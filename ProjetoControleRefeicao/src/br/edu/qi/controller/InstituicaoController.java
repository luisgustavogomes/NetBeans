/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.controller;

import br.edu.qi.entity.Instituicao;
import br.edu.qi.service.IService;
import br.edu.qi.service.InstituicaoService;
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
public class InstituicaoController implements Initializable {

    private ObservableList<Instituicao> dados;
    private IService instituicaoService;

    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtEndereco;
    @FXML
    private TextField txtNumero;
    @FXML
    private TextField txtTelefone;
    @FXML
    private TextField txtBairro;
    @FXML
    private TextField txtCidade;
    @FXML
    private ComboBox<String> cbEstado;
    @FXML
    private ComboBox<String> cbPais;
    @FXML
    private TextField txtID;
    @FXML
    private TableView<Instituicao> tvConsulta;
    @FXML
    private TableColumn nomeCol;
    @FXML
    private TableColumn emailCol;
    @FXML
    private TableColumn telefoneCol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.dados = FXCollections.observableArrayList();
        instituicaoService = new InstituicaoService();
        nomeCol.setCellValueFactory(new PropertyValueFactory<>("nome"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        telefoneCol.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        cbEstado.getItems().addAll("[...]", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA",
                "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO");
        cbPais.getItems().addAll("[...]", "BR");
        cbEstado.getSelectionModel().select(0);
        cbPais.getSelectionModel().select(0);
        carregarInstituicao();
        tvConsulta.setItems(dados);
    }

    @FXML
    private void hendlerSalvar(ActionEvent event) {
        try {
            if (txtID.getText().isEmpty()) {
                validation();
                Instituicao instituicao = new Instituicao(
                        txtNome.getText(),
                        txtEndereco.getText(),
                        txtNumero.getText(),
                        txtBairro.getText(),
                        txtCidade.getText(),
                        cbEstado.getSelectionModel().getSelectedItem(),
                        cbPais.getSelectionModel().getSelectedItem(),
                        txtTelefone.getText(),
                        txtEmail.getText());
                instituicaoService.save(instituicao);
                dados.add(instituicao);
                clear();
                HelperNotification.Notification("Instituição", "Instituição salva com sucesso!", NotificationType.SUCCESS);
            } else {
                Instituicao i = tvConsulta.getSelectionModel().getSelectedItem();
                Instituicao ii = new Instituicao(
                        Integer.parseInt(txtID.getText()),
                        txtNome.getText(),
                        txtEndereco.getText(),
                        txtNumero.getText(),
                        txtBairro.getText(),
                        txtCidade.getText(),
                        cbEstado.getSelectionModel().getSelectedItem(),
                        cbPais.getSelectionModel().getSelectedItem(),
                        txtTelefone.getText(),
                        txtEmail.getText());
                boolean status = (i.equals(ii));
                if (!status) {
                    instituicaoService.update(ii);
                    dados.clear();
                    carregarInstituicao();
                    HelperNotification.Notification("Instituição", "Alterações realizadas com sucesso!", NotificationType.SUCCESS);
                } else {
                    HelperNotification.Notification("Instituição", "Não há alterações!", NotificationType.INFORMATION);
                }
                clear();
            }
        } catch (Exception e) {
            HelperNotification.Notification("Instituição", e.getMessage(), NotificationType.ERROR);
        }
    }

    @FXML
    private void handlerRemover(ActionEvent event) {
        try {
            Instituicao i = tvConsulta.getSelectionModel().getSelectedItem();
            if (i != null) {
                instituicaoService.delete(i);
                dados.remove(i);
                HelperNotification.Notification("Instituição", "Instituição foi removida com sucesso!", NotificationType.SUCCESS);
                clear();
                return;
            }
            HelperNotification.Notification("Instituição", "Selecione o item para remoção!", NotificationType.ERROR);
        } catch (Exception e) {
            HelperNotification.Notification("Instituição", e.getMessage(), NotificationType.ERROR);
        }

    }

    @FXML
    private void handlerCancelar(ActionEvent event) {
        clear();
    }

    private void clear() {
        txtID.setText("");
        txtNome.setText("");
        txtEmail.setText("");
        txtEndereco.setText("");
        txtNumero.setText("");
        txtTelefone.setText("");
        txtBairro.setText("");
        txtCidade.setText("");
        cbEstado.getSelectionModel().select(0);
        cbPais.getSelectionModel().select(0);
    }

    @FXML
    private void handlerEditar(ActionEvent event) {
        Instituicao i = tvConsulta.getSelectionModel().getSelectedItem();
        if (i != null) {
            txtID.setText(String.valueOf(i.getIdInstituicao()));
            txtNome.setText(i.getNome());
            txtEmail.setText(i.getEmail());
            txtEndereco.setText(i.getEndereco());
            txtNumero.setText(i.getNumero());
            txtTelefone.setText(i.getTelefone());
            txtBairro.setText(i.getBairro());
            txtCidade.setText(i.getCidade());
            cbEstado.getSelectionModel().select(i.getEstado());
            cbPais.getSelectionModel().select(i.getPais());
        }
    }

    private void carregarInstituicao() {
        tvConsulta.getItems().clear();
        List<Instituicao> arr = null;
        try {
            arr = instituicaoService.findAllWithoutClose();
        } catch (Exception ex) {
            HelperNotification.Notification("Instituição", ex.getMessage(), NotificationType.ERROR);
        }
        dados.addAll(arr);
    }

    private void validation() throws Exception {
        if (txtNome.getText().isEmpty()) {
            throw new Exception("Informe um nome!");
        }
        if (txtEmail.getText().isEmpty()) {
            throw new Exception("Informe um email!");
        }
        if (!Helper.isEmail(txtEmail.getText())) {
            throw new Exception("Informe um email Valido!");
        }
        if (txtEndereco.getText().isEmpty()) {
            throw new Exception("Informe um endereço!");
        }
        if (txtNumero.getText().isEmpty()) {
            throw new Exception("Informe um número!");
        }
        if (txtTelefone.getText().isEmpty()) {
            throw new Exception("Informe um número de telefone!");
        }
        if (txtBairro.getText().isEmpty()) {
            throw new Exception("Informe um bairro!");
        }
        if (txtCidade.getText().isEmpty()) {
            throw new Exception("Informe uma cidade!");
        }
        if (cbEstado.getSelectionModel().getSelectedIndex() == 0) {
            throw new Exception("Selecione um estado!");
        }
        if (cbPais.getSelectionModel().getSelectedIndex() == 0) {
            throw new Exception("Selecione um país!");
        }
    }

}
