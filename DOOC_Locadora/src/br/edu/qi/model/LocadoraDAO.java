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
public class LocadoraDAO implements IDao<LocadoraVO>{

    private List<LocadoraVO> locadoraArr;

    public LocadoraDAO() {
        this.locadoraArr = new ArrayList<>();
    }
    
    
    public List<LocadoraVO> getLocadoraArr() {
        return locadoraArr;
    }

    @Override
    public void save(LocadoraVO locadora) throws Exception {
        if (!find(locadora)) {
            this.locadoraArr.add(locadora);
        } else {
            throw new Exception("Locação já cadastrada!");
        }
    }

    @Override
    public boolean find(LocadoraVO locadora) {
        return locadoraArr.stream().anyMatch((LocadoraVO l) -> l.getNroLocacao() == locadora.getNroLocacao());
    }

}
