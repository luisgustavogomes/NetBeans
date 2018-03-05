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
public class ProfessorVO {

    private int nroProf;
    private float salario;
    private float formacao;
    private boolean andamento;

    public ProfessorVO(int nroProf, float salario, float formacao, boolean andamento) {
        this.nroProf = nroProf;
        this.salario = salario;
        this.formacao = formacao;
        this.andamento = andamento;
    }

    public int getNroProf() {
        return nroProf;
    }

    public void setNroProf(int nroProf) {
        this.nroProf = nroProf;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public float getFormacao() {
        return formacao;
    }

    public void setFormacao(float formacao) {
        this.formacao = formacao;
    }

    public boolean isAndamento() {
        return andamento;
    }

    public void setAndamento(boolean andamento) {
        this.andamento = andamento;
    }

    @Override
    public String toString() {
        return "Nro Prof: " + nroProf
                + "\nSalario: " + salario
                + "\nCurso em andamento: " + andamento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.nroProf;
        hash = 97 * hash + Float.floatToIntBits(this.formacao);
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
        final ProfessorVO other = (ProfessorVO) obj;
        if (this.nroProf != other.nroProf) {
            return false;
        }
        if (Float.floatToIntBits(this.formacao) != Float.floatToIntBits(other.formacao)) {
            return false;
        }
        return true;
    }

}
