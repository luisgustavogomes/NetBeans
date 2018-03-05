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
public class Movimentacao {

      
    
    private Integer nroConta;
    private Integer nroAgencia;
    private Double valor;
    private Double saldo;
    private Double limite;
    private String operacao;

    public Movimentacao(Integer nroConta, Integer nroAgencia, Double valor, Double saldo, Double limite, String operacao) {
        this.nroConta = nroConta;
        this.nroAgencia = nroAgencia;
        this.valor = valor;
        this.saldo = saldo;
        this.limite = limite;
        this.operacao = operacao;
    }

    

    public Integer getNroConta() {
        return nroConta;
    }

    public void setNroConta(Integer nroConta) {
        this.nroConta = nroConta;
    }

    public Integer getNroAgencia() {
        return nroAgencia;
    }

    public void setNroAgencia(Integer nroAgencia) {
        this.nroAgencia = nroAgencia;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    
    
    
    

}
