/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.dao;

import br.edu.qi.model.Carro;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author lg
 */
public class CarroDAO extends GenericDao<Carro, Serializable> {

    public CarroDAO() {
        super(new Carro());
    }

    @Override
    public void save(Carro carro) throws Exception {
        if (!find(carro)) {
            super.save(carro); //To change body of generated methods, choose Tools | Templates.
        } else {
            throw new Exception("Carro já cadastrado!");
        }
    }

    @Override
    public void update(Carro carro) throws Exception {
        if (!find(carro)) {
            super.update(carro);
        } else {
            throw new Exception("Não há alterações!");
        }
    }
    

    @Override
    public void delete(Carro carro) throws Exception {
        super.delete(carro); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Carro> findAll() throws Exception {
        return super.findAll(); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean find(Carro carro) throws Exception {
        return this.findAll().stream().anyMatch((carros) -> carros.equals(carro));
    }

    @Override
    public List<Carro> findAllWithoutClose() throws Exception {
        return super.findAllWithoutClose(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void closeSession() throws Exception {
        super.closeSession(); //To change body of generated methods, choose Tools | Templates.
    }

}
