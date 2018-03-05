
package br.edu.qi;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Main extends Application {
    
    private static Stage stage;
    private static Scene EditView;

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = new Stage();
        FXMLLoader fmlxEditView = new FXMLLoader(Main.class.getResource("view/EditView.fxml"));
        AnchorPane rootFmlxEditView = (AnchorPane) fmlxEditView.load();
        EditView = new Scene(rootFmlxEditView);
        stage.setScene(EditView);
        stage.show();
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
