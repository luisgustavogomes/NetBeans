package algoritmoaula36exercicio0;

import java.util.Scanner;

public class AlgoritmoAula36Exercicio0 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        

        int matriz[][] = new int[5][4];
        int mediaAluno[] = new int[5];
        int controlador = 0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                do {
                    System.out.print("Digite a " + (j + 1) + "º nota do " + (i + 1) + "º aluno: ");
                    matriz[i][j] = teclado.nextInt();
                    controlador += matriz[i][j];
                    if (matriz[i][j] > 10) {
                        System.out.println("Erro digite novamnte");
                        System.out.println("");
                    }
                } while (matriz[i][j] > 10);

            }
            mediaAluno[i] = controlador / 4;
            controlador = 0;
        }

        System.out.println("");

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("");
        }

        System.out.println("");

        for (int apresentarMedia : mediaAluno) {
            System.out.println("A media " + apresentarMedia);
        }
    }

}
