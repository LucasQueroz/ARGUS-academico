package br.com.argus.bean;

import br.com.argus.dao.Ano_LetivoDAO;
import br.com.argus.dao.UsuarioDAO;
import br.com.argus.model.Ano_Letivo;
import br.com.argus.model.JPAUtil;
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
@ManagedBean(name = "ano_LetivoBean")
@ViewScoped
public class Ano_LetivoBean implements Serializable {
    
    private Ano_Letivo ano_Letivo;
    
    @PostConstruct
    private void init(){
        ano_Letivo = new Ano_Letivo();
    }
    
    /*public String novo(){
        Usuario u = new Usuario();
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	sessionMap.put("usuario", u);
        return "/faces/register_usuario.xhtml";
    }*/
    
    public void gravar(){
        
        Ano_LetivoDAO ano_LetivoDAO = new Ano_LetivoDAO();
        ano_LetivoDAO.gravar(getAno_Letivo());
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/listar_ano_letivo.jsf");
        } catch (IOException ex) {
            Logger.getLogger(AlunoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Ano_Letivo> obterAno_Letivo(){
        List<Ano_Letivo> ano_Letivos = new ArrayList<>();
        EntityManager e = JPAUtil.getEntityManagerFactory().createEntityManager();
        Query q = e.createQuery("FROM Ano_Letivo");
        ano_Letivos = q.getResultList();
        return ano_Letivos;
     
    }
    
    /*public void editar(Long id){
        Usuario usuario = new Usuario();
        EntityManager e = JPAUtil.getEntityManagerFactory().createEntityManager();
        usuario = e.find(Usuario.class, id);
        //JPAUtil.shutdown();
        System.out.println("Usuario:"  + usuario.getNome());
    }*/
    
    public void editar(int id){
        Ano_LetivoDAO ano_LetivoDAO = new Ano_LetivoDAO();
        Ano_Letivo a = new Ano_Letivo();
        a = ano_LetivoDAO.buscar(id);
        
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("ano_letivo", a);
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("editar_ano_letivo.jsf");
        } catch (IOException ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void atualizar(Ano_Letivo ano_Letivo){
        Ano_LetivoDAO ano_LetivoDAO = new Ano_LetivoDAO();
        ano_LetivoDAO.editar(ano_Letivo);
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/listar_ano_letivo.jsf");
        } catch (IOException ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminar(int id){
        Ano_LetivoDAO ano_LetivoDAO = new Ano_LetivoDAO();
        ano_LetivoDAO.eliminar(id);
    }

    /**
     * @return the ano_Letivo
     */
    public Ano_Letivo getAno_Letivo() {
        return ano_Letivo;
    }
}
