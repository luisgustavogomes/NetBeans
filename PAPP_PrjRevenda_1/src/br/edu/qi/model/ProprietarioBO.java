/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.model;

import br.edu.qi.dao.ProprietarioDAO;
import java.util.List;

/**
 *
 * @author lg
 */
public class ProprietarioBO implements IBO<Proprietario> {

    private ProprietarioDAO dao;

    public ProprietarioBO() {
        this.dao = new ProprietarioDAO();
    }

    @Override
    public void save(Proprietario proprietario) throws Exception {
        dao.save(proprietario);
    }

    @Override
    public void delete(Proprietario proprietario) throws Exception {
        dao.delete(proprietario);
    }

    @Override
    public List<Proprietario> findAll() throws Exception {
        return dao.findAll();
    }

    @Override
    public List<Proprietario> findAllWithoutClose() throws Exception {
        return dao.findAllWithoutClose();
    }

}
