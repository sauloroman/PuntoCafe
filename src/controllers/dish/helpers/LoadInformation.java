package controllers.dish.helpers;

import entities.Category;
import entities.Dish;
import services.CategoryService;
import views.components.ImageCustom;
import views.warehouse.WarehouseEditDish;
import views.warehouse.WarehouseInfoDish;

public class LoadInformation {
    
    private final ImageCustom image = new ImageCustom();
    private final WarehouseInfoDish infoView;
    private final WarehouseEditDish editView;
    private final CategoryService categoryService;

    public LoadInformation(WarehouseInfoDish infoView, WarehouseEditDish editView, CategoryService categoryService) {
        this.infoView = infoView;
        this.editView = editView;
        this.categoryService = categoryService;
    }
    
    public void loadDishInfo(Dish dish, String categoryName) {
        infoView.dishId.setText(dish.getDishID() + "");
        infoView.dishCategory.setText(categoryName);
        infoView.dishName.setText(dish.getDishName());
        infoView.dishPrice.setText("$" + dish.getDishSellingPrice().toString() + "0");
        infoView.dishStatus.setText(dish.getIsActive() ? "Platillo Activo" : "Platillo Inactivo");
        infoView.dishCreatedAt.setText("Fecha de creación: " + dish.getDishCreatedAt());
        infoView.dishUpdatedAt.setText("Última actualización: " + dish.getDishUpdatedAt());
        infoView.dishDescription.setText(dish.getDishDescription());
        image.addImageDish(infoView.dishImage, "Platillo sin imagen".equals(dish.getDishImage()) ? "no-image.jpg" : dish.getDishImage(), 320, 320); 
    }
    
    public void loadEditInfo( Dish dish, String categoryName ) {        
        editView.dishEditNameTxt.setText(dish.getDishName());
        editView.dishEditCategoryCombo.setSelectedItem(categoryName);
        editView.dishEditPriceTxt.setText(dish.getDishSellingPrice().toString());
        editView.dishEditDescriptionTxt.setText(dish.getDishDescription());
        image.addImageDish(editView.dishEditImageLabel, dish.getDishImage(), 200, 200);
    }
    
}
