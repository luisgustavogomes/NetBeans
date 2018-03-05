/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecavirtual;

import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis Gustavo
 */
public class Principal {

    static Scanner teclado = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        carregarDadosClasse();
        GerenciadorBibliotecaVirtual.cadastrarAdmin();
        carregarTeste();
        while (true) {
            int controladorAcesso = menuPrincipal();
            boolean statusAutenticacao = autenticacao(controladorAcesso);
            if (statusAutenticacao) {
                switch (controladorAcesso) {
                    case 1:
                        menuUsuario();
                        break;
                    case 2:
                        menuAdministrador();
                        break;
                }
            } else {
                System.out.println("\nAcesso Negado!\n");
            }
        }
    }

    //Método para determinar quem está acessando!
    private static int menuPrincipal() {
        System.out.println("\nBiblioteca Virtual\n");
        while (true) {
            System.out.println("Selecione a sua Opção:");
            System.out.println("1 - Usuario " + "\n2 - Administrador " + "\n3 - Sair");
            int controladorAcesso = solicitaInteiroMenu();
            switch (controladorAcesso) {
                case 1:
                case 2:
                    System.out.println("Acessando...");
                    return controladorAcesso;
                case 3:
                    System.out.println("Finalizando...");
                    System.exit(0);
                default:
                    System.out.println("\nErro! Escolha a opção correta!\n");
                    break;
            }
        }
    }

    //Métodos do Menu administrador
    private static void menuAdministrador() {
        while (true) {
            System.out.println("\nMenu Administrador\n");
            int controladorMenuOpcaoAdministrador = menuOpcaoAdministrador();
            switch (controladorMenuOpcaoAdministrador) {
                case 1:
                    cadastrarLivro();
                    break;
                case 2:
                    alterarLivro();
                    break;
                case 3:
                    excluirLivro();
                    break;
                case 4:
                    listarLivro();
                    break;
                case 5:
                    cadastrarUsuario();
                    break;
                case 6:
                    excluirUsuario();
                    break;
                case 7:
                    listarUsuario();
                    break;
                case 9:
                    return;
                default:
                    System.out.println("\nErro! Escolha a opção correta!\n");
            }
        }
    }

    private static int menuOpcaoAdministrador() {
        while (true) {
            System.out.println("1 - Cadastrar Livro\n"
                    + "2 - Alterar Livro\n"
                    + "3 - Excluir Livro\n"
                    + "4 - Listar Livro\n"
                    + "5 - Cadastrar Usuário\n"
                    + "6 - Excluir Usuário\n"
                    + "7 - Listar Usuário\n"
                    + "9 - Voltar");
            int controladorMenuOpcaoAdministrador = solicitaInteiroMenu();
            if ((controladorMenuOpcaoAdministrador >= 1 && controladorMenuOpcaoAdministrador <= 7) || controladorMenuOpcaoAdministrador == 9) {
                return controladorMenuOpcaoAdministrador;
            } else {
                System.out.println("\nErro, opção invalida!\n");
            }
        }
    }

    //Métodos do Menu usuario
    private static void menuUsuario() {
        while (true) {
            System.out.println("\nMenu Usuario\n");
            int controladorMenuUsuario = menuOpcaoUsuario();
            switch (controladorMenuUsuario) {
                case 1:
                    listarLivro();
                    break;
                case 2:
                    lerLivro();
                    break;
                case 3:
                    editarSenhaUsuario();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("\nErro! Escolha a opção correta!\n");
            }
        }
    }

    private static int menuOpcaoUsuario() {
        while (true) {
            System.out.println("1 - Listar Livros\n"
                    + "2 - Ler Livro\n"
                    + "3 - Alterar Senha\n"
                    + "4 - Voltar");
            int controladorMenuUsuario = solicitaInteiroMenu();
            if (controladorMenuUsuario >= 1 && controladorMenuUsuario <= 4) {
                return controladorMenuUsuario;
            } else {
                System.out.println("\nErro, opção invalida!\n");
            }
        }
    }

    //Método Autenticação
    private static boolean autenticacao(int controladorAcesso) {
        short contadorTentativas = 0;
        while (true) {
            System.out.println("\nUsuario\n");
            String login = solicitaLogin();
            String senha = solicitaSenha();
            boolean status = GerenciadorBibliotecaVirtual.verificadorUsuario(login, senha);
            if (status) {
                if (controladorAcesso == 2 && !login.equalsIgnoreCase("admin")) {
                    contadorTentativas++;
                    return false;
                } else {
                    GerenciadorBibliotecaVirtual.USUARIOLOGADO.setLogin(login);
                    return true;
                }
            } else {
                System.out.println("\nErro! Usuario ou Senha incorretos!\n");
                contadorTentativas++;
            }
            if (contadorTentativas == 3) {
                return false;
            }
        }

    }

    //Métodos carga arquivo
    private static void carregarDadosClasse() {
        boolean statusArquivoLivro = GerenciadorBibliotecaVirtual.carregarArquivoLivro();
        boolean statusArquivoUsuario = GerenciadorBibliotecaVirtual.carregarArquivoUsuario();

        JOptionPane.showMessageDialog(null, "Carga Livros:  " + statusArquivoLivro + "\n"
                + "Carga Usuario: " + statusArquivoUsuario);
    }

    private static void carregarTeste() {

        GerenciadorBibliotecaVirtual.cadastrarArquivoLivro("Tche loko", "Luis Gustavo", 10, "Qi", "O vídeo fornece uma maneira poderosa de ajudá-lo a provar seu argumento. Ao clicar em Vídeo Online, você pode colar o código de inserção do vídeo que deseja adicionar. Você também pode digitar uma palavra-chave para pesquisar online o vídeo mais adequado ao seu documento.");
        GerenciadorBibliotecaVirtual.cadastrarArquivoLivro("Bagual", "Bruno Murata", 140, "Qi", "Clique em Inserir e escolha os elementos desejados nas diferentes galerias. Temas e estilos também ajudam a manter seu documento coordenado. Quando você clica em Design e escolhe um novo tema.");
        GerenciadorBibliotecaVirtual.cadastrarArquivoLivro("Gaiteiro", "Mauro Hanh", 55, "Qi", "Para alterar a maneira como uma imagem se ajusta ao seu documento, clique nela e um botão de opções de layout será exibido ao lado.");
        GerenciadorBibliotecaVirtual.cadastrarArquivoUsuario("Luis Gomes", "luis.gomes", "123");
    }

    //Métodos terminal, com tratamento de erros
    private static int solicitaInteiroMenu() {
        int numero = 0;
        boolean status = false;
        do {
            try {
                System.out.print("Digite sua escolha: ");
                numero = teclado.nextInt();
                teclado.nextLine();
                status = true;
            } catch (InputMismatchException ime) {
                System.out.println("\nErro no tipo digitado!\n" + ime.toString() + "\n");
                teclado.nextLine();
            } catch (Exception ex) {
                System.out.println("\nFaltal erro!\n" + ex.toString());
                teclado.nextLine();
            }
        } while (!status);
        return numero;
    }

    private static int solicitaInteiroNumeroPagina() {
        int numero = 0;
        boolean status = false;
        do {
            try {
                System.out.print("Número página: ");
                numero = teclado.nextInt();
                teclado.nextLine();
                status = true;
            } catch (InputMismatchException ime) {
                System.out.println("\nErro no tipo digitado!\n" + ime.toString() + "\n");
                teclado.nextLine();
            } catch (Exception ex) {
                System.out.println("\nFaltal erro!\n" + ex.toString());
                teclado.nextLine();
            }
        } while (!status);
        return numero;
    }

    private static String solicitaNome() {
        System.out.print("Nome: ");
        String nome = teclado.nextLine();
        return nome;
    }

    private static String solicitaEditora() {
        System.out.print("Editora: ");
        String nome = teclado.nextLine();
        return nome;
    }

    private static String solicitaAutor() {
        System.out.print("Autor: ");
        String nome = teclado.nextLine();
        return nome;
    }

    private static String solicitaLogin() {
        System.out.print("Login: ");
        String login = teclado.nextLine();
        return login;
    }

    private static String solicitaSenha() {
        System.out.print("Senha: ");
        String senha = teclado.nextLine();
        return senha;
    }

    private static String solicitaNomePesquisa() {
        System.out.print("\nPesquisa...\nDigite o campo ");
        return solicitaNome();
    }

    private static String solicitaCaminho() {
        System.out.print("Digite o nome do arquivo: ");
        String caminho = teclado.nextLine();
        return caminho;
    }

    //Métodos Classe Livro
    private static void cadastrarLivro() {
        System.out.println("\nCadastro Livro\n");
        boolean statusCadastro = GerenciadorBibliotecaVirtual.cadastrarArquivoLivro(solicitaNome(), solicitaAutor(), solicitaInteiroNumeroPagina(), solicitaEditora(),
                GerenciadorBibliotecaVirtual.uploadConteudo(solicitaCaminho()));
        if (statusCadastro) {
            System.out.println("\nCadastrado com sucesso\n");
        } else {
            System.out.println("\nErro, Livro já cadastrado!\n");
        }
    }

    private static void listarLivro() {
        System.out.println("\nListagem\n");
        System.out.println("Classe;Nome;Autor;Numero Páginas;Editora\n");
        GerenciadorBibliotecaVirtual.livros.stream().forEach(System.out::print);
        System.out.println("");
    }

    private static void alterarLivro() {
        short contadorTentativas = 0;
        while (true) {
            System.out.println("\nAlteração de Livro\n");
            String nomePesquisa = solicitaNomePesquisa();
            boolean statusPesquisa = GerenciadorBibliotecaVirtual.verificadorLivro(nomePesquisa);
            if (statusPesquisa) {
                System.out.println("\nClasse;Nome;Autor;Numero Páginas;Editora");
                System.out.println(GerenciadorBibliotecaVirtual.visualizadorLivro(nomePesquisa));
                System.out.println("Digite a alteração do livro!");
                boolean status = GerenciadorBibliotecaVirtual.alteracaoArquivoLivro(nomePesquisa, solicitaNome(), solicitaAutor(), 
                        solicitaInteiroNumeroPagina(), solicitaEditora(),GerenciadorBibliotecaVirtual.uploadConteudo(solicitaCaminho()));
                if (status) {
                    System.out.println("\nLivro alterado com sucesso!\n");
                    return;
                } else {
                    System.out.println("\nErro ao criar arquivo!\n");
                    break;
                }
            } else {
                System.out.println("Erro! Objeto não encontrado!");
                contadorTentativas++;
            }
            if (contadorTentativas == 3) {
                return;
            }
        }
    }

    private static void excluirLivro() {
        short contadorTentativas = 0;
        while (true) {
            String nomePesquisa = solicitaNomePesquisa();
            if (GerenciadorBibliotecaVirtual.verificadorLivro(nomePesquisa)) {
                boolean status = GerenciadorBibliotecaVirtual.exclusaoLivro(nomePesquisa);
                if (status) {
                    System.out.println("\nLivro excluido com sucesso!\n");
                    return;
                } else {
                    System.out.println("\nErro ao criar arquivo!\n");
                    break;
                }
            } else {
                System.out.println("\nErro! Objeto não encontrato\n");
                contadorTentativas++;
            }
            if (contadorTentativas == 3) {
                return;
            }
        }
    }

    private static void lerLivro() {
        System.out.println("\nLeitor\n");
        String nomePesquisa = solicitaNomePesquisa();
        boolean statusPesquisa = GerenciadorBibliotecaVirtual.verificadorLivro(nomePesquisa);
        if (statusPesquisa) {
            System.out.println(GerenciadorBibliotecaVirtual.visualizadorLivro(nomePesquisa));
        } else {
            System.out.println("\nErro! Objeto não encontrado!\n");
        }
    }

    //Métodos Classe GerenciadorUsuario
    private static void cadastrarUsuario() {
        System.out.println("\nCadastro Usuario");
        boolean statusCadastro = GerenciadorBibliotecaVirtual.cadastrarArquivoUsuario(solicitaNome(), solicitaLogin(), solicitaSenha());
        if (statusCadastro) {
            System.out.println("\nCadastrado com sucesso\n");
        } else {
            System.out.println("\nErro, Usuário já cadastrado!\n");
        }
    }

    private static void excluirUsuario() {
        short contadorTentativas = 0;
        while (true) {
            String nomePesquisa = solicitaNomePesquisa();
            if (GerenciadorBibliotecaVirtual.verificadorUsuario(nomePesquisa)) {
                boolean status = GerenciadorBibliotecaVirtual.exclusaoUsuario(nomePesquisa);
                if (status) {
                    System.out.println("\nUsuário excluido com sucesso!\n");
                    return;
                } else {
                    System.out.println("\nErro ao criar arquivo!\n");
                    break;
                }
            } else {
                System.out.println("\nErro! Objeto não encontrato\n");
                contadorTentativas++;
            }
            if (contadorTentativas == 3) {
                return;
            }
        }
    }

    private static void listarUsuario() {
        System.out.println("\nListagem\n");
        System.out.println("\nNome;Login;Senha");
        GerenciadorBibliotecaVirtual.usuarios.stream().forEach(System.out::print);
        System.out.println("");
    }

    private static void editarSenhaUsuario() {
        System.out.println("\nAlteração de senha\n");
        System.out.print("Digite sua nova ");
        String novaSenha = solicitaSenha();
        boolean statusEdicao = GerenciadorBibliotecaVirtual.alteracaoArquivoUsuarioSenha(novaSenha);
        if (statusEdicao) {
            System.out.println("\nSenha alterada com sucesso!\n");
        } else {
            System.out.println("Não foi possivel alterar a sua senha");
        }
    }

}
