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
public class LocadoraBO {
    
    private LocadoraDAO dao;

    public LocadoraBO() {
        this.dao = new LocadoraDAO();
    }
    
    public void save(LocadoraVO locadora) throws Exception{
        this.dao.save(locadora);
    }
    
    
}
