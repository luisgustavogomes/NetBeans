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
public class CarroModel {

    private SimpleStringProperty proprietario = new SimpleStringProperty();
    private SimpleIntegerProperty ano = new SimpleIntegerProperty();
    private SimpleStringProperty marca = new SimpleStringProperty();
    private SimpleStringProperty modelo = new SimpleStringProperty();
    private SimpleStringProperty cor = new SimpleStringProperty();
    private SimpleStringProperty descricao = new SimpleStringProperty();
    private SimpleBooleanProperty arCondicionado = new SimpleBooleanProperty();
    private SimpleBooleanProperty tocaFita = new SimpleBooleanProperty();
    private SimpleBooleanProperty rodaLiga = new SimpleBooleanProperty();
    private SimpleBooleanProperty tapetes = new SimpleBooleanProperty();
    private SimpleBooleanProperty alarme = new SimpleBooleanProperty();
    private SimpleStringProperty tipo = new SimpleStringProperty();
    private SimpleStringProperty estado = new SimpleStringProperty();
    private SimpleDoubleProperty km = new SimpleDoubleProperty();
    private SimpleDoubleProperty valor = new SimpleDoubleProperty();

    public String getProprietario() {
        return proprietario.get();
    }

    public void setProprietario(String proprietario) {
        this.proprietario.setValue(proprietario);
    }

    public Integer getAno() {
        return ano.get();
    }

    public void setAno(Integer ano) {
        this.ano.setValue(ano);
    }

    public String getMarca() {
        return marca.get();
    }

    public void setMarca(String marca) {
        this.marca.setValue(marca);
    }

    public String getModelo() {
        return modelo.get();
    }

    public void setModelo(String modelo) {
        this.modelo.setValue(modelo);
    }

    public String getCor() {
        return cor.get();
    }

    public void setCor(String cor) {
        this.cor.setValue(cor);
    }

    public String getDescricao() {
        return descricao.get();
    }

    public void setDescricao(String descricao) {
        this.descricao.setValue(descricao);
    }

    public Boolean getArCondicionado() {
        return arCondicionado.get();
    }

    public void setArCondicionado(Boolean arCondicionado) {
        this.arCondicionado.setValue(arCondicionado);
    }

    public Boolean getTocaFita() {
        return tocaFita.get();
    }

    public void setTocaFita(Boolean tocaFita) {
        this.tocaFita.setValue(tocaFita);
    }

    public Boolean getRodaLiga() {
        return rodaLiga.get();
    }

    public void setRodaLiga(Boolean rodaLiga) {
        this.rodaLiga.setValue(rodaLiga);
    }

    public Boolean getTapetes() {
        return tapetes.get();
    }

    public void setTapetes(Boolean tapetes) {
        this.tapetes.setValue(tapetes);
    }

    public Boolean getAlarme() {
        return alarme.get();
    }

    public void setAlarme(Boolean Alarme) {
        this.alarme.setValue(Alarme);
    }

    public String getTipo() {
        return tipo.get();
    }

    public void setTipo(String tipo) {
        this.tipo.setValue(tipo);
    }

    public String getEstado() {
        return estado.get();
    }

    public void setEstado(String estado) {
        this.estado.setValue(estado);
    }

    public Double getKm() {
        return km.get();
    }

    public void setKm(Double km) {
        this.km.setValue(km);
    }

    public Double getValor() {
        return valor.get();
    }

    public void setValor(Double valor) {
        this.valor.setValue(valor);
    }

}
