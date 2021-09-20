package modelo;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.data.geo.Point;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Cidade")
@Table(name = "CIDADE")
@TypeDefs(value = { @TypeDef(name = "point", typeClass = TipoPonto.class) })
public class Cidade {

    @Id
    private Long id;

    private String nome;
    private String uf;
    private Integer codigoIBGE;

    // 1ª opção
    @Column(name = "lat_long")
    private String geoLocalizacao;

    // 2ª opção
    @Type(type = "point")
    @Column(name="lat_long", updatable = false, insertable = false)
    private Point localizacao;

    /**
     * Construtor padrão.
     */
    public Cidade() {
    }

    /**
     * Construtor para todos os atributos da classe.
     * @param id Identificador da Cidade
     * @param nome Nome da cidade
     * @param uf Unidade Federativa
     * @param codigoIBGE Código do IBGE
     * @param geoLocalizacao Geolocalização em String
     * @param localizacao Geolocalização em Point
     */
    public Cidade(Long id, String nome, String uf, Integer codigoIBGE, String geoLocalizacao, Point localizacao) {
        this.id = id;
        this.nome = nome;
        this.uf = uf;
        this.codigoIBGE = codigoIBGE;
        this.geoLocalizacao = geoLocalizacao;
        this.localizacao = localizacao;
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

    public String getGeoLocalizacao() {
        return geoLocalizacao;
    }

    public void setGeoLocalizacao(String geoLocalizacao) {
        this.geoLocalizacao = geoLocalizacao;
    }

    public Point getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Point localizacao) {
        this.localizacao = localizacao;
    }

}
