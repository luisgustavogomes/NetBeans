/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi;

import br.edu.qi.model.Aluno;
import br.edu.qi.model.CursoDoutorado;
import br.edu.qi.model.CursoEspecializacao;
import br.edu.qi.model.CursoMestrado;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lg
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Aluno> alunos = new ArrayList<>();
        alunos.add(new Aluno(1, "Luis"));
        alunos.add(new Aluno(1, "Gustavo"));
        alunos.add(new Aluno(1, "Bruno"));
        alunos.add(new Aluno(1, "Anderson"));
        alunos.add(new Aluno(1, "Anderson"));
        alunos.add(new Aluno(1, "Anderson"));
        alunos.add(new Aluno(1, "Anderson"));
        alunos.add(new Aluno(1, "Anderson"));
        alunos.add(new Aluno(1, "Anderson"));
        alunos.add(new Aluno(1, "Anderson"));
        alunos.add(new Aluno(1, "Anderson"));
        alunos.add(new Aluno(1, "Anderson"));
        alunos.add(new Aluno(1, "Anderson"));
        alunos.add(new Aluno(1, "Anderson"));
        alunos.add(new Aluno(1, "Anderson"));

        CursoEspecializacao cursoEspecializacao = new CursoEspecializacao(1, 17, 306, "DOOC", "rodrigo", alunos, true);
        System.out.println(cursoEspecializacao);
        cursoEspecializacao.calculoDiploma(cursoEspecializacao);
        System.out.println(cursoEspecializacao);
        System.out.println("");
        CursoMestrado cursoMestrado = new CursoMestrado(1, 17, 306, "IPOO", "Cleo", alunos, true);
        System.out.println(cursoMestrado);
        cursoMestrado.calculoDiploma(cursoMestrado);
        System.out.println(cursoMestrado);
        System.out.println("");
        CursoDoutorado cursoDoutorado = new CursoDoutorado(1, 17, 306, "PAPP", "Rodrigo", alunos, true,10);
        System.out.println(cursoDoutorado);
        cursoDoutorado.calculoDiploma(cursoDoutorado);
        System.out.println(cursoDoutorado);

    }

}
