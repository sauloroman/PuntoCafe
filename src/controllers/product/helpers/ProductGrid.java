package controllers.product.helpers;

import services.ProductService;
import services.SupplierService;
import entities.Product;
import entities.Supplier;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import javax.swing.JScrollPane;
import views.components.Grid;
import views.components.Card;
import views.warehouse.WarehouseProducts;

public class ProductGrid {
    
    private final int QUANTITY_PRODUCTS = 15;
    private final WarehouseProducts view;
    private final ProductService queryProducts;
    private final SupplierService querySuppliers;
    private final JScrollPane scroll;
    private Consumer<Product> onProductClick;
    private List<Product> products = new ArrayList<>();
    
    public ProductGrid(
            WarehouseProducts view, 
            ProductService queryProducts, 
            SupplierService querySuppliers
    ) {
        this.view = view;
        this.queryProducts = queryProducts;
        this.querySuppliers = querySuppliers;
        
        Grid.create(view.productsGrid, 5, 20);
        this.scroll = new JScrollPane(view.productsGrid);
        view.add(this.scroll);
    }
    
    public void setItemsByPage( int quantity ) {
        view.quantityItems.setText("Visualizando " + quantity + " de " + queryProducts.getQuantityProducts()+ " productos");
    }
    
    private void clearGrid() {
        view.productsGrid.removeAll();
        view.productsGrid.revalidate();
        view.productsGrid.repaint();
    }
    
    public void setOnProductClick(Consumer<Product> listener) {
        this.onProductClick = listener;
    }
    
    public void showAllProducts(int page) {
        clearGrid();
        products = queryProducts.getProducts( page, QUANTITY_PRODUCTS);
        setItemsByPage(products.size());
        for (Product product : products) {
            addProduct(product);
        }
    }
    
    public void showProductsByCategory( int categoryId, int page ) {
        clearGrid();
        products = queryProducts.getProductsByCategory(categoryId, page, QUANTITY_PRODUCTS);
        setItemsByPage(products.size());
        for (Product product : products) {
            addProduct(product);
        }
    }
    
    public void showProductsBySupplier(String supplierCompany, int page) {
        clearGrid();
        products = queryProducts.getProductsBySupplierCompany(supplierCompany, page, QUANTITY_PRODUCTS);
        setItemsByPage(products.size());
        for (Product product : products) {
            addProduct(product);
        }
    }
    
    public void showProductsByStatus(String status, int page) {
        clearGrid();
        products = queryProducts.getProductsByStatus(status, page, QUANTITY_PRODUCTS);
        setItemsByPage(products.size());
        for (Product product : products) {
            addProduct(product);
        }
    }
    
    public void showProductsByName(String name, int page) {
        clearGrid();
        products = queryProducts.getProductsByName(name, page, QUANTITY_PRODUCTS);
        setItemsByPage(products.size());
        for(Product product: products) {
            addProduct(product);
        }
    }
    
    public void addProduct( Product product ) {
        Card card = new Card();
        
        Supplier supplierProduct = querySuppliers.getById(product.getSupplierId());
        String supplierCompany = supplierProduct.getSupplierCompany();
        
        view.productsGrid.add(card.createProduct(
            supplierCompany,           
            product,
            onProductClick
        ));
    }
    
}
