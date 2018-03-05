package algoritmoaula34exercicio02;

import java.util.Scanner;

public class AlgoritmoAula34Exercicio02 {

    public static void main(String[] args) {
        int idade;
        int anoAtual;
        int anoNascimento;
        
        Scanner teclado = new Scanner(System.in);
        System.out.print("Digite o ano de seu nascimento :");
        anoNascimento = teclado.nextInt();
        System.out.print("Digite o ano atual: ");
        anoAtual = teclado.nextInt();
        idade =  anoAtual - anoNascimento;
        System.out.println("Sua idade é: " + idade);
    }
    
}
