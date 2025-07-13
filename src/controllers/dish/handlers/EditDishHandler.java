package controllers.dish.handlers;

import controllers.interfaces.HandlerController;
import services.CategoryService;
import services.DishService;
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
