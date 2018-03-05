/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author luizfduartejr
 */
public class Principal {
    public static void main(String[] args) {
        
        
      ListaEncadeada<Integer> lista = new ListaEncadeada<>();
      lista.inserir(10, 0);
      lista.imprimir();
        System.out.println("");
      lista.inserir(20, 1);
      lista.imprimir();
      System.out.println("");
      
      lista.inserir(30, 2);
      lista.imprimir();
      System.out.println("");
      
      lista.inserir(40, 1);
      lista.imprimir();
      System.out.println("");
      
      lista.inserir(50, 0);
         
        /*
          System.out.println("Gerando:");
        List<Integer> numeros = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int nro = (int)Math.floor(Math.random() * 3);
            System.out.print(nro + " ");
            numeros.add(nro);
        }
        System.out.println("");
        
        
        
        for(Integer i : numeros){
            int x = (int)Math.floor(Math.random() * 100);
            System.out.println("Conseguiu " + x + " na "+ i +"? " + lista.inserir(x, i)); 
            lista.imprimir();
        }
        
        System.out.println("Removendo:");
        lista.remover(lista.getTamanho()-1);*/
        lista.imprimir();
    }
}
