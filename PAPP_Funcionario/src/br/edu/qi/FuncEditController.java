/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Luis Gustavo
 */
public class FuncEditController implements Initializable {
    
    @FXML
    private TextField txtNome;
    
    private Stage dialogStage;
    @FXML
    private Button btnGravar;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        btnGravar.setOnAction(this::handBtnGravar);
    }    
    @FXML
    private void handBtnGravar(ActionEvent event) {
        msgDialog("Nome : " + txtNome.getText());
    }
    
    private void msgDialog(String msg){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sistema RM");
        alert.setHeaderText("Informação");
        alert.setContentText(msg);
        alert.show();
    }
    
    public void setDialogStage(Stage dialog){
        this.dialogStage = dialog;
    }
}
