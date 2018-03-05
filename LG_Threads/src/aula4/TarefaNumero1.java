/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula4;

/**
 *
 * @author lg
 */
public class TarefaNumero1 implements Runnable {

    private Banheiro banheiro;

    public TarefaNumero1(Banheiro banheiro) {
        this.banheiro = banheiro;
    }
    
   
    @Override
    public void run() {
        banheiro.FazNumero1();
    }
    
}
