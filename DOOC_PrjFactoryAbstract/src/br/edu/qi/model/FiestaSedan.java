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
public class FiestaSedan implements ICarroSedan{

    @Override
    public void exibirInfoSedan() {
        System.out.println("Modelo: Fiesta\nCategoria: Sedan\nFabricante: Ford");
    }
    
}
