package controllers.purchase;

import controllers.purchase.helpers.LoadInformation;
import controllers.purchase.helpers.PurchasesRefresher;
import controllers.purchase.helpers.InputReader;
import controllers.purchase.helpers.PurchaseProductRefresher;
import controllers.purchase.helpers.PurchaseValidator;
import controllers.purchase.helpers.ViewElements;
import controllers.purchase.helpers.CalculateTotal;
import controllers.purchase.helpers.ProductsList;
import controllers.purchase.helpers.PurchaseList;
import entities.Product;
import entities.PurchaseItem;
import entities.User;
import models.ProductModel;
import models.PurchaseDetailModel;
import models.PurchaseModel;
import models.SupplierModel;
import services.ProductService;
import services.PurchaseService;
import services.SupplierService;
import utils.helpers.Charts;
import utils.helpers.DateFilterPanel;
import utils.helpers.DateGenerator;
import utils.helpers.Modal;
import utils.helpers.TableRowClickHelper;
import views.purchases.PurchaseBuyQuantityPrice;
import views.purchases.PurchasesBuy;
import views.purchases.PurchasesCreateBuy;

public class PurchaseController {
    
    private final User user;
    
    private final PurchasesBuy view;
    private final PurchasesCreateBuy createView;
    private final PurchaseBuyQuantityPrice quantityPriceView;
    
    private final PurchaseModel model;
    private final PurchaseDetailModel purchaseDetailModel;
    private final SupplierModel supplierModel;
    private final ProductModel productModel;
    
    private final SupplierService supplierService;
    private final PurchaseService purchaseService;
    private final ProductService productService;

    private final LoadInformation load;
    private final DateFilterPanel dateFilter;
    private final PurchasesRefresher refresher;
    private final InputReader inputReader;
    private final PurchaseProductRefresher purchaseProductRefresher;
    private final ViewElements elements;
    private final PurchaseValidator validator;
    private final ProductsList productsList;
    private final PurchaseList purchaseList;
    private final CalculateTotal calculateTotal;
    private final Modal modal = new Modal("PuntoCafé - Compras del sistema");
    
    private Product productSelected = null;
    
    public PurchaseController(
            User user,
            PurchasesBuy view, 
            PurchaseModel purchasemodel,
            PurchaseDetailModel purchaseDetailModel,
            SupplierModel supplierModel,
            ProductModel productModel
    ) {
        this.user = user;
        
        this.view = view;
        this.createView = new PurchasesCreateBuy();
        this.quantityPriceView = new PurchaseBuyQuantityPrice();
        
        this.purchaseDetailModel = purchaseDetailModel;
        this.supplierModel = supplierModel;
        this.productModel = productModel;
        
        this.model = purchasemodel;
        
        this.supplierService = new SupplierService(this.supplierModel);
        this.purchaseService = new PurchaseService(this.model, this.purchaseDetailModel);
        this.productService = new ProductService(this.productModel);
        
        this.load = new LoadInformation(view, createView);
        this.dateFilter = new DateFilterPanel(view.startDatePanel, view.endDatePanel);
        this.refresher = new PurchasesRefresher(view, supplierService);
        this.inputReader = new InputReader(view, createView, quantityPriceView, dateFilter);
        this.purchaseProductRefresher = new PurchaseProductRefresher(createView);
        this.elements = new ViewElements(view, quantityPriceView);
        this.productsList = new ProductsList();
        this.validator = new PurchaseValidator(modal);
        this.calculateTotal = new CalculateTotal(createView);
        this.purchaseList = new PurchaseList(createView);
        
        init();
        initHandlers();
    }
    
    private void init() {
        load.fillSuppliersBox(supplierService.getAll());
        refresher.load(purchaseService.getPurchases(0, DateGenerator.getCurrentDateStart(60), DateGenerator.getCurrentDateEnd()));
        loadStats();
        loadGraphs();
    }
    
    private void initHandlers() {
        view.btnNewBuy.addActionListener(e -> openRegisterBuyWindow());
        view.btnReload.addActionListener( e -> refreshInfo());
        view.btnFilter.addActionListener(e -> filterPurchases());
    
        createView.btnSearch.addActionListener(e -> filterProductsToChoose());
        
        quantityPriceView.btnAddToList.addActionListener(e -> addProductToPurchase());
        
        TableRowClickHelper.addRowClickListener(createView.productsTable, row -> openProductQuantityPriceWindow(row));
    }
    
    private void loadStats() {
        load.setTotalPurchasesAmount(purchaseService.getTotalPurchasesAmount());
        load.setTotalPurchases(purchaseService.getTotalPurchases());
        load.setAvgPurchaseAmount(purchaseService.getAvgPurchasesAmount());
        load.setTopSupplier(purchaseService.getTopSupplier());
    }
    
    private void loadGraphs() {
        load.setMontlyPurchasesChart(
                Charts.createMonthlyBarChart(
                        purchaseService.getMonthlyPurchasesAmount(6), 
                        "Compras por Mes (Últimos 6 meses)"
                )
        );
        
        load.setTopProductsPurchasesChart(
                Charts.createTopProductsDonutChart(
                        purchaseService.getTopProducts(5)
                )
        );
    }
    
    private void filterPurchases() {
        String supplierFilter = inputReader.getSupplierFiltered();
        int supplierId = 0;
        
        if ( supplierFilter != null ) {
            supplierId = supplierService.getByNameAndLastname(supplierFilter).getSupplierId();
        }
        
        String startDate = inputReader.getStartDate();
        String endDate = inputReader.getEndDate();
        
        refresher.load(purchaseService.getPurchases(supplierId, startDate, endDate));
    }
    
    private void refreshInfo() {
        load.fillSuppliersBox(supplierService.getAll());
        load.setTopSupplier(purchaseService.getTopSupplier());
        String startDate = DateGenerator.getCurrentDateStart(60);
        String endDate = DateGenerator.getCurrentDateEnd();
        refresher.load(purchaseService.getPurchases(0, startDate, endDate));
        purchaseProductRefresher.load(productService.getProductsToChoseInPurchase());
    }
    
    private void openRegisterBuyWindow() {
        createView.setVisible(true);
        load.fillSupplierBoxCreatePurchase(supplierService.getAll());
        purchaseProductRefresher.load(productService.getProductsToChoseInPurchase());        
    }
    
    private void openProductQuantityPriceWindow(int row) {
        Product product = productService.getProductByName(createView.productsTable.getValueAt(row, 0).toString());
        productSelected = product;  
        quantityPriceView.setVisible(true);
    }
    
    private void addProductToPurchase() {
        int quantity = inputReader.getQuantityProduct();
        double price = inputReader.getPriceProduct();
        
        if ( !validator.isValidForm(quantity, price)) return;
        
        if ( productSelected != null ) {
            productsList.addProduct(productSelected, quantity, price);
            purchaseList.addItem(new PurchaseItem(productSelected, quantity, price));
            quantityPriceView.dispose();
        }
        
        elements.clearQuantiyPriceForm();
        calculateTotal.calculate(productsList.getProducts());
    }
    
    private void filterProductsToChoose() {
        String productSearched = inputReader.getProductSearched();
        
        if ( productSearched == null ) {
            purchaseProductRefresher.load(productService.getProductsToChoseInPurchase());
            return;
        }
        
        purchaseProductRefresher.load(productService.getProductsByName(productSearched, 0, 0));
    }
    
    
}
