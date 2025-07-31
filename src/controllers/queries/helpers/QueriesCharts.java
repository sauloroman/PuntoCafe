package controllers.queries.helpers;

import entities.Product;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.function.ToDoubleFunction;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.RingPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
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
    
    public static ChartPanel createMonthlyGrowthLineChart(Map<String, Double> growthData) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Map.Entry<String, Double> entry : growthData.entrySet()) {
            dataset.addValue(entry.getValue(), "Crecimiento", entry.getKey());
        }

        JFreeChart lineChart = ChartFactory.createLineChart(
                null,                  
                "Mes",                 
                "% Crecimiento",       
                dataset,
                PlotOrientation.VERTICAL,
                false, true, false
        );

        Font font = new Font("SansSerif", Font.PLAIN, 10);
        CategoryPlot plot = lineChart.getCategoryPlot();
        plot.getDomainAxis().setTickLabelFont(font);
        plot.getDomainAxis().setLabelFont(font);
        plot.getRangeAxis().setTickLabelFont(font);
        plot.getRangeAxis().setLabelFont(font);

        lineChart.setBackgroundPaint(Color.WHITE);
        plot.setBackgroundPaint(Color.WHITE);
        plot.setRangeGridlinePaint(Color.LIGHT_GRAY);

        var renderer = plot.getRenderer();
        renderer.setSeriesPaint(0, new Color(100, 149, 237));
        renderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());

        ChartPanel chartPanel = new ChartPanel(lineChart);
        chartPanel.setPreferredSize(new Dimension(660, 490));
        chartPanel.setBackground(Color.WHITE);
        chartPanel.setDisplayToolTips(true);

        return chartPanel;
    }
    
    public static ChartPanel createTopSalesMonthsChart(Map<String, Double> monthSales) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Map.Entry<String, Double> entry : monthSales.entrySet()) {
            dataset.addValue(entry.getValue(), "Ventas", entry.getKey());
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                null,
                "Mes",
                "Total de Ventas",
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
        renderer.setSeriesPaint(0, new Color(135, 206, 250)); // azul suave
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
    
    public static ChartPanel createTopSalesCountMonthsChart(Map<String, Integer> salesCount) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Map.Entry<String, Integer> entry : salesCount.entrySet()) {
            dataset.addValue(entry.getValue(), "Ventas", entry.getKey());
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                null,
                "Mes",
                "Cantidad de Ventas",
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
        renderer.setSeriesPaint(0, new Color(255, 200, 87)); // tono amarillo suave
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
    
    public static ChartPanel createAverageDailySalesBarChart(Map<String, Double> avgSales) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Map.Entry<String, Double> entry : avgSales.entrySet()) {
            dataset.addValue(entry.getValue(), "Promedio Diario", entry.getKey());
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                null,
                "Mes",
                "Promedio Diario ($)",
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
        renderer.setSeriesPaint(0, new Color(173, 216, 230)); 
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
    
    public static ChartPanel createAvgTimeBetweenPurchaseAndSaleChart(Map<String, Double> avgDaysMap) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Map.Entry<String, Double> entry : avgDaysMap.entrySet()) {
            String productName = entry.getKey();
            if (productName.length() > 15) {
                productName = productName.substring(0, 13) + "...";
            }
            dataset.addValue(entry.getValue(), "Días Promedio", productName);
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                null,
                "Producto",
                "Días Promedio",
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
        renderer.setSeriesPaint(0, new Color(255, 160, 122));
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

    public static ChartPanel createSupplierInvestmentDonutChart(Map<String, Double> supplierInvestmentMap) {
        DefaultPieDataset dataset = new DefaultPieDataset();

        for (Map.Entry<String, Double> entry : supplierInvestmentMap.entrySet()) {
            dataset.setValue(entry.getKey(), entry.getValue());
        }

        JFreeChart chart = ChartFactory.createRingChart(
                null,
                dataset,
                false,
                true,
                false
        );

        RingPlot plot = (RingPlot) chart.getPlot();
        plot.setSectionDepth(0.35);
        plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 11));
        plot.setLabelPaint(new Color(80, 80, 80)); // gris claro para etiquetas
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}: ${1}"));
        plot.setOutlineVisible(false);
        plot.setBackgroundPaint(Color.WHITE);
        plot.setSectionOutlinesVisible(false);
        plot.setShadowPaint(null);

        chart.setBackgroundPaint(Color.WHITE);

        Color[] colors = {
            new Color(135, 206, 250), 
            new Color(255, 160, 122), 
            new Color(144, 238, 144), 
            new Color(255, 218, 185), 
            new Color(221, 160, 221), 
            new Color(240, 230, 140), 
            new Color(176, 196, 222), 
            new Color(255, 182, 193), 
            new Color(152, 251, 152), 
            new Color(210, 180, 140)  
        };

        int i = 0;
        for (Object keyObj : dataset.getKeys()) {
            Comparable<?> key = (Comparable<?>) keyObj;
            plot.setSectionPaint(key, colors[i % colors.length]);
            i++;
        }

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(660, 490));
        chartPanel.setBackground(Color.WHITE);

        return chartPanel;
    }
    
    public static ChartPanel createTopPurchasesLineChart(Map<String, Integer> purchasesPerMonth) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Map.Entry<String, Integer> entry : purchasesPerMonth.entrySet()) {
            dataset.addValue(entry.getValue(), "Compras", entry.getKey());
        }

        JFreeChart lineChart = ChartFactory.createLineChart(
                null,
                "Mes",
                "Total de Compras",
                dataset,
                PlotOrientation.VERTICAL,
                false, true, false
        );

        Font font = new Font("SansSerif", Font.PLAIN, 10);
        CategoryPlot plot = lineChart.getCategoryPlot();
        plot.getDomainAxis().setTickLabelFont(font);
        plot.getDomainAxis().setLabelFont(font);
        plot.getRangeAxis().setTickLabelFont(font);
        plot.getRangeAxis().setLabelFont(font);

        lineChart.setBackgroundPaint(Color.WHITE);
        plot.setBackgroundPaint(Color.WHITE);
        plot.setRangeGridlinePaint(Color.LIGHT_GRAY);

        var renderer = plot.getRenderer();
        renderer.setSeriesPaint(0, new Color(72, 201, 176));
        renderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());

        ChartPanel chartPanel = new ChartPanel(lineChart);
        chartPanel.setPreferredSize(new Dimension(660, 490));
        chartPanel.setBackground(Color.WHITE);
        chartPanel.setDisplayToolTips(true);

        return chartPanel;
    }
    
    public static ChartPanel createMonthlySalesVsPurchasesLineChart(Map<String, Map<String, BigDecimal>> data) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Map.Entry<String, Map<String, BigDecimal>> entry : data.entrySet()) {
            String month = entry.getKey();
            Map<String, BigDecimal> values = entry.getValue();

            BigDecimal sales = values.getOrDefault("venta", BigDecimal.ZERO);
            BigDecimal purchases = values.getOrDefault("compra", BigDecimal.ZERO);

            dataset.addValue(sales, "Ventas", month);
            dataset.addValue(purchases, "Compras", month);
        }

        JFreeChart chart = ChartFactory.createLineChart(
            null,                
            "Fecha",            
            "Total ($)",        
            dataset,            
            PlotOrientation.VERTICAL,
            true,               
            true,
            false
        );

        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setOutlineVisible(false);
        plot.setRangeGridlinePaint(Color.LIGHT_GRAY);

        Font font = new Font("SansSerif", Font.PLAIN, 11);
        plot.getDomainAxis().setTickLabelFont(font);
        plot.getRangeAxis().setTickLabelFont(font);
        plot.getDomainAxis().setLabelFont(font);
        plot.getRangeAxis().setLabelFont(font);

        LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
        renderer.setSeriesStroke(0, new BasicStroke(2.5f)); // Ventas
        renderer.setSeriesStroke(1, new BasicStroke(2.5f)); // Compras

        chart.setBackgroundPaint(Color.WHITE);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(778, 500));
        chartPanel.setBackground(Color.WHITE);

        return chartPanel;
    }
    
    public static ChartPanel createLowRotationProductsBarChart(List<Product> products) {
        return createProductBarChart(products, "Productos con baja rotación", Product::getProductStock);
    }

    public static ChartPanel createLowStockProductsBarChart(List<Product> products) {
        return createProductBarChart(products, "Productos con stock crítico", Product::getProductStockMin);
    }
}
