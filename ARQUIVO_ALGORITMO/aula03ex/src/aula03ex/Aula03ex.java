package aula03ex;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Aula03ex {
    
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Random gerador = new Random();
        
        int x;
        
        System.out.print("Digite o tamanho do vetor: ");
        x = teclado.nextInt();
        
        int a [] = new int [x];
        
        for (int i = 0; i < a.length; i++) {
            System.out.println("Digite o " + (i+1) + "º valor: ");
            a[i] = gerador.nextInt(10);            
        }
        
        String veta = Arrays.toString(a);
        System.out.println(veta);
        
    }
}
