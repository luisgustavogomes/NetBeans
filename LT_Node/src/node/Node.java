/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package node;

/**
 *
 * @author Luis Gustavo
 */
public class Node<T extends Comparable> implements Comparable<T>  {
    
    public T valor;
    public Node<T> proximo;
    public Node<T> anterior;
    
    public Node(T valor) {
        this.valor = valor;
        this.proximo = this.anterior = null;
    }

    @Override
    public String toString() {
        return this.valor.toString();
    }

    @Override
    public int compareTo(T o) {
        return this.valor.compareTo(o);
    }

           
    
}
