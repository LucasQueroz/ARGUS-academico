package br.com.argus.bean;

import br.com.argus.dao.TurmaDAO;
import br.com.argus.model.JPAUtil;
import br.com.argus.model.Turma;
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
@ManagedBean(name = "turmaBean")
@ViewScoped
public class TurmaBean implements Serializable {
    
    private Turma turma;
    
    @PostConstruct
    private void init(){
        turma = new Turma();
    }
    
    /*public String novo(){
        Usuario u = new Usuario();
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	sessionMap.put("usuario", u);
        return "/faces/register_usuario.xhtml";
    }*/
    
    public void gravar(){
        
        TurmaDAO turmaDAO = new TurmaDAO();
        turmaDAO.gravar(getTurma());
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/listar_turma.jsf");
        } catch (IOException ex) {
            Logger.getLogger(AlunoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Turma> obter(){
        List<Turma> turmas = new ArrayList<>();
        EntityManager e = JPAUtil.getEntityManagerFactory().createEntityManager();
        Query q = e.createQuery("FROM Turma");
        turmas = q.getResultList();
        return turmas;
     
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
        TurmaDAO turamDAO = new TurmaDAO();
        Turma t = new Turma();
        t = turamDAO.buscar(id);
        
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("turma", t);
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/editar_turma.jsf");
        } catch (IOException ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void atualizar(Turma turma){
        TurmaDAO turmaDAO = new TurmaDAO();
        turmaDAO.editar(turma);
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/listar_turma.jsf");
        } catch (IOException ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminar(int id){
        TurmaDAO turmaDAO = new TurmaDAO();
        turmaDAO.eliminar(id);
    }

    /**
     * @return the turma
     */
    public Turma getTurma() {
        return turma;
    }
    
}
