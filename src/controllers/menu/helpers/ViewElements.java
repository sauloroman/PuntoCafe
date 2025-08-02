package controllers.menu.helpers;

import views.warehouse.WarehouseMenuInfo;

public class ViewElements {
    
    private final WarehouseMenuInfo menuInfoView;

    public ViewElements(WarehouseMenuInfo menuInfoView) {
        this.menuInfoView = menuInfoView;
    }
    
    public void clearCreateMenuForm() {
        menuInfoView.menuNameTxt.setText("");
        menuInfoView.menuDescriptionTxt.setText("");
    }
    
}
