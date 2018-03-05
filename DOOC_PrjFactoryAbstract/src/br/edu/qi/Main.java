/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi;

import br.edu.qi.model.FabricaFiat;
import br.edu.qi.model.FabricaFord;
import br.edu.qi.model.ICarroPopular;
import br.edu.qi.model.ICarroSedan;
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
        // TODO code application logic here
        
        IFabricaCarro fabrica;
        ICarroPopular carroPopular;
        ICarroSedan carroSedan;
        
        fabrica = new FabricaFiat();
        carroPopular = fabrica.criarCarroPopular();
        carroSedan = fabrica.criarCarroSedan();
        
        carroPopular.exbirInfoPopular();
        barra();
        carroSedan.exibirInfoSedan();
        barra();
        
        fabrica = new FabricaFord();
        carroPopular = fabrica.criarCarroPopular();
        carroSedan = fabrica.criarCarroSedan();
        
        carroPopular.exbirInfoPopular();
        barra();
        carroSedan.exibirInfoSedan();
        barra();
    }
    
    public static void barra(){
        System.out.println("===========================");
    }
}
