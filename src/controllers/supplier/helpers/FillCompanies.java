package controllers.supplier.helpers;

import java.util.List;
import javax.swing.JComboBox;
import services.SupplierService;
import views.purchases.PurchasesSuppliers;

public class FillCompanies {

    private final SupplierService service;
    private final PurchasesSuppliers view;

    public FillCompanies(PurchasesSuppliers view, SupplierService service) {
        this.view = view;
        this.service = service;
    }

    public void fillCompaniesBoxes() {
        fillBox(view.suppliersCompanyCombo);
        fillBox(view.supplierCompanyTxt);
        fillBox(view.supplierEditCompanyTxt);
        view.btnSeeAllSuppliers.setVisible(false);
    }
    
    private void fillBox( JComboBox combo ) {
        List<String> companies = service.getCompaniesUnique();
        combo.removeAllItems();
        for( String company : companies ) {
            combo.addItem(company);
        }
    }
    
}
