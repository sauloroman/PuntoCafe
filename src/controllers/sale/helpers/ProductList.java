package controllers.sale.helpers;

import entities.Product;
import entities.ProductItem;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import views.components.Card;
import views.sales.CreateSale;

public class ProductList {

    private final CreateSale view;
    private Consumer<Integer> onDelete; 
    private final List<ProductItem> products = new ArrayList<>();

    public ProductList(CreateSale view) {
        this.view = view;
    }

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

        renderProductList();
    }

    public void removeProduct(int productId) {
        products.removeIf(item -> item.getProduct().getProductId() == productId);
        renderProductList();
    }

    private ProductItem findProductItemById(int productId) {
        for (ProductItem item : products) {
            if (item.getProduct().getProductId() == productId) {
                return item;
            }
        }
        return null;
    }

    private void updateProductItem(ProductItem item, int quantity, double discount) {
        item.setQuantity(quantity);
        item.setDisscount(discount);
    }

    private void renderProductList() {
        view.saleList.removeAll();

        Card card = new Card();
        for (ProductItem item : products) {
            view.saleList.add(card.createSaleItemCard(
                item.getProduct(),
                item.getQuantity(),
                item.getDisscount(),
                onDelete
            ));
        }

        view.saleList.revalidate();
        view.saleList.repaint();
    }
}
