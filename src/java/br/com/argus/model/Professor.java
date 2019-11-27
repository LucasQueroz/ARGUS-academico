package br.com.argus.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author lucas queroz
 */
@Entity
public class Professor implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String data_nascimento;
    private String endereco; 
    private String naturalidade;
    private int id_turma;

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
     * @return the naturalidade
     */
    public String getNaturalidade() {
        return naturalidade;
    }

    /**
     * @param naturalidade the naturalidade to set
     */
    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    /**
     * @return the id_turma
     */
    public int getId_turma() {
        return id_turma;
    }

    /**
     * @param id_turma the id_turma to set
     */
    public void setId_turma(int id_turma) {
        this.id_turma = id_turma;
    }
    
    @Override
    public String toString() {
        return String.format("%s[id=%d]", getClass().getSimpleName(), getId());
    }
    
}
