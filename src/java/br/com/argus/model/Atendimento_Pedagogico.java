package br.com.argus.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author lucas queroz
 */
@Entity
public class Atendimento_Pedagogico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String detalhamento;
    private String data;
    private boolean concluido;
    private int id_pedagogo;
    private int id_usuario;
    private int id_aluno;
    @ManyToOne
    private Aluno aluno;
    
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
     * @return the detalhamento
     */
    public String getDetalhamento() {
        return detalhamento;
    }

    /**
     * @param detalhamento the detalhamento to set
     */
    public void setDetalhamento(String detalhamento) {
        this.detalhamento = detalhamento;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the concluido
     */
    public boolean isConcluido() {
        return concluido;
    }

    /**
     * @param concluido the concluido to set
     */
    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }

    /**
     * @return the id_pedagogo
     */
    public int getId_pedagogo() {
        return id_pedagogo;
    }

    /**
     * @param id_pedagogo the id_pedagogo to set
     */
    public void setId_pedagogo(int id_pedagogo) {
        this.id_pedagogo = id_pedagogo;
    }

    /**
     * @return the id_usuario
     */
    public int getId_usuario() {
        return id_usuario;
    }

    /**
     * @param id_usuario the id_usuario to set
     */
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
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
     * @return the aluno
     */
    //@ManyToOne
    //@JoinColumn(name = "id_aluno")
    public Aluno getAluno() {
        return aluno;
    }

    /**
     * @param aluno the aluno to set
     */
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    /**
     * @return the alunos
     *
    public List<Aluno> getAlunos() {
        return alunos;
    }*/

    /**
     * @param alunos the alunos to set
     *
    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }*/
    
}
