package controllers.auth.handlers;

import controllers.auth.helpers.InputReader;
import entities.User;
import services.AuthService;
import utils.helpers.Crypter;

public class LoginUserHandler {
    
    private final InputReader inputReader;
    private final AuthService service;

    public LoginUserHandler(InputReader inputReader, AuthService service) {
        this.inputReader = inputReader;
        this.service = service;
    } 

    public User login() {
        String email = inputReader.getEmail();
        String cryptPass = Crypter.cryptPassword(inputReader.getPassword());
        
        return service.loginUser(email, cryptPass);
    }

    
    
}
