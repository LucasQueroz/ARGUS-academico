package br.com.argus.dao;

import br.com.argus.model.JPAUtil;
import br.com.argus.model.Pedagogo;
import br.com.argus.model.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author lucas queroz
 */
public class PedagogoDAO {

    EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

    public Pedagogo buscar(int id) {
        Pedagogo p = new Pedagogo();
        p = entity.find(Pedagogo.class, id);
        return p;
    }

    public void eliminar(int id) {
        Pedagogo p = new Pedagogo();
        p = entity.find(Pedagogo.class, id);
        entity.getTransaction().begin();
        entity.remove(p);
        entity.getTransaction().commit();
    }

    public void editar(Pedagogo pedagogo) {
        entity.getTransaction().begin();
        entity.merge(pedagogo);
        entity.getTransaction().commit();
    }

    public void gravar(Pedagogo pedagogo) {
        EntityManagerFactory f = Persistence.createEntityManagerFactory("teste");
        EntityManager e = f.createEntityManager();
        e.getTransaction().begin();
        e.persist(pedagogo);
        e.getTransaction().commit();            
    }

}
