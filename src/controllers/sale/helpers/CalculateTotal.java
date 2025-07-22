package controllers.sale.helpers;

import entities.ProductItem;
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
    
    public void calculateAllProducts(List<ProductItem> products) {
        
        subtotal = 0;
        discountAcc = 0;
        total = 0;
        
        for ( ProductItem item: products ) {
            double productSubtotal = item.getProduct().getProductSellingPrice() * item.getQuantity();
            subtotal += productSubtotal;
            discountAcc += item.getDisscount();
        }
        
        total = subtotal - discountAcc;
        setValuesInView();
    }
    
    private void setValuesInView() {
        view.subtotal.setText("$" + String.format("%.2f", subtotal));
        view.disccount.setText("$" + String.format("%.2f", discountAcc));
        view.total.setText("$" + String.format("%.2f", total));
    }
    
}
