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
    
    public void createByCategories( int categoryId ) {
        int quantityDishes = dishService.getQuantityDishesByCategory(categoryId);
        int pages = calculatePages(quantityDishes);
        fillPageComboBox(pages);
    }
    
    public void createByStatus(String status) {
        int quantityDishes = dishService.getQuantityDishesByStatus(status);
        int pages = calculatePages(quantityDishes);
        fillPageComboBox(pages);
    }
    
    public void createByName(String name) {
        int quantityDishes = dishService.getQuantityDishesByName(name);
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
    
    public int getSelectedPage() {
        Object selectedItem = view.pageComboBox.getSelectedItem();
        if ( selectedItem == null ) return 1;
        return Integer.parseInt(selectedItem.toString());
    }
    
}
