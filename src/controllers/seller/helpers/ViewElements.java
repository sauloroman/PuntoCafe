package controllers.seller.helpers;

import javax.swing.SpinnerNumberModel;
import views.sales.CreateSaleProductQuantity;
import entities.Product;
import views.sales.CreateSale;
import views.sales.CreateSaleDishQuantity;

public class ViewElements {
    
    private final CreateSale view;
    private final CreateSaleProductQuantity productQuantityView;
    private final CreateSaleDishQuantity dishQuantityView;

    public ViewElements(
            CreateSale view, 
            CreateSaleProductQuantity productQuantityView,
            CreateSaleDishQuantity dishQuantityView
    ) {
        this.view = view;
        this.productQuantityView = productQuantityView;
        this.dishQuantityView = dishQuantityView;
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
    
    public void setCurrentDate(String formattedDate) {
        view.saleDate.setText(formattedDate);
    }
    
    public void clearSpinnerFieldProduct() {
        SpinnerNumberModel model = (SpinnerNumberModel) productQuantityView.productSpinner.getModel();
        model.setValue(1);
    }
    
    public void clearDiscountFieldProduct() {
        productQuantityView.disscountQuantityTxt.setText("");
    }
    
    public void clearSpinnerFieldDish() {
        SpinnerNumberModel model = (SpinnerNumberModel) dishQuantityView.dishSpinner.getModel();
        model.setValue(1);
    }
    
    public void clearDiscountFieldDish() {
        dishQuantityView.disscountQuantityTxt.setText("");
    }
    
    public void clearTotalSale() {
        view.subtotal.setText("$0.00");
        view.disccount.setText("$0.00");
        view.total.setText("$0.00");
    }
    
    public void clearSaleList() {
        view.saleList.removeAll();
        view.saleList.revalidate();
        view.saleList.repaint();
    }
    
}
