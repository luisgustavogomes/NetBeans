/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luis Gustavo
 */
public class Aluno {

    private long ra;
    private String nome;
    private List<Disciplina> disciplinas;

    public Aluno(long ra, String nome) {
        disciplinas = new ArrayList<>();
        this.ra = ra;
        this.nome = nome;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public boolean addDisciplina(Disciplina disciplina) {
        return !validadorDisciplina(disciplina) ? disciplinas.add(disciplina) : false;
    }

    private boolean validadorDisciplina(Disciplina disciplina) {
        return disciplinas.stream().anyMatch(d -> d.equals(disciplina));
    }

    @Override
    public String toString() {
        return "{" + "ra=" + ra + ", nome=" + nome + '}';
    }

}
