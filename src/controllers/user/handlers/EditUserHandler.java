package controllers.user.handlers;

import interfaces.HandlerController;
import entities.User;
import services.RoleService;
import services.UserService;
import utils.enums.ModalTypeEnum;
import utils.helpers.Modal;
import views.access.AccessEditUser;

public class EditUserHandler implements HandlerController {
    
    private final AccessEditUser view;
    private final UserService userService;
    private final RoleService roleService;
    private final Modal modal;
    private String image = null;
    private String oldEmail = null;
    private int id = -1;

    public EditUserHandler(
            AccessEditUser view, 
            UserService userService, 
            RoleService roleService, 
            Modal modal
    ) {
        this.view = view;
        this.userService = userService;
        this.roleService = roleService;
        this.modal = modal;
    }

    @Override
    public void execute() {

        String name = view.userNameTxt.getText();
        String lastname = view.userLastnameTxt.getText();
        String email = view.userEmailTxt.getText();
        String role = view.userRoleCombo.getSelectedItem().toString();
        int roleId = roleService.getRoleByName(role).getRoleId();
        
        User existingUser = userService.getUserByEmail(email);
         
        if ( !email.equals( oldEmail ) && existingUser != null ) {
            modal.show("Ya existe un usuario con ese email", ModalTypeEnum.error);
            return;
        }
        
        User user = new User( name, lastname, image, email, roleId );
        
        if ( !userService.updateUser(user, id) ) {
            modal.show("El usuario no se pudo actualizar", ModalTypeEnum.error);
            return;
        }
        
        modal.show("El usuario ha sido actualizado exitosamente", ModalTypeEnum.success);
        return;
        
    }
    
    public void setImage(String userImage) {
        this.image = userImage;
    }
    
    public void setEmail(String userEmail) {
        this.oldEmail = userEmail;
    }
    
    public void setId(int userId) {
        this.id = userId;
    }
 
}
