package controllers.queries.helpers;

import entities.Product;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import java.util.Map;
import java.util.function.ToDoubleFunction;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class QueriesCharts {

    public static ChartPanel createProductBarChart(
            List<Product> products,
            String chartTitle,
            ToDoubleFunction<Product> valueExtractor
    ) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Product product : products) {
            dataset.addValue(valueExtractor.applyAsDouble(product), "Productos", product.getProductName());
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                null, null, null,
                dataset,
                PlotOrientation.HORIZONTAL,
                false, true, false
        );

        Font font = new Font("SansSerif", Font.PLAIN, 10);
        CategoryPlot plot = barChart.getCategoryPlot();
        plot.getDomainAxis().setTickLabelFont(font);
        plot.getDomainAxis().setLabelFont(font);
        plot.getRangeAxis().setTickLabelFont(font);
        plot.getRangeAxis().setLabelFont(font);

        barChart.setBackgroundPaint(Color.WHITE);
        plot.setBackgroundPaint(Color.WHITE);
        plot.setRangeGridlinePaint(Color.LIGHT_GRAY);

        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, new Color(255, 180, 180));
        renderer.setDrawBarOutline(false);
        renderer.setShadowVisible(false);
        renderer.setBarPainter(new StandardBarPainter());
        renderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(660, 490));
        chartPanel.setBackground(Color.WHITE);
        chartPanel.setDisplayToolTips(true);

        return chartPanel;
    }
    
    public static ChartPanel createMostProfitableProductsChart(Map<String, Double> profits, String title) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Map.Entry<String, Double> entry : profits.entrySet()) {
            dataset.addValue(entry.getValue(), "Utilidad", entry.getKey());
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                null,
                null,
                "Ganancia",
                dataset,
                PlotOrientation.VERTICAL,
                false, true, false
        );

        Font font = new Font("SansSerif", Font.PLAIN, 10);
        CategoryPlot plot = barChart.getCategoryPlot();
        plot.getDomainAxis().setTickLabelFont(font);
        plot.getDomainAxis().setLabelFont(font);
        plot.getRangeAxis().setTickLabelFont(font);
        plot.getRangeAxis().setLabelFont(font);

        barChart.setBackgroundPaint(Color.WHITE);
        plot.setBackgroundPaint(Color.WHITE);
        plot.setRangeGridlinePaint(Color.LIGHT_GRAY);

        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, new Color(144, 238, 144)); 
        renderer.setDrawBarOutline(false);
        renderer.setShadowVisible(false);
        renderer.setBarPainter(new StandardBarPainter());
        renderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(860, 490));
        chartPanel.setBackground(Color.WHITE);
        chartPanel.setDisplayToolTips(true);

        return chartPanel;
    }

    public static ChartPanel createTopSellingProductsPieChart(Map<String, Integer> sales, String title) {
        DefaultPieDataset dataset = new DefaultPieDataset();

        for (Map.Entry<String, Integer> entry : sales.entrySet()) {
            dataset.setValue(entry.getKey(), entry.getValue());
        }

        JFreeChart pieChart = ChartFactory.createPieChart(
                null,
                dataset,
                true,
                true,
                false
        );

        pieChart.setBackgroundPaint(Color.WHITE);
        pieChart.setBorderVisible(false);

        PiePlot plot = (PiePlot) pieChart.getPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setOutlineVisible(false);

        plot.setLabelBackgroundPaint(null);  
        plot.setLabelOutlinePaint(null);     
        plot.setLabelShadowPaint(null);      

        ChartPanel chartPanel = new ChartPanel(pieChart);
        chartPanel.setPreferredSize(new Dimension(660, 490));
        chartPanel.setBackground(Color.WHITE);
        chartPanel.setBorder(null);

        return chartPanel;
    }


    public static ChartPanel createLowRotationProductsBarChart(List<Product> products) {
        return createProductBarChart(products, "Productos con baja rotación", Product::getProductStock);
    }

    public static ChartPanel createLowStockProductsBarChart(List<Product> products) {
        return createProductBarChart(products, "Productos con stock crítico", Product::getProductStockMin);
    }
}
