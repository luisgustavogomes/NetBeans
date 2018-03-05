package br.edu.qi.model;

public class ContaCorrente extends Conta {

    private double limite;

    public ContaCorrente(Correntista correntista, double limite, double saldo) {
        super(correntista, saldo);
        this.limite = limite;
    }

    @Override
    public boolean retirar(double valor) {
        return (super.saldo + this.limite) >= valor ? super.retirar(valor) : false;
    }

    public void depositar(Cheque valor) {
        super.depositar(valor.getValor());
    }

}
