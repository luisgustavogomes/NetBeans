/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula3;

/**
 *
 * @author lg
 */
public class Main {
    
    public static void main(String[] args) {
        
        String nome ="da";
        Thread threadAssinaturas1 = new Thread(new TarefaBuscaTextual("assinaturas1.txt", nome));
        Thread threadAssinaturas2 = new Thread(new TarefaBuscaTextual("assinaturas2.txt", nome));
        Thread threadAutores = new Thread(new TarefaBuscaTextual("autores.txt", nome));
        
        threadAssinaturas1.start();
        threadAssinaturas2.start();
        threadAutores.start();
        
    }
    

}
