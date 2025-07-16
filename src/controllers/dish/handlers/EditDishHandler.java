package controllers.dish.handlers;

import interfaces.HandlerController;
import entities.Category;
import entities.Dish;
import services.CategoryService;
import services.DishService;
import utils.enums.ModalTypeEnum;
import utils.helpers.Modal;
import views.warehouse.WarehouseEditDish;

public class EditDishHandler implements HandlerController {
    
    private final WarehouseEditDish view;
    private final Modal modal;
    private final CategoryService categoryService;
    private final DishService dishService;
    private String image = null;
    private String dishOldName = null;
    private int dishId = 0;

    public EditDishHandler(
            WarehouseEditDish view, 
            CategoryService categoryService, 
            DishService dishService,
            Modal modal
    ) {
        this.view = view;
        this.categoryService = categoryService;
        this.dishService = dishService;
        this.modal = modal;
    }
    
    @Override
    public void execute() {
        String dishName = view.dishEditNameTxt.getText().trim();
        Double dishPrice = Double.valueOf(view.dishEditPriceTxt.getText().toString());
        String dishDescription = view.dishEditDescriptionTxt.getText();
        
        String categorySelected = view.dishEditCategoryCombo.getSelectedItem().toString();
        Category category = categoryService.getByName(categorySelected);
        int categoryId = category.getCategoryId();
        
        Dish existingDish = dishService.getDishByName(dishName);
        
        if ( !dishName.equals(dishOldName) && existingDish != null && existingDish.getDishID() != dishId ) {
            modal.show("El platillo ya existe", ModalTypeEnum.error);
            return;
        }
        
        Dish dish = new Dish(
                dishName,
                dishDescription,
                image,
                dishPrice,
                categoryId
        );
        
        if (!dishService.editDish(dish, dishId)) {
            modal.show("El platillo no pudo ser actualizado", ModalTypeEnum.error);
            return;
        }
        
        modal.show("El platillo ha sido actualizado exitosamente", ModalTypeEnum.success);           
    }
    
    public void setDishOldName(String name) {
        this.dishOldName = name;
    }
    
    public void setDishImage(String dishImage) {
        this.image = dishImage;
    }
    
    public void setDishId( int id ) {
        dishId = id;
    }
    
}
