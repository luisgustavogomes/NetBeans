/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.model;

import br.edu.qi.dao.PagamentoDAO;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author lg
 */
public class PagamentoBO implements IBO<Pagamento> {

    private PagamentoDAO dao;

    public PagamentoBO() {
        dao = new PagamentoDAO();
    }

    @Override
    public void save(Pagamento pagamento) throws Exception {
        dao.save(pagamento);
    }
    
    public void save(List<Pagamento> pagtos) throws Exception{
        for (Pagamento pagto : pagtos) {
            this.save(pagto);
        }
    }

    @Override
    public void delete(Pagamento pagamento) throws Exception {
        dao.delete(pagamento);
    }

    @Override
    public List<Pagamento> findAll() throws Exception {
        return dao.findAll();
    }

    @Override
    public List<Pagamento> findAllWithoutClose() throws Exception {
        return dao.findAllWithoutClose();
    }
    
    public void update(Pagamento pagamento) throws Exception{
        dao.update(pagamento);
    }

    public BigDecimal GetNovoValorLiquido(Double juros, Double valorLiquido) {
        double vlr = juros + valorLiquido;
        BigDecimal vlrBigDecimal = new BigDecimal(vlr);
        return vlrBigDecimal;
    }
}
