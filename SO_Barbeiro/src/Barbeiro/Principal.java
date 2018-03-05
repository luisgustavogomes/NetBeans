/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Barbeiro;

/**
 *
 * @author lg
 */
public class Principal {
    public static void main(String[] args) {
        Barbeiro b = new Barbeiro("Barbeiro Luis", 2, 5);
        Thread threadB = new Thread(b);
        threadB.start();
    }
}
