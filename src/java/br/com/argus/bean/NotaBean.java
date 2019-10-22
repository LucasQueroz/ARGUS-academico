package br.com.argus.bean;

import br.com.argus.dao.AlunoDAO;
import br.com.argus.dao.NotaDAO;
import br.com.argus.dao.UsuarioDAO;
import br.com.argus.model.Aluno;
import br.com.argus.model.JPAUtil;
import br.com.argus.model.Nota;
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
@ManagedBean(name = "notaBean")
@ViewScoped
public class NotaBean implements Serializable{
    
    private Nota nota;
    //private NotaDAO notaDAO;
    
    @PostConstruct
    private void init(){
        nota = new Nota();
    }
    
    public void novo(int id){
        
        AlunoDAO alunoDAO = new AlunoDAO();
        Aluno a = new Aluno();
        a = alunoDAO.buscar(id);
        
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("aluno", a);
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/register_notas.jsf");
        } catch (IOException ex) {
            Logger.getLogger(AlunoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void gravar(int id_aluno){
        nota.setId_aluno(id_aluno);
        
        NotaDAO notaDAO = new NotaDAO();
        notaDAO.gravar(nota);
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/listar_alunos.jsf");
        } catch (IOException ex) {
            Logger.getLogger(AlunoBean.class.getName()).log(Level.SEVERE, null, ex);
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

    /**
     * @return the nota
     */
    public Nota getNota() {
        return nota;
    }

}
