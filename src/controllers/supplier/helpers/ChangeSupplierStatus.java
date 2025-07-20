package controllers.supplier.helpers;

import services.SupplierService;
import views.purchases.PurchasesSuppliers;

public class ChangeSupplierStatus {
    
    private final PurchasesSuppliers view;
    private final SupplierService service;
    private final boolean activate;

    public ChangeSupplierStatus(
            PurchasesSuppliers view, 
            SupplierService service,
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
        return activate ? service.activateSupplier(id) : service.deactivateSupplier(id);
    }

    public boolean isStatusValid(String status) {
        if ( activate && status.equals("Activo") ) {
           return false;
        }
        
        return !(!activate && status.equals("Inactivo"));
    }

}
