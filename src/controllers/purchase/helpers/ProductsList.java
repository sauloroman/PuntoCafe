package controllers.purchase.helpers;

import entities.Product;
import entities.PurchaseItem;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ProductsList {
    
    private Consumer<Integer> onDelete;
    private final List<PurchaseItem> products = new ArrayList<>();
    
    public ProductsList(){}
    
    public void setOnDelete(Consumer<Integer> listener) {
        this.onDelete = listener;
    }
    
    public List<PurchaseItem> getProducts() {
        return products;
    }
    
    public void addProduct(Product product, int quantity, double price) {
        PurchaseItem existingItem = findProductItemById(product.getProductId());

        if (existingItem != null) {
            updateProductItem(existingItem, quantity, price);
        } else {
            products.add(new PurchaseItem(product, quantity, price));
        }
    }

    public void removeProduct(int productId) {
        products.removeIf(item -> item.getProduct().getProductId() == productId);
    }
    
    public void clearList() {
        products.clear();
    }

    private PurchaseItem findProductItemById(int productId) {
        for (PurchaseItem item : products) {
            if (item.getProduct().getProductId() == productId) {
                return item;
            }
        }
        return null;
    }

    private void updateProductItem(PurchaseItem item, int quantity, double price) {
        item.setQuantity(quantity);
        item.setPrice(price);
    }
    
}
