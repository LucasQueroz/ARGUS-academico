package br.com.argus.bean;

import br.com.argus.dao.DisciplinaDAO;
import br.com.argus.dao.ProfessorDAO;
import br.com.argus.model.Ano_Letivo;
import br.com.argus.model.Disciplina;
import br.com.argus.model.JPAUtil;
import br.com.argus.model.Professor;
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
    private List<Ano_Letivo> ano_letivos;
    private List<Professor> professores;
    
    @PostConstruct
    private void init(){
        disciplina = new Disciplina();
        Ano_Letivo ano_Letivos = new Ano_Letivo();
        setAno_letivos(ano_Letivos.listar());
        
        ProfessorDAO professorDAO = new ProfessorDAO();
        professores = professorDAO.listar();
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

    /**
     * @return the ano_letivos
     */
    public List<Ano_Letivo> getAno_letivos() {
        return ano_letivos;
    }

    /**
     * @param ano_letivos the ano_letivos to set
     */
    public void setAno_letivos(List<Ano_Letivo> ano_letivos) {
        this.ano_letivos = ano_letivos;
    }

    /**
     * @return the professores
     */
    public List<Professor> getProfessores() {
        return professores;
    }

}
