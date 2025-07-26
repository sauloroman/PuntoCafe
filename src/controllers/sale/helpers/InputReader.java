package controllers.sale.helpers;

import java.text.SimpleDateFormat;
import java.util.Date;
import utils.helpers.DateFilterPanel;
import views.sales.CreateSale;
import views.sales.CreateSaleDishQuantity;
import views.sales.CreateSaleProductQuantity;
import views.sales.Sales;

public class InputReader {

    private final Sales view;
    private final CreateSale createView;
    private final CreateSaleProductQuantity productQuantity;
    private final CreateSaleDishQuantity dishQuantity;
    private final DateFilterPanel dateFilterPanel;

    public InputReader(
            Sales view,
            CreateSale createView, 
            CreateSaleProductQuantity productQuantity,
            CreateSaleDishQuantity dishQuantity,
            DateFilterPanel dateFilterPanel
    ) {
        this.view = view;
        this.createView = createView;
        this.productQuantity = productQuantity;
        this.dishQuantity = dishQuantity;
        this.dateFilterPanel = dateFilterPanel;
    }
    
    public String getUserFiltered() {
        String user = view.filterUsers.getSelectedItem().toString();
        if ( user.equals("Usuarios") ) return null;
        return user;
    }
    
    public String getStartDate() {
        Date dateSelected = dateFilterPanel.getStartDate();
        if ( dateSelected == null ) return null;
        return new SimpleDateFormat("yyyy-MM-dd").format(dateSelected);
    }
    
    public String getEndDate() {
        Date dateSelected = dateFilterPanel.getEndDate();
        if ( dateSelected == null ) return null;
        return new SimpleDateFormat("yyyy-MM-dd").format(dateSelected);
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
