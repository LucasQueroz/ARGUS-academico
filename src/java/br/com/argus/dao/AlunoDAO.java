package br.com.argus.dao;

import br.com.argus.model.Aluno;
import br.com.argus.model.JPAUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas queroz
 */
public class AlunoDAO {
    
    EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
    
    public void gravar(Aluno aluno){
        EntityManagerFactory f = Persistence.createEntityManagerFactory("teste");
        EntityManager e = f.createEntityManager();
        e.getTransaction().begin();
        e.persist(aluno);
        e.getTransaction().commit();
    }

    public void eliminar(int id) {
        Aluno a = new Aluno();
        a = entity.find(Aluno.class, id);
        entity.getTransaction().begin();
        entity.remove(a);
        entity.getTransaction().commit();
    }

    public Aluno buscar(int id) {
        Aluno a = new Aluno();
        a = entity.find(Aluno.class, id);
        return a;
    }

    public void editar(Aluno aluno) {
        entity.getTransaction().begin();
        entity.merge(aluno);
        entity.getTransaction().commit();
    }
    
}
