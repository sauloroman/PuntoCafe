package controllers.sale.helpers;

import entities.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import services.ProductService;
import views.components.Card;
import views.components.Grid;
import views.sales.CreateSale;

public class ProductsGrid {

    private final int QUANTITY_PRODUCTS = 20;
    private final CreateSale view;
    private final ProductService productService;
    private List<Product> products = new ArrayList<>();
    private Consumer<Product> onProductClick;

    public ProductsGrid(
            CreateSale view,
            ProductService productService
    ) {
        this.view = view;
        this.productService = productService;
        
        Grid.create(view.productsGrid, 5, 20);
    }
    
    public void setOnProductClick(Consumer<Product> listener) {
        this.onProductClick = listener;
    }
    
    private void clearGrid() {
        view.productsGrid.removeAll();
        view.productsGrid.revalidate();
        view.productsGrid.repaint();
    }
    
     public void showAllProducts(int page) {
        clearGrid();
        products = productService.getProductsByStatus("Activo", page, QUANTITY_PRODUCTS);
        for (Product product : products) {
            addProduct(product);
        }
    }
     
    public void showProductsByName(String name, int page) {
        clearGrid();
        products = productService.getProductsByName(name, page, QUANTITY_PRODUCTS);
        for(Product product: products) {
            addProduct(product);
        }
    }
     
    public void addProduct( Product product ) {
        Card card = new Card();        
        view.productsGrid.add(card.createModernProductCard(product, onProductClick));
    }
    
}
