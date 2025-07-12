package controllers.product.helpers;

import entities.Category;
import entities.Supplier;
import services.CategoryService;
import services.SupplierService;
import utils.enums.ModalTypeEnum;
import utils.helpers.Formatter;
import utils.helpers.Modal;
import views.warehouse.WarehouseCreateProduct;
import views.warehouse.WarehouseEditProduct;

public class ProductValidator {
    
    private final WarehouseCreateProduct view;
    private final WarehouseEditProduct editView;
    private final CategoryService categoryService;
    private final SupplierService supplierService;
    private final Modal modal;
    
    public ProductValidator(
            WarehouseCreateProduct view, 
            WarehouseEditProduct editView,
            CategoryService categoryService,
            SupplierService supplierService,
            Modal modal
    ) {
        this.view = view;
        this.editView = editView;
        this.categoryService = categoryService;
        this.supplierService = supplierService;
        this.modal = modal;
    }
    
    public boolean isValidCreation() {
        String productName = view.productNameTxt.getText().trim();
        Double productPrice = Double.valueOf(view.productPriceTxt.getText());
        int stock = Integer.parseInt(view.productStockTxt.getText());
        int stockMin = Integer.parseInt(view.productStockMinTxt.getText());
        String productDescription = view.productDescriptionTxt.getText();
        
        String categorySelected = view.productCategoryCombo.getSelectedItem().toString();
        Category category = categoryService.getByName(categorySelected);
        int categoryId = category.getCategoryId();
        
        String supplierSelected = view.productSupplierCombo.getSelectedItem().toString();
        String supplierName = Formatter.extractName(supplierSelected);
        Supplier supplier = supplierService.getByName(supplierName);
        int supplierId = supplier.getSupplierId();
        
        if ( !isValidName(productName) ) {
            modal.show("El nombre del producto es obligatorio y debe ser menor a 100 caracteres", ModalTypeEnum.error );
            return false;
        }
        
        if ( !isValidCategoryId(categoryId) ) {
            modal.show("La categoría es obligatoria", ModalTypeEnum.error );
            return false;
        }
        
        if ( !isValidSupplierId(supplierId) ) {
            modal.show("El proveedor es obligatorio", ModalTypeEnum.error );
            return false;
        }
        
        if ( !isValidSellingPrice(productPrice) ) {
            modal.show("El precio es obligatorio y debe ser positivo", ModalTypeEnum.error );
            return false;
        }
        
        if ( !isValidStock(stock) ) {
            modal.show("El stock es obligatorio y debe ser positivo", ModalTypeEnum.error );
            return false;
        }
        
        if ( !isValidStockMinimum(stock, stockMin) ) {
            modal.show("El stock mínimo es obligatorio. Debe ser positivo y mayor que el stock original", ModalTypeEnum.error );
            return false;
        }
        
        if (!isValidDescription(productDescription)) {
            modal.show("La descripción debe ser menor a 220 caracteres", ModalTypeEnum.error );
            return false;
        }
        
        return true;
    }
    
    public boolean isValidEdition() {
        
        String productName = editView.productEditNameTxt.getText().trim();
        Double productPrice = Double.valueOf(editView.productEditPriceTxt.getText());
        int stock = Integer.parseInt(editView.productEditStockTxt.getText());
        int stockMin = Integer.parseInt(editView.productEditStockMinTxt.getText());
        String productDescription = editView.productEditDescriptionTxt.getText();
        
        String categorySelected = editView.productEditCategoryCombo.getSelectedItem().toString();
        Category category = categoryService.getByName(categorySelected);
        int categoryId = category.getCategoryId();
        
        String supplierSelected = editView.productEditSupplierCombo.getSelectedItem().toString();
        String supplierName = Formatter.extractName(supplierSelected);
        Supplier supplier = supplierService.getByName(supplierName);
        int supplierId = supplier.getSupplierId();
        
        if ( !isValidName(productName) ) {
            modal.show("El nombre del producto es obligatorio y debe ser menor a 100 caracteres", ModalTypeEnum.error );
            return false;
        }
        
        if ( !isValidCategoryId(categoryId) ) {
            modal.show("La categoría es obligatoria", ModalTypeEnum.error );
            return false;
        }
        
        if ( !isValidSupplierId(supplierId) ) {
            modal.show("El proveedor es obligatorio", ModalTypeEnum.error );
            return false;
        }
        
        if ( !isValidSellingPrice(productPrice) ) {
            modal.show("El precio es obligatorio y debe ser positivo", ModalTypeEnum.error );
            return false;
        }
        
        if ( !isValidStock(stock) ) {
            modal.show("El stock es obligatorio y debe ser positivo", ModalTypeEnum.error );
            return false;
        }
        
        if ( !isValidStockMinimum(stock, stockMin) ) {
            modal.show("El stock mínimo es obligatorio. Debe ser positivo y mayor que el stock original", ModalTypeEnum.error );
            return false;
        }
        
        if (!isValidDescription(productDescription)) {
            modal.show("La descripción debe ser menor a 220 caracteres", ModalTypeEnum.error );
            return false;
        }
        
        return true;
    }
    
    private boolean isValidName(String name) {
        if ( name == null ) return false;
        name = name.trim();
        return !name.isEmpty() && name.length() <= 100;
    }
    
    private boolean isValidDescription(String description) {
        if ( description == null ) return false;
        description = description.trim();
        return description.length() <= 220;
    }
 
    private boolean isValidSellingPrice( double price ) {
        return price > 0 && price < 1e9;
    }
    
    private boolean isValidStock( int stock ) {
        return stock > 0; 
    }
    
    private boolean isValidStockMinimum( int stock, int stockMin ) {
        return stockMin > 0 && stock > stockMin; 
    }
    
    private boolean isValidCategoryId( int categoryId ) {
        return categoryId > 0;
    }
    
    private boolean isValidSupplierId( int supplierId ) {
        return supplierId > 0;
    }
    
}
