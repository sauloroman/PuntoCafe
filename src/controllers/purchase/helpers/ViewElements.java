package controllers.purchase.helpers;

import views.purchases.PurchaseBuyQuantityPrice;
import views.purchases.PurchasesBuy;
import views.purchases.PurchasesCreateBuy;

public class ViewElements {
    
    private final PurchasesBuy view;
    private final PurchasesCreateBuy createView;
    private final PurchaseBuyQuantityPrice quantityPriceView;
    
    public ViewElements(PurchasesBuy view, PurchasesCreateBuy createView, PurchaseBuyQuantityPrice quantityPriceView) {
        this.view = view;
        this.createView = createView;
        this.quantityPriceView = quantityPriceView;
    }
    
    public void clearQuantiyPriceForm() {
        quantityPriceView.quantityTxt.setText("");
        quantityPriceView.priceTxt.setText("");
    }
    
    public void clearTotalPurchase() {
        createView.totalPurchase.setText("$0.00");
    }
    
    public void clearPurchaseList() {
        createView.productsInPurchase.removeAll();
        createView.productsInPurchase.revalidate();
        createView.productsInPurchase.repaint();
    }
    
}
