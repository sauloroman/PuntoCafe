package controllers.purchase.helpers;

import entities.Supplier;
import entities.TopSupplier;
import java.util.List;
import views.purchases.PurchasesBuy;

public class LoadInformation {
    
    private final PurchasesBuy view;

    public LoadInformation(PurchasesBuy view) {
        this.view = view;
    }
    
    public void fillSuppliersBox(List<Supplier> suppliers) {
       view.filterSupplier.removeAllItems();
       view.filterSupplier.addItem("Proveedor");
       for( Supplier supplier: suppliers ) {
           view.filterSupplier.addItem(supplier.getSupplierName() + " " + supplier.getSupplierLastname());
       }
       view.filterSupplier.setSelectedItem(0);
    }
    
    public void setTotalPurchasesAmount( double total ) {
        view.purchasesMoney.setText("$" + String.format("%.2f", total));
    }
    
    public void setTotalPurchases(int totalPurchases) {
        view.purchasesQuantity.setText(totalPurchases + "");
    }
    
    public void setAvgPurchaseAmount( double quantity ) {
        view.purchaseAvg.setText("$" + String.format("%.2f", quantity));
    }
    
    public void setTopSupplier(TopSupplier topSupplier) {
        view.purchasesFavoriteSupplier.setText("$" + String.format("%.2f", topSupplier.getTotalInversion()));
        view.suppleirName.setText(topSupplier.getSupplierName() + " " + topSupplier.getSupplierLastname());
    }
    
}
