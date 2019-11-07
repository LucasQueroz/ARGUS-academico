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
public class Disciplina implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String codigo;
    private int carga_horaria;
    //private int id_professor;
    private int id_turma;
    private int id_curriculo;

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

}
