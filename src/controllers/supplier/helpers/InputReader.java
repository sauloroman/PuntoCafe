package controllers.supplier.helpers;

import views.purchases.PurchasesCreateSupplier;

public class InputReader {
    
    private final PurchasesCreateSupplier createView;

    public InputReader(PurchasesCreateSupplier createView) {
        this.createView = createView;
    }
    
    public String getNameCreate() {
        String name = createView.supplierNameTxt.getText().trim();
        return name;
    }
    
    public String getLastNameCreate() {
        String lastname = createView.supplierNameTxt.getText().trim();
        return lastname;
    }
    
    public String getPhoneCreate() {
        String phone = createView.supplierPhoneTxt.getText().trim();
        return phone;
    }
    
    
    
}
