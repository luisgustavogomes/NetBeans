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
public class Expresso implements Frete {

    private final double ALIQUOTAFRETEEXPRESSO = 10;

    @Override
    public double calcularFrete(Double totalPedido) {
       return (totalPedido * (ALIQUOTAFRETEEXPRESSO / 100));
    }

}
