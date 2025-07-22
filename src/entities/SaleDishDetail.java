package entities;

public class SaleDishDetail {
    
    private int saleDishDetailId;
    private int saleDishDetailQuantity;
    private double saleDishDetailUnitPrice;
    private int saleId;
    private int dishId;

    public SaleDishDetail() {}

    public SaleDishDetail(
            int saleDishDetailId, 
            int saleDishDetailQuantity, 
            double saleDishDetailUnitPrice, 
            int saleId, 
            int dishId
    ) {
        this.saleDishDetailId = saleDishDetailId;
        this.saleDishDetailQuantity = saleDishDetailQuantity;
        this.saleDishDetailUnitPrice = saleDishDetailUnitPrice;
        this.saleId = saleId;
        this.dishId = dishId;
    }

    public SaleDishDetail(
            int saleDishDetailQuantity, 
            double saleDishDetailUnitPrice, 
            int saleId, 
            int dishId
    ) {
        this.saleDishDetailQuantity = saleDishDetailQuantity;
        this.saleDishDetailUnitPrice = saleDishDetailUnitPrice;
        this.saleId = saleId;
        this.dishId = dishId;
    }

    public int getSaleDishDetailId() {
        return saleDishDetailId;
    }

    public void setSaleDishDetailId(int saleDishDetailId) {
        this.saleDishDetailId = saleDishDetailId;
    }

    public int getSaleDishDetailQuantity() {
        return saleDishDetailQuantity;
    }

    public void setSaleDishDetailQuantity(int saleDishDetailQuantity) {
        this.saleDishDetailQuantity = saleDishDetailQuantity;
    }

    public double getSaleDishDetailUnitPrice() {
        return saleDishDetailUnitPrice;
    }

    public void setSaleDishDetailUnitPrice(double saleDishDetailUnitPrice) {
        this.saleDishDetailUnitPrice = saleDishDetailUnitPrice;
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }
}
