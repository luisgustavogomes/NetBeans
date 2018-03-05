/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luizfduartejr
 */
public class ListaEncadeada<T extends Comparable<T>> {
    
    private Node<T> inicio;
    private Node<T> fim;
    private int tamanho;
    
    public ListaEncadeada(){
        this.fim = this.inicio = null;
    }
    
    public boolean inserir(T valor, int index){
        if(index < 0 || index > this.tamanho)
            return false;
        
        if(this.isEmpty() || index == 0) return adicionarInicio(valor);
        if(index == tamanho) return adicionarFim(valor);
        
        
        Node node = new Node(valor);
        Node aux = this.inicio.prox;
        int i = 1;
        while(aux != null && i < index){
            aux = aux.prox;
            i++;
        }
        
        
        node.prox = aux;
        node.ant = aux.ant;
        aux.ant.prox = node;
        
        aux.ant = node;
        tamanho++;
        return true;
    }
    
    public boolean remover(int index){
        if(index < 0 || index > (this.tamanho-1)
                || this.isEmpty())
            return false;
        
        if(index == 0) return excluir(this.inicio.valor);
        if(index == (tamanho-1)) return excluir(this.fim.valor);
        
        Node aux = this.inicio.prox;
        Node penultimo = this.inicio;
        int i = 1;
        while(aux != null && i < index){
            penultimo = aux;
            aux = aux.prox;
            i++;
        }
        
        penultimo.prox = aux.prox;
        aux = null;
        tamanho--;
        return true;
    }
    
    public boolean inserir(T valor){
        Node node = new Node(valor);
        if(this.isEmpty()) return adicionarInicio(valor);
        
        Node nodeMaior = this.inicio;
        Node nodeAnterior = null;
        while(nodeMaior != null && 
                nodeMaior.compareTo(valor) < 0){
            nodeAnterior = nodeMaior;
            nodeMaior = nodeMaior.prox;
        }
        
        if(nodeMaior != null && 
                nodeMaior.compareTo(valor) >= 0){
            if(nodeAnterior == null)
                this.inicio = node;
            else
                nodeAnterior.prox = node;

            node.prox = nodeMaior;
        }
        else{
            nodeAnterior.prox = node;
            this.fim = node;
        }
        
        tamanho++;
        return true;
    }
    
    private boolean isEmpty(){
        return this.inicio == null;
    }
    
    public boolean adicionarFim(T valor){
        
        Node node = new Node(valor);
        if(isEmpty())
            this.inicio = this.fim = node;
        
        this.fim.prox = node;
        node.ant = fim;
        this.fim = node;
        tamanho++;
        return true;
    }
    
    public boolean adicionarInicio(T valor){
        Node node = new Node(valor);
        if(this.isEmpty()){
            this.fim = this.inicio = node; 
        }
        else{
            this.inicio.ant = node;
            node.prox = this.inicio;
            this.inicio = node;
        }
        tamanho++;
        return true;
    }
    
    public Node buscar(T valor){
        Node aux = this.inicio;
        while(aux != null && !aux.valor.equals(valor))
            aux = aux.prox;
        
        if(aux != null && aux.valor.equals(valor))
            return aux;
        else
            return null;
    }
    
    public List<T> buscarTodos(T valor){
        List<T> lista = new ArrayList<>();
        Node aux = this.inicio;
        while(aux != null){
            if(aux.valor.toString().contains(valor.toString()))
                lista.add((T)aux.valor);
            aux = aux.prox;
        }
        
        return lista;
    }
    
      
    public boolean excluir(T valor){
        if(isEmpty())
            return false;
        
        if(this.inicio.valor.equals(valor)) {//remove o primeiro
            this.inicio = this.inicio.prox;
            if(this.isEmpty())
                this.fim = null;
            return true;
        }
        
        Node aux = this.inicio;
        Node aux2 = null;
        
        while(aux != null && !aux.valor.equals(valor)){
            aux2 = aux;
            aux = aux.prox;
        }
            
        if(aux.prox == null){//remove o último
            aux2.prox = null;
            this.fim = aux2;
            return true;
        }
        else{
            aux2.prox = aux.prox;//remove do meio
            return true;
        }
    }
    
    public void imprimir(){
        if(this.inicio != null)
            System.out.println("Início:" + this.inicio.valor);
        System.out.println(this.toString());
        
        if(this.fim != null)
            System.out.println("Fim:" + this.fim.valor);
    }
    
    @Override
    public String toString(){
        String s = "";
        Node aux = this.inicio;
        while(aux != null){
            s+= aux.valor + " > ";
            aux = aux.prox;
        }
        return s;
    }

    int getTamanho() {
        return this.tamanho;
    }
}
