package br.com.argus.bean;

import br.com.argus.dao.AlunoDAO;
import br.com.argus.dao.DisciplinaDAO;
import br.com.argus.dao.NotaDAO;
import br.com.argus.model.Aluno;
import br.com.argus.model.Disciplina;
import br.com.argus.model.JPAUtil;
import br.com.argus.model.Nota;
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
import javax.swing.JOptionPane;

/**
 *
 * @author lucas queroz
 */
@ManagedBean(name = "notaBean")
@ViewScoped
public class NotaBean implements Serializable{
    
    private Nota nota;
    private List<Disciplina> disciplinas;
    //private NotaDAO notaDAO;
    
    @PostConstruct
    private void init(){
        nota = new Nota();
        
        //DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
        //disciplinas = disciplinaDAO.listar();
        
        DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
        disciplinas = disciplinaDAO.listar();
        JOptionPane.showMessageDialog(null, "Iniciando...");
        
    }
    
    /*public void novo(int id){
        AlunoDAO alunoDAO = new AlunoDAO();
        Aluno a = new Aluno();
        a = alunoDAO.buscar(id);
        
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("aluno", a);
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("register_notas.jsf");
        } catch (IOException ex) {
            Logger.getLogger(AlunoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    
    public void novo(Aluno aluno){
        
        AlunoDAO alunoDAO = new AlunoDAO();
        Aluno a = new Aluno();
        a = alunoDAO.buscar(aluno.getId());
        
        JOptionPane.showMessageDialog(null, "Aluno curriculo id: " + aluno.getCurriculo().getId());
        DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
        disciplinas = disciplinaDAO.listar(aluno.getCurriculo().getId());
        JOptionPane.showMessageDialog(null, "Size disciplinas: " + disciplinas.size());
        
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("aluno", a);
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("register_notas.jsf");
        } catch (IOException ex) {
            Logger.getLogger(AlunoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void listar(int id_aluno){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("listar_notas.jsf");
        } catch (IOException ex) {
            Logger.getLogger(AlunoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void gravar(int id_aluno){
        NotaDAO notaDAO = new NotaDAO();
        notaDAO.gravar(nota);
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("listar_notas.jsf");
        } catch (IOException ex) {
            Logger.getLogger(AlunoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Nota> obter(){
        List<Nota> notas = new ArrayList<>();
        EntityManager e = JPAUtil.getEntityManagerFactory().createEntityManager();
        Query q = e.createQuery("FROM Nota");
        notas = q.getResultList();
        return notas;
     
    }
    
    /*public void editar(Long id){
        Usuario usuario = new Usuario();
        EntityManager e = JPAUtil.getEntityManagerFactory().createEntityManager();
        usuario = e.find(Usuario.class, id);
        //JPAUtil.shutdown();
        System.out.println("Usuario:"  + usuario.getNome());
    }*/
    
    public void editar(int id_aluno, int id_diciplina){
        NotaDAO notaDAO = new NotaDAO();
        Nota n = new Nota();
        n = notaDAO.buscar(id_aluno);
        
        /*DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
        Disciplina d = new Disciplina();
        d = disciplinaDAO.buscar(id_diciplina);*/
        
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("nota", n);
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("editar_notas.jsf");
        } catch (IOException ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void atualizar(Nota nota){
        NotaDAO notaDAO= new NotaDAO();
        notaDAO.editar(nota);
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("listar_notas.jsf");
        } catch (IOException ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminar(int id){
        NotaDAO notaDAO = new NotaDAO();
        notaDAO.eliminar(id);
    }

    /**
     * @return the nota
     */
    public Nota getNota() {
        return nota;
    }

    /**
     * @return the disciplinas
     */
    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

}
