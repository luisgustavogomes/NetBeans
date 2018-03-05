/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Luis Gustavo
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane root = FXMLLoader.load(getClass().getResource("view/Layout.fxml"));
        Stage dialogStage = new Stage();
        Scene scene = new Scene(root);
        dialogStage.setTitle("BlueKeeper");
        dialogStage.setMinHeight(400);
        dialogStage.setMinWidth(800);
        dialogStage.setScene(scene);
        dialogStage.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
