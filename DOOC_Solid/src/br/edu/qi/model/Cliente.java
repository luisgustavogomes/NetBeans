/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.model;

import br.edu.qi.util.HelperUtilidade;
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
    
    public boolean isValid(){
        return EmailService.isValid(email) &&
                HelperUtilidade.isValidCPF(cpf);
    }

}
