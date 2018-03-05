/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.controller;

import br.edu.qi.entity.Instituicao;
import br.edu.qi.entity.Pessoa;
import br.edu.qi.service.IService;
import br.edu.qi.service.InstituicaoService;
import br.edu.qi.service.PessoaService;
import br.edu.qi.utl.Helper;
import br.edu.qi.utl.HelperNotification;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import tray.notification.NotificationType;

/**
 * FXML Controller class
 *
 * @author lg
 */
public class PessoaController implements Initializable {

    private ObservableList<Pessoa> dados;
    private IService instituicaoService;
    private IService pessoaService;

    @FXML
    private TextField txtID;
    @FXML
    private TableView<Pessoa> tvConsulta;
    @FXML
    private TableColumn nomeCol;
    @FXML
    private TableColumn instituicaoCol;
    @FXML
    private TableColumn emailCol;
    @FXML
    private TableColumn telefoneCol;
    @FXML
    private ComboBox<Instituicao> cbInstituicao;
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtTelefone;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.dados = FXCollections.observableArrayList();
        instituicaoService = new InstituicaoService();
        pessoaService = new PessoaService();
        nomeCol.setCellValueFactory(new PropertyValueFactory<>("nome"));
        instituicaoCol.setCellValueFactory(new PropertyValueFactory<>("instituicao"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        telefoneCol.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        atualizaTabela();
        carregaComboInstituicao();
        tvConsulta.setItems(dados);
    }

    private void carregaComboInstituicao() {
        try {
            cbInstituicao.getItems().addAll(instituicaoService.findAllWithoutClose());
        } catch (Exception ex) {
            HelperNotification.Notification("Pessoa", ex.getMessage(), NotificationType.ERROR);
        }
    }

    private void atualizaTabela() {
        tvConsulta.getItems().clear();
        List<Pessoa> arr = null;
        try {
            arr = pessoaService.findAllWithoutClose();
        } catch (Exception ex) {
            HelperNotification.Notification("Pessoa", ex.getMessage(), NotificationType.ERROR);
        }
        dados.addAll(arr);
    }

    @FXML
    private void hendlerSalvar(ActionEvent event) {
        try {
            if (txtID.getText().isEmpty()) {
                validation();
                Pessoa pessoa = new Pessoa(cbInstituicao.getSelectionModel().getSelectedItem(),
                        txtNome.getText(),
                        txtEmail.getText(),
                        txtTelefone.getText());
                pessoaService.save(pessoa);
                dados.add(pessoa);
                clear();
                HelperNotification.Notification("Pessoa", "Pessoa salva com sucesso", NotificationType.SUCCESS);
            } else {
                Pessoa p = tvConsulta.getSelectionModel().getSelectedItem();
                Pessoa pp = new Pessoa(
                        Integer.parseInt(txtID.getText()),
                        cbInstituicao.getSelectionModel().getSelectedItem(),
                        txtNome.getText(),
                        txtEmail.getText(),
                        txtTelefone.getText());
                boolean status = (p.equals(pp));
                if (!status) {
                    pessoaService.update(pp);
                    dados.clear();
                    atualizaTabela();
                    HelperNotification.Notification("Pessoa", "Alterações realizadas com sucesso!", NotificationType.SUCCESS);
                } else {
                    HelperNotification.Notification("Pessoa", "Não há alterações!", NotificationType.INFORMATION);
                }
                clear();
            }
        } catch (Exception e) {
            HelperNotification.Notification("Pessoa", e.getMessage(), NotificationType.ERROR);
        }
    }

    @FXML
    private void handlerRemover(ActionEvent event) {
        try {
            Pessoa p = tvConsulta.getSelectionModel().getSelectedItem();
            if (p != null) {
                pessoaService.delete(p);
                dados.remove(p);
                HelperNotification.Notification("Pessoa", "Pessoa removida com sucesso!", NotificationType.SUCCESS);
                clear();
                return;
            }
            HelperNotification.Notification("Pessoa", "Selecione o item para remoção!", NotificationType.ERROR);
        } catch (Exception e) {
            HelperNotification.Notification("Pessoa", e.getMessage(), NotificationType.ERROR);
        }
    }

    @FXML
    private void handlerCancelar(ActionEvent event) {
        clear();
    }

    @FXML
    private void handlerEditar(ActionEvent event) {
        Pessoa p = tvConsulta.getSelectionModel().getSelectedItem();
        if (p != null) {
            txtID.setText(String.valueOf(p.getIdPessoa()));
            cbInstituicao.getSelectionModel().select(p.getInstituicao());
            txtNome.setText(p.getNome());
            txtEmail.setText(p.getEmail());
            txtTelefone.setText(p.getTelefone());
        }
    }

    private void clear() {
        cbInstituicao.getSelectionModel().select(null);
        txtID.setText("");
        txtNome.setText("");
        txtEmail.setText("");
        txtTelefone.setText("");
    }

    private void validation() throws Exception {
        if (cbInstituicao.getSelectionModel().isEmpty()) {
            throw new Exception("Selecione uma instituição!");
        }
        if (txtNome.getText().isEmpty()) {
            throw new Exception("Informe um nome!");
        }
        if (txtEmail.getText().isEmpty()) {
            throw new Exception("Informe um email!");
        }
        if (!Helper.isEmail(txtEmail.getText())) {
            throw new Exception("Informe um email valido!");
        }
        if (txtTelefone.getText().isEmpty()) {
            throw new Exception("Informe um número de telefone!");
        }
    }

}
