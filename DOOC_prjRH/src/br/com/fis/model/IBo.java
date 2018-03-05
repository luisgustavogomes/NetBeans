/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fis.model;

/**
 *
 * @author Luis Gustavo
 */
public interface IBo<T> {

    public boolean save(T t);
    
    public boolean find(T t);

    public String getAll();
    
}
