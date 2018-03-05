/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fis.utl;

import java.util.Scanner;

/**
 *
 * @author Luis Gustavo
 */
public class Teclado {

    private static Scanner teclado = new Scanner(System.in);

    public static String lerString() {
        return teclado.nextLine();
    }

    public static int lerInteiro() {
        try {
            return Integer.parseInt(lerString());
        } catch (RuntimeException on) {
            throw new RuntimeException("Erro!");
        }
    }

    public static long lerlong() {
        try {
            return Long.parseLong(lerString());
        } catch (RuntimeException on) {
            throw new RuntimeException("Erro!");
        }
    }
}
