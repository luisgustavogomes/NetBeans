/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package node;

import view.FrmAlunos;

/**
 *
 * @author Luis Gustavo
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        carregaDados();
        
        FrmAlunos frmAlunos = new FrmAlunos();
        frmAlunos.setVisible(true);
        
    }

    private static void carregaDados() {
        Lista.isCarregarAluno();
    }

}
