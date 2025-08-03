package controllers.menu.helpers;

import services.MenuService;
import views.warehouse.WarehouseMenus;

public class ChangeMenuStatus {
    
    private final MenuService service;
    private final boolean activate;

    public ChangeMenuStatus(
            MenuService service,
            boolean activate
    ) {
        this.service = service;
        this.activate = activate;
    }

    public boolean getActivate() {
        return activate;
    }
    
    public boolean change( int id ) {
        return activate ? service.activateMenu(id) : service.deactivateMenu(id);
    }

    public boolean isStatusValid(String status) {
        if ( activate && status.equals("Activo") ) {
           return false;
        }
        
        return !(!activate && status.equals("Inactivo"));
    }

    
}
