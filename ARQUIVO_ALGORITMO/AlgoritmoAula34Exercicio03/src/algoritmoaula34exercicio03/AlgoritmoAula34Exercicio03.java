package algoritmoaula34exercicio03;

import java.util.Scanner;

public class AlgoritmoAula34Exercicio03 {

    public static void main(String[] args) {
        double salarioBruto;
        double valorPrestacao;

        Scanner teclado = new Scanner(System.in);
        System.out.print("Informe seu salário bruto: ");
        salarioBruto = teclado.nextDouble();
        System.out.print("Informe o valor da prestação: ");
        valorPrestacao = teclado.nextDouble();
        if (valorPrestacao > (salarioBruto * 0.2)) {
            System.out.println("Empréstimo não pode ser concedido");
        } else {
            System.out.println("Empréstimo concedido!");
        }
    }
}
