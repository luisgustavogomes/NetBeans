package algoritmoaula34exercicio04;

import java.util.Random;
import java.util.Scanner;

public class AlgoritmoAula34Exercicio04 {

    public static void main(String[] args) {
        int numeroAleatorio;
        int numeroDigitado;
        
        Scanner teclado = new Scanner (System.in);
        Random gerador = new Random();
        
        numeroAleatorio  = gerador.nextInt(10)+1;
        
        System.out.println("O jogo de adivinhação...");
        System.out.print("Digite um número inteiro entre 1 e 10: ");
        numeroDigitado = teclado.nextInt();
        if (numeroDigitado == numeroAleatorio) {
            System.out.println("Parabéns! acertou o número!");            
        } else {
            System.out.println("Errou!, o número que pensei foi " + numeroAleatorio);
        }
        
        
        
    }
    
}
