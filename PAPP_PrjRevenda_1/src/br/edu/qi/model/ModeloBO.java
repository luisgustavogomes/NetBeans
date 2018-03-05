/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.model;

import br.edu.qi.dao.ModeloDAO;
import java.util.List;

/**
 *
 * @author lg
 */
public class ModeloBO implements IBO<Modelo> {

    private ModeloDAO dao;

    public ModeloBO() {
        this.dao = new ModeloDAO();
    }

    public void save(Modelo modelo) throws Exception {
        dao.save(modelo);
    }

    public void delete(Modelo modelo) throws Exception {
        dao.delete(modelo);
    }

    public List<Modelo> findAll() throws Exception {
        return dao.findAll();
    }

    public List<Modelo> findAllWithoutClose() throws Exception {
        return dao.findAllWithoutClose();
    }
    
    public void update(Modelo modelo) throws Exception{
        dao.update(modelo);
    }

}
