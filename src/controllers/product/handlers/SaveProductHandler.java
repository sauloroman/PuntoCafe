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
import utils.validators.ProductValidator;
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
        
        if ( !isFormValid(
                productName, 
                categoryId, 
                supplierId, 
                productPrice, 
                stock, 
                stockMin, 
                image, 
                productDescription
        )) return;
        
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
    
    private boolean isFormValid(
            String productName,
            int categoryID,
            int supplierID,
            double productPrice,
            int stock,
            int stockMin,
            String image,
            String description
    ) {
        
        if ( !ProductValidator.isValidImage(productName) ) {
            modal.show("El nombre del producto es obligatorio y debe ser menor a 100 caracteres", ModalTypeEnum.error );
            return false;
        }
        
        if ( !ProductValidator.isValidCategoryId(categoryID) ) {
            modal.show("La categoría es obligatoria", ModalTypeEnum.error );
            return false;
        }
        
        if ( !ProductValidator.isValidSupplierId(supplierID) ) {
            modal.show("El proveedor es obligatorio", ModalTypeEnum.error );
            return false;
        }
        
        if ( !ProductValidator.isValidSellingPrice(productPrice) ) {
            modal.show("El precio es obligatorio y debe ser positivo", ModalTypeEnum.error );
            return false;
        }
        
        if ( !ProductValidator.isValidStock(stock) ) {
            modal.show("El stock es obligatorio y debe ser positivo", ModalTypeEnum.error );
            return false;
        }
        
        if ( !ProductValidator.isValidStockMinimum(stock, stockMin) ) {
            modal.show("El stock mínimo es obligatorio. Debe ser positivo y mayor que el stock original", ModalTypeEnum.error );
            return false;
        }
        
        if (!ProductValidator.isValidImage(image)) {
            modal.show("La imagen tiene un nombre muy largo. Cambielo o intente con otra imagen.", ModalTypeEnum.error );
            return false;
        }
        
        if (!ProductValidator.isValidDescription(description)) {
            modal.show("La descripción debe ser menor a 220 caracteres", ModalTypeEnum.error );
            return false;
        }
        
        return true;
    }
    
}
