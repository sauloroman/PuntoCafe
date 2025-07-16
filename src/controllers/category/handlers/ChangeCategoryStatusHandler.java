package controllers.category.handlers;

import controllers.interfaces.ChangeStatusInterface;
import services.CategoryService;
import utils.enums.ModalTypeEnum;
import views.warehouse.WarehouseCategories;
import utils.helpers.Modal;

public class ChangeCategoryStatusHandler implements ChangeStatusInterface {
    
    private final WarehouseCategories view;
    private final CategoryService service;
    private final Modal modal;
    private final boolean activate;

    public ChangeCategoryStatusHandler(
            WarehouseCategories view, 
            CategoryService service, 
            Modal modal,
            boolean activate
    ) {
        this.view = view;
        this.service = service;
        this.modal = modal;
        this.activate = activate;
    }

    @Override
    public boolean change( int row ) {
        int id = Integer.parseInt(view.categoriesTable.getValueAt(row, 0).toString());

        boolean wasStatusUpdated = activate ? service.activateCategory(id) : service.deactivateCategory(id);
        
        if ( !wasStatusUpdated ) {
           modal.show("No se pudo cambiar el estado.", ModalTypeEnum.error);
           return false;
        }
       
        modal.show("El estado ha cambiado", ModalTypeEnum.success);
        return true;
    }
    
    @Override
    public boolean isStatusValid(int row) {
        String status = String.valueOf(view.categoriesTable.getValueAt(row, 6));
        
        if ( activate && status.equals("Activo") ) {
           modal.show("La categoría ya está activa", ModalTypeEnum.error );
           return false;
        }
        
        if ( !activate && status.equals("Inactivo")) {
           modal.show("La categoría ya está inactiva", ModalTypeEnum.error );
           return false;
        }
        
        return true;
    }

    @Override
    public boolean confirmChange(int row) {
        String name = String.valueOf(view.categoriesTable.getValueAt(row, 1));
        return modal.confirm("¿Está seguro que desea cambiar el estado de la categoría " + name + "?") == 0;
    }

}
