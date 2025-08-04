package controllers.menu.helpers;

import entities.Dish;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import views.components.Card;
import views.warehouse.WarehouseMenuEdit;

public class DishesListEdit {
    
    private final WarehouseMenuEdit editMenuView;
    private Consumer<Dish> onDelete;
    private List<Dish> dishes = new ArrayList<>();
    private final Card cardFactory = new Card();
    
    public DishesListEdit(WarehouseMenuEdit editMenuView){
        this.editMenuView = editMenuView;
    }
    
    public void setOnDelete( Consumer<Dish> listener ) {
        this.onDelete = listener;
    }
    
    public List<Dish> getDishList() {
        return this.dishes;
    }
    
    public void setDishesList(List<Dish> dishesInMenu) {
        this.dishes = dishesInMenu;
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
    
    public void render() {
        editMenuView.dishesInMenu.removeAll();
        for( Dish dish: dishes ) {
            editMenuView.dishesInMenu.add(cardFactory.createMinimalDishCard(dish, onDelete));
        }
        editMenuView.dishesInMenu.revalidate();
        editMenuView.dishesInMenu.repaint();
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
