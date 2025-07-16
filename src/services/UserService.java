package services;

import entities.User;
import java.util.List;
import models.UserModel;
import utils.enums.SearchCriteriaEnum;

public class UserService {
    
    private final UserModel model;

    public UserService(UserModel model) {
        this.model = model;
    }
    
    public User getUserById(int id) {
        return model.getItemById(id);
    }
    
    public User getUserByEmail(String email) {
        return model.getUserByEmail(email);
    }
    
    public boolean saveUser(User user) {
        if ( user == null ) return false;
        return model.saveItem(user);
    }
    
    public List<User> getAllUsers() {
        return model.listItems("");
    }
    
    public int getTotalUsers() {
        return model.getTotalItems();
    }
    
    public List<User> getUsersByPage(String filter, SearchCriteriaEnum criteria, int page, int quantity) {
        return model.listItemsByPage(filter, criteria, page, quantity);
    }
    
    public int getQuantityUsers() {
        return model.getTotalItems();
    }
    
    public boolean updateUser(User user, int id) {
        if ( user == null || id < 0 ) return false;
        return model.updateItem(user, id);
    }
    
    public boolean activateUser( int userId ) {
        return model.changeStatus(userId, true);
    }
    
    public boolean deactivateUser( int userId ) {
        return model.changeStatus(userId, false);
    } 
}
