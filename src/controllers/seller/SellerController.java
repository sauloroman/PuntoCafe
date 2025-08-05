package controllers.seller;

import java.util.List;

import controllers.seller.helpers.CalculateTotalSaleDetail;
import controllers.seller.helpers.LoadInformation;
import controllers.seller.helpers.CalculateTotal;
import controllers.seller.helpers.DishGrid;
import controllers.seller.helpers.ProductsGrid;
import controllers.seller.helpers.DishList;
import controllers.seller.helpers.InputReader;
import controllers.seller.helpers.Pages;
import controllers.seller.helpers.SaleList;
import controllers.seller.helpers.ProductList;
import controllers.seller.helpers.SalesRefresher;
import controllers.seller.helpers.ViewElements;

import entities.Dish;
import entities.DishItem;
import entities.Product;
import entities.ProductItem;
import entities.Sale;
import entities.SaleDishDetail;
import entities.SaleProductDetail;
import entities.User;
import interfaces.SaleItem;
import java.awt.event.ActionListener;

import models.DishModel;
import models.ProductModel;
import models.SaleDishDetailModel;
import models.SaleModel;
import models.SaleProductDetailModel;
import models.UserModel;

import services.DishService;
import services.ProductService;
import services.SaleService;
import services.UserService;

import utils.enums.ModalTypeEnum;
import utils.helpers.CodeGenerator;
import utils.helpers.DateGenerator;
import utils.helpers.Modal;
import utils.helpers.TableRowClickHelper;

import views.sales.CreateSale;
import views.sales.CreateSaleDishQuantity;
import views.sales.CreateSaleProductQuantity;
import views.sales.SaleDetail;
import views.sales.SalesSeller;

public class SellerController {
    
    private final User user;
    private final SalesSeller view;
    private final CreateSale createSaleView;
    private final CreateSaleProductQuantity productQuantityView;
    private final CreateSaleDishQuantity dishQuantityView;
    private final SaleDetail saleDetailView;
    
    private final SaleModel model;
    private final SaleProductDetailModel saleProductDetailModel;
    private final SaleDishDetailModel saleDishDetailModel;
    private final UserModel userModel;
    private final DishModel dishModel;
    private final ProductModel productModel;
    
    private final UserService userService;
    private final DishService dishService;
    private final ProductService productService;
    private final SaleService service;
    
    private final SalesRefresher refresher;
    private final ProductList productList;
    private final DishList dishList;
    private final SaleList saleList;
    private final CodeGenerator codeGenerator;
    private final ViewElements elements;
    private final ProductsGrid productGrid;
    private final DishGrid dishesGrid;
    private final CalculateTotal calculateTotal;
    private final CalculateTotalSaleDetail calculateTotalDetail;

    private final LoadInformation load;
    private final InputReader inputReader;
    private final Pages pages;
    private final Modal modal = new Modal("Vendedor - Registro de ventas");
    
    private Product productSelected = null;
    private Dish dishSelected = null;
    private String saleCode = null;
    private int saleIdSelected = -1;
    
    public SellerController(
            User user,
            SalesSeller view, 
            SaleModel model,
            DishModel dishModel,
            ProductModel productModel,
            SaleProductDetailModel saleProductDetailModel,
            SaleDishDetailModel saleDishDetailModel,
            UserModel userModel
    ) {
        this.user = user;
        
        this.view = view;
        this.createSaleView = new CreateSale();
        this.productQuantityView = new CreateSaleProductQuantity();
        this.dishQuantityView = new CreateSaleDishQuantity();
        this.saleDetailView = new SaleDetail(user);
        
        this.model = model;
        this.dishModel = dishModel;
        this.productModel = productModel;
        this.saleProductDetailModel = saleProductDetailModel;
        this.saleDishDetailModel = saleDishDetailModel;
        this.userModel = userModel;
        
        this.service = new SaleService(model, saleProductDetailModel, saleDishDetailModel);
        this.userService = new UserService(userModel);
        this.dishService = new DishService(dishModel);
        this.productService = new ProductService(productModel);
        
        this.refresher = new SalesRefresher(view, saleDetailView, productService, dishService, userService);
        this.productList = new ProductList();
        this.dishList = new DishList();
        this.saleList = new SaleList(createSaleView);
        this.elements = new ViewElements(createSaleView, productQuantityView, dishQuantityView);
        this.codeGenerator = new CodeGenerator();
        this.productGrid = new ProductsGrid(createSaleView, productService);
        this.dishesGrid = new DishGrid(createSaleView, dishService);
        this.calculateTotal = new CalculateTotal(createSaleView);
        this.calculateTotalDetail = new CalculateTotalSaleDetail(saleDetailView);
        this.inputReader = new InputReader(createSaleView, productQuantityView, dishQuantityView);
        this.load = new LoadInformation(saleDetailView, productQuantityView, dishQuantityView);
        this.pages = new Pages(createSaleView, productService, dishService);
        
        init();
        initListeners();
    }
    
    
    private void init() {
        pages.create();
        refresher.load(service.getSales(user.getUserId(), DateGenerator.getPastDate(3), DateGenerator.getCurrentDateEnd()));
    }
    
    private void initListeners() {
        view.btnNewSale.addActionListener(e -> openCreateSaleWindow());
        
        createSaleView.pageCombo.addActionListener(e -> loadPage());
        createSaleView.pageComboDish.addActionListener(e -> loadPageDish());
        createSaleView.btnSaveSale.addActionListener(e -> saveSale());
        createSaleView.btnSearch.addActionListener(e -> filterProductsByName());
        createSaleView.btnSearchDish.addActionListener(e -> filterDishesByName());
        
        productQuantityView.btnAddToList.addActionListener(e -> addProductToSaleList());
        dishQuantityView.btnAddToList.addActionListener(e -> addDishToSaleList());
        
        productList.setOnDelete(id -> removeProduct( id ));
        dishList.setOnDelete(id -> removeDish(id));
        
        saleList.setOnDelete(item -> removeItemOfList(item));
        productGrid.setOnProductClick(product -> openProductQuantityWindow(product));
        dishesGrid.setOnDishClick(dish -> openDishQuantityWindow(dish));
        productGrid.showAllProducts(1);
        dishesGrid.showAllDishes(1);
        
        TableRowClickHelper.addRowClickListener(view.salesTable, row -> openSaleDetailWindow(row));
    }

    private void openSaleDetailWindow(int selectedRow) { 
        int saleId = Integer.parseInt(view.salesTable.getValueAt(selectedRow, 0).toString());
        saleIdSelected = saleId;
        String saleDate = view.salesTable.getValueAt(selectedRow, 3).toString();
        
        load.setSaleDateInDetailWindow(saleDate);
        List<SaleProductDetail> productDetails = service.getProductDetails(saleId);
        List<SaleDishDetail> dishDetails = service.getDishDetails(saleId);
        
        refresher.loadProductDetailTable( productDetails );
        calculateTotalDetail.setSubtotalProducts();
        
        refresher.loadDishDetailTable(dishDetails);
        calculateTotalDetail.setSubtotalDishes();
        
        calculateTotalDetail.setInfoTotalGeneral();
        saleDetailView.setVisible(true);
    }
    
    private void filterProductsByName() {
        String productSearched = inputReader.getProductNameSearch();
        if ( productSearched == null ) {
            safelyRebuildPaginationCreate(() -> pages.create());
            productGrid.showAllProducts(1);
            return; 
        }
        
        safelyRebuildPaginationCreate(() -> pages.createByProductName(productSearched));
        productGrid.showProductsByName(productSearched, 1);
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
    
    private void loadPage() {
        int selectedPage = pages.getSelectedPageProducts();
        productGrid.showAllProducts(selectedPage);
    }
    
    private void loadPageDish() {
        int selectedPage = pages.getSelectedPageDishes();
        dishesGrid.showAllDishes(selectedPage);
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
    
    private void removeItemOfList(SaleItem item) {
        if ( item instanceof ProductItem ) {
            productList.removeProduct(item.getId());
        } else {
            dishList.removeDish(item.getId());
        }
        
        saleList.removeItem(item.getId(), item.getClass());
        calculateTotal.calculateAll(saleList.getItems());
    }
    
    private void removeProduct(int id ) {
        productList.removeProduct(id);
        calculateTotal.calculateAll(saleList.getItems());
    }
    
    private void removeDish( int id ) {
        dishList.removeDish(id);
        calculateTotal.calculateAll(saleList.getItems());
    }
    
    private void openCreateSaleWindow() {
        dishesGrid.showAllDishes(1);
        productGrid.showAllProducts(1);
        createSaleView.setVisible(true);
        saleCode = codeGenerator.generate(5);
        elements.setCodeSell(saleCode);
        elements.setUserInfo(user.getUserName() + " " + user.getUserLastname());
        elements.setCurrentDate(DateGenerator.getCurrentDateTimeFormatted());
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
        Sale saleSaved = service.saveSale(sale);
        
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
        productGrid.showAllProducts(1);
        refresher.load(
            service.getSales(user.getUserId(), DateGenerator.getCurrentDateStart(2), DateGenerator.getCurrentDateEnd())
        );
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
            boolean wasSaleDishDetailSaved = service.saveSaleDishDetail(saleDishDetail);
            
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
            boolean wasSaleProductDetail = service.saveSaleProductDetail(saleProductDetail);
            
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
    
    private void safelyRebuildPaginationCreate(Runnable rebuildLogic) {
        ActionListener[] listeners = createSaleView.pageCombo.getActionListeners();
        for (ActionListener l : listeners) {
            createSaleView.pageCombo.removeActionListener(l);
        }

        rebuildLogic.run();

        for (ActionListener l : listeners) {
            createSaleView.pageCombo.addActionListener(l);
        }
    }
    
}
