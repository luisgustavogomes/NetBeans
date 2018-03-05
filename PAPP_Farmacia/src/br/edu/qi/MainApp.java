/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi;

import br.edu.qi.controller.ProdEditController;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Luis Gustavo
 */
public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {

        Pane root = FXMLLoader.load(getClass().getResource("view/ProdEdit.fxml"));

        Stage dialogStage = new Stage();
        dialogStage.setTitle("Farmácia");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        Scene scene = new Scene(root);
        dialogStage.setScene(scene);

        ProdEditController controller;

        dialogStage.setTitle("Farmácia");
        dialogStage.showAndWait();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    

}
