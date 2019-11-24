package br.com.argus.dao;

import br.com.argus.model.Atendimento_Pedagogico;
import br.com.argus.model.JPAUtil;
import br.com.argus.model.Usuario;
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
public class Atendimento_PedagogicoDAO {
    
    EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

    public Atendimento_Pedagogico buscar(int id) {
        /*Cliente c = new Cliente();
	c = entity.find(Cliente.class, id);
	// JPAUtil.shutdown();
	return c;*/
        
        Atendimento_Pedagogico a = new Atendimento_Pedagogico();
        a = entity.find(Atendimento_Pedagogico.class, id);
        return a;
    }
    
    public void eliminar(int id){
        Atendimento_Pedagogico a = new Atendimento_Pedagogico();
        a = entity.find(Atendimento_Pedagogico.class, id);
        entity.getTransaction().begin();
        entity.remove(a);
        entity.getTransaction().commit();
    }
    
    public void editar(Atendimento_Pedagogico atendimento_Pedagogico){
        entity.getTransaction().begin();
        entity.merge(atendimento_Pedagogico);
        entity.getTransaction().commit();
    }
    
	public void gravar(Atendimento_Pedagogico atendimento_Pedagogico) {
            EntityManagerFactory f = Persistence.createEntityManagerFactory("teste");
            EntityManager e = f.createEntityManager();
            e.getTransaction().begin();
            e.persist(atendimento_Pedagogico);
            e.getTransaction().commit();  
            
	}

    public List<Atendimento_Pedagogico> listar() {
        List<Atendimento_Pedagogico> atendimento_Pedagogicos = new ArrayList<>();
        EntityManager e = JPAUtil.getEntityManagerFactory().createEntityManager();
        Query q = e.createQuery("FROM Atendimento_Pedagogico");
        atendimento_Pedagogicos = q.getResultList();
        return atendimento_Pedagogicos;
    }

}
