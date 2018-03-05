/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecavirtual;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Aluno
 */
public class Principal {
    static Scanner teclado = new Scanner(System.in);
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int opcao = 0;
        while(true){
            System.out.println("MENU");
            System.out.println("1 - Add Livro");
            System.out.println("2 - Listar");
            opcao = teclado.nextInt();
            teclado.nextLine();
            
            switch(opcao){
                case 1: addLivro(); break;
                case 2: listar(); break;
            }
        }
    }

    private static void addLivro() {
        System.out.println("Digite o título:");
        String titulo = teclado.nextLine();
        System.out.println("Digite o autor:");                
        String autor = teclado.nextLine();
        System.out.println("Digite o ano:");
        int ano = teclado.nextInt();
        teclado.nextLine();
        GerenciadorLivro.adicionarLivro(titulo, autor, ano);
    }

    private static void listar() {
        List<Livro> livros = GerenciadorLivro.retornarTodosJSON();
        for(Livro livro : livros)
            System.out.println(livro);
    }
    
}
