/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi;

import br.edu.qi.controller.FuncEditController;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Luis Gustavo
 */
public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("view/FuncEdit.fxml"));
        AnchorPane root = (AnchorPane) loader.load();
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Edição de Funcionário");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        Scene scene = new Scene(root);
        dialogStage.setScene(scene);
        FuncEditController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        dialogStage.showAndWait();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
