package br.com.argus.dao;

import br.com.argus.model.JPAUtil;
import br.com.argus.model.Parcela;
import br.com.argus.model.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author lucas queroz
 */
public class ParcelaDAO {

    EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

    public Parcela buscar(int id) {
        Parcela p = new Parcela();
        p = entity.find(Parcela.class, id);
        return p;
    }

    public void eliminar(int id) {
        Parcela p = new Parcela();
        p = entity.find(Parcela.class, id);
        entity.getTransaction().begin();
        entity.remove(p);
        entity.getTransaction().commit();
    }

    public void editar(Parcela parcela) {
        entity.getTransaction().begin();
        entity.merge(parcela);
        entity.getTransaction().commit();
    }

    public void gravar(Parcela parcela) {
        EntityManagerFactory f = Persistence.createEntityManagerFactory("teste");
        EntityManager e = f.createEntityManager();
        e.getTransaction().begin();
        e.persist(parcela);
        e.getTransaction().commit();

    }

}
