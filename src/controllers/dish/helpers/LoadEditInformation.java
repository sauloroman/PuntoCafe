package controllers.dish.helpers;

import entities.Category;
import entities.Dish;
import services.CategoryService;
import views.components.ImageCustom;
import views.warehouse.WarehouseEditDish;

public class LoadEditInformation {
    
    private final ImageCustom image = new ImageCustom();
    private final WarehouseEditDish view;
    private final CategoryService categoryService;
    
    public LoadEditInformation (
            WarehouseEditDish view,
            CategoryService categoryService
    ) {
        this.view = view;
        this.categoryService = categoryService;
    }
    
    public void load( Dish dish ) {
        Category category = categoryService.getById(dish.getCategoryId());
        String categoryName = category.getCategoryName();
        
        view.dishEditTitle.setText("Editar Platillo - " + dish.getDishName());
        view.dishEditNameTxt.setText(dish.getDishName());
        view.dishEditCategoryCombo.setSelectedItem(categoryName);
        view.dishEditPriceTxt.setText(dish.getDishSellingPrice().toString());
        view.dishEditDescriptionTxt.setText(dish.getDishDescription());
        image.addImageDish(view.dishEditImageLabel, dish.getDishImage(), 200, 200);
    }
}
