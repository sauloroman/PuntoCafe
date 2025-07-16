package controllers.supplier.handlers;

import interfaces.HandlerController;
import entities.Supplier;
import services.SupplierService;
import utils.enums.ModalTypeEnum;
import utils.helpers.Modal;
import views.purchases.PurchasesSuppliers;

public class EditSupplierHandler implements HandlerController {
    
    private final PurchasesSuppliers view;
    private final SupplierService service;
    private final Modal modal;

    public EditSupplierHandler(
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
        
        String newName = view.supplierEditNameTxt.getText().trim();
        String newLastname = view.supplierEditLastnameTxt.getText().trim();
        String newPhone = view.supplierEditPhoneTxt.getText().trim();
        String newEmail = view.supplierEditEmailTxt.getText().trim();
        String newAddress = view.supplierEditAddressTxt.getText().trim();
        String newCompany;
                
        String newCompanyTxt = view.supplierEditNewCompanyTxt.getText().trim();
        
        if ( !newCompanyTxt.isEmpty() ) {
            newCompany = newCompanyTxt;
            
            if ( service.getSupplierByCompany(newCompany) != null ) {
                modal.show("La empresa que intentas crear está entre las opciones disponibles", ModalTypeEnum.error);
                return;
            }
            
        } else {
            newCompany = view.supplierEditCompanyTxt.getSelectedItem().toString();
        }
                
        Supplier supplier = new Supplier(
                newName,
                newLastname,
                newCompany,
                newPhone,
                newEmail,
                newAddress
        );
        
        int id = Integer.parseInt(view.supplierIDSelected.getText());
        
        if ( !service.updateSupplier(supplier, id ) ) {
            modal.show("El proveedor no pudo ser actualizado", ModalTypeEnum.error);
            return;
        }
        
        modal.show("El proveedor ha sido actualizado", ModalTypeEnum.success);
    }

}
