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
public class Desenvolvedor implements IFuncionario{

    private Funcionario func;

    public Desenvolvedor(Funcionario func) {
        this.func = func;
    }
    
    
    @Override
    public float calcularSalario() {
        return func.getSalario() + func.getGratificaca();
    }
    
}
