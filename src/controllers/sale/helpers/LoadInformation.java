package controllers.sale.helpers;

import entities.Product;
import views.sales.CreateSaleProductQuantity;

public class LoadInformation {
    
    private final CreateSaleProductQuantity productQuantityView;

    public LoadInformation(CreateSaleProductQuantity productQuantityView) {
        this.productQuantityView = productQuantityView;
    }
    
    public void productQuantiy(Product product) {
        productQuantityView.productName.setText(product.getProductName());
        productQuantityView.productStock.setText(product.getProductStock() + "");
        productQuantityView.sellingPrice.setText(product.getProductSellingPrice() + "0");
    }
    
}
