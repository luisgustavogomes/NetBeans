/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author lg
 */
@Entity
@Table(name = "participante")
public class Participante implements Serializable {

    @Id
    private long id;
    @Column
    private String nome;
    @Column
    private String departamento;
    @Column
    private String email;
    @Column
    private String telefone;
    @Column
    private String ramal1;
    @Column
    private String ramal2;
    @Column
    private String celular;

    public Participante() {
    }
    
    

    public Participante(long id, String nome, String departamento, String email, String telefone, String ramal1, String ramal2, String celular) {
        this.id = id;
        this.nome = nome;
        this.departamento = departamento;
        this.email = email;
        this.telefone = telefone;
        this.ramal1 = ramal1;
        this.ramal2 = ramal2;
        this.celular = celular;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRamal1() {
        return ramal1;
    }

    public void setRamal1(String ramal1) {
        this.ramal1 = ramal1;
    }

    public String getRamal2() {
        return ramal2;
    }

    public void setRamal2(String ramal2) {
        this.ramal2 = ramal2;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

}
