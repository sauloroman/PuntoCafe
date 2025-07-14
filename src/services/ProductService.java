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
    
    public List<Product> getProductsBySupplierCompany(String supplierCompany, int page, int quantity ) {
        return model.getProductsBySupplierCompany(supplierCompany, page, quantity);
    }
    
    public List<Product> getProductsByStatus(String status, int page, int quantity) {
        int statusParsed = status.equals("Activo") ? 1 : 0;
        return model.getProductsByStatus(statusParsed, page, quantity);
    }
    
    public List<Product> getProductsByName(String name, int page, int quantity) {
        return model.getProductsByName(name, page, quantity);
    }
    
    public int getQuantityProducts() {
        return model.getTotalItems();
    }
    
    public int getQuantityProductsByCategory( int categoryId ) {
        return model.getTotalProductsByCategoryId(categoryId);
    }
    
    public int getQuantityProductsBySupplierCompany(String supplierCompany) {
        return model.getTotalProductsBySupplierCompany(supplierCompany);
    }
    
    public int getQuantityProductsByStatus(String status) {
        return model.getTotalProductsByStatus(status);
    }
    
    public int getQuantityProductsByName(String name) {
        return model.getTotalProductsByName(name);
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
