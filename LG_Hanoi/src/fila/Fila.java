/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fila;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luizfduartejr
 */
public class Fila<T> {
    
    private List<T> fila = new ArrayList<>();
    
    public boolean enqueue(T valor){
        fila.add(valor);
        return true;
    }
    
    public T dequeue(){
        T valor = fila.get(0);
        fila.remove(0);
        return valor;
    }
}
