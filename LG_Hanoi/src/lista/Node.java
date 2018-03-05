/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista;

/**
 *
 * @author luizfduartejr
 */
public class Node<T extends Comparable<T>> implements Comparable<T> {
    
    T valor;
    Node<T> prox = null, ant = null;
    
    public Node(T valor){
        this.valor = valor;
    }

    @Override
    public int compareTo(T outroValor) {
        return this.valor.compareTo(outroValor);
    }
    
    @Override
    public String toString(){
        return this.valor.toString();
    }
}
