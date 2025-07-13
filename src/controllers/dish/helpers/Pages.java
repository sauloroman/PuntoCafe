package controllers.dish.helpers;

import services.DishService;
import views.warehouse.WarehouseDishes;

public class Pages {
    
    private final WarehouseDishes view;
    private final DishService dishService; 

    public Pages(WarehouseDishes view, DishService dishService) {
        this.view = view;
        this.dishService = dishService;
    }
    
    public void create() {
        int quantityDishes = dishService.getQuantityDishes();
        int pages = calculatePages(quantityDishes);
        fillPageComboBox(pages);
    }
    
    private int calculatePages( int quantityDishes ) {
        return Math.max((int) Math.ceil((double) quantityDishes / 15), 1);
    }
    
    private void fillPageComboBox( int pages ) {
        view.pageComboBox.removeAllItems();
        for ( int i = 1; i <= pages; i++ ) {
            view.pageComboBox.addItem(String.valueOf(i));
        }
        
        if ( pages == 0 ) {
            view.pageComboBox.addItem("1");
        }
        
        view.pageComboBox.setSelectedIndex(0);
    }
    
}
