package views.login;

import java.awt.Color;
import utils.constants.ViewConstants;
import views.components.Button;
import views.components.ImageCustom;
import views.components.Input;
import views.login.Login;

public class LoginInit {
    
    private final Button button = new Button();
    private final ImageCustom image = new ImageCustom();
    private final Input input = new Input();
    private final Login view;

    public LoginInit(Login view) {
        this.view = view;
    }
    
    public void init() {
        
        view.setResizable(false);
        view.setSize(1100, 650);
        view.setLocationRelativeTo(null);
        view.setVisible(true);
        
        view.nameApp.setForeground(Color.decode(ViewConstants.mainColor));
        image.addImageFix(view.loginImage, "login-3", 700, 700);
        image.addImageFix(view.logo, "logo-rh", 50, 50);
        
        input.roundedField(view.emailTxt, "#DDDDDD", 10, "Ingrese su correo");
        input.roundedPasswordField(view.passwordTxt, "#DDDDDD", 10, "Ingrese su contraseña");
        
        button.outlineButton(view.btnShowPassword, "#DDDDDD", ViewConstants.textBtn);
        button.addIcon(view.btnShowPassword, "icon-eye", 14);
        button.solidButton(view.btnLogin, ViewConstants.mainColor, ViewConstants.whiteColor, 12);
        button.addIcon(view.btnLogin, "icon-login", 20);
    }
    
}
