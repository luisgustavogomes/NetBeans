package algoritmoaula34exercicio05;

import java.util.Scanner;

public class AlgoritmoAula34Exercicio05 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Digite a nota do ano: ");
        double valorNotaAluno = teclado.nextDouble();
        System.out.print("Digite a frequencia do aluno:");
        double frequenciaAluno = teclado.nextDouble();
        if (frequenciaAluno >= 75) {
            if (valorNotaAluno >= 7 && frequenciaAluno >= 75) {
                System.out.println("Situação: Aluno Aprovado");
            } else if ((valorNotaAluno > 3 && valorNotaAluno < 7) && frequenciaAluno >= 75) {
                System.out.println("Situação: Aluno Exame");
            } else {
                System.out.println("Situação: Aluno Reprovado");
            }
        } else {
            System.out.println("Situação: Aluno Reprovado");
        }
    }

}
