/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fis.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luis Gustavo
 */
public class GerenteBO implements IBo<Gerente> {

    List<Gerente> gerenteArr;

    public GerenteBO() {
        gerenteArr = new ArrayList<>();
    }

    @Override
    public boolean save(Gerente t) {
        return !find(t) ? gerenteArr.add(t) : false;
    }

    @Override
    public boolean find(Gerente t) {
        return gerenteArr.stream().anyMatch(g -> g.equals(t));
    }

    @Override
    public String getAll() {
        String str = null;
        for (Gerente g : gerenteArr) {
            str += g.toString() + ", \r\n";
        }
        if (str.length() > 0) {
            str = str.substring(4);
            str = str.substring(0,str.length() -3);
        }
        return str;
    }

}
