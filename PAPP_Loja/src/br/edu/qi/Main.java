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
public class Main extends Application {

    private static Stage stage;
    private static Scene locEditView;
    private static Scene consultaView;

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = new Stage();

        FXMLLoader fmlxLocEditView = new FXMLLoader(Main.class.getResource("view/LocEditView.fxml"));
        FXMLLoader fmlxConsultaView = new FXMLLoader(Main.class.getResource("view/ConsultaView.fxml"));

        AnchorPane rootFmlxLocEditView = (AnchorPane) fmlxLocEditView.load();
        locEditView = new Scene(rootFmlxLocEditView);

        AnchorPane rootFmlxConsultaView = (AnchorPane) fmlxConsultaView.load();
        consultaView = new Scene(rootFmlxConsultaView);

        stage.setScene(locEditView);
        stage.showAndWait();
        
    }

    public static void changeScreen(String tela) throws Exception {
        switch (tela) {
            case "LocEditView":
                stage.setScene(locEditView);
                break;
            case "ConsultaView":
                stage.setScene(consultaView);
                break;
            default:
                throw new Exception("Erro!");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
