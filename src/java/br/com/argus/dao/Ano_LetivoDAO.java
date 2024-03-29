package br.com.argus.dao;

import br.com.argus.model.Ano_Letivo;
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
public class Ano_LetivoDAO {

    EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

    public Ano_Letivo buscar(int id) {
        Ano_Letivo a = new Ano_Letivo();
        a = entity.find(Ano_Letivo.class, id);
        return a;
    }

    public void eliminar(int id) {
        Ano_Letivo a = new Ano_Letivo();
        a = entity.find(Ano_Letivo.class, id);
        entity.getTransaction().begin();
        entity.remove(a);
        entity.getTransaction().commit();
    }

    public void editar(Ano_Letivo ano_Letivo) {
        entity.getTransaction().begin();
        entity.merge(ano_Letivo);
        entity.getTransaction().commit();
    }

    public void gravar(Ano_Letivo ano_letivo) {
        EntityManagerFactory f = Persistence.createEntityManagerFactory("teste");
        EntityManager e = f.createEntityManager();
        e.getTransaction().begin();
        e.persist(ano_letivo);
        e.getTransaction().commit();
    }

    public List<Ano_Letivo> listar() {
        List<Ano_Letivo> responsaveis = new ArrayList<>();
        EntityManager e = JPAUtil.getEntityManagerFactory().createEntityManager();
        Query q = e.createQuery("FROM Ano_Letivo");
        responsaveis = q.getResultList();
        return responsaveis;
    }

}
