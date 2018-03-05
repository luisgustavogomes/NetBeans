package algoritmoaula38exercicio02;

import java.util.Random;
import java.util.Scanner;
import java.text.DecimalFormat;

public class AlgoritmoAula38Exercicio02 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        DecimalFormat decimal = new DecimalFormat("#.00");
        double[] salario = new double[14];
        double totalSalario = 0;
        double mediaSalario = 0;
        int contadorMedia = 0;

        salario = vetorSalario();

        for (int i = 0; i < salario.length; i++) {
            totalSalario += salario[i];
        }
        mediaSalario = totalSalario / salario.length;

        System.out.println("Tabela salarios\n");
        for (double mostrarSalario : salario) {
            System.out.println("Salário: R$ " + decimal.format(mostrarSalario));
        }

        System.out.println("\nTabela acima da média: R$ " + decimal.format(mediaSalario) + "\n");
        for (int i = 0; i < salario.length; i++) {
            if (salario[i] > mediaSalario) {
                System.out.println("Salario: R$ " + decimal.format(salario[i]));
                contadorMedia++;
            }
        }
        System.out.println("\nQuantidade de funcionarios acima da media: " + contadorMedia);

    }

    public static double[] vetorSalario() {
        Random gerador = new Random();
        double[] salario = new double[14];
        for (int i = 0; i < salario.length; i++) {
            salario[i] = gerador.nextDouble() * 10000;
        }
        return (salario);
    }
}
