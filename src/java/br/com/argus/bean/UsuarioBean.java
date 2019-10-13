package br.com.argus.bean;

import br.com.argus.dao.UsuarioDAO;
import br.com.argus.model.JPAUtil;
import java.time.Clock;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.com.argus.model.Usuario;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ViewScoped;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas queroz
 */
@ManagedBean(name = "usuarioBean")
@ViewScoped
public class UsuarioBean implements Serializable {
    
    private Usuario usuario;
    private List<Usuario> usuarios;
    
    @PostConstruct
    private void init(){
        usuario= new Usuario();
    }
    
    public String novo(){
        Usuario u = new Usuario();
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	sessionMap.put("usuario", u);
        return "/faces/register_usuario.xhtml";
    }
    
    public void gravar(){
        //novo();
        
        //UsuarioDAO usuarioDAO = new UsuarioDAO();
        //System.out.println(usuario.getNome());
        EntityManagerFactory f = Persistence.createEntityManagerFactory("teste"); //teste
        try{
            EntityManager e = f.createEntityManager();
            e.getTransaction().begin();
            e.persist(usuario);
            e.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public List<Usuario> obterUsuarios(){
        List<Usuario> usuarios = new ArrayList<>();
        EntityManager e = JPAUtil.getEntityManagerFactory().createEntityManager(); //Persistence.createEntityManagerFactory("teste");
        Query q = e.createQuery("FROM Usuario");
        usuarios = q.getResultList();
        return usuarios;
     
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
        //JOptionPane.showMessageDialog(null, "Passei no editar com id:" + id);
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario u = new Usuario();
        u = usuarioDAO.buscar(id);
        
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("usuario", u);
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/editar_usuario.jsf");
        } catch (IOException ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //return "/editar_usuario.jsf";
    }
    
    public void atualizar(Usuario usuario){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.editar(usuario);
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/listar_usuario.jsf");
        } catch (IOException ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminar(int id){
        //JOptionPane.showMessageDialog(null, "Passei no eliminar com id: " + id);
        /*Usuario usuario = new Usuario();
        EntityManager e = JPAUtil.getEntityManagerFactory().createEntityManager();
        usuario = e.find(Usuario.class, id);*/
        //JPAUtil.shutdown();
        //System.out.println("Usuario:"  + usuario.getNome());
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.eliminar(id);
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
}
