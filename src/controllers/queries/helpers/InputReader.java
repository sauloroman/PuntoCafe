package controllers.queries.helpers;

import views.queries.ProductsLowRotation;
import views.queries.ProductsMostSold;
import views.queries.PurchasesRotation;
import views.queries.PurchasesTopSuppliers;
import views.queries.Queries;
import views.queries.SalesAvgSaleMonth;
import views.queries.SalesMontlyGrow;
import views.queries.SalesTopMonths;
import views.queries.SalesTopMonthsSales;

public class InputReader {
    
    private final Queries view;
    private final ProductsLowRotation productsLowRotationView;
    private final ProductsMostSold productsMostSoldView;
    private final SalesMontlyGrow montlyGrowView;
    private final SalesTopMonths topMonthsView;
    private final SalesTopMonthsSales topMonthsSalesView;
    private final SalesAvgSaleMonth avgSaleMonthView;
    private final PurchasesRotation rotationView;
    private final PurchasesTopSuppliers topSuppliersView;

    public InputReader(
            Queries view,
            ProductsLowRotation productsLowRotationView,
            ProductsMostSold productsMostSold,
            SalesMontlyGrow montlyGrowView,
            SalesTopMonths topMonthsView,
            SalesTopMonthsSales topMonthsSalesView,
            SalesAvgSaleMonth avgSaleMonthView,
            PurchasesRotation rotationView,
            PurchasesTopSuppliers topSuppliersView
    ) {
        this.view = view;
        this.productsLowRotationView = productsLowRotationView;
        this.productsMostSoldView = productsMostSold;
        this.montlyGrowView = montlyGrowView;
        this.topMonthsView = topMonthsView;
        this.topMonthsSalesView = topMonthsSalesView;
        this.avgSaleMonthView = avgSaleMonthView;
        this.rotationView = rotationView;
        this.topSuppliersView = topSuppliersView;
    }
    
    public int getQuantityMonthsComparativeSalesPurchases() {
        return Integer.parseInt(view.timeBox.getSelectedItem().toString());
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
    
    public int getQuantityProductsRotation() {
        return Integer.parseInt(rotationView.quantityCombo.getSelectedItem().toString());
    }
    
    public int getQuantityTopSuppliers() {
        return Integer.parseInt(topSuppliersView.quantityCombo.getSelectedItem().toString());
    }
    
}

