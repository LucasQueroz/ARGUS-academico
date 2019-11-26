package br.com.argus.bean;

import br.com.argus.bussiness.LoginUsuario;
import br.com.argus.model.LoginEntity;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.NoResultException;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas queroz
 */
@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {
    
    private LoginEntity login;
    
    @PostConstruct
    private void init(){
        login = new LoginEntity();
    }
    
    public String logarNoSistema(){
        LoginUsuario loginUsuario = new LoginUsuario();
        
        try {
            String tipo_usuario = loginUsuario.tipoUsuario(login);
            
            if(tipo_usuario.equals("administrador")){
            HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            session.setAttribute("administrador", login);
            return "protegido/administrador/index?faces-redirect=true";
            
        } else if(tipo_usuario.equals("pedagogo")){
            HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            session.setAttribute("pedagogo", login);
            return "protegido/pedagogo/index?faces-redirect=true";
            
        } else if(tipo_usuario.equals("diretor")){
            HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            session.setAttribute("diretor", login);
            return "protegido/diretor/index?faces-redirect=true";
            
        } else if(tipo_usuario.equals("funcionario")){
            HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            session.setAttribute("funcionario", login);
            return "protegido/funcionario/index?faces-redirect=true";
            
        }
            
        } catch (NoResultException e) {
            return "login?faces-redirect=true";
        }
        return "login?faces-redirect=true";
    }
    
    public void logout(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        //return "login?faces-redirect=true";
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/login.jsf");
        } catch (IOException ex) {
            Logger.getLogger(AlunoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public LoginEntity getLogin() {
        return login;
    }
    
}
