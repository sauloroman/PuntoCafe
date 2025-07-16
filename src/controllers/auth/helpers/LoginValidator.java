package controllers.auth.helpers;

import utils.enums.ModalTypeEnum;
import utils.helpers.Modal;
import utils.validators.EmailValidator;

public class LoginValidator {
    
    private final InputReader inputReader;
    private final Modal modal;

    public LoginValidator(InputReader inputReader, Modal modal) {
        this.inputReader = inputReader;
        this.modal = modal;
    }
    
    public boolean isValidLoginForm() {
        
        String email = inputReader.getEmail();
        String pass = inputReader.getPassword();
        
        if ( !isValidEmail(email) ) {
            modal.show("El email no es válido", ModalTypeEnum.error);
            return false;
        }
        
        if ( !isValidPassword(pass) ) {
            modal.show("La contraseña no es válida", ModalTypeEnum.error);
            return false;
        }
        
        return true;
    }
    
    private boolean isValidEmail(String email) {
        if ( email == null ) return false;
        email = email.trim();
        return !email.isEmpty() && EmailValidator.isValidEmail(email);
    }
    
    private boolean isValidPassword( String password ) {
        if ( password == null ) return false;
        password = password.trim();
        return !password.isEmpty();
    }
    
}
