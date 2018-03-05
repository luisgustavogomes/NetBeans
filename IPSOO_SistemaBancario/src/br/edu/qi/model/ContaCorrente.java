package br.edu.qi.model;

public class ContaCorrente extends Conta {

    private double limite;

    public ContaCorrente(Correntista correntista, double limite, double saldo) {
        super(correntista, saldo);
        this.limite = limite;
    }

    @Override
    public boolean retirar(double valor) {
        return (super.saldo + this.limite) >= valor ? (this.saldo -= valor) >= this.saldo : false;
               
    }

    public void depositar(Cheque valor) {
        super.depositar(valor.getValor());
    }
    
    public void depositar(double valor) {
        super.depositar(valor);
    }
}
