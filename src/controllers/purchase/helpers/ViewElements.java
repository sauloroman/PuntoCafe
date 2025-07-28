package controllers.purchase.helpers;

import views.purchases.PurchaseBuyQuantityPrice;
import views.purchases.PurchasesBuy;

public class ViewElements {
    
    private final PurchasesBuy view;
    private final PurchaseBuyQuantityPrice quantityPriceView;

    public ViewElements(PurchasesBuy view, PurchaseBuyQuantityPrice quantityPriceView) {
        this.view = view;
        this.quantityPriceView = quantityPriceView;
    }
    
    public void clearQuantiyPriceForm() {
        quantityPriceView.quantityTxt.setText("");
        quantityPriceView.priceTxt.setText("");
    }
    
}
