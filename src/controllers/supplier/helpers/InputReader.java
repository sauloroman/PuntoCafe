package controllers.supplier.helpers;

import views.purchases.PurchasesCreateSupplier;
import views.purchases.PurchasesEditSupplier;
import views.purchases.PurchasesSuppliers;

public class InputReader {
    
    private final PurchasesSuppliers view;
    private final PurchasesCreateSupplier createView;
    private final PurchasesEditSupplier editView;

    public InputReader(PurchasesSuppliers view, PurchasesCreateSupplier createView, PurchasesEditSupplier editView) {
        this.view = view;
        this.createView = createView;
        this.editView = editView;
    }
    
     public String getStatusSearch() {
        String status = view.suppliersStatusCombo.getSelectedItem().toString();
        if ( status.equals("Estado")) return null;
        return status;
    }
    
    public String getCompanySearch() {
        String company = view.suppliersCompanyCombo.getSelectedItem().toString();
        if ( company.equals("Empresa") ) return null;
        return company;
    }
    
    public String getNameSearch() {
        String nameSearched = view.searchSuppliersTxt.getText().trim();
        if ( nameSearched.equals("Buscar proveedores por nombre") || nameSearched.isEmpty() ) return null;
        return nameSearched;
    }
    
    public String getNameCreate() {
        String name = createView.supplierNameTxt.getText().trim();
        if ( name.equals("Ingrese nombre de proveedor") ) return "";
        return name;
    }
    
    public String getLastNameCreate() {
        String lastname = createView.supplierLastnameTxt.getText().trim();
        if ( lastname.equals("Ingrese apellido de proveedor") ) return "";
        return lastname;
    }
    
    public String getPhoneCreate() {
        String phone = createView.supplierPhoneTxt.getText().trim();
        return phone;
    }
    
    public String getEmailCreate() {
        String email = createView.supplierEmailTxt.getText().trim();
        if ( email.equals("proveedor@correo.com") ) return "";
        return email;
    }
    
    public String getAddressCreate() {
        String address = createView.supplierAddressTxt.getText().trim();
        if ( address.equals("Ingrese la dirección del proveedor") ) return "";
        return address;
    }
    
    public String getCompanySelectedCreate() {
        String selectedCompany = createView.suppleirCompaniesCombo.getSelectedItem().toString();
        if ( selectedCompany.equals("Seleccione una empresa") ) return "";
        return selectedCompany;
    }
    
    public String getNewCompanyCreate() {
        String newCompany = createView.supplierCompanyNameTxt.getText().trim();
        if ( newCompany.equals("Ingrese el nombre de la empresa") ) return "";
        return newCompany;
    }
    
    public String getNameEdit() {
        String name = editView.supplierNameTxt.getText().trim();
        if ( name.equals("Ingrese nombre de proveedor") ) return "";
        return name;
    }
    
    public String getLastNameEdit() {
        String lastname = editView.supplierNameTxt.getText().trim();
        if ( lastname.equals("Ingrese apellido de proveedor") ) return "";
        return lastname;
    }
    
    public String getPhoneEdit() {
        String phone = editView.supplierPhoneTxt.getText().trim();
        return phone;
    }
    
    public String getEmailEdit() {
        String email = editView.supplierEmailTxt.getText().trim();
        if ( email.equals("proveedor@correo.com") ) return "";
        return email;
    }
    
    public String getAddressEdit() {
        String address = editView.supplierAddressTxt.getText().trim();
        if ( address.equals("Ingrese la dirección del proveedor") ) return "";
        return address;
    }
    
    public String getCompanySelectedEdit() {
        String selectedCompany = editView.suppleirCompaniesCombo.getSelectedItem().toString();
        if ( selectedCompany.equals("Seleccione una empresa") ) return "";
        return selectedCompany;
    }
    
    public String getNewCompanyEdit() {
        String newCompany = editView.supplierCompanyNameTxt.getText();
        if ( newCompany.equals("Ingrese el nombre de la empresa") ) return "";
        return newCompany;
    }
}
