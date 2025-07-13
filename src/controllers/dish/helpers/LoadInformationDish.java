package controllers.dish.helpers;

import entities.Category;
import entities.Dish;
import services.CategoryService;
import views.components.ImageCustom;
import views.warehouse.WarehouseInfoDish;

public class LoadInformationDish {
    
    private final ImageCustom image = new ImageCustom();
    private final WarehouseInfoDish view;
    private final CategoryService categoryService;

    public LoadInformationDish(WarehouseInfoDish view, CategoryService categoryService) {
        this.view = view;
        this.categoryService = categoryService;
    }
    
    public void load(Dish dish) {
        
        Category category = categoryService.getById(dish.getCategoryId());
        String categoryName = category.getCategoryName();
        
        view.dishId.setText(dish.getDishID() + "");
        view.dishTitle.setText("Platillo seleccionado - " + dish.getDishName());
        view.dishCategory.setText(categoryName);
        view.dishName.setText(dish.getDishName());
        view.dishPrice.setText("$" + dish.getDishSellingPrice().toString() + "0");
        view.dishStatus.setText(dish.getIsActive() ? "Platillo Activo" : "Platillo Inactivo");
        view.dishCreatedAt.setText("Fecha de creación: " + dish.getDishCreatedAt());
        view.dishUpdatedAt.setText("Última actualización: " + dish.getDishUpdatedAt());
        view.dishDescription.setText(dish.getDishDescription());
        
        image.addImageDish(view.dishImage, "Platillo sin imagen".equals(dish.getDishImage()) ? "no-image.jpg" : dish.getDishImage(), 320, 320);
        
    }
    
}
