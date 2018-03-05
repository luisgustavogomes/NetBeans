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
public abstract class Curso implements ICursoCommand {

    private int codigo;
    private int time;
    private int sala;
    private String nome;
    private String nomeProfessor;
    List<Aluno> alunos;
    private double adicionalDiploma;

    public Curso(int codigo, int time, int sala, String nome, String nomeProfessor, List<Aluno> alunos) {
        this.codigo = codigo;
        this.time = time;
        this.sala = sala;
        this.nome = nome;
        this.nomeProfessor = nomeProfessor;
        this.alunos = alunos;
    }
   

    public double getAdicionalDiploma() {
        return adicionalDiploma;
    }

    protected void setAdicionalDiploma(double adicionalDiploma) {
        this.adicionalDiploma = adicionalDiploma;
    }

    @Override
    public String toString() {
        return "Curso{" + "codigo=" + codigo + ", time=" + time + ", sala=" + sala + ", nome=" + nome + ", nomeProfessor=" + nomeProfessor + ", alunos=" + alunos + ", adicionalDiploma=" + adicionalDiploma + '}';
    }
    
    

}
