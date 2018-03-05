/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.controller;

import br.edu.qi.model.FuncionarioBO;
import br.edu.qi.model.FuncionarioVO;
import br.edu.qi.utl.Helper;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Luis Gustavo
 */
public class FuncEditController implements Initializable {

    private FuncionarioBO func;

    private Stage dialogStage;
    @FXML
    private Label lbMatricula;
    @FXML
    private Label lbNome;
    @FXML
    private Label lbEndereco;
    @FXML
    private Label lbSexo;
    @FXML
    private Label lbSalario;
    @FXML
    private TextField txMatricula;
    @FXML
    private TextField txNome;
    @FXML
    private TextField txEndereco;
    @FXML
    private TextField txSalario;
    @FXML
    private TextField txQuinquenio;
    @FXML
    private ComboBox cbCargo;
    @FXML
    private RadioButton rbM;
    @FXML
    private ToggleGroup grSexo;
    @FXML
    private RadioButton rbF;
    @FXML
    private Button btGravar;
    @FXML
    private CheckBox ckGerente;
    @FXML
    private Label lbGerente;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cbCargo.getItems().addAll("[Selecione...]", "Analista", "Desenvolvedor", "DBA", "Suporte");
        cbCargo.getSelectionModel().select(0);
        func = new FuncionarioBO();
    }

    public void setDialogStage(Stage dialog) {
        this.dialogStage = dialog;
    }

    private void validation() throws Exception {

        if (!Helper.isNumero(this.txMatricula.getText())) {
            throw new Exception("Informe a Matricula!");
        }
        if (this.txNome.getText().length() == 0) {
            throw new Exception("Informe o Nome!");
        }
        if (this.txEndereco.getText().length() == 0) {
            throw new Exception("Informe o Endereço!");
        }
        if (this.grSexo.getSelectedToggle() == null) {
            throw new Exception("Escolha um sexo para o funcionário!");
        }
        if (this.cbCargo.getSelectionModel().getSelectedIndex() == 0) {
            throw new Exception("Seecione um Cargo!");
        }
        if (this.txQuinquenio.getText().length() == 0 || Float.parseFloat(txQuinquenio.getText()) <= 0) {
            throw new Exception("Informe um quinquenio");
        }
        if (this.txSalario.getText().length() == 0 || Float.parseFloat(txSalario.getText()) <= 0) {
            throw new Exception("Informe um salário");
        }

    }

    private void msgDialog(String msg, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle("Sistema RH");
        alert.setContentText(msg);
        alert.show();
    }

    @FXML
    private void handBtGravar(ActionEvent event) {
        try {
            validation();
            func.save(new FuncionarioVO(
                    Long.parseLong(this.txMatricula.getText()), 
                    this.txNome.getText(), 
                    this.txEndereco.getText(), 
                    ((RadioButton)this.grSexo.getSelectedToggle()).getText(), 
                    this.cbCargo.getSelectionModel().getSelectedItem().toString(),
                    Double.parseDouble(this.txSalario.getText()),
                    Double.parseDouble(this.txQuinquenio.getText()),
                    this.ckGerente.selectedProperty().get()));
            System.out.println(func.getFuncionarioArr().toString());
            
            func.toString();
            msgDialog("Gravado com Sucesso!", Alert.AlertType.INFORMATION);
        } catch (Exception e) {
            msgDialog(e.getMessage(), Alert.AlertType.ERROR);
        }
    }

}
