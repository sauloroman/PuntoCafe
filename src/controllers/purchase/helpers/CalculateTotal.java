package controllers.purchase.helpers;

import entities.PurchaseItem;
import java.util.List;
import views.purchases.PurchasesCreateBuy;

public class CalculateTotal {
    
    private final PurchasesCreateBuy view;
    private double total = 0;

    public CalculateTotal(PurchasesCreateBuy view) {
        this.view = view;
    }
    
    public void calculate(List<PurchaseItem> items) {
        total = 0;
        
        for(PurchaseItem item: items) {
            total += item.getPrice() * item.getQuantity();
        }
        
        setValiesInView();
    }
    
    private void setValiesInView() {
        view.totalPurchase.setText("$" + String.format("%.2f", total));
    }
    
}
