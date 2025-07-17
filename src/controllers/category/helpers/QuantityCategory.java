package controllers.category.helpers;

import views.warehouse.WarehouseCategories;

public class QuantityCategory {
    
    private final WarehouseCategories view;

    public QuantityCategory(WarehouseCategories view) {
        this.view = view;
    }

    public void setQuantities( int quantity ) {
        view.quantityCategories.setText(quantity + "");
    }
    
}
