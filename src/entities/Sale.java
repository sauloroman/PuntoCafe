package entities;

import java.util.Date;

public class Sale {
    
    private int saleId;
    private Date saleDate;
    private double total;
    private String saleCode;
    private int userId;

    public Sale() {}

    public Sale(int saleId, Date saleDate, double total, String saleCode, int userId) {
        this.saleId = saleId;
        this.saleDate = saleDate;
        this.total = total;
        this.saleCode = saleCode;
        this.userId = userId;
    }

    public Sale(Date saleDate, double total, String saleCode, int userId) {
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

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
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
