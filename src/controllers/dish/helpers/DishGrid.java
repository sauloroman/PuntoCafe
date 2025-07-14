package controllers.dish.helpers;

import entities.Category;
import entities.Dish;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import javax.swing.JScrollPane;
import services.CategoryService;
import services.DishService;
import views.components.Card;
import views.components.Grid;
import views.warehouse.WarehouseDishes;

public class DishGrid {
    
    private final int QUANTITY_DISHES = 15;
    private final WarehouseDishes view;
    private final DishService dishService;
    private final CategoryService categoryService;
    
    private final JScrollPane scroll;
    private Consumer<Dish> onDishClick;
    private List<Dish> dishes = new ArrayList<>();

    public DishGrid(WarehouseDishes view, DishService dishService, CategoryService categoryService) {
        this.view = view;
        this.dishService = dishService;
        this.categoryService = categoryService;
 
        Grid.create(view.dishesGrid, 5, 20);
        this.scroll = new JScrollPane(view.dishesGrid);
        view.add(this.scroll);
    }
    
    public void setOnDishClick( Consumer<Dish> listener ) {
        this.onDishClick = listener;
    }
    
    public void showAllDishes( int page ) {
        clearGrid();
        dishes = dishService.getAllDishes(page, QUANTITY_DISHES);
        for ( Dish dish: dishes) {
            addDish(dish);
        }
    }
    
    public void showDishesByCategory(int categoryId, int page) {
        clearGrid();
        dishes = dishService.getDishesByCategory(categoryId, page, QUANTITY_DISHES);
        for ( Dish dish: dishes) {
            addDish(dish);
        }
    }
    
    public void showDishesByStatus(String status, int page) {
        clearGrid();
        dishes = dishService.getDishesByStatus(status, page, QUANTITY_DISHES);
        for ( Dish dish: dishes) {
            addDish(dish);
        }
    }
    
    public void showDishesByName(String dishName, int page) {
        clearGrid();
        dishes = dishService.getDishesByName(dishName, page, QUANTITY_DISHES);
        for ( Dish dish: dishes) {
            addDish(dish);
        }
    }
    
    private void addDish( Dish dish ) {
        Card card = new Card();
        Category categoryDish = categoryService.getById(dish.getCategoryId());
        String categoryName = categoryDish.getCategoryName();
        view.dishesGrid.add(card.createDish(categoryName, dish, onDishClick));
    }
    
    private void clearGrid() {
        view.dishesGrid.removeAll();
        view.dishesGrid.revalidate();
        view.dishesGrid.repaint();
    }
}
