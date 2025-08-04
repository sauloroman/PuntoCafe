package controllers.seller.helpers;

import entities.Product;
import entities.ProductItem;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ProductList {

    private Consumer<Integer> onDelete; 
    private final List<ProductItem> products = new ArrayList<>();

    public ProductList() {}

    public void setOnDelete(Consumer<Integer> listener) {
        this.onDelete = listener;
    }
    
    public List<ProductItem> getProducts() {
        return products;
    }

    public void addProduct(Product product, int quantity, double discount) {
        ProductItem existingItem = findProductItemById(product.getProductId());

        if (existingItem != null) {
            updateProductItem(existingItem, quantity, discount);
        } else {
            products.add(new ProductItem(product, quantity, discount));
        }
    }

    public void removeProduct(int productId) {
        products.removeIf(item -> item.getItem().getProductId() == productId);
    }
    
    public void clearList() {
        products.clear();
    }

    private ProductItem findProductItemById(int productId) {
        for (ProductItem item : products) {
            if (item.getItem().getProductId() == productId) {
                return item;
            }
        }
        return null;
    }

    private void updateProductItem(ProductItem item, int quantity, double discount) {
        item.setQuantity(quantity);
        item.setDiscount(discount);
    }
    
}
