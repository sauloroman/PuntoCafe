package controllers.product.helpers;

import utils.enums.ModalTypeEnum;
import utils.helpers.Modal;

public class ProductValidator {
    
    private final Modal modal;
    
    public ProductValidator(
            Modal modal
    ) {
        this.modal = modal;
    }
    
    public boolean isValidForm(
            String productName,
            String productPrice,
            String stock,
            String stockMin,
            String productDescription,
            String categorySelected,
            String supplierSelected
    ) {
        
        if ( !isValidName(productName) ) {
            modal.show("El nombre del producto es obligatorio y debe ser menor a 100 caracteres", ModalTypeEnum.error );
            return false;
        }
        
        if ( !isValidCategory(categorySelected) ) {
            modal.show("La categoría es obligatoria", ModalTypeEnum.error );
            return false;
        }
        
        if ( !isValidSupplier(supplierSelected) ) {
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
 
    private boolean isValidSellingPrice( String price ) {
        if ( price.isEmpty() ) return false;
        double priceParsed = Double.parseDouble(price);
        return priceParsed > 0 && priceParsed < 1e9;
    }
    
    private boolean isValidStock( String stock ) {
        if ( stock.isEmpty() ) return false;
        int stockParsed = Integer.parseInt(stock);
        return stockParsed > 0; 
    }
    
    private boolean isValidStockMinimum( String stock, String stockMin ) {
        if ( stock.isEmpty() || stockMin.isEmpty() ) return false;  
        int stockParsed = Integer.parseInt(stock);
        int stockMinParsed = Integer.parseInt(stockMin);
        return stockMinParsed > 0 && stockParsed > stockMinParsed; 
    }
    
    private boolean isValidCategory( String category ) {
        return !category.equals("Categorías");
    }
    
    private boolean isValidSupplier( String supplier ) {
        return !supplier.equals("Proveedores");
    }
    
}
