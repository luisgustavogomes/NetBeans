/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author lg
 */
public class main extends Application {
    
    private static Stage stage;
    private static Scene cadEditView;

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = new Stage();

        FXMLLoader fmlxLocEditView = new FXMLLoader(main.class.getResource("view/CadEditPessoaView.fxml"));
        AnchorPane rootFmlxLocEditView = (AnchorPane) fmlxLocEditView.load();
        cadEditView = new Scene(rootFmlxLocEditView);

        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setTitle("Cadastro");

        stage.setScene(cadEditView);
        stage.show();
    }

    public static void changeScreen(String scene) throws IOException {
        switch (scene) {
            case "locEditView":
                stage.setScene(cadEditView);
                break;
          
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
