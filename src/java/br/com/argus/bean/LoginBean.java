package br.com.argus.bean;

import br.com.argus.model.LoginEntity;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

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
        if(login.getEmail().equals("administrador") && login.getSenha().equals("administrador")){
            HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            session.setAttribute("administrador", login);
            return "protegido/administrador/index?faces-redirect=true";
            
        } else if(login.getEmail().equals("pedagogo") && login.getSenha().equals("pedagogo")){
            HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            session.setAttribute("pedagogo", login);
            return "protegido/pedagogo/index?faces-redirect=true";
            
        } else if(login.getEmail().equals("diretor") && login.getSenha().equals("diretor")){
            HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            session.setAttribute("diretor", login);
            return "protegido/diretor/index?faces-redirect=true";
            
        } else if(login.getEmail().equals("funcionario") && login.getSenha().equals("funcionario")){
            HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            session.setAttribute("funcionario", login);
            return "protegido/funcionario/index?faces-redirect=true";
            
        }
        else{
            return "login?faces-redirect=true";
        }
        
    }
    
    public String logout(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index?faces-redirect=true";
    }

    public LoginEntity getLogin() {
        return login;
    }
    
}
