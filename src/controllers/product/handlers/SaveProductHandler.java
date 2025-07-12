package controllers.product.handlers;

import services.CategoryService;
import controllers.interfaces.HandlerController;
import services.ProductService;
import services.SupplierService;
import entities.Category;
import entities.Product;
import entities.Supplier;
import utils.enums.ModalTypeEnum;
import utils.helpers.Formatter;
import utils.helpers.Modal;
import views.warehouse.WarehouseCreateProduct;

public class SaveProductHandler implements HandlerController {

    private final WarehouseCreateProduct view;
    private final Modal modal;
    private final CategoryService categorieService;
    private final SupplierService suppliersService;
    private final ProductService productsService;
    private String image = null;
    
    public SaveProductHandler(
            WarehouseCreateProduct view, 
            CategoryService queryCategories,
            SupplierService querySuppliers,
            ProductService queryProducts,
            Modal modal
    ) {
        this.view = view;
        this.modal = modal;
        this.categorieService = queryCategories;
        this.suppliersService = querySuppliers;
        this.productsService = queryProducts;
    }
    
    @Override
    public void execute() {
        
        String productName = view.productNameTxt.getText().trim();
        Double productPrice = Double.valueOf(view.productPriceTxt.getText());
        int stock = Integer.parseInt(view.productStockTxt.getText());
        int stockMin = Integer.parseInt(view.productStockMinTxt.getText());
        String productDescription = view.productDescriptionTxt.getText();
        
        String categorySelected = view.productCategoryCombo.getSelectedItem().toString();
        Category category = categorieService.getByName(categorySelected);
        int categoryId = category.getCategoryId();
        
        String supplierSelected = view.productSupplierCombo.getSelectedItem().toString();
        String supplierName = Formatter.extractName(supplierSelected);
        Supplier supplier = suppliersService.getByName(supplierName);
        int supplierId = supplier.getSupplierId();
        
        if ( productsService.getProductByName(productName) != null ) {
            modal.show("El producto ya existe", ModalTypeEnum.error);
            return;
        }
        
        Product product = new Product(
                productName,
                productDescription,
                image,
                productPrice,
                stock,
                stockMin,
                categoryId,
                supplierId
        );
        
        if ( !productsService.saveProduct(product) ) {
            modal.show("El producto no pudo ser creado", ModalTypeEnum.error);
            return;
        }
        
        modal.show("El producto ha sido creado exitosamente", ModalTypeEnum.success);        
        view.setVisible(false);       
    }
    
    public void setProductImage(String productImage) {
        image = productImage;
    }
    
}
