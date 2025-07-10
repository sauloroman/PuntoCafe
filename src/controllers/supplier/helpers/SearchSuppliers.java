package controllers.supplier.helpers;

import views.purchases.PurchasesSuppliers;

public class SearchSuppliers {
    
    private final PurchasesSuppliers view;

    public SearchSuppliers(
            PurchasesSuppliers view
    ) {
        this.view = view;
    }

    public String getSearchInput() {
        String input = view.searchSuppliersTxt.getText().trim();
        return input;
    }
    
}
