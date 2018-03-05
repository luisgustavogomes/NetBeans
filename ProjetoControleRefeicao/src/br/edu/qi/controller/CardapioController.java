/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.controller;

import br.edu.qi.MainApp;
import br.edu.qi.entity.Instituicao;
import br.edu.qi.entity.Menu;
import br.edu.qi.entity.Refeicao;
import br.edu.qi.service.CardapioService;
import br.edu.qi.service.IService;
import br.edu.qi.service.InstituicaoService;
import br.edu.qi.service.RefeicaoService;
import br.edu.qi.utl.HelperDate;
import br.edu.qi.utl.HelperNotification;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import tray.notification.NotificationType;

/**
 * FXML Controller class
 *
 * @author lg
 */
public class CardapioController implements Initializable {

    private ObservableList<Menu> dados;
    private IService cardapioService;
    private IService instituicaoService;
    private IService refeicaoService;
    public static Menu menuEmail;

    @FXML
    private TextField txtID;
    @FXML
    private TableColumn dataCol;
    @FXML
    private TableColumn instituicaoCol;
    @FXML
    private TableColumn refeicaoCol;
    @FXML
    private DatePicker dpData;
    @FXML
    private ComboBox<Instituicao> cbInstituicao;
    @FXML
    private ComboBox<Refeicao> cbRefeicao;
    @FXML
    private TextArea txtDescricao;
    @FXML
    private TableView<Menu> tvConsulta;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.dados = FXCollections.observableArrayList();
        cardapioService = new CardapioService();
        refeicaoService = new RefeicaoService();
        instituicaoService = new InstituicaoService();
        dataCol.setCellValueFactory(new PropertyValueFactory<>("dataCarpadio"));
        instituicaoCol.setCellValueFactory(new PropertyValueFactory<>("instituicao"));
        refeicaoCol.setCellValueFactory(new PropertyValueFactory<>("refeicao"));
        atualizaTabela();
        carregaComboInstituicao();
        carregaComboRefeicao();
        tvConsulta.setItems(dados);
    }

    @FXML
    private void hendlerSalvar(ActionEvent event) {
        try {
            if (txtID.getText().isEmpty()) {
                validation();
                Menu m = new Menu(cbInstituicao.getSelectionModel().getSelectedItem(),
                        cbRefeicao.getSelectionModel().getSelectedItem(),
                        Date.valueOf(dpData.getValue()),
                        txtDescricao.getText());
                cardapioService.save(m);
                dados.add(m);
                clear();
                HelperNotification.Notification("Cardapio", "Cardapio salvo com sucesso!", NotificationType.SUCCESS);
            } else {
                Menu m = tvConsulta.getSelectionModel().getSelectedItem();
                Menu mm = new Menu(Integer.parseInt(txtID.getText()),
                        cbInstituicao.getSelectionModel().getSelectedItem(),
                        cbRefeicao.getSelectionModel().getSelectedItem(),
                        Date.valueOf(dpData.getValue()),
                        txtDescricao.getText());
                boolean status = (m.equals(mm));
                if (!status) {
                    cardapioService.update(mm);
                    dados.clear();
                    atualizaTabela();
                    HelperNotification.Notification("Cardapio", "Alterações realizadas com sucesso!", NotificationType.SUCCESS);
                } else {
                    HelperNotification.Notification("Cardapio", "Não há alterações!", NotificationType.INFORMATION);
                }
                clear();
            }
        } catch (Exception e) {
            HelperNotification.Notification("Cardapio", e.getMessage(), NotificationType.ERROR);
        }
    }

    @FXML
    private void handlerEditar(ActionEvent event) {
        Menu m = tvConsulta.getSelectionModel().getSelectedItem();
        if (m != null) {
            txtID.setText(String.valueOf(m.getIdMenu()));
            dpData.setValue(HelperDate.toLocalDate(m.getDataCarpadio()));
            cbInstituicao.getSelectionModel().select(m.getInstituicao());
            cbRefeicao.getSelectionModel().select(m.getRefeicao());
            txtDescricao.setText(m.getDescricao());
        }
    }

    @FXML
    private void handlerRemover(ActionEvent event) {
        try {
            Menu m = tvConsulta.getSelectionModel().getSelectedItem();
            if (m != null) {
                cardapioService.delete(m);
                dados.remove(m);
                HelperNotification.Notification("Cardapio", "Selecione o item para remoção!", NotificationType.SUCCESS);
                clear();
                return;
            }
            HelperNotification.Notification("Cardapio", "Selecione o item para remoção!", NotificationType.ERROR);
        } catch (Exception e) {
            HelperNotification.Notification("Cardapio", e.getMessage(), NotificationType.ERROR);
        }
    }

    @FXML
    private void handlerCancelar(ActionEvent event) {
        clear();
    }

    @FXML
    private void handlerEnviarEmail(ActionEvent event) {
        try {
            Menu m = tvConsulta.getSelectionModel().getSelectedItem();
            if (m != null) {
                menuEmail = m;
                abrir("/br/edu/qi/view/Email.fxml", "E-mail");
                return;
            }
            HelperNotification.Notification("Cardapio", "Selecione o item para envio de e-mail!", NotificationType.ERROR);
        } catch (Exception e) {
            HelperNotification.Notification("Cardapio", e.getMessage(), NotificationType.ERROR);
        }
    }

    private void abrir(String path, String title) throws Exception {
        Parent root1 = FXMLLoader.load(getClass().getResource(path));
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.setResizable(true);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.getIcons().add(MainApp.icon);
        stage.setTitle(title);
        stage.show();
    }

    private void atualizaTabela() {
        tvConsulta.getItems().clear();
        List<Menu> arr = null;
        try {
            arr = cardapioService.findAllWithoutClose();
        } catch (Exception e) {
            HelperNotification.Notification("Pessoa", e.getMessage(), NotificationType.ERROR);
        }
        dados.addAll(arr);
    }

    private void carregaComboRefeicao() {
        try {
            cbRefeicao.getItems().addAll(refeicaoService.findAllWithoutClose());
        } catch (Exception ex) {
            HelperNotification.Notification("Cardapio", ex.getMessage(), NotificationType.ERROR);
        }
    }

    private void carregaComboInstituicao() {
        try {
            cbInstituicao.getItems().addAll(instituicaoService.findAllWithoutClose());
        } catch (Exception ex) {
            HelperNotification.Notification("Cardapio", ex.getMessage(), NotificationType.ERROR);
        }
    }

    private void clear() {
        cbInstituicao.getSelectionModel().select(null);
        cbRefeicao.getSelectionModel().select(null);
        dpData.setValue(null);
        txtDescricao.setText("");
        txtID.setText("");
    }

    private void validation() throws Exception {
        if (dpData.getValue() == null) {
            throw new Exception("Informe uma data");
        }
        if (txtDescricao.getText().isEmpty()) {
            throw new Exception("Informe uma descrição");
        }
        if (cbInstituicao.getSelectionModel().getSelectedItem() == null) {
            throw new Exception("Selecione a instituição!");
        }
        if (cbRefeicao.getSelectionModel().getSelectedItem() == null) {
            throw new Exception("Selecione a refeição!");
        }
    }

}
