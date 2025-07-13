package controllers.product.helpers;

import entities.Category;
import entities.Supplier;
import java.util.List;
import views.warehouse.WarehouseCreateProduct;
import views.warehouse.WarehouseEditProduct;
import views.warehouse.WarehouseProducts;

public final class FillComboBoxes {
    
    private final WarehouseCreateProduct createProductView;
    private final WarehouseEditProduct editProductView; 
    private final WarehouseProducts view;
    
    public FillComboBoxes( 
            WarehouseCreateProduct createProductView, 
            WarehouseEditProduct editProductView,
            WarehouseProducts view
    ) {
        this.createProductView = createProductView;
        this.editProductView = editProductView;
        this.view = view;
    }
    
    public void categoriesCreateBox( List<Category> categories ) {
        createProductView.productCategoryCombo.removeAllItems();
        createProductView.productCategoryCombo.addItem("Categorías");
        for ( Category category : categories ) {
            createProductView.productCategoryCombo.addItem(category.getCategoryName());
        }
        createProductView.productCategoryCombo.setSelectedIndex(0);
    }
    
    public void suppliersCreateBox( List<Supplier> suppliers ) {
        createProductView.productSupplierCombo.removeAllItems();
        createProductView.productSupplierCombo.addItem("Proveedores");
        for ( Supplier supplier : suppliers ) {
            createProductView.productSupplierCombo.addItem(supplier.getSupplierName() + "-" + supplier.getSupplierCompany());
        }
        createProductView.productSupplierCombo.setSelectedIndex(0);
    }
    
    public void categoriesEditBox(List<Category> categories) {
        editProductView.productEditCategoryCombo.removeAllItems();
        editProductView.productEditCategoryCombo.addItem("Categorías");
        for ( Category category : categories ) {
            editProductView.productEditCategoryCombo.addItem(category.getCategoryName());
        }
        editProductView.productEditCategoryCombo.setSelectedIndex(0);
    }
    
    public void suppliersEditBox( List<Supplier> suppliers ) {
        editProductView.productEditSupplierCombo.removeAllItems();
        editProductView.productEditSupplierCombo.addItem("Proveedores");
        for ( Supplier supplier : suppliers ) {
            editProductView.productEditSupplierCombo.addItem(supplier.getSupplierName() + "-" + supplier.getSupplierCompany());
        }
        editProductView.productEditSupplierCombo.setSelectedIndex(0);
    }
    
    public void categoriesFilterBox(List<Category> categories) {
        view.productCategoryCombo.removeAllItems();
        view.productCategoryCombo.addItem("Categorías");
        for ( Category category : categories  ) {
            view.productCategoryCombo.addItem(category.getCategoryName());
        }
        view.productCategoryCombo.setSelectedIndex(0);
    }
    
     public void suppliersFilterBox(List<String> companySuppliers) {
        view.productSupplierCombo.removeAllItems();
        view.productSupplierCombo.addItem("Proveedores");
        for ( String company : companySuppliers  ) {
            view.productSupplierCombo.addItem(company);
        }
        view.productSupplierCombo.setSelectedIndex(0);
    }
    
}
