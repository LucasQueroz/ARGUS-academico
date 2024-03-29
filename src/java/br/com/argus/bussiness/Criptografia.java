package br.com.argus.bussiness;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.openmbean.SimpleType;

/**
 *
 * @author lucas queroz
 */
public class Criptografia {

    public static String criptografar(String senha) {
        String retorno = "";
        MessageDigest md;

        try {
            md = MessageDigest.getInstance("MD5");
            BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
            retorno = hash.toString(16);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Criptografia.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno;
    }

}
