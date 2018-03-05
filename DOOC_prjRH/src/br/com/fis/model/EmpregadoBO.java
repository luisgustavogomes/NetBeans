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
public class EmpregadoBO implements IBo<Empregado> {

    private List<Empregado> empregadoArr;

    public EmpregadoBO() {
        empregadoArr = new ArrayList<>();
    }

    @Override
    public boolean save(Empregado emp) {
        return !find(emp) ? empregadoArr.add(emp) : false;
    }

    @Override
    public boolean find(Empregado emp) {
        return empregadoArr.stream().anyMatch(e -> e.equals(emp));
    }

    @Override
    public String getAll() {
        String str = null;
        for (Empregado e : empregadoArr) {
            str += e.toString() + ", \r\n";
        }
        if (str.length() > 0) {
            str = str.substring(4);
            str = str.substring(0,str.length() -3);
        }
        return str;
    }

}
