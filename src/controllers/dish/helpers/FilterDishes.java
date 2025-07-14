package controllers.dish.helpers;

import services.CategoryService;
import views.warehouse.WarehouseDishes;

public class FilterDishes {
    
    private final WarehouseDishes view;
    private final CategoryService categoryService;

    public FilterDishes(WarehouseDishes view, CategoryService categoryService) {
        this.view = view;
        this.categoryService = categoryService;
    }
    
    public String getDishNameSearched() {
        String dishNameSearched = view.dishSearchByNameTxt.getText().trim();
        if ( dishNameSearched.isEmpty() ) return null;
        return dishNameSearched;
    }
    
    public int getCategoryIDSelected() {
        String categorySelected = view.dishCategoryCombo.getSelectedItem().toString();
        if ( categorySelected.equals("Categorías") ) return -1;
        int categoryId = categoryService.getByName(categorySelected).getCategoryId();
        return categoryId;
    }
    
    public String getStatusSelected() {
        String statusSelected = view.dishStatusCombo.getSelectedItem().toString();
        if( statusSelected.equals("Estado") ) return null;
        return statusSelected;
    }
    
}
