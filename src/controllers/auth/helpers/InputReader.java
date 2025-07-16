package controllers.auth.helpers;

import views.login.Login;

public class InputReader {
 
    private final Login view;

    public InputReader(Login view) {
        this.view = view;
    }
    
    public String getEmail() {
        String email = view.emailTxt.getText().trim();
        if ( email.equals("Ingrese su correo") ) return "";
        return email;
    }
    
    public String getPassword() {
        String pass = view.passwordTxt.getText().trim(); 
        if ( pass.equals("Ingrese su contraseña") ) return "";
        return pass;
    }
    
}
