package br.com.argus.bean;

import br.com.argus.model.Aluno;
import br.com.argus.model.JPAUtil;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.swing.JOptionPane;
import javax.websocket.Session;
import net.sf.ehcache.hibernate.HibernateUtil;

/**
 *
 * @author lucas queroz
 */
@ManagedBean(name = "atendimento_Pedagogico_join_AlunoBean")
@ViewScoped
public class Atendimento_Pedagogico_join_AlunoBean {
    
    public List<Aluno> obter(){
        //JOptionPane.showMessageDialog(null, "Passei 1");
        List<Aluno> alunos = new ArrayList<>();
        EntityManager e = JPAUtil.getEntityManagerFactory().createEntityManager();
        Query q = e.createQuery("SELECT DISTINCT a FROM Aluno a INNER JOIN Atendimento_Pedagogico ap");
        //JOptionPane.showMessageDialog(null, "Passei 2");
        alunos = q.getResultList();
        //JOptionPane.showMessageDialog(null, "Passei 3");
        //JOptionPane.showMessageDialog(null, "Aluno size:" +alunos.size());
        //JOptionPane.showMessageDialog(null, "Nome: " + alunos.get(0).getNome());
        return alunos;
     
    }
    
}
