package controllers.product.helpers;

import services.ProductService;
import views.warehouse.WarehouseProducts;

public class Pages {
    
    private final WarehouseProducts view;
    private final ProductService queryProducts;

    public Pages(WarehouseProducts view, ProductService queryProducts) {
        this.view = view;
        this.queryProducts = queryProducts;
    }
    
    public void create() {
        int quantityProducts = queryProducts.getQuantityProducts();
        int pages = Math.max((int) Math.ceil((double) quantityProducts / 15), 1);
        
        view.pageComboBox.removeAllItems();
        for ( int i = 1; i <= pages; i++ ) {
            view.pageComboBox.addItem(String.valueOf(i));
        }
        view.pageComboBox.setSelectedIndex(0);
    }
    
    public int getSelectedPage() {
        return Integer.parseInt(view.pageComboBox.getSelectedItem().toString());
    }
    
}
