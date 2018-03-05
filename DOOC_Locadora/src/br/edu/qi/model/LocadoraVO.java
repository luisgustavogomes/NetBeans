/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.model;

import java.util.Objects;

/**
 *
 * @author Luis Gustavo
 */
public class LocadoraVO {
    private int nroLocacao;
    private String veiculo;
    private double valor;
    private int qtdeDias;
    private double multa;
    private int qtdeDiasAtraso;

    public LocadoraVO(int nroLocacao, String veiculo, double valor, int qtdeDias) {
        this.nroLocacao = nroLocacao;
        this.veiculo = veiculo;
        this.valor = valor;
        this.qtdeDias = qtdeDias;
    }

    public LocadoraVO(int nroLocacao, String veiculo, double valor, int qtdeDias, double multa, int qtdeDiasAtraso) {
        this.nroLocacao = nroLocacao;
        this.veiculo = veiculo;
        this.valor = valor;
        this.qtdeDias = qtdeDias;
        this.multa = multa;
        this.qtdeDiasAtraso = qtdeDiasAtraso;
    }

    public int getNroLocacao() {
        return nroLocacao;
    }

    public void setNroLocacao(int nroLocacao) {
        this.nroLocacao = nroLocacao;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQtdeDias() {
        return qtdeDias;
    }

    public void setQtdeDias(int qtdeDias) {
        this.qtdeDias = qtdeDias;
    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }

    public int getQtdeDiasAtraso() {
        return qtdeDiasAtraso;
    }

    public void setQtdeDiasAtraso(int qtdeDiasAtraso) {
        this.qtdeDiasAtraso = qtdeDiasAtraso;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.nroLocacao;
        hash = 61 * hash + Objects.hashCode(this.veiculo);
        hash = 61 * hash + (int) (Double.doubleToLongBits(this.valor) ^ (Double.doubleToLongBits(this.valor) >>> 32));
        hash = 61 * hash + this.qtdeDias;
        hash = 61 * hash + (int) (Double.doubleToLongBits(this.multa) ^ (Double.doubleToLongBits(this.multa) >>> 32));
        hash = 61 * hash + this.qtdeDiasAtraso;
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
        final LocadoraVO other = (LocadoraVO) obj;
        if (this.nroLocacao != other.nroLocacao) {
            return false;
        }
        if (Double.doubleToLongBits(this.valor) != Double.doubleToLongBits(other.valor)) {
            return false;
        }
        if (this.qtdeDias != other.qtdeDias) {
            return false;
        }
        if (Double.doubleToLongBits(this.multa) != Double.doubleToLongBits(other.multa)) {
            return false;
        }
        if (this.qtdeDiasAtraso != other.qtdeDiasAtraso) {
            return false;
        }
        if (!Objects.equals(this.veiculo, other.veiculo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LocadoraVO{" + "nroLocacao=" + nroLocacao + ", veiculo=" + veiculo + ", valor=" + valor + ", qtdeDias=" + qtdeDias + ", multa=" + multa + ", qtdeDiasAtraso=" + qtdeDiasAtraso + '}';
    }
    
    
    
    
}
