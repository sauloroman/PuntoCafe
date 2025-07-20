package controllers.product.helpers;

import views.warehouse.WarehouseProducts;

public class QuantityProducts {
    
    private final WarehouseProducts view;

    public QuantityProducts(WarehouseProducts view) {
        this.view = view;
    }
    
    public void setQuantity( int quantity ) {
        view.quantityProducts.setText(quantity + "");
    }
    
}
