/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.dao;

import br.edu.qi.model.Modelo;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author lg
 */
public class ModeloDAO extends GenericDao<Modelo, Serializable> {

    public ModeloDAO() {
        super(new Modelo());
    }

    @Override
    public void save(Modelo modelo) throws Exception {
        if (!isValidation(modelo)) {
            super.save(modelo); //To change body of generated methods, choose Tools | Templates.
        } else {
            throw new Exception("Modelo já cadastrado!");
        }
    }

    @Override
    public void delete(Modelo modelo) throws Exception {
        super.delete(modelo); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Modelo> findAll() throws Exception {
        return super.findAll(); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean isValidation(Modelo modelo) throws Exception {
        return this.findAll().stream().anyMatch((modelos) -> modelos.equals(modelo));
    }

    @Override
    public List<Modelo> findAllWithoutClose() throws Exception {
        return super.findAllWithoutClose(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Modelo e) throws Exception {
        super.update(e); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
