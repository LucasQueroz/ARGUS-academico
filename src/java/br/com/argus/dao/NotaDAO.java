package br.com.argus.dao;

import br.com.argus.model.JPAUtil;
import br.com.argus.model.Nota;
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
public class NotaDAO {
    
    EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
    
    public void gravar(Nota nota){
        EntityManagerFactory f = Persistence.createEntityManagerFactory("teste");
        EntityManager e = f.createEntityManager();
        e.getTransaction().begin();
        e.persist(nota);
        e.getTransaction().commit();
    }
    
    public Nota buscar(int id) {
        Nota n = new Nota();
        n = entity.find(Nota.class, id);
        return n;
    }
    
    public void eliminar(int id){
        Nota n = new Nota();
        n = entity.find(Nota.class, id);
        entity.getTransaction().begin();
        entity.remove(n);
        entity.getTransaction().commit();
    }
    
    public void editar(Nota nota){
        entity.getTransaction().begin();
        entity.merge(nota);
        entity.getTransaction().commit();
    }
     
    public List<Nota> listarPorAluno(int aluno_id){
        List<Nota> notas = new ArrayList<>();
        EntityManager e = JPAUtil.getEntityManagerFactory().createEntityManager();
        Query q = e.createQuery("FROM Nota WHERE aluno_id = :aluno_id");
        q.setParameter("aluno_id", aluno_id);
        notas = q.getResultList();
        return notas;
    }
}
