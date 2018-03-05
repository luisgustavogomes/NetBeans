/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuario;

import java.util.Objects;

/**
 *
 * @author Luis Gustavo
 */
public class GerenciadorUsuario {

    private String nome;
    private String login;
    private String senha;

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }

    public GerenciadorUsuario() {
        this.nome = "administrador";
        this.login = "admin";
        this.senha = "admin";
    }

    public GerenciadorUsuario(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public GerenciadorUsuario(String linha) {
        String[] partes = linha.split(";");
        this.nome = partes[1];
        this.login = partes[2];
        this.senha = partes[3];
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.nome);
        hash = 79 * hash + Objects.hashCode(this.login);
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
        final GerenciadorUsuario other = (GerenciadorUsuario) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return GerenciadorUsuario.class.getSimpleName() + ";" + nome + ";" + login + ";" + senha + "\r\n";
    }
    
    public boolean isVerificadorSenhas(String senha){
        return senha.length() >= 3;     
    }

}
