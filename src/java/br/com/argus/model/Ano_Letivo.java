package br.com.argus.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Query;

/**
 *
 * @author lucas queroz
 */
@Entity
public class Ano_Letivo implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    //private int id_curriculo;
    
    @OneToOne
    private Curriculo curriculo;

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

    public List<Ano_Letivo> listar() {
        List<Ano_Letivo> ano_Letivos = new ArrayList<>();
        EntityManager e = JPAUtil.getEntityManagerFactory().createEntityManager();
        Query q = e.createQuery("FROM Ano_Letivo");
        ano_Letivos = q.getResultList();
        return ano_Letivos;
    }
    
    @Override
    public String toString() {
        return String.format("%s[id=%d]", getClass().getSimpleName(), getId());
    }
    
}
