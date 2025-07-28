package controllers.purchase.helpers;

import java.text.SimpleDateFormat;
import java.util.Date;
import utils.helpers.DateFilterPanel;
import views.purchases.PurchaseBuyQuantityPrice;
import views.purchases.PurchasesBuy;
import views.purchases.PurchasesCreateBuy;

public class InputReader {
    
    private final PurchasesBuy view;
    private final PurchasesCreateBuy createView;
    private final PurchaseBuyQuantityPrice quantityPriceView;
    private final DateFilterPanel dateFilterPanel;

    public InputReader(
            PurchasesBuy view,
            PurchasesCreateBuy createView,
            PurchaseBuyQuantityPrice quantityPriceView,
            DateFilterPanel dateFilterPanel
    ) {
        this.view = view;
        this.createView = createView;
        this.quantityPriceView = quantityPriceView;
        this.dateFilterPanel = dateFilterPanel;
    }
    
    public String getSupplierFiltered() {
        String supplier = view.filterSupplier.getSelectedItem().toString();
        if ( supplier.equals("Proveedor")) return null;
        return supplier;
    }
    
    public String getStartDate() {
        Date dateSelected = dateFilterPanel.getStartDate();
        if ( dateSelected == null ) return null;
        return new SimpleDateFormat("yyyy-MM-dd").format(dateSelected);
    }
    
    public String getEndDate() {
        Date dateSelected = dateFilterPanel.getEndDate();
        if ( dateSelected == null ) return null;
        return new SimpleDateFormat("yyyy-MM-dd").format(dateSelected);
    }
    
    public int getQuantityProduct() {
        int quantity = Integer.parseInt(quantityPriceView.quantityTxt.getText().trim());
        return quantity;
    }
    
    public double getPriceProduct() {
        double price = Double.parseDouble(quantityPriceView.priceTxt.getText().trim());
        return price;
    }
    
    public String getProductSearched() {
        String productSearched = createView.searchProductTxt.getText().trim();
        if ( productSearched.equals("Buscar productos por nombre")) return null;
        return productSearched;
    }
    
}
