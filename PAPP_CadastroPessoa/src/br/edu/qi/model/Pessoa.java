package br.edu.qi.model;

import br.edu.qi.util.HelpDate;
import java.util.Date;

public class Pessoa {

    public static final char MASCULINO = 'M';
    public static final char FEMININO = 'F';
    private int codigo;
    private String nome;
    private char sexo;
    private Date dataNascimento;
    private String cpf;
    private Endereco endereco;

    public Pessoa(int codigo, String nome, char sexo, Date dataNascimento, String cpf) {
        this.codigo = codigo;
        this.nome = nome;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
    }

    public Pessoa(int codigo, String nome, char sexo, Date dataNascimento, String cpf, Endereco endereco) {
        this.codigo = codigo;
        this.nome = nome;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.endereco = endereco;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public char getSexo() {
        return sexo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }


    public Endereco getEndereco() {
        return this.endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Nome=" + nome + ", Sexo=" + sexo + ", Data nascimento=" + HelpDate.retornarDataString(dataNascimento) + ", CPF=" + cpf;
    }

}
