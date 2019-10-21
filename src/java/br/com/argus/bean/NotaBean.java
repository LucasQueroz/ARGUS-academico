package br.com.argus.bean;

import br.com.argus.dao.AlunoDAO;
import br.com.argus.dao.NotaDAO;
import br.com.argus.model.Aluno;
import br.com.argus.model.Disciplina;
import br.com.argus.model.Nota;
import java.io.IOException;
import java.io.Serializable;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

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

    /**
     * @return the nota
     */
    public Nota getNota() {
        return nota;
    }

}
