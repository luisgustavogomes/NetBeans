/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.dao;

import br.edu.qi.model.Pagamento;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author lg
 */
public class PagamentoDAO extends GenericDao<Pagamento, Serializable> {

    public PagamentoDAO() {
        super(new Pagamento());
    }

    @Override
    public void save(Pagamento e) throws Exception {
        super.save(e);
    }
    
    

    @Override
    public void delete(Pagamento e) throws Exception {
        super.delete(e); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pagamento> findAll() throws Exception {
        return super.findAll(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pagamento> findAllWithoutClose() throws Exception {
        return super.findAllWithoutClose(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Pagamento e) throws Exception {
        super.update(e); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
