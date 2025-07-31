package controllers.queries.helpers;

import views.queries.ProductsLowRotation;
import views.queries.ProductsMostSold;
import views.queries.PurchasesAvgSaleMonth;
import views.queries.PurchasesMontlyGrow;
import views.queries.PurchasesTopMonths;
import views.queries.PurchasesTopMonthsSales;

public class InputReader {
    
    private final ProductsLowRotation productsLowRotationView;
    private final ProductsMostSold productsMostSoldView;
    private final PurchasesMontlyGrow montlyGrowView;
    private final PurchasesTopMonths topMonthsView;
    private final PurchasesTopMonthsSales topMonthsSalesView;
    private final PurchasesAvgSaleMonth avgSaleMonthView;

    public InputReader(
            ProductsLowRotation productsLowRotationView,
            ProductsMostSold productsMostSold,
            PurchasesMontlyGrow montlyGrowView,
            PurchasesTopMonths topMonthsView,
            PurchasesTopMonthsSales topMonthsSalesView,
            PurchasesAvgSaleMonth avgSaleMonthView
    ) {
        this.productsLowRotationView = productsLowRotationView;
        this.productsMostSoldView = productsMostSold;
        this.montlyGrowView = montlyGrowView;
        this.topMonthsView = topMonthsView;
        this.topMonthsSalesView = topMonthsSalesView;
        this.avgSaleMonthView = avgSaleMonthView;
    }
    
    public int getQuantityProductsLowRotation() {
        return Integer.parseInt(productsLowRotationView.quantityCombo.getSelectedItem().toString());
    }
    
    public int getQuantityProductsMostSold() {
        return Integer.parseInt(productsMostSoldView.quantityCombo.getSelectedItem().toString());
    }
    
    public int getQuantityMonthsToSeeGrown() {
        return Integer.parseInt(montlyGrowView.quantityCombo.getSelectedItem().toString());
    }
    
    public int getQuantityMonthsTopMonths() {
        return Integer.parseInt(topMonthsView.quantityCombo.getSelectedItem().toString());
    }
    
    public int getQuantityMonthsTopMonthsSales() {
        return Integer.parseInt(topMonthsSalesView.quantityCombo.getSelectedItem().toString());
    }
    
    public int getQuantityMonthsAvgSaleMonth() {
        return Integer.parseInt(avgSaleMonthView.quantityCombo.getSelectedItem().toString());
    }
    
}
