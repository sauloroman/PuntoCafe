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
    
    public List<User> getUsersByPage(int page, int quantity) {
        return model.listItemsByPage("", SearchCriteriaEnum.NONE, page, quantity);
    }
}
