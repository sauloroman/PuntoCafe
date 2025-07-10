package controllers.product.helpers;

import entities.Category;
import entities.Product;
import entities.Supplier;
import services.CategoryService;
import services.SupplierService;
import views.components.ImageCustom;
import views.warehouse.WarehouseEditProduct;

public class LoadEditInformation {

    private final WarehouseEditProduct view;
    private final ImageCustom image = new ImageCustom();
    private final CategoryService categoryService;
    private final SupplierService supplierService;

    public LoadEditInformation(WarehouseEditProduct viewEdit, CategoryService categoryService, SupplierService supplierService ) {
        this.view = viewEdit;
        this.categoryService = categoryService;
        this.supplierService = supplierService;
    }
    
    public void load( Product product ) {
        view.productEditDescriptionTxt.setText(product.getProductDescription());
        view.productEditPriceTxt.setText(product.getProductSellingPrice().toString());
        view.productEditNameTxt.setText( product.getProductName() );
        view.productEditStockTxt.setText(product.getProductStock() + "");
        view.productEditStockMinTxt.setText(product.getProductStockMin() + "");
        image.addImageProduct(view.productEditImageLabel, "Producto sin imagen".equals(product.getProductImage()) ? "no-image.jpg" : product.getProductImage(), 200, 200);
        
        Category category = categoryService.getById(product.getCategoryId());
        String categoryName = category.getCategoryName();
        
        Supplier supplier = supplierService.getByID(product.getSupplierId());
        String supplierName = supplier.getSupplierName();
        String supplierCompany = supplier.getSupplierCompany();
        
        view.productEditCategoryCombo.setSelectedItem(categoryName);
        view.productEditSupplierCombo.setSelectedItem(supplierName + "-" + supplierCompany);
    }
    
}
