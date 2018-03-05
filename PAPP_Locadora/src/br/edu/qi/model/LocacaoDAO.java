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
public class LocacaoDAO {

    private List<LocacaoVO> locacaoArr;

    public LocacaoDAO() {
        locacaoArr = new ArrayList<>();
    }

    public List<LocacaoVO> getLocacaoArr() {
        return locacaoArr;
    }

    public void save(LocacaoVO locacao) throws Exception {
        if (!find(locacao)) {
            locacaoArr.add(locacao);
        } else {
            throw new Exception("Erro! Veiculo já locado");
        }
    }
    
    public void remove(LocacaoVO locacao) throws Exception{
        if (!find(locacao)) {
            locacaoArr.remove(locacao);
        } else {
            throw new Exception("Erro! Impossível remover");
        }
    }

    public boolean find(LocacaoVO locacao) {
        System.out.println(locacaoArr.stream().anyMatch(l -> l.getNroLocacao() == locacao.getNroLocacao()));
        System.out.println(locacaoArr);
        return locacaoArr.stream().anyMatch((LocacaoVO l) -> l.getNroLocacao() == locacao.getNroLocacao());
    }

    @Override
    public String toString() {
        String str = null;
        for (LocacaoVO e : locacaoArr) {
            str += e.toString() + ", \r\n";
        }
        if (str.length() > 0) {
            str = str.substring(4);
            str = str.substring(0, str.length() - 3);
        }
        return str;
    }
}
