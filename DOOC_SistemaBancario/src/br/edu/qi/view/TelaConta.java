package br.edu.qi.view;

import br.edu.qi.model.Conta;
import br.edu.qi.model.ContaCorrente;
import br.edu.qi.model.Correntista;

public class TelaConta {

    public static void main(String[] args) {
        Correntista correntista = new Correntista(111, "Fred");
        Conta conta = new Conta(new Correntista(222, "Luis"), 100);
        ContaCorrente contaCorrente = new ContaCorrente(new Correntista(333, "João"), 1000, 100);
        
        
        System.out.println(conta.toString());
        System.out.println(contaCorrente.toString());
        contaCorrente.retirar(26);
        System.out.println(contaCorrente.toString());
        contaCorrente.retirar(200);
        System.out.println(contaCorrente.toString());
        contaCorrente.depositar(50);
        System.out.println(contaCorrente.toString());
        contaCorrente.depositar(60);
        System.out.println(contaCorrente.toString());
    }
}
