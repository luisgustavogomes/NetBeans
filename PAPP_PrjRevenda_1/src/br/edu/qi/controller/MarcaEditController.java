/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.controller;

import br.edu.qi.model.Marca;
import br.edu.qi.model.MarcaBO;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author lg
 */
public class MarcaEditController implements Initializable {

    private ObservableList<Marca> dados;
    private MarcaBO marcaBo = new MarcaBO();

    @FXML
    private Label lblDescricao;
    @FXML
    private TextField txtDescricao;
    @FXML
    private Button btnSalvar;
    @FXML
    private Button btnRemover;
    @FXML
    private TableView<Marca> tvConsulta;
    @FXML
    private TableColumn idCol;
    @FXML
    private TableColumn descricaoCol;
    @FXML
    private Button btnEditar;
    @FXML
    private Button btnCancelar;
    @FXML
    private TextField txtID;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dados = FXCollections.observableArrayList();
        idCol.setCellValueFactory(new PropertyValueFactory<>("idMarca"));
        descricaoCol.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        tvConsulta.setItems(dados);
        dados.addAll(carregaMarca());
    }

    private List<Marca> carregaMarca() {
        List<Marca> marcaModels = null;
        try {
            marcaModels = marcaBo.findAllWithoutClose();
        } catch (Exception ex) {
            HelperAlert.msgDialog(ex.getMessage(), getClass().getName(), Alert.AlertType.ERROR);
        }
        return marcaModels;
    }

    @FXML
    private void HandlerSalvar(ActionEvent event) {
        try {
            if (txtID.getText().isEmpty()) {
                validation();
                Marca m = new Marca(txtDescricao.getText());
                marcaBo.save(m);
                marcaBo.findAll().stream().filter((marcas) -> (marcas.equals(m))).forEachOrdered((marcas) -> {
                    m.setIdMarca(marcas.getIdMarca());
                });
                dados.add(m);
                HelperAlert.msgDialog("Marca salva com sucesso!", "Marca", Alert.AlertType.INFORMATION);
                clear();
            } else {
                Marca m = tvConsulta.getSelectionModel().getSelectedItem();
                if (m.getDescricao().equalsIgnoreCase(txtDescricao.getText())) {
                    HelperAlert.msgDialog("Não há aterações", "Marca", Alert.AlertType.INFORMATION);
                } else {
                    dados.clear();
                    m.setDescricao(txtDescricao.getText());
                    marcaBo.update(m);
                    dados.addAll(carregaMarca());
                    HelperAlert.msgDialog("Alterações salvas com sucesso!", "Marca", Alert.AlertType.INFORMATION);
                    clear();
                }
            }
        } catch (Exception e) {
            HelperAlert.msgDialog(e.getMessage(), "Marca", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void HandlerRemover(ActionEvent event) {
        try {
            Marca m = tvConsulta.getSelectionModel().getSelectedItem();
            marcaBo.delete(m);
            dados.remove(m);
            HelperAlert.msgDialog("Marca removida com sucesso!", "Marca", Alert.AlertType.INFORMATION);
            clear();
        } catch (Exception ex) {
            HelperAlert.msgDialog(ex.getMessage(), "Marca", Alert.AlertType.ERROR);
        }

    }

    @FXML
    private void HandlerEditar(ActionEvent event) {
        try {
            Marca m = tvConsulta.getSelectionModel().getSelectedItem();
            txtDescricao.setText(m.getDescricao());
            txtID.setText(m.getIdMarca().toString());
        } catch (Exception ex) {
            HelperAlert.msgDialog(ex.getMessage(), "Marca", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void HandlerCancelar(ActionEvent event) {
        clear();
    }

    private void validation() throws Exception {
        if (txtDescricao.getText().isEmpty()) {
            throw new Exception("Informe uma descrição!");
        }
    }

    private void clear() {
        txtID.setText(null);
        txtDescricao.setText(null);
    }

}
