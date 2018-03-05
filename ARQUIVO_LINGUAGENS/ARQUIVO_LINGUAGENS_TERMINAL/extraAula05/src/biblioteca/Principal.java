package biblioteca;

import java.util.Scanner;

public class Principal {

    static Scanner teclado = new Scanner(System.in);
    static Biblioteca biblioteca = new Biblioteca();

    public static void main(String[] args) {

        Usuario login = new Usuario();
        boolean statusUsuario = false;
        short contatorTentativas = 0;

        System.out.println("Biblioteca\n");

        do {
            System.out.print("Usuario: ");
            login.nome = teclado.nextLine();
            System.out.print("Senha: ");
            login.senha = teclado.nextLine();

            if (login.verificarNome(login.nome) && login.verificarSenha(login.senha)) {
                statusUsuario = true;
            } else {
                System.out.println("Erro digite novamente\n");
                contatorTentativas++;
            }

        } while (!statusUsuario);
        
        menuPrincipal();

    }

    static void menuPrincipal() {
        int controladorMenuPrograma;

        do {
            controladorMenuPrograma = opcoes();
            Principal.teclado.nextLine();

            switch (controladorMenuPrograma) {
                case 1:
                    biblioteca.consultarLivro();
                    break;
                case 2:
                    biblioteca.cadastrarLivro();
                    break;
                case 3:
                    biblioteca.emprestimoLivro();
                    break;
                case 4:
                    biblioteca.devolverLivro();
                    break;
                case 5:
                    System.out.println("Finalizando...");
                    System.exit(0);
            }
        } while (controladorMenuPrograma != 5);

    }

    static public int opcoes() {
        int controladorMenuPrograma = 0;

        do {
            System.out.println("\nMenu\n"
                    + "\n1 - Buscar Livro"
                    + "\n2 - Cadastrar Livro"
                    + "\n3 - Emprestar"
                    + "\n4 - Devolver"
                    + "\n5 - Sair");
            System.out.print("\nDigite sua opção: ");
            controladorMenuPrograma = Principal.teclado.nextInt();

            if (controladorMenuPrograma <= 0 || controladorMenuPrograma > 5) {
                System.out.println("Erro... digite novamente sua opção!");
            }
        } while (controladorMenuPrograma <= 0 || controladorMenuPrograma > 5);
        return controladorMenuPrograma;
    }
}
