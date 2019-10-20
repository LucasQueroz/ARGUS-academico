package br.com.argus.bean;

import br.com.argus.dao.AlunoDAO;
import br.com.argus.model.Aluno;
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
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas queroz
 */

@ManagedBean(name = "alunoBean")
@ViewScoped
public class AlunoBean implements Serializable {
    
    private Aluno aluno;
    
    @PostConstruct
    private void init(){
        aluno = new Aluno();
    }
    
    public void gravar(){
        //AlunoDAO alunoDAO = new AlunoDAO();
        //alunoDAO.gravar(aluno);
        
        EntityManagerFactory f = Persistence.createEntityManagerFactory("teste");
        try{
            EntityManager e = f.createEntityManager();
            e.getTransaction().begin();
            e.persist(aluno);
            e.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        //JOptionPane.showMessageDialog(null, "Pasei no gravar de aluno 1");
        try {
            //JOptionPane.showMessageDialog(null, "Pasei no gravar de aluno 2");
            FacesContext.getCurrentInstance().getExternalContext().redirect("/listar_alunos.jsf");
            //JOptionPane.showMessageDialog(null, "Pasei no gravar de aluno 3");
        } catch (IOException ex) {
            Logger.getLogger(AlunoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminar(int id){
        AlunoDAO alunoDAO = new AlunoDAO();
        alunoDAO.eliminar(id);
    }
    
    public void editar(int id){
        AlunoDAO alunoDAO = new AlunoDAO();
        Aluno a = new Aluno();
        a = alunoDAO.buscar(id);
        
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("aluno", a);
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/editar_aluno.jsf");
        } catch (IOException ex) {
            Logger.getLogger(AlunoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void atualizar(Aluno aluno){
        AlunoDAO alunoDAO = new AlunoDAO();
        alunoDAO.editar(aluno);
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/listar_alunos.jsf");
        } catch (IOException ex) {
            Logger.getLogger(AlunoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Aluno> obterAluno(){
        List<Aluno> alunos = new ArrayList<>();
        EntityManager e = JPAUtil.getEntityManagerFactory().createEntityManager();
        Query q = e.createQuery("FROM Aluno");
        alunos = q.getResultList();
        return alunos;
    }

    /**
     * @return the aluno
     */
    public Aluno getAluno() {
        return aluno;
    }

}