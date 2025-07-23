package controllers.sale;

import entities.Dish;
import entities.Product;
import entities.User;

import controllers.sale.helpers.DishGrid;
import controllers.sale.helpers.CalculateTotal;
import controllers.sale.helpers.DishList;
import controllers.sale.helpers.Pages;
import controllers.sale.helpers.InputReader;
import controllers.sale.helpers.ProductsGrid;
import controllers.sale.helpers.LoadInformation;
import controllers.sale.helpers.ProductList;
import controllers.sale.helpers.SaleList;
import controllers.sale.helpers.ViewElements;
import entities.DishItem;
import entities.ProductItem;
import entities.Sale;
import entities.SaleDishDetail;
import entities.SaleProductDetail;

import models.DishModel;
import models.ProductModel;
import models.SaleDishDetailModel;
import models.SaleModel;
import models.SaleProductDetailModel;

import services.DishService;
import services.ProductService;

import utils.helpers.CodeGenerator;

import views.sales.CreateSale;
import views.sales.CreateSaleDishQuantity;
import views.sales.CreateSaleProductQuantity;
import views.sales.Sales;

import java.awt.event.ActionListener;
import java.util.List;
import services.SaleService;
import utils.enums.ModalTypeEnum;
import utils.helpers.DateGenerator;
import utils.helpers.Modal;

public class SaleController {
    
    private final User user;
    
    private final Sales view;
    private final CreateSale createView;
    private final CreateSaleProductQuantity productQuantityView;
    private final CreateSaleDishQuantity dishQuantityView;
    
    private final SaleModel saleModel;
    private final SaleProductDetailModel saleProductDetailModel;
    private final SaleDishDetailModel saleDishDetailModel;
    private final ProductModel productModel;
    private final DishModel dishModel;
    
    private final ProductService productService;
    private final DishService dishService;
    private final SaleService saleService;
    
    private final ProductsGrid productsGrid;
    private final DishGrid dishesGrid;
    private final InputReader inputReader;
    private final Pages pages;
    private final LoadInformation load;
    private final ViewElements elements;
    private final CodeGenerator codeGenerator;
    private final ProductList productList;
    private final DishList dishList;
    private final SaleList saleList;
    private final CalculateTotal calculateTotal;
    private final Modal modal = new Modal("Punto de venta -  PuntoCafé");
    
    private Product productSelected = null;
    private Dish dishSelected = null;
    private String saleCode = null;
    
    public SaleController(
            User user,
            Sales view, 
            SaleModel saleModel,
            SaleProductDetailModel saleProductDetailModel,
            SaleDishDetailModel saleDishDetailModel,
            ProductModel productModel,
            DishModel dishModel
    ) {
        this.user = user;
        this.view = view;
        this.createView = new CreateSale();
        this.productQuantityView = new CreateSaleProductQuantity();
        this.dishQuantityView = new CreateSaleDishQuantity();
    
        this.saleModel = saleModel;
        this.saleProductDetailModel = saleProductDetailModel;
        this.saleDishDetailModel = saleDishDetailModel;
        this.productModel = productModel;
        this.dishModel = dishModel;
        
        this.productService = new ProductService(this.productModel);
        this.dishService = new DishService(this.dishModel);
        this.saleService = new SaleService(this.saleModel, this.saleProductDetailModel, this.saleDishDetailModel);
        
        this.calculateTotal = new CalculateTotal(createView);
        this.productList = new ProductList();
        this.dishList = new DishList();
        this.saleList = new SaleList(createView);
        this.codeGenerator = new CodeGenerator();
        this.elements = new ViewElements(createView, productQuantityView, dishQuantityView);
        this.load = new LoadInformation(productQuantityView, dishQuantityView);
        this.pages = new Pages(createView, productService, dishService);
        this.inputReader = new InputReader(createView, productQuantityView, dishQuantityView);
        this.productsGrid = new ProductsGrid(createView, productService);
        this.dishesGrid = new DishGrid(createView, dishService);
        
        init();
        initListeners();
    }
    
    private void init() {
        pages.create();
    }
    
    private void initListeners() {
        view.btnNewSale.addActionListener(e -> openCreateSaleWindow());
        
        createView.pageCombo.addActionListener(e -> loadPage());
        createView.pageComboDish.addActionListener(e -> loadPageDish());
        createView.btnSearch.addActionListener(e -> filterProductsByName());
        createView.btnSearchDish.addActionListener(e -> filterDishesByName());
        createView.btnSaveSale.addActionListener(e -> saveSale());
        
        productQuantityView.btnAddToList.addActionListener(e -> addProductToSaleList());
        dishQuantityView.btnAddToList.addActionListener(e -> addDishToSaleList());
        
        productList.setOnDelete(id -> removeProduct( id ));
        dishList.setOnDelete(id -> removeDish(id));
        
        productsGrid.setOnProductClick(product -> openProductQuantityWindow(product));
        dishesGrid.setOnDishClick(dish -> openDishQuantityWindow(dish));
        productsGrid.showAllProducts(1);
        dishesGrid.showAllDishes(1);
    }
    
    private void saveSale() {
        if ( modal.confirm("¿Desea confirmar el registro de venta?") != 0 ) return;
        
        double total = calculateTotal.getTotal();
        String date = DateGenerator.getCurrentDateTimeFormatted();
        String code = saleCode;
        int userId = user.getUserId();
        
        Sale sale = new Sale(date, total, code, userId);
        Sale saleSaved = saleService.saveSale(sale);
        
        if ( saleSaved == null )  {
            modal.show("Error al crear la venta", ModalTypeEnum.error);
            return;
        }
        
        saveSaleDishDetail(saleSaved.getSaleId());
        saveSaleProductDetail(saleSaved.getSaleId());
        saleList.clearList();
        productList.clearList();
        dishList.clearList();
        elements.clearSaleList();
        saleCode = codeGenerator.generate(5);
        elements.clearTotalSale();
    }
    
    private void saveSaleDishDetail( int saleId ) {
        List<DishItem> dishesInSale = dishList.getDishes();
        
        for ( DishItem dish: dishesInSale ) {
            
            int quantity = dish.getQuantity();
            double unitPrice = dish.getSellingPrice();
            double discount = dish.getDiscount();
            int dishId = dish.getId();
            
            SaleDishDetail saleDishDetail = new SaleDishDetail(quantity, unitPrice, discount, saleId, dishId);
            boolean wasSaleDishDetailSaved = saleService.saveSaleDishDetail(saleDishDetail);
            
            if ( !wasSaleDishDetailSaved ) {
                modal.show("Error al crear la venta", ModalTypeEnum.error);
                return;
            }   
        }
    }
    
    private void saveSaleProductDetail(int saleId) {
         List<ProductItem> productsInSale = productList.getProducts();
        
        for ( ProductItem product: productsInSale ) {
            
            int quantity = product.getQuantity();
            double unitPrice = product.getSellingPrice();
            double discount = product.getDiscount();
            int productId = product.getId();
            
            SaleProductDetail saleProductDetail = new SaleProductDetail(quantity, unitPrice, discount, saleId, productId);
            boolean wasSaleProductDetail = saleService.saveSaleProductDetail(saleProductDetail);
            
            if ( !wasSaleProductDetail ) {
                modal.show("Error al crear la venta", ModalTypeEnum.error);
                return;
            }   
        }
    }
    
    private void loadPage() {
        int selectedPage = pages.getSelectedPageProducts();
        productsGrid.showAllProducts(selectedPage);
    }
    
    private void loadPageDish() {
        int selectedPage = pages.getSelectedPageDishes();
        dishesGrid.showAllDishes(selectedPage);
    }
    
    private void removeProduct(int id ) {
        productList.removeProduct(id);
        calculateTotal.calculateAll(saleList.getItems());
    }
    
    private void removeDish( int id ) {
        dishList.removeDish(id);
        calculateTotal.calculateAll(saleList.getItems());
    }
    
    private void openProductQuantityWindow(Product product) {
        productSelected = product;
        load.productQuantiy(product);
        elements.setLimitValueInProductSpinner(product);
        productQuantityView.setVisible(true);
    }
    
    private void openDishQuantityWindow(Dish dish) {
        dishSelected = dish;
        load.dishQuantity(dish);
        dishQuantityView.setVisible(true);
    } 
    
    private void openCreateSaleWindow() {
        dishesGrid.showAllDishes(1);
        productsGrid.showAllProducts(1);
        createView.setVisible(true);
        saleCode = codeGenerator.generate(5);
        elements.setCodeSell(saleCode);
        elements.setUserInfo(user.getUserName() + " " + user.getUserLastname());
        elements.setCurrentDate(DateGenerator.getCurrentDateTimeFormatted());
    }
    
    private void filterProductsByName() {
        String productSearched = inputReader.getProductNameSearch();
        if ( productSearched == null ) {
            safelyRebuildPaginationCreate(() -> pages.create());
            productsGrid.showAllProducts(1);
            return; 
        }
        
        safelyRebuildPaginationCreate(() -> pages.createByProductName(productSearched));
        productsGrid.showProductsByName(productSearched, 1);
    }
    
    private void filterDishesByName() {
        String dishSearched = inputReader.getDishNameSearch();
        if ( dishSearched == null ) {
            safelyRebuildPaginationCreate(() -> pages.create());
            dishesGrid.showAllDishes(1);
            return;
        }
        
        safelyRebuildPaginationCreate(() -> pages.createByDishName(dishSearched));
        dishesGrid.showDishesByName(dishSearched, 1);
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
    
    private void addProductToSaleList() {
        int quantity = inputReader.getQuantityProducts();
        double price = inputReader.getProductPrice();
        double discount = inputReader.getDiscountProduct();
        
        if ( price < 0 ) {
            modal.show("El precio no puede ser negativo", ModalTypeEnum.error);
            return;
        }

        if ( productSelected != null && quantity > 0 && price > 0 ) {
            productList.addProduct(productSelected, quantity, discount);
            saleList.addItem(new ProductItem(productSelected, quantity, discount));
            productQuantityView.dispose();
        }
        
        elements.clearSpinnerFieldProduct();
        elements.clearDiscountFieldProduct();
        calculateTotal.calculateAll(saleList.getItems());
    }
    
    private void addDishToSaleList() {
        int quantity = inputReader.getQuantityDishes();
        double price = inputReader.getDishPrice();
        double discount = inputReader.getDiscountDish();
        
        if ( price < 0 ) {
            modal.show("El precio no puede ser negativo", ModalTypeEnum.error);
            return;
        }

        if ( dishSelected != null && quantity > 0 && price > 0 ) {
            dishList.addDish(dishSelected, quantity, discount);
            saleList.addItem(new DishItem(dishSelected, quantity, discount));
            dishQuantityView.dispose();
        }
        
        elements.clearSpinnerFieldDish();
        elements.clearDiscountFieldDish();
        calculateTotal.calculateAll(saleList.getItems());
    }
    
}
