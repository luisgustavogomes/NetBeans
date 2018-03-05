/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi;

import br.edu.qi.controller.CadEditController;
import br.edu.qi.view.CadEditView;

/**
 *
 * @author lg
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CadEditView cadEditView = new CadEditView(null, true);
        CadEditController cadEditController = new CadEditController(cadEditView);
        cadEditView.setVisible(true);
    }
    
}
