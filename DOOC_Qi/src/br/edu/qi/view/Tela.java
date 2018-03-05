/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.view;

import br.edu.qi.model.Aluno;
import br.edu.qi.model.Disciplina;
import br.edu.qi.model.Integrante;
import br.edu.qi.model.Professor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luis Gustavo
 */
public class Tela {

    public static void main(String[] args) {

        Integrante i1 = new Integrante(new Aluno(1, "Luis"));
        Integrante i2 = new Integrante(new Aluno(2, "Gustavo"));
        Integrante i3 = new Integrante(new Aluno(3, "Bauer"));
        Integrante i4 = new Integrante(new Aluno(4, "Pedroso"));
        Professor p = new Professor(101, "Zé ruela");
        List<Integrante> l = new ArrayList<>();
        l.add(i1);
        l.add(i2);
        l.add(i3);
        l.add(i4);
        i1.getNota().setN1(10);
        i1.getNota().setN2(6);
        System.out.println(i1.mediaAluno());
        
        
        Disciplina d = new Disciplina(l, p);

        d.getIntegrantes().forEach((Integrante i) -> System.out.print(i + "\n"));
        System.out.println(d.mediaTurma());
        
    }
}
