/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Barbeiro;

import java.util.Random;

/**
 *
 * @author lg
 */
public class Barbeiro implements Runnable {

    private int cadeiraDeEspera;
    boolean cadeiraOcupada = false;
    int[] clientes;
    boolean barbeiroDorme = false;
    private String nome;
    private int cliNovos;
    int nClientes = 0;

    public Barbeiro(String nome, int cadeiraDeEspera, int clientes) {
        cliNovos = clientes;
        this.nome = nome;
        this.cadeiraDeEspera = cadeiraDeEspera;
        System.out.println("O " + nome + " chegou ao salão");
    }

    public void Clientes() {
        Random r = new Random();
        nClientes = r.nextInt(cliNovos);
        clientes = new int[nClientes];
        for (int i = 0; nClientes < clientes.length; i++) {
            clientes[i] = i;
        }
    }

    public void BarbeiroDorme() throws InterruptedException {
        System.out.println("Não existe(m) cliente(s) no salão no " + nome);
        System.out.println("O " + nome + " está esperando a chegada de clientes.");
        Thread.sleep(2000);
        Clientes();
    }

    public void BarbeiroAtende() throws InterruptedException {
        if (nClientes != 0) {
            if (nClientes > 1 && cadeiraOcupada == false) {
                System.out.println("Entrou (aram) " + nClientes + " cliente(s) no salão");
            } else {
                System.out.println("Existe(m) " + nClientes + " cliente(s) esperando atendimento do " + nome);
            }
            System.out.println("Um cliente ocupou a cadeira do " + nome);
            nClientes--;
            System.out.println("Um cliente está sendo atendido pelo " + nome);
            cadeiraOcupada = true;
            Thread.sleep(1000);
            if (nClientes > cadeiraDeEspera) {
                int cli = nClientes - cadeiraDeEspera;
                nClientes -= cli;
                for (int i = 0; i < clientes.length; i++) {
                    clientes[i] = 0;
                }
                for (int j = 0; j < nClientes; j++) {
                    clientes[j] = j + 1;
                }
                System.out.println(cli + " clientes foram embora");
                System.out.println(nClientes + " clientes estão esperando");
            }
            System.out.println("Um cliente já foi atendido pelo " + nome);
        } else if (nClientes == 1) {
            System.out.println("A cadeira do " + nome + " está livre");
            System.out.println("A cadeira do " + nome + " está ocupada, não existem clientes esperando");
            Thread.sleep(1000);
            nClientes--;
            System.out.println("Um cliente já foi atendido pelo " + nome);
        } else {
            System.out.println("A cadeira do " + nome + " está livre");
            cadeiraOcupada = false;
            
        }
    }

    @Override
    public void run() {
        while (true){
            if (nClientes <= 0){
                try{
                    BarbeiroDorme();
                }catch(InterruptedException i){
                    System.out.println(i);
                }
            } else {
                try{
                    BarbeiroAtende();
                } catch(InterruptedException i){
                    System.out.println(i);
                }
            }
        }
    }

}
