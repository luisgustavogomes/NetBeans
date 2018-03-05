package banco;

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

}
