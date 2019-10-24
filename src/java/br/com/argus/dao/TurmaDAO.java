package br.com.argus.dao;

import br.com.argus.bean.AlunoBean;
import br.com.argus.bean.UsuarioBean;
import br.com.argus.model.Ano_Letivo;
import br.com.argus.model.JPAUtil;
import br.com.argus.model.Turma;
import br.com.argus.model.Usuario;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author lucas queroz
 */
public class TurmaDAO {
    
    EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
    
    public void gravar(Turma turma){
        EntityManagerFactory f = Persistence.createEntityManagerFactory("teste");
        EntityManager e = f.createEntityManager();
        e.getTransaction().begin();
        e.persist(turma);
        e.getTransaction().commit();
    }

    public void eliminar(int id) {
        Turma t = new Turma();
        t = entity.find(Turma.class, id);
        entity.getTransaction().begin();
        entity.remove(t);
        entity.getTransaction().commit();
    }

    public Turma buscar(int id) {
        Turma t = new Turma();
        t = entity.find(Turma.class, id);
        return t;
    }

    public void editar(Turma turma) {
        entity.getTransaction().begin();
        entity.merge(turma);
        entity.getTransaction().commit();
    }
}
