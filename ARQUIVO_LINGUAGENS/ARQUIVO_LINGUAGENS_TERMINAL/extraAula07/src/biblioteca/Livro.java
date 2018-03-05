package biblioteca;

public class Livro extends Produto {

    String nomeAutor;
    String editora;
    String anoPublicacao;

    public Livro() {

    }

    public Livro(String nomeAutor, String editora, String anoPublicacao) {
        this.nomeAutor = nomeAutor;
        this.editora = editora;
        this.anoPublicacao = anoPublicacao;

    }

    @Override
    public String toString() {
        return super.toString()
                + "\nAutor: " + this.nomeAutor
                + "\nEditora: " + this.editora
                + "\nAno Publicação: " + this.anoPublicacao;
    }

}
