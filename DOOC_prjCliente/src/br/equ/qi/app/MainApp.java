/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.equ.qi.app;

import br.equ.qi.controller.ClienteController;
import br.equ.qi.view.ClienteEditView;

/**
 *
 * @author Luis Gustavo
 */
public class MainApp {
     public static void main(String[] args) {
         ClienteEditView clienteEditView = new ClienteEditView(null, true);
         ClienteController clienteController = new ClienteController(clienteEditView);
         clienteEditView.setVisible(true);
    }
   
}
