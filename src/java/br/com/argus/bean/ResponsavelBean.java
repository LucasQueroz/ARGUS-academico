package br.com.argus.bean;

import br.com.argus.model.Responsavel;
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
import javax.swing.JOptionPane;

/**
 *
 * @author lucas queroz
 */
@ManagedBean(name = "responsavelBean")
@ViewScoped
public class ResponsavelBean implements Serializable {
    
    private Responsavel responsavel;
    
    @PostConstruct
    private void init(){
        responsavel = new Responsavel();
    }
    
    public void gravar(){
        //novo();
        
        //UsuarioDAO usuarioDAO = new UsuarioDAO();
        //System.out.println(usuario.getNome());
        EntityManagerFactory f = Persistence.createEntityManagerFactory("teste"); //teste
        try{
            EntityManager e = f.createEntityManager();
            e.getTransaction().begin();
            e.persist(getResponsavel());
            e.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        try {
            //JOptionPane.showMessageDialog(null, "Pasei no gravar de responsavel 1");
            FacesContext.getCurrentInstance().getExternalContext().redirect("/listar_alunos.jsf");
            //JOptionPane.showMessageDialog(null, "Pasei no gravar de aluno 3");
        } catch (IOException ex) {
            Logger.getLogger(AlunoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the responsavel
     */
    public Responsavel getResponsavel() {
        return responsavel;
    }
    
}
