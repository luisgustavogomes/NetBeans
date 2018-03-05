package biblioteca;

public class Usuario {

    String nome;
    String senha;

    boolean verificarSenha(String senha) {
        boolean status = false;

        String ad = "admin";

        if (ad.equalsIgnoreCase(senha)) {
            status = true;
        }

        return status;
    }

    boolean verificarNome(String nome) {
        boolean status = false;

        String ad = "admin";

        if (ad.equalsIgnoreCase(nome)) {
            status = true;
        }

        return status;
    }
}
