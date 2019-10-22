package br.com.argus.bean;

import br.com.argus.dao.AlunoDAO;
import br.com.argus.dao.CurriculoDAO;
import br.com.argus.model.Aluno;
import br.com.argus.model.Curriculo;
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
@ManagedBean(name = "curriculoBean")
@ViewScoped
public class CurriculoBean implements Serializable {
    
    private Curriculo curriculo;
    
    @PostConstruct
    private void init(){
        curriculo = new Curriculo();
    }
    
    public void gravar(){
        CurriculoDAO curriculoDAO = new CurriculoDAO();
        curriculoDAO.gravar(curriculo);
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/listar_curriculo.jsf");
        } catch (IOException ex) {
            Logger.getLogger(AlunoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminar(int id){
        CurriculoDAO curriculoDAO = new CurriculoDAO();
        curriculoDAO.eliminar(id);
    }
    
    public void editar(int id){
        CurriculoDAO curriculoDAO = new CurriculoDAO();
        Curriculo c = new Curriculo();
        c = curriculoDAO.buscar(id);
        
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("curriculo", c);
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/editar_curriculo.jsf");
        } catch (IOException ex) {
            Logger.getLogger(AlunoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void atualizar(Curriculo curriculo){
        CurriculoDAO curriculoDAO = new CurriculoDAO();
        curriculoDAO.editar(curriculo);
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/listar_curriculo.jsf");
        } catch (IOException ex) {
            Logger.getLogger(AlunoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the curriculo
     */
    public Curriculo getCurriculo() {
        return curriculo;
    }
    
}
