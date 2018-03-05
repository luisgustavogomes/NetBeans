package biblioteca;

public class Produto {

    long codigo;
    String titulo;
    String genero;
    boolean disponivel;

    public Produto() {
    }

    public Produto(long codigo, String titulo, String genero, boolean disponivel) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.genero = genero;
        this.disponivel = disponivel;
    }
    
    @Override
    public String toString() {
        return "Codigo: " + this.codigo +
             "\nTitulo: " + this.titulo +
             "\nGenero: " + this.genero +
             "\nDisponível: " + this.disponivel;
    }
}
