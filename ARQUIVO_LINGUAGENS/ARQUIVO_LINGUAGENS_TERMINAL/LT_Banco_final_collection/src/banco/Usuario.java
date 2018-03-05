package banco;

import java.util.Objects;

public class Usuario {

    private String nome;
    private String login;
    private String senha;

    public String getLogin() {
        return login;
    }
    
    public String getSenha() {
        return senha;
    }

    public Usuario() {
        this.nome = "administrador";
        this.login = "admin";
        this.senha = "admin";
    }

    public Usuario(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.login);
        hash = 29 * hash + Objects.hashCode(this.senha);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        return Objects.equals(this.senha, other.senha);
    }

}
