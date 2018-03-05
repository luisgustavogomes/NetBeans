package arvorebinaria;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Principal {

    static Scanner teclado = new Scanner(System.in);
    static Arvore arvore = new Arvore();

    public static void main(String[] args) {

        int controlador;

        do {
            System.out.println("\nMenu\n ");
            System.out.println("1 - Inserir\n"
                    + "2 - Excluir\n"
                    + "3 - Pesquisa\n"
                    + "4 - Pesquisa MAIOR\n"
                    + "5 - Pesquisa MENOR\n"
                    + "6 - Atravessar em Ordem\n"
                    + "7 - Atravessar em Pré-Ordem\n"
                    + "8 - Atravessar em Pós-Ordem\n"
                    + "9 - Folhas\n"
                    + "10- Ordem Inversa\n"
                    + "11- Soma dos nodes\n"
                    + "12- Média dos nodes\n"
                    + "13- Primos dos nodes\n"
                    + "14- Quantidade de nodes\n"
                    + "15- Verificador arvore\n"
                    + "16- Altura\n"
                    + "0 - Sair");
            controlador = escolha();
            switch (controlador) {
                case 0:
                    System.exit(controlador);
                case 1:
                    arvore.inserir(escolhaValor());
                    break;
                case 2:
                    arvore.excluir(escolhaValor());
                    break;
                case 3:
                    System.out.println("\nValor: " + arvore.pesquisa(escolhaValor()));
                    break;
                case 4:
                    System.out.println("\nMaior: " + arvore.maior());
                    break;
                case 5:
                    System.out.println("\nMenor: " + arvore.menor());
                    break;
                case 6:
                    List<Integer> listaEmOrdem = arvore.atravessarEmOrdem();
                    System.out.println(Arrays.toString(listaEmOrdem.toArray()));
                    break;
                case 7:
                    List<Integer> listaPreOrdem = arvore.atravessarPreOrdem();
                    System.out.println(Arrays.toString(listaPreOrdem.toArray()));
                    break;
                case 8:
                    List<Integer> listaPosOrdem = arvore.atravessarPosOrdem();
                    System.out.println(Arrays.toString(listaPosOrdem.toArray()));
                    break;
                case 9:
                    List<Integer> folhas = arvore.folhas();
                    System.out.println(Arrays.toString(folhas.toArray()));
                    System.out.println("\nQuantidades de folhas é " + folhas.size());
                    break;
                case 10:
                    List<Integer> ordemInversa = arvore.ordemInversa();
                    System.out.println(Arrays.toString(ordemInversa.toArray()));
                    break;
                case 11:
                    System.out.println("Total: " + arvore.somaArvore());
                    break;
                case 12:
                    System.out.println("Média: " + arvore.media());
                case 13:
                    List<Integer> primos = arvore.primos();
                    System.out.println(Arrays.toString(primos.toArray()));
                    break;
                case 14:
                    System.out.println("\nValor: " + arvore.quantidadePesquisa(escolhaValor()));
                    break;
                case 15:
                    System.out.println("Status: " + arvore.verificadorArvore());
                    break;
                case 16:
                    System.out.println("Altura: " + arvore.altura());
                    break;
            }
        } while (controlador != 0);

    }

    private static int escolha() {
        System.out.print("Digite sua escolha:");
        int retorno = teclado.nextInt();
        teclado.nextLine();
        return retorno;
    }

    private static int escolhaValor() {
        System.out.print("Digite um valor: ");
        int retorno = teclado.nextInt();
        teclado.nextLine();
        return retorno;
    }

}
