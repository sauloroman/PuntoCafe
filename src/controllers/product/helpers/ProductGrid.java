package controllers.product.helpers;

import services.ProductService;
import services.CategoryService;
import services.SupplierService;
import entities.Category;
import entities.Product;
import entities.Supplier;
import java.util.List;
import java.util.function.Consumer;
import javax.swing.JScrollPane;
import views.components.Grid;
import views.components.ProductCard;
import views.warehouse.WarehouseProducts;

public class ProductGrid {
    
    private final int QUANTITY_PRODUCTS = 15;
    private final WarehouseProducts view;
    private final ProductService queryProducts;
    private final CategoryService queryCategories;
    private final SupplierService querySuppliers;
    private final JScrollPane scroll;
    private Consumer<Product> onProductClick;
    
    public ProductGrid(
            WarehouseProducts view, 
            ProductService queryProducts, 
            CategoryService queryCategories, 
            SupplierService querySuppliers
    ) {
        this.view = view;
        this.queryProducts = queryProducts;
        this.queryCategories = queryCategories;
        this.querySuppliers = querySuppliers;
        
        Grid.create(view.productsGrid, 5, 20);
        this.scroll = new JScrollPane(view.productsGrid);
        view.add(scroll);
    }
    
    public void setOnProductClick(Consumer<Product> listener) {
        this.onProductClick = listener;
    }
    
    public void create(int page) {
        view.productsGrid.removeAll();
        view.productsGrid.revalidate();
        view.productsGrid.repaint();

        List<Product> products = queryProducts.getProducts(QUANTITY_PRODUCTS, page);

        for (Product product : products) {
            addProduct(product);
        }
    }

    
    public void addProduct( Product product ) {
        ProductCard card = new ProductCard();
        
        Category categoryProduct = queryCategories.getById(product.getCategoryId());
        String categoryName = categoryProduct.getCategoryName();
        
        Supplier supplierProduct = querySuppliers.getByID(product.getSupplierId());
        String supplierCompany = supplierProduct.getSupplierCompany();
        
        view.productsGrid.add(card.create(
            product.getProductName(),
            categoryName,
            supplierCompany,
            product.getProductSellingPrice().toString(),
            "Producto sin imagen".equals(product.getProductImage()) ? "no-image.jpg" : product.getProductImage(),
            product.getProductIsActive(),
            product,
            onProductClick
        ));
    }
    
}
