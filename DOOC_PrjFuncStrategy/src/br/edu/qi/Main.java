/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi;

import br.edu.qi.model.Analista;
import br.edu.qi.model.Cargo;
import br.edu.qi.model.Funcionario;

/**
 *
 * @author lg
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        REGRA DO CÁLCULO DO SALÁRIO de cada Funcionário
        - ANALISTA:
            Se o tempo de empresa >= 5 anos
                (salario+gratificacao +10%
            Se Não
                (Salário + Gratificacao)
        
        - DESENVOLVEDOR
                (Salário + Gratificacao)
        
        - VENDEDOR
                (salario+comissao+gratificacao)
        - GERENTE
            Se o tempo de empresa >= 5 anos
                (salario+gratificacao +20%
            Se Não
                (Salário + Gratificacao)
        - CONSULTOR
                (salario+comissao)
        
         */
        Analista analista = new Analista(new Funcionario(1, "Funcionario1", 1200, 100, 200, 5, Cargo.ANALISTA));
        Funcionario func2 = new Funcionario(1, "Funcionario2", 1000, 50, 100, 2, Cargo.CONSULTOR);
        System.out.println("Func  1: " + Cargo.ANALISTA.calcularSalario(analista));
//        System.out.println("Func  2: " + calcularSalario(func2));
    }

   
}
