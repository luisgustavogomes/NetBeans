/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package node;

import java.util.Objects;

/**
 *
 * @author Luis Gustavo
 */
public class Aluno extends ItemGenerico<Aluno> {

    public static final String DELIMITADOR = ";";
    public static final String FINALDECURSOWINDOWS = "\r\n";

    private int idCodigo;
    private int codigo;
    private String nome;
    private String curso;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getCodigo() {
        return codigo;
    }

    public Aluno(String nome, String curso) {
        this.idCodigo = Lista.ultimoCodigo();
        this.codigo = ++this.idCodigo;
        this.nome = nome;
        this.curso = curso;
    }

    public Aluno(String linha) {
        String[] partes = linha.split(DELIMITADOR);
        this.codigo = Integer.parseInt(partes[1]);
        this.nome = partes[2];
        this.curso = partes[3];

    }

    public String getCurso() {
        return curso;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.codigo;
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + Objects.hashCode(this.curso);
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
        final Aluno other = (Aluno) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.curso, other.curso)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return Aluno.class.getSimpleName()+DELIMITADOR+String.valueOf(this.codigo) + DELIMITADOR + this.nome + DELIMITADOR + this.curso + FINALDECURSOWINDOWS;
    }

    @Override
    public String getPesquisa() {
        return this.getNome();
    }

    @Override
    public int getIdentificador() {
        return this.getCodigo();
    }

    @Override
    public int compareTo(Aluno t) {
        return this.nome.compareTo(t.nome);
    }

}
