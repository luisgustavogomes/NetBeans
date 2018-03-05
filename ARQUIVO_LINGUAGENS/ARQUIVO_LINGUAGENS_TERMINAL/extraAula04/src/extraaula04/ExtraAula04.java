package extraaula04;

/*
Encontrei muitas dificuldades em tentar resolver esse exercício, pois, tenho muitas dúvidas:
1º quando criamos uma classe, os dados contidos nela devem somente ser uma referência, ou seja, 
estanciando objetos, pois, nesse caso como é aonde deveríamos criar o array para armazenar essas informações? 
2 º quando criamos um método dentro de uma função ele tem função de fazer algo, bom... conforme o 
exercício passado...poderia criar um método para cadastrar livro baseando-se na classe e logicamente 
criar um array no main retornando as informações digitadas no método? Logo caiu na 1º questão.
3º suponho que o array desse guardara seus dados no main, como irei criar um método para remover 
uma posição, pois, o objeto criado é um conjunto de dados?



*/

import java.util.Scanner;

public class ExtraAula04 {

    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        int controladorMenuPrograma;
        Livro[] livro = new Livro[3];
        Livro[] livronovo = new Livro[3];
        boolean verificadorExclusao = false;

        System.out.println("Atividade extra aula | Criando um cadastro de livros\n");

        do {
            controladorMenuPrograma = MenuPrincipalPrograma();

            switch (controladorMenuPrograma) {
                case 1:
                    System.out.println("Cadastro de livros\n ");

                    for (int i = 0; i < livro.length; i++) {
                        Livro l = new Livro();
                        System.out.println("Indice: " + (i + 1));
                        System.out.print("Código do livro: ");
                        l.codigoLivro = teclado.nextLong();
                        teclado.nextLine();
                        System.out.print("Título: ");
                        l.titulo = teclado.nextLine();
                        System.out.print("Autor: ");
                        l.nomeAutor = teclado.nextLine();
                        System.out.print("Editora: ");
                        l.editora = teclado.nextLine();
                        System.out.print("Ano: ");
                        l.anoPublicacao = teclado.nextLine();
                        System.out.println("");
                        livro[i] = l;
                    }

                    break;
                case 2:
                    System.out.println("Consulta de livros");

                    for (Livro l : livro) {
                        System.out.println("Código:  " + l.codigoLivro
                                + "\nTítulo:  " + l.titulo
                                + "\nAutor:   " + l.nomeAutor
                                + "\nEditora: " + l.editora
                                + "\nAno:     " + l.anoPublicacao
                                + "\n");
                    }

                    break;

                case 3:
                    System.out.println("Digite o código do livro para exclusão: ");
                    int excluir = teclado.nextInt();

                    for (int i = 0, j = 0; i < livro.length; i++) {
                        if (livro[i].codigoLivro == excluir) {
                            livronovo[j] = livro[i];
                            j++;
                            verificadorExclusao = true;
                        }
                    }

                    break;
                case 4:
                    System.out.println("Finalizando...");
                    System.exit(0);

            }
        } while (controladorMenuPrograma != 4);
    }

    static int MenuPrincipalPrograma() {
        int controladorMenuPrograma = 0;
        do {
            System.out.println("\nMenu\n"
                    + "\n1 - Cadastro"
                    + "\n2 - Consultar"
                    + "\n3 - Excluir"
                    + "\n4 - Fechar");
            System.out.print("\nDigite sua opção: ");
            controladorMenuPrograma = teclado.nextInt();

            if (controladorMenuPrograma <= 0 || controladorMenuPrograma > 4) {
                System.out.println("Erro... digite novamente sua opção!");
            }
        } while (controladorMenuPrograma <= 0 || controladorMenuPrograma > 4);
        return controladorMenuPrograma;
    }

}
