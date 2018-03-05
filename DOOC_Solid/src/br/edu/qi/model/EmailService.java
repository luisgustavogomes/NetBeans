/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.model;

/**
 *
 * @author lg
 */
public class EmailService {

    public static boolean isValid(String email) {
        if (email.indexOf('@') == 0) {
            return true;
        }
        return false;
    }

    public static void send(String from, String to, String subject, String msg) {
        System.out.println("Enviado o email de confirmação do cadastro!"
                + "\nDe: " + from
                + "\nPara: " + to
                + "\nAssunto: " + subject
                + "\nMsg: " + msg);
    }
}
