package controllers.auth.helpers;

import javax.swing.JPasswordField;
import views.login.Login;

public class ViewElements {
    
    private final Login view;

    public ViewElements(Login view) {
        this.view = view;
    }
    
    public void showPassword(JPasswordField field) {
        if (field.getEchoChar() == (char) 0) {
            field.setEchoChar('▪');
        } else {
            field.setEchoChar((char) 0);
        }
    }
}
