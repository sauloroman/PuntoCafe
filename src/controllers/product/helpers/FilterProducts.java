package controllers.product.helpers;

import services.CategoryService;
import views.warehouse.WarehouseProducts;

public class FilterProducts {
    
    private final WarehouseProducts view;
    private final CategoryService categoryService;

    public FilterProducts(
            WarehouseProducts view,  
            CategoryService categoryService
    ) {
        this.view = view;
        this.categoryService = categoryService;
    }
    
    public int getCategoryIDSelected() {
        String categorySelected = view.productCategoryCombo.getSelectedItem().toString();
        if ( categorySelected.equals("Categorías") ) return -1;
        int categoryId = categoryService.getByName(categorySelected).getCategoryId();
        return categoryId;
    }
    
    public String getSupplierCompanyName() {
        String supplierSelected = view.productSupplierCombo.getSelectedItem().toString();
        if ( supplierSelected.equals("Proveedores") ) return null;
        return supplierSelected;
    }
    
}
