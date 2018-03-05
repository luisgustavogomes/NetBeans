/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fis.model;

/**
 *
 * @author Luis Gustavo
 */
public class Gerente extends Empregado {

    private Departamento departamento;

    public Gerente(long cpf, String nome) {
        super(cpf, nome);
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    
}
