/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.model;

import br.edu.qi.utl.HelperNumbers;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luis Gustavo
 */
public class LocacaoBO {

    private LocacaoDAO dao;

    public LocacaoBO() {
        dao = new LocacaoDAO();
    }

    public void save(LocacaoVO locacao) throws Exception {
        dao.save(locacao);
    }
    
    public void remove(LocacaoVO locacao) throws Exception{
        dao.remove(locacao);
    }

    public double resultado(int qtdeDias, double valor, double multa, int qtdeDiasAtrasado, boolean avista) {

        double total = qtdeDias * valor;
        double totalMulta = 0;

        if (multa > 0 && qtdeDiasAtrasado > 0) {
            totalMulta = qtdeDiasAtrasado * multa;
        }

        if (avista) {
            return ((total + totalMulta) - ((total + totalMulta) * 0.1));
        } else {
            return (total + totalMulta);
        }

    }

}
