/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.model;

import br.edu.qi.dao.VendaDAO;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author lg
 */
public class VendaBO implements IBO<Venda> {

    private VendaDAO dao;
    private PagamentoBO pagamentoBo = new PagamentoBO();

    public VendaBO() {
        dao = new VendaDAO();
    }

    @Override
    public void save(Venda venda) throws Exception {
        if (!find(venda)) {
            dao.save(venda);
        } else {
            throw new Exception("Venda já cadastrada!");
        }
    }

    @Override
    public void delete(Venda venda) throws Exception {
        dao.delete(venda);
    }

    @Override
    public List<Venda> findAll() throws Exception {
        return dao.findAll();
    }

    @Override
    public List<Venda> findAllWithoutClose() throws Exception {
        return dao.findAllWithoutClose();
    }

    public List<Pagamento> parcelas(int nroVenda,Venda venda, Date dataVenda, BigDecimal valorVenda, int numeroParcelas) throws Exception {
        double vlr = valorParcela(valorVenda, numeroParcelas);
        BigDecimal valorPar = new BigDecimal(vlr);
        List<Pagamento> pagtoArr = new ArrayList<>(numeroParcelas);
        for (int i = 0; i < numeroParcelas; i++) {
            Pagamento p = new Pagamento(
                    nroVenda + "/" + (i + 1),
                    venda,
                    calcularDataVencimento(dataVenda, (i + 1)),
                    valorPar);
            pagtoArr.add(p);
        }
        return pagtoArr;
    }

    private Double valorParcela(BigDecimal valorVenda, int numeroParcelas) {
        Double valor = valorVenda.doubleValue();
        return valor / numeroParcelas;
    }

    private Date calcularDataVencimento(Date datavenda, int mes) {
        Calendar c = Calendar.getInstance();
        c.setTime(datavenda);
        c.add(Calendar.MONTH, mes);
        return c.getTime();
    }

    public void closeSession() throws Exception {
        dao.closeSession();
    }

    private boolean find(Venda venda) throws Exception {
        return this.findAll().stream().anyMatch((vendas) -> vendas.equals(venda));
    }

}
