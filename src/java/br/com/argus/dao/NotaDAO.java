package br.com.argus.dao;

import br.com.argus.model.JPAUtil;
import br.com.argus.model.Nota;
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
    
}
