package entities;

public class ProductItem {
 
    private Product product;
    private int quantity;
    private double disscount;

    public ProductItem(Product product, int quantity, double disscount) {
        this.product = product;
        this.quantity = quantity;
        this.disscount = disscount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getDisscount() {
        return disscount;
    }

    public void setDisscount(double disscount) {
        this.disscount = disscount;
    }
    
    
    
}
