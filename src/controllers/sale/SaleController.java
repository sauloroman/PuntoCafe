package controllers.sale;

import controllers.sale.helpers.CalculateTotal;
import controllers.sale.helpers.Pages;
import controllers.sale.helpers.InputReader;
import controllers.sale.helpers.ProductsGrid;
import controllers.sale.helpers.LoadInformation;
import controllers.sale.helpers.ProductList;
import controllers.sale.helpers.ViewElements;
import entities.Product;
import entities.User;
import java.awt.event.ActionListener;
import models.ProductModel;
import models.SaleDishDetailModel;
import models.SaleModel;
import models.SaleProductDetailModel;
import services.ProductService;
import utils.enums.SearchCriteriaEnum;
import utils.helpers.CodeGenerator;
import views.sales.CreateSale;
import views.sales.CreateSaleProductQuantity;
import views.sales.Sales;

public class SaleController {
    
    private final User user;
    
    private final Sales view;
    private final CreateSale createView;
    private final CreateSaleProductQuantity productQuantityView;
    
    private final SaleModel saleModel;
    private final SaleProductDetailModel saleProductDetailModel;
    private final SaleDishDetailModel saleDishDetailModel;
    private final ProductModel productModel;
    
    private final ProductService productService;
    
    private final ProductsGrid productsGrid;
    private final InputReader inputReader;
    private final Pages pages;
    private final LoadInformation load;
    private final ViewElements elements;
    private final CodeGenerator codeGenerator;
    private final ProductList productList;
    private final CalculateTotal calculateTotal;
    
    private SearchCriteriaEnum filterSelected = SearchCriteriaEnum.NONE;
    private Product productSelected = null;
    
    public SaleController(
            User user,
            Sales view, 
            SaleModel saleModel,
            SaleProductDetailModel saleProductDetailModel,
            SaleDishDetailModel saleDishDetailModel,
            ProductModel productModel
    ) {
        this.user = user;
        this.view = view;
        this.createView = new CreateSale();
        this.productQuantityView = new CreateSaleProductQuantity();
    
        this.saleModel = saleModel;
        this.saleProductDetailModel = saleProductDetailModel;
        this.saleDishDetailModel = saleDishDetailModel;
        this.productModel = productModel;
        
        this.productService = new ProductService(this.productModel);
        
        this.calculateTotal = new CalculateTotal(createView);
        this.productList = new ProductList(createView);
        this.codeGenerator = new CodeGenerator();
        this.elements = new ViewElements(createView, productQuantityView);
        this.load = new LoadInformation(productQuantityView);
        this.pages = new Pages(createView, productService);
        this.inputReader = new InputReader(createView, productQuantityView);
        this.productsGrid = new ProductsGrid(createView, productService);
        
        init();
        initListeners();
    }
    
    private void init() {
        pages.create();
    }
    
    private void initListeners() {
        view.btnNewSale.addActionListener(e -> openCreateSaleWindow());
        
        createView.btnSearch.addActionListener(e -> filterProductsByName());
        
        productQuantityView.btnAddToList.addActionListener(e -> addToSaleList());
        
        productList.setOnDelete(id -> removeProduct( id ));
        productsGrid.setOnProductClick(product -> openProductQuantityWindow(product));
        productsGrid.showAllProducts(1);
    }
    
    private void removeProduct(int id ) {
        productList.removeProduct(id);
        calculateTotal.calculateAllProducts(productList.getProducts());
    }
    
    private void openProductQuantityWindow(Product product) {
        productSelected = product;
        load.productQuantiy(product);
        elements.setLimitValueInProductSpinner(product);
        productQuantityView.setVisible(true);
    }
    
    private void openCreateSaleWindow() {
        productsGrid.showAllProducts(1);
        createView.setVisible(true);
        elements.setCodeSell(codeGenerator.generate(5));
        elements.setUserInfo(user.getUserName() + " " + user.getUserLastname());
    }
    
    private void filterProductsByName() {
        String productSearched = inputReader.getProductNameSearch();
        if ( productSearched == null ) {
            safelyRebuildPaginationCreate(() -> pages.create());
            filterSelected = SearchCriteriaEnum.NONE;
            productsGrid.showAllProducts(1);
            return; 
        }
        
        safelyRebuildPaginationCreate(() -> pages.createByName(productSearched));
        productsGrid.showProductsByName(productSearched, 1);
        filterSelected = SearchCriteriaEnum.NAME;
    }
    
    private void safelyRebuildPaginationCreate(Runnable rebuildLogic) {
        ActionListener[] listeners = createView.pageCombo.getActionListeners();
        for (ActionListener l : listeners) {
            createView.pageCombo.removeActionListener(l);
        }

        rebuildLogic.run();

        for (ActionListener l : listeners) {
            createView.pageCombo.addActionListener(l);
        }
    }
    
    private void addToSaleList() {
        int quantity = inputReader.getQuantityProducts();
        double price = inputReader.getProductPrice();
        double disscount = inputReader.getDisscountProduct();
        
        if ( productSelected != null && quantity > 0 && price > 0 ) {
            productList.addProduct(productSelected, quantity, disscount);
            productQuantityView.dispose();
        }
        
        elements.clearDisscountField();
        calculateTotal.calculateAllProducts(productList.getProducts());
    }
    
}
