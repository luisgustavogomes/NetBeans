package br.edu.qi.controller;

import br.edu.qi.MainApp;
import br.edu.qi.util.HelperAlert;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class HomeEditController implements Initializable {

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
        stage.getIcons().add(new Image("/br/edu/qi/image/iconCar.png"));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleCadCarro(ActionEvent event) {
        try {
            openWindow("/br/edu/qi/view/CarroEdit.fxml", "Cadastro de Carros");
        } catch (Exception ex) {
            HelperAlert.msgDialog(ex.getMessage(), getClass().getName(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void handleCadMarca(ActionEvent event) throws Exception {
        try {
            openWindow("/br/edu/qi/view/MarcaEdit.fxml", "Cadastro de Marcas");
        } catch (Exception ex) {
            HelperAlert.msgDialog(ex.getMessage(), getClass().getName(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void handleCadModelo(ActionEvent event) throws Exception {
        try {
            openWindow("/br/edu/qi/view/ModeloEdit.fxml", "Cadastro de Modelos");
        } catch (Exception ex) {
            HelperAlert.msgDialog(ex.getMessage(), getClass().getName(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void handleCadCliente(ActionEvent event) throws Exception {
        try {
            openWindow("/br/edu/qi/view/ProprietarioEdit.fxml", "Cadastro de Clientes");
        } catch (Exception ex) {
            HelperAlert.msgDialog(ex.getMessage(), getClass().getName(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void handleCadVenda(ActionEvent event) throws Exception {
        try {
            openWindow("/br/edu/qi/view/VendaEdit.fxml", "Registro de Vendas");
        } catch (Exception ex) {
            HelperAlert.msgDialog(ex.getMessage(), getClass().getName(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void handleCadPagamento(ActionEvent event) throws Exception {
        try {
            openWindow("/br/edu/qi/view/PagamentoEdit.fxml", "Registro de Pagamentos");
        } catch (Exception ex) {
            HelperAlert.msgDialog(ex.getMessage(), getClass().getName(), Alert.AlertType.ERROR);
        }
    }

    private void openWindow(String path, String title) throws Exception {
        Parent root1 = FXMLLoader.load(getClass().getResource(path));
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.setResizable(true);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.getIcons().add(MainApp.icon);
        stage.setTitle(title);
        stage.show();
    }

}
