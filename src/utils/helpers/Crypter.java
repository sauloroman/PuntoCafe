package utils.helpers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Crypter {
    
    public static String cryptPassword(String value) {
        if ( value == null ) return null;
        
        MessageDigest md;
        
        try {
           md = MessageDigest.getInstance("SHA-256");
        } catch( NoSuchAlgorithmException e ) {
           return null;
        }
        
        byte[] hash = md.digest( value.getBytes() );
        StringBuilder sb = new StringBuilder();
        
        for (byte b: hash) {
            sb.append(String.format("%02x", b));
        }
        
        return sb.toString();
    }
    
}
