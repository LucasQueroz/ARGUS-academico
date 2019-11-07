package br.com.argus.bean;

import br.com.argus.dao.DisciplinaDAO;
import br.com.argus.model.Disciplina;
import br.com.argus.model.JPAUtil;
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
@ManagedBean(name = "disciplinaBean")
@ViewScoped
public class DisciplinaBean implements Serializable {
    
    private Disciplina disciplina;
    
    @PostConstruct
    private void init(){
        disciplina = new Disciplina();
    }
    
    public void gravar(){
        DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
        disciplinaDAO.gravar(disciplina);
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("listar_disciplina.jsf");
        } catch (IOException ex) {
            Logger.getLogger(AlunoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Disciplina> obter(){
        List<Disciplina> diciplinas = new ArrayList<>();
        EntityManager e = JPAUtil.getEntityManagerFactory().createEntityManager();
        Query q = e.createQuery("FROM Disciplina");
        diciplinas = q.getResultList();
        return diciplinas;
     
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
        DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
        Disciplina d = new Disciplina();
        d = disciplinaDAO.buscar(id);
        
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("disciplina", d);
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("editar_disciplina.jsf");
        } catch (IOException ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void atualizar(Disciplina disciplina){
        DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
        disciplinaDAO.editar(disciplina);
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("listar_disciplina.jsf");
        } catch (IOException ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminar(int id){
        DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
        disciplinaDAO.eliminar(id);
    }

    /**
     * @return the disciplina
     */
    public Disciplina getDisciplina() {
        return disciplina;
    }

}
