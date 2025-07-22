package controllers.auth;

import controllers.auth.handlers.LoginUserHandler;
import controllers.auth.helpers.ViewElements;
import controllers.auth.helpers.InputReader;
import controllers.auth.helpers.LoginValidator;
import entities.User;
import java.awt.Window;
import java.util.function.Consumer;
import models.AuthModel;
import puntocafe.PuntoCafe;
import services.AuthService;
import utils.enums.ModalTypeEnum;
import utils.helpers.Modal;
import views.MainFrame;
import views.login.Login;

public class AuthController {
    
    private final Login loginView;
    private final AuthModel model;
    private final AuthService service;
    private final LoginValidator validator;
    private final InputReader inputReader;
    private final LoginUserHandler loginUser;
    private final ViewElements elements;
    private final Modal modal = new Modal("PuntoCafé - Sesión de usuario");
    public User userLogged = null;
    private Consumer<User> onLoginSucess;
    private final PuntoCafe app;
    
    public AuthController(PuntoCafe app, Login loginView, AuthModel model) {
        this.app = app;
        this.loginView = loginView;
        this.model = model;
        
        this.service = new AuthService(this.model);
        
        this.inputReader = new InputReader(loginView);
        this.validator = new LoginValidator(inputReader, modal);
        this.elements = new ViewElements(loginView);
        
        this.loginUser = new LoginUserHandler(inputReader, service);
        
        initHandler();
    }
    
    private void initHandler() {
        loginView.btnLogin.addActionListener(e -> loginUser());
        loginView.btnShowPassword.addActionListener(e -> elements.showPassword(loginView.passwordTxt));
    }
    
    private void loginUser() {
        if ( !validator.isValidLoginForm() ) return;
        
        if ( service.getUserByEmail(inputReader.getEmail()) == null ) {
            modal.show("El usuario con email " + inputReader.getEmail() + " no existe", ModalTypeEnum.error);
            return;
        }
        
        User user = loginUser.login();
        
        if ( user == null ) {
            modal.show("Credenciales Incorrectas. Intente nuevamente", ModalTypeEnum.error);
            return;
        }
        
        if ( !user.getIsActive() ) {
            modal.show("El usuario está desactivado. Hable con el administrador", ModalTypeEnum.error);
            return;
        }
        
        modal.show("Bievenido de vuelta " + user.getUserName() + " " + user.getUserLastname() + "!", ModalTypeEnum.success);
        userLogged = user;
        loginView.dispose();
        
        if ( onLoginSucess != null ) {
            onLoginSucess.accept(user);
        }
    }
    
    public void logoutUser(MainFrame mainFrame) {
        if ( modal.confirm("¿Está seguro de cerrar la sesión?") != 0 ) return;

        this.userLogged = null;

        for (Window window : Window.getWindows()) {
            window.dispose();
        }
        
        this.app.showLogin();
    }
    
    public User getUserLogged() {
        return userLogged;
    }
    
    public void setOnLoginSuccess(Consumer<User> callback) {
        this.onLoginSucess = callback;
    }
    
}
