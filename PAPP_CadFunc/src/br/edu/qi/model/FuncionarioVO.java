/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.model;

import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;

/**
 *
 * @author Luis Gustavo
 */
public class FuncionarioVO {

    private long matricula;
    private String nome;
    private String endereco;
    private String sexo;
    private String cargo;
    private double salario;
    private double quinquenio;
    private boolean gerente;

    public FuncionarioVO(long matricula, String nome, String endereco, String sexo, String cargo, double salario, double quinquenio, boolean gerente) {
        this.matricula = matricula;
        this.nome = nome;
        this.endereco = endereco;
        this.sexo = sexo;
        this.cargo = cargo;
        this.salario = salario;
        this.quinquenio = quinquenio;
        this.gerente = gerente;
    }

    public boolean isGerente() {
        return gerente;
    }

    public void setGerente(boolean gerente) {
        this.gerente = gerente;
    }

  

    public long getMatricula() {
        return matricula;
    }

    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getQuinquenio() {
        return quinquenio;
    }

    public void setQuinquenio(double quinquenio) {
        this.quinquenio = quinquenio;
    }

    @Override
    public String toString() {
        return "FuncionarioVO{" + "matricula=" + matricula + ", nome=" + nome + ", endereco=" + endereco + ", sexo=" + sexo + ", cargo=" + cargo + ", salario=" + salario + ", quinquenio=" + quinquenio + ", gerente=" + gerente + '}';
    }

    
}
