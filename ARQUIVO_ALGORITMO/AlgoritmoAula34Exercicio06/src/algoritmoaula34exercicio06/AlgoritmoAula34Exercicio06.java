package algoritmoaula34exercicio06;

import java.util.Scanner;

public class AlgoritmoAula34Exercicio06 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("------------------------------------------------------------------");
        System.out.println("PROGRAMA CARPADIO");
        System.out.println("------------------------------------------------------------------");
        
        System.out.println("------------------------------------------------------------------");
        System.out.println("Escolha seu prato");
        System.out.println("Tipo: Vegetariano        180cal      [ 1 ]: ");
        System.out.println("Tipo: Peixe              230cal      [ 2 ]: ");
        System.out.println("Tipo: Frango             250cal      [ 3 ]: ");
        System.out.println("Tipo: Carne              350cal      [ 4 ]: ");
        System.out.print("Digite sua escolha:");
        int codigoPrato = teclado.nextInt();
        int caloriasPrato = 0;
        String nomePrato = null;
        switch (codigoPrato) {
            case 1:
                caloriasPrato = 180;
                nomePrato = "Vegetariano";
                break;
            case 2:
                caloriasPrato = 230;
                nomePrato = "Peixe";
                break;
            case 3:
                caloriasPrato = 250;
                nomePrato = "Frango";
                break;
            case 4:
                caloriasPrato = 350;
                nomePrato = "Carne";
                break;
        }
        
        System.out.println("------------------------------------------------------------------");
        System.out.println("Escolha sua sobremesa");
        System.out.println("Tipo: Abacaxi             75cal      [ 1 ] ");
        System.out.println("Tipo: Sorvete diet       110cal      [ 2 ] ");
        System.out.println("Tipo: Mouse diet         170cal      [ 3 ] ");
        System.out.println("Tipo: Mouse chocolate    350cal      [ 4 ] ");
        System.out.print("Digite sua escolha:");
        int codigoSobremesa = teclado.nextInt();
        int caloriasSobremesa = 0;
        String nomeSobremesa = null;
        switch (codigoSobremesa) {
            case 1:
                caloriasSobremesa = 75;
                nomeSobremesa = "Abacaxi";
                break;
            case 2:
                caloriasSobremesa = 110;
                nomeSobremesa = "Sorvete diet";
                break;
            case 3:
                caloriasSobremesa = 170;
                nomeSobremesa = "Mouse diet";
                break;
            case 4:
                caloriasSobremesa = 350;
                nomeSobremesa = "Mouse chocolate";
                break;
        }
        
        System.out.println("------------------------------------------------------------------");
        System.out.println("Escolha sua bedida");
        System.out.println("Tipo: Chá                 20cal      [ 1 ] ");
        System.out.println("Tipo: Suco de laranja     70cal      [ 2 ] ");
        System.out.println("Tipo: Suco de melão      100cal      [ 3 ] ");
        System.out.println("Tipo: Refrigerente diet   65cal      [ 4 ] ");
        System.out.print("Digite sua escolha:");
        int codigoBebida = teclado.nextInt();
        int caloriasBebida = 0;
        String nomeBebida = null;
        switch (codigoBebida) {
            case 1:
                caloriasBebida = 20;
                nomeBebida = "Chá";
                break;
            case 2:
                caloriasBebida = 70;
                nomeBebida = "Suco de laranja";
                break;
            case 3:
                caloriasBebida = 100;
                nomeBebida = "Suco de melão";
                break;
            case 4:
                caloriasBebida = 65;
                nomeBebida = "Refrigerente diet";
                break;
        }
        
        System.out.println("------------------------------------------------------------------");
        System.out.println("Seu pedido");
        System.out.println("Prato     : " + nomePrato);
        System.out.println("Sobremesa : " + nomeSobremesa);
        System.out.println("Bebida    : " + nomeBebida);
        System.out.println("Quantidade de calorias : " + (caloriasBebida + caloriasPrato + caloriasSobremesa));
        
    }
}
