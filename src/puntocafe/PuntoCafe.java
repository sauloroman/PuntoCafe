package puntocafe;

import com.formdev.flatlaf.FlatLightLaf;
import controllers.category.CategoryController;
import controllers.NavegationController;
import controllers.product.ProductController;
import controllers.supplier.SupplierController;
import javax.swing.UIManager;
import models.CategoryModel;
import models.ProductModel;
import models.SupplierModel;
import views.Access;
import views.MainFrame;
import views.purchases.Purchases;
import views.Queries;
import views.Sales;
import views.purchases.PurchasesSuppliers;
import views.warehouse.Warehouse;
import views.warehouse.WarehouseCategories;
import views.warehouse.WarehouseProducts;

public class PuntoCafe {

    public static void main(String[] args) {
        
        loadFlatLaf();
        MainFrame mainView = new MainFrame();
        
        WarehouseCategories warehouseCategories = new WarehouseCategories();
        WarehouseProducts warehouseProducts = new WarehouseProducts();
        Warehouse warehouse = new Warehouse(warehouseCategories, warehouseProducts);
        
        Access access = new Access();
        
        PurchasesSuppliers purchasesSuppliers = new PurchasesSuppliers();
        Purchases purchases = new Purchases( purchasesSuppliers );
        
        Sales sales = new Sales();
        Queries queries = new Queries();
        
        CategoryModel categoryModel = new CategoryModel();
        new CategoryController( warehouseCategories, categoryModel );
        
        SupplierModel supplierModel = new SupplierModel();
        new SupplierController( purchasesSuppliers, supplierModel );
        
        ProductModel productModel = new ProductModel();
        new ProductController( warehouseProducts, productModel, categoryModel, supplierModel );
        
        new NavegationController( 
            mainView,
            warehouse,
            purchases,
            access,
            queries,
            sales
        );
                
        mainView.setVisible(true);
    }
    
    private static void loadFlatLaf() {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception e) {
            System.err.println("No se pudo cargar FlatLaf: " + e.getMessage());
        }
    }
    
}
