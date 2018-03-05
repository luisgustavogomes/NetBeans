/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilha;

/**
 *
 * @author luizfduartejr
 */
public class Principal {
    public static void main(String[] args) {
        Pilha X = new Pilha();
        Pilha Y = new Pilha();
        Pilha Z = new Pilha();
        
        X.push(Y.pop());
    }
}
