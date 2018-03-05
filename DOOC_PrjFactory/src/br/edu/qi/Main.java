/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi;

import br.edu.qi.model.FabricaChevrotel;
import br.edu.qi.model.FabricaFiat;
import br.edu.qi.model.FabricaFord;
import br.edu.qi.model.FabricaVolkswagen;
import br.edu.qi.model.ICarro;
import br.edu.qi.model.IFabricaCarro;

/**
 *
 * @author lg
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        IFabricaCarro fabrica;
        ICarro carro;

        fabrica = new FabricaFiat();
        carro = fabrica.criarCarro();
        carro.exibirInfo();
        barra();

        fabrica = new FabricaVolkswagen();
        carro = fabrica.criarCarro();
        carro.exibirInfo();
        barra();

        fabrica = new FabricaFord();
        carro = fabrica.criarCarro();
        carro.exibirInfo();
        barra();

        fabrica = new FabricaChevrotel();
        carro = fabrica.criarCarro();
        carro.exibirInfo();
        barra();
        
    }

    public static void barra() {
        System.out.println("\n============================\n");
    }
}
