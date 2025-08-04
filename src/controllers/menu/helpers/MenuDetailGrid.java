package controllers.menu.helpers;

import entities.Dish;
import java.util.List;
import views.components.Card;
import views.warehouse.WarehouseMenuDetail;

public class MenuDetailGrid {
    
    private final WarehouseMenuDetail view;
    private final Card card;

    public MenuDetailGrid(WarehouseMenuDetail view, Card card) {
        this.view = view;
        this.card = card;
    }
    
    public void showMenuDishes(List<Dish> dishes) {
        clearGrid();
        for( Dish dish: dishes ) {
            addMenuToGrid(dish);
        }
    }
    
    private void addMenuToGrid( Dish dish ) {
        view.menuDetailGrid.add(card.createMinimalDishMenuCard(dish));
    }
    
    private void clearGrid() {
        view.menuDetailGrid.removeAll();
        view.menuDetailGrid.revalidate();
        view.menuDetailGrid.repaint();
    }
    
}
