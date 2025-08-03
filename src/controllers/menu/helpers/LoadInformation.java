package controllers.menu.helpers;

import views.warehouse.WarehouseMenuCreate;
import views.warehouse.WarehouseMenuDetail;

public class LoadInformation {
    
    private final WarehouseMenuCreate menuCreateView;
    private final WarehouseMenuDetail menuDetailView;

    public LoadInformation(WarehouseMenuCreate menuCreateView, WarehouseMenuDetail menuDetailView) {
        this.menuCreateView = menuCreateView;
        this.menuDetailView = menuDetailView;
    }
    
    public void loadCreateMenuInformation(String menuName, String menuStartDate, String menuEndDate) {
        menuCreateView.menuNameLabel.setText("\"" + menuName + "\"");
        menuCreateView.menuStartDate.setText("\\" + menuStartDate);
        menuCreateView.menuEndDate.setText("\\" + menuEndDate);
    }
    
    public void leadMenuDetailName(String menuName) {
        menuDetailView.menuNameLabel.setText(menuName);
    }
    
}
