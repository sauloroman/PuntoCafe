package controllers.purchase.helpers;

import utils.enums.ModalTypeEnum;
import utils.helpers.Modal;

public class PurchaseValidator {
    
    private final Modal modal;

    public PurchaseValidator(Modal modal) {
        this.modal = modal;
    }
    
    public boolean isValidForm(int quantity, double price) {
        
        if ( !isValidQuantityProduct(quantity) ) {
            modal.show("La cantidad no es válida", ModalTypeEnum.error);
            return false;
        }
        
        if (!isValidPriceProduct(price)) {
            modal.show("El precio no es válido", ModalTypeEnum.error);
            return false;
        }
        
        return true;
    }
    
    private boolean isValidQuantityProduct(int quantity) {
        return quantity > 0;
    }
    
    private boolean isValidPriceProduct(double price) {
        return price > 0;
    }
    
}
