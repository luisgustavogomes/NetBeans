package br.edu.qi.model;

public class Correntista {
    private long cpf;
    private String nome;

    public String getNome() {
        return nome;
    }

    public Correntista(long cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }
    
    @Override
    public String toString() {
        return "Cpf: " + cpf + ", Nome: " + nome;
    }

        
}
