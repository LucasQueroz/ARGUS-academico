package br.com.argus.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author lucas queroz
 */
@Entity
public class Disciplina implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String codigo;
    private int carga_horaria;
    
    @ManyToOne
    private Professor professor;
    @ManyToOne
    private Curriculo curriculo;
    @ManyToOne
    private Turma turma;
    @ManyToOne
    private Ano_Letivo ano_Letivo;
    
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
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the carga_horaria
     */
    public int getCarga_horaria() {
        return carga_horaria;
    }

    /**
     * @param carga_horaria the carga_horaria to set
     */
    public void setCarga_horaria(int carga_horaria) {
        this.carga_horaria = carga_horaria;
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
     * @return the professor
     */
    public Professor getProfessor() {
        return professor;
    }

    /**
     * @param professor the professor to set
     */
    public void setProfessor(Professor professor) {
        this.professor = professor;
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
     * @return the ano_Letivo
     */
    public Ano_Letivo getAno_Letivo() {
        return ano_Letivo;
    }

    /**
     * @param ano_Letivo the ano_Letivo to set
     */
    public void setAno_Letivo(Ano_Letivo ano_Letivo) {
        this.ano_Letivo = ano_Letivo;
    }
    
    @Override
    public String toString() {
        return String.format("%s[id=%d]", getClass().getSimpleName(), getId());
    }

}
