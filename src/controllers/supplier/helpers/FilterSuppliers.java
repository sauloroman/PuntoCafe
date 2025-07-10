package controllers.supplier.helpers;

import views.purchases.PurchasesSuppliers;

public class FilterSuppliers {
    
    private final PurchasesSuppliers view;

    public FilterSuppliers(
            PurchasesSuppliers view    
    ) {
        this.view = view;
    }
    
    public String filterByStatus() {
        String status = view.suppliersStatusCombo.getSelectedItem().toString();
        if ( status.equals("Estado")) return null;
        return status;
    }
    
    public String filterByCompany() {
        if ( view.suppliersCompanyCombo.getSelectedItem() == null ) return null;
        String company = view.suppliersCompanyCombo.getSelectedItem().toString();
        return company;
    }
}
