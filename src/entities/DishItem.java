package entities;

import interfaces.SaleItem;

public class DishItem implements SaleItem<Dish> {
    
    private Dish dish;
    private int quantity;
    private double discount;
    
    public DishItem(Dish dish, int quantity, double disscount) {
        this.dish = dish;
        this.quantity = quantity;
        this.discount = disscount;
    }
    
    @Override
    public int getQuantity() {
        return this.quantity;
    }

    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public double getDiscount() {
        return this.discount;
    }

    @Override
    public void setDiscount(double disscount) {
        this.discount = disscount;
    }

    @Override
    public Dish getItem() {
        return this.dish;
    }

    @Override
    public void setItem(Dish item) {
        this.dish = item;
    }
    
    @Override
    public String getImage() {
        return this.dish.getDishImage();
    }

    @Override
    public String getName() {
        return this.dish.getDishName();
    }

    @Override
    public Double getSellingPrice() {
        return this.dish.getDishSellingPrice();
    }
    
    @Override
    public int getId() {
        return this.dish.getDishID();
    }
    
    @Override
    public boolean getIsActive() {
        return this.dish.getIsActive();
    }
    
}
