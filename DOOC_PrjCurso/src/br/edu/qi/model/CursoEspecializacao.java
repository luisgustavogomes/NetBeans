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
public class CursoEspecializacao extends Curso {

    private boolean latoSensu;

    public CursoEspecializacao(int codigo, int time, int sala, String nome, String nomeProfessor, List<Aluno> alunos, boolean latoSensu) {
        super(codigo, time, sala, nome, nomeProfessor, alunos);
        this.latoSensu = latoSensu;
    }

    @Override
    public void calculoDiploma(Curso curso) {
        if (curso.alunos.size() <= 10) {
            this.setAdicionalDiploma(25);
        } else if (curso.alunos.size() <= 30) {
            this.setAdicionalDiploma(20);
        } else {
            this.setAdicionalDiploma(18);
        }
    }

    @Override
    public String toString() {
        return super.toString() + "CursoEspecializacao{" + "latoSensu=" + latoSensu + '}';
    }
    

}
