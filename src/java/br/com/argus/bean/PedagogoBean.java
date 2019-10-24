package br.com.argus.bean;

import br.com.argus.dao.PedagogoDAO;
import br.com.argus.dao.UsuarioDAO;
import br.com.argus.model.JPAUtil;
import br.com.argus.model.Pedagogo;
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
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author lucas queroz
 */
@ManagedBean(name = "pedagogoBean")
@ViewScoped
public class PedagogoBean implements Serializable {
    
    private Pedagogo pedagogo;
    
    @PostConstruct
    private void init(){
        pedagogo = new Pedagogo();
    }
    
    public void gravar(){
        
        PedagogoDAO pedagogoDAO = new PedagogoDAO();
        pedagogoDAO.gravar(pedagogo);
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/listar_pedagogo.jsf");
        } catch (IOException ex) {
            Logger.getLogger(AlunoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Pedagogo> obter(){
        List<Pedagogo> pedagogos = new ArrayList<>();
        EntityManager e = JPAUtil.getEntityManagerFactory().createEntityManager();
        Query q = e.createQuery("FROM Pedagogo");
        pedagogos = q.getResultList();
        return pedagogos;
     
    }
    
    /*public void editar(Long id){
        Usuario usuario = new Usuario();
        EntityManager e = JPAUtil.getEntityManagerFactory().createEntityManager();
        usuario = e.find(Usuario.class, id);
        //JPAUtil.shutdown();
        System.out.println("Usuario:"  + usuario.getNome());
    }*/
    
    public void editar(int id){
        PedagogoDAO pedagogoDAO = new PedagogoDAO();
        Pedagogo p = new Pedagogo();
        p = pedagogoDAO.buscar(id);
        
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("pedagogo", p);
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/editar_pedagogo.jsf");
        } catch (IOException ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void atualizar(Pedagogo pedagogo){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.editar(pedagogo);
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/listar_pedagogo.jsf");
        } catch (IOException ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminar(int id){
        PedagogoDAO pedagogoDAO = new PedagogoDAO();
        pedagogoDAO.eliminar(id);
    }

    /**
     * @return the pedagogo
     */
    public Pedagogo getPedagogo() {
        return pedagogo;
    }

    
}
