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
public class CarroVO {

    private String proprietario;
    private int ano;
    private String marca;
    private String modelo;
    private String cor;
    private String descricao;
    private boolean arCondicionado;
    private boolean tocaFita;
    private boolean rodaLiga;
    private boolean tapetes;
    private boolean alarme;
    private String tipo;
    private String estado;
    private double km;
    private double valor;

    public CarroVO(String proprietario, int ano, String marca, String modelo, String cor, String descricao, boolean arCondicionado, boolean tocaFita, boolean rodaLiga, boolean tapetes, boolean alarme, String tipo, String estado, double km, double valor) {
        this.proprietario = proprietario;
        this.ano = ano;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.descricao = descricao;
        this.arCondicionado = arCondicionado;
        this.tocaFita = tocaFita;
        this.rodaLiga = rodaLiga;
        this.tapetes = tapetes;
        this.alarme = alarme;
        this.tipo = tipo;
        this.estado = estado;
        this.km = km;
        this.valor = valor;
    }


    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isArCondicionado() {
        return arCondicionado;
    }

    public void setArCondicionado(boolean arCondicionado) {
        this.arCondicionado = arCondicionado;
    }

    public boolean isTocaFita() {
        return tocaFita;
    }

    public void setTocaFita(boolean tocaFita) {
        this.tocaFita = tocaFita;
    }

    public boolean isRodaLiga() {
        return rodaLiga;
    }

    public void setRodaLiga(boolean rodaLiga) {
        this.rodaLiga = rodaLiga;
    }

    public boolean isTapetes() {
        return tapetes;
    }

    public void setTapetes(boolean tapetes) {
        this.tapetes = tapetes;
    }

    public boolean isAlarme() {
        return alarme;
    }

    public void setAlarme(boolean Alarme) {
        this.alarme = Alarme;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.proprietario);
        hash = 23 * hash + this.ano;
        hash = 23 * hash + Objects.hashCode(this.marca);
        hash = 23 * hash + Objects.hashCode(this.modelo);
        hash = 23 * hash + Objects.hashCode(this.cor);
        hash = 23 * hash + Objects.hashCode(this.descricao);
        hash = 23 * hash + (this.arCondicionado ? 1 : 0);
        hash = 23 * hash + (this.tocaFita ? 1 : 0);
        hash = 23 * hash + (this.rodaLiga ? 1 : 0);
        hash = 23 * hash + (this.tapetes ? 1 : 0);
        hash = 23 * hash + (this.alarme ? 1 : 0);
        hash = 23 * hash + Objects.hashCode(this.tipo);
        hash = 23 * hash + Objects.hashCode(this.estado);
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.km) ^ (Double.doubleToLongBits(this.km) >>> 32));
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
        final CarroVO other = (CarroVO) obj;
        if (this.ano != other.ano) {
            return false;
        }
        if (this.arCondicionado != other.arCondicionado) {
            return false;
        }
        if (this.tocaFita != other.tocaFita) {
            return false;
        }
        if (this.rodaLiga != other.rodaLiga) {
            return false;
        }
        if (this.tapetes != other.tapetes) {
            return false;
        }
        if (this.alarme != other.alarme) {
            return false;
        }
        if (Double.doubleToLongBits(this.km) != Double.doubleToLongBits(other.km)) {
            return false;
        }
        if (!Objects.equals(this.proprietario, other.proprietario)) {
            return false;
        }
        if (!Objects.equals(this.marca, other.marca)) {
            return false;
        }
        if (!Objects.equals(this.modelo, other.modelo)) {
            return false;
        }
        if (!Objects.equals(this.cor, other.cor)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        return true;
    }
    
    

}
