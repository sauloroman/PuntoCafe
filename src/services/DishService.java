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
    
    public Dish getDishById( int id ) {
        return model.getItemById(id);
    }
    
    public List<Dish> getAllDishes(int page, int quantity) {
        return model.listItemsByPage("", SearchCriteriaEnum.NONE, page, quantity);
    }
    
    public List<Dish> getDishesByCategory(int categoryId, int page, int quantity) {
        return model.getDishesByCategoryId(categoryId, page, quantity);
    }
    
    public List<Dish> getDishesByStatus(String status, int page, int quantity) {
        int statusParsed = status.equals("Activo") ? 1 : 0;
        return model.getDishesByStatus(statusParsed, page, quantity);
    }
    
    public List<Dish> getDishesByName(String dishName, int page, int quantity) {
        return model.getDishesByName(dishName, page, quantity);
    }
    
    public int getQuantityDishes() {
        return model.getTotalItems();
    }
    
    public int getQuantityDishesByCategory( int categoryId ) {
        return model.getTotalDishesByCategoryId(categoryId);
    }
    
    public int getQuantityDishesByStatus(String status) {
        return model.getTotalDishesByStatus(status);
    }
    
    public int getQuantityDishesByName(String dishName) {
        return model.getTotalDishesByName(dishName);
    }
    
    public boolean saveDish(Dish dish) {
        return model.saveItem(dish);
    }
    
    public boolean editDish(Dish dish, int dishId ) {
        return model.updateItem(dish, dishId);
    }
    
    public boolean activateDish(int dishId) {
        return model.changeStatus(dishId, true);
    }
    
    public boolean deactivateDish(int dishId) {
        return model.changeStatus(dishId, false);
    }
    
}
