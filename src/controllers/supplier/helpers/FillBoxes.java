package controllers.supplier.helpers;

import java.util.List;
import services.SupplierService;
import views.purchases.PurchasesCreateSupplier;
import views.purchases.PurchasesSuppliers;

public class FillBoxes {
    
    private final PurchasesSuppliers view;
    private final PurchasesCreateSupplier createView;

    public FillBoxes(PurchasesSuppliers view, PurchasesCreateSupplier createView) {
        this.view = view;
        this.createView = createView;
    }

    public void fillCompaniesBox( List<String> companies ) {
        view.suppliersCompanyCombo.removeAllItems();
        view.suppliersCompanyCombo.addItem("Empresa");
        for( String company : companies ) {
            view.suppliersCompanyCombo.addItem(company);
        }
        view.suppliersCompanyCombo.setSelectedItem(0);
    }
    
    public void fillCompaniesBoxCreate( List<String> companies ) {
        createView.suppleirCompaniesCombo.removeAllItems();
        createView.suppleirCompaniesCombo.addItem("Seleccione una empresa");
        for( String company : companies ) {
            createView.suppleirCompaniesCombo.addItem(company);
        }
        createView.suppleirCompaniesCombo.setSelectedItem(0);
    }
    
}
