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
    
    public void resetComboBoxes() {
        view.filterStatus.setSelectedItem("Estado");
        view.filterStatus.setSelectedIndex(1);
        view.searchTxt.setText("Busca menús por nombre");
    }
    
}
