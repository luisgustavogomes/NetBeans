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
 * @author Luis Gustavo
 */
public class FuncionarioBO {

    private List<FuncionarioVO> funcionarioArr;

    public FuncionarioBO() {
        funcionarioArr = new ArrayList<>();
    }

    public void save(FuncionarioVO func) throws Exception{
        if (!find(func)) {
            funcionarioArr.add(func);
        } else {
            throw new Exception("Funcionário já cadastrado!");
        }
       
    }

    public boolean find(FuncionarioVO func) {
        return funcionarioArr.stream().anyMatch(f -> f.getMatricula() == func.getMatricula());
    }
    
    
    public List<FuncionarioVO> getFuncionarioArr() {
        return funcionarioArr;
    }

    @Override
    public String toString() {
        String str = null;
        for (FuncionarioVO e : funcionarioArr) {
            str += e.toString() + ", \r\n";
        }
        if (str.length() > 0) {
            str = str.substring(4);
            str = str.substring(0, str.length() - 3);
        }
        return str;
    }

}
