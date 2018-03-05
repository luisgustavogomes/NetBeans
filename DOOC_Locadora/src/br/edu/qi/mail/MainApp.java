/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.mail;

import br.edu.qi.controller.LocController;
import br.edu.qi.view.LocEditView;

/**
 *
 * @author Luis Gustavo
 */
public class MainApp {
    public static void main(String[] args) {
        LocEditView locEditView = new LocEditView(null, true);
        LocController locController = new LocController(locEditView);
        locEditView.setVisible(true);
    }
    
}
