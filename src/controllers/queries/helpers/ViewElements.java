package controllers.queries.helpers;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import views.queries.ProductsHighestRetribution;
import views.queries.ProductsLowRotation;
import views.queries.ProductsLowStock;
import views.queries.ProductsMostSold;

public class ViewElements {

    private final ProductsLowRotation productsLowRotationView;
    private final ProductsLowStock productsLowStockView;
    private final ProductsHighestRetribution productsHighestRetribution;
    private final ProductsMostSold productsMostSoldView;

    public ViewElements(
            ProductsLowRotation productsLowRotationView,
            ProductsLowStock productsLowStockView,
            ProductsHighestRetribution productsHighestRetribution,
            ProductsMostSold productsMostSoldView
    ) {
        this.productsLowRotationView = productsLowRotationView;
        this.productsLowStockView = productsLowStockView;
        this.productsHighestRetribution = productsHighestRetribution;
        this.productsMostSoldView = productsMostSoldView;
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

    private void updateChart(JPanel panel, ChartPanel chart) {
        panel.removeAll();
        panel.setLayout(new BorderLayout());
        panel.add(chart, BorderLayout.CENTER);
        panel.revalidate();
        panel.repaint();
    }
}
