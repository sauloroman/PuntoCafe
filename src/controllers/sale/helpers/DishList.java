package controllers.sale.helpers;

import entities.Dish;
import entities.DishItem;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class DishList {
    
    private final List<DishItem> dishes = new ArrayList<>();
    private Consumer<Integer> onDelete;
    
    public DishList() {}
    
    public void addDish(Dish dish, int quantity, double discount ) {
        DishItem existingDish = findDishItemById(dish.getDishID());
        
        if ( existingDish != null ) {
            updateDishItem(existingDish, quantity, discount);
        } else {
            dishes.add(new DishItem(dish, quantity, discount));
        }
    }
    
    public void removeDish( int dishId ) {
        dishes.removeIf( item -> item.getItem().getDishID() == dishId );
    }
    
    public void clearList() {
        dishes.clear();
    }
    
    private DishItem findDishItemById( int dishId ) {
        for( DishItem dish: dishes ) {
            if ( dish.getItem().getDishID() == dishId ) {
                return dish;
            }
        }
        return null;
    }
    
    private void updateDishItem(DishItem dish, int quantity, double discount) {
        dish.setQuantity(quantity);
        dish.setDiscount(discount);
    }
    
    public void setOnDelete(Consumer<Integer> listener) {
        this.onDelete = listener;
    }
    
    public List<DishItem> getDishes() {
        return this.dishes;
    }
    
}
