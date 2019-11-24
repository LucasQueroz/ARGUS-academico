package br.com.argus.dao;

import br.com.argus.model.JPAUtil;
import br.com.argus.model.Pedagogo;
import br.com.argus.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

public class UsuarioDAO {

    EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

    public Usuario buscar(int id) {
        Usuario u = new Usuario();
        u = entity.find(Usuario.class, id);
        return u;
    }

    public Usuario buscar(String nome, String senha) {
        Query query = entity.createQuery("FROM Usuario u where u.nome = :nome and u.senha=:senha");
        query.setParameter("nome", nome);
        query.setParameter("senha", senha);

        return (Usuario) query.getSingleResult();
    }
    
    public Usuario buscar(String nome) {
        Query query = entity.createQuery("FROM Usuario u where u.nome = :nome");
        query.setParameter("nome", nome);
        //query.setParameter("senha", senha);

        return (Usuario) query.getSingleResult();
    }

    public void eliminar(int id) {
        Usuario u = new Usuario();
        u = entity.find(Usuario.class, id);
        entity.getTransaction().begin();
        entity.remove(u);
        entity.getTransaction().commit();
    }

    public void editar(Usuario usuario) {
        entity.getTransaction().begin();
        entity.merge(usuario);
        entity.getTransaction().commit();
    }

    public void gravar(Usuario usuario) {
        EntityManagerFactory f = Persistence.createEntityManagerFactory("teste");
        EntityManager e = f.createEntityManager();
        e.getTransaction().begin();
        e.persist(usuario);
        e.getTransaction().commit();

    }

    public List<Usuario> obterUsuario() {
        List<Usuario> usuarios = new ArrayList<>();
        EntityManager e = JPAUtil.getEntityManagerFactory().createEntityManager();
        Query q = e.createQuery("FROM Usuario");
        usuarios = q.getResultList();
        return usuarios;
    }

}
