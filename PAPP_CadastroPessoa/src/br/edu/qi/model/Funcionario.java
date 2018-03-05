package br.edu.qi.model;

import java.util.Date;

public class Funcionario extends Pessoa {

    private Double salario;
    private EstadoCivil estadoCivil;

    public Funcionario(int codigo, String nome, char sexo, Date dataNascimento, String cpf, Endereco endereco, Double salario, EstadoCivil estadoCivil) {
        super(codigo, nome, sexo, dataNascimento, cpf, endereco);
        this.salario = salario;
        this.estadoCivil = estadoCivil;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
    

}
