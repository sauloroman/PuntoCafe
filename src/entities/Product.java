package entities;

import java.util.Date;

public class Product {
    
    private int productId;
    private String productName;
    private String productDescription;
    private String productImage;
    private Double productSellingPrice;
    private int productStock;
    private int productStockMin;
    private boolean productIsActive;
    private Date productCreatedAt;
    private Date productUpdatedAt;
    private int categoryId;
    private int supplierId;

    public Product() {
    }
    
    public Product( int productId, String productName ) {
        this.productId = productId;
        this.productName = productName;
    }
    
     public Product( int productId, String productName, int stock, int stockMin ) {
        this.productId = productId;
        this.productName = productName;
        this.productStock = stock;
        this.productStockMin = stockMin;
    }

    public Product(
            int productId, 
            String productName, 
            String productDescription, 
            String productImage, 
            Double productSellingPrice, 
            int productStock, 
            int productStockMin, 
            boolean productIsActive,
            Date productCreatedAt, 
            Date productUpdatedAt,  
            int categoryId, 
            int supplierId
    ) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productImage = productImage;
        this.productSellingPrice = productSellingPrice;
        this.productStock = productStock;
        this.productStockMin = productStockMin;
        this.productCreatedAt = productCreatedAt;
        this.productUpdatedAt = productUpdatedAt;
        this.productIsActive = productIsActive;
        this.categoryId = categoryId;
        this.supplierId = supplierId;
    }

    public Product(
            String productName, 
            String productDescription, 
            String productImage, 
            Double productSellingPrice, 
            int productStock, 
            int productStockMin, 
            int categoryId, 
            int supplierId
    ) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productImage = productImage;
        this.productSellingPrice = productSellingPrice;
        this.productStock = productStock;
        this.productStockMin = productStockMin;
        this.categoryId = categoryId;
        this.supplierId = supplierId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public Double getProductSellingPrice() {
        return productSellingPrice;
    }

    public void setProductSellingPrice(Double productSellingPrice) {
        this.productSellingPrice = productSellingPrice;
    }

    public int getProductStock() {
        return productStock;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }

    public int getProductStockMin() {
        return productStockMin;
    }

    public void setProductStockMin(int productStockMin) {
        this.productStockMin = productStockMin;
    }

    public boolean getProductIsActive() {
        return productIsActive;
    }

    public void setProductIsActive(boolean productIsActive) {
        this.productIsActive = productIsActive;
    }

    public Date getProductCreatedAt() {
        return productCreatedAt;
    }

    public void setProductCreatedAt(Date productCreatedAt) {
        this.productCreatedAt = productCreatedAt;
    }

    public Date getProductUpdatedAt() {
        return productUpdatedAt;
    }

    public void setProductUpdatedAt(Date productUpdatedAt) {
        this.productUpdatedAt = productUpdatedAt;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    @Override
    public String toString() {
        return "Product{" + "productId=" + productId + ", productName=" + productName + ", productDescription=" + productDescription + ", productImage=" + productImage + ", productSellingPrice=" + productSellingPrice + ", productStock=" + productStock + ", productStockMin=" + productStockMin + ", productIsActive=" + productIsActive + ", productCreatedAt=" + productCreatedAt + ", productUpdatedAt=" + productUpdatedAt + ", categoryId=" + categoryId + ", supplierId=" + supplierId + '}';
    }
    
}
