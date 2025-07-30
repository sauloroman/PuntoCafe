package controllers.purchase;

import java.util.List;

import controllers.purchase.helpers.LoadInformation;
import controllers.purchase.helpers.PurchasesRefresher;
import controllers.purchase.helpers.InputReader;
import controllers.purchase.helpers.PurchaseProductRefresher;
import controllers.purchase.helpers.PurchaseValidator;
import controllers.purchase.helpers.ViewElements;
import controllers.purchase.helpers.CalculateTotal;
import controllers.purchase.helpers.CalculateTotalPurchaseDetail;
import controllers.purchase.helpers.ProductsList;
import controllers.purchase.helpers.PurchaseCharts;
import controllers.purchase.helpers.PurchaseList;

import entities.Product;
import entities.Purchase;
import entities.PurchaseDetail;
import entities.PurchaseItem;
import entities.User;
import java.util.HashMap;
import java.util.Map;

import models.ProductModel;
import models.PurchaseDetailModel;
import models.PurchaseModel;
import models.SupplierModel;

import services.ProductService;
import services.PurchaseService;
import services.SupplierService;

import utils.enums.ModalTypeEnum;
import utils.helpers.CodeGenerator;
import utils.helpers.DateFilterPanel;
import utils.helpers.DateGenerator;
import utils.helpers.GenerateReports;
import utils.helpers.Modal;
import utils.helpers.TableRowClickHelper;

import views.purchases.PurchaseBuyQuantityPrice;
import views.purchases.PurchasesBuy;
import views.purchases.PurchasesCreateBuy;
import views.purchases.PurchasesDetail;

public class PurchaseController {
    
    private final User user;
    
    private final PurchasesBuy view;
    private final PurchasesCreateBuy createView;
    private final PurchaseBuyQuantityPrice quantityPriceView;
    private final PurchasesDetail detailView;
    
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
    private final CodeGenerator codeGenerator;
    private final PurchaseProductRefresher purchaseProductRefresher;
    private final ViewElements elements;
    private final PurchaseValidator validator;
    private final ProductsList productsList;
    private final PurchaseList purchaseList;
    private final CalculateTotal calculateTotal;
    private final CalculateTotalPurchaseDetail calculateTotalPurchase;
    private final Modal modal = new Modal("PuntoCafé - Compras del sistema");
    
    private Product productSelected = null;
    private int purchaseIdSelected = -1;
    
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
        this.detailView = new PurchasesDetail();
        
        this.purchaseDetailModel = purchaseDetailModel;
        this.supplierModel = supplierModel;
        this.productModel = productModel;
        
        this.model = purchasemodel;
        
        this.supplierService = new SupplierService(this.supplierModel);
        this.purchaseService = new PurchaseService(this.model, this.purchaseDetailModel);
        this.productService = new ProductService(this.productModel);
        
        this.load = new LoadInformation(view, createView, detailView);
        this.dateFilter = new DateFilterPanel(view.startDatePanel, view.endDatePanel);
        this.refresher = new PurchasesRefresher(view, detailView, supplierService, productService);
        this.inputReader = new InputReader(view, createView, quantityPriceView, dateFilter);
        this.purchaseProductRefresher = new PurchaseProductRefresher(createView);
        this.elements = new ViewElements(view, createView, quantityPriceView);
        this.productsList = new ProductsList();
        this.validator = new PurchaseValidator(modal);
        this.calculateTotal = new CalculateTotal(createView);
        this.calculateTotalPurchase = new CalculateTotalPurchaseDetail(detailView);
        this.purchaseList = new PurchaseList(createView);
        this.codeGenerator = new CodeGenerator();
        
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
        createView.btnSavePurchase.addActionListener(e -> savePurchase());
        
        quantityPriceView.btnAddToList.addActionListener(e -> addProductToPurchase());
        
        detailView.btnExport.addActionListener(e -> generateReport());
        
        purchaseList.setOnDelete(item -> removeItemOfLIst(item));
        
        TableRowClickHelper.addRowClickListener(view.purchasesTable, row -> openPurchaseDetail(row));
        TableRowClickHelper.addRowClickListener(createView.productsTable, row -> openProductQuantityPriceWindow(row));
    }
    
    private void savePurchase() {
        String supplierInPurchase = inputReader.getSupplierCreatePurchase(); 
        if ( supplierInPurchase == null ) {
            modal.show("El proveedor es obligatorio. Seleccione uno", ModalTypeEnum.error);
            return;
        }
        
        if ( productsList.getProducts().isEmpty() ) {
            modal.show("No hay artículos en el registro de compra. Agrege algunos para continuar", ModalTypeEnum.error);
            return;
        }
        
        if ( modal.confirm("¿Desea confirmar el registro de compra?") != 0 ) return;
        
        double total  = calculateTotal.getTotal();
        String date = DateGenerator.getCurrentDateTimeFormatted();
        String code = codeGenerator.generate(5);
        int userId = user.getUserId();
        int supplierId = supplierService.getByNameAndLastname(supplierInPurchase).getSupplierId();
        
        Purchase purchase = new Purchase(date, total, code, supplierId, userId);
        Purchase purchaseSaved = purchaseService.savePurchase(purchase);
        
        if ( purchaseSaved == null ) {
            modal.show("Error al crear la compra", ModalTypeEnum.error);
            return;
        }
        
        if ( !savePurchaseDetail(purchaseSaved.getPurchaseId()) ) {
            modal.show("Error al guardar el detalle de compra", ModalTypeEnum.error);
            return;
        }
        
        if ( !updateStockProducts() ) {
            modal.show("No se pudo actualizar el stock.", ModalTypeEnum.error);
            return;
        }
        
        modal.show("La compra se ha realizado exitosamente.\nFolio: " + code + "\nFecha: " + date, ModalTypeEnum.success);
        purchaseList.clearList();
        productsList.clearList();
        elements.clearPurchaseList();
        elements.clearTotalPurchase();
        purchaseProductRefresher.load(productService.getProductsToChoseInPurchase());
        refresher.load(purchaseService.getPurchases(0, DateGenerator.getCurrentDateStart(60), DateGenerator.getCurrentDateEnd()));
        loadStats();
        loadGraphs();
    }
    
    private boolean savePurchaseDetail( int purchaseId ) {
        List<PurchaseItem> items = productsList.getProducts();
        
        for( PurchaseItem item: items ) {
            int quantity = item.getQuantity();
            double price = item.getPrice();
            int productId = item.getProduct().getProductId();
            
            PurchaseDetail purchaseDetail = new PurchaseDetail(quantity, price, productId, purchaseId);
            boolean wasPurchaseDetailSaved = purchaseService.savePurchaseDetail(purchaseDetail);
            
            if ( !wasPurchaseDetailSaved ) return false;
        }
        return true;
    }
    
    private boolean updateStockProducts() {
        List<PurchaseItem> items = productsList.getProducts();
        
        for(PurchaseItem item: items ) {
            int productId = item.getProduct().getProductId();
            int quantity = item.getQuantity();
            boolean wasStockUpdated = productService.incrementStock(productId, quantity);
            if ( !wasStockUpdated ) return false;
        }
        
        return true;
    }
    
    private void loadStats() {
        load.setTotalPurchasesAmount(purchaseService.getTotalPurchasesAmount());
        load.setTotalPurchases(purchaseService.getTotalPurchases());
        load.setAvgPurchaseAmount(purchaseService.getAvgPurchasesAmount());
        load.setTopSupplier(purchaseService.getTopSupplier());
    }
    
    private void loadGraphs() {
        load.setMontlyPurchasesChart(
                PurchaseCharts.createMonthlyBarChart(
                        purchaseService.getMonthlyPurchasesAmount(6), 
                        "Compras por Mes (Últimos 6 meses)"
                )
        );
        
        load.setTopProductsPurchasesChart(
                PurchaseCharts.createTopProductsDonutChart(
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
        
        purchaseProductRefresher.load(productService.getProductsByName(productSearched, 1, 100));
    }
    
    private void removeItemOfLIst(PurchaseItem item) {
        productsList.removeProduct(item.getProduct().getProductId());
        purchaseList.removeItem(item.getProduct().getProductId());
        calculateTotal.calculate(productsList.getProducts());
    }
    
    private void openPurchaseDetail(int row) {
        int purchaseId = Integer.parseInt(view.purchasesTable.getValueAt(row, 0).toString());
        purchaseIdSelected = purchaseId;
        String purchaseDate = view.purchasesTable.getValueAt(row, 3).toString();
        load.setPurchaseDateInDetailWindow(purchaseDate);
        
        List<PurchaseDetail> details = purchaseService.getProductDetails(purchaseId);
        refresher.loadProductDetailTable(details);
        calculateTotalPurchase.setInfoTotalGeneral();
        
        detailView.setVisible(true);
    }
    
    private void generateReport() {
        Map<String, Object> params = new HashMap<>();
        params.put("purchase_id", purchaseIdSelected);
        GenerateReports.generateReport("purchase_detail", "PuntoCafé - Detalle de compra", params);
    }
    
}
