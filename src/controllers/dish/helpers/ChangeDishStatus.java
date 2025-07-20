package controllers.dish.helpers;

import interfaces.ChangeStatusNoTableInterface;
import services.DishService;
import utils.enums.ModalTypeEnum;
import utils.helpers.Modal;
import views.warehouse.WarehouseInfoDish;

public class ChangeDishStatus implements ChangeStatusNoTableInterface {

    private final WarehouseInfoDish view;
    private final DishService service;
    private final Modal modal;
    private final boolean activate;

    public ChangeDishStatus(WarehouseInfoDish view, DishService service, Modal modal, boolean activate) {
        this.view = view;
        this.service = service;
        this.modal = modal;
        this.activate = activate;
    }

    @Override
    public boolean change(int id) {
        boolean wasStatusChanged = activate ? service.activateDish(id) : service.deactivateDish(id);
        
        if ( !wasStatusChanged ) {
            modal.show("El estado del platillo no pudo ser cambiado", ModalTypeEnum.error);
            return false;
        }
        
        modal.show("El estado del producto ha cambiado", ModalTypeEnum.success);
        return true;
    }
    
    @Override
    public boolean isValidStatus(boolean status) {
        if ( activate && status ) {
            modal.show("El platillo ya está activo", ModalTypeEnum.warning);
            return false;
        }
        
        if ( !activate && !status ) {
            modal.show("El platillo ya está inactivo", ModalTypeEnum.warning);
            return false;
        }     
        
        return true;
    }

    @Override
    public boolean confirmChange() {
        return modal.confirm("¿Está seguro de cambiar el estado del platillo?") == 0;
    }
}
