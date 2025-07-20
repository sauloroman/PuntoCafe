package controllers.supplier.helpers;

import views.purchases.PurchasesSuppliers;

public class QuantitySuppliers {
    
    private final PurchasesSuppliers view;

    public QuantitySuppliers(PurchasesSuppliers view) {
        this.view = view;
    }
    
    public void setQuantity( int quantity ) {
        view.quantitySuppliers.setText(quantity + "");
    }
    
}
