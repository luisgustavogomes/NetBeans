/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author lg
 */
public class TarefaBuscaTextual implements Runnable {

    private String nomearquivo;
    private String nome;

    public TarefaBuscaTextual(String nomearquivo, String nome) {
        this.nomearquivo = nomearquivo;
        this.nome = nome;
    }

    @Override
    public void run() {
        try {
            Scanner scanner = new Scanner(new File(nomearquivo));
            int numeroLinha = 1;
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                if (linha.toLowerCase().contains(nome.toLowerCase())) {
                    System.out.println(nomearquivo + " - " + numeroLinha + " - " + linha);
                }
                numeroLinha++;
            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

}
