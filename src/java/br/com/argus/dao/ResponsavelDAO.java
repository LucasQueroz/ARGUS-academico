package br.com.argus.dao;

import br.com.argus.model.JPAUtil;
import br.com.argus.model.Responsavel;
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
public class ResponsavelDAO {

    EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

    public Responsavel buscar(int id) {
        Responsavel r = new Responsavel();
        r = entity.find(Responsavel.class, id);
        return r;
    }

    public void eliminar(int id) {
        Responsavel r = new Responsavel();
        r = entity.find(Responsavel.class, id);
        entity.getTransaction().begin();
        entity.remove(r);
        entity.getTransaction().commit();
    }

    public void editar(Responsavel responsavel) {
        entity.getTransaction().begin();
        entity.merge(responsavel);
        entity.getTransaction().commit();
    }

    public void gravar(Responsavel responsavel) {
        EntityManagerFactory f = Persistence.createEntityManagerFactory("teste");
        EntityManager e = f.createEntityManager();
        e.getTransaction().begin();
        e.persist(responsavel);
        e.getTransaction().commit();           
    }

    public List<Responsavel> listar() {
        List<Responsavel> responsaveis = new ArrayList<>();
        EntityManager e = JPAUtil.getEntityManagerFactory().createEntityManager();
        Query q = e.createQuery("FROM Responsavel");
        responsaveis = q.getResultList();
        return responsaveis;
    }

}
