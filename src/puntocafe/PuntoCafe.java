package puntocafe;

import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.UIManager;

import entities.User;

import models.AuthModel;
import models.CategoryModel;
import models.DishModel;
import models.ProductModel;
import models.RoleModel;
import models.SaleModel;
import models.SupplierModel;
import models.UserModel;
import models.SaleDishDetailModel;

import controllers.category.CategoryController;
import controllers.navigation.NavigationController;
import controllers.user.UserController;
import controllers.dish.DishController;
import controllers.auth.AuthController;
import controllers.main.MainFrameController;
import controllers.product.ProductController;
import controllers.sale.SaleController;
import controllers.supplier.SupplierController;

import views.access.Access;
import views.MainFrame;
import views.purchases.Purchases;
import views.queries.Queries;
import views.sales.Sales;
import views.access.AccessRoles;
import views.access.AccessUsers;
import views.components.SplashScreen;
import views.login.Login;
import views.purchases.PurchasesSuppliers;
import views.warehouse.Warehouse;
import views.warehouse.WarehouseCategories;
import views.warehouse.WarehouseDishes;
import views.warehouse.WarehouseProducts;

import com.formdev.flatlaf.FlatLightLaf;
import controllers.menu.MenuController;
import controllers.purchase.PurchaseController;
import controllers.queries.QueriesController;
import controllers.seller.SellerController;
import models.MenuDetailModel;
import models.MenuModel;
import models.PurchaseDetailModel;
import models.PurchaseModel;
import models.SaleProductDetailModel;
import models.StatsModel;
import views.purchases.PurchasesBuy;
import views.sales.SalesSeller;
import views.warehouse.WarehouseMenus;

public class PuntoCafe {

    private User user = null;
    private AuthController authController;
    
    public static void main(String[] args) {
        loadFlatLaf();
        
//        new PuntoCafe().run();
        
        SwingUtilities.invokeLater(() -> {
            new PuntoCafe().showLogin();
        });       
    }
    
    private void run() {
        initApp();
    }
    
    private static void loadFlatLaf() {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception e) {
            System.err.println("No se pudo cargar FlatLaf: " + e.getMessage());
        }
    }
    
    public void showLogin() {
        Login loginView = new Login();
        AuthModel model = new AuthModel();
        
        authController = new AuthController(this, loginView, model);
        
        authController.setOnLoginSuccess(user -> {
            this.user = user;
            initApp();
        });
        
        loginView.setVisible(true);
    }
    
    private void initApp() {

        SplashScreen splash = new SplashScreen(null);
        splash.setVisible(true);

        SwingWorker<Boolean, Void> worker = new SwingWorker<>() {
            @Override
            protected Boolean doInBackground() throws Exception {
                
                CategoryModel categoryModel = new CategoryModel();
                PurchaseModel purchaseModel = new PurchaseModel();
                PurchaseDetailModel purchaseDetailModel = new PurchaseDetailModel();
                SupplierModel supplierModel = new SupplierModel();
                ProductModel productModel = new ProductModel();
                DishModel dishModel = new DishModel();
                UserModel userModel = new UserModel();
                RoleModel roleModel = new RoleModel();
                SaleModel saleModel = new SaleModel();
                SaleProductDetailModel saleProductDetailModel = new SaleProductDetailModel();
                SaleDishDetailModel saleDishDetailModel = new SaleDishDetailModel();
                StatsModel statsModel = new StatsModel();
                MenuModel menuModel = new MenuModel();
                MenuDetailModel menuDetailModel = new MenuDetailModel();
                
                return true;
            }

            @Override
            protected void done() {
                
                User dummyUser = new User();
                dummyUser.setUserName("Danna Janeth");
                dummyUser.setUserLastname("Sánchez Carreón");
                dummyUser.setUserEmail("dannajanethsanchez@outlook.es");
                dummyUser.setRoleId(3);
                dummyUser.setUserId(8);
                dummyUser.setUserImage("user-3.jpg");
                
                MainFrame mainView = new MainFrame(user);
                
                WarehouseCategories warehouseCategories = new WarehouseCategories(user);
                WarehouseProducts warehouseProducts = new WarehouseProducts(user);
                WarehouseDishes warehouseDishes = new WarehouseDishes(user);
                WarehouseMenus warehouseMenus = new WarehouseMenus(user);
                Warehouse warehouse = new Warehouse(
                        warehouseCategories, 
                        warehouseProducts, 
                        warehouseDishes, 
                        warehouseMenus
                );

                AccessRoles accessRoles = new AccessRoles();
                AccessUsers accessUsers = new AccessUsers( user );
                Access access = new Access(accessRoles, accessUsers);

                PurchasesSuppliers purchasesSuppliers = new PurchasesSuppliers(user);
                PurchasesBuy purchasesBuy = new PurchasesBuy(user);
                Purchases purchases = new Purchases(purchasesSuppliers, purchasesBuy);

                Sales sales = new Sales(user);
                SalesSeller salesSeller = new SalesSeller();
                Queries queries = new Queries();

                CategoryModel categoryModel = new CategoryModel();
                PurchaseModel purchaseModel = new PurchaseModel();
                PurchaseDetailModel purchaseDetailModel = new PurchaseDetailModel();
                SupplierModel supplierModel = new SupplierModel();
                ProductModel productModel = new ProductModel();
                DishModel dishModel = new DishModel();
                UserModel userModel = new UserModel();
                RoleModel roleModel = new RoleModel();
                SaleModel saleModel = new SaleModel();
                SaleProductDetailModel saleProductDetailModel = new SaleProductDetailModel();
                SaleDishDetailModel saleDishDetailModel = new SaleDishDetailModel();
                StatsModel statsModel = new StatsModel();
                MenuModel menuModel = new MenuModel();
                MenuDetailModel menuDetailModel = new MenuDetailModel();
                
                new MainFrameController(mainView, roleModel, user, authController);
                new CategoryController(warehouseCategories, categoryModel);
                new SupplierController(purchasesSuppliers, supplierModel);
                new PurchaseController(user, purchasesBuy, purchaseModel, purchaseDetailModel, supplierModel, productModel);
                new ProductController(warehouseProducts, productModel, categoryModel, supplierModel);
                new DishController(warehouseDishes, dishModel, categoryModel);
                new UserController(accessUsers, accessRoles, userModel, roleModel);
                new QueriesController(queries, statsModel);
                new MenuController(warehouseMenus, menuModel, menuDetailModel, categoryModel, dishModel);
                new SaleController( 
                        user, 
                        sales, 
                        saleModel, 
                        saleProductDetailModel, 
                        saleDishDetailModel, 
                        productModel, 
                        dishModel,
                        userModel
                );
                new SellerController(
                        user,
                        salesSeller, 
                        saleModel,
                        dishModel,
                        productModel,
                        saleProductDetailModel, 
                        saleDishDetailModel, 
                        userModel
                );
                
                new NavigationController(
                        user,
                        mainView,
                        warehouse,
                        purchases,
                        access,
                        queries,
                        sales,
                        salesSeller
                );

                splash.dispose();
                mainView.setVisible(true);
            }
        };

        worker.execute();
    }


    
}
