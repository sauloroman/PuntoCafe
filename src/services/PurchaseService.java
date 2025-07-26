package services;

import entities.MontlyMoney;
import entities.Purchase;
import entities.PurchaseDetail;
import entities.TopProduct;
import entities.TopSupplier;
import java.util.List;
import models.PurchaseDetailModel;
import models.PurchaseModel;

public class PurchaseService {
    
    private final PurchaseModel model;
    private final PurchaseDetailModel purchaseDetailModel;
    
    public PurchaseService(PurchaseModel model, PurchaseDetailModel purchaseDetailModel) {
        this.model = model;
        this.purchaseDetailModel = purchaseDetailModel;
    }
    
    public Purchase savePurchase(Purchase purchase) {
        return model.savePurchase(purchase);
    }
    
    public boolean savePurchaseDetail(PurchaseDetail purchaseDetail) {
        return purchaseDetailModel.savePurchaseDetail(purchaseDetail);
    }
    
    public List<Purchase> getPurchases( int supplierId, String startDate, String endDate ) {
        if ( supplierId < 0 || startDate == null || endDate == null ) return null;
        return model.getPurchases(supplierId, startDate, endDate);
    }
    
    public List<PurchaseDetail> getProductDetails( int purchaseId ) {
        if ( purchaseId < 0 ) return null;
        return purchaseDetailModel.getPurchaseDetailByPurchaseId(purchaseId);
    }

    public double getTotalPurchasesAmount() {
        return model.getTotalPurchasesAmount();
    }
    
    public int getTotalPurchases() {
        return model.getTotalPurchases();
    }
    
    public double getAvgPurchasesAmount() {
        return model.getAvgPurchaseAmount();
    }

    public TopSupplier getTopSupplier() {
        return model.getTopSupplierPurchases();
    }
    
    public List<TopProduct> getTopProducts( int quantityProduct ) {
        if ( quantityProduct <= 0 ) return null;
        return model.getTopProductsInPurchase(quantityProduct);
    }
    
    public List<MontlyMoney> getMonthlyPurchasesAmount( int lastMonths ) {
        return model.getTotalPurchasesPerMonth( lastMonths );
    }
    
}
