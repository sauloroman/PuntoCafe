package controllers.product.helpers;

import interfaces.ChangeStatusNoTableInterface;
import services.ProductService;
import utils.enums.ModalTypeEnum;
import utils.helpers.Modal;
import views.warehouse.WarehouseInfoProduct;

public class ChangeProductStatus implements ChangeStatusNoTableInterface {

    private final WarehouseInfoProduct view;
    private final ProductService service;
    private final Modal modal;
    private final boolean activate;

    public ChangeProductStatus(
            WarehouseInfoProduct view, 
            ProductService service, 
            Modal modal, 
            boolean activate
    ) {
        this.view = view;
        this.service = service;
        this.modal = modal;
        this.activate = activate;
    }

    @Override
    public boolean change(int id) {
        
        boolean wasStatusChanged = activate ? service.activateProduct(id) : service.deactivateProduct(id);
        
        if ( !wasStatusChanged ) {
            modal.show("El estado del producto no pudo ser cambiado", ModalTypeEnum.warning);
            return false; 
        }
        
        modal.show("El estado del producto ha cambiado", ModalTypeEnum.success);
        return true;
    }
    
    @Override
    public boolean isValidStatus(boolean status) {
        
        if( activate && status ) {
            modal.show("El producto ya está activo", ModalTypeEnum.warning);
            return false;
        }
        
        if( !activate && !status ) {
            modal.show("El producto ya está inactivo", ModalTypeEnum.warning);
            return false;
        }
        
        return true;
        
    }

    @Override
    public boolean confirmChange() {
        return modal.confirm("¿Está seguro de cambiar el estado del producto?") == 0;
    }
    
}
