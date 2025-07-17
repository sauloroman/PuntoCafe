package controllers.category.helpers;

import services.CategoryService;
import views.warehouse.WarehouseCategories;

public class ChangeCategoryStatus {
    
    private final WarehouseCategories view;
    private final CategoryService service;
    private final boolean activate;

    public ChangeCategoryStatus(
            WarehouseCategories view, 
            CategoryService service,
            boolean activate
    ) {
        this.view = view;
        this.service = service;
        this.activate = activate;
    }

    public boolean getActivate() {
        return activate;
    }
    
    public boolean change( int id ) {
        return activate ? service.activateCategory(id) : service.deactivateCategory(id);
    }

    public boolean isStatusValid(String status) {
        if ( activate && status.equals("Activo") ) {
           return false;
        }
        
        return !(!activate && status.equals("Inactivo"));
    }

}
