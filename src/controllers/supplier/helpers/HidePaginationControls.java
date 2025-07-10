package controllers.supplier.helpers;

import views.purchases.PurchasesSuppliers;

public class HidePaginationControls {
    
    private final PurchasesSuppliers view;

    public HidePaginationControls(PurchasesSuppliers view) {
        this.view = view;
    }
    
    public void hide() {
        view.btnSearchSuppliers.setVisible(false);
        view.pageComboBox.setVisible(false);
        view.itemsPerPageComboBox.setVisible(false);
        view.btnSeeAllSuppliers.setVisible(true);
    }
    
    public void show() {
        view.btnSearchSuppliers.setVisible(true);
        view.pageComboBox.setVisible(true);
        view.itemsPerPageComboBox.setVisible(true);
        view.btnSeeAllSuppliers.setVisible(false);
        view.searchSuppliersTxt.setText("");
    }
    
}
