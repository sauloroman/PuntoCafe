package controllers.queries.helpers;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import views.queries.ProductsHighestRetribution;
import views.queries.ProductsLowRotation;
import views.queries.ProductsLowStock;
import views.queries.ProductsMostSold;
import views.queries.PurchasesAvgSaleMonth;
import views.queries.PurchasesMontlyGrow;
import views.queries.PurchasesTopMonths;
import views.queries.PurchasesTopMonthsSales;

public class ViewElements {

    private final ProductsLowRotation productsLowRotationView;
    private final ProductsLowStock productsLowStockView;
    private final ProductsHighestRetribution productsHighestRetribution;
    private final ProductsMostSold productsMostSoldView;
    private final PurchasesMontlyGrow purchasesMontlyGrowView;
    private final PurchasesTopMonths topMonthsView;
    private final PurchasesTopMonthsSales topMonthsSalesView;
    private final PurchasesAvgSaleMonth avgSaleMonthView;

    public ViewElements(
            ProductsLowRotation productsLowRotationView,
            ProductsLowStock productsLowStockView,
            ProductsHighestRetribution productsHighestRetribution,
            ProductsMostSold productsMostSoldView,
            PurchasesMontlyGrow purchasesMontlyGrowView,
            PurchasesTopMonths topMonthsView,
            PurchasesTopMonthsSales topMonthsSalesView,
            PurchasesAvgSaleMonth avgSaleMonthView
    ) {
        this.productsLowRotationView = productsLowRotationView;
        this.productsLowStockView = productsLowStockView;
        this.productsHighestRetribution = productsHighestRetribution;
        this.productsMostSoldView = productsMostSoldView;
        this.purchasesMontlyGrowView = purchasesMontlyGrowView;
        this.topMonthsView = topMonthsView;
        this.topMonthsSalesView = topMonthsSalesView;
        this.avgSaleMonthView = avgSaleMonthView;
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

    private void updateChart(JPanel panel, ChartPanel chart) {
        panel.removeAll();
        panel.setLayout(new BorderLayout());
        panel.add(chart, BorderLayout.CENTER);
        panel.revalidate();
        panel.repaint();
    }
}
