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
public class Professor {

    private long matricula;
    private String nome;

    public Professor(long matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (int) (this.matricula ^ (this.matricula >>> 32));
        hash = 53 * hash + Objects.hashCode(this.nome);
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
        final Professor other = (Professor) obj;
        if (this.matricula != other.matricula) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Professor{" + "matricula=" + matricula + ", nome=" + nome + '}';
    }

}
