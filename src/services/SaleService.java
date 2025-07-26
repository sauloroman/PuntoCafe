package services;

import entities.MontlyMoney;
import entities.Sale;
import entities.SaleDishDetail;
import entities.SaleProductDetail;
import entities.SoldCategoryTotal;
import java.util.List;
import models.SaleDishDetailModel;
import models.SaleModel;
import models.SaleProductDetailModel;

public class SaleService {
    
    private final SaleModel model;
    private final SaleProductDetailModel saleProductDetailModel;
    private final SaleDishDetailModel saleDishDetailModel;
    
    public SaleService(SaleModel model, SaleProductDetailModel saleProductDetailModel, SaleDishDetailModel saleDishDetailModel) {
        this.model = model;
        this.saleProductDetailModel = saleProductDetailModel;
        this.saleDishDetailModel = saleDishDetailModel;
    }
    
    public Sale saveSale(Sale sale) {
        return model.saveSale(sale);
    }
    
    public boolean saveSaleProductDetail(SaleProductDetail saleProductDetail) {
        return saleProductDetailModel.saveSaleProductDetail(saleProductDetail);
    }
    
    public boolean saveSaleDishDetail(SaleDishDetail saleDishDetail) {
        return saleDishDetailModel.saveSaleDishDetail(saleDishDetail);
    }
    
    public List<Sale> getSales( int userId, String startDate, String endDate ) {
        return model.getSales(userId, startDate, endDate);
    }
    
    public List<SaleProductDetail> getProductDetails( int saleId ) {
        return saleProductDetailModel.getProductDetailsBySaleId(saleId);
    }
    
    public List<SaleDishDetail> getDishDetails( int saleId ) {
        return saleDishDetailModel.getDishDetailsBySaleId(saleId);
    }
    
    public double getTotalSalesAmount() {
        return model.getTotalSalesAmount();
    }
    
    public int getTotalSales() {
        return model.getTotalSales();
    }
    
    public double getAvgSaleAmount() {
        return model.getAvgSaleAmount();
    }
    
    public double getTotalDiscountSalesAmount() {
        return model.getTotalDiscountSalesAmount();
    }
    
    public List<MontlyMoney> getMonthlySalesAmount( int lastMonths ) {
        return model.getTotalSalesPerMonth( lastMonths );
    }
    
    public List<SoldCategoryTotal> getPercentageCategorySales() {
        return model.getItemsCountPercentageByCategory();
    }
    
}
