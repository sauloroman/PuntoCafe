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
    
    public  List<Product> getProducts( int quantity, int page ) {
        List<Product> products = model.getItemsByCriteria(SearchCriteriaEnum.NONE, quantity, page);
        return products;
    }
    
    public int getQuantityProducts() {
        return model.getTotalItems();
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
