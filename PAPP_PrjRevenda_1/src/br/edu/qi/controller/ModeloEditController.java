/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.controller;

import br.edu.qi.model.Modelo;
import br.edu.qi.model.ModeloBO;
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
public class ModeloEditController implements Initializable {

    private ObservableList<Modelo> dados;
    private ModeloBO modeloBo = new ModeloBO();

    @FXML
    private Label lblDescricao;
    @FXML
    private TextField txtDescricao;
    @FXML
    private Button btnSalvar;
    @FXML
    private Button btnRemover;
    @FXML
    private TableView<Modelo> tvConsulta;
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
        idCol.setCellValueFactory(new PropertyValueFactory<>("idModelo"));
        descricaoCol.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        tvConsulta.setItems(dados);
        dados.addAll(carregaModelo());

    }

    private List<Modelo> carregaModelo() {
        List<Modelo> modelo = null;
        try {
            modelo = modeloBo.findAllWithoutClose();
        } catch (Exception ex) {
            HelperAlert.msgDialog(ex.getMessage(), getClass().getName(), Alert.AlertType.ERROR);
        }
        return modelo;
    }

    @FXML
    private void HandlerSalvar(ActionEvent event) {
        try {
            if (txtID.getText().isEmpty()) {
                validation();
                Modelo m = new Modelo(txtDescricao.getText());
                modeloBo.save(m);
                modeloBo.findAll().stream().filter((models) -> (models.equals(m))).forEachOrdered((models) -> {
                    m.setIdModelo(models.getIdModelo());
                });
                dados.add(m);
                HelperAlert.msgDialog("Modelo salvo com sucesso!", "Modelo", Alert.AlertType.INFORMATION);
                clear();
            } else {
                dados.clear();
                Modelo m = tvConsulta.getSelectionModel().getSelectedItem();
                if (m.getDescricao().equalsIgnoreCase(txtDescricao.getText())) {
                    HelperAlert.msgDialog("Não há alterações", "Modelo", Alert.AlertType.INFORMATION);
                } else {
                    dados.clear();
                    m.setDescricao(txtDescricao.getText());
                    modeloBo.update(m);
                    dados.addAll(carregaModelo());
                    HelperAlert.msgDialog("Alterações salvas com sucesso!", "Modelo", Alert.AlertType.INFORMATION);
                    clear();
                }
            }
        } catch (Exception ex) {
            HelperAlert.msgDialog(ex.getMessage(), "Modelo", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void HandlerRemover(ActionEvent event) {
        try {
            Modelo m = tvConsulta.getSelectionModel().getSelectedItem();
            modeloBo.delete(m);
            dados.remove(m);
            HelperAlert.msgDialog("Modelo removido com sucesso!", "Modelo", Alert.AlertType.INFORMATION);
            clear();
        } catch (Exception ex) {
            HelperAlert.msgDialog(ex.getMessage(), "Modelo", Alert.AlertType.ERROR);
        }
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

    @FXML
    private void HandlerEditar(ActionEvent event) {
        try {
            Modelo m = tvConsulta.getSelectionModel().getSelectedItem();
            txtDescricao.setText(m.getDescricao());
            txtID.setText(m.getIdModelo().toString());
        } catch (Exception ex) {
            HelperAlert.msgDialog(ex.getMessage(), "Modelo", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void HandlerCancelar(ActionEvent event) {
        clear();
    }

}
