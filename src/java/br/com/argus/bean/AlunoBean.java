package br.com.argus.bean;

import br.com.argus.bussiness.Matricula;
import br.com.argus.dao.AlunoDAO;
import br.com.argus.dao.Ano_LetivoDAO;
import br.com.argus.dao.CurriculoDAO;
import br.com.argus.dao.ParcelaDAO;
import br.com.argus.dao.ResponsavelDAO;
import br.com.argus.model.Aluno;
import br.com.argus.model.Ano_Letivo;
import br.com.argus.model.Curriculo;
import br.com.argus.model.JPAUtil;
import br.com.argus.model.Parcela;
import br.com.argus.model.Responsavel;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas queroz
 */
@ManagedBean(name = "alunoBean")
@ViewScoped
public class AlunoBean implements Serializable {
    
    private Aluno aluno;
    private List<Responsavel> responsaveis;
    private List<Curriculo> curriculos;
    
    @PostConstruct
    private void init(){
        aluno = new Aluno();
        ResponsavelDAO responsavelDAO = new ResponsavelDAO();
        setResponsaveis(responsavelDAO.listar());
        
        CurriculoDAO curriculoDAO = new CurriculoDAO();
        setCurriculos(curriculoDAO.listar());
    }
    
    public void matricularAluno(int id){
        AlunoDAO alunoDAO = new AlunoDAO();
        Aluno a = new Aluno();
        a = alunoDAO.buscar(id);
        
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("aluno", a);
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("matricular_aluno.jsf");
        } catch (IOException ex) {
            Logger.getLogger(AlunoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    /*public void registrarMatricola(){
        
        Matricula matricula = new Matricula();
        ParcelaDAO parcelaDAO = new ParcelaDAO();
        
        Parcela parcela = new Parcela();
        parcela.setNumero_a_pagar(12);
        parcela.setValor(matricula.valorDaParcela(this.aluno.getAno_Letivo().getCurriculo().getNome()));
        
        parcelaDAO.gravar(parcela);
        aluno.setParcela(parcela);
        
        JOptionPane.showMessageDialog(null, "Aluno nome:" + aluno.getNome());
        AlunoDAO alunoDAO = new AlunoDAO();
        alunoDAO.editar(aluno);
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("listar_alunos.jsf");
        } catch (IOException ex) {
            Logger.getLogger(AlunoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    
    
    
    public void registrarMatricola(Aluno aluno){
        //JOptionPane.showMessageDialog(null, "Passei 0");
        
        Matricula matricula = new Matricula();
        ParcelaDAO parcelaDAO = new ParcelaDAO();
        
        Parcela parcela = new Parcela();
        parcela.setNumero_a_pagar(12);
        parcela.setValor(matricula.valorDaParcela(this.aluno.getCurriculo().getNome()));
        
        AlunoDAO alunoDAO = new AlunoDAO();
        Aluno alunoSetar = alunoDAO.buscar(aluno.getId());
        
        //JOptionPane.showMessageDialog(null, "Passei 1");
        
        parcelaDAO.gravar(parcela);
        alunoSetar.setParcela(parcela);
        alunoSetar.setCurriculo(this.aluno.getCurriculo());
        
        //JOptionPane.showMessageDialog(null, "Curriculo nome:" + this.aluno.getCurriculo().getNome());
        
        alunoSetar.setAno_Letivo(matricula.selecionaAnoLetivo(this.aluno.getCurriculo().getNome()));
        
        //JOptionPane.showMessageDialog(null, "Aluno nome:" + alunoSetar.getNome());
        //AlunoDAO alunoDAO = new AlunoDAO();
        alunoDAO.editar(alunoSetar);
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("listar_alunos.jsf");
        } catch (IOException ex) {
            Logger.getLogger(AlunoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void gravar(){
        AlunoDAO alunoDAO = new AlunoDAO();
        alunoDAO.gravar(aluno);
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("listar_alunos.jsf");
        } catch (IOException ex) {
            Logger.getLogger(AlunoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminar(int id){
        AlunoDAO alunoDAO = new AlunoDAO();
        alunoDAO.eliminar(id);
    }
    
    public void editar(int id){
        AlunoDAO alunoDAO = new AlunoDAO();
        Aluno a = new Aluno();
        a = alunoDAO.buscar(id);
        
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("aluno", a);
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("editar_aluno.jsf");
        } catch (IOException ex) {
            Logger.getLogger(AlunoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void atualizar(Aluno aluno){
        AlunoDAO alunoDAO = new AlunoDAO();
        alunoDAO.editar(aluno);
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("listar_alunos.jsf");
        } catch (IOException ex) {
            Logger.getLogger(AlunoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Aluno> obterAluno(){
        AlunoDAO alunoDAO = new AlunoDAO();
        return alunoDAO.listar();
    }

    /**
     * @return the aluno
     */
    public Aluno getAluno() {
        return aluno;
    }

    /**
     * @return the responsaveis
     */
    public List<Responsavel> getResponsaveis() {
        return responsaveis;
    }

    /**
     * @param responsaveis the responsaveis to set
     */
    public void setResponsaveis(List<Responsavel> responsaveis) {
        this.responsaveis = responsaveis;
    }

    /**
     * @return the curriculos
     */
    public List<Curriculo> getCurriculos() {
        return curriculos;
    }

    /**
     * @param curriculos the curriculos to set
     */
    public void setCurriculos(List<Curriculo> curriculos) {
        this.curriculos = curriculos;
    }

}
