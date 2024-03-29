package br.com.argus.dao;

import br.com.argus.model.JPAUtil;
import br.com.argus.model.Professor;
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
public class ProfessorDAO {

    EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

    public Professor buscar(int id) {
        Professor p = new Professor();
        p = entity.find(Professor.class, id);
        return p;
    }

    public void eliminar(int id) {
        Professor p = new Professor();
        p = entity.find(Professor.class, id);
        entity.getTransaction().begin();
        entity.remove(p);
        entity.getTransaction().commit();
    }

    public void editar(Professor professor) {
        entity.getTransaction().begin();
        entity.merge(professor);
        entity.getTransaction().commit();
    }

    public void gravar(Professor professor) {
        EntityManagerFactory f = Persistence.createEntityManagerFactory("teste");
        EntityManager e = f.createEntityManager();
        e.getTransaction().begin();
        e.persist(professor);
        e.getTransaction().commit();      
    }

    public List<Professor> listar() {
        List<Professor> proefessores = new ArrayList<>();
        EntityManager e = JPAUtil.getEntityManagerFactory().createEntityManager();
        Query q = e.createQuery("FROM Professor");
        proefessores = q.getResultList();
        return proefessores;
    }

}
