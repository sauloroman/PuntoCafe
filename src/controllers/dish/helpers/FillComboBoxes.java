package controllers.dish.helpers;

import entities.Category;
import java.util.List;
import views.warehouse.WarehouseCreateDish;
import views.warehouse.WarehouseDishes;
import views.warehouse.WarehouseEditDish;

public class FillComboBoxes {
    
    private final WarehouseDishes view;
    private final WarehouseCreateDish createDishView;
    private final WarehouseEditDish editDishView;
    
    public FillComboBoxes(WarehouseDishes view, WarehouseCreateDish createDishView, WarehouseEditDish editDishView) {
        this.view = view;
        this.createDishView = createDishView;
        this.editDishView = editDishView;
    }
    
    public void categoriesFilterBox(List<Category> categories) {
        view.dishCategoryCombo.removeAllItems();
        view.dishCategoryCombo.addItem("Categorías");
        for(Category category: categories) {
            view.dishCategoryCombo.addItem(category.getCategoryName());
        }
        view.dishCategoryCombo.setSelectedItem(0);
    }
    
    public void categoriesCreateBox(List<Category> categories) {
        createDishView.dishCategoryCombo.removeAllItems();
        createDishView.dishCategoryCombo.addItem("Categorías");
        for(Category category: categories) {
            createDishView.dishCategoryCombo.addItem(category.getCategoryName());
        }
        createDishView.dishCategoryCombo.setSelectedItem(0);
    }
    
    public void categoriesEditBox(List<Category> categories) {
        editDishView.dishEditCategoryCombo.removeAllItems();
        editDishView.dishEditCategoryCombo.addItem("Categorías");
        for(Category category: categories) {
            editDishView.dishEditCategoryCombo.addItem(category.getCategoryName());
        }
        editDishView.dishEditCategoryCombo.setSelectedItem(0);
    }
    
}
