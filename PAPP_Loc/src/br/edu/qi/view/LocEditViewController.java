/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author lg
 */
public class LocEditViewController implements Initializable {

    private Stage dialogStage;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setDialogStage(Stage dialog) {
        this.dialogStage = dialog;
    }
    
    public void msgDialog(String msg, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle("Locadora");
        alert.setContentText(msg);
        alert.show();
    }
}
