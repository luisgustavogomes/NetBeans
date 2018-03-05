/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.mail;

import br.edu.qi.controller.MatriculaController;
import br.edu.qi.view.CadastroMatriculaEditView;

/**
 *
 * @author Luis Gustavo
 */
public class MainApp {
    public static void main(String[] args) {
        CadastroMatriculaEditView cadastroMatriculaEditView =  new CadastroMatriculaEditView(null, true);
        MatriculaController matriculaController = new MatriculaController(cadastroMatriculaEditView);
        cadastroMatriculaEditView.setVisible(true);
    }
}
