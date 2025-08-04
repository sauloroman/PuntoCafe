package controllers.menu.helpers;

import views.warehouse.WarehouseMenuEditInfo;
import views.warehouse.WarehouseMenuInfo;
import views.warehouse.WarehouseMenus;

public class ViewElements {
    
    private final WarehouseMenus view;
    private final WarehouseMenuInfo menuInfoView;
    private final WarehouseMenuEditInfo menuEditInfoView;

    public ViewElements(WarehouseMenus view, WarehouseMenuInfo menuInfoView, WarehouseMenuEditInfo menuEditInfoView) {
        this.view = view;
        this.menuInfoView = menuInfoView;
        this.menuEditInfoView = menuEditInfoView;
    }
    
    public void clearCreateMenuForm() {
        menuInfoView.menuNameTxt.setText("");
        menuInfoView.menuDescriptionTxt.setText("");
    }
    
    public void clearEditMenuForm() {
        menuEditInfoView.menuNameTxt.setText("");
        menuEditInfoView.menuDescriptionTxt.setText("");
    }
    
    public void resetComboBoxes() {
        view.filterStatus.setSelectedItem("Estado");
        view.filterStatus.setSelectedIndex(1);
        view.searchTxt.setText("Busca menús por nombre");
    }
    
}
