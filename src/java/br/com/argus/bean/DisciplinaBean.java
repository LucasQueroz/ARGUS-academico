package br.com.argus.bean;

import br.com.argus.model.Disciplina;
import br.com.argus.model.Professor;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
        EntityManagerFactory f = Persistence.createEntityManagerFactory("teste"); //teste
        try{
            EntityManager e = f.createEntityManager();
            e.getTransaction().begin();
            e.persist(getDisciplina());
            e.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        try {
            //JOptionPane.showMessageDialog(null, "Pasei no gravar de Professor 1");
            FacesContext.getCurrentInstance().getExternalContext().redirect("/index.jsf");
            //JOptionPane.showMessageDialog(null, "Pasei no gravar de aluno 3");
        } catch (IOException ex) {
            Logger.getLogger(AlunoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the disciplina
     */
    public Disciplina getDisciplina() {
        return disciplina;
    }

}
