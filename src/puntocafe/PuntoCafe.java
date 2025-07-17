package puntocafe;

import com.formdev.flatlaf.FlatLightLaf;
import controllers.category.CategoryController;
import controllers.navigation.NavigationController;
import controllers.user.UserController;
import controllers.dish.DishController;
import controllers.auth.AuthController;
import controllers.product.ProductController;
import controllers.supplier.SupplierController;
import entities.User;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import models.AuthModel;
import models.CategoryModel;
import models.DishModel;
import models.ProductModel;
import models.RoleModel;
import models.SupplierModel;
import models.UserModel;
import views.access.Access;
import views.MainFrame;
import views.purchases.Purchases;
import views.Queries;
import views.Sales;
import views.access.AccessRoles;
import views.access.AccessUsers;
import views.components.SplashScreen;
import views.login.Login;
import views.purchases.PurchasesSuppliers;
import views.warehouse.Warehouse;
import views.warehouse.WarehouseCategories;
import views.warehouse.WarehouseDishes;
import views.warehouse.WarehouseProducts;

public class PuntoCafe {

    private User user = null;
    
    public static void main(String[] args) {
        loadFlatLaf();
        
        new PuntoCafe().run();
        
//        SwingUtilities.invokeLater(() -> {
//            new PuntoCafe().showLogin();
//        });       
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
    
    private void showLogin() {
        Login loginView = new Login();
        AuthModel model = new AuthModel();
        
        AuthController authController = new AuthController(loginView, model);
        
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
                SupplierModel supplierModel = new SupplierModel();
                ProductModel productModel = new ProductModel();
                DishModel dishModel = new DishModel();
                UserModel userModel = new UserModel();
                RoleModel roleModel = new RoleModel();
                return true;
            }

            @Override
            protected void done() {
                MainFrame mainView = new MainFrame();

                WarehouseCategories warehouseCategories = new WarehouseCategories();
                WarehouseProducts warehouseProducts = new WarehouseProducts();
                WarehouseDishes warehouseDishes = new WarehouseDishes();
                Warehouse warehouse = new Warehouse(warehouseCategories, warehouseProducts, warehouseDishes);

                AccessRoles accessRoles = new AccessRoles();
                AccessUsers accessUsers = new AccessUsers();
                Access access = new Access(accessRoles, accessUsers);

                PurchasesSuppliers purchasesSuppliers = new PurchasesSuppliers();
                Purchases purchases = new Purchases(purchasesSuppliers);

                Sales sales = new Sales();
                Queries queries = new Queries();

                CategoryModel categoryModel = new CategoryModel();
                SupplierModel supplierModel = new SupplierModel();
                ProductModel productModel = new ProductModel();
                DishModel dishModel = new DishModel();
                UserModel userModel = new UserModel();
                RoleModel roleModel = new RoleModel();

                new CategoryController(warehouseCategories, categoryModel);
                new SupplierController(purchasesSuppliers, supplierModel);
                new ProductController(warehouseProducts, productModel, categoryModel, supplierModel);
                new DishController(warehouseDishes, dishModel, categoryModel);
                new UserController(accessUsers, accessRoles, userModel, roleModel);

                new NavigationController(
                        mainView,
                        warehouse,
                        purchases,
                        access,
                        queries,
                        sales
                );

                splash.dispose();
                mainView.setVisible(true);
            }
        };

        worker.execute();
    }


    
}
