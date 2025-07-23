package entities;

import interfaces.SaleItem;

public class ProductItem implements SaleItem<Product> {
    
    private Product product;
    private int quantity;
    private double discount;

    public ProductItem(Product product, int quantity, double disscount) {
        this.product = product;
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
    public Product getItem() {
        return this.product;
    }

    @Override
    public void setItem(Product item) {
        this.product = item;
                
    }

    @Override
    public String getImage() {
        return this.product.getProductImage();
    }

    @Override
    public String getName() {
        return this.product.getProductName();
    }

    @Override
    public Double getSellingPrice() {
        return this.product.getProductSellingPrice();
    }

    @Override
    public int getId() {
        return this.product.getProductId();
    }

    @Override
    public boolean getIsActive() {
        return this.product.getProductIsActive();
    }
}
