package controllers.queries;

import controllers.queries.helpers.InputReader;
import controllers.queries.helpers.QueriesCharts;
import controllers.queries.helpers.ViewElements;
import entities.Product;
import models.StatsModel;
import services.QueriesService;
import views.components.UnsoldProductsList;
import views.queries.ProductsHighestRetribution;
import views.queries.ProductsLowRotation;
import views.queries.ProductsLowStock;
import views.queries.ProductsMostSold;
import views.queries.PurchasesProductsNoSold;
import views.queries.PurchasesRotation;
import views.queries.PurchasesTopMonths;
import views.queries.PurchasesTopSuppliers;
import views.queries.SalesAvgSaleMonth;
import views.queries.SalesMontlyGrow;
import views.queries.SalesTopMonths;
import views.queries.SalesTopMonthsSales;
import views.queries.Queries;

public class QueriesController {
    
    private final Queries view;
    private final ProductsLowRotation productsLowRotationView;
    private final ProductsLowStock productsLowStockView;
    private final ProductsHighestRetribution productsHighestRetribution;
    private final ProductsMostSold productsMostSoldView;
    private final SalesMontlyGrow montlyGrowView;
    private final SalesTopMonths topMonthsView;
    private final SalesTopMonthsSales topMonthsSalesView;
    private final SalesAvgSaleMonth avgSaleMonthView;
    private final PurchasesRotation rotationView;
    private final PurchasesProductsNoSold unsoldProductsView;
    private final PurchasesTopSuppliers topSuppliersView;
    private final PurchasesTopMonths topMonthsPurchasesView;
    
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
        this.montlyGrowView = new SalesMontlyGrow();
        this.topMonthsView = new SalesTopMonths();
        this.topMonthsSalesView = new SalesTopMonthsSales();
        this.avgSaleMonthView = new SalesAvgSaleMonth();
        this.rotationView = new PurchasesRotation();
        this.unsoldProductsView = new PurchasesProductsNoSold();
        this.topSuppliersView = new PurchasesTopSuppliers();
        this.topMonthsPurchasesView = new PurchasesTopMonths();
        
        this.statsModel = statsModel;
        
        this.queriesService = new QueriesService(this.statsModel);
        
        this.elements = new ViewElements(
                view,
                productsLowRotationView,
                productsLowStockView,
                productsHighestRetribution,
                productsMostSoldView,
                montlyGrowView,
                topMonthsView,
                topMonthsSalesView,
                avgSaleMonthView,
                rotationView,
                unsoldProductsView,
                topSuppliersView,
                topMonthsPurchasesView
        );
        
        this.inputReader = new InputReader(
                view,
                productsLowRotationView, 
                productsMostSoldView,
                montlyGrowView,
                topMonthsView,
                topMonthsSalesView,
                avgSaleMonthView,
                rotationView,
                topSuppliersView
        );
        
        init();
        initListeners();
    }
    
    private void init() {
        createChartComparativeSalesAndPurchases();
        setPanelsStats();
    }
    
    private void initListeners() {   
        view.timeBox.addActionListener(e -> createChartComparativeSalesAndPurchases());
        
        view.btnProductsLowRotation.addActionListener(e -> showChartProductsLowRotation());
        view.btnProductsLowStock.addActionListener(e -> showChartProductsLowStock());
        view.btnProductsEarn.addActionListener(e -> showChartMostProfitableProducts());
        view.btnProductsSold.addActionListener(e -> showChartMostSoldProductsInMonth());
        
        view.btnGrowMontly.addActionListener(e -> showChartMontlySalesGrowth());
        view.btnGrowBestMonths.addActionListener(e -> showChartTopMonths());
        view.btnGrowMostQuantity.addActionListener(e -> showChartTopMonthsSales());
        view.btnGrowAvgMonth.addActionListener(e -> showChartAvgSalePerMonth());
        
        view.btnPurchasesTime.addActionListener(e -> showChartRotationProducts());
        view.btnPurchasesNoSold.addActionListener(e -> showProductsUnSold());
        view.btnPurchasesSuppliers.addActionListener(e -> showChartTopSuppliers());
        view.btnPurchasesBestMonths.addActionListener(e -> showTopMonthsPurchases());
        
        topSuppliersView.quantityCombo.addActionListener(e -> createChartTopSuppliers());
        rotationView.quantityCombo.addActionListener(e -> createChartRotationProducts());
        avgSaleMonthView.quantityCombo.addActionListener(e -> createChartAvgSalePerMonth());
        topMonthsSalesView.quantityCombo.addActionListener(e -> createChartTopMonthsSales());
        topMonthsView.quantityCombo.addActionListener(e -> createChartTopMonths());
        montlyGrowView.quantityCombo.addActionListener(e -> createChartMontlyGrowthSales());
        productsMostSoldView.quantityCombo.addActionListener(e -> createChartMostSoldProductsInMonth());
        productsLowRotationView.quantityCombo.addActionListener(e -> createChartProductsLowRotation());
    }
    
    private void setPanelsStats() {
        elements.setEstimatedNetProfit(queriesService.getEstimatedNetProfit());
        elements.setMonthlyGrowthPercentage(queriesService.getMonthlyGrowthPercentage());
        elements.setTopSellingProduct(queriesService.getTopSellingProduct());
        elements.setTopSellerUser(queriesService.getTopSellerUser());
    }
    
    private void createChartComparativeSalesAndPurchases() {
        int quantityToWatch = inputReader.getQuantityMonthsComparativeSalesPurchases();
        elements.setPurchasesSalesComparative(QueriesCharts.createMonthlySalesVsPurchasesLineChart(
                queriesService.getDailyPurchaseAndSaleTotalsForLastMonth(quantityToWatch)
        ));
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
    
    private void createChartRotationProducts() {
        int quantityToWatch = inputReader.getQuantityProductsRotation();
        elements.setRotationProductsChart(QueriesCharts.createAvgTimeBetweenPurchaseAndSaleChart(
               queriesService.getRotationProducts(quantityToWatch)
        ));
    }
    
    private void createListUnsoldProducts() {
        elements.setUnsoldProductsList(UnsoldProductsList.create(
               queriesService.getUnsoldproducts()
        ));
    }
    
    private void createChartTopSuppliers() {
        int quantityToWatch = inputReader.getQuantityTopSuppliers();
        elements.setTopSuppliersChart(QueriesCharts.createSupplierInvestmentDonutChart(
                queriesService.getTopSuppliers(quantityToWatch)
        ));
    }
    
    private void createChartTopMonthsPurchases() {
        elements.setTopMonthsPurchasesChart(QueriesCharts.createTopPurchasesLineChart(
               queriesService.getTopMonthsPurchases()
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
    
    private void showChartRotationProducts() {
        rotationView.setVisible(true);
        createChartRotationProducts();
    }
    
    private void showProductsUnSold() {
        unsoldProductsView.setVisible(true);
        createListUnsoldProducts();
    }
    
    private void showChartTopSuppliers() {
        topSuppliersView.setVisible(true);
        createChartTopSuppliers();
    }
    
    private void showTopMonthsPurchases() {
        topMonthsPurchasesView.setVisible(true);
        createChartTopMonthsPurchases();
    }
    
}
