package controllers.supplier.helpers;

import entities.Supplier;
import services.SupplierService;
import views.purchases.PurchasesSuppliers;

public class SupplierFromTable {
  
    private final PurchasesSuppliers view;
    private final SupplierService service;

    public SupplierFromTable(PurchasesSuppliers view, SupplierService service) {
        this.view = view;
        this.service = service;
    }
    
    public Supplier supplierSelectedInTable( int selectedRow ) {
        int supplierId = Integer.parseInt(view.suppliersTable.getValueAt(selectedRow, 0).toString());
        Supplier supplier = service.getById(supplierId);
        return supplier;
    }

}
