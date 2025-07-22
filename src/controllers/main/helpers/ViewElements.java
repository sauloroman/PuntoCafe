package controllers.main.helpers;

import entities.User;
import java.awt.Color;
import views.MainFrame;
import views.components.ImageCustom;

public class ViewElements {
    
    private final ImageCustom imageCustom = new ImageCustom();
    private final MainFrame view;

    public ViewElements(MainFrame view) {
        this.view = view;
    }
    
    public void setUserInfo(User user, String roleName) {
        view.userName.setText(user.getUserName() + " " + user.getUserLastname());
        view.welcomeMessage.setText("¡Bienvenido " + user.getUserName() + " " + user.getUserLastname() + "!");
        view.userRole.setText( roleName );
        setColorRolLabel(roleName);
        imageCustom.addImageUser(view.userPhoto, user.getUserImage(), 35, 35);
    }
    
    private void setColorRolLabel(String roleName) {
        view.userRole.setForeground(Color.WHITE);
        switch (roleName) {
            case "Administrador" -> view.userRole.setBackground(Color.decode("#9933FF"));
            case "Vendedor" -> view.userRole.setBackground(Color.decode("#FFCC00"));
            case "Supervisor" -> view.userRole.setBackground(Color.decode("#009933"));
        }
    }
    
}
