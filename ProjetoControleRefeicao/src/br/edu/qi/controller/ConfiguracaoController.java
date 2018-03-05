/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.controller;

import br.edu.qi.entity.ParametroEmail;
import br.edu.qi.service.ConfiguracaoService;
import br.edu.qi.service.IService;
import br.edu.qi.utl.Helper;
import br.edu.qi.utl.HelperNotification;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import tray.notification.NotificationType;

/**
 * FXML Controller class
 *
 * @author lg
 */
public class ConfiguracaoController implements Initializable {

    private IService configuracaoService;

    @FXML
    private TextField txtEmail;
    @FXML
    private ComboBox<String> cbServidor;
    @FXML
    private TextField txtId;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        configuracaoService = new ConfiguracaoService();
        carregarConfiguracao();
    }

    @FXML
    private void handlerSalvar(ActionEvent event) {
        try {
            validation();
            System.out.println(txtId.getText());
            if (txtId.getText().isEmpty()) {
                ParametroEmail email = new ParametroEmail(txtEmail.getText());
                configuracaoService.save(email);
                HelperNotification.Notification("Configuração", "Salva com sucesso!", NotificationType.SUCCESS);
                txtId.setText(String.valueOf(email.getIdParametroEmail()));
            } else {
                ParametroEmail email = new ParametroEmail(Integer.parseInt(txtId.getText()), txtEmail.getText());
                configuracaoService.update(email);
                HelperNotification.Notification("Configuração", "Salva com sucesso!", NotificationType.SUCCESS);
            }
        } catch (Exception ex) {
            HelperNotification.Notification("Configuração", ex.getMessage(), NotificationType.ERROR);
        }
    }

    @FXML
    private void handlerCancelar(ActionEvent event) {
        clear();
    }

    private void clear() {
        txtEmail.setText("");
    }

    private void validation() throws Exception {
        if (txtEmail.getText().isEmpty()) {
            throw new Exception("Informe um email!");
        }
        if (!Helper.isEmail(txtEmail.getText())) {
            throw new Exception("Informe um email valido!");
        }
    }

    private void carregarConfiguracao() {
        ParametroEmail email = null;
        try {
            email = (ParametroEmail) configuracaoService.findAllWithoutClose().get(0);
        } catch (Exception ex) {
            HelperNotification.Notification("Configuração", ex.getMessage(), NotificationType.ERROR);
        }
        if (email != null) {
            txtId.setText(String.valueOf(email.getIdParametroEmail()));
            txtEmail.setText(email.getEmail());
        }
    }

}
