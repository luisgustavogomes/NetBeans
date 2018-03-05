/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.equ.qi.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luis Gustavo
 */
public class ClienteDAO {

    private List<ClienteVO> clienteArr;

    public ClienteDAO() {
        clienteArr = new ArrayList<>();
    }

    public void save(ClienteVO cliente) throws Exception {
        if (!find(cliente)) {
            clienteArr.add(cliente);
        } else {
            throw new Exception("Cliente já cadastrado!");
        }
    }

    public List<ClienteVO> getClienteArr() {
        return clienteArr;
    }

    public boolean find(ClienteVO cliente) {
        return clienteArr.stream().anyMatch((ClienteVO c) -> c.getCodigo() == cliente.getCodigo());
    }

    
}
