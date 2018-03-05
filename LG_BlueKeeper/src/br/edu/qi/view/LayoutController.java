/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Luis Gustavo
 */
public class LayoutController implements Initializable {

    @FXML
    private TextField txtSearch;
    @FXML
    private Button btnSearch;
    @FXML
    private Button btnClearSearch;
    @FXML
    private TableView<?> table;
    @FXML
    private Button btnNovo;
    @FXML
    private Button btnEditar;
    @FXML
    private Button btnExcluir;
    @FXML
    private TextField txtServico;
    @FXML
    private TextField txtLogin;
    @FXML
    private TextField txtSenha;
    @FXML
    private TextArea txtObservacoes;
    @FXML
    private Button btnConfirm;
    @FXML
    private Button btnCancel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void exit(ActionEvent event) {
    }

    @FXML
    private void search(ActionEvent event) {
    }

    @FXML
    private void clearSearch(ActionEvent event) {
    }

    @FXML
    private void onNew(ActionEvent event) {
    }

    @FXML
    private void onEdit(ActionEvent event) {
    }

    @FXML
    private void onDelete(ActionEvent event) {
    }

    @FXML
    private void onConfirm(ActionEvent event) {
    }

    @FXML
    private void onCancel(ActionEvent event) {
    }
    
}
