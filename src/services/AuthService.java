package services;

import entities.User;
import models.AuthModel;

public class AuthService {
    
    private final AuthModel model;

    public AuthService(AuthModel model) {
        this.model = model;
    }
    
    public User getUserByEmail(String email) {
        if ( email == null ) return null;
        return model.getUserByEmail(email);
    }
    
    public User loginUser(String email, String password) {
        if ( email == null || password == null ) return null;
        return model.login(email, password);
    }
    
}
