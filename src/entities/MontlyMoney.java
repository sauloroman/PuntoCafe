package entities;

public class MontlyMoney {
    
    private String month;
    private double totalAmount;

    public MontlyMoney(String month, double totalAmount) {
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
