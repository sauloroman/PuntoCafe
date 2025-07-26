package entities;

public class Purchase {
    
    private int purchaseId;
    private String purchaseDate;
    private double purchaseTotal;
    private String purchaseCode;
    private int supplierId;
    private int userId;

    public Purchase() {}

    public Purchase(
            String purchaseDate, 
            double purchaseTotal, 
            String purchaseCode,
            int supplierId, 
            int userId
    ) {
        this.purchaseDate = purchaseDate;
        this.purchaseTotal = purchaseTotal;
        this.purchaseCode = purchaseCode;
        this.supplierId = supplierId;
        this.userId = userId;
    }
    
    public Purchase(
            int purchaseId, 
            String purchaseDate, 
            double purchaseTotal,
            String purchaseCode,
            int supplierId, 
            int userId
    ) {
        this.purchaseId = purchaseId;
        this.purchaseDate = purchaseDate;
        this.purchaseTotal = purchaseTotal;
        this.purchaseCode = purchaseCode;
        this.supplierId = supplierId;
        this.userId = userId;
    }

    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public double getPurchaseTotal() {
        return purchaseTotal;
    }

    public void setPurchaseTotal(double purchaseTotal) {
        this.purchaseTotal = purchaseTotal;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPurchaseCode() {
        return purchaseCode;
    }

    public void setPurchaseCode(String purchaseCode) {
        this.purchaseCode = purchaseCode;
    }
}
