package controllers.product.helpers;

import entities.Category;
import entities.Product;
import entities.Supplier;
import services.CategoryService;
import services.SupplierService;
import views.components.ImageCustom;
import views.warehouse.WarehouseInfoProduct;

public class LoadInformationProduct {
    
    private final ImageCustom image = new ImageCustom();
    private final WarehouseInfoProduct view;
    private final CategoryService categoryService;
    private final SupplierService supplierService;
    
    public LoadInformationProduct(
            WarehouseInfoProduct view,
            CategoryService categoryService,
            SupplierService supplierService
    ) {
        this.view = view;
        this.categoryService = categoryService;
        this.supplierService = supplierService;
    }
    
    public void load( Product product ) { 
        Category category = categoryService.getById(product.getCategoryId());
        String categoryName = category.getCategoryName();
        
        Supplier supplier = supplierService.getByID(product.getSupplierId());
        String supplierName = supplier.getSupplierName() + " " + supplier.getSupplierLastname();
        String supplierCompany = supplier.getSupplierCompany();
        
        view.productId.setText("" + product.getProductId());
        view.productName.setText(product.getProductName());
        view.productDescription.setText(product.getProductDescription());
        view.productCategory.setText(categoryName);
        view.productStock.setText("Productos en Stock: " + product.getProductStock());
        view.productMinStock.setText("Productos Min: " + product.getProductStockMin());
        view.productPrice.setText("$" + product.getProductSellingPrice().toString() + "0");
        view.productCreatedAt.setText("Fecha de creación: " + product.getProductCreatedAt());
        view.productUpdatedAt.setText("Última actualización: " + product.getProductUpdatedAt());
        view.productSupplierName.setText(supplierName);
        view.productSupplierCompany.setText(supplierCompany);
        view.productStatus.setText(product.getProductIsActive() ? "Producto Activo" : "Producto Inactivo");
        
        image.addImageProduct(view.productImage,  "Producto sin imagen".equals(product.getProductImage()) ? "no-image.jpg" : product.getProductImage(), 300, 300);
        
    }
    
}
