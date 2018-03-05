/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco2;

import entidades.ContaCorrente;
import entidades.ContaInvestimento;
import entidades.ContaPoupanca;
import entidades.ContaSalario;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author luizfduartejr
 */
public class GerenciadorBanco {
    
    private static ContaSalario contaAutenticada = null;
    private static List<ContaSalario> contas = new ArrayList<>();
    
    public static Collection<ContaSalario> retornarContas(){
        return contas;
    }
    
    public static boolean cadastrarContaSalario(int agencia, int numero, String senha){
        return cadastrarConta(new ContaSalario(numero, agencia, senha));
    }
    
    public static boolean cadastrarContaCorrente(int agencia, int numero, String senha, int limite){
        return cadastrarConta(new ContaCorrente(numero, agencia, senha, limite));
    }
    
    public static boolean cadastrarContaPoupanca(int agencia, int numero, String senha){
        return cadastrarConta(new ContaPoupanca(numero, agencia, senha));
    }
    
    public static boolean cadastrarContaInvestimento(int agencia, int numero, String senha, double rendimento){
        return cadastrarConta(new ContaInvestimento(numero, agencia, senha, rendimento));
    }
    
    private static boolean cadastrarConta(ContaSalario conta){
        if(contas.contains(conta))
            return false;
        
        contas.add(conta);
        return true;
    }
    
    public static boolean excluirConta(int agencia, int numero){
        return contas.removeIf(c -> c.equals(new ContaSalario(numero, agencia, "")));
    }

    static boolean autenticarConta(int agencia, int numero, String senha) {
         
        try{
            contaAutenticada = GerenciadorBanco.contas.stream().filter(c -> c.getAgencia() == agencia
                                        && c.getNumero() == numero
                                        && c.getSenha().equals(senha)).findFirst().get();
            return true;
        }
        catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    static boolean sacar(int valor) {
        return contaAutenticada.sacar(valor);
    }

    static boolean depositar(int valor) {
        return contaAutenticada.depositar(valor);
    }

    static boolean transferir(double valor, int agencia, int numero) {
        try{
            ContaSalario contaDestino = contas.stream().filter(c -> c.getAgencia() == agencia
                                                        && c.getNumero() == numero).findFirst().get();
            contaAutenticada.sacar(valor);
            contaDestino.depositar(valor);
            return true;
        }
        catch(Exception ex){
            return false;
        }
        
    }

    static double exibirSaldo() {
        return contaAutenticada.getSaldo();
    }

    static String getTipoContaAutenticada() {
        return contaAutenticada.getClass().getSimpleName();
    }
}
