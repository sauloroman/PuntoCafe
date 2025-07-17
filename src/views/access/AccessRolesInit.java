package views.access;

import views.access.AccessRoles;
import views.components.ImageCustom;

public class AccessRolesInit {
 
    private final ImageCustom image = new ImageCustom();
    private final AccessRoles view;
    private final int PANEL_WIDTH = 1200;
    private final int PANEL_HEIGHT = 900;
    
    public AccessRolesInit(AccessRoles view) {
        this.view = view;
    }
    
    public void init() {
        view.setVisible(true);
        view.setSize(PANEL_WIDTH, PANEL_HEIGHT);
        
        image.addImageFix(view.iconAdmin, "icon-admin", 40, 40);
        image.addImageFix(view.iconSeller, "icon-seller", 40, 40);
        image.addImageFix(view.iconSupervisor, "icon-supervisor", 40, 40);
        image.addImageFix(view.logoRH, "logo-rh", 50, 50);
    }
    
}
