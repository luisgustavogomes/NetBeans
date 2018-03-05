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
public class MultaDAO {

    private List<MultaVO> multas;

    public MultaDAO() {
        this.multas = new ArrayList<>();
    }

    public void save(MultaVO multaVO) throws Exception {
        if (!find(multaVO)) {
            multas.add(multaVO);
        } else {
            throw new Exception("Multa já cadastrada!");
        }
    }

    public boolean find(MultaVO multaVO) {
        return multas.stream().anyMatch(m -> m.equals(multaVO));
    }

    public List<MultaVO> getMultas() {
        return multas;
    }

}
