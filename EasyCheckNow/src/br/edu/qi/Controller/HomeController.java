/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.Controller;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author lg
 */
public class HomeController implements Initializable {

    private Stage stage;

    /**
     * Initializes the controller class.
     */
    public void setStage(Stage stage) {
        this.stage = stage;
        //stage.getIcons().add(new Image("/br/edu/qi/img/icon.png"));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        KeyFrame frame = new KeyFrame(Duration.millis(1000), e -> atualizaHoras());
        Timeline timeline = new Timeline(frame);
        timeline.setCycleCount(timeline.INDEFINITE);
        timeline.play();
    }

    private void atualizaHoras() {
        SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
        Date agora = new Date();
        //lblHorario.setText(s.format(agora));
    }

//    private void abrir(String url, String title) {
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource(url));
//            Parent content = loader.load();
//            Tab tab = new Tab(title);
//            tab.setContent(content);
//            //tabPane.getTabs().add(tab);
//            //tabPane.getSelectionModel().select(tab);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

//    @FXML
//    private void handlerInstituicao(ActionEvent event) {
//        abrir("/br/edu/qi/view/Instituicao.fxml", "Instituição");
//    }
}
