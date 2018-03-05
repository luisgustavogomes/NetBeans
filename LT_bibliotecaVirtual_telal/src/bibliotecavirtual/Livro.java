/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecavirtual;

import java.util.Objects;

/**
 *
 * @author Luis Gustavo
 */
public class Livro {

    public static final String DELIMITADOR = ";";
    public static final String FINALDECURSOWINDOWS = "\r\n";

    private String nome;
    private String autor;
    private int numeroPaginas;
    private String editora;
    private String conteudo;

    public Livro(String nome, String autor, int numeroPaginas, String editora, String conteudo) {
        this.nome = nome;
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
        this.editora = editora;
        this.conteudo = conteudo;
    }

    public Livro(String linha) {
        String[] partes = linha.split(DELIMITADOR);
        this.nome = partes[1];
        this.autor = partes[2];
        this.numeroPaginas = Integer.parseInt(partes[3]);
        this.editora = partes[4];
        this.conteudo = partes[5];
    }

    public String getAutor() {
        return autor;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getEditora() {
        return editora;
    }

    public String getConteudo() {
        return conteudo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.nome);
        hash = 29 * hash + Objects.hashCode(this.autor);
        hash = 29 * hash + this.numeroPaginas;
        hash = 29 * hash + Objects.hashCode(this.editora);
        hash = 29 * hash + Objects.hashCode(this.conteudo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Livro other = (Livro) obj;
        if (this.numeroPaginas != other.numeroPaginas) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.autor, other.autor)) {
            return false;
        }
        if (!Objects.equals(this.editora, other.editora)) {
            return false;
        }
        if (!Objects.equals(this.conteudo, other.conteudo)) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return Livro.class.getSimpleName() + DELIMITADOR + nome + DELIMITADOR + autor + DELIMITADOR + numeroPaginas
                + DELIMITADOR + editora + DELIMITADOR + conteudo + FINALDECURSOWINDOWS;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String leitorLivro() {
        return String.format(nome);
    }

}
