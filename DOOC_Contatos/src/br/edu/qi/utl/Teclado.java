package br.edu.qi.utl;

import java.util.Scanner;

public class Teclado {

    private static Scanner teclado = new Scanner(System.in);

    public Teclado() {
    }

    public static String lerString() {
        return teclado.nextLine();
    }

    public static int lerInteiro() {
        int numero = 0;
        try {
            numero = teclado.nextInt();
            teclado.nextLine();
        } catch (Exception on) {
            throw new RuntimeException("Erro!");
        }
        return numero;
    }
}
