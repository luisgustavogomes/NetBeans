/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.controller;

import br.edu.qi.model.Proprietario;
import br.edu.qi.model.ProprietarioBO;
import br.edu.qi.util.HelperAlert;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author lg
 */
public class ProprietarioEditController implements Initializable {

    private ObservableList<Proprietario> dados;
    private ProprietarioBO proprietarioBO = new ProprietarioBO();

    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtEndereco;
    @FXML
    private TextField txtNro;
    @FXML
    private TextField txtBairro;
    @FXML
    private TextField txtCidade;
    @FXML
    private ComboBox<String> cbEstado;
    @FXML
    private ComboBox<String> cbPais;
    @FXML
    private TextField txtTelefone;
    @FXML
    private TextField txtEmail;
    @FXML
    private Button btnSalvar;
    @FXML
    private Button btnRemover;
    @FXML
    private TableColumn idCol;
    @FXML
    private TableColumn nomeCol;
    @FXML
    private TableColumn telefoneCol;
    @FXML
    private TableColumn emailCol;
    @FXML
    private TableView<Proprietario> tvConsulta;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dados = FXCollections.observableArrayList();
        idCol.setCellValueFactory(new PropertyValueFactory("idProprietario"));
        nomeCol.setCellValueFactory(new PropertyValueFactory("nome"));
        telefoneCol.setCellValueFactory(new PropertyValueFactory("telefone"));
        emailCol.setCellValueFactory(new PropertyValueFactory("email"));
        cbEstado.getItems().addAll("[Selecione...]", "Acre", "Alagoas", "Amapá", "Bahia", "Amazonas", "Ceará", "Distrito Federal", "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins");
        cbPais.getItems().addAll("[Selecione...]", "Brasil");
        tvConsulta.setItems(dados);
        List<Proprietario> proprietario = carregaProprietario();
        dados.addAll(proprietario);
    }

    private List<Proprietario> carregaProprietario() {
        List<Proprietario> proprietario = null;
        try {
            proprietario = proprietarioBO.findAllWithoutClose();
        } catch (Exception ex) {
            HelperAlert.msgDialog(ex.getMessage(), getClass().getName(), Alert.AlertType.ERROR);
        }
        return proprietario;
    }

    @FXML
    private void HandlerSalvar(ActionEvent event) {
        try {
            validation();
            Proprietario p = new Proprietario(
                    txtNome.getText(),
                    txtEndereco.getText(),
                    txtNro.getText(),
                    txtBairro.getText(),
                    txtCidade.getText(),
                    cbPais.getSelectionModel().getSelectedItem(),
                    txtTelefone.getText().isEmpty() ? "0" : txtTelefone.getText(),
                    txtEmail.getText().isEmpty() ? "0" : txtEmail.getText(),
                    cbEstado.getSelectionModel().getSelectedItem());
            proprietarioBO.save(p);
            p.setIdProprietario(proprietarioBO.findAll().stream().filter(pb -> pb.equals(p)).findFirst().get().getIdProprietario());
            dados.add(p);
            HelperAlert.msgDialog("Cliente salvo com sucesso!", "Cliente", Alert.AlertType.INFORMATION);
            clear();
        } catch (Exception ex) {
            HelperAlert.msgDialog(ex.getMessage(), "Cliente", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void HandlerRemover(ActionEvent event) {
        try {
            Proprietario p = tvConsulta.getSelectionModel().getSelectedItem();
            proprietarioBO.delete(p);
            dados.remove(p);
            HelperAlert.msgDialog("Cliente removido!", "Cliente", Alert.AlertType.INFORMATION);
            clear();
        } catch (Exception ex) {
            HelperAlert.msgDialog(ex.getMessage(), "Cliente", Alert.AlertType.ERROR);
        }
    }

    private void validation() throws Exception {
        if (txtNome.getText().isEmpty()) {
            throw new Exception("Informe um nome!");
        }
        if (txtEndereco.getText().isEmpty()) {
            throw new Exception("Informe um endereço!");
        }
        if (txtNro.getText().isEmpty()) {
            throw new Exception("Informe um número!");
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
            throw new Exception("Selecione um estado!");
        }
    }

    private void clear() {
        txtNome.setText("");
        txtEndereco.setText("");
        txtNro.setText("");
        txtBairro.setText("");
        txtCidade.setText("");
        cbEstado.getSelectionModel().select(0);
        cbPais.getSelectionModel().select(0);
        txtTelefone.setText("");
        txtEmail.setText("");
    }

}
