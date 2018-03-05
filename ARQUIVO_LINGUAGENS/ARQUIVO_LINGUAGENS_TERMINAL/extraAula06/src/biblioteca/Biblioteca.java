package biblioteca;

public class Biblioteca {

    //Livro livros[] = new Livro [10]; 
    Produto produtos[] = new Produto[10];

    public boolean cadastrarProduto(long codigo, String titulo, String nomeAutor, String editora, String anoPublicacao, String genero, boolean disponivel) {
        //Livro livro = new Livro();
        Produto produto = null;
        boolean statusCadastro = false;
        
        if (tipoCadastro == 1) {
            produto = new Livro();
        } else {
            produto = new Midia();
        }

        for (int i = 0; i < produtos.length; i++) {
            if (produtos[i] == null) {
                produto.codigo = codigo;
                produto.titulo = titulo;
                if (tipoCadastro == 1) {
                    ((Livro) produto).nomeAutor = nomeAutor;
                    ((Livro) produto).editora = editora;
                    ((Livro) produto).anoPublicacao = anoPublicacao;
                    ((Livro) produto).genero = genero;
                } else {
                    ((Midia) produto).diretor = diretor;
                    ((Midia) produto).diretor = duracao;
                }
                produto.disponivel = disponivel;
                produtos[i] = produto;
                statusCadastro = true;
                break;
            }
        }
        return statusCadastro;
    }

    public Livro consultarLivro(long codigo) {
        Livro livro = new Livro();

        for (int i = 0; i < livros.length; i++) {
            if (livros[i] != null && livros[i].codigo == codigo) {

                livro.titulo = livros[i].titulo.toUpperCase();
                livro.nomeAutor = livros[i].nomeAutor.toUpperCase();
                livro.editora = livros[i].editora.toUpperCase();
                livro.anoPublicacao = livros[i].anoPublicacao.toUpperCase();
                livro.genero = livros[i].genero.toUpperCase();
                livro.disponivel = livros[i].disponivel;
                break;
            }
        }
        return livro;
    }

    public boolean emprestimoLivro(long codigo, boolean disponivel) {
        boolean statusEmprestimoLivro = false;

        for (int i = 0; i < livros.length; i++) {
            if ((livros[i] != null && codigo == livros[i].codigo) && !disponivel) {
                statusEmprestimoLivro = true;
                livros[i].disponivel = true;
                break;
            }
        }
        return statusEmprestimoLivro;

    }

    public boolean devolucaoLivro(long codigo, boolean disponivel) {
        boolean statusDevolucaoLivro = false;

        for (int i = 0; i < livros.length; i++) {
            if ((livros[i] != null && codigo == livros[i].codigo) && disponivel) {
                statusDevolucaoLivro = true;
                livros[i].disponivel = false;
                break;
            }
        }
        return statusDevolucaoLivro;

    }

    /*Busca a informação do status do livro*/
    public boolean verificadordisponivel(long codigo) {
        boolean status = false;

        for (int i = 0; i < livros.length; i++) {
            if (livros[i] != null && codigo == livros[i].codigo) {
                status = livros[i].disponivel;
                break;
            }
        }

        return status;
    }

    /* Busca a informação se o livro existe no array */
    public boolean verificadorExistenciaLivro(long codigo) {
        boolean status = false;

        for (int i = 0; i < livros.length; i++) {
            if (livros[i] != null && codigo == livros[i].codigo) {
                status = true;
                break;
            }
        }

        return status;
    }

}
