/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lg
 */
public class MovimentacaoDAO {

    private List<Movimentacao> contasArr;

    public MovimentacaoDAO() {
        this.contasArr = new ArrayList<>();
    }

    public void save(Movimentacao conta) throws Exception {
        contasArr.add(conta);
    }

    public List<Movimentacao> getContasArr() {
        return contasArr;
    }

}
