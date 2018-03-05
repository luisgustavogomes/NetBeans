/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.model;

import java.util.List;

/**
 *
 * @author lg
 */
public class CursoMestrado extends Curso {

    private boolean strictoSensu;

    public CursoMestrado(int codigo, int time, int sala, String nome, String nomeProfessor, List<Aluno> alunos, boolean strictoSensu) {
        super(codigo, time, sala, nome, nomeProfessor, alunos);
        this.strictoSensu = strictoSensu;
    }

    @Override
    public void calculoDiploma(Curso curso) {
        if (curso.alunos.size() <= 5) {
            this.setAdicionalDiploma(45);
        } else if (curso.alunos.size() <= 15) {
            this.setAdicionalDiploma(43);
        } else if (curso.alunos.size() <= 30) {
            this.setAdicionalDiploma(40);
        } else {
            this.setAdicionalDiploma(36);
        }
    }

    @Override
    public String toString() {
        return super.toString() + "CursoMestrado{" + "strictoSensu=" + strictoSensu + '}';
    }

}
