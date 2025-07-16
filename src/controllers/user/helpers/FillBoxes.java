package controllers.user.helpers;

import entities.Role;
import java.util.List;
import views.access.AccessCreateUser;
import views.access.AccessEditUser;

public class FillBoxes {
    
    private final AccessCreateUser createView;
    private final AccessEditUser editView;

    public FillBoxes(AccessCreateUser createView, AccessEditUser editView) {
        this.createView = createView;
        this.editView = editView;
    }

    public void fillRoleBox(List<Role> roles) {
        createView.userRoleCombo.removeAllItems();
        createView.userRoleCombo.addItem("Seleccione un rol");
        for ( Role role: roles ) {
            createView.userRoleCombo.addItem(role.getRoleName());
        }
        createView.userRoleCombo.setSelectedIndex(0);
    }
    
    public void fillRoleEditBox(List<Role> roles) {
        editView.userRoleCombo.removeAllItems();
        editView.userRoleCombo.addItem("Seleccione un rol");
        for ( Role role: roles ) {
            editView.userRoleCombo.addItem(role.getRoleName());
        }
        editView.userRoleCombo.setSelectedIndex(0);
    }
    
    
    
}
