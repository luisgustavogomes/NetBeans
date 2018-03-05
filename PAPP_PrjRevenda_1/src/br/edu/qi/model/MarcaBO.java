/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.model;

import br.edu.qi.dao.MarcaDAO;
import java.util.List;

/**
 *
 * @author lg
 */
public class MarcaBO implements IBO<Marca> {

    private MarcaDAO dao;

    public MarcaBO() {
        this.dao = new MarcaDAO();
    }

    @Override
    public void save(Marca marca) throws Exception {
        dao.save(marca);
    }

    @Override
    public void delete(Marca marca) throws Exception {
        dao.delete(marca);
    }

    @Override
    public List<Marca> findAll() throws Exception {
        return dao.findAll();
    }

    @Override
    public List<Marca> findAllWithoutClose() throws Exception {
        return dao.findAllWithoutClose();
    }
    
    public void update(Marca marca) throws Exception {
        dao.update(marca);
    }
}
