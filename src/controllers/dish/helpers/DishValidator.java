package controllers.dish.helpers;

import entities.Category;
import services.CategoryService;
import utils.enums.ModalTypeEnum;
import utils.helpers.Modal;
import views.warehouse.WarehouseCreateDish;

public class DishValidator {
    
    private final WarehouseCreateDish createView;
    private final CategoryService categoryService;
    private final Modal modal;
    
    public DishValidator(
            WarehouseCreateDish createView, 
            CategoryService categoryService,
            Modal modal
    ) {
        this.createView = createView;
        this.categoryService = categoryService;
        this.modal = modal;
    }
    
    public boolean isValidCreation() {
        String dishName = createView.dishNameTxt.getText();
        String dishDescription = createView.dishDescriptionTxt.getText();
        Double dishSellingPrice = Double.valueOf(createView.dishPriceTxt.getText());
        
        String categorySelected = createView.dishCategoryCombo.getSelectedItem().toString();
        Category category = categoryService.getByName(categorySelected);
        int categoryId = category.getCategoryId();
        
        if ( !isValidName(dishName) ) {
            modal.show("El nombre del producto es obligatorio y debe ser menor a 100 caracteres", ModalTypeEnum.error );
            return false;
        }
        
        if ( !isValidCategoryId(categoryId) ) {
            modal.show("La categoría es obligatoria", ModalTypeEnum.error );
            return false;
        }
        
        if ( !isValidSellingPrice(dishSellingPrice) ) {
            modal.show("El precio es obligatorio y debe ser positivo", ModalTypeEnum.error );
            return false;
        }
        
        if (!isValidDescription(dishDescription)) {
            modal.show("La descripción debe ser menor a 220 caracteres", ModalTypeEnum.error );
            return false;
        }
        
        return true;
    }

    /*
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
*/
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
    
    private boolean isValidCategoryId( int categoryId ) {
        return categoryId > 0;
    }
    
}
