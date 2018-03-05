/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi;

import br.edu.qi.controller.MovEditController;
import br.edu.qi.view.MovEditView;

/**
 *
 * @author lg
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MovEditView editView = new MovEditView(null, true);
        MovEditController editController = new MovEditController(editView);
        editView.setVisible(true);
    }
    
}
