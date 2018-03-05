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
public class MatriculaVO {

    private final double VALORMATRICULADEFAUT = 260;

    private int nroMatricula;
    private String Disciplina;
    private double desconto;
    private double valor;

    public MatriculaVO(int nroMatricula, String Disciplina, double desconto) {
        this.nroMatricula = nroMatricula;
        this.Disciplina = Disciplina;
        this.desconto = desconto;
        this.valor = VALORMATRICULADEFAUT;
    }

    public double getValor() {
        return valor;
    }

    public int getNroMatricula() {
        return nroMatricula;
    }

    public void setNroMatricula(int nroMatricula) {
        this.nroMatricula = nroMatricula;
    }

    public String getDisciplina() {
        return Disciplina;
    }

    public void setDisciplina(String Disciplina) {
        this.Disciplina = Disciplina;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.VALORMATRICULADEFAUT) ^ (Double.doubleToLongBits(this.VALORMATRICULADEFAUT) >>> 32));
        hash = 29 * hash + this.nroMatricula;
        hash = 29 * hash + Objects.hashCode(this.Disciplina);
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.desconto) ^ (Double.doubleToLongBits(this.desconto) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.valor) ^ (Double.doubleToLongBits(this.valor) >>> 32));
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
        final MatriculaVO other = (MatriculaVO) obj;
        if (Double.doubleToLongBits(this.VALORMATRICULADEFAUT) != Double.doubleToLongBits(other.VALORMATRICULADEFAUT)) {
            return false;
        }
        if (this.nroMatricula != other.nroMatricula) {
            return false;
        }
        if (Double.doubleToLongBits(this.desconto) != Double.doubleToLongBits(other.desconto)) {
            return false;
        }
        if (Double.doubleToLongBits(this.valor) != Double.doubleToLongBits(other.valor)) {
            return false;
        }
        if (!Objects.equals(this.Disciplina, other.Disciplina)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MatriculaVO{" + "VALORMATRICULADEFAUT=" + VALORMATRICULADEFAUT + ", nroMatricula=" + nroMatricula + ", Disciplina=" + Disciplina + ", desconto=" + desconto + ", valor=" + valor + '}';
    }

    
    
}
