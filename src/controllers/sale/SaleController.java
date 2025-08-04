package controllers.sale;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import controllers.sale.helpers.DishGrid;
import controllers.sale.helpers.CalculateTotal;
import controllers.sale.helpers.CalculateTotalSaleDetail;
import controllers.sale.helpers.DishList;
import controllers.sale.helpers.Pages;
import controllers.sale.helpers.InputReader;
import controllers.sale.helpers.ProductsGrid;
import controllers.sale.helpers.LoadInformation;
import controllers.sale.helpers.ProductList;
import controllers.sale.helpers.SaleCharts;
import controllers.sale.helpers.SaleList;
import controllers.sale.helpers.SaleRefresher;
import controllers.sale.helpers.ViewElements;

import entities.Dish;
import entities.Product;
import entities.User;
import entities.DishItem;
import entities.ProductItem;
import entities.Sale;
import entities.SaleDishDetail;
import entities.SaleProductDetail;
import interfaces.SaleItem;

import models.UserModel;
import models.DishModel;
import models.ProductModel;
import models.SaleDishDetailModel;
import models.SaleModel;
import models.SaleProductDetailModel;

import services.DishService;
import services.ProductService;
import services.SaleService;
import services.UserService;

import utils.helpers.CodeGenerator;
import utils.enums.ModalTypeEnum;
import utils.helpers.DateFilterPanel;
import utils.helpers.DateGenerator;
import utils.helpers.GenerateReports;
import utils.helpers.Modal;
import utils.helpers.TableRowClickHelper;

import views.sales.CreateSale;
import views.sales.CreateSaleDishQuantity;
import views.sales.CreateSaleProductQuantity;
import views.sales.Sales;
import views.sales.SaleDetail;

public class SaleController {
    
    private final User user;
    
    private final Sales view;
    private final CreateSale createView;
    private final CreateSaleProductQuantity productQuantityView;
    private final CreateSaleDishQuantity dishQuantityView;
    private final SaleDetail saleDetailView;
    
    private final SaleModel saleModel;
    private final SaleProductDetailModel saleProductDetailModel;
    private final SaleDishDetailModel saleDishDetailModel;
    private final ProductModel productModel;
    private final DishModel dishModel;
    private final UserModel userModel;
    
    private final ProductService productService;
    private final DishService dishService;
    private final SaleService saleService;
    private final UserService userService;
    
    private final SaleRefresher refresher;
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
    private final CalculateTotalSaleDetail calculateTotalDetail;
    private final DateFilterPanel dateFilter;
    private final Modal modal = new Modal("Punto de venta -  PuntoCafé");
    
    private Product productSelected = null;
    private Dish dishSelected = null;
    private String saleCode = null;
    private int saleIdSelected = -1;
    
    public SaleController(
            User user,
            Sales view, 
            SaleModel saleModel,
            SaleProductDetailModel saleProductDetailModel,
            SaleDishDetailModel saleDishDetailModel,
            ProductModel productModel,
            DishModel dishModel,
            UserModel userModel
    ) {
        this.user = user;
        this.view = view;
        this.createView = new CreateSale();
        this.productQuantityView = new CreateSaleProductQuantity();
        this.dishQuantityView = new CreateSaleDishQuantity();
        this.saleDetailView = new SaleDetail();
    
        this.userModel = userModel;
        this.saleModel = saleModel;
        this.saleProductDetailModel = saleProductDetailModel;
        this.saleDishDetailModel = saleDishDetailModel;
        this.productModel = productModel;
        this.dishModel = dishModel;
        
        this.productService = new ProductService(this.productModel);
        this.dishService = new DishService(this.dishModel);
        this.saleService = new SaleService(this.saleModel, this.saleProductDetailModel, this.saleDishDetailModel);
        this.userService = new UserService(this.userModel);
        
        this.dateFilter = new DateFilterPanel(view.filterStartDate, view.filterEndDate);
        this.refresher = new SaleRefresher(view, saleDetailView, productService, dishService, userService);
        this.calculateTotal = new CalculateTotal(createView);
        this.calculateTotalDetail = new CalculateTotalSaleDetail(saleDetailView);
        this.productList = new ProductList();
        this.dishList = new DishList();
        this.saleList = new SaleList(createView);
        this.codeGenerator = new CodeGenerator();
        this.elements = new ViewElements(createView, productQuantityView, dishQuantityView);
        this.load = new LoadInformation(view, saleDetailView, productQuantityView, dishQuantityView);
        this.pages = new Pages(createView, productService, dishService);
        this.inputReader = new InputReader(view, createView, productQuantityView, dishQuantityView, dateFilter);
        this.productsGrid = new ProductsGrid(createView, productService);
        this.dishesGrid = new DishGrid(createView, dishService);
        
        init();
        initListeners();
    }
    
    private void init() {
        pages.create();
        load.fillUserBox(userService.getAllUsers());
        refresher.load(saleService.getSales(0, DateGenerator.getCurrentDateStart(2), DateGenerator.getCurrentDateEnd()));
        loadStats();
        loadGraphs();
    }
    
    private void initListeners() {
        view.btnNewSale.addActionListener(e -> openCreateSaleWindow());
        view.btnReload.addActionListener(e -> refreshInfo());
        view.btnFilter.addActionListener(e -> filterSales());
        
        saleDetailView.btnExport.addActionListener(e -> generateSaleDetailReport());
        
        createView.pageCombo.addActionListener(e -> loadPage());
        createView.pageComboDish.addActionListener(e -> loadPageDish());
        createView.btnSearch.addActionListener(e -> filterProductsByName());
        createView.btnSearchDish.addActionListener(e -> filterDishesByName());
        createView.btnSaveSale.addActionListener(e -> saveSale());
        
        productQuantityView.btnAddToList.addActionListener(e -> addProductToSaleList());
        dishQuantityView.btnAddToList.addActionListener(e -> addDishToSaleList());
        
        productList.setOnDelete(id -> removeProduct( id ));
        dishList.setOnDelete(id -> removeDish(id));
        
        saleList.setOnDelete(item -> removeItemOfList(item));
        productsGrid.setOnProductClick(product -> openProductQuantityWindow(product));
        dishesGrid.setOnDishClick(dish -> openDishQuantityWindow(dish));
        productsGrid.showAllProducts(1);
        dishesGrid.showAllDishes(1);
        
        TableRowClickHelper.addRowClickListener(view.salesTable, row -> openSaleDetailWindow(row));
    }
    
    private void openSaleDetailWindow(int selectedRow) { 
        int saleId = Integer.parseInt(view.salesTable.getValueAt(selectedRow, 0).toString());
        saleIdSelected = saleId;
        String saleDate = view.salesTable.getValueAt(selectedRow, 3).toString();
        
        load.setSaleDateInDetailWindow(saleDate);
        List<SaleProductDetail> productDetails = saleService.getProductDetails(saleId);
        List<SaleDishDetail> dishDetails = saleService.getDishDetails(saleId);
        
        refresher.loadProductDetailTable( productDetails );
        calculateTotalDetail.setSubtotalProducts();
        
        refresher.loadDishDetailTable(dishDetails);
        calculateTotalDetail.setSubtotalDishes();
        
        calculateTotalDetail.setInfoTotalGeneral();
        saleDetailView.setVisible(true);
    }
    
    private void generateSaleDetailReport() {
        Map<String, Object> params = new HashMap<>();
        params.put("sale_id", saleIdSelected);
        GenerateReports.generateReport("detail_sale", "PuntoCafé - Detalle de venta", params);
    }
    
    private void filterSales() {
        String userFilter = inputReader.getUserFiltered();
        int userId = 0;
        if ( userFilter != null ) {
            userId = userService.getUserByNameAndLastname(userFilter).getUserId();
        }
        
        String startDate = inputReader.getStartDate();
        String endDate = inputReader.getEndDate();
        
        refresher.load(saleService.getSales(userId, startDate, endDate));
    }
    
    private void refreshInfo() {
        load.fillUserBox(userService.getAllUsers());
        String startDate = DateGenerator.getCurrentDateStart(2);
        String endDate = DateGenerator.getCurrentDateEnd();
        refresher.load(saleService.getSales(0, startDate, endDate));
    }
    
    private void loadStats() {
        load.setTotalSalesAmount(saleService.getTotalSalesAmount());
        load.setTotalSales(saleService.getTotalSales());
        load.setAvgSaleAmount(saleService.getAvgSaleAmount());
        load.setTotalDiscountSalesAmount(saleService.getTotalDiscountSalesAmount());
    }
    
    private void loadGraphs() {
        load.setMontlySalesChart(
                SaleCharts.createMonthlyBarChart(
                        saleService.getMonthlySalesAmount(6), 
                        "Ventas por Mes (Últimos 6 meses)"
                )
        );
        
        load.setAmountCategoryItemsChart(
                SaleCharts.createItemsDonutChart(
                        saleService.getPercentageCategorySales()
                )
        );
    }
    
    private void removeItemOfList(SaleItem item) {
        if ( item instanceof ProductItem ) {
            productList.removeProduct(item.getId());
        } else {
            dishList.removeDish(item.getId());
        }
        
        saleList.removeItem(item.getId(), item.getClass());
        calculateTotal.calculateAll(saleList.getItems());
    }
    
    private void saveSale() {
        if ( productList.getProducts().isEmpty() && dishList.getDishes().isEmpty() ){
            modal.show("No hay artículos en el registro de venta. Agrege algunos para continuar", ModalTypeEnum.error);
            return;
        }
        
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
        
        modal.show("La venta se ha realizado exitosamente.\nFolio: " + code + "\nFecha: " + date, ModalTypeEnum.success);
        saleList.clearList();
        productList.clearList();
        dishList.clearList();
        elements.clearSaleList();
        saleCode = codeGenerator.generate(5);
        elements.clearTotalSale();
        productsGrid.showAllProducts(1);
        refresher.load(
            saleService.getSales(0, DateGenerator.getCurrentDateStart(2), DateGenerator.getCurrentDateEnd())
        );
        loadStats();
        loadGraphs();
    }
    
    private void saveSaleDishDetail( int saleId ) {
        List<DishItem> dishesInSale = dishList.getDishes();
        
        for ( DishItem dishItem: dishesInSale ) {
            int quantity = dishItem.getQuantity();
            Dish dish = dishService.getDishById(dishItem.getId());
            double unitPrice = dish.getDishSellingPrice();
            double discount = dishItem.getDiscount();
            int dishId = dishItem.getId();
            
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
        
        for ( ProductItem productItem: productsInSale ) {
            
            int quantity = productItem.getQuantity();
            
            Product product = productService.getProductById(productItem.getId());
            double unitPrice = product.getProductSellingPrice();
            
            double discount = productItem.getDiscount();
            int productId = productItem.getId();
            
            if ( quantity > productSelected.getProductStock() ) {
                modal.show("El stock del producto no es suficiente", ModalTypeEnum.error);
                return;
            }
            
            boolean wasStockUpdated = productService.discountStock(productId, quantity);
            
            if ( !wasStockUpdated ) {
                modal.show("No se pudo actualizar el stock.", ModalTypeEnum.error);
                return;
            }
            
            SaleProductDetail saleProductDetail = new SaleProductDetail(quantity, unitPrice, discount, saleId, productId);
            boolean wasSaleProductDetail = saleService.saveSaleProductDetail(saleProductDetail);
            
            if ( !wasSaleProductDetail ) {
                modal.show("Error al crear la venta", ModalTypeEnum.error);
                return;
            }
            
            checkProductStock();
        }
    }
    
    private void checkProductStock() {
        Product product = productService.getProductById(productSelected.getProductId());
        
        if ( product.getProductStock() <= 0 ) {
            productService.deactivateProduct(productSelected.getProductId());
            modal.show("El stock de este producto '" + product.getProductName() + "' ha sido agotado. Producto desactivado. Reabastece y actualiza su información", ModalTypeEnum.warning);
        } else if ( product.getProductStock() <= product.getProductStockMin() ) {
            modal.show("El stock está en riesgo. Reabastece pronto y evita perdidas en tus ventas", ModalTypeEnum.warning);
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

        if ( discount > price * quantity ) {
            modal.show("No puedes descontar más del precio del producto", ModalTypeEnum.error);
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
        
        if ( discount > price * quantity ) {
            modal.show("No puedes descontar más del precio del platillo", ModalTypeEnum.error);
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
