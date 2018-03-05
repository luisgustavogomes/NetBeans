/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.controller;

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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author lg
 */
public class HomeController implements Initializable {

    @FXML
    private Button btnInstituicao;

    private Stage stage;
    @FXML
    private TabPane tabPane;
    @FXML
    private Button btnCardapio;
    @FXML
    private Button btnPessoa;
    @FXML
    private Button btnRefeicao;
    @FXML
    private Button btnConfiguracao;
    @FXML
    private Label lblHorario;

    public void setStage(Stage stage) {
        this.stage = stage;
        stage.getIcons().add(new Image("/br/edu/qi/image/icon.png"));
    }

    /**
     * Initializes the controller class.
     */
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
        lblHorario.setText(s.format(agora));
    }

    private void abrir(String url, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(url));
            Parent content = loader.load();
            Tab tab = new Tab(title);
            tab.setContent(content);
            tabPane.getTabs().add(tab);
            tabPane.getSelectionModel().select(tab);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handlerInstituicao(ActionEvent event) {
        abrir("/br/edu/qi/view/Instituicao.fxml", "Instituição");
    }

    @FXML
    private void handlerCardapio(ActionEvent event) {
        abrir("/br/edu/qi/view/Cardapio.fxml", "Cardápio");
    }

    @FXML
    private void handlerPessoa(ActionEvent event) {
        abrir("/br/edu/qi/view/Pessoa.fxml", "Pessoa");
    }

    @FXML
    private void handlerRefeicao(ActionEvent event) {
        abrir("/br/edu/qi/view/Refeicao.fxml", "Refeição");
    }

    @FXML
    private void handlerConfiguracao(ActionEvent event) {
        abrir("/br/edu/qi/view/Configuracao.fxml", "Configuração");
    }
}
