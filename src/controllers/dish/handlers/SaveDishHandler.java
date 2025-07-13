package controllers.dish.handlers;

import controllers.interfaces.HandlerController;
import entities.Category;
import entities.Dish;
import services.CategoryService;
import services.DishService;
import utils.enums.ModalTypeEnum;
import utils.helpers.Modal;
import views.warehouse.WarehouseCreateDish;

public class SaveDishHandler implements HandlerController {

    private final WarehouseCreateDish createView;
    private final CategoryService categoryService;
    private final DishService dishService;
    private final Modal modal;
    private String image = null;

    public SaveDishHandler(
            WarehouseCreateDish createView, 
            CategoryService categoryService, 
            DishService dishService, 
            Modal modal
    ) {
        this.createView = createView;
        this.categoryService = categoryService;
        this.dishService = dishService;
        this.modal = modal;
    } 
    
    @Override
    public void execute() {
        
        String dishName = createView.dishNameTxt.getText();
        String dishDescription = createView.dishDescriptionTxt.getText();
        Double dishSellingPrice = Double.valueOf(createView.dishPriceTxt.getText());
        String categorySelected = createView.dishCategoryCombo.getSelectedItem().toString();
        Category category = categoryService.getByName(categorySelected);
        int categoryId = category.getCategoryId();
        
        if ( dishService.getDishByName(dishName) != null ) {
            modal.show("El platillo ya existe", ModalTypeEnum.error);
            return;
        }
        
        Dish dish = new Dish( dishName, dishDescription, image, dishSellingPrice, categoryId );
        
        if ( !dishService.saveProduct(dish) ) {
            modal.show("El platillo no pudo ser creado", ModalTypeEnum.error);
            return; 
        }
        
        modal.show("El platillo ha sido creado exitosamente", ModalTypeEnum.success);
    } 
    
    public void setDishImage(String dishImage) {
        image = dishImage;
    }
}
