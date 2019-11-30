package br.com.argus.model;

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
public class Parcela {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private float valor;
    private int numero_a_pagar;
    
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

    @Override
    public String toString() {
        return String.format("%s[id=%d]", getClass().getSimpleName(), getId());
    }
}
