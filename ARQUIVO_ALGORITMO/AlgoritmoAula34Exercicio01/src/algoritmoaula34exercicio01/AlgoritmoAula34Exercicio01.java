
package algoritmoaula34exercicio01;

import java.util.Scanner;

public class AlgoritmoAula34Exercicio01 {

    public static void main(String[] args) {
        int diaSemana;
        String nomeDiaSemana;
        
        Scanner teclado = new Scanner (System.in);
        System.out.print("Digite o número: ");
        diaSemana = teclado.nextInt();
        switch (diaSemana){
            case 1:
                nomeDiaSemana = "Domingo";
                break;
            case 2:
                nomeDiaSemana = "Segunda-feira";
                break;
            case 3:
                nomeDiaSemana = "Terça-feira";
                break;
            case 4:
                nomeDiaSemana = "Quarta-feira";
                break;
            case 5:
                nomeDiaSemana = "Quinta-feira";
                break;
            case 6:
                nomeDiaSemana = "Sexta-feira";
                break;
            case 7: 
                nomeDiaSemana = "Sábado";
                break;
            default: nomeDiaSemana= "Não existe dia da semana com esse valor";   
        }
        System.out.println("O número digitado corresponde a " + nomeDiaSemana );
    }
}
