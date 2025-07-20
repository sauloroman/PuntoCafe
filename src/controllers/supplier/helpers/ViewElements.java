package controllers.supplier.helpers;

import views.purchases.PurchasesCreateSupplier;
import views.purchases.PurchasesEditSupplier;
import views.purchases.PurchasesSuppliers;

public class ViewElements {
    
    private final PurchasesSuppliers view;
    private final PurchasesCreateSupplier createView;
    private final PurchasesEditSupplier editView;
    public boolean isCreatingNewCompany = false;

    public ViewElements(PurchasesSuppliers view, PurchasesCreateSupplier createView, PurchasesEditSupplier editView) {
        this.view = view;
        this.createView = createView;
        this.editView = editView;
    }
    
    public void hidePaginationControls() {
        view.pageComboBox.setVisible(false);
        view.itemsPerPageComboBox.setVisible(false);
        view.titlePages.setVisible(false);
        view.titleItems.setVisible(false);
    }
    
    public void showPaginationControls() {
        view.pageComboBox.setVisible(true);
        view.itemsPerPageComboBox.setVisible(true);
        view.searchSuppliersTxt.setText("");
        view.titlePages.setVisible(true);
        view.titleItems.setVisible(true);
    }
    
    public void clearCreateSupplierForm() {
        createView.supplierNameTxt.setText("");
        createView.supplierLastnameTxt.setText("");
        createView.supplierPhoneTxt.setText("");
        createView.supplierEmailTxt.setText("");
        createView.supplierAddressTxt.setText("");
        createView.supplierCompanyNameTxt.setText("");
        createView.suppleirCompaniesCombo.setSelectedItem("Seleccione una empresa");
        hideCreateCompanyForm();
    }
    
    public void clearEditSupplierForm() {
        editView.supplierNameTxt.setText("");
        editView.supplierLastnameTxt.setText("");
        editView.supplierPhoneTxt.setText("");
        editView.supplierEmailTxt.setText("");
        editView.supplierAddressTxt.setText("");
        editView.supplierCompanyNameTxt.setText("");
        editView.suppleirCompaniesCombo.setSelectedItem("Seleccione una empresa");
        hideCreateCompanyForm();
    }
    
    public void clearInputSearch() {
        view.searchSuppliersTxt.setText("");
    }
    
    public void toggleCreateCompanyForm() {
        if ( isCreatingNewCompany ) {
            showCreateCompanyForm();
            isCreatingNewCompany = false;
        } else {
            hideCreateCompanyForm();
            isCreatingNewCompany = true;
        }
    }
    
    public void showCreateCompanyForm() {
        createView.supplierCompanyNameTxt.setVisible(true);
        createView.btnNewCompany.setText("Ocultar");
        createView.suppleirCompaniesCombo.setVisible(false);
    }    
    
    public void hideCreateCompanyForm() {
        createView.btnNewCompany.setText("Crear empresa");
        createView.supplierCompanyNameTxt.setVisible(false);
        createView.suppleirCompaniesCombo.setVisible(true);
        createView.supplierCompanyNameTxt.setText("");
    }
    
    public void toggleCreateCompanyFormEdit() {
        if ( isCreatingNewCompany ) {
            showCreateCompanyFormEdit();
            isCreatingNewCompany = false;
        } else {
            hideCreateCompanyFormEdit();
            isCreatingNewCompany = true;
        }
    }
    
    public void showCreateCompanyFormEdit() {
        editView.supplierCompanyNameTxt.setVisible(true);
        editView.btnNewCompany.setText("Ocultar");
        editView.suppleirCompaniesCombo.setVisible(false);
    }    
    
    public void hideCreateCompanyFormEdit() {
        editView.btnNewCompany.setText("Crear empresa");
        editView.supplierCompanyNameTxt.setVisible(false);
        editView.suppleirCompaniesCombo.setVisible(true);
        editView.supplierCompanyNameTxt.setText("");
    }

}
