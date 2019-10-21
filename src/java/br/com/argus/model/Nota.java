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
public class Nota implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private float nota1;
    private float nota2;
    private float nota3;
    private float nota4;
    private float nota_na_final;
    private int id_aluno;
    private int id_diciplina;

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
     * @return the nota1
     */
    public float getNota1() {
        return nota1;
    }

    /**
     * @param nota1 the nota1 to set
     */
    public void setNota1(float nota1) {
        this.nota1 = nota1;
    }

    /**
     * @return the nota2
     */
    public float getNota2() {
        return nota2;
    }

    /**
     * @param nota2 the nota2 to set
     */
    public void setNota2(float nota2) {
        this.nota2 = nota2;
    }

    /**
     * @return the nota3
     */
    public float getNota3() {
        return nota3;
    }

    /**
     * @param nota3 the nota3 to set
     */
    public void setNota3(float nota3) {
        this.nota3 = nota3;
    }

    /**
     * @return the nota4
     */
    public float getNota4() {
        return nota4;
    }

    /**
     * @param nota4 the nota4 to set
     */
    public void setNota4(float nota4) {
        this.nota4 = nota4;
    }

    /**
     * @return the id_aluno
     */
    public int getId_aluno() {
        return id_aluno;
    }

    /**
     * @param id_aluno the id_aluno to set
     */
    public void setId_aluno(int id_aluno) {
        this.id_aluno = id_aluno;
    }

    /**
     * @return the id_diciplina
     */
    public int getId_diciplina() {
        return id_diciplina;
    }

    /**
     * @param id_diciplina the id_diciplina to set
     */
    public void setId_diciplina(int id_diciplina) {
        this.id_diciplina = id_diciplina;
    }

    /**
     * @return the nota_na_final
     */
    public float getNota_na_final() {
        return nota_na_final;
    }

    /**
     * @param nota_na_final the nota_na_final to set
     */
    public void setNota_na_final(float nota_na_final) {
        this.nota_na_final = nota_na_final;
    }
    
}
