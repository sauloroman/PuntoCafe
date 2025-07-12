package controllers.product.helpers;

import services.ProductService;
import utils.enums.SearchCriteriaEnum;
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
        fillPageComboBox(pages);
    }
    
    public void createByFilter( SearchCriteriaEnum criteria, int categoryId ) {
        int quantityProducts = 0;
        
        switch( criteria ) {
            case SearchCriteriaEnum.PRODUCT_CATEGORY -> quantityProducts = queryProducts.getQuantityProductsByCategory(categoryId);
        }
        
        int pages = Math.max((int) Math.ceil((double) quantityProducts / 15), 1);
        fillPageComboBox(pages);
    }
    
    public int getSelectedPage() {
        Object selectedItem = view.pageComboBox.getSelectedItem();
        if ( selectedItem == null ) return 1;
        return Integer.parseInt(selectedItem.toString());
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
