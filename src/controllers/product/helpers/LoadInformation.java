package controllers.product.helpers;

import entities.Category;
import entities.Product;
import entities.Supplier;
import services.CategoryService;
import services.SupplierService;
import views.components.ImageCustom;
import views.warehouse.WarehouseEditProduct;
import views.warehouse.WarehouseInfoProduct;

public class LoadInformation {
    
    private final ImageCustom image = new ImageCustom();
    private final WarehouseInfoProduct infoView;
    private final WarehouseEditProduct editView;
    private final CategoryService categoryService;
    private final SupplierService supplierService;
    
    public LoadInformation(
            WarehouseInfoProduct infoView,
            WarehouseEditProduct editView,
            CategoryService categoryService,
            SupplierService supplierService
    ) {
        this.infoView = infoView;
        this.editView = editView;
        this.categoryService = categoryService;
        this.supplierService = supplierService;
    }
    
    public void loadProductInfo( Product product ) {
        int supplierId = product.getSupplierId();
        String supplierName = getSupplierName(supplierId) + " " + getSupplierLastName(supplierId);
        String supplierCompany = getSupplierCompany(supplierId);
        
        infoView.productId.setText("" + product.getProductId());
        infoView.productName.setText(product.getProductName());
        infoView.productDescription.setText(product.getProductDescription());
        infoView.productCategory.setText(getCategoryName(product.getCategoryId()));
        infoView.productStock.setText("Stock: " + product.getProductStock());
        infoView.productMinStock.setText("Stock Min: " + product.getProductStockMin());
        infoView.productPrice.setText("$" + product.getProductSellingPrice().toString() + "0");
        infoView.productCreatedAt.setText("Fecha de creación: " + product.getProductCreatedAt());
        infoView.productUpdatedAt.setText("Última actualización: " + product.getProductUpdatedAt());
        infoView.productSupplierName.setText(supplierName + " - " + supplierCompany );
        infoView.productStatus.setText(product.getProductIsActive() ? "Producto Activo" : "Producto Inactivo");
        image.addImageProduct(infoView.productImage,  "Producto sin imagen".equals(product.getProductImage()) ? "no-image.jpg" : product.getProductImage(), 320, 320);
        
    }
    
    public void loadProductEdit( Product product ) {
        String supplierName = getSupplierName(product.getSupplierId());
        String supplierCompany = getSupplierCompany(product.getSupplierId());
        
        editView.productEditDescriptionTxt.setText(product.getProductDescription());
        editView.productEditPriceTxt.setText(product.getProductSellingPrice().toString());
        editView.productEditNameTxt.setText( product.getProductName() );
        editView.productEditStockTxt.setText(product.getProductStock() + "");
        editView.productEditStockMinTxt.setText(product.getProductStockMin() + "");
        editView.productEditCategoryCombo.setSelectedItem(getCategoryName(product.getCategoryId()));
        editView.productEditSupplierCombo.setSelectedItem(supplierName + "-" + supplierCompany);
        image.addImageProduct(editView.productEditImageLabel, "Producto sin imagen".equals(product.getProductImage()) ? "no-image.jpg" : product.getProductImage(), 200, 200);
    }
    
    public String getCategoryName( int categoryId ) {
        Category category = categoryService.getById(categoryId);
        String categoryName = category.getCategoryName();
        return categoryName;
    }
    
    public String getSupplierName( int supplierId ) {
        Supplier supplier = supplierService.getById(supplierId);
        String supplierName = supplier.getSupplierName();
        return supplierName;
    }
    
    public String getSupplierLastName( int supplierId ) {
        Supplier supplier = supplierService.getById(supplierId);
        String supplierLastname = supplier.getSupplierLastname();
        return supplierLastname;
    }
    
    public String getSupplierCompany( int supplierId ) {
        Supplier supplier = supplierService.getById(supplierId);
        String supplierCompany = supplier.getSupplierCompany();
        return supplierCompany;
    }
    
}
