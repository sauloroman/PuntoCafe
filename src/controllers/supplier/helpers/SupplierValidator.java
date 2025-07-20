package controllers.supplier.helpers;

import utils.enums.ModalTypeEnum;
import utils.helpers.Modal;
import utils.validators.EmailValidator;

public final class SupplierValidator {
    
    private final Modal modal;

    public SupplierValidator(Modal modal) {
        this.modal = modal;
    }
    
    public boolean isValidForm(
            String name,
            String lastName,
            String phone,
            String email,
            String address,
            String company
    ) {
        
        if ( !isValidName(name) ) {
            modal.show("El nombre de proveedor es obligatorio y menor a 100 caracteres", ModalTypeEnum.error);
            return false;
        }
        
        if ( !isValidLastName(lastName) ) {
            modal.show("El apellido del proveedor es obligatorio y menor a 100 caracteres", ModalTypeEnum.error);
            return false;
        }
        
        if ( !isValidPhone(phone) ) {
            modal.show("El teléfono del proveedor es obligatorio y menor a 15 caracteres", ModalTypeEnum.error);
            return false;
        }
        
        if ( !email.isEmpty() && !isValidEmail(email) ) {
            modal.show("El correo del proveedor debe ser válido", ModalTypeEnum.error);
            return false;
        }
        
        if ( !address.isEmpty() && !isValidAddress(address) ) {
            modal.show("La dirección del proveedor debe ser menor a 200 caracteres", ModalTypeEnum.error);
            return false;
        }
        
        if ( !isValidCompany(company) ) {
            modal.show("La empresa del proveedor es obligatoria y menor a 100 caracteres", ModalTypeEnum.error);
            return false;
        }
        
        return true;
    }
    
    private boolean isValidName(String name) {
        if ( name == null ) return false;
        name = name.trim();
        return !name.isEmpty()&& name.length() <= 100;
    }
    
    private boolean isValidLastName(String lastname) {
        if ( lastname == null ) return false;
        lastname = lastname.trim();
        return !lastname.isEmpty() && lastname.length() <= 100;
    }
    
    private boolean isValidCompany(String company) {
        if ( company == null ) return false;
        company = company.trim();
        return !company.isEmpty() && company.length() <= 100;
    }
    
    private boolean isValidPhone(String phone) {
        if (phone == null) return false;
        phone = phone.trim();
        if (phone.isEmpty() || phone.length() > 15) return false;
 
        if (!phone.matches("[0-9\\-]+")) return false;

        if (!Character.isDigit(phone.charAt(0)) || !Character.isDigit(phone.charAt(phone.length() - 1))) {
            return false;
        }
        
        if (phone.contains("--")) return false;

        String digitsOnly = phone.replaceAll("-", "");
        return digitsOnly.length() == 10;
    }
    
    private boolean isValidEmail(String email) {
        if ( email == null ) return false;
        email = email.trim();
        return EmailValidator.isValidEmail(email) && email.length() <= 100;
    }
    
    private boolean isValidAddress(String address) {
        if ( address == null ) return false;
        address = address.trim();
        return address.length() <= 200;
    }
    
}
