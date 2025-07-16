package controllers.user.handlers;

import interfaces.HandlerController;
import services.RoleService;
import services.UserService;
import views.access.AccessRoles;

public class QuantityUsersByRoleHandler implements HandlerController {
    
    private final AccessRoles view;
    private final RoleService roleService;
    private final UserService userService;

    public QuantityUsersByRoleHandler(AccessRoles view, RoleService roleService, UserService userService) {
        this.view = view;
        this.roleService = roleService;
        this.userService = userService;
    }
    
    @Override
    public void execute() {
        
        int roleAdminId = roleService.getRoleByName("Administrador").getRoleId();
        int roleSellerId = roleService.getRoleByName("Vendedor").getRoleId();
        int roleSupervisorId = roleService.getRoleByName("Supervisor").getRoleId();
        
        int quantityAdmins = this.userService.getQuantityUserByRole( roleAdminId );
        int quantitySeller = this.userService.getQuantityUserByRole( roleSellerId );
        int quantitySupervisor  = this.userService.getQuantityUserByRole( roleSupervisorId );
        
        view.quantityAdmins.setText(quantityAdmins + "");
        view.quantitySellers.setText(quantitySeller + "");
        view.quantitySupervisors.setText(quantitySupervisor + "");
        
    }
    
}
