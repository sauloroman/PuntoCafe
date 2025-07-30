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
import views.queries.Queries;

public class QueriesController {
    
    private final Queries view;
    private final ProductsLowRotation productsLowRotationView;
    private final ProductsLowStock productsLowStockView;
    private final ProductsHighestRetribution productsHighestRetribution;
    private final ProductsMostSold productsMostSoldView;
    
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
        
        this.statsModel = statsModel;
        
        this.queriesService = new QueriesService(this.statsModel);
        
        this.elements = new ViewElements(
                productsLowRotationView,
                productsLowStockView,
                productsHighestRetribution,
                productsMostSoldView
        );
        this.inputReader = new InputReader(productsLowRotationView, productsMostSoldView);
        
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
    
}
