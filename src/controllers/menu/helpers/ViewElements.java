package controllers.menu.helpers;

import views.warehouse.WarehouseMenuInfo;
import views.warehouse.WarehouseMenus;

public class ViewElements {
    
    private final WarehouseMenus view;
    private final WarehouseMenuInfo menuInfoView;

    public ViewElements(WarehouseMenus view, WarehouseMenuInfo menuInfoView) {
        this.view = view;
        this.menuInfoView = menuInfoView;
    }
    
    public void clearCreateMenuForm() {
        menuInfoView.menuNameTxt.setText("");
        menuInfoView.menuDescriptionTxt.setText("");
    }
    
    public void setQuantityMenus( int quantity ) {
        view.quantityMenus.setText("" + quantity);
    }
    
    public void setCountMenusPages( int quantity, int total ) {
        view.quantityItems.setText("Visualizando " + quantity + " de " + total + " menús");
    }
    
}
