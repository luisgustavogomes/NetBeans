package br.edu.qi.controller;

import br.edu.qi.model.MultaBO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class EditViewController implements Initializable {

    private MultaBO multa = new MultaBO();
    @FXML
    private TextField txtNroPlaca;
    @FXML
    private TextField txtData;
    @FXML
    private TextField txtHorario;
    @FXML
    private TextField txtLocal;
    @FXML
    private TextField txtVelocidadePermitida;
    @FXML
    private TextField txtVelocidadeVeiculo;
    @FXML
    private TextField txtValorApagar;
    @FXML
    private Button btnGravar;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    @FXML
    private void handlerBtGravar(ActionEvent event) {
        try {
            validation();
            //pega tela e manda salvar 
            //MultaVO multaVO = new MultaVO(, data, horario, local, 0, 0, 0);
            //multa.save(multaVO);
            msgDialog("Salva com sucesso!", Alert.AlertType.INFORMATION);
        } catch (Exception ex) {
            msgDialog(ex.getMessage(), Alert.AlertType.ERROR);
        }
    }

    public void validation() {

    }

    public void msgDialog(String msg, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle("Multas");
        alert.setContentText(msg);
        alert.show();
    }

}
