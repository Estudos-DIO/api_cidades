package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe para representar o país.
 */
@Entity(name = "Pais")
@Table(name = "PAIS")
public class Pais {

    @Id
    private Long id;

    @Column(name="nome")
    private String nome;

    @Column(name="nome_pt")
    private String nomeEmPortugues;

    @Column(name="sigla")
    private String sigla;

    @Column(name="bacen")
    private Integer bacen;

    /**
     * Construtor padrão.
     */
    public Pais() {
    }

    /**
     * Construtor para todos os atributos da classe.
     * @param id Identificador do país
     * @param nome Nome do país
     * @param nomeEmPortugues Nome do país em português
     * @param sigla Sigla no país
     * @param bacen Código do Banco Central utilizado para representar o país
     */
    public Pais(Long id, String nome, String nomeEmPortugues, String sigla, Integer bacen) {
        this.id = id;
        this.nome = nome;
        this.nomeEmPortugues = nomeEmPortugues;
        this.sigla = sigla;
        this.bacen = bacen;
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

    public String getNomeEmPortugues() {
        return nomeEmPortugues;
    }

    public void setNomeEmPortugues(String nomeEmPortugues) {
        this.nomeEmPortugues = nomeEmPortugues;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Integer getBacen() {
        return bacen;
    }

    public void setBacen(Integer bacen) {
        this.bacen = bacen;
    }

}
