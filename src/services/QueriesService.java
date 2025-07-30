package services;

import entities.Product;
import java.util.List;
import java.util.Map;
import models.StatsModel;

public class QueriesService {
    
    private final StatsModel model;

    public QueriesService(StatsModel model) {
        this.model = model;
    }
    
    public List<Product> getProductsLowRotation( int quantity ) {
        return model.getLowRotationProducts(quantity);
    }
    
    public List<Product> getProductsLowStock() {
        return model.getCriticalStockProducts();
    }
    
    public Map<String, Double> getMostProfitableProducts() {
        return model.getMostProfitableProducts();
    }
    
    public Map<String, Integer> getTopSellingProductsOfMonth(int quantity) {
        return model.getTopSellingProductsOfMonth(quantity);
    }
}
