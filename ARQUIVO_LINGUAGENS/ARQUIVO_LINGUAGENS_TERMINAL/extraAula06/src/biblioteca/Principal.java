package biblioteca;

/**
 *
 * @author Luis Gustavo
 */


import java.util.Arrays;
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

            long codigo;
            boolean verificadorLivro;
            boolean disponivel;

            switch (controladorMenuPrograma) {
                case 1:
                    System.out.println("Consulta Livro\n");

                    codigo = solicitaCodigoLivro();
                    verificadorLivro = biblioteca.verificadorExistenciaLivro(codigo);

                    if (verificadorLivro) {
                        Livro livro = biblioteca.consultarLivro(codigo);
                        System.out.println(
                                "\nTítulo:     " + livro.titulo
                                + "\nNome Autor: " + livro.nomeAutor
                                + "\nEditora:    " + livro.editora
                                + "\nAno:        " + livro.anoPublicacao
                                + "\nGenero:     " + livro.genero
                                + "\nEmprestado: " + livro.disponivel + "\n");
                    } else {
                        System.out.println("Livro não encontrado!");
                    }

                    break;
                case 2:

                    String titulo;
                    String nomeAutor;
                    String editora;
                    String anoPublicacao;
                    String[] generos = {"Acao", "Romance", "Ficcao", "Historia", "Tecnico"};
                    String genero;
                    disponivel = false;
                    boolean statusGenero = false;
                    boolean statusCadastro = false;

                    System.out.println("Cadastro de Produtos\n");

                    System.out.print("Código: ");
                    codigo = Principal.teclado.nextLong();
                    Principal.teclado.nextLine();

                    System.out.print("Titulo: ");
                    titulo = Principal.teclado.nextLine();

                    System.out.print("Nome autor: ");
                    nomeAutor = Principal.teclado.nextLine();

                    System.out.print("Editora: ");
                    editora = Principal.teclado.nextLine();

                    System.out.print("Ano [YYYY]: ");
                    anoPublicacao = Principal.teclado.nextLine();

                    do {
                        System.out.println("Generos:");
                        System.out.println(Arrays.toString(generos));
                        System.out.print("Digite sua escolha: ");
                        genero = Principal.teclado.nextLine();
                        for (int j = 0; j < generos.length; j++) {
                            if (genero.equalsIgnoreCase(generos[j])) {
                                statusGenero = true;
                                break;
                            }
                        }
                        if (!statusGenero) {
                            System.out.println("\nErro...escolha o genero correto");
                        }
                    } while (!statusGenero);

                    statusCadastro = biblioteca.cadastrarProduto(codigo, titulo, nomeAutor, editora, anoPublicacao, genero, disponivel);

                    if (statusCadastro) {
                        System.out.println("Cadastro com sucesso!");
                    } else {
                        System.out.println("Não possível efetuar o cadastro!");
                    }

                    break;
                case 3:

                    System.out.println("Emprestimo Livro\n");

                    codigo = solicitaCodigoLivro();
                    verificadorLivro = biblioteca.verificadorExistenciaLivro(codigo);
                    disponivel = biblioteca.verificadordisponivel(codigo);

                    if (verificadorLivro) {
                        boolean statusEmprestimoLivro = biblioteca.emprestimoLivro(codigo, disponivel);
                        if (statusEmprestimoLivro) {
                            System.out.println("Emprestimo efetuado");
                        } else {
                            System.out.println("Sem disponibilidade");
                        }

                    } else {
                        System.out.println("Livro não existente");
                    }

                    break;
                case 4:

                    codigo = solicitaCodigoLivro();
                    verificadorLivro = biblioteca.verificadorExistenciaLivro(codigo);
                    disponivel = biblioteca.verificadordisponivel(codigo);

                    if (verificadorLivro) {
                        boolean statusDevolucaoLivro = biblioteca.devolucaoLivro(codigo, disponivel);
                        if (statusDevolucaoLivro) {
                            System.out.println("Devulução efetuada");
                        } else {
                            System.out.println("Livro já devolvido");
                        }

                    } else {
                        System.out.println("Livro não existente");
                    }

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

    /*Solicita ao usuario o código do livro*/
    public static long solicitaCodigoLivro() {
        long codigo;

        System.out.print("Informe o codigo do livro: ");
        codigo = Principal.teclado.nextLong();
        Principal.teclado.nextLine();

        return codigo;
    }

}
