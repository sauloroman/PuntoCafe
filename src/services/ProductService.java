package services;

import entities.Product;
import java.util.List;
import models.ProductModel;
import utils.enums.SearchCriteriaEnum;

public class ProductService {
    
    private final ProductModel model;

    public ProductService(ProductModel model) {
        this.model = model;
    }
    
    public  List<Product> getProducts(int page, int quantity) {
        List<Product> products = model.listItemsByPage("", SearchCriteriaEnum.NONE, page, quantity);
        return products;
    }
    
    public List<Product> getProductsByCategory( int categoryId, int page, int quantity ) {
        List<Product> products = model.getProductsByCategoryId(categoryId, page, quantity);
        return products;
    }
    
    public int getQuantityProducts() {
        return model.getTotalItems();
    }
    
    public int getQuantityProductsByCategory( int categoryId ) {
        return model.getTotalItemsByFilter(SearchCriteriaEnum.PRODUCT_CATEGORY, categoryId );
    }
    
    public Product getProductByName(String productName) {
        return model.getItemByName(productName);
    }
    
    public boolean saveProduct(Product product) {
        return model.saveItem(product);
    }
    
    public boolean updateProduct(Product product, int id) {
        return model.updateItem(product, id);
    }
    
    public boolean activateProduct(int productId) {
        return model.changeStatus(productId, true);
    }
    
    public boolean deactivateProduct(int productId) {
        return model.changeStatus(productId, false);
    }
    
}
