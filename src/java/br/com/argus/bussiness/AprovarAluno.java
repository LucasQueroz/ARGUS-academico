package br.com.argus.bussiness;

import br.com.argus.model.Aluno;
import br.com.argus.model.Nota;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas queroz
 */
public class AprovarAluno {
    
    public static String APROVADO_POR_MEDIA = "media";
    public static String APROVADO_NA_FINAL = "final";
    
    /*public Aluno aprovar(Nota nota){
        if(calcularMediaParcial(nota) >= 7){
            nota.getAluno().getAno_Letivo().setId(nota.getAluno().getAno_Letivo().getId()+1);
            return nota.getAluno();
        }
        else if(calcularMediaGeral(nota) >= 5){
            nota.getAluno().getAno_Letivo().setId(nota.getAluno().getAno_Letivo().getId()+1);
            return nota.getAluno();
        }
        return nota.getAluno();
    }*/
    
    public float calcularMediaParcial(Nota nota){
        return (nota.getNota1() + nota.getNota2() + nota.getNota3() + nota.getNota4()) / 4;
    }
    
    public float calcularMediaGeral(Nota nota){
        return (nota.getNota1() + nota.getNota2() + nota.getNota3() + nota.getNota4() + nota.getNota_na_final()) / 5;
    }
    
    public Aluno verificarAprovacao(Aluno aluno, List<Nota> notas){
        int reprovacoes = 0;
        for(Nota n : notas){
            if(calcularMediaParcial(n) >= 7){
                JOptionPane.showMessageDialog(null, "Passei >=7");
            } else if(calcularMediaParcial(n) >= 5){
                JOptionPane.showMessageDialog(null, "Passei >=5");
            } else {
                JOptionPane.showMessageDialog(null, "Reprovado");
                reprovacoes++;
            }
        }
        if(reprovacoes == 0){
            aluno.getAno_Letivo().setId(aluno.getAno_Letivo().getId()+1);
        } 
        return aluno;
    }
}
