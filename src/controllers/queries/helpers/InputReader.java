package controllers.queries.helpers;

import views.queries.ProductsLowRotation;
import views.queries.ProductsMostSold;

public class InputReader {
    
    private final ProductsLowRotation productsLowRotationView;
    private final ProductsMostSold productsMostSold;

    public InputReader(
            ProductsLowRotation productsLowRotationView,
            ProductsMostSold productsMostSold
    ) {
        this.productsLowRotationView = productsLowRotationView;
        this.productsMostSold = productsMostSold;
    }
    
    public int getQuantityProductsLowRotation() {
        return Integer.parseInt(productsLowRotationView.quantityCombo.getSelectedItem().toString());
    }
    
    public int getQuantityProductsMostSold() {
        return Integer.parseInt(productsMostSold.quantityCombo.getSelectedItem().toString());
    }
    
}
