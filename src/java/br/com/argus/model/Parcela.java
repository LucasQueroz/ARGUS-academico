package br.com.argus.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author lucas queroz
 */
@Entity
public class Parcela {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private float valor;
    private int numero_a_pagar;
    private int id_responsavel;

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
     * @return the valor
     */
    public float getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(float valor) {
        this.valor = valor;
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
     * @return the numero_a_pagar
     */
    public int getNumero_a_pagar() {
        return numero_a_pagar;
    }

    /**
     * @param numero_a_pagar the numero_a_pagar to set
     */
    public void setNumero_a_pagar(int numero_a_pagar) {
        this.numero_a_pagar = numero_a_pagar;
    }
    
}
