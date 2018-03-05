/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author lg
 */
public class CadFuncViewController implements Initializable {

    @FXML
    private TextField txNroMatricula;
    @FXML
    private TextField txNome;
    @FXML
    private TableView<FuncionarioModel> tbl;
    @FXML
    private TableColumn matriculaCol;
    @FXML
    private TableColumn nomeCol;
    @FXML
    private Button btAdicionar;

    private ObservableList<FuncionarioModel> dados;

    private Stage dialogStage;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        matriculaCol.setCellValueFactory(new PropertyValueFactory<FuncionarioModel, Integer>("nroMatricula"));
        nomeCol.setCellValueFactory(new PropertyValueFactory<FuncionarioModel, String>("nome"));
        dados = FXCollections.observableArrayList();
        tbl.setItems(dados);
    }

    @FXML
    private void handBtAdd(ActionEvent event) {
        FuncionarioModel dadosFunc = new FuncionarioModel();
        dadosFunc.setNroMatricula(Integer.parseInt(txNroMatricula.getText()));
        dadosFunc.setNome(txNome.getText());
        dados.add(dadosFunc);
    }

    private void msgDialog(String msg, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle("Sistema");
        alert.setContentText(msg);
        alert.show();
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

}
