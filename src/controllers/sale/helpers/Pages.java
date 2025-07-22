package controllers.sale.helpers;

import services.ProductService;
import views.sales.CreateSale;

public class Pages {
    
    private final CreateSale view;
    private final ProductService productService;

    public Pages(CreateSale view, ProductService productService) {
        this.view = view;
        this.productService = productService;
    }
    
    public void create() {
        int quantityProducts = productService.getQuantityProducts();
        int pages = calculatePages(quantityProducts);
        fillPageComboBox(pages);
    }
    
    public void createByName(String name) {
        int quantityProducts = productService.getQuantityProductsByName(name);
        int pages = calculatePages(quantityProducts);
        fillPageComboBox(pages);
    }
    
    private int calculatePages( int quantityProducts ) {
        return Math.max((int) Math.ceil((double) quantityProducts / 15), 1);
    }
    
    private void fillPageComboBox( int pages ) {
        view.pageCombo.removeAllItems();
        for ( int i = 1; i <= pages; i++ ) {
            view.pageCombo.addItem(String.valueOf(i));
        }
        
        if ( pages == 0 ) {
            view.pageCombo.addItem("1");
        }
        
        view.pageCombo.setSelectedIndex(0);
    }
    
}
