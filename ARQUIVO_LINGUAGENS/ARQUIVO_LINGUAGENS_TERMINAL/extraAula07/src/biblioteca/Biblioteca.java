package biblioteca;

public class Biblioteca {

    Produto produtos[] = new Produto[10];

    public boolean cadastrarProduto(Produto produto, int tipo) {
        boolean statusCadastro = false;

        for (int i = 0; i < produtos.length; i++) {
            if (produtos[i] == null) {
                produtos[i] = produto;
                statusCadastro = true;
                break;
            }
        }

        return statusCadastro;
    }

    public Produto consultarProduto(long codigo) {
        Produto produto = null;

        for (int i = 0; i < produtos.length; i++) {
            if (produtos[i] != null && produtos[i].codigo == codigo) {
                produto = produtos[i];
                break;
            }
        }
        return produto;
    }

    public boolean emprestimoProduto (long codigo, boolean disponivel) {
        boolean statusEmprestimoProduto = false;

        for (int i = 0; i < produtos.length; i++) {
            if ((produtos[i] != null && codigo == produtos[i].codigo) && !disponivel) {
                statusEmprestimoProduto = true;
                produtos[i].disponivel = true;
                break;
            }
        }
        return statusEmprestimoProduto;

    }

    public boolean devolucaoProduto(long codigo, boolean disponivel) {
        boolean statusDevolucaoProduto = false;

        for (int i = 0; i < produtos.length; i++) {
            if ((produtos[i] != null && codigo == produtos[i].codigo) && disponivel) {
                statusDevolucaoProduto = true;
                produtos[i].disponivel = false;
                break;
            }
        }
        return statusDevolucaoProduto;

    }

    /*Busca a informação do status do livro*/
    public boolean verificadorDisponibilidadeProduto (long codigo) {
        boolean disponivel = false;

        for (int i = 0; i < produtos.length; i++) {
            if (produtos[i] != null && codigo == produtos[i].codigo) {
                disponivel = produtos[i].disponivel;
                break;
            }
        }

        return disponivel;
    }

    /* Busca a informação se o livro existe no array */
    public boolean verificadorExistenciaProduto(long codigo) {
        boolean status = false;

        for (int i = 0; i < produtos.length; i++) {
            if (produtos[i] != null && codigo == produtos[i].codigo) {
                status = true;
                break;
            }
        }

        return status;
    } 
}
