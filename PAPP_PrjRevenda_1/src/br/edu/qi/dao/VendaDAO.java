/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.dao;

import br.edu.qi.model.Venda;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author lg
 */
public class VendaDAO extends GenericDao<Venda, Serializable> {

    public VendaDAO() {
        super(new Venda());
    }

    @Override
    public void save(Venda venda) throws Exception {

        if (!isValidation(venda)) {
            super.save(venda);
        } else {
            throw new Exception("Venda já cadastrada!");
        }

    }

    @Override
    public List<Venda> findAll() throws Exception {
        return super.findAll(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Venda> findAllWithoutClose() throws Exception {
        return super.findAllWithoutClose(); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean isValidation(Venda venda) throws Exception {
        return this.findAll().stream().anyMatch((vendas) -> vendas.equals(venda));
    }

    @Override
    public void closeSession() throws Exception {
        super.closeSession(); //To change body of generated methods, choose Tools | Templates.
    }

}
