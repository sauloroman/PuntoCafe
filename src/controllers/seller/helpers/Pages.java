package controllers.seller.helpers;

import services.DishService;
import services.ProductService;
import views.sales.CreateSale;

public class Pages {
    
    private final CreateSale view;
    private final ProductService productService;
    private final DishService dishService;

    public Pages(CreateSale view, ProductService productService, DishService dishService) {
        this.view = view;
        this.productService = productService;
        this.dishService = dishService;
    }
    
    public void create() {
        int quantityProducts = productService.getQuantityProducts();
        int quantityDishes = dishService.getQuantityDishes();
        
        int pagesProducts = calculatePages(quantityProducts);
        int pagesDishes = calculatePages(quantityDishes);
        
        fillPageComboBoxProducts(pagesProducts);
        fillPageComboBoxDishes(pagesDishes);
    }
    
    public void createByProductName(String name) {
        int quantityProducts = productService.getQuantityProductsByName(name);
        int pages = calculatePages(quantityProducts);
        fillPageComboBoxProducts(pages);
    }
    
    public void createByDishName(String name) {
        int quantityProducts = dishService.getQuantityDishesByName(name);
        int pages = calculatePages(quantityProducts);
        fillPageComboBoxDishes(pages);
    }
    
    private int calculatePages( int quantity ) {
        return Math.max((int) Math.ceil((double) quantity / 20), 1);
    }
    
    public int getSelectedPageProducts() {
        Object selectedItem = view.pageCombo.getSelectedItem();
        if ( selectedItem == null ) return 1;
        return Integer.parseInt(selectedItem.toString());
    }
    
    public int getSelectedPageDishes() {
        Object selectedItem = view.pageComboDish.getSelectedItem();
        if ( selectedItem == null ) return 1;
        return Integer.parseInt(selectedItem.toString());
    }
    
    private void fillPageComboBoxProducts( int pages ) {
        view.pageCombo.removeAllItems();
        
        for ( int i = 1; i <= pages; i++ ) {
            view.pageCombo.addItem(String.valueOf(i));
        }
        
        if ( pages == 0 ) {
            view.pageCombo.addItem("1");
        }
        
        view.pageCombo.setSelectedIndex(0);
    }
    
    private void fillPageComboBoxDishes( int pages ) {
        view.pageComboDish.removeAllItems();
        
        for ( int i = 1; i <= pages; i++ ) {
            view.pageComboDish.addItem(String.valueOf(i));
        }
        
        if ( pages == 0 ) {
            view.pageComboDish.addItem("1");
        }
        
        view.pageComboDish.setSelectedIndex(0);
    }
    
}
