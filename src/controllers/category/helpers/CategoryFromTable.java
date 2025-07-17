package controllers.category.helpers;

import entities.Category;
import services.CategoryService;
import views.warehouse.WarehouseCategories;

public class CategoryFromTable {
  
    private final WarehouseCategories view;
    private final CategoryService service;

    public CategoryFromTable(WarehouseCategories view, CategoryService service) {
        this.view = view;
        this.service = service;
    }
    
    public Category categorySelectedInTable( int selectedRow ) {
        int categoryId = Integer.parseInt(view.categoriesTable.getValueAt(selectedRow, 0).toString());
        Category category = service.getById(categoryId);
        return category;
    }

}
