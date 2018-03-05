package br.edu.qi.entity;
// Generated 29/11/2017 21:51:45 by Hibernate Tools 4.3.1

import br.edu.qi.utl.HelperDate;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Refeicao generated by hbm2java
 */
@Entity
@Table(name = "refeicao",
         catalog = "refeicao"
)
public class Refeicao implements java.io.Serializable {

    private Integer idRefeicao;
    private Foto foto;
    private String descricao;
    private Date dataCadastro;
    private Set<Menu> menus = new HashSet<Menu>(0);

    public Refeicao() {
    }

    public Refeicao(Integer idRefeicao, Foto foto, String descricao, Date dataCadastro) {
        this.idRefeicao = idRefeicao;
        this.foto = foto;
        this.descricao = descricao;
        this.dataCadastro = dataCadastro;
    }

    public Refeicao(Integer idRefeicao, String descricao, Date dataCadastro) {
        this.idRefeicao = idRefeicao;
        this.foto = foto;
        this.descricao = descricao;
        this.dataCadastro = dataCadastro;
    }

    public Refeicao(Foto foto, String descricao, Date dataCadastro) {
        this.foto = foto;
        this.descricao = descricao;
        this.dataCadastro = dataCadastro;
    }

    public Refeicao(Foto foto, String descricao) {
        this.foto = foto;
        this.descricao = descricao;
    }

    public Refeicao(Foto foto, String descricao, Date dataCadastro, Set<Menu> menus) {
        this.foto = foto;
        this.descricao = descricao;
        this.dataCadastro = dataCadastro;
        this.menus = menus;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "id_refeicao", unique = true, nullable = false)
    public Integer getIdRefeicao() {
        return this.idRefeicao;
    }

    public void setIdRefeicao(Integer idRefeicao) {
        this.idRefeicao = idRefeicao;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_foto", nullable = false)
    public Foto getFoto() {
        return this.foto;
    }

    public void setFoto(Foto foto) {
        this.foto = foto;
    }

    @Column(name = "descricao", nullable = false, length = 1000)
    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_cadastro", length = 19)
    public Date getDataCadastro() {
        return this.dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "refeicao")
    public Set<Menu> getMenus() {
        return this.menus;
    }

    public void setMenus(Set<Menu> menus) {
        this.menus = menus;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.descricao);
        hash = 37 * hash + Objects.hashCode(this.dataCadastro);
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
        final Refeicao other = (Refeicao) obj;
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        //porque está vindo Timestamp
        GregorianCalendar gCalendar = new GregorianCalendar();   
        gCalendar.setTimeInMillis(this.dataCadastro.getTime());   
	Date data = gCalendar.getTime();
        String r = new SimpleDateFormat("yyyy-MM-dd").format(data);
        return Objects.equals(data, other.dataCadastro);
    }

    
    

    @Override
    public String toString() {
        return descricao;
    }

}