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
    
    public Map<String, Double> getMonthlyGrowth( int quantityMonths ) { 
        return model.getMonthlyGrowth(quantityMonths);
    }
    
    public Map<String, Double> getTopMonths( int quantityMonths ) {
        return model.getTopSalesMonths(quantityMonths);
    }
    
    public Map<String, Integer> getTopSalesMontly( int limitMonths ) {
        return model.getTopSalesCountMonths(limitMonths);
    }
    
    public Map<String, Double> getAvgSaleMonthly(int limitMonths) {
        return model.getAverageDailySalesPerMonth(limitMonths);
    }
}
