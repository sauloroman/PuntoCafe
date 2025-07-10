package controllers.category.helpers;

import services.CategoryService;
import utils.enums.SearchCriteriaEnum;
import views.warehouse.WarehouseCategories;

public class QuantityCategory {
    
    private final WarehouseCategories view;
    private final CategoryService service;

    public QuantityCategory(WarehouseCategories view, CategoryService categoryService) {
        this.view = view;
        this.service = categoryService;
    }

    public void setQuantities() {
        int total = service.getTotal();
        int totalActive = service.getTotalByFilter("Activo", SearchCriteriaEnum.STATUS);
        int totalInactive = service.getTotalByFilter("Inactivo", SearchCriteriaEnum.STATUS);
        
        view.quantityTotalCategories.setText(total + "");
        view.quantityActiveCategories.setText(totalActive + "");
        view.quantityInactiveCategories.setText(totalInactive + "");
    }
    
}
