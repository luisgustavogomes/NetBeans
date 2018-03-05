package crud;

import java.util.Date;
import java.util.Objects;

public class Produto implements Comparable<Produto>{

    private int id;
    private String nome;
    private double preco;
    private Date data;

    public Produto(int id, String nome, double preco, Date data) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public Date getData() {
        return data;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + this.id;
        hash = 11 * hash + Objects.hashCode(this.nome);
        hash = 11 * hash + (int) (Double.doubleToLongBits(this.preco) ^ (Double.doubleToLongBits(this.preco) >>> 32));
        hash = 11 * hash + Objects.hashCode(this.data);
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
        final Produto other = (Produto) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.preco) != Double.doubleToLongBits(other.preco)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Produto t) {
        return this.nome.compareTo(t.nome);
    }


}
