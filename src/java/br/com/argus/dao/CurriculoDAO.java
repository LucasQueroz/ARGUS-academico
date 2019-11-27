package br.com.argus.dao;

import br.com.argus.model.Aluno;
import br.com.argus.model.Curriculo;
import br.com.argus.model.JPAUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

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
    
    public void editar(Curriculo curriculo) {
        entity.getTransaction().begin();
        entity.merge(curriculo);
        entity.getTransaction().commit();
    }

    public List<Curriculo> listar() {
        List<Curriculo> curriculos = new ArrayList<>();
        EntityManager e = JPAUtil.getEntityManagerFactory().createEntityManager();
        Query q = e.createQuery("FROM Curriculo");
        curriculos = q.getResultList();
        return curriculos;
    }
    
}
