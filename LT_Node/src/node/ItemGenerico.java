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
public abstract class ItemGenerico<T> implements Comparable<T>{

    public abstract String getPesquisa();
    
    public abstract int getIdentificador(); 

}
