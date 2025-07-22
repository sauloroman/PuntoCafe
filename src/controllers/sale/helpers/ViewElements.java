package controllers.sale.helpers;

import javax.swing.SpinnerNumberModel;
import views.sales.CreateSaleProductQuantity;
import entities.Product;
import views.sales.CreateSale;

public class ViewElements {
    
    private final CreateSale view;
    private final CreateSaleProductQuantity productQuantityView;

    public ViewElements(CreateSale view, CreateSaleProductQuantity productQuantityView) {
        this.view = view;
        this.productQuantityView = productQuantityView;
    }
    
    public void setLimitValueInProductSpinner( Product product ) {  
        int stock = product.getProductStock();
        SpinnerNumberModel model = (SpinnerNumberModel) productQuantityView.productSpinner.getModel();

        int currentValue = (Integer) model.getValue();
        int min = 1; 
        int step = 1;

        if (currentValue > stock) {
            currentValue = stock;
        }

        model.setMinimum(min);
        model.setMaximum(stock);
        model.setStepSize(step);
        model.setValue(currentValue);        
    }
    
    public void setCodeSell( String code ) {
        view.saleCode.setText(code);
    }
    
    public void setUserInfo( String username ) {
        view.userSeller.setText(username);
    }
    
    public void clearDisscountField() {
        productQuantityView.disscountQuantityTxt.setText("");
    }
    
}
