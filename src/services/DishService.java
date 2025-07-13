package services;

import entities.Dish;
import java.util.List;
import models.DishModel;
import utils.enums.SearchCriteriaEnum;

public class DishService {
    
    private final DishModel model;

    public DishService(DishModel model) {
        this.model = model;
    }
    
    public Dish getDishByName(String name) {
        return model.getItemByName(name);
    }
    
    public List<Dish> getAllDishes(int page, int quantity) {
        return model.listItemsByPage("", SearchCriteriaEnum.NONE, page, quantity);
    }
    
    public int getQuantityDishes() {
        return model.getTotalItems();
    }
    
    public boolean saveDish(Dish dish) {
        return model.saveItem(dish);
    }
    
    public boolean editDish(Dish dish, int dishId ) {
        return model.updateItem(dish, dishId);
    }
    
}
