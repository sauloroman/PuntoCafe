package entities;

public class PurchaseDetail {
    
    private int purchaseDetailId;
    private int purchaseDetailQuantity;
    private double purchaseDetailUnitPrice;
    private int productId;
    private int puchaseId;

    public PurchaseDetail() {}

    public PurchaseDetail(
            int purchaseDetailQuantity, 
            double purchaseDetailUnitPrice, 
            int productId, 
            int puchaseId
    ) {
        this.purchaseDetailQuantity = purchaseDetailQuantity;
        this.purchaseDetailUnitPrice = purchaseDetailUnitPrice;
        this.productId = productId;
        this.puchaseId = puchaseId;
    }

    public PurchaseDetail(
            int purchaseDetailId, 
            int purchaseDetailQuantity, 
            double purchaseDetailUnitPrice, 
            int productId, 
            int puchaseId
    ) {
        this.purchaseDetailId = purchaseDetailId;
        this.purchaseDetailQuantity = purchaseDetailQuantity;
        this.purchaseDetailUnitPrice = purchaseDetailUnitPrice;
        this.productId = productId;
        this.puchaseId = puchaseId;
    }

    public int getPurchaseDetailId() {
        return purchaseDetailId;
    }

    public void setPurchaseDetailId(int purchaseDetailId) {
        this.purchaseDetailId = purchaseDetailId;
    }

    public int getPurchaseDetailQuantity() {
        return purchaseDetailQuantity;
    }

    public void setPurchaseDetailQuantity(int purchaseDetailQuantity) {
        this.purchaseDetailQuantity = purchaseDetailQuantity;
    }

    public double getPurchaseDetailUnitPrice() {
        return purchaseDetailUnitPrice;
    }

    public void setPurchaseDetailUnitPrice(double purchaseDetailUnitPrice) {
        this.purchaseDetailUnitPrice = purchaseDetailUnitPrice;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getPuchaseId() {
        return puchaseId;
    }

    public void setPuchaseId(int puchaseId) {
        this.puchaseId = puchaseId;
    }
    
    
    
}
