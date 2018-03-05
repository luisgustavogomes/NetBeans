package algoritmoaula38exercicio01;

import java.util.Random;
import java.util.*;

public class AlgoritmoAula38Exercicio01 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int[][] matriz = new int[5][5];
        int verificadorUsuario;
        int somaColuna=0;
        int somaLinha=0;
        matriz = retornaMatriz();
        
        do{
        verificadorUsuario = 0;
        System.out.print("Digite um número entre 1 e 5: ");
        verificadorUsuario = teclado.nextInt();
        verificadorUsuario -= 1;
            if (verificadorUsuario < 0 || verificadorUsuario > 4) {
                System.out.println("\nErro...Repita!");
            }
        } while (verificadorUsuario < 0 || verificadorUsuario > 4);
        
        System.out.println("\nMatriz\n");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println("");
        }
        
        System.out.println("\nTodos os elementos da linha escolhida\n");
        System.out.println("Linha");
        for (int j = 0; j < matriz[0].length; j++) {
            System.out.print( matriz[verificadorUsuario][j] + "\t");
            somaLinha += matriz[verificadorUsuario][j];
        }
        
        System.out.println("\nTodos os elementos da coluna escolhida\n");
        System.out.println("Coluna");
        for (int i = 0; i < matriz.length; i++) {
            System.out.println( matriz[i][verificadorUsuario] + "\t");
            somaColuna += matriz[i][verificadorUsuario];
        }
        
        System.out.println("\nSoma da Linha escolhida: "+ somaLinha );
        System.out.println("\nSoma da Coluna escolhida: "+ somaColuna );
                

    }

    public static int[][] retornaMatriz() {
        Random gerador = new Random();
        int[][] matriz = new int[5][5];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = gerador.nextInt(100);
            }
        }
        return (matriz);
    }

}
