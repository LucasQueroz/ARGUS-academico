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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ViewScoped;
import javax.persistence.Query;

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
    
    public void editar(Long id){
        Usuario usuario = new Usuario();
        EntityManager e = JPAUtil.getEntityManagerFactory().createEntityManager();
        usuario = e.find(Usuario.class, id);
        //JPAUtil.shutdown();
        System.out.println("Usuario:"  + usuario.getNome());
    }
    
    public void eliminar(Long id){
        Usuario usuario = new Usuario();
        EntityManager e = JPAUtil.getEntityManagerFactory().createEntityManager();
        usuario = e.find(Usuario.class, id);
        //JPAUtil.shutdown();
        System.out.println("Usuario:"  + usuario.getNome());
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
}
