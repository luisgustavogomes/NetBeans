/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.controller;

import br.edu.qi.model.MultaBO;
import br.edu.qi.model.MultaVO;
import br.edu.qi.util.HelperNumbers;
import br.edu.qi.view.MultaModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author lg
 */
public class CadEditViewController implements Initializable {

    private MultaBO multa = MultaBO.getInstancia();

    @FXML
    private TextField txtNroPlaca;
    @FXML
    private TextField txtHorario;
    @FXML
    private TextField txtLocal;
    @FXML
    private TextField txtVelocidadePermitidaKM;
    @FXML
    private TextField txtVelocidadeVeiculoKM;
    @FXML
    private Button btnGravar;
    @FXML
    private TextField txtData;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handlerBtGravar(ActionEvent event) {
        try {
            validation();
            MultaModel mm = buscarMultaModel();
            MultaVO mv = buscarMultaVO(mm);
            multa.save(mv);
            String msg = "";
            int percente = multa.percentual(Integer.parseInt(txtVelocidadePermitidaKM.getText()), Integer.parseInt(txtVelocidadeVeiculoKM.getText()));
            if (percente <= 0) {
                msg += "\nSem valores!\n";
            } else {
                String valor = null;
                double valorApagar = multa.valorApagar(percente);
                valor = "Sua multa é no valor de " + String.valueOf(valorApagar);
                msg += valor;
            }
            if (percente > 50) {
                msg += "\nSua carteira deve ser entregue ao CRVA mais próximo!";
            }
            msg += "\nMulta salva com sucesso!";
            msgDialog(msg, Alert.AlertType.INFORMATION);
        } catch (Exception ex) {
            msgDialog(ex.getMessage(), Alert.AlertType.ERROR);
        }
    }

    public MultaModel buscarMultaModel() {
        MultaModel multaModel = new MultaModel();
        multaModel.setNroPlaca(txtNroPlaca.getText());
        multaModel.setData(txtData.getText());
        multaModel.setHorario(txtHorario.getText());
        multaModel.setVelocidadePermitida(Integer.parseInt(txtVelocidadePermitidaKM.getText()));
        multaModel.setVelocidadeVeiculo(Integer.parseInt(txtVelocidadeVeiculoKM.getText()));
        
        return multaModel;
    }

    public MultaVO buscarMultaVO(MultaModel multaModel) {
        MultaVO multaVO = new MultaVO(
                multaModel.getNroPlaca(),
                multaModel.getData(),
                multaModel.getHorario(),
                multaModel.getLocal(),
                multaModel.getVelocidadePermitida(),
                multaModel.getVelocidadeVeiculo());
        return multaVO;
    }

    public void msgDialog(String msg, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle("Controle de Multas");
        alert.setContentText(msg);
        alert.show();
    }

    public void validation() throws Exception {
        if (txtNroPlaca.getText().isEmpty()) {
            throw new Exception("Informe uma placa valida");
        }
        if (txtData.getText().isEmpty()) {
            throw new Exception("Informe uma data valida");
        }
        if (txtHorario.getText().isEmpty()) {
            throw new Exception("Informe um horario valido");
        }
        if (txtLocal.getText().isEmpty()) {
            throw new Exception("Informe um local");
        }
        if (!HelperNumbers.isNumericDouble(txtVelocidadePermitidaKM.getText())) {
            throw new Exception("Informe uma velocidade permitida valida");
        }
        if (!HelperNumbers.isNumericDouble(txtVelocidadeVeiculoKM.getText())) {
            throw new Exception("Informe uma velocidade permitida valida");
        }
        
    }

    
}
