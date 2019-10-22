package br.com.argus.dao;

import br.com.argus.model.JPAUtil;
import br.com.argus.model.Nota;
import br.com.argus.model.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author lucas queroz
 */
public class NotaDAO {
    
    EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
    
    public void gravar(Nota nota){
        EntityManagerFactory f = Persistence.createEntityManagerFactory("teste");
        EntityManager e = f.createEntityManager();
        e.getTransaction().begin();
        e.persist(nota);
        e.getTransaction().commit();
    }
    
    public Usuario buscar(int id) {
        /*Cliente c = new Cliente();
	c = entity.find(Cliente.class, id);
	// JPAUtil.shutdown();
	return c;*/
        
        Usuario u = new Usuario();
        u = entity.find(Usuario.class, id);
        return u;
    }
    
    public void eliminar(int id){
        Usuario u = new Usuario();
        u = entity.find(Usuario.class, id);
        entity.getTransaction().begin();
        entity.remove(u);
        entity.getTransaction().commit();
    }
    
    public void editar(Usuario usuario){
        entity.getTransaction().begin();
        entity.merge(usuario);
        entity.getTransaction().commit();
    }
    
//    EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
    
        // Gravar cliente    
}
