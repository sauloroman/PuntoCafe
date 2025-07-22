package controllers.main;

import controllers.auth.AuthController;
import controllers.main.helpers.ViewElements;
import entities.User;
import models.RoleModel;
import services.RoleService;
import utils.helpers.Modal;
import views.MainFrame;

public class MainFrameController {
    
    private User user = null;
    private final MainFrame view;
    private final RoleModel roleModel;
    private final RoleService roleService;
    private final ViewElements elements;
    private final AuthController authController;
    private final Modal modal = new Modal("PuntoCafé - Cierre de sesión");
    
    public MainFrameController(MainFrame view, RoleModel roleModel, User user, AuthController authController) {
        this.view = view;
        this.roleModel = roleModel;
        this.roleService = new RoleService(this.roleModel);
        this.user = user;
        this.authController = authController;
        
        this.elements = new ViewElements(this.view);
        init();
        initListeners();
    }
    
    private void init() {
        String roleName = roleService.getRoleById(user.getRoleId()).getRoleName();
        elements.setUserInfo(user, roleName);
    }
    
    private void initListeners() {
        view.btnLogout.addActionListener(e -> authController.logoutUser(view));
    }
    
}
