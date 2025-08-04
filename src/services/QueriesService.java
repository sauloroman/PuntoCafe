package services;

import entities.Product;
import java.math.BigDecimal;
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
    
    public Map<String, Double> getRotationProducts(int limitProducts) {
        return model.getAverageTimeBetweenPurchaseAndSalePerProduct(limitProducts);
    }
    
    public List<String> getUnsoldproducts() {
        return model.getUnsoldPurchasedProducts();
    }
    
    public Map<String, Double> getTopSuppliers( int limitSuppliers ) {
        return model.getTopSuppliersByInvestment(limitSuppliers);
    }
    
    public Map<String, Integer> getTopMonthsPurchases() {
        return model.getTopMonthsByPurchases();
    }
    
    public Map<String, Map<String, BigDecimal>> getDailyPurchaseAndSaleTotalsForLastMonth( int lastMonths ) {
        return model.getMonthlyPurchaseAndSaleTotals(lastMonths);
    }
    
    public BigDecimal getEstimatedNetProfit() {
        return model.getEstimatedNetProfit();
    }
    
    public double getMonthlyGrowthPercentage() {
        return model.getLastMonthlyGrowthPercentage();
    }
    
    public Map<String, Integer> getTopSellingProduct() { 
        return model.getTopSellingProduct();
    }
    
    public Map<String, Integer> getTopSellerUser() {
        return model.getTopSellerUser();
    }
    
}
