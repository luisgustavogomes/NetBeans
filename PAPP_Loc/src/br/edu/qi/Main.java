/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi;

import br.edu.qi.view.LocEditViewController;
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
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/LocEditView.fxml"));
        AnchorPane root = (AnchorPane) loader.load();

        Stage dialogStage = new Stage();
        Scene scene = new Scene(root);

        dialogStage.setScene(scene);
        LocEditViewController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        dialogStage.setTitle("Locadora");
        dialogStage.showAndWait();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
