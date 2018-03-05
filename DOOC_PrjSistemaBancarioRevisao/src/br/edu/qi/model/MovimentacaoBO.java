/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.model;

/**
 *
 * @author lg
 */
public class MovimentacaoBO {

    private static MovimentacaoBO intancia;
    private static MovimentacaoDAO dao;

    private MovimentacaoBO() {
    }

    public static MovimentacaoBO getInstancia() {
        if (intancia == null) {
            intancia = new MovimentacaoBO();
            dao = new MovimentacaoDAO();
        }
        return intancia;
    }

    public void save(Movimentacao conta) throws Exception {
        dao.save(conta);
    }

    public double depositar(Movimentacao obj) throws Exception {
        obj.setSaldo(obj.getSaldo() + obj.getValor());
        this.dao.save(obj);
        return obj.getSaldo();
    }

    public double sacar(Movimentacao obj) throws Exception {
        if (obj.getValor() > (obj.getSaldo() + obj.getLimite())) {
            throw new Exception("O valor de saque não pode ser superior");
        }
        obj.setSaldo(obj.getSaldo() - obj.getValor());
        this.dao.save(obj);
        return obj.getSaldo();
    }
    
    public double getSaldo(Movimentacao obj){
        return this.dao.getContasArr().get(dao.getContasArr().size() -1).getSaldo();
    }

}
