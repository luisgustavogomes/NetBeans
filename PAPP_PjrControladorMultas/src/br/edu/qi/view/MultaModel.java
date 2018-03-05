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
public class MultaModel {

    private SimpleStringProperty nroPlaca = new SimpleStringProperty();
    private SimpleStringProperty data = new SimpleStringProperty();
    private SimpleStringProperty horario = new SimpleStringProperty();
    private SimpleStringProperty local = new SimpleStringProperty();
    private SimpleIntegerProperty velocidadePermitida = new SimpleIntegerProperty();
    private SimpleIntegerProperty velocidadeVeiculo = new SimpleIntegerProperty();
    

    public String getNroPlaca() {
        return nroPlaca.get();
    }

    public void setNroPlaca(String nroPlaca) {
        this.nroPlaca.setValue(nroPlaca);
    }

    public String getData() {
        return data.get();
    }

    public void setData(String data) {
        this.data.setValue(data);
    }

    public String getHorario() {
        return horario.get();
    }

    public void setHorario(String horario) {
        this.horario.setValue(horario);
    }

    public String getLocal() {
        return local.get();
    }

    public void setLocal(String local) {
        this.local.setValue(local);
    }

    public Integer getVelocidadePermitida() {
        return velocidadePermitida.get();
    }

    public void setVelocidadePermitida(Integer velocidadePermitida) {
        this.velocidadePermitida.setValue(velocidadePermitida);
    }

    public Integer getVelocidadeVeiculo() {
        return velocidadeVeiculo.get();
    }

    public void setVelocidadeVeiculo(Integer velocidadeVeiculo) {
        this.velocidadeVeiculo.setValue(velocidadeVeiculo);
    }

    
    

}
