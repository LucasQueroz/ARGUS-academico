package br.com.argus.bean;

import br.com.argus.dao.AlunoDAO;
import br.com.argus.model.Aluno;
import br.com.argus.model.JPAUtil;
import com.sun.javafx.scene.control.skin.VirtualFlow;
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
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
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
    //private List<Aluno> alunos;
    
    //private List<SelectItem> alunosSelect;

    @PostConstruct
    private void init(){
        aluno = new Aluno();
        /*alunos = obterAluno();
        for (Aluno aluno1 : alunos) {
            System.out.println(aluno1.getNome());
        }*/
    }
    
    public void matricularAluno(int id){
        AlunoDAO alunoDAO = new AlunoDAO();
        Aluno a = new Aluno();
        a = alunoDAO.buscar(id);
        
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("aluno", a);
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("matricular_aluno.jsf");
        } catch (IOException ex) {
            Logger.getLogger(AlunoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void registrarMatricola(Aluno aluno){
        AlunoDAO alunoDAO = new AlunoDAO();
        alunoDAO.editar(aluno);
        
        Aluno a = new Aluno();
        a = alunoDAO.buscar(aluno.getId());
        
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("aluno", a);
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("register_parcela.jsf");
        } catch (IOException ex) {
            Logger.getLogger(AlunoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void gravar(){
        AlunoDAO alunoDAO = new AlunoDAO();
        alunoDAO.gravar(aluno);
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("listar_alunos.jsf");
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
            FacesContext.getCurrentInstance().getExternalContext().redirect("editar_aluno.jsf");
        } catch (IOException ex) {
            Logger.getLogger(AlunoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void atualizar(Aluno aluno){
        AlunoDAO alunoDAO = new AlunoDAO();
        alunoDAO.editar(aluno);
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("listar_alunos.jsf");
        } catch (IOException ex) {
            Logger.getLogger(AlunoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Aluno> obterAluno(){
        AlunoDAO alunoDAO = new AlunoDAO();
        return alunoDAO.listar();
    }

    /**
     * @return the aluno
     */
    public Aluno getAluno() {
        return aluno;
    }

    /*public List<Aluno> getAlunos() {
        return alunos;
    }*/

    /*public List<SelectItem> getAlunosSelect() {
        if(alunosSelect == null){
            alunosSelect = new ArrayList<>();
            
            AlunoDAO alunoDAO = new AlunoDAO();
            List<Aluno> listaAlunos = alunoDAO.obterAlunos();
            
            if(listaAlunos != null && !listaAlunos.isEmpty()){
                SelectItem item;
                for(Aluno alunoLista : listaAlunos){
                    item = new SelectItem(alunoLista, alunoLista.getNome());
                    alunosSelect.add(item);
                }
            }
        }
        //JOptionPane.showMessageDialog(null, "Size alunos" + alunosSelect.size());
        return alunosSelect;
    }*/
}
