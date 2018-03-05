/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.controller;

import br.edu.qi.entity.Email;
import br.edu.qi.entity.Pessoa;
import br.edu.qi.service.ConfiguracaoService;
import br.edu.qi.service.EmailService;
import br.edu.qi.service.IService;
import br.edu.qi.service.PessoaService;
import br.edu.qi.utl.HelperDate;
import br.edu.qi.utl.HelperNotification;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import tray.notification.NotificationType;

/**
 * FXML Controller class
 *
 * @author lg
 */
public class EmailController implements Initializable {

    private EmailService emailService;
    private ConfiguracaoService configuracaoService;
    private IService pessoaService;

    @FXML
    private Button button;
    @FXML
    private TextField tfEmailRemetente;
    @FXML
    private PasswordField psSenhaRemetente;
    @FXML
    private TextField tfEmailDestinatario;
    @FXML
    private TextField tfAssunto;
    @FXML
    private TextArea txtAreaMsg;
    @FXML
    private AnchorPane tela;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        emailService = new EmailService();
        configuracaoService = new ConfiguracaoService();
        pessoaService = new PessoaService();
        carregaRemetente();
        tfAssunto.setText(criarAssunto());
        tfEmailDestinatario.setText(carregaDestinatarios());
        txtAreaMsg.setText(criarMensagem());

    }

    private void carregaRemetente() {
        try {
            tfEmailRemetente.setText(configuracaoService.findAllWithoutClose().get(0).toString());
        } catch (Exception ex) {
            HelperNotification.Notification("E-mail", ex.getMessage(), NotificationType.ERROR);
        }
    }

    @FXML
    private void enviarEmail(ActionEvent event) {
        try {
            emailService.enviarGmail(new Email(
                    tfEmailRemetente.getText(),
                    psSenhaRemetente.getText(),
                    tfEmailDestinatario.getText(),
                    tfAssunto.getText(),
                    txtAreaMsg.getText()));
            HelperNotification.Notification("E-mail", "E-mail enviado com sucesso!", NotificationType.SUCCESS);

        } catch (Exception e) {
            HelperNotification.Notification("E-mail", e.getMessage(), NotificationType.ERROR);
        }
    }

    private String criarAssunto() {
        return "Cardápio da Instituição: " + CardapioController.menuEmail.getInstituicao().toString()
                + " | Data: " + HelperDate.retornarDataString(CardapioController.menuEmail.getDataCarpadio());
    }

    private String criarMensagem() {
        String retorno = null;
        try {
            retorno =
                    "Refeição: " + CardapioController.menuEmail.getRefeicao().getDescricao() + "\n" + 
                    "Data refeição: " + HelperDate.retornarDataString(CardapioController.menuEmail.getRefeicao().getDataCadastro()) + "\n" +
                    "Descrição: " + CardapioController.menuEmail.getDescricao();
            
        } catch (Exception ex) {
            HelperNotification.Notification("E-mail", ex.getMessage(), NotificationType.ERROR);
        }
                
        return retorno;
    }

    private String carregaDestinatarios() {
        int idInstituicao = CardapioController.menuEmail.getInstituicao().getIdInstituicao();
        String email = null;
        try {
            List<Pessoa> pessoas = pessoaService.findAllWithoutClose();
            List<Pessoa> pessoasInstituicao = new ArrayList<>();
            pessoas.stream().filter((p) -> (p.getInstituicao().getIdInstituicao() == idInstituicao)).forEachOrdered((p) -> {
                pessoasInstituicao.add(p);
            });
            if (pessoasInstituicao.size() == 1) {
                email = pessoasInstituicao.get(0).getEmail();
                return email;
            }
            if (pessoasInstituicao.isEmpty()) {
                email = CardapioController.menuEmail.getInstituicao().getEmail();
                return email;
            }
            email = pessoasInstituicao.get(0).getEmail();
            for (int i = 1; i < pessoasInstituicao.size(); i++) {
                 email = email + ";" +  pessoasInstituicao.get(i).getEmail();
            }
        } catch (Exception ex) {
            HelperNotification.Notification("E-mail", ex.getMessage(), NotificationType.ERROR);
        }
        return email;
    }
}
