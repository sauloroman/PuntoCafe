package controllers.supplier.handlers;

import interfaces.ChangeStatusInterface;
import services.SupplierService;
import utils.enums.ModalTypeEnum;
import utils.helpers.Modal;
import views.purchases.PurchasesSuppliers;

public class ChangeSupplierStatusHandler implements ChangeStatusInterface {
    
    private final PurchasesSuppliers view;
    private final SupplierService service;
    private final Modal modal;
    private final boolean activate;
    
    public ChangeSupplierStatusHandler(
            PurchasesSuppliers view, 
            SupplierService service,
            Modal modal,
            boolean activate
    ) {
        this.view = view;
        this.service = service;
        this.modal = modal;
        this.activate = activate;
    }

    @Override
    public boolean change(int row) {
        int id = Integer.parseInt(view.suppliersTable.getValueAt(row, 0).toString());
        String name = view.suppliersTable.getValueAt(row, 1).toString();
        
        boolean wasStatusSupplierChanged = activate ? service.activateSupplier(id) : service.deactivateSupplier(id);
        
        if ( !wasStatusSupplierChanged ) {
            modal.show("El proveedor no pudo cambiar de estado", ModalTypeEnum.error);
            return false;
        }
            
        modal.show("El proveedor " + name + " ha cambiado de estado", ModalTypeEnum.success);
        return true;
    }

    @Override
    public boolean isStatusValid(int row) {
        String status = view.suppliersTable.getValueAt(row, 9).toString();

        if( activate && status.equals("Activo") ) {
            modal.show("El proveedor ya está activo", ModalTypeEnum.warning);
            return false;
        }
        
        if( !activate && status.equals("Inactivo") ) {
            modal.show("El proveedor ya está inactivo", ModalTypeEnum.warning);
            return false;
        }
        
        return true;
    }

    @Override
    public boolean confirmChange(int row) {
        String name = view.suppliersTable.getValueAt(row, 1).toString();
        return modal.confirm("¿Está seguro que desea cambiar el estado del proveedor " + name + "?") == 0;
    }
    
}
