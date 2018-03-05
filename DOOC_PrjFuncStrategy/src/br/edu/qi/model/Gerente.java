/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.model;

/**
 *
 * @author lg
 */
public class Gerente implements IFuncionario {

    private Funcionario func;

    public Gerente(Funcionario func) {
        this.func = func;
    }
    
    
    @Override
    public float calcularSalario() {
        float total = func.getSalario() + func.getGratificaca();
        if (func.getTempoEmpresa() >= 5) {
            total *= 1.2;
        }
        return total;
    }

}
