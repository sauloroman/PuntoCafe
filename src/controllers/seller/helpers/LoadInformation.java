package controllers.seller.helpers;

import entities.Dish;
import entities.Product;
import views.sales.CreateSaleDishQuantity;
import views.sales.CreateSaleProductQuantity;
import views.sales.SaleDetail;

public class LoadInformation {
    
    private final SaleDetail detailView;
    private final CreateSaleProductQuantity productQuantityView;
    private final CreateSaleDishQuantity dishQuantityView;

    public LoadInformation(
            SaleDetail detailView,
            CreateSaleProductQuantity productQuantityView,
            CreateSaleDishQuantity dishQuantityView
    ) {
        this.detailView = detailView;
        this.productQuantityView = productQuantityView;
        this.dishQuantityView = dishQuantityView;
    }
    
    public void productQuantiy(Product product) {
        productQuantityView.productName.setText(product.getProductName());
        productQuantityView.productStock.setText(product.getProductStock() + "");
        productQuantityView.sellingPrice.setText(product.getProductSellingPrice() + "0");
    }
    
    public void dishQuantity(Dish dish) {
        dishQuantityView.dishName.setText(dish.getDishName());
        dishQuantityView.sellingPrice.setText(dish.getDishSellingPrice() + "");
    }
    
    public void setSaleDateInDetailWindow(String date) {
        detailView.saleDate.setText(date);
    }
    
}
