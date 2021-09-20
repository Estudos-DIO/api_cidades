package modelo;

import org.hibernate.annotations.Type;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;

@Entity(name = "Estado")
@Table(name="ESTADO")
public class Estado {

    @Id
    private Long id;

    @Column(name = "nome")
    private String nome;

    private String uf;

    @Column(name = "ibge")
    private Integer codigoIBGE;

    @ManyToOne
    @JoinColumn(name = "Pais", referencedColumnName = "id")
    private Pais pais;

    @Type(type = "jsonb")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "ddd", columnDefinition = "jsonb")
    private List<Integer> ddd;

    /**
     * Construtor padrão.
     */
    public Estado() {
    }

    /**
     * Construtor para todos os atributos da classe
     * @param id Identificador da classe
     * @param nome Nome do estado
     * @param uf Unidade Federativa da União
     * @param codigoIBGE Código IBGE
     * @param pais País
     * @param ddd DDD
     */
    public Estado(Long id, String nome, String uf, Integer codigoIBGE, Pais pais, List<Integer> ddd) {
        this.id = id;
        this.nome = nome;
        this.uf = uf;
        this.codigoIBGE = codigoIBGE;
        this.pais = pais;
        this.ddd = ddd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Integer getCodigoIBGE() {
        return codigoIBGE;
    }

    public void setCodigoIBGE(Integer codigoIBGE) {
        this.codigoIBGE = codigoIBGE;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public List<Integer> getDdd() {
        return ddd;
    }

    public void setDdd(List<Integer> ddd) {
        this.ddd = ddd;
    }

}
