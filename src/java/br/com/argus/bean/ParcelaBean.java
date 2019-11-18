package br.com.argus.bean;

import br.com.argus.dao.AlunoDAO;
import br.com.argus.dao.ParcelaDAO;
import br.com.argus.dao.ResponsavelDAO;
import br.com.argus.dao.UsuarioDAO;
import br.com.argus.model.JPAUtil;
import br.com.argus.model.Parcela;
import br.com.argus.model.Responsavel;
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
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author lucas queroz
 */
@ManagedBean(name = "parcelaBean")
@ViewScoped
public class ParcelaBean implements Serializable {
    
    private Parcela parcela;
    
    @PostConstruct
    private void init(){
        parcela= new Parcela();
    }
    
    public void listar(int id_responsavel){
        parcela.setId_responsavel(id_responsavel);
         try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/listar_parcela.jsf");
        } catch (IOException ex) {
            Logger.getLogger(AlunoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void novo(int id){
        ResponsavelDAO parcelaDAO = new ResponsavelDAO();
        Responsavel r = new Responsavel();
        r = parcelaDAO.buscar(id);
        
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("responsavel", r);
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/register_parcela.jsf");
        } catch (IOException ex) {
            Logger.getLogger(AlunoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void gravar(int id_responsavel){
        parcela.setNumero_a_pagar(12);
        parcela.setId_responsavel(id_responsavel);
        
        ParcelaDAO parcelaDAO = new ParcelaDAO();
        parcelaDAO.gravar(parcela);
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("listar_alunos.jsf");
        } catch (IOException ex) {
            Logger.getLogger(AlunoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Parcela> obter(){
        List<Parcela> parcelas = new ArrayList<>();
        EntityManager e = JPAUtil.getEntityManagerFactory().createEntityManager();
        Query q = e.createQuery("FROM Parcela");
        parcelas = q.getResultList();
        return parcelas;
     
    }
    
    /*public void editar(Long id){
        Usuario usuario = new Usuario();
        EntityManager e = JPAUtil.getEntityManagerFactory().createEntityManager();
        usuario = e.find(Usuario.class, id);
        //JPAUtil.shutdown();
        System.out.println("Usuario:"  + usuario.getNome());
    }*/
    
    public void editar(int id){
        ParcelaDAO parcelaDAO = new ParcelaDAO();
        Parcela p = new Parcela();
        p = parcelaDAO.buscar(id);
        
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("parcela", p);
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("editar_parcela.jsf");
        } catch (IOException ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void atualizar(Parcela parcela){
        ParcelaDAO parcelaDAO= new ParcelaDAO();
        parcelaDAO.editar(parcela);
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("listar_parcela.jsf");
        } catch (IOException ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void atualizar(Parcela parcela, int numero_a_pagar){
        parcela.setNumero_a_pagar(numero_a_pagar - 1);
        ParcelaDAO parcelaDAO= new ParcelaDAO();
        parcelaDAO.editar(parcela);
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("listar_parcela.jsf");
        } catch (IOException ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminar(int id){
        ParcelaDAO parcelaDAO = new ParcelaDAO();
        parcelaDAO.eliminar(id);
    }

    /**
     * @return the parcela
     */
    public Parcela getParcela() {
        return parcela;
    }
}
