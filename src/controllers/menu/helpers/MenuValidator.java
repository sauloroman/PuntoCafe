package controllers.menu.helpers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import utils.enums.ModalTypeEnum;
import utils.helpers.Modal;

public class MenuValidator {
    
    private final Modal modal;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    
    public MenuValidator(Modal modal) {
        this.modal = modal;
    }
    
    public boolean isValidForm(
            String menuName,
            String menuDesc,
            String menuStartDate,
            String menuEndDate
    ) {
        
        if ( !isValidName(menuName) ) {
            modal.show("El nombre del menú es obligatorio y menor a 100 caracteres", ModalTypeEnum.error);
            return false;
        } 
        
        if ( !isValidDescription(menuDesc) ) {
            modal.show("La descripción del debe ser menor a 220 caracteres", ModalTypeEnum.error);
            return false;
        } 
        
        LocalDate startDate = parseDate(menuStartDate);
        if ( startDate == null ) {
            modal.show("La fecha de inicio no es válida.", ModalTypeEnum.error);
            return false;
        }
        
        LocalDate endDate = parseDate(menuEndDate);
        if ( endDate == null ) {
            modal.show("La fecha de fin no es válida.", ModalTypeEnum.error);
            return false;
        }
        
        if ( endDate.isBefore(startDate) ) {
            modal.show("La fecha de fin no puede ser anterior a la fecha de inicio.", ModalTypeEnum.error);
            return false;
        }
        
        return true;
    }
    
    private boolean isValidName(String menuName) {
        return menuName != null && !menuName.isEmpty() && menuName.length() <= 100;
    }
    
    private boolean isValidDescription(String menuDesc) {
        return menuDesc != null && menuDesc.length() <= 220;
    }
    
    private LocalDate parseDate(String dateStr) {
        try {
            return LocalDate.parse(dateStr, formatter);
        } catch(DateTimeParseException e) {
            return null;
        }
    }
    
}
