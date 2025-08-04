package controllers.seller.helpers;

import interfaces.SaleItem;
import java.util.List;
import views.sales.CreateSale;

public class CalculateTotal {
    
    private double subtotal = 0;
    private double discountAcc = 0;
    private double total = 0;
    private final CreateSale view;

    public CalculateTotal(CreateSale view) {
        this.view = view;
    }
    
    public void calculateAll(List<SaleItem> items) {
        subtotal = 0;
        discountAcc = 0;
        total = 0;
        
        for ( SaleItem item: items ) {
            double itemSubtotal = item.getSellingPrice() * item.getQuantity();
            subtotal += itemSubtotal;
            discountAcc += item.getDiscount();
        }
        
        total = subtotal - discountAcc;
        setValuesInView();
    }
    
    public double getTotal() {
        return total;
    }
    
    private void setValuesInView() {
        view.subtotal.setText("$" + String.format("%.2f", subtotal));
        view.disccount.setText("$" + String.format("%.2f", discountAcc));
        view.total.setText("$" + String.format("%.2f", total));
    }
    
}
