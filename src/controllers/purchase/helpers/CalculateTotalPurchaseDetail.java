package controllers.purchase.helpers;

import javax.swing.JTable;
import views.purchases.PurchasesDetail;

public class CalculateTotalPurchaseDetail {
    
    private final int INDEX_SUBTOTAL_IN_TABLE = 4;
    private final PurchasesDetail view;

    public CalculateTotalPurchaseDetail(PurchasesDetail view) {
        this.view = view;
    }
    
    public void setInfoTotalGeneral() {
        double total = getTotalTable(view.productsTable);
        view.total.setText("$" + String.format("%.2f", total));
    }
    
    private double getTotalTable(JTable table ) {
        double acc = 0;
        for ( int i = 0; i < table.getRowCount(); i++ ) {
           String subtotalFormatted = table.getValueAt(i, INDEX_SUBTOTAL_IN_TABLE).toString();
           String sub = subtotalFormatted.replace("$", "");
           double subTotal = Double.parseDouble(sub);
           acc += subTotal;
        }
        
        return acc;
    }
    
}
