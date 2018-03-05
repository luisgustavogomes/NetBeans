/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.controller;

import br.edu.qi.dao.HibernateUtil;
import br.edu.qi.model.Endereco;
import br.edu.qi.model.Pessoa;
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
public class CadEditPessoaViewController implements Initializable {

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtRua;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtNumero;
    @FXML
    private Button btnSalvar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void handlerBtGravar(ActionEvent ev) {
        try {
            Pessoa p = new Pessoa(new Endereco(this.txtRua.getText(),
                    Integer.parseInt(this.txtNumero.getText())),
                    this.txtNome.getText(),
                    this.txtEmail.getText());
            HibernateUtil.persistePessoa(p);
            msgDialog("Gravação com sucesso!", Alert.AlertType.ERROR);
        } catch (Exception e) {
            msgDialog(e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    public void msgDialog(String msg, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle("Cadastro");
        alert.setHeaderText("Informação");
        alert.setContentText(msg);
        alert.show();
    }

}
