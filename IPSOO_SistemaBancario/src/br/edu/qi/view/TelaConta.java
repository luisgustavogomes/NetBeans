package br.edu.qi.view;

import br.edu.qi.model.Cheque;
import br.edu.qi.model.Conta;
import br.edu.qi.model.ContaCorrente;
import br.edu.qi.model.Correntista;

public class TelaConta {

    public static void main(String[] args) {
        Correntista correntista = new Correntista(111, "Fred");
        Conta conta = new Conta(new Correntista(222, "Luciano"), 100);
        ContaCorrente contaCorrente = new ContaCorrente(new Correntista(333, "João"), 1000, 100);

        System.out.println("Dados da conta");
        System.out.println(conta);
        System.out.println("Chamada do método retirar: " + conta.retirar(26));
        System.out.println(conta);
        divisor();
        System.out.println("Dados conta corrente");
        System.out.println(contaCorrente);
        System.out.println("Chamada do método retirar " + contaCorrente.retirar(200));
        System.out.println(contaCorrente);
        System.out.println("Deposito em dinheiro");
        contaCorrente.depositar(50);
        System.out.println(contaCorrente);
        System.out.println("Deposito em cheque");
        contaCorrente.depositar(new Cheque(60));
        System.out.println(contaCorrente);
        divisor();
        
    }
    
    public static void divisor(){
        System.out.println("=================================================\n");
    }
}
