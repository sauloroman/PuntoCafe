package controllers.sale.helpers;

import javax.swing.JTable;
import views.sales.SaleDetail;

public class CalculateTotalSaleDetail {
    
    private final int INDEX_SUBTOTAL_IN_TABLE = 5;
    private final int INDEX_DISCOUNT_IN_TABLE = 4;
    private final SaleDetail view;

    public CalculateTotalSaleDetail(SaleDetail view) {
        this.view = view;
    }
    
    public void setSubtotalProducts() {
        double subtotalTable = getSubtotalTable(view.productsTable);
        view.subtotalProducts.setText("$" + String.format("%.2f", subtotalTable));
    }
    
    public void setSubtotalDishes() {
        double subtotalTable = getSubtotalTable(view.dishesTable);
        view.subtotalDishes.setText("$" + String.format("%.2f", subtotalTable));
    }
    
    public void setInfoTotalGeneral() {
        double total = getSubtotalTable(view.productsTable) + getSubtotalTable(view.dishesTable);
        view.totalSale.setText("$" + total);
        
        double discountGeneral = getDiscountTotalTable(view.productsTable) + getDiscountTotalTable(view.dishesTable);
        view.discountSale.setText("$" + discountGeneral);
    }
    
    private double getSubtotalTable(JTable table ) {
        double acc = 0;
        for ( int i = 0; i < table.getRowCount(); i++ ) {
           String subtotalFormatted = table.getValueAt(i, INDEX_SUBTOTAL_IN_TABLE).toString();
           String sub = subtotalFormatted.replace("$", "");
           double subTotal = Double.parseDouble(sub);
           acc += subTotal;
        }
        
        return acc;
    }
    
    private double getDiscountTotalTable(JTable table) {
        double acc = 0;
        for ( int i = 0; i < table.getRowCount(); i++ ) {
           String discountFormatted = table.getValueAt(i, INDEX_DISCOUNT_IN_TABLE).toString();
           String sub = discountFormatted.replace("$", "");
           double disscount = Double.parseDouble(sub);
           acc += disscount;
        }
        
        return acc;
    }
    
}
