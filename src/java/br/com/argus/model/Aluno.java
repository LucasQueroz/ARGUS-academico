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
    private int id_curriculo;
    private int id_turma;
    private int id_responsavel;
    private int id_disciplina;
    
    //@OneToMany(cascade = CascadeType.ALL)
    //private List<Atendimento_Pedagogico> atendimento_pedagogicos;
    
    //@OneToMany(fetch = FetchType.LAZY)
    //@JoinColumn(name = "id_atendimento_pedagogico")
    //private Atendimento_Pedagogico atendimento_Pedagogico;
    
    
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
     * @return the id_curriculo
     */
    public int getId_curriculo() {
        return id_curriculo;
    }

    /**
     * @param id_curriculo the id_curriculo to set
     */
    public void setId_curriculo(int id_curriculo) {
        this.id_curriculo = id_curriculo;
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

    /**
     * @return the id_responsavel
     */
    public int getId_responsavel() {
        return id_responsavel;
    }

    /**
     * @param id_responsavel the id_responsavel to set
     */
    public void setId_responsavel(int id_responsavel) {
        this.id_responsavel = id_responsavel;
    }

    /**
     * @return the id_disciplina
     */
    public int getId_disciplina() {
        return id_disciplina;
    }

    /**
     * @param id_disciplina the id_disciplina to set
     */
    public void setId_disciplina(int id_disciplina) {
        this.id_disciplina = id_disciplina;
    }

    @Override
    public String toString() {
        return String.format("%s[id=%d]", getClass().getSimpleName(), getId());
    }

}
