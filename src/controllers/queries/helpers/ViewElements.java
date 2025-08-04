package controllers.queries.helpers;

import java.awt.BorderLayout;
import java.math.BigDecimal;
import java.util.Map;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import views.queries.ProductsHighestRetribution;
import views.queries.ProductsLowRotation;
import views.queries.ProductsLowStock;
import views.queries.ProductsMostSold;
import views.queries.PurchasesProductsNoSold;
import views.queries.PurchasesRotation;
import views.queries.PurchasesTopMonths;
import views.queries.PurchasesTopSuppliers;
import views.queries.Queries;
import views.queries.SalesAvgSaleMonth;
import views.queries.SalesMontlyGrow;
import views.queries.SalesTopMonths;
import views.queries.SalesTopMonthsSales;

public class ViewElements {

    private final Queries view;
    private final ProductsLowRotation productsLowRotationView;
    private final ProductsLowStock productsLowStockView;
    private final ProductsHighestRetribution productsHighestRetribution;
    private final ProductsMostSold productsMostSoldView;
    private final SalesMontlyGrow purchasesMontlyGrowView;
    private final SalesTopMonths topMonthsView;
    private final SalesTopMonthsSales topMonthsSalesView;
    private final SalesAvgSaleMonth avgSaleMonthView;
    private final PurchasesRotation rotationView;
    private final PurchasesProductsNoSold unsoldProductsView;
    private final PurchasesTopSuppliers topSuppliersView;
    private final PurchasesTopMonths topMonthsPurchasesView;

    public ViewElements(
            Queries view,
            ProductsLowRotation productsLowRotationView,
            ProductsLowStock productsLowStockView,
            ProductsHighestRetribution productsHighestRetribution,
            ProductsMostSold productsMostSoldView,
            SalesMontlyGrow purchasesMontlyGrowView,
            SalesTopMonths topMonthsView,
            SalesTopMonthsSales topMonthsSalesView,
            SalesAvgSaleMonth avgSaleMonthView,
            PurchasesRotation rotationView,
            PurchasesProductsNoSold unsoldProductsView,
            PurchasesTopSuppliers topSuppliersView,
            PurchasesTopMonths topMonthsPurchasesView
    ) {
        this.view = view;
        this.productsLowRotationView = productsLowRotationView;
        this.productsLowStockView = productsLowStockView;
        this.productsHighestRetribution = productsHighestRetribution;
        this.productsMostSoldView = productsMostSoldView;
        this.purchasesMontlyGrowView = purchasesMontlyGrowView;
        this.topMonthsView = topMonthsView;
        this.topMonthsSalesView = topMonthsSalesView;
        this.avgSaleMonthView = avgSaleMonthView;
        this.rotationView = rotationView;
        this.unsoldProductsView = unsoldProductsView;
        this.topSuppliersView = topSuppliersView;
        this.topMonthsPurchasesView = topMonthsPurchasesView;
    }
    
    public void setPurchasesSalesComparative(ChartPanel chart) {
        updateChart(view.salesAndPurchasesGraph, chart);
    }

    public void setProductsLowRotationChart(ChartPanel chart) {
        updateChart(productsLowRotationView.panelGraph, chart);
    }

    public void setProductsLowStockChart(ChartPanel chart) {
        updateChart(productsLowStockView.panelGraph, chart);
    }

    public void setProductsMostProfitableChart(ChartPanel chart) {
        updateChart(productsHighestRetribution.panelGraph, chart);
    }

    public void setProductsMostSoldChart(ChartPanel chart) {
        updateChart(productsMostSoldView.panelGraph, chart);
    }
    
    public void setMontlySalesChart(ChartPanel chart) {
        updateChart(purchasesMontlyGrowView.panelGraph, chart);
    }
    
    public void setTopMonthsChart(ChartPanel chart) {
        updateChart(topMonthsView.panelGraph, chart);
    }
    
    public void setTopMonthsSalesChart(ChartPanel chart) {
        updateChart(topMonthsSalesView.panelGraph, chart);
    }
    
    public void setAvgSalePerMonthChart(ChartPanel chart) {
        updateChart(avgSaleMonthView.panelGraph, chart);
    }
    
    public void setRotationProductsChart(ChartPanel chart) {
        updateChart(rotationView.panelGraph, chart);
    }
    
    public void setTopSuppliersChart(ChartPanel chart) {
        updateChart(topSuppliersView.panelGraph, chart);
    }
    
    public void setTopMonthsPurchasesChart(ChartPanel chart) {
        updateChart(topMonthsPurchasesView.panelGraph, chart);
    }
    
    public void setUnsoldProductsList(JPanel panel) {
        unsoldProductsView.panelGraph.removeAll();
        unsoldProductsView.panelGraph.setLayout(new BorderLayout());
        unsoldProductsView.panelGraph.add(panel);
        unsoldProductsView.panelGraph.revalidate();
        unsoldProductsView.panelGraph.repaint();
    }

    public void setEstimatedNetProfit(BigDecimal quantity) {
        view.earnMoney.setText("$" + String.format("%.2f", quantity));
    }
    
    public void setMonthlyGrowthPercentage(double growth) {
        view.growPercentage.setText(String.format("%%%.2f", growth));
        view.labelComparativeMonth.setText(growth > 0 ? "+ mes anterior" : "- mes anterior");
    }
    
    public void setTopSellingProduct(Map<String, Integer> topProduct) {
        if ( topProduct != null && !topProduct.isEmpty() ) {
            Map.Entry<String, Integer> entry = topProduct.entrySet().iterator().next();
            
            String nameProduct = entry.getKey();
            int quantitySold = entry.getValue();
            
            view.quantityBestProduct.setText(quantitySold + "");
            view.bestProduct.setText(nameProduct);
        }
    }
    
    public void setTopSellerUser(Map<String, Integer> user) {
        if ( user != null && !user.isEmpty() ) {
            Map.Entry<String, Integer> entry = user.entrySet().iterator().next();
            
            String username = entry.getKey();
            int quantitySales = entry.getValue();
            
            view.bestUser.setText(username);
            view.quantityBestSalesUser.setText(quantitySales + "");
        }
    }
    
    private void updateChart(JPanel panel, ChartPanel chart) {
        panel.removeAll();
        panel.setLayout(new BorderLayout());
        panel.add(chart, BorderLayout.CENTER);
        panel.revalidate();
        panel.repaint();
    }
}
