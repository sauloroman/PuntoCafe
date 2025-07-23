package controllers.sale.helpers;

import entities.Dish;
import entities.Product;
import views.sales.CreateSaleDishQuantity;
import views.sales.CreateSaleProductQuantity;

public class LoadInformation {
    
    private final CreateSaleProductQuantity productQuantityView;
    private final CreateSaleDishQuantity dishQuantityView;

    public LoadInformation(
            CreateSaleProductQuantity productQuantityView,
            CreateSaleDishQuantity dishQuantityView
    ) {
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
    
}
