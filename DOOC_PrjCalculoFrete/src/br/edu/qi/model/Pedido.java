/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.model;

import br.edu.qi.util.HelperLocalDate;
import java.time.LocalDate;

/**
 *
 * @author lg
 */
public class Pedido {

    private int nro;
    private LocalDate data;
    private String cliente;
    private String vendedor;
    private double total;

    public Pedido(int nro, LocalDate data, String cliente, String vendedor, double total) {
        this.nro = nro;
        this.data = data;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.total = total;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    

    @Override
    public String toString() {
        return "Pedido{" + "nro=" + nro + ", data=" + HelperLocalDate.formatador(data) + ", cliente=" + cliente + ", vendedor=" + vendedor + ", total=" + total + '}';
    }

}
