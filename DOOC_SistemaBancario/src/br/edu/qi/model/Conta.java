package br.edu.qi.model;

import java.util.ArrayList;
import java.util.List;

public class Conta {

    protected double saldo;
    private List<Correntista> correntistas;

    public Conta(Correntista correntista) {
        this(correntista, 0);
    }

    public Conta(Correntista correntista, double saldo) {
        correntistas = new ArrayList<>();
        this.correntistas.add(correntista);
        this.saldo = saldo;
    }

    public List<Correntista> getCorrentistas() {
        return correntistas;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean retirar(double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            return true;
        } 
        return false;
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }

    @Override
    public String toString() {
        String nomeCorrentista = "";
        for (Correntista correntista : correntistas) {
            nomeCorrentista += correntista.getNome() + ", ";
        }
        nomeCorrentista = nomeCorrentista.substring(0, nomeCorrentista.length() - 2);
        return "Correntista:" + nomeCorrentista + " tem R$ " + saldo;

    }

}
