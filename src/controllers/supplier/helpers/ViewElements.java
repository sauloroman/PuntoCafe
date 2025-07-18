package controllers.supplier.helpers;

import views.purchases.PurchasesCreateSupplier;
import views.purchases.PurchasesSuppliers;

public class ViewElements {
    
    private final PurchasesSuppliers view;
    private final PurchasesCreateSupplier createView;
    public boolean isCreatingNewCompany = false;

    public ViewElements(PurchasesSuppliers view, PurchasesCreateSupplier createView) {
        this.view = view;
        this.createView = createView;
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
    
    public void toggleCreateCompanyForm() {
        if ( isCreatingNewCompany ) {
            showCreateCompanyForm();
            isCreatingNewCompany = false;
        } else {
            hideCreateCompanyForm();
            isCreatingNewCompany = true;
        }
    }
    
    private void showCreateCompanyForm() {
        createView.supplierCompanyNameTxt.setVisible(true);
        createView.btnNewCompany.setText("Ocultar");
    }    
    
    private void hideCreateCompanyForm() {
        createView.btnNewCompany.setText("Crear empresa");
        createView.supplierCompanyNameTxt.setVisible(false);
    }
}
