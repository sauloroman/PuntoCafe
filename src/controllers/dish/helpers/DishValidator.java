package controllers.dish.helpers;

import utils.enums.ModalTypeEnum;
import utils.helpers.Modal;
import views.warehouse.WarehouseCreateDish;
import views.warehouse.WarehouseEditDish;

public class DishValidator {
    
    private final WarehouseCreateDish createView;
    private final WarehouseEditDish editView;
    private final Modal modal;
    
    public DishValidator(
            WarehouseCreateDish createView, 
            WarehouseEditDish editView,
            Modal modal
    ) {
        this.createView = createView;
        this.editView = editView;
        this.modal = modal;
    }
    
    public boolean isValidCreation() {
        String dishName = createView.dishNameTxt.getText();
        String dishDescription = createView.dishDescriptionTxt.getText();
        String dishSellingPrice = createView.dishPriceTxt.getText();
        String categorySelected = createView.dishCategoryCombo.getSelectedItem().toString();
        
        if ( !isValidName(dishName) ) {
            modal.show("El nombre del producto es obligatorio y debe ser menor a 100 caracteres", ModalTypeEnum.error );
            return false;
        }
        
        if ( !isValidCategory(categorySelected) ) {
            modal.show("La categoría es obligatoria", ModalTypeEnum.error );
            return false;
        }
        
        if ( dishSellingPrice == null || !isValidSellingPrice(dishSellingPrice) ) {
            modal.show("El precio es obligatorio y debe ser positivo", ModalTypeEnum.error );
            return false;
        }
        
        if (!isValidDescription(dishDescription)) {
            modal.show("La descripción debe ser menor a 220 caracteres", ModalTypeEnum.error );
            return false;
        }
        
        return true;
    }
    
    public boolean isValidEdition() {
        String dishName = editView.dishEditNameTxt.getText();
        String dishDescription = editView.dishEditDescriptionTxt.getText();
        String dishSellingPrice = editView.dishEditPriceTxt.getText();
        String categorySelected = editView.dishEditCategoryCombo.getSelectedItem().toString();
        
        if ( !isValidName(dishName) ) {
            modal.show("El nombre del producto es obligatorio y debe ser menor a 100 caracteres", ModalTypeEnum.error );
            return false;
        }
        
        if ( !isValidCategory(categorySelected) ) {
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
    
    private boolean isValidCategory( String categoryName ) {
        return !categoryName.equals("Categorías");
    }
    
}
