package controllers.menu.helpers;

import entities.Dish;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import views.components.Card;
import views.warehouse.WarehouseMenuCreate;

public class DishesList {
    
    private final WarehouseMenuCreate createMenuView;
    private Consumer<Dish> onDelete;
    private final List<Dish> dishes = new ArrayList<>();
    private final Card cardFactory = new Card();
    
    public DishesList(WarehouseMenuCreate createMenuView){
        this.createMenuView = createMenuView;
    }
    
    public void setOnDelete( Consumer<Dish> listener ) {
        this.onDelete = listener;
    }
    
    public List<Dish> getDishList() {
        return this.dishes;
    }
    
    public void addDish( Dish dish ) {
        Dish existingDish = findDishById(dish.getDishID());
        if ( existingDish != null ) return;
        dishes.add( dish );
        render();
    }
    
    public void removeDish( int dishId ) {
        dishes.removeIf( dish -> dish.getDishID() == dishId );
        render();
    }
    
    public void clearList() {
        dishes.clear();
        render();
    }
    
    private void render() {
        createMenuView.dishesInMenu.removeAll();
        for( Dish dish: dishes ) {
            createMenuView.dishesInMenu.add(cardFactory.createMinimalDishCard(dish, onDelete));
        }
        createMenuView.dishesInMenu.revalidate();
        createMenuView.dishesInMenu.repaint();
    }
    
    private Dish findDishById( int dishId ) {
        for( Dish dish: dishes ) {
            if ( dish.getDishID() == dishId ) {
                return dish;
            }
        }
        return null;
    }
    
}
