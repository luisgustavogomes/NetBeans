/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.model;

import java.util.ArrayList;
import java.util.List;
import java.util.DoubleSummaryStatistics;

/**
 *
 * @author Luis Gustavo
 */
public class Disciplina {

    private List<Integrante> integrantes;
    private Professor professor;

    public Disciplina() {
        integrantes = new ArrayList<>();
    }

    public Disciplina(Professor professor) {
        this();
        this.professor = professor;
    }

    public Disciplina(List<Integrante> integrantes, Professor professor) {
        this();
        this.integrantes = integrantes;
    }

    public boolean adicionarIntegrantes(Integrante integrante) {
        return !validadorIntegrante(integrante) ? integrantes.add(integrante) : false;
    }

    public boolean removerIntegrantes(Integrante integrante) {
        return validadorIntegrante(integrante) ? integrantes.removeIf(i -> i.equals(integrante)) : false;
    }

    private boolean validadorIntegrante(Integrante integrante) {
        return integrantes.stream().anyMatch(i -> i.equals(integrante));
    }

    public double mediaTurma() {
        DoubleSummaryStatistics dss = integrantes.stream().mapToDouble(i -> i.mediaAluno()).summaryStatistics();
        return dss.getAverage();
    }

    public List<Integrante> getIntegrantes() {
        return integrantes;
    }

    @Override
    public String toString() {
        return "Disciplina{" + "integrantes=" + integrantes + ", professor=" + professor + '}';
    }
}
