package entities;

public class SaleProductDetail {
    
    private int saleProductDetailId;
    private int saleProductDetailQuantity;
    private double saleProductDetailUnitPrice;
    private double saleProductDetailDiscount;
    private int saleId;
    private int productId;

    public SaleProductDetail() {}

    public SaleProductDetail(
            int saleProductDetailId, 
            int saleProductDetailQuantity, 
            double saleProductDetailUnitPrice, 
            double saleProductDetailDiscount,
            int saleId, 
            int productId
    ) {
        this.saleProductDetailId = saleProductDetailId;
        this.saleProductDetailQuantity = saleProductDetailQuantity;
        this.saleProductDetailUnitPrice = saleProductDetailUnitPrice;
        this.saleProductDetailDiscount = saleProductDetailDiscount;
        this.saleId = saleId;
        this.productId = productId;
    }

    public SaleProductDetail(
            int saleProductDetailQuantity, 
            double saleProductDetailUnitPrice, 
            double saleProductDetailDiscount,
            int saleId, 
            int productId
    ) {
        this.saleProductDetailQuantity = saleProductDetailQuantity;
        this.saleProductDetailUnitPrice = saleProductDetailUnitPrice;
        this.saleProductDetailDiscount = saleProductDetailDiscount;
        this.saleId = saleId;
        this.productId = productId;
    }

    public int getSaleProductDetailId() {
        return saleProductDetailId;
    }

    public void setSaleProductDetailId(int saleProductDetailId) {
        this.saleProductDetailId = saleProductDetailId;
    }

    public int getSaleProductDetailQuantity() {
        return saleProductDetailQuantity;
    }

    public void setSaleProductDetailQuantity(int saleProductDetailQuantity) {
        this.saleProductDetailQuantity = saleProductDetailQuantity;
    }

    public double getSaleProductDetailUnitPrice() {
        return saleProductDetailUnitPrice;
    }

    public void setSaleProductDetailUnitPrice(double saleProductDetailUnitPrice) {
        this.saleProductDetailUnitPrice = saleProductDetailUnitPrice;
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public double getSaleProductDetailDiscount() {
        return saleProductDetailDiscount;
    }

    public void setSaleProductDetailDiscount(double saleProductDetailDiscount) {
        this.saleProductDetailDiscount = saleProductDetailDiscount;
    } 
    
}
