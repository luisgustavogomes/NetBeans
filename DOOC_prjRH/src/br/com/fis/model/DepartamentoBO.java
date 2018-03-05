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
public class DepartamentoBO implements IBo<Departamento> {

    private List<Departamento> departamentoArr;

    public DepartamentoBO() {
        this.departamentoArr = new ArrayList<>();
    }

    @Override
    public boolean save(Departamento depto) {
        return !find(depto) ? departamentoArr.add(depto) : false;
    }

    @Override
    public String getAll() {
        String str = null;
        for (Departamento d : departamentoArr) {
            str += d.toString() + ",\r\n";
        }
        if (str.length() > 0) {
            str = str.substring(4);
            str = str.substring(0,str.length() -3);
        }
        return str;
    }

    @Override
    public boolean find(Departamento depto) {
        return departamentoArr.stream().anyMatch(d -> d.equals(depto));
    }

}
