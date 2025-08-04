package controllers.menu.helpers;

import entities.Menu;
import utils.helpers.DateFilterPanel;
import views.warehouse.WarehouseMenuCreate;
import views.warehouse.WarehouseMenuDetail;
import views.warehouse.WarehouseMenuEdit;
import views.warehouse.WarehouseMenuEditInfo;

public class LoadInformation {
    
    private final WarehouseMenuCreate menuCreateView;
    private final WarehouseMenuDetail menuDetailView;
    private final WarehouseMenuEdit menuEditView;
    private final WarehouseMenuEditInfo menuEditInfoView;

    public LoadInformation(
            WarehouseMenuCreate menuCreateView, 
            WarehouseMenuDetail menuDetailView,
            WarehouseMenuEdit menuEditView,
            WarehouseMenuEditInfo menuEditInfoView
    ) {
        this.menuCreateView = menuCreateView;
        this.menuDetailView = menuDetailView;
        this.menuEditView = menuEditView;
        this.menuEditInfoView = menuEditInfoView;
    }
    
    public void loadCreateMenuInformation(String menuName, String menuStartDate, String menuEndDate) {
        menuCreateView.menuNameLabel.setText("\"" + menuName + "\"");
        menuCreateView.menuStartDate.setText("\\  " + menuStartDate);
        menuCreateView.menuEndDate.setText("\\  " + menuEndDate);
    }
    
    public void loadEditMenuInformation(String menuName, String menuStartDate, String menuEndDate) {
        menuEditView.menuNameLabel.setText("\"" + menuName + "\"");
        menuEditView.menuStartDate.setText("\\  " + menuStartDate.substring(0, 10));
        menuEditView.menuEndDate.setText("\\  " + menuEndDate.substring(0, 10));
    }
    
    public void loadMenuDetailName(String menuName) {
        menuDetailView.menuNameLabel.setText(menuName);
    }
    
    public void loadEditMenuInfo(Menu menu, DateFilterPanel datePanel) {
        menuEditInfoView.menuNameTxt.setText(menu.getMenuName());
        menuEditInfoView.menuDescriptionTxt.setText(menu.getMenuDescription());
        datePanel.setStartDate(menu.getMenuStartDate());
        datePanel.setEndDate(menu.getMenuEndDate());
    }
    
}
