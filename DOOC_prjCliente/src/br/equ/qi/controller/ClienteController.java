/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.equ.qi.controller;

import br.equ.qi.model.ClienteBO;
import br.equ.qi.model.ClienteVO;
import br.equ.qi.utl.HelperNumbers;
import br.equ.qi.view.ClienteEditView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis Gustavo
 */
public class ClienteController implements ActionListener{
    
    private ClienteEditView clienteEditView;
    private ClienteBO cliente;
    
    public ClienteController(ClienteEditView clienteEditView) {
        this.clienteEditView = clienteEditView;
        this.cliente = new ClienteBO();
        this.clienteEditView.getBtnGravar().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        try{
            validation();
            this.cliente.save(new ClienteVO(
                    Integer.parseInt(clienteEditView.getTxtCodigo().getText()), 
                    clienteEditView.getTxtNome().getText(), 
                    clienteEditView.getTxtEndereco().getText(), 
                    clienteEditView.getTxtBairro().getText(), 
                    clienteEditView.getTxtCidade().getText(), 
                    clienteEditView.getCbUF().getSelectedObjects().toString()));
            JOptionPane.showMessageDialog(null, "Gravação com sucesso!");
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    private void validation () throws Exception{
        if(!HelperNumbers.isNumeric(clienteEditView.getTxtCodigo().getText())){
            throw new Exception("Número inválido!");
        }
        if(this.clienteEditView.getTxtNome().getText().trim().length() == 0){
            throw new Exception("Informe um nome!");
        }
        if(this.clienteEditView.getTxtEndereco().getText().trim().length() == 0){
            throw new Exception("Informe um endereco!");
        }
        if(this.clienteEditView.getTxtBairro().getText().trim().length() == 0){
            throw new Exception("Informe um bairro!");
        }
        if(this.clienteEditView.getTxtCidade().getText().trim().length() == 0){
            throw new Exception("Informe uma cidade!");
        }
        if(this.clienteEditView.getCbUF().getSelectedIndex() == 0){
            throw new Exception("Informe um UF!");
        }
    }
    
    
}
