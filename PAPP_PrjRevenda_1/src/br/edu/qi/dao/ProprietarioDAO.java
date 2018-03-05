/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.dao;

import br.edu.qi.model.Proprietario;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author lg
 */
public class ProprietarioDAO extends GenericDao<Proprietario, Serializable> {

    public ProprietarioDAO() {
        super(new Proprietario());
    }

    @Override
    public void save(Proprietario proprietario) throws Exception {
        if (!isValidation(proprietario)) {
            super.save(proprietario); //To change body of generated methods, choose Tools | Templates.
        } else {
            throw new Exception("Proprietário já cadastrado!");
        }
    }

    @Override
    public void delete(Proprietario proprietario) throws Exception {
        super.delete(proprietario); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Proprietario> findAll() throws Exception {
        return super.findAll(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Proprietario> findAllWithoutClose() throws Exception {
        return super.findAllWithoutClose(); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean isValidation(Proprietario proprietario) throws Exception {
        return this.findAll().stream().anyMatch((prop) -> prop.equals(proprietario));
    }

}
