package controllers.menu.helpers;

import views.warehouse.WarehouseMenuCreate;

public class LoadInformation {
    
    private final WarehouseMenuCreate menuCreateView;

    public LoadInformation(WarehouseMenuCreate menuCreateView) {
        this.menuCreateView = menuCreateView;
    }
    
    public void loadCreateMenuInformation(String menuName) {
        menuCreateView.menuNameLabel.setText("\"" + menuName + "\"");
    }
    
}
