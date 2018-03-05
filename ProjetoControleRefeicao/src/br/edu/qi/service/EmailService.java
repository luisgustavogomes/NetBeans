/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.service;

import br.edu.qi.entity.Email;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author lg
 */
public class EmailService {

    private Session session;
    private MimeMessage message;

    public void enviarGmail(Email email) throws Exception {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email.getEmailRemetente(), email.getSenhaRemetente());//email e senha usuário 
            }
        });
        session.setDebug(true);
        try {
            message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email.getEmailRemetente()));
            String[] listaEmailsVet = email.getEmailDestinatario().split(";");
            List<InternetAddress> listaEmails = new ArrayList<>();
            for (int i = 0; i < listaEmailsVet.length; i++) {
                listaEmails.add(new InternetAddress(listaEmailsVet[i]));
            }
            Set<InternetAddress> listaEmailsSet = new HashSet<>(listaEmails);
            InternetAddress[] vetor = (InternetAddress[]) listaEmailsSet.toArray(new InternetAddress[listaEmailsSet.size()]);
            message.addRecipients(Message.RecipientType.TO, vetor);
            message.setSubject(email.getAssunto());
            message.setContent(email.getMenssagem(), "text/html; charset=utf-8");
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException("Não foi possível enviar o email!");
        }
    }
}
