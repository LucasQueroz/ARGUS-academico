package br.com.argus.bussiness;

import br.com.argus.dao.UsuarioDAO;
import br.com.argus.model.LoginEntity;
import br.com.argus.model.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas queroz
 */
public class LoginUsuario {
    
    public static final String ADMINISTRADOR = "administrador";
    public static final String DIRETOR = "diretor";
    public static final String FUNCIONARIO = "funcionario";
    public static final String PEDAGOGO = "pedagogo";
    
    public String tipoUsuario(LoginEntity loginEntity){
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        //JOptionPane.showMessageDialog(null, Criptografia.criptografar(loginEntity.getSenha()));
        
        Usuario usuario = usuarioDAO.buscar(loginEntity.getNome(), Criptografia.criptografar(loginEntity.getSenha()));
        
        if(usuario.getTipo_usuario().equals(ADMINISTRADOR)){
            return ADMINISTRADOR;
        } else if(usuario.getTipo_usuario().equals(DIRETOR)){
            return DIRETOR;
        } else if(usuario.getTipo_usuario().equals(FUNCIONARIO)){
            return FUNCIONARIO;
        } else if(usuario.getTipo_usuario().equals(PEDAGOGO)){
            return PEDAGOGO;
        } else {
            return "";
        }
    }
    
}
