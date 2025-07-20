package controllers.dish.helpers;

import views.warehouse.WarehouseDishes;

public class QuantityDishes {
    
    private final WarehouseDishes view;

    public QuantityDishes(WarehouseDishes view) {
        this.view = view;
    }
    
    public void setQuantity( int quantity ) {
        view.quantityDishes.setText(quantity + "");
    }
    
}
