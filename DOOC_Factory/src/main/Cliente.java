/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author lg
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FabricaDeCarro fabrica;
        Carro carro;

        fabrica = new FabricaFiat();
        carro = fabrica.criarCarro();
        carro.exibirInfo();

        System.out.println();

        fabrica = new FabricaWolks();
        carro = fabrica.criarCarro();
        carro.exibirInfo();

        System.out.println();

        fabrica = new FabricaFord();
        carro = fabrica.criarCarro();
        carro.exibirInfo();

        System.out.println();

        fabrica = new FabricaChevrolet();
        carro = fabrica.criarCarro();
        carro.exibirInfo();
    }

}
