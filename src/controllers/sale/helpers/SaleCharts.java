package controllers.sale.helpers;

import entities.MontlyMoney;
import entities.SoldCategoryTotal;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.RingPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class SaleCharts {
    
    public static ChartPanel createMonthlyBarChart(List<MontlyMoney> monthlySales, String title) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (MontlyMoney ms : monthlySales) {
            dataset.addValue(ms.getTotalAmount(), title, ms.getMonth());
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                null, 
                null,
                null,
                dataset
        );

        Font font = new Font("SansSerif", Font.PLAIN, 10);
        CategoryPlot plot = barChart.getCategoryPlot();
        plot.getDomainAxis().setTickLabelFont(font);
        plot.getDomainAxis().setLabelFont(font);
        plot.getRangeAxis().setTickLabelFont(font);
        plot.getRangeAxis().setLabelFont(font);

        barChart.removeLegend();

        barChart.setBackgroundPaint(Color.WHITE);
        plot.setBackgroundPaint(Color.WHITE);
        plot.setRangeGridlinePaint(Color.LIGHT_GRAY); 

        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        Color softPurplePink = new Color(193, 150, 255); 
        renderer.setSeriesPaint(0, softPurplePink);

        renderer.setDrawBarOutline(false); 
        renderer.setShadowVisible(false); 
        renderer.setBarPainter(new StandardBarPainter()); 

        renderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(390, 200));
        chartPanel.setBackground(Color.WHITE);
        chartPanel.setDisplayToolTips(true); 
        
        return chartPanel;
    }    
    
    public static ChartPanel createItemsDonutChart(List<SoldCategoryTotal> categoryTotals) {
        DefaultPieDataset dataset = new DefaultPieDataset();

        for (SoldCategoryTotal item : categoryTotals) {
            dataset.setValue(item.getCategory(), item.getCount());
        }

        JFreeChart donutChart = ChartFactory.createRingChart(
                null, 
                dataset,
                false, 
                true, 
                false
        );

        RingPlot plot = (RingPlot) donutChart.getPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setOutlineVisible(false);
        plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
        plot.setLabelBackgroundPaint(Color.WHITE);
        plot.setLabelOutlinePaint(null);
        plot.setLabelShadowPaint(null);
        plot.setSectionDepth(0.35);
        plot.setSeparatorPaint(new Color(0,0,0,0));
        plot.setShadowPaint(null);

        Color[] colors = { new Color(193, 150, 255), new Color(255, 243, 191) };
        int i = 0;
        for (Object key : dataset.getKeys()) {
            plot.setSectionPaint((Comparable) key, colors[i % colors.length]);
            i++;
        }

        ChartPanel chartPanel = new ChartPanel(donutChart);
        chartPanel.setPreferredSize(new Dimension(390, 200));

        return chartPanel;
    }
    
}
