package biblioteca;

/**
 *
 * @author Luis Gustavo
 */
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
        int controladorMenuProduto;
        
        do {
            controladorMenuPrograma = opcoesMenuPrincipal();
            
            switch (controladorMenuPrograma) {
                case 1:
                    Produto produtoConsulta = new Produto();
                    
                    long codigo = solicitaCodigo();
                    produtoConsulta = biblioteca.consultarProduto(codigo);
                    
                    if (produtoConsulta != null) {
                        System.out.println(produtoConsulta.toString());
                    } else {
                        System.out.println("Produto inexistente!");
                    }
                    break;
                
                case 2:
                    Produto produto;
                    Genero genero = new Genero();
                    boolean statusCadastro;
                    boolean statusGenero;
                    
                    controladorMenuProduto = opcoesMenuProduto(controladorMenuPrograma);
                    
                    if (controladorMenuProduto == 1) {
                        produto = new Livro();
                    } else {
                        produto = new Midia();
                    }
                    
                    if (controladorMenuProduto == 3) {
                        break;
                    } else {
                        System.out.println("Cadastro de Produtos\n");
                        
                        System.out.print("Codigo: ");
                        produto.codigo = Principal.teclado.nextLong();
                        Principal.teclado.nextLine();
                        
                        System.out.print("Titulo: ");
                        produto.titulo = Principal.teclado.nextLine();
                        
                        do {
                            statusGenero = false;
                            System.out.println("Genero");
                            System.out.println(genero.toString());
                            System.out.print("Digite sua escolha: ");
                            produto.genero = Principal.teclado.nextLine();
                            for (int i = 0; i < genero.tipos.length; i++) {
                                if (produto.genero.equalsIgnoreCase(genero.tipos[i])) {
                                    statusGenero = true;
                                    break;
                                }                                
                            }
                            if (!statusGenero) {
                                System.out.println("\nDigite novamente a sua escolha!\n");
                            }
                            
                        } while (!statusGenero);
                        
                        produto.disponivel = false;
                        
                        if (controladorMenuProduto == 1) {
                            System.out.print("Nome Autor: ");
                            ((Livro) produto).nomeAutor = Principal.teclado.nextLine();
                            
                            System.out.print("Editora: ");
                            ((Livro) produto).editora = Principal.teclado.nextLine();
                            
                            System.out.print("Ano Publicação: ");
                            ((Livro) produto).anoPublicacao = Principal.teclado.nextLine();
                            
                        } else {
                            
                            System.out.print("Duração:  ");
                            ((Midia) produto).duracao = Principal.teclado.nextLine();
                            
                            System.out.print("Diretor: ");
                            ((Midia) produto).diretor = Principal.teclado.nextLine();
                        }
                        
                        statusCadastro = biblioteca.cadastrarProduto(produto, controladorMenuProduto);
                        
                        if (statusCadastro) {
                            System.out.println("Cadastrado com sucesso!");
                        } else {
                            System.out.println("Não foi possivel cadastrar");
                        }
                    }
                    
                    break;
                case 3:
                    codigo = solicitaCodigo();
                    boolean existencia = biblioteca.verificadorExistenciaProduto(codigo);
                    boolean disponibilidade = biblioteca.verificadorDisponibilidadeProduto(codigo);
                    
                    if (existencia) {
                        boolean statusEmprestimoProduto = biblioteca.emprestimoProduto(codigo, disponibilidade);
                        if (statusEmprestimoProduto) {
                            System.out.println("Emprestimo efetuado");
                        } else {
                            System.out.println("Sem disponibilidade");
                        }
                    } else {
                        System.out.println("Livro não existente");
                    }
                    
                    break;
                case 4:
                    codigo = solicitaCodigo();
                    existencia = biblioteca.verificadorExistenciaProduto(codigo);
                    disponibilidade = biblioteca.verificadorDisponibilidadeProduto(codigo);
                    
                    if (existencia) {
                        boolean statusDevolucaoProduto = biblioteca.devolucaoProduto(codigo, disponibilidade);
                        if (statusDevolucaoProduto) {
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
    
    static public int opcoesMenuPrincipal() {
        int controladorMenuPrograma = 0;
        
        do {
            System.out.println("\nMenu principal\n"
                    + "\n1 - Buscar"
                    + "\n2 - Cadastrar"
                    + "\n3 - Emprestar"
                    + "\n4 - Devolver"
                    + "\n5 - Sair");
            System.out.print("\nDigite sua opção: ");
            controladorMenuPrograma = Principal.teclado.nextInt();
            
            if (controladorMenuPrograma <= 0 || controladorMenuPrograma > 5) {
                System.out.println("Erro... digite novamente sua opção!");
            }
        } while (controladorMenuPrograma <= 0 || controladorMenuPrograma > 5);
        Principal.teclado.nextLine();
        return controladorMenuPrograma;
    }
    
    static public int opcoesMenuProduto(int controladorMenuPrograma) {
        int controle = controladorMenuPrograma;
        int controladorMenuProduto;
        
        switch (controle) {
            case 1:
                System.out.println("Localizar");
                break;
            case 2:
                System.out.println("Cadastrar");
                break;
            case 3:
                System.out.println("Emprestar");
                break;
            case 4:
                System.out.println("Devolver");
                break;
        }
        
        do {
            System.out.println(
                    "\n1 - Livro"
                    + "\n2 - Midia"
                    + "\n3 - Voltar");
            System.out.print("\nDigite sua opção: ");
            controladorMenuProduto = Principal.teclado.nextInt();
            
            if (controladorMenuProduto <= 0 || controladorMenuProduto > 3) {
                System.out.println("Erro... digite novamente sua opção!");
            }
        } while (controladorMenuProduto <= 0 || controladorMenuProduto > 3);
        Principal.teclado.nextLine();
        return controladorMenuProduto;
    }

    /*Solicita ao usuario o código do livro*/
    public static long solicitaCodigo() {
        long codigo;
        
        System.out.print("Informe o codigo: ");
        codigo = Principal.teclado.nextLong();
        Principal.teclado.nextLine();
        
        return codigo;
    }
}
