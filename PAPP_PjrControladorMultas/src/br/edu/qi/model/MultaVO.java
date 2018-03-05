/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.model;

import java.util.Objects;

/**
 *
 * @author lg
 */
public class MultaVO {

    private String nroPlaca;
    private String data;
    private String horario;
    private String local;
    private int velocidadePermitida;
    private int velocidadeVeiculo;
    private double valorApagar;

    public MultaVO(String nroPlaca, String data, String horario, String local, int velocidadePermitida, int velocidadeVeiculo, double valorApagar) {
        this.nroPlaca = nroPlaca;
        this.data = data;
        this.horario = horario;
        this.local = local;
        this.velocidadePermitida = velocidadePermitida;
        this.velocidadeVeiculo = velocidadeVeiculo;
        this.valorApagar = valorApagar;
    }
    

    public MultaVO(String nroPlaca, String data, String horario, String local, int velocidadePermitida, int velocidadeVeiculo) {
        this.nroPlaca = nroPlaca;
        this.data = data;
        this.horario = horario;
        this.local = local;
        this.velocidadePermitida = velocidadePermitida;
        this.velocidadeVeiculo = velocidadeVeiculo;
        
    }

    public String getNroPlaca() {
        return nroPlaca;
    }

    public String getData() {
        return data;
    }

    public String getHorario() {
        return horario;
    }

    public String getLocal() {
        return local;
    }

    public int getVelocidadePermitida() {
        return velocidadePermitida;
    }

    public int getVelocidadeVeiculo() {
        return velocidadeVeiculo;
    }

    public double getValorApagar() {
        return valorApagar;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.nroPlaca);
        hash = 47 * hash + Objects.hashCode(this.data);
        hash = 47 * hash + Objects.hashCode(this.horario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MultaVO other = (MultaVO) obj;
        if (!Objects.equals(this.nroPlaca, other.nroPlaca)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (!Objects.equals(this.horario, other.horario)) {
            return false;
        }
        return true;
    }
    
    
}
