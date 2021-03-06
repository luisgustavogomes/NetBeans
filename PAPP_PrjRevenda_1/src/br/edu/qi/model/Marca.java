package br.edu.qi.model;
// Generated 02/11/2017 10:18:25 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Marca generated by hbm2java
 */
@Entity
@Table(name = "marca",
        catalog = "dbrevenda"
)
public class Marca implements java.io.Serializable {

    private Integer idMarca;
    private String descricao;
    private Set<Carro> carros = new HashSet<Carro>(0);

    public Marca() {
    }

    public Marca(String descricao, Set<Carro> carros) {
        this.descricao = descricao;
        this.carros = carros;
    }

    public Marca(String descricao) {
        this.descricao = descricao;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "id_marca", unique = true, nullable = false)
    public Integer getIdMarca() {
        return this.idMarca;
    }

    public void setIdMarca(Integer idMarca) {
        this.idMarca = idMarca;
    }

    @Column(name = "descricao", length = 100)
    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "marca")
    public Set<Carro> getCarros() {
        return this.carros;
    }

    public void setCarros(Set<Carro> carros) {
        this.carros = carros;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.descricao);
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
        final Marca other = (Marca) obj;
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return descricao;
    }

}
