package controllers.supplier.helpers;

import java.util.List;
import views.purchases.PurchasesCreateSupplier;
import views.purchases.PurchasesEditSupplier;
import views.purchases.PurchasesSuppliers;

public class FillBoxes {
    
    private final PurchasesSuppliers view;
    private final PurchasesCreateSupplier createView;
    private final PurchasesEditSupplier editView;

    public FillBoxes(PurchasesSuppliers view, PurchasesCreateSupplier createView, PurchasesEditSupplier editView) {
        this.view = view;
        this.createView = createView;
        this.editView = editView;
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
    
    public void fillCompaniesBoxEdit( List<String> companies ) {
        editView.suppleirCompaniesCombo.removeAllItems();
        editView.suppleirCompaniesCombo.addItem("Seleccione una empresa");
        for( String company : companies ) {
            editView.suppleirCompaniesCombo.addItem(company);
        }
        editView.suppleirCompaniesCombo.setSelectedItem(0);
    }
    
}
