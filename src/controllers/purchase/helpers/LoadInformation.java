package controllers.purchase.helpers;

import entities.Supplier;
import entities.TopSupplier;
import java.awt.BorderLayout;
import java.util.List;
import org.jfree.chart.ChartPanel;
import views.purchases.PurchasesBuy;
import views.purchases.PurchasesCreateBuy;
import views.purchases.PurchasesDetail;

public class LoadInformation {
    
    private final PurchasesBuy view;
    private final PurchasesCreateBuy createView;
    private final PurchasesDetail detailView;

    public LoadInformation(PurchasesBuy view, PurchasesCreateBuy createView, PurchasesDetail detailView) {
        this.view = view;
        this.createView = createView;
        this.detailView = detailView;
    }
    
    public void fillSuppliersBox(List<Supplier> suppliers) {
       view.filterSupplier.removeAllItems();
       view.filterSupplier.addItem("Proveedor");
       for( Supplier supplier: suppliers ) {
           view.filterSupplier.addItem(supplier.getSupplierName() + " " + supplier.getSupplierLastname());
       }
       view.filterSupplier.setSelectedItem(0);
    }
    
    public void fillSupplierBoxCreatePurchase(List<Supplier> suppliers) {
       createView.filterSupplier.removeAllItems();
       createView.filterSupplier.addItem("Selecciona un proveedor");
       for( Supplier supplier: suppliers ) {
           createView.filterSupplier.addItem(supplier.getSupplierName() + " " + supplier.getSupplierLastname());
       }
       createView.filterSupplier.setSelectedItem(0);
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
    
    public void setMontlyPurchasesChart(ChartPanel chart) {
        view.purchasesGraph.removeAll();
        view.purchasesGraph.setLayout(new BorderLayout());
        view.purchasesGraph.add(chart, BorderLayout.CENTER);
        view.purchasesGraph.revalidate();
        view.purchasesGraph.repaint();
    }
    
    public void setTopProductsPurchasesChart(ChartPanel chart) {
        view.purchasesTopProducts.removeAll();
        view.purchasesTopProducts.setLayout(new BorderLayout());
        view.purchasesTopProducts.add(chart, BorderLayout.CENTER);
        view.purchasesTopProducts.revalidate();
        view.purchasesTopProducts.repaint();
    }
    
    public void setPurchaseDateInDetailWindow(String date) {
        detailView.purchaseDate.setText(date);
    }
    
}
