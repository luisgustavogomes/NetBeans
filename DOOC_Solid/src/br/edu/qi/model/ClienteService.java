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
public class ClienteService {
    
    public String adicionar(Cliente cliente){
        
        if (!cliente.isValid()) {
            return "Dados inválido";
        }
        ClienteRepository repository = new ClienteRepository();
        repository.adicionar(cliente);
        
        EmailService.send("tu", "de", "teste", "tomate cru!");
        return null;
    }
}
