/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fila;

/**
 *
 * @author luizfduartejr
 */
public class Principal {
    public static void main(String[] args) {
        Fila<String> f = new Fila<>();
        f.enqueue("teste");
        f.enqueue("ola");
        f.enqueue("outro");
        
    }
}
