package controllers.seller.helpers;

import entities.Dish;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import javax.swing.JPanel;
import services.DishService;
import views.components.Card;
import views.components.Grid;
import views.sales.CreateSale;

public class DishGrid {
    
    private final int QUANTITY_PRODUCTS = 20;
    private final CreateSale view;
    private final DishService dishService;
    private List<Dish> dishes = new ArrayList<>();
    private Consumer<Dish> onDishClick;

    public DishGrid(CreateSale view, DishService dishService) {
        this.view = view;
        this.dishService = dishService;
    
        Grid.create(view.dishesGrid, 5, QUANTITY_PRODUCTS);
    }
    
    public void setOnDishClick(Consumer<Dish> listener) {
        this.onDishClick = listener;
    }
    
    private void clearGrid() {
        view.dishesGrid.removeAll();
        view.dishesGrid.revalidate();
        view.dishesGrid.repaint();
    }
    
    public void showAllDishes( int page ) {
        clearGrid();
        dishes = dishService.getDishesByStatus("Activo", page, QUANTITY_PRODUCTS);
        for ( Dish dish: dishes ) {
            addDish(dish);
        }
    }
    
    public void showDishesByName(String name, int page ) {
        clearGrid();
        dishes = dishService.getDishesByName(name, page, QUANTITY_PRODUCTS);
        for ( Dish dish: dishes ) {
            addDish(dish);
        }
    }
    
    public void addDish(Dish dish) {
        Card cardFactory = new Card();
        JPanel card =  cardFactory.createModernDishCard(dish, onDishClick);
        JPanel wrapper = cardFactory.cartWrapper(card);
        view.dishesGrid.add(wrapper);
    }
    
    
}
