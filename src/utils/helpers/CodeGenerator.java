package utils.helpers;

import java.security.SecureRandom;

public class CodeGenerator {
    
    private final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private final SecureRandom RANDOM = new SecureRandom();

    public String generate(int lenght) {
        StringBuilder code = new StringBuilder(lenght);
        for (int i = 0; i < lenght; i++) {
            int index = RANDOM.nextInt(CHARACTERS.length());
            code.append(CHARACTERS.charAt(index));
        }
        return code.toString();
    }
    
}
