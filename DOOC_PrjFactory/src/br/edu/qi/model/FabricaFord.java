/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.model;

/**
 *
 * @author lg
 */
public class FabricaFord implements IFabricaCarro{

    @Override
    public ICarro criarCarro() {
        return new Fiesta();
    }
    
}
