package controllers.queries;

import controllers.queries.helpers.InputReader;
import controllers.queries.helpers.QueriesCharts;
import controllers.queries.helpers.ViewElements;
import entities.Product;
import models.StatsModel;
import services.QueriesService;
import views.queries.ProductsHighestRetribution;
import views.queries.ProductsLowRotation;
import views.queries.ProductsLowStock;
import views.queries.ProductsMostSold;
import views.queries.PurchasesAvgSaleMonth;
import views.queries.PurchasesMontlyGrow;
import views.queries.PurchasesTopMonths;
import views.queries.PurchasesTopMonthsSales;
import views.queries.Queries;

public class QueriesController {
    
    private final Queries view;
    private final ProductsLowRotation productsLowRotationView;
    private final ProductsLowStock productsLowStockView;
    private final ProductsHighestRetribution productsHighestRetribution;
    private final ProductsMostSold productsMostSoldView;
    private final PurchasesMontlyGrow montlyGrowView;
    private final PurchasesTopMonths topMonthsView;
    private final PurchasesTopMonthsSales topMonthsSalesView;
    private final PurchasesAvgSaleMonth avgSaleMonthView;
    
    private final StatsModel statsModel;
    
    private final QueriesService queriesService;
    
    private final ViewElements elements;
    private final InputReader inputReader;

    public QueriesController(Queries view, StatsModel statsModel) {
        this.view = view;
        this.productsLowRotationView = new ProductsLowRotation();
        this.productsLowStockView = new ProductsLowStock();
        this.productsHighestRetribution = new ProductsHighestRetribution();
        this.productsMostSoldView = new ProductsMostSold();
        this.montlyGrowView = new PurchasesMontlyGrow();
        this.topMonthsView = new PurchasesTopMonths();
        this.topMonthsSalesView = new PurchasesTopMonthsSales();
        this.avgSaleMonthView = new PurchasesAvgSaleMonth();
        
        this.statsModel = statsModel;
        
        this.queriesService = new QueriesService(this.statsModel);
        
        this.elements = new ViewElements(
                productsLowRotationView,
                productsLowStockView,
                productsHighestRetribution,
                productsMostSoldView,
                montlyGrowView,
                topMonthsView,
                topMonthsSalesView,
                avgSaleMonthView
        );
        
        this.inputReader = new InputReader(
                productsLowRotationView, 
                productsMostSoldView,
                montlyGrowView,
                topMonthsView,
                topMonthsSalesView,
                avgSaleMonthView
        );
        
        init();
        initListeners();
    }
    
    private void init() {
        
    }
    
    private void initListeners() {   
        view.btnProductsLowRotation.addActionListener(e -> showChartProductsLowRotation());
        view.btnProductsLowStock.addActionListener(e -> showChartProductsLowStock());
        view.btnProductsEarn.addActionListener(e -> showChartMostProfitableProducts());
        view.btnProductsSold.addActionListener(e -> showChartMostSoldProductsInMonth());
        
        view.btnGrowMontly.addActionListener(e -> showChartMontlySalesGrowth());
        view.btnGrowBestMonths.addActionListener(e -> showChartTopMonths());
        view.btnGrowMostQuantity.addActionListener(e -> showChartTopMonthsSales());
        view.btnGrowAvgMonth.addActionListener(e -> showChartAvgSalePerMonth());
        
        avgSaleMonthView.quantityCombo.addActionListener(e -> createChartAvgSalePerMonth());
        topMonthsSalesView.quantityCombo.addActionListener(e -> createChartTopMonthsSales());
        topMonthsView.quantityCombo.addActionListener(e -> createChartTopMonths());
        montlyGrowView.quantityCombo.addActionListener(e -> createChartMontlyGrowthSales());
        productsMostSoldView.quantityCombo.addActionListener(e -> createChartMostSoldProductsInMonth());
        productsLowRotationView.quantityCombo.addActionListener(e -> createChartProductsLowRotation());
        
    }
    
    private void createChartProductsLowRotation() {
        int quantityToWatch = inputReader.getQuantityProductsLowRotation();
        elements.setProductsLowRotationChart(QueriesCharts.createProductBarChart(
                queriesService.getProductsLowRotation(quantityToWatch), 
                "Productos con baja rotación",
                Product::getProductStock
        ));
    }
    
    private void createChartProductsLowStock() {
        elements.setProductsLowStockChart(QueriesCharts.createProductBarChart(
                queriesService.getProductsLowStock(), 
                "Productos con bajo stock",
                Product::getProductStockMin
        ));
    }
    
    private void createChartMostProfitableProducts() {
        elements.setProductsMostProfitableChart(QueriesCharts.createMostProfitableProductsChart(
                queriesService.getMostProfitableProducts(), 
                "Productos más rentables"
        ));
    }
    
    private void createChartMostSoldProductsInMonth() {
       int quantityToWatch = inputReader.getQuantityProductsMostSold();
       elements.setProductsMostSoldChart(QueriesCharts.createTopSellingProductsPieChart(
               queriesService.getTopSellingProductsOfMonth(quantityToWatch), 
               "Products más vendidos en el més"
       ));
    }
    
    private void createChartMontlyGrowthSales() {
       int quantityToWatch = inputReader.getQuantityMonthsToSeeGrown();
       elements.setMontlySalesChart(QueriesCharts.createMonthlyGrowthLineChart(
               queriesService.getMonthlyGrowth(quantityToWatch)
       ));
    }
    
    private void createChartTopMonths() {
        int quantityToWatch = inputReader.getQuantityMonthsTopMonths();
        elements.setTopMonthsChart(QueriesCharts.createTopSalesMonthsChart(
               queriesService.getTopMonths(quantityToWatch)
        ));
    }
    
    private void createChartTopMonthsSales() {
        int quantityToWatch = inputReader.getQuantityMonthsTopMonthsSales();
        elements.setTopMonthsSalesChart(QueriesCharts.createTopSalesCountMonthsChart(
               queriesService.getTopSalesMontly(quantityToWatch)
        ));
    }
    
    private void createChartAvgSalePerMonth() {
        int quantityToWatch = inputReader.getQuantityMonthsAvgSaleMonth();
        elements.setAvgSalePerMonthChart(QueriesCharts.createAverageDailySalesBarChart(
               queriesService.getAvgSaleMonthly(quantityToWatch)
        ));
    }
    
    private void showChartProductsLowStock() {
        productsLowStockView.setVisible(true);
        createChartProductsLowStock();
    }
    
    private void showChartProductsLowRotation() {
        productsLowRotationView.setVisible(true);
        createChartProductsLowRotation();
    }
    
    private void showChartMostProfitableProducts() {
        productsHighestRetribution.setVisible(true);
        createChartMostProfitableProducts();
    }
    
    private void showChartMostSoldProductsInMonth() {
        productsMostSoldView.setVisible(true);
        createChartMostSoldProductsInMonth();
    }
    
    private void showChartMontlySalesGrowth() {
        montlyGrowView.setVisible(true);
        createChartMontlyGrowthSales();
    }
    
    private void showChartTopMonths() {
        topMonthsView.setVisible(true);
        createChartTopMonths();
    }
    
    private void showChartTopMonthsSales() {
        topMonthsSalesView.setVisible(true);
        createChartTopMonthsSales();
    }
    
    private void showChartAvgSalePerMonth() {
        avgSaleMonthView.setVisible(true);
        createChartAvgSalePerMonth();
    }
    
}
