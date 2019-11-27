package br.com.argus.bussiness;

import br.com.argus.dao.Ano_LetivoDAO;
import br.com.argus.model.Ano_Letivo;

/**
 *
 * @author lucas queroz
 */
public class Matricula {
    
    public static final String ANOS_INICIAIS = "EF-Anos Iniciais (anos): 1° ao 5°";
    public static final String ANOS_FINAIS = "EF-Anos Finais (anos): 6° ao 9°";
    public static final String ENSINO_MEDIO = "EM (anos): 1° ao 3°";
    
    public static final int ID_ANOS_INICIAIS = 1;
    public static final int ID_ANOS_FINAIS = 6;
    public static final int ID_ENSINO_MEDIO = 10;
    
    
    public float valorDaParcela(String curriculo){
        float valor = 0;
        if(curriculo.equals(ANOS_INICIAIS)){
            valor = 400;
        } else if(curriculo.equals(ANOS_FINAIS)){
            valor = 600;
        } else if(curriculo.equals(ENSINO_MEDIO)){
            valor = 800;
        }
        return valor;
    }
    
    public Ano_Letivo selecionaAnoLetivo(String curriculo){
        Ano_Letivo ano_Letivo = new Ano_Letivo();
        Ano_LetivoDAO ano_LetivoDAO = new Ano_LetivoDAO();
        
        if(curriculo.equals(ANOS_INICIAIS)){
             ano_Letivo = ano_LetivoDAO.buscar(ID_ANOS_INICIAIS);
        } else if(curriculo.equals(ANOS_FINAIS)){
            ano_Letivo = ano_LetivoDAO.buscar(ID_ANOS_FINAIS);
        } else if(curriculo.equals(ENSINO_MEDIO)){
            ano_Letivo = ano_LetivoDAO.buscar(ID_ENSINO_MEDIO);
        }
        return ano_Letivo;
    }
    
}
