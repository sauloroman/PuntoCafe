package controllers.category.helpers;

import utils.enums.ModalTypeEnum;
import utils.helpers.Modal;

public class CategoryValidator {
    
    private final Modal modal;

    public CategoryValidator(Modal modal) {
        this.modal = modal;
    }
    
    public boolean isValidForm(String name, String desc, String type) {
        if ( !isValidName(name) ) {
            modal.show("El nombre de categoría es obligatorio y menor a 100 caracteres", ModalTypeEnum.error);
            return false;
        }
        
        if ( !isValidDescription(desc) ) {
            modal.show("La descripción debe ser menor a 220 caracteres", ModalTypeEnum.error);
            return false;
        }
        
        if ( !isValidType(type) ) {
            modal.show("El tipo de categoría es obligatorio", ModalTypeEnum.error);
            return false;
        }
        
        return true;
    }

    private boolean isValidName(String name) {
        if ( name == null || name.equals("Ingresa un nombre de categoría") ) return false;
        name = name.trim();
        return !name.isEmpty() && name.length() < 100;
    }
    
    private boolean isValidDescription(String description) {
        if ( description == null ) return false;
        description = description.trim();
        return description.length() < 220;
    }
    
    private boolean isValidType(String type) {
        return !type.equals("selecciona un tipo");
    }
    
}
