/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.view;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author lg
 */
public class LocadoraModel {

    private SimpleIntegerProperty nroLocacao = new SimpleIntegerProperty();
    private SimpleStringProperty veiculo = new SimpleStringProperty();
    private SimpleDoubleProperty valor = new SimpleDoubleProperty();
    private SimpleIntegerProperty qtdeDias = new SimpleIntegerProperty();
    private SimpleDoubleProperty multa = new SimpleDoubleProperty();
    private SimpleIntegerProperty qtdeDiasAtraso = new SimpleIntegerProperty();
    private SimpleDoubleProperty total = new SimpleDoubleProperty();
    private SimpleBooleanProperty avista = new SimpleBooleanProperty();

    public Integer getNroLocacao() {
        return nroLocacao.get();
    }

    public void setNroMatricula(Integer nroLocacao) {
        this.nroLocacao.setValue(nroLocacao);
    }
    
    public String getVeiculo(){
        return veiculo.get();
    }
    
    public void setVeiculo(String veiculo){
        this.veiculo.setValue(veiculo);
    }

    public Double getValor() {
        return valor.get();
    }

    public void setValor(Double valor) {
        this.valor.setValue(valor);
    }

    public Integer getQtdeDias() {
        return qtdeDias.get();
    }

    public void setQtdeDias(Integer qtdeDias) {
        this.qtdeDias.setValue(qtdeDias);
    }

    public Double getMulta() {
        return multa.get();
    }

    public void setMulta(Double multa) {
        this.multa.setValue(multa);
    }

    public Integer getQtdeDiasAtraso() {
        return qtdeDiasAtraso.get();
    }

    public void setQtdeDiasAtraso(Integer qtdeDiasAtraso) {
        this.qtdeDiasAtraso.setValue(qtdeDiasAtraso);
    }
    
    public Double getTotal(){
        return total.get();
    }
    
    public void setTotal(Double total){
        this.total.setValue(total);
    }
    
    public Boolean getAvista(){
        return avista.get();
    }
    
    public void setAvista(Boolean avista){
        this.avista.setValue(avista);
    }
    
}
