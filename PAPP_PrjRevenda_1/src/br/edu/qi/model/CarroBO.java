/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.model;

import br.edu.qi.dao.CarroDAO;
import java.util.List;

/**
 *
 * @author lg
 */
public class CarroBO implements IBO<Carro> {

    private CarroDAO dao;

    public CarroBO() {
        this.dao = new CarroDAO();
    }

    @Override
    public void save(Carro carro) throws Exception {
        dao.save(carro);
    }
    
    public void update (Carro carro) throws Exception{
        dao.update(carro);
    }

    @Override
    public void delete(Carro carro) throws Exception {
        dao.delete(carro);
    }

    @Override
    public List<Carro> findAll() throws Exception {
        return dao.findAll();
    }

    @Override
    public List<Carro> findAllWithoutClose() throws Exception {
        return dao.findAllWithoutClose();
    }

    public void closeSession() throws Exception {
        dao.closeSession();
    }

}
