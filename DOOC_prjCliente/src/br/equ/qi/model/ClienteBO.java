/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.equ.qi.model;

/**
 *
 * @author Luis Gustavo
 */
public class ClienteBO {
    
    private ClienteDAO cliente;

    public ClienteBO() {
        this.cliente = new ClienteDAO();
    }
    
    public void save (ClienteVO cliente) throws Exception{
        this.cliente.save(cliente);
    }
}
