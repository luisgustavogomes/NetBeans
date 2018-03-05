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
public class Funcionario {

    private int matricula;
    private String nome;
    private float salario;
    private float comissao;
    private float gratificaca;
    private int tempoEmpresa;
    private Cargo cargo;

    public Funcionario() {
    }

    public Funcionario(int matricula, String nome, float salario, float comissao, float gratificaca, int tempoEmpresa, Cargo cargo) {
        this.matricula = matricula;
        this.nome = nome;
        this.salario = salario;
        this.comissao = comissao;
        this.gratificaca = gratificaca;
        this.tempoEmpresa = tempoEmpresa;
        this.cargo = cargo;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public int getTempoEmpresa() {
        return tempoEmpresa;
    }

    public void setTempoEmpresa(int tempoEmpresa) {
        this.tempoEmpresa = tempoEmpresa;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public float getComissao() {
        return comissao;
    }

    public void setComissao(float comissao) {
        this.comissao = comissao;
    }

    public float getGratificaca() {
        return gratificaca;
    }

    public void setGratificaca(float gratificaca) {
        this.gratificaca = gratificaca;
    }
}
