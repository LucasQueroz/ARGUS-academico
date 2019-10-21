package br.com.argus.dao;

import br.com.argus.model.Aluno;
import br.com.argus.model.Curriculo;
import br.com.argus.model.JPAUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author lucas queroz
 */
public class CurriculoDAO {
    
    EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
    
    public void gravar(Curriculo curriculo) {
        EntityManagerFactory f = Persistence.createEntityManagerFactory("teste");
        EntityManager e = f.createEntityManager();
        e.getTransaction().begin();
        e.persist(curriculo);
        e.getTransaction().commit();
    }
    
    public void eliminar(int id) {
        Curriculo c = new Curriculo();
        c = entity.find(Curriculo.class, id);
        entity.getTransaction().begin();
        entity.remove(c);
        entity.getTransaction().commit();
    }

    public Curriculo buscar(int id) {
        Curriculo c = new Curriculo();
        c = entity.find(Curriculo.class, id);
        return c;
    }
    
}
