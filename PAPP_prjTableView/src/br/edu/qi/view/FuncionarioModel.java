/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.view;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author lg
 */
public class FuncionarioModel {

    private SimpleIntegerProperty nroMatricula = new SimpleIntegerProperty();
    private SimpleStringProperty nome = new SimpleStringProperty();

    public Integer getNroMatricula() {
        return nroMatricula.get();
    }

    public void setNroMatricula(Integer nroMatricula) {
        this.nroMatricula.setValue(nroMatricula);
    }

    public String getNome() {
        return nome.get();
    }

    public void setNome(String nome) {
        this.nome.setValue(nome);
    }
    
}
