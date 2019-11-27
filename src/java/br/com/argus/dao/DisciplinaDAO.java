package br.com.argus.dao;

import br.com.argus.model.Ano_Letivo;
import br.com.argus.model.Disciplina;
import br.com.argus.model.JPAUtil;
import br.com.argus.model.Usuario;
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
public class DisciplinaDAO {

    EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

    public Disciplina buscar(int id) {

        Disciplina d = new Disciplina();
        d = entity.find(Disciplina.class, id);
        return d;
    }

    public void eliminar(int id) {
        Disciplina d = new Disciplina();
        d = entity.find(Disciplina.class, id);
        entity.getTransaction().begin();
        entity.remove(d);
        entity.getTransaction().commit();
    }

    public void editar(Disciplina disciplina) {
        entity.getTransaction().begin();
        entity.merge(disciplina);
        entity.getTransaction().commit();
    }

    public void gravar(Disciplina disciplina) {
        EntityManagerFactory f = Persistence.createEntityManagerFactory("teste");
        EntityManager e = f.createEntityManager();
        e.getTransaction().begin();
        e.persist(disciplina);
        e.getTransaction().commit();           
    }

    public List<Disciplina> listar() {
        List<Disciplina> disciplinas = new ArrayList<>();
        EntityManager e = JPAUtil.getEntityManagerFactory().createEntityManager();
        Query q = e.createQuery("FROM Disciplina");
        disciplinas = q.getResultList();
        return disciplinas;
    }

}
