package controllers.category.helpers;

import views.warehouse.WarehouseCategories;

public class FillBoxes {
    
    private final WarehouseCategories view;

    public FillBoxes(WarehouseCategories view) {
        this.view = view;
    }
    
    public void fill(String typeProduct, String typeDish ) {
        view.categoryTypeCombo.addItem(typeProduct);
        view.categoryTypeCombo.addItem(typeDish);
        view.editCategoryTypeCombo.addItem(typeProduct);
        view.editCategoryTypeCombo.addItem(typeDish);
    }
    
}
