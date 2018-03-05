package br.edu.qi.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class ProdEditController implements Initializable {

    private Stage dialogStage;
    @FXML
    private TextField txtProduto;
    @FXML
    private TextField txtQuantidade;
    @FXML
    private TextField txtValor;
    @FXML
    private Button btCalcular;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        btCalcular.setOnAction(this::handCalcular);
    }

    @FXML
    private void handCalcular(ActionEvent event) {
        double qtde = Double.parseDouble(txtQuantidade.getText());
        double valor = Double.parseDouble(txtValor.getText());
        JOptionPane.showMessageDialog(null, "Total: " + qtde * valor);
    }

    public void setDialogStage(Stage dialog) {
        this.dialogStage = dialog;
    }

}
