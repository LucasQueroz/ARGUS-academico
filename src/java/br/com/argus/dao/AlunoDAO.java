package br.com.argus.dao;

import br.com.argus.model.Aluno;
import br.com.argus.model.JPAUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
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
        JOptionPane.showMessageDialog(null, "Aluno editado:" + aluno.getNome());
        entity.getTransaction().begin();
        JOptionPane.showMessageDialog(null, "editar 1");
        entity.merge(aluno);
        JOptionPane.showMessageDialog(null, "editar 2");
        entity.getTransaction().commit();
        JOptionPane.showMessageDialog(null, "editar 3");
    }

    public List<Aluno> listar() {
        List<Aluno> alunos = new ArrayList<>();
        EntityManager e = JPAUtil.getEntityManagerFactory().createEntityManager();
        Query q = e.createQuery("FROM Aluno");
        alunos = q.getResultList();
        return alunos;
    }
    
}
