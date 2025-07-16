package controllers.user.handlers;

import interfaces.HandlerController;
import entities.User;
import services.RoleService;
import services.UserService;
import utils.enums.ModalTypeEnum;
import utils.helpers.Crypter;
import utils.helpers.Modal;
import views.access.AccessCreateUser;

public class CreateUserHandler implements HandlerController {

    private final AccessCreateUser createView;
    private final UserService userService;
    private final RoleService roleService;
    private final Modal modal;
    private String image = null;

    public CreateUserHandler(AccessCreateUser createView, UserService userService, RoleService roleService, Modal modal ) {
        this.createView = createView;
        this.userService = userService;
        this.roleService = roleService;
        this.modal = modal;
    }
    
    @Override
    public void execute() {

        String name = createView.userNameTxt.getText();
        String lastname = createView.userLastnameTxt.getText();
        String email = createView.userEmailTxt.getText();
        String pass = createView.userPassTxt.getText();
        String role = createView.userRoleCombo.getSelectedItem().toString();
        int roleId = roleService.getRoleByName(role).getRoleId();
        
        if ( userService.getUserByEmail(email) != null ) {
            modal.show("Ya existe un usuario con ese correo. Intente con uno nuevo", ModalTypeEnum.error);
            return;
        }
        
        String passwordCrypt = Crypter.cryptPassword(pass);
        User user = new User(name, lastname, image, email, passwordCrypt, roleId );
        
        if ( !userService.saveUser(user) ) {
            modal.show("No se pudo guardar el usuario", ModalTypeEnum.error);
            return;
        }
        
        modal.show("Usuario creado exitosamente", ModalTypeEnum.success);
    }
    
    public void setImage(String userImage) {
        this.image = userImage;
    }
    
}
