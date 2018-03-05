/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi;

import br.edu.qi.controller.HomeEditController;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author lg
 */
public class MainApp extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public static Image icon = new Image("/br/edu/qi/image/iconCar.png");

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setOnCloseRequest(new javafx.event.EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.exit(0);
            }
        });
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/HomeEdit.fxml"));
        Parent root1 = (Parent) loader.load();
        HomeEditController home = loader.<HomeEditController>getController();
        home.setStage(primaryStage);
        Scene scene = new Scene(root1);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Revenda");
        primaryStage.show();

    }

}
