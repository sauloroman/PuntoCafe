package controllers.seller.helpers;

import java.text.SimpleDateFormat;
import java.util.Date;
import views.sales.CreateSale;
import views.sales.CreateSaleDishQuantity;
import views.sales.CreateSaleProductQuantity;

public class InputReader {

    private final CreateSale createView;
    private final CreateSaleProductQuantity productQuantity;
    private final CreateSaleDishQuantity dishQuantity;

    public InputReader(
            CreateSale createView, 
            CreateSaleProductQuantity productQuantity,
            CreateSaleDishQuantity dishQuantity
    ) {
        this.createView = createView;
        this.productQuantity = productQuantity;
        this.dishQuantity = dishQuantity;
    }
    
    public String getProductNameSearch() {
       String nameSearched = createView.searchProductTxt.getText().trim();
       if ( nameSearched.equals("Busca productos por su nombre") ) return null;
       return nameSearched;
    }
    
    public String getDishNameSearch() {
       String nameSearched = createView.searchDishTxt.getText().trim();
       if ( nameSearched.equals("Busca platillos por su nombre") ) return null;
       return nameSearched;
    }
    
    public int getQuantityProducts() {
        return (int)productQuantity.productSpinner.getValue();
    }
    
    public double getProductPrice() {
        return Double.parseDouble(productQuantity.sellingPrice.getText());
    }
    
    public double getDiscountProduct() {
        String newPrice = productQuantity.disscountQuantityTxt.getText().trim();
        if ( newPrice.isEmpty() ) return 0;
        return Double.parseDouble(newPrice);
    }
    
    public int getQuantityDishes() {
        return (int)dishQuantity.dishSpinner.getValue();
    }
    
    public double getDishPrice() {
        return Double.parseDouble(dishQuantity.sellingPrice.getText());
    }
    
    public double getDiscountDish() {
        String newPrice = dishQuantity.disscountQuantityTxt.getText().trim();
        if ( newPrice.isEmpty() ) return 0;
        return Double.parseDouble(newPrice);
    }
    
}
