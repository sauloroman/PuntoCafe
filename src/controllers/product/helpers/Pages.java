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
        int pages = calculatePages(quantityProducts);
        fillPageComboBox(pages);
    }
    
    public void createByCategories (int categoryId ) {
        int quantityProducts = queryProducts.getQuantityProductsByCategory(categoryId);
        int pages = calculatePages(quantityProducts);
        fillPageComboBox(pages);
    }
    
    public void createBySuppliers( String supplierCompany ) {
        int quantityProducts = queryProducts.getQuantityProductsBySupplierCompany(supplierCompany);
        int pages = calculatePages(quantityProducts);
        fillPageComboBox(pages);
    }
    
    public void createByStatus( String status ) {
        int quantityProducts = queryProducts.getQuantityProductsByStatus(status);
        int pages = calculatePages(quantityProducts);
        fillPageComboBox(pages);
    }
    
    public void createByName(String name) {
        int quantityProducts = queryProducts.getQuantityProductsByName(name);
        int pages = calculatePages(quantityProducts);
        fillPageComboBox(pages);
    }

    public int getSelectedPage() {
        Object selectedItem = view.pageComboBox.getSelectedItem();
        if ( selectedItem == null ) return 1;
        return Integer.parseInt(selectedItem.toString());
    }
    
    private int calculatePages( int quantityProducts ) {
        return Math.max((int) Math.ceil((double) quantityProducts / 15), 1);
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
