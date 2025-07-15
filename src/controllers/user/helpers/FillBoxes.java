package controllers.user.helpers;

import entities.Role;
import java.util.List;
import views.access.AccessCreateUser;

public class FillBoxes {
    
    private final AccessCreateUser createView;

    public FillBoxes(AccessCreateUser createView) {
        this.createView = createView;
    }

    public void fillRoleBox(List<Role> roles) {
        createView.userRoleCombo.removeAllItems();
        createView.userRoleCombo.addItem("Seleccione un rol");
        for ( Role role: roles ) {
            createView.userRoleCombo.addItem(role.getRoleName());
        }
        createView.userRoleCombo.setSelectedIndex(0);
    }
    
    
    
}
