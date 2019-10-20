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
    private int numero_pago;
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
     * @return the numero_pago
     */
    public int getNumero_pago() {
        return numero_pago;
    }

    /**
     * @param numero_pago the numero_pago to set
     */
    public void setNumero_pago(int numero_pago) {
        this.numero_pago = numero_pago;
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
    
}
