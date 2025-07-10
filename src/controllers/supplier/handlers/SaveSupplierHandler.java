package controllers.supplier.handlers;

import controllers.interfaces.HandlerController;
import entities.Supplier;
import services.SupplierService;
import utils.enums.ModalTypeEnum;
import utils.helpers.Modal;
import utils.validators.SupplierValidator;
import views.components.Label;
import views.purchases.PurchasesSuppliers;

public class SaveSupplierHandler implements HandlerController {
    
    private final PurchasesSuppliers view;
    private final SupplierService service;
    private final Modal modal;
    
    public SaveSupplierHandler(
            PurchasesSuppliers view, 
            SupplierService service, 
            Modal modal
    ) {
        this.view = view;
        this.service = service;
        this.modal = modal;
    }

    @Override
    public void execute() {
        String name = view.supplierNameTxt.getText().trim();
        String lastname = view.supplierLastnameTxt.getText().trim();
        String phone = view.supplierPhoneTxt.getText().trim();
        String email = view.supplierEmailTxt.getText().trim();
        String address = view.supplierAddressTxt.getText().trim(); 
        
        String newCompany = view.supplierNewCompanyTxt.getText().trim();
        String company;
        
        if ( !newCompany.isEmpty() ) {
            company = newCompany;
            
            if ( service.getSupplierByCompany(company) != null ) {
                modal.show("La empresa que intentas crear está entre las opciones disponibles", ModalTypeEnum.error);
                return;
            }
        } else {
            company = view.supplierCompanyTxt.getSelectedItem().toString();
        }
        
        System.out.println(company);
                
        if ( !isValid(name, lastname, company, phone, email, address) ) return;
        
        Supplier supplier = new Supplier( name, lastname, company, phone, email, address );
        
        if (!service.saveSupplier(supplier)) {
            modal.show("El proveedor no pudo ser creado", ModalTypeEnum.error);
            return;
        } 
        
        modal.show("El proveedor ha sido creado", ModalTypeEnum.success);
        resetForm();
    }
    
    private boolean isValid(
            String name,
            String lastname,
            String company,
            String phone,
            String email,
            String address
    ) {   

        if ( !SupplierValidator.isValidName(name) ) {
            modal.show("El nombre es obligatorio y menor a 100 caracteres", ModalTypeEnum.error);
            Label.styleWrongRestrictionField(view.supplierNameTxt, view.supplierRestrictionName);
            return false;
        }
        
        if ( !SupplierValidator.isValidLastName(lastname) ) {
            modal.show("El apellido es obligatorio y menor a 100 caracteres", ModalTypeEnum.error);
            Label.styleWrongRestrictionField(view.supplierLastnameTxt, view.supplierRestrictionLastname);
            return false;
        }
        
        if ( !SupplierValidator.isValidCompany(company) ) {
            modal.show("La compañia es obligatoria y menor a 100 caracteres", ModalTypeEnum.error);
            Label.styleWrongRestrictionField(view.supplierNewCompanyTxt, view.supplierRestrictionNewCompany);
            return false;
        }
        
        if ( !SupplierValidator.isValidPhone(phone) ) {
            System.out.println("Teléfono invalido");
            modal.show("El teléfono es obligatorio y menor a 15 caracteres", ModalTypeEnum.error);
            Label.styleWrongRestrictionField(view.supplierPhoneTxt, view.supplierRestrictionPhone);
            return false;
        }
        
        if ( !email.isEmpty() && !SupplierValidator.isValidEmail(email) ) {
            modal.show("El correo debe ser valido y menor a 100 caracteres", ModalTypeEnum.error);
            Label.styleWrongRestrictionField(view.supplierEmailTxt, view.supplierRestrictionEmail);
            return false;
        }
        
        if ( !SupplierValidator.isValidAddress(address) ) {
            modal.show("La dirección debe ser menor a 200 caracteres", ModalTypeEnum.error);
            Label.styleWrongRestrictionField(view.supplierAddressTxt, view.supplierRestrictionAddress);
            return false;
        }
        
        return true;
    }
    
    private void resetForm() {
        view.supplierNameTxt.setText("");
        view.supplierLastnameTxt.setText("");
        view.supplierCompanyTxt.setSelectedIndex(0);
        view.supplierPhoneTxt.setText("");
        view.supplierEmailTxt.setText("");
        view.supplierAddressTxt.setText("");
        Label.styleRestriction(view.supplierRestrictionName);
        Label.styleRestriction(view.supplierRestrictionLastname);
        Label.styleRestriction(view.supplierRestrictionEmail);
        Label.styleRestriction(view.supplierRestrictionPhone);
        Label.styleRestriction(view.supplierRestrictionAddress);
        Label.styleRestriction(view.supplierRestrictionNewCompany);
        view.supplierNewCompanyLabel.setVisible(false);
        view.supplierRestrictionNewCompany.setVisible(false);
        view.supplierNewCompanyTxt.setVisible(false);
        view.supplierCompanyTxt.setVisible(true);
        view.btnCreateCompany.setText("Crear");
    }
    

}
