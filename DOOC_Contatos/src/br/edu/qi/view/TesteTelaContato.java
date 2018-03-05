/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.view;

import br.edu.qi.model.Agenda;
import br.edu.qi.model.Contato;
import br.edu.qi.model.Endereco;
import br.edu.qi.utl.Teclado;
import java.util.List;

/**
 *
 * @author Luis Gustavo
 */
public class TesteTelaContato {

    static Agenda agenda = new Agenda();

    public static void main(String[] args) {
        carredarDados();
        while (true) {
            int controladorMenu = menu();
            switch (controladorMenu) {
                case 1:
                    agenda.adicionarContato(incluirContato());
                    break;
                case 2:
                    alterarContato();
                    break;
                case 3:
                    excluirContato();
                    break;
                case 4:
                    String nomePesquisa = null;

                    do {
                        System.out.print("\nDigite o nome : ");
                        nomePesquisa = Teclado.lerString();
                        if (nomePesquisa.trim().length() == 0 || nomePesquisa == null) {
                            System.out.println("Erro informe um nome!");
                        }
                    } while (nomePesquisa.trim().length() == 0 || nomePesquisa == null);
                    pesquisarContato(nomePesquisa);
                    break;
                case 5:
                    String nomePesquisa2 = null;
                    do {
                        System.out.print("\nDigite o nome : ");
                        nomePesquisa2 = Teclado.lerString();
                        if (nomePesquisa2.trim().length() == 0 || nomePesquisa2 == null) {
                            System.out.println("Erro informe um nome!");
                        }
                    } while (nomePesquisa2.trim().length() == 0 || nomePesquisa2 == null);

                    String telefone = null;
                    do {
                        System.out.print("\nDigite o telefone : ");
                        telefone = Teclado.lerString();
                        if (telefone.trim().length() == 0 || telefone == null) {
                            System.out.println("Erro informe um telefone!");
                        }
                    } while (telefone.trim().length() == 0 || telefone == null);

                    pesquisarContato(nomePesquisa2, telefone);
                    break;
                case 6:
                    listarContatos();
                    break;
                case 7:
                    quantidadeContato();
                    break;
                case 8:
                    System.exit(0);
                default:
                    System.out.println("Erro na escolha!!");
            }
        }
    }

    public static int menu() {
        System.out.println("\n----Menu----\n"
                + "1 - Incluir Contato\n"//ok
                + "2 - Alterar Contato\n"
                + "3 - Excluir Contato\n"
                + "4 - Pesquisar Contato por nome\n"//ok
                + "5 - Pesquisar Contato por nome e telefone\n"//ok
                + "6 - Listar Contatos\n"//ok
                + "7 - Ver quantidades de Contatos\n"//ok
                + "8 - Sair");
        System.out.print("Digite sua opção: ");
        return Teclado.lerInteiro();
    }

    public static void mostrarDados() {
        System.out.println("");
        agenda.getListaContatos().forEach(l -> System.out.print(l + "\n"));
    }

    public static void carredarDados() {
        Contato c1 = new Contato("Luis", new Endereco("Austria", "M.rondon", 30, "94965020", "Cachoeirinha", "RS"), "51", "luis@luis");
        Contato c2 = new Contato("Karen", new Endereco("Austria", "M.rondon", 30, "94965020", "Cachoeirinha", "RS"), "", "luis@luis");
        Contato c3 = new Contato("Monique", new Endereco("Austria", "M.rondon", 30, "94965020", "Cachoeirinha", "RS"), "51", "luis@luis");
        Contato c4 = new Contato("Julia", new Endereco("Austria", "M.rondon", 30, "94965020", "Cachoeirinha", "RS"), "51", "luis@luis");
        Contato c5 = new Contato("Patricia", new Endereco("Austria", "M.rondon", 30, "94965020", "Cachoeirinha", "RS"), "31", "luis@luis");
        agenda.adicionarContato(c1);
        agenda.adicionarContato(c2);
        agenda.adicionarContato(c4);
        agenda.adicionarContato(c3);
        agenda.adicionarContato(c5);
    }

    private static Contato incluirContato() {
        System.out.println("\nNovo Contato");

        String nome = null;
        do {
            System.out.print("\nDigite o nome : ");
            nome = Teclado.lerString();
            if (nome.trim().length() == 0 || nome == null) {
                System.out.println("Erro informe um nome!");
            }
        } while (nome.trim().length() == 0 || nome == null);

        Endereco endereco = solicitarEndereco();

        String telefone = null;
        do {
            System.out.print("\nDigite o telefone : ");
            telefone = Teclado.lerString();
            if (telefone.trim().length() == 0 || telefone == null) {
                System.out.println("Erro informe um telefone!");
            }
        } while (telefone.trim().length() == 0 || telefone == null);

        System.out.print("Digite o email : ");
        String email = Teclado.lerString();

        Contato contato = new Contato(nome, endereco, telefone, email);
        return contato;
    }

    private static Endereco solicitarEndereco() {
        System.out.print("Digite a rua :");
        String rua = Teclado.lerString();

        System.out.print("Digite a bairro :");
        String bairro = Teclado.lerString();

        System.out.print("Digite o número :");
        int numero = Teclado.lerInteiro();

        System.out.print("Digite a cep :");
        String cep = Teclado.lerString();

        System.out.print("Digite a cidade :");
        String cidade = Teclado.lerString();

        System.out.print("Digite a estado :");
        String estado = Teclado.lerString();

        Endereco endereco = new Endereco(rua, bairro, numero, cep, cidade, estado);
        return endereco;
    }

    private static void alterarContato() {
        int index = -1;
        do {
            System.out.print("\nDigite o indice para exclusão: ");
            index = Teclado.lerInteiro();
        } while (index < 0);

        if (index >= 0 || index <= agenda.getListaContatos().size()) {
            Contato contatoNovo = incluirContato();
            agenda.alterarContato(agenda.getListaContatos().get(0), contatoNovo);
        } else {
            System.out.println("Erro: Repita a operação!");
        }

    }

    private static void excluirContato() {

        int index = -1;
        do {
            System.out.print("\nDigite o indice para exclusão: ");
            index = Teclado.lerInteiro();
        } while (index < 0);

        if (index >= 0 || index <= agenda.getListaContatos().size()) {
            agenda.removerContato(agenda.getListaContatos().get(index));
        } else {
            System.out.println("Erro: Repita a operação!");
        }
    }

    private static void pesquisarContato(String nome, String telefone) {
        List<Contato> lista = agenda.pesquisarContato(nome, telefone);
        lista.forEach(l -> System.out.print(l + "\n"));
    }

    private static void pesquisarContato(String nome) {
        pesquisarContato(nome, "");
    }

    private static void listarContatos() {
        mostrarDados();
    }

    private static void quantidadeContato() {
        System.out.println("Quantidades de contatos : " + agenda.getQuantidade());
    }

}
