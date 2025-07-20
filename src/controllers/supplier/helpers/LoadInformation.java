package controllers.supplier.helpers;

import entities.Supplier;
import java.awt.Color;
import utils.constants.ViewConstants;
import views.purchases.PurchasesEditSupplier;
import views.purchases.PurchasesInfoSupplier;

public class LoadInformation {
    
    private final PurchasesInfoSupplier infoView;
    private final PurchasesEditSupplier editView;
    
    public LoadInformation(
            PurchasesInfoSupplier infoView,
            PurchasesEditSupplier editView
    ) {
        this.infoView = infoView;
        this.editView = editView;
    }

    public void infoWindow(Supplier supplier) {
        infoView.supplierName.setText(supplier.getSupplierName() + " " + supplier.getSupplierLastname());
        infoView.supplierPhone.setText(supplier.getSupplierPhone());
        infoView.supplierEmail.setText(supplier.getSupplierEmail());
        infoView.supplierAddress.setText(supplier.getSupplierAddress());
        infoView.supplierInfoId.setText(supplier.getSupplierId() + "");
        infoView.supplierCompany.setText(supplier.getSupplierCompany());
        infoView.supplierCreatedAt.setText(supplier.getSupplierCreatedAt().toString());
        infoView.supplierUpdatedAt.setText(supplier.getSupplierUpdatedAt().toString());
        setColorStatusLabel(supplier.getSupplierIsActive() ? "activo" : "inactivo");
    }
    
    public void editWindow(Supplier supplier) {
        editView.supplierNameTxt.setText(supplier.getSupplierName());
        editView.supplierLastnameTxt.setText(supplier.getSupplierLastname());
        editView.supplierPhoneTxt.setText(supplier.getSupplierPhone());
        editView.supplierEmailTxt.setText( supplier.getSupplierEmail() );
        editView.supplierAddressTxt.setText(supplier.getSupplierAddress());
        editView.suppleirCompaniesCombo.setSelectedItem(supplier.getSupplierCompany());
    }
    
    private void setColorStatusLabel(String status) {
        switch (status.toLowerCase()) {
            case "activo" -> infoView.supplierStatus.setBackground(Color.decode(ViewConstants.errorColor));
            case "inactivo" -> infoView.supplierStatus.setBackground(new Color(16, 185, 129));
        }
    }
    
}
