package br.com.argus.bean;

import br.com.argus.dao.ResponsavelDAO;
import br.com.argus.dao.UsuarioDAO;
import br.com.argus.model.JPAUtil;
import br.com.argus.model.Responsavel;
import br.com.argus.model.Usuario;
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
@ManagedBean(name = "responsavelBean")
@ViewScoped
public class ResponsavelBean implements Serializable {
    
    private Responsavel responsavel;
    
    @PostConstruct
    private void init(){
        responsavel = new Responsavel();
    }
    
    public void gravar(){
        ResponsavelDAO responsavelDAO = new ResponsavelDAO();
        responsavelDAO.gravar(responsavel);
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/listar_responsavel.jsf");
        } catch (IOException ex) {
            Logger.getLogger(AlunoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Responsavel> obter(){
        List<Responsavel> responsavels = new ArrayList<>();
        EntityManager e = JPAUtil.getEntityManagerFactory().createEntityManager();
        Query q = e.createQuery("FROM Responsavel");
        responsavels = q.getResultList();
        return responsavels;
     
    }
    
    /*public void editar(Long id){
        Usuario usuario = new Usuario();
        EntityManager e = JPAUtil.getEntityManagerFactory().createEntityManager();
        usuario = e.find(Usuario.class, id);
        //JPAUtil.shutdown();
        System.out.println("Usuario:"  + usuario.getNome());
    }*/
    
    /*public static void main(String[] args) {
        editar();
    }*/
    
    public void editar(int id){
        ResponsavelDAO responsavelDAO = new ResponsavelDAO();
        Responsavel r = new Responsavel();
        r = responsavelDAO.buscar(id);
        
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("responsavel", r);
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/editar_responsavel.jsf");
        } catch (IOException ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void atualizar(Responsavel responsavel){
        ResponsavelDAO responsavelDAO = new ResponsavelDAO();
        responsavelDAO.editar(responsavel);
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/listar_responsavel.jsf");
        } catch (IOException ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminar(int id){
        ResponsavelDAO responsavelDAO = new ResponsavelDAO();
        responsavelDAO.eliminar(id);
    }

    /**
     * @return the responsavel
     */
    public Responsavel getResponsavel() {
        return responsavel;
    }
    
}
