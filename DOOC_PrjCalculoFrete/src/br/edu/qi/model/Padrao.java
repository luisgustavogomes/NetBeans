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
public class Padrao implements Frete {

    private final double ALIQUOTAFRETEPADRAO = 2;

    @Override
    public double calcularFrete(Double totalPedido) {
        return (totalPedido * (ALIQUOTAFRETEPADRAO / 100));
    }

}
