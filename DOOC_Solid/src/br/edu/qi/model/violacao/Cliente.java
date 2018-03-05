/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.model.violacao;

import java.time.LocalDate;

/**
 *
 * @author lg
 */
public class Cliente {

    private int id;
    private String nome;
    private String email;
    private String cpf;
    private LocalDate data;
    
    public String adicionarCliente(){
        if (this.email.indexOf('@') == 0 ) {
            return "O e-mail inválido";
        }
        if (this.cpf.length() != 11) {
            return "cpf invalido";
        }
        return "Cliente cadastrado com sucesso!";
    }
}
