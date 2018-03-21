/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi;

import br.edu.qi.Controller.HomeController;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author lg
 */
public class app extends Application {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    //public static Image icon = new Image("/br/edu/qi/image/icon.png");
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setOnCloseRequest((WindowEvent event) -> {
            System.exit(0);
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
        primaryStage.setTitle(" E D I T A R ");
        primaryStage.show();
    }

    
}
