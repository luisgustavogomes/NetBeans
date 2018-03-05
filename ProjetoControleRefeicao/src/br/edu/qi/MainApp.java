/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi;

import br.edu.qi.controller.HomeController;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author lg
 */
public class MainApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public static Image icon = new Image("/br/edu/qi/image/icon.png");

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setOnCloseRequest(new javafx.event.EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.exit(0);
            }
        });
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/Home.fxml"));
        Parent root1 = (Parent) loader.load();
        HomeController home = loader.<HomeController>getController();
        home.setStage(primaryStage);
        Scene scene = new Scene(root1);
        primaryStage.centerOnScreen();
        primaryStage.setHeight(Screen.getPrimary().getVisualBounds().getHeight());
        primaryStage.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Controle");
        primaryStage.show();
    }
}
