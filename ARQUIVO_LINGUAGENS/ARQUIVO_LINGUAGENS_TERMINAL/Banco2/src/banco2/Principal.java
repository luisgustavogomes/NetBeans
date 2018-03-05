/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco2;

import entidades.ContaPoupanca;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luizfduartejr
 */
public class Principal {

    private static Scanner teclado = new Scanner(System.in);
    
    private static int lerInt(){
        
        int x = 0;
        
        le:
        try{
            x = teclado.nextInt();
        }
        catch(Exception ex){
            System.out.println("Digite um número por favor...");
            break le;
        }
        
        teclado.nextLine();
        return x;
        
    }
    
    private static double lerDouble(){
        double x = 0;
        
        le:
        try{
            x = teclado.nextDouble();
        }
        catch(Exception ex){
            System.out.println("Digite um número decimal por favor...");
            break le;
        }
        
        teclado.nextLine();
        return x;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Path caminho = Paths.get(System.getProperty("user.dir"), "teste.txt");
        try {
            /*Files.write(caminho,
                    "teste".getBytes(),
                    StandardOpenOption.WRITE,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);*/
            List<String> linhas = Files.readAllLines(caminho);
            linhas.stream().forEach(c -> System.out.println(c));
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        /*
        cadastrarContasTeste();
        
        int opcao = 0;
        
        while(true){
            System.out.println("MENU");
            System.out.println("1 - Admin");
            System.out.println("2 - Cliente");
            System.out.println("3 - Sair");
            opcao = lerInt();
            if(opcao < 1 || opcao > 3){
                System.out.println("Digite uma opção válida!");
                continue;
            }
            else if(opcao == 1)
            {
                loginAdmin();
                //menu admin
                exibirMenuAdmin();
            }
            else if(opcao ==2){
                loginCliente();
                
                exibirMenuCliente();
            }
        }
        
       */
    }

    private static void exibirMenuAdmin() {
        int opcao = 0;
        while(opcao != 4){
            System.out.println("MENU ADMIN");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Excluir Cliente");
            System.out.println("3 - Listar Clientes");
            System.out.println("4 - Sair");
            opcao = lerInt();
            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    excluirCliente();
                    break;
                case 3:
                    listarClientes();
                    break;
                default:
                    break;
            }
        }
    }

    private static void cadastrarCliente() {
        System.out.println("Digite o tipo de conta:");
        System.out.println("1 - Salário");
        System.out.println("2 - Corrente");
        System.out.println("3 - Poupança");
        System.out.println("4 - Investimento");
        int tipoConta = lerInt();
        
        System.out.println("Digite a agência:");
        int agencia = lerInt();
        
        System.out.println("Digite o número:");
        int numero = lerInt();
        
        System.out.println("Digite a senha:");
        String senha = teclado.nextLine();
        
        boolean sucesso = false;
        
        if(tipoConta == 1)
            sucesso = GerenciadorBanco.cadastrarContaSalario(agencia, numero, senha);
        else if(tipoConta == 2){
            System.out.println("Digite o limite da conta-corrente:");
            int limite = lerInt();
            sucesso = GerenciadorBanco.cadastrarContaCorrente(agencia, numero, senha, limite);
        }
        else if(tipoConta == 3)
            sucesso = GerenciadorBanco.cadastrarContaPoupanca(agencia, numero, senha);
        else if(tipoConta == 4){
            System.out.println("Digite o rendimento do investimento:");
            double rendimento = lerInt();
            sucesso = GerenciadorBanco.cadastrarContaInvestimento(agencia, numero, senha, rendimento);
        }
        
        if(sucesso)
            System.out.println("Conta cadastrada com sucesso!");
        else
            System.out.println("Erro no cadastro da conta!");
    }

    private static void excluirCliente() {
        System.out.println("Digite a agência:");
        int agencia = lerInt();
        System.out.println("Digite o número:");
        int numero = lerInt();
        if(GerenciadorBanco.excluirConta(agencia, numero))
            System.out.println("Conta excluída com sucesso!");
        else
            System.out.println("Não foi possível excluir a conta!");
    }

    private static void loginAdmin() {
        while(true){
            System.out.println("Digite a senha de Admin:");
            if(teclado.nextLine().equals("123")){
                System.out.println("Autenticado com sucesso!");
                return;
            }
        }  
    }

    private static void listarClientes() {
        GerenciadorBanco.retornarContas().forEach(c -> System.out.println(c));
    }
    
    private static void cadastrarContasTeste(){
        GerenciadorBanco.cadastrarContaCorrente(1, 1, "1", 100);
        GerenciadorBanco.cadastrarContaInvestimento(2, 2, "2", 2);
        GerenciadorBanco.cadastrarContaPoupanca(3, 3, "3");
        GerenciadorBanco.cadastrarContaSalario(4, 4, "4");
    }

    private static void loginCliente() {
        while(true){
            System.out.println("Digite a agência:");
            int agencia = lerInt();
            System.out.println("Digite o número da conta:");
            int numero = lerInt();
            System.out.println("Digite a senha:");
            String senha = teclado.nextLine();
            boolean sucesso = GerenciadorBanco.autenticarConta(agencia, numero, senha);
            if(sucesso){
                System.out.println("Conta autenticada com sucesso!");
                return;
            }
        }
    }

    private static void exibirMenuCliente() {
        int opcao = 0;
        String tipoConta = GerenciadorBanco.getTipoContaAutenticada();
        while(opcao != 5){
            System.out.println("MENU Cliente");
            System.out.println("1 - Saque");
            System.out.println("2 - Depósito");
            
            if(!tipoConta.equals("ContaSalario"))
                System.out.println("3 - Transferência");
            
            System.out.println("4 - Saldo");
            System.out.println("5 - Sair");
            opcao = lerInt();
            switch(opcao){
                case 1: sacar();
                    break;
                case 2: depositar();
                    break;
                case 3: 
                    if(!tipoConta.equals("ContaSalario")) transferir();
                    break;
                case 4: exibirSaldo();
                default:
                    break;
            }
        }
    }

    private static void sacar() {
        System.out.println("Digite o valor do saque:");
        int valor = lerInt();
        boolean sucesso = GerenciadorBanco.sacar(valor);
        if(sucesso)
            System.out.println("Saque realizado com sucesso!");
        else
            System.out.println("Não foi possível efetuar o saque, consulte o saldo.");
    }

    private static void depositar() {
        System.out.println("Digite o valor do depósito:");
        int valor = lerInt();
        boolean sucesso = GerenciadorBanco.depositar(valor);
        if(sucesso)
            System.out.println("Depósito realizado com sucesso!");
        else
            System.out.println("Não foi possível efetuar o depósito");
    }

    private static void transferir() {
        System.out.println("Digite o valor da transferência:");
        double valor = lerDouble();
        System.out.println("Digite a agência da conta de destino:");
        int agencia = lerInt();
        System.out.println("Digite o número da conta de destino:");
        int numero = lerInt();
        boolean sucesso = GerenciadorBanco.transferir(valor, agencia, numero);
        if(sucesso)
            System.out.println("Transferência realizada com sucesso!");
        else
            System.out.println("Não foi possível efetuar a transferência");
    }

    private static void exibirSaldo() {
        double saldo = GerenciadorBanco.exibirSaldo();
        System.out.println("Seu saldo é: " + saldo);
    }
    
}
