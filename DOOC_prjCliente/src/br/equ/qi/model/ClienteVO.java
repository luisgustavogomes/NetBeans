/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.equ.qi.model;

import java.util.Objects;

/**
 *
 * @author Luis Gustavo
 */
public class ClienteVO {
    private int codigo;
    private String nome;
    private String endereco;
    private String bairro;
    private String cidade;
    private String uf;

    
    public ClienteVO(int codigo, String nome, String endereco, String bairro, String cidade, String uf) {
        this.codigo = codigo;
        this.nome = nome;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.codigo;
        hash = 67 * hash + Objects.hashCode(this.nome);
        hash = 67 * hash + Objects.hashCode(this.endereco);
        hash = 67 * hash + Objects.hashCode(this.bairro);
        hash = 67 * hash + Objects.hashCode(this.cidade);
        hash = 67 * hash + Objects.hashCode(this.uf);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ClienteVO other = (ClienteVO) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.bairro, other.bairro)) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        if (!Objects.equals(this.uf, other.uf)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Codigo=" + codigo + ", nome=" + nome + ", endereco=" + endereco + ", bairro=" + bairro + ", cidade=" + cidade + ", uf=" + uf;
    }
 
    
}    
