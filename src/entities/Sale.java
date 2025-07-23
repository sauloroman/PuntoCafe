package entities;

public class Sale {
    
    private int saleId;
    private String saleDate;
    private double total;
    private String saleCode;
    private int userId;

    public Sale() {}

    public Sale(int saleId, String saleDate, double total, String saleCode, int userId) {
        this.saleId = saleId;
        this.saleDate = saleDate;
        this.total = total;
        this.saleCode = saleCode;
        this.userId = userId;
    }

    public Sale(String saleDate, double total, String saleCode, int userId) {
        this.saleDate = saleDate;
        this.total = total;
        this.saleCode = saleCode;
        this.userId = userId;
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getSaleCode() {
        return saleCode;
    }

    public void setSaleCode(String saleCode) {
        this.saleCode = saleCode;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    
}
