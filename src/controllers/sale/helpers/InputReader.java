package controllers.sale.helpers;

import views.sales.CreateSale;
import views.sales.CreateSaleProductQuantity;

public class InputReader {

    private final CreateSale view;
    private final CreateSaleProductQuantity productQuantity;

    public InputReader(CreateSale view, CreateSaleProductQuantity productQuantity) {
        this.view = view;
        this.productQuantity = productQuantity;
    }
    
    public String getProductNameSearch() {
       String nameSearched = view.searchProductTxt.getText().trim();
       if ( nameSearched.equals("Busca productos por su nombre") ) return null;
       return nameSearched;
    }
    
    public int getQuantityProducts() {
        return (int)productQuantity.productSpinner.getValue();
    }
    
    public double getProductPrice() {
        return Double.parseDouble(productQuantity.sellingPrice.getText());
    }
    
    public double getDisscountProduct() {
        String newPrice = productQuantity.disscountQuantityTxt.getText().trim();
        if ( newPrice.isEmpty() ) return 0;
        return Double.parseDouble(newPrice);
    }
    
}
