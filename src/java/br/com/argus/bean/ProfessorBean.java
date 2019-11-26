package br.com.argus.bean;

import br.com.argus.dao.ProfessorDAO;
import br.com.argus.dao.UsuarioDAO;
import br.com.argus.model.JPAUtil;
import br.com.argus.model.Professor;
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
//import javax.swing.JOptionPane;

/**
 *
 * @author lucas queroz
 */
@ManagedBean(name = "professorBean")
@ViewScoped
public class ProfessorBean implements Serializable {
    
    private Professor professor;
    
    @PostConstruct
    private void init(){
        professor = new Professor();
    }
    
    public void gravar(){
        ProfessorDAO professorDao = new ProfessorDAO();
        professorDao.gravar(professor);
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("listar_professor.jsf");
        } catch (IOException ex) {
            Logger.getLogger(AlunoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Professor> obter(){
        List<Professor> usuarios = new ArrayList<>();
        EntityManager e = JPAUtil.getEntityManagerFactory().createEntityManager();
        Query q = e.createQuery("FROM Professor");
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
        ProfessorDAO professorDAO = new ProfessorDAO();
        Professor p = new Professor();
        p = professorDAO.buscar(id);
        
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("professor", p);
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("editar_professor.jsf");
        } catch (IOException ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //return "/editar_usuario.jsf";
    }
    
    public void atualizar(Professor professor){
        ProfessorDAO professorDAO = new ProfessorDAO();
        professorDAO.editar(professor);
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("listar_professor.jsf");
        } catch (IOException ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminar(int id){
        ProfessorDAO professorDAO = new ProfessorDAO();
        professorDAO.eliminar(id);
    }

    /**
     * @return the professor
     */
    public Professor getProfessor() {
        return professor;
    }
    
}
