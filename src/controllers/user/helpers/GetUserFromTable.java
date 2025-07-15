package controllers.user.helpers;

import entities.User;
import services.UserService;
import views.access.AccessUsers;

public class GetUserFromTable {

    private final AccessUsers view;
    private final UserService service;

    public GetUserFromTable(AccessUsers view, UserService service) {
        this.view = view;
        this.service = service;
    }
    
    public User getUser( int selectedRow ) {
        int userId = Integer.parseInt(view.usersTable.getValueAt(selectedRow, 0).toString());
        User user = service.getUserById(userId);
        return user;
    }
    
}
