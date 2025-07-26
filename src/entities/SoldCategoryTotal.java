package entities;

public class SoldCategoryTotal {
    
    private String category;
    private int count;
    private double percentage;

    public SoldCategoryTotal(String category, int count, double percentage) {
        this.category = category;
        this.count = count;
        this.percentage = percentage;
    }
    
    public String getCategory() {
        return this.category;
    }
    
    public int getCount() {
        return count;
    }

    public double getPercentage() {
        return percentage;
    }
    
}
