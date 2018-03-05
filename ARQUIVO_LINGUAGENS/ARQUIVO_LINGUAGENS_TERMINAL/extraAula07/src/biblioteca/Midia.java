package biblioteca;

public class Midia extends Produto {

    String duracao;
    String diretor;

    public Midia() {

    }

    public Midia(String duracao, String diretor) {
        this.duracao = duracao;
        this.diretor = diretor;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nDuração: " + this.duracao
                + "\nDiretor: " + this.diretor;
    }
}
