package controllers.supplier.helpers;

import views.purchases.PurchasesSuppliers;

public class LoadEditSupplier {
    
    private final PurchasesSuppliers view;
    
    public LoadEditSupplier(
            PurchasesSuppliers view
    ) {
        this.view = view;
    }

    public void load() {
        int row = view.suppliersTable.getSelectedRow();
        
        String id = view.suppliersTable.getValueAt(row, 0).toString();
        String name = view.suppliersTable.getValueAt(row, 1).toString();
        String lastName = view.suppliersTable.getValueAt(row, 2).toString();
        String company = view.suppliersTable.getValueAt(row, 3).toString();
        String phone = view.suppliersTable.getValueAt(row, 4).toString();
        String email = view.suppliersTable.getValueAt(row, 5).toString();
        String address = view.suppliersTable.getValueAt(row, 6).toString();
        String createdAt = view.suppliersTable.getValueAt(row, 7).toString();
        String updatedAt = view.suppliersTable.getValueAt(row, 8).toString();
        String status = view.suppliersTable.getValueAt(row, 9).toString();
        
//        view.supplierEditNameTxt.setText( name );
//        view.supplierEditLastnameTxt.setText(lastName);
//        view.supplierEditCompanyTxt.setSelectedItem(company);
//        view.supplierEditPhoneTxt.setText(phone);
//        view.supplierEditEmailTxt.setText(email);
//        view.supplierEditAddressTxt.setText(address);
//        
//        view.supplierIDSelected.setText(id);
//        view.supplierNameSelected.setText(name);
//        view.supplierLastnameSelected.setText(lastName);
//        view.supplierCompanySelected.setText(company);
//        view.supplierPhoneSelected.setText(phone);
//        view.supplierEmailSelected.setText(email);
//        view.supplierAddressSelected.setText(address);
//        view.supplierCreatedAtSelected.setText(createdAt);
//        view.supplierUpdatedAtSelected.setText(updatedAt);
//        view.supplierStatusSelected.setText(status);
    }
    
}
