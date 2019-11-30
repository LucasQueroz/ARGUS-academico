 package br.com.argus.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author lucas queroz
 */
@Entity
public class Aluno implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String pai;
    private String mae;
    private String endereco;
    private String data_nascimento;
    private String naturaliadade;
    
    @ManyToOne
    private Turma turma;
    @ManyToOne
    private Curriculo curriculo;
    @ManyToOne
    private Responsavel responsavel;
    @ManyToOne
    private Ano_Letivo ano_Letivo;
    @OneToOne
    private Parcela parcela;

    public void setAno_Letivo(Ano_Letivo ano_Letivo) {
        this.ano_Letivo = ano_Letivo;
    }

    public Ano_Letivo getAno_Letivo() {
        return ano_Letivo;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the pai
     */
    public String getPai() {
        return pai;
    }

    /**
     * @param pai the pai to set
     */
    public void setPai(String pai) {
        this.pai = pai;
    }

    /**
     * @return the mae
     */
    public String getMae() {
        return mae;
    }

    /**
     * @param mae the mae to set
     */
    public void setMae(String mae) {
        this.mae = mae;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the data_nascimento
     */
    public String getData_nascimento() {
        return data_nascimento;
    }

    /**
     * @param data_nascimento the data_nascimento to set
     */
    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    /**
     * @return the naturaliadade
     */
    public String getNaturaliadade() {
        return naturaliadade;
    }

    /**
     * @param naturaliadade the naturaliadade to set
     */
    public void setNaturaliadade(String naturaliadade) {
        this.naturaliadade = naturaliadade;
    }

    /**
     * @return the turma
     */
    public Turma getTurma() {
        return turma;
    }

    /**
     * @param turma the turma to set
     */
    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    /**
     * @return the curriculo
     */
    public Curriculo getCurriculo() {
        return curriculo;
    }

    /**
     * @param curriculo the curriculo to set
     */
    public void setCurriculo(Curriculo curriculo) {
        this.curriculo = curriculo;
    }

    /**
     * @return the responsavel
     */
    public Responsavel getResponsavel() {
        return responsavel;
    }

    /**
     * @param responsavel the responsavel to set
     */
    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }
    
    /**
     * @return the parcela
     */
    public Parcela getParcela() {
        return parcela;
    }

    /**
     * @param parcela the parcela to set
     */
    public void setParcela(Parcela parcela) {
        this.parcela = parcela;
    }

    @Override
    public String toString() {
        return String.format("%s[id=%d]", getClass().getSimpleName(), getId());
    }

}
