package biblioteca;

import java.util.Arrays;

public class Biblioteca {

    Livro livros[] = new Livro[10];

    public void cadastrarLivro() {
        Livro livro = new Livro();

        String[] genero = {"Acao", "Romance", "Ficcao", "Historia", "Tecnico"};
        boolean statusGenero = false;
        boolean statusCadastro = false;

        for (int i = 0; i < livros.length; i++) {
            if (livros[i] == null) {
                livro.statusLivro = false;
                
                System.out.println("Cadastro de Livro\n");

                System.out.print("Código: ");
                livro.codigoLivro = Principal.teclado.nextLong();
                Principal.teclado.nextLine();

                System.out.print("Titulo: ");
                livro.titulo = Principal.teclado.nextLine();

                System.out.print("Nome autor: ");
                livro.nomeAutor = Principal.teclado.nextLine();

                System.out.print("Editora: ");
                livro.editora = Principal.teclado.nextLine();

                System.out.print("Ano [YYYY]: ");
                livro.anoPublicacao = Principal.teclado.nextLine();

                do {
                    System.out.println("Generos:");
                    System.out.println(Arrays.toString(genero));
                    System.out.print("Digite sua escolha: ");
                    livro.genero = Principal.teclado.nextLine();

                    for (int j = 0; j < genero.length; j++) {
                        if (livro.genero.equalsIgnoreCase(genero[j])) {
                            statusGenero = true;
                            break;
                        }
                    }

                    if (!statusGenero) {
                        System.out.println("\nErro...escolha o genero correto");
                    }

                } while (!statusGenero);

                livros[i] = livro;

                statusCadastro = true;
                if (statusCadastro) {
                    return;
                }
            }

        }
        System.out.println("\nLotado\n");

    }

    public void consultarLivro() {

        System.out.println("Consulta Livro\n");

        long codigoLivro = solicitaCodigoLivro();
        boolean verificadorLivro = verificadorLivro(codigoLivro);

        if (verificadorLivro) {
            for (int i = 0; i < livros.length; i++) {
                if (livros[i] != null && livros[i].codigoLivro == codigoLivro) {
                    System.out.println(
                            "\nTítulo:     " + livros[i].titulo.toUpperCase()
                            + "\nNome Autor: " + livros[i].nomeAutor.toUpperCase()
                            + "\nEditora:    " + livros[i].editora.toUpperCase()
                            + "\nAno:        " + livros[i].anoPublicacao.toUpperCase()
                            + "\nGenero:     " + livros[i].genero.toUpperCase()
                            + "\nEmprestado: " + livros[i].statusLivro + "\n");
                    return;
                }
            }
        } else {
            System.out.println("Livro não encontrado!");
        }

    }

    public void emprestimoLivro() {
        System.out.println("Emprestimo Livro\n");

        long codigoLivro = solicitaCodigoLivro();
        boolean verificadorLivro = verificadorLivro(codigoLivro);
        boolean status = statusLivro(codigoLivro);

        if (verificadorLivro) {
            for (int i = 0; i < livros.length; i++) {
                if ((livros[i] != null && codigoLivro == livros[i].codigoLivro) && !status) {
                    System.out.println("Livro disponivel...");
                    livros[i].statusLivro = true;
                    System.out.println("Operação efetuada com sucesso");
                    return;
                }
            }
            System.out.println("Sem disponibilidade");
        } else {
            System.out.println("Livro não cadastrado");
        }

    }

    public void devolverLivro() {
        System.out.println("Devolução Livro\n");

        long codigoLivro = solicitaCodigoLivro();
        boolean verificadorLivro = verificadorLivro(codigoLivro);
        boolean status = statusLivro(codigoLivro);

        if (verificadorLivro) {
            for (int i = 0; i < livros.length; i++) {
                if ((livros[i] != null && codigoLivro == livros[i].codigoLivro) && status) {
                    System.out.println("Livro devolvido...");
                    livros[i].statusLivro = false;
                    System.out.println("Operação efetuada com sucesso");
                    return;
                }
            }
            System.out.println("Livro já devolvido");
        } else {
            System.out.println("Livro não cadastrado");
        }
    }

    /*Busca a informação do status do livro*/
    private boolean statusLivro(long codigoLivro) {
        boolean status = false;

        for (int i = 0; i < livros.length; i++) {
            if (livros[i] != null && codigoLivro == livros[i].codigoLivro) {
                status = livros[i].statusLivro;
                break;
            }
        }

        return status;
    }

    /*Solicita ao usuario o código do livro*/
    private long solicitaCodigoLivro() {
        long codigoLivro;

        System.out.print("Informe o codigo do livro: ");
        codigoLivro = Principal.teclado.nextLong();
        Principal.teclado.nextLine();

        return codigoLivro;
    }

    /* Busca a informação se o livro existe no array */
    private boolean verificadorLivro(long codigoLivro) {
        boolean status = false;

        for (int i = 0; i < livros.length; i++) {
            if (livros[i] != null && codigoLivro == livros[i].codigoLivro) {
                status = true;
                break;
            }
        }

        return status;
    }

}
