package entities;

public class MontlySale {
    
    private String month;
    private double totalAmount;

    public MontlySale(String month, double totalAmount) {
        this.month = month;
        this.totalAmount = totalAmount;
    }
    
    public String getMonth() {
        return month;
    }

    public double getTotalAmount() {
        return totalAmount;
    } 
    
}
