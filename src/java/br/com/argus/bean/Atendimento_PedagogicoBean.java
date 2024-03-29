package br.com.argus.bean;

import br.com.argus.dao.AlunoDAO;
import br.com.argus.dao.Atendimento_PedagogicoDAO;
import br.com.argus.dao.UsuarioDAO;
import br.com.argus.filtros.PedagogoAuth;
import br.com.argus.model.Aluno;
import br.com.argus.model.Atendimento_Pedagogico;
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
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas queroz
 */
@ManagedBean(name = "atendimento_PedagogicoBean")
@ViewScoped
public class Atendimento_PedagogicoBean implements Serializable {
    
    private Atendimento_Pedagogico atendimento_Pedagogico;
    private List<Atendimento_Pedagogico> atendimento_Pedagogicos;
    private List<Aluno> alunos;
    private List<Usuario> usuarios;
    
    @PostConstruct
    private void init(){
        atendimento_Pedagogico = new Atendimento_Pedagogico();
        
        AlunoDAO alunoDAO = new AlunoDAO();
        alunos = alunoDAO.listar();
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarios = usuarioDAO.listaPedagogo();
    }
    
    /*public String novo(){
        Usuario u = new Usuario();
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	sessionMap.put("usuario", u);
        return "/faces/register_usuario.xhtml";
    }*/
    
    public void gravar(){
        
        Atendimento_PedagogicoDAO atendimento_PedagogicoDAO = new Atendimento_PedagogicoDAO();
        atendimento_PedagogicoDAO.gravar(atendimento_Pedagogico);
        
        atendimento_Pedagogico = new Atendimento_Pedagogico();
        
        AlunoDAO alunoDAO = new AlunoDAO();
        alunos = alunoDAO.listar();
        
        atendimento_Pedagogicos = atendimento_PedagogicoDAO.listar();
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("listar_atendimento_pedagogico.jsf");
        } catch (IOException ex) {
            Logger.getLogger(AlunoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void gravar(int aluno_id){
        //atendimento_Pedagogico.set
        
        Atendimento_PedagogicoDAO atendimento_PedagogicoDAO = new Atendimento_PedagogicoDAO();
        atendimento_PedagogicoDAO.gravar(atendimento_Pedagogico);
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("listar_atendimento_pedagogico.jsf");
        } catch (IOException ex) {
            Logger.getLogger(AlunoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Atendimento_Pedagogico> obter(){
        List<Atendimento_Pedagogico> atendimento_Pedagogico = new ArrayList<>();
        EntityManager e = JPAUtil.getEntityManagerFactory().createEntityManager();
        Query q = e.createQuery("FROM Atendimento_Pedagogico");
        atendimento_Pedagogico = q.getResultList();
        return atendimento_Pedagogico;
    }
    
    /*public List<Atendimento_Pedagogico> obter_por_aluno(){
        List<Atendimento_Pedagogico> atendimento_Pedagogico = new ArrayList<>();
        EntityManager e = JPAUtil.getEntityManagerFactory().createEntityManager();
        Query q = e.createQuery("SELECT ap.detalhamento FROM Atendimento_Pedagogico ap inner join p.detalhesProduto as d");
        atendimento_Pedagogico = q.getResultList();
        return atendimento_Pedagogico;
     
    }*/
    
    /*public void editar(Long id){
        Usuario usuario = new Usuario();
        EntityManager e = JPAUtil.getEntityManagerFactory().createEntityManager();
        usuario = e.find(Usuario.class, id);
        //JPAUtil.shutdown();
        System.out.println("Usuario:"  + usuario.getNome());
    }*/
    
    public void editar(int id){
        Atendimento_PedagogicoDAO atendimento_PedagogicoDAO = new Atendimento_PedagogicoDAO();
        Atendimento_Pedagogico a = new Atendimento_Pedagogico();
        a = atendimento_PedagogicoDAO.buscar(id);
        
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("atendimento_pedagogico", a);
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("editar_atendimento_pedagogico.jsf");
        } catch (IOException ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void atualizar(Atendimento_Pedagogico atendimento_Pedagogico){
        Atendimento_PedagogicoDAO atendimento_PedagogicoDAO = new Atendimento_PedagogicoDAO();
        atendimento_PedagogicoDAO.editar(atendimento_Pedagogico);
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("listar_atendimento_pedagogico.jsf");
        } catch (IOException ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminar(int id){
        Atendimento_PedagogicoDAO atendimento_PedagogicoDAO = new Atendimento_PedagogicoDAO();
        atendimento_PedagogicoDAO.eliminar(id);
    }

    public Atendimento_Pedagogico getAtendimento_Pedagogico() {
        return atendimento_Pedagogico;
    }
    
    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    /**
     * @return the usuarios
     */
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     * @param usuarios the usuarios to set
     */
    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
}
