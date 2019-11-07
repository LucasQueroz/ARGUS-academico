package br.com.argus.bean;

import br.com.argus.dao.AlunoDAO;
import br.com.argus.dao.CurriculoDAO;
import br.com.argus.model.Aluno;
import br.com.argus.model.Curriculo;
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
            FacesContext.getCurrentInstance().getExternalContext().redirect("listar_curriculo.jsf");
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
            FacesContext.getCurrentInstance().getExternalContext().redirect("editar_curriculo.jsf");
        } catch (IOException ex) {
            Logger.getLogger(AlunoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void atualizar(Curriculo curriculo){
        CurriculoDAO curriculoDAO = new CurriculoDAO();
        curriculoDAO.editar(curriculo);
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("listar_curriculo.jsf");
        } catch (IOException ex) {
            Logger.getLogger(AlunoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Curriculo> obter(){
        List<Curriculo> curriculos = new ArrayList<>();
        EntityManager e = JPAUtil.getEntityManagerFactory().createEntityManager();
        Query q = e.createQuery("FROM Curriculo");
        curriculos = q.getResultList();
        return curriculos;
    }

    /**
     * @return the curriculo
     */
    public Curriculo getCurriculo() {
        return curriculo;
    }
    
}
