/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.dao;

import br.edu.qi.model.Marca;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author lg
 */
public class MarcaDAO extends GenericDao<Marca, Serializable> {

    public MarcaDAO() {
        super(new Marca());
    }

    @Override
    public void save(Marca marca) throws Exception {
        if (!isValidation(marca)) {
            super.save(marca); //To change body of generated methods, choose Tools | Templates.
        } else {
            throw new Exception("Marca já cadastrada!");
        }
    }

    @Override
    public void delete(Marca marca) throws Exception {
        super.delete(marca); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Marca> findAll() throws Exception {
        return super.findAll(); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean isValidation(Marca marca) throws Exception {
        return this.findAll().stream().anyMatch((marcas) -> marcas.equals(marca));
    }

    @Override
    public List<Marca> findAllWithoutClose() throws Exception {
        return super.findAllWithoutClose(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Marca e) throws Exception {
        super.update(e); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
