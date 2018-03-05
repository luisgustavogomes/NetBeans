/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.model;

/**
 *
 * @author Luis Gustavo
 */
public interface IDao <T> {
     
    public void save(T t) throws Exception;
    
    public boolean find (T t );
     
}
