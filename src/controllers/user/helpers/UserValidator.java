package controllers.user.helpers;

import utils.enums.ModalTypeEnum;
import utils.helpers.Modal;
import utils.validators.EmailValidator;
import views.access.AccessCreateUser;
import views.access.AccessEditUser;

public class UserValidator {
    
    private final AccessCreateUser createView;
    private final AccessEditUser editView;
    private final Modal modal; 
    
    public UserValidator(AccessCreateUser createView, AccessEditUser editView, Modal modal) {
        this.createView = createView;
        this.editView = editView;
        this.modal = modal;
    }
    
    public boolean isValidCreation() {
        
        String name = createView.userNameTxt.getText();
        String lastname = createView.userLastnameTxt.getText();
        String email = createView.userEmailTxt.getText();
        String pass = createView.userPassTxt.getText();
        String confirmPass = createView.userConfirmPassTxt.getText();
        String role = createView.userRoleCombo.getSelectedItem().toString();
        
        if (!isValidName(name)) {
            modal.show("El nombre del usuario es obligatorio y menor a 60 caracteres", ModalTypeEnum.error);
            return false;
        }
        
        if (!isValidLastname(lastname)) {
            modal.show("El apellido del usuario es obligatorio y menor a 60 caracteres", ModalTypeEnum.error);
            return false;
        }
        
        if (!isValidEmail(email)) {
            modal.show("El correo es obligatorio y debe ser menor a 100 caracteres", ModalTypeEnum.error);
            return false;
        }
        
        if (!isValidPassword(pass)) {
            modal.show("La contraseña es obligatoria y debe tener por lo menos 3 caracteres y máximo 20 caracteres", ModalTypeEnum.error);
            return false;
        }
        
        if (!AreEqualPasswords(pass, confirmPass)) {
            modal.show("Las contraseñas deben ser iguales", ModalTypeEnum.error);
            return false;
        }
        
        if (!isValidRole(role) ) {
            modal.show("El rol es obligatorio", ModalTypeEnum.error);
            return false; 
        }
        
        return true;
    }
    
    public boolean isValidEdition() {
        
        String name = editView.userNameTxt.getText();
        String lastname = editView.userLastnameTxt.getText();
        String email = editView.userEmailTxt.getText();
        String role = editView.userRoleCombo.getSelectedItem().toString();

        if (!isValidName(name)) {
            modal.show("El nombre del usuario es obligatorio y menor a 60 caracteres", ModalTypeEnum.error);
            return false;
        }
        
        if (!isValidLastname(lastname)) {
            modal.show("El apellido del usuario es obligatorio y menor a 60 caracteres", ModalTypeEnum.error);
            return false;
        }
        
        if (!isValidEmail(email)) {
            modal.show("El correo es obligatorio y debe ser menor a 100 caracteres", ModalTypeEnum.error);
            return false;
        }
        
        if (!isValidRole(role) ) {
            modal.show("El rol es obligatorio", ModalTypeEnum.error);
            return false; 
        }
        
        return true;
        
    }
    
    private boolean isValidName(String name) {
        if ( name == null ) return false;
        name = name.trim();
        return !name.isEmpty() && name.length() <= 60;
    }
    
    private boolean isValidLastname(String lastname) {
        if ( lastname == null ) return false;
        lastname = lastname.trim();
        return !lastname.isEmpty() && lastname.length() <= 60;
    }
    
    private boolean isValidEmail(String email) {
        if ( email == null ) return false;
        email = email.trim();
        return EmailValidator.isValidEmail(email) && email.length() <= 100;
    }
    
    private boolean isValidPassword(String pass) {
        if ( pass == null ) return false;
        pass = pass.trim();
        return !pass.isEmpty() && pass.length() >= 3 && pass.length() <= 20;
    }
    
    private boolean isValidRole(String role) {
        return !role.equals("Selecciona un rol");
    } 
    
    private boolean AreEqualPasswords(String pass, String confirmPass) {
        if ( pass == null || confirmPass == null ) return false;
        return pass.equals(confirmPass);
    }
    
}
