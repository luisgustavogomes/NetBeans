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
public class Integrante {

    private Nota nota;
    private Aluno aluno;

    public Integrante(Aluno aluno) {
        this.aluno = aluno;
        nota = new Nota();
    }

    public double mediaAluno() {
        return nota.getSubst() > 0 ? nota.getSubst() : ((nota.getN1() + nota.getN2()) / 2);
    }

    public Nota getNota() {
        return nota;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.nota);
        hash = 79 * hash + Objects.hashCode(this.aluno);
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
        final Integrante other = (Integrante) obj;
        if (!Objects.equals(this.nota, other.nota)) {
            return false;
        }
        if (!Objects.equals(this.aluno, other.aluno)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Integrante{" + "Aluno=" + aluno + ", Nota=" + nota + '}';
    }

}
