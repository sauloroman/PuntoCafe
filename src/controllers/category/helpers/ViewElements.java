package controllers.category.helpers;

import views.warehouse.WarehouseCategories;
import views.warehouse.WarehouseCreateCategory;
import views.warehouse.WarehouseEditCategory;
import views.warehouse.WarehouseInfoCategory;

public class ViewElements {
    
    private final WarehouseCategories view;
    private final WarehouseCreateCategory createView;
    private final WarehouseInfoCategory infoView;
    private final WarehouseEditCategory editView;

    public ViewElements(WarehouseCategories view, WarehouseCreateCategory createView, WarehouseEditCategory editView, WarehouseInfoCategory infoView) {
        this.view = view;
        this.createView = createView;
        this.editView = editView;
        this.infoView = infoView;
    }
    
    public void clearInputSearch() {
        view.searchTxt.setText("");
    }
    
    public void clearFormCreateCategory() {
        createView.categoryNameTxt.setText("");
        createView.categoryDescTxt.setText("");
        createView.categoryTypeCombo.setSelectedItem("Selecciona un tipo");
        createView.categoryTypeCombo.setSelectedItem(0);
    }
    
    public void clearFormEditCategory() {
        editView.categoryNameTxt.setText("");
        editView.categoryDescTxt.setText("");
        editView.categoryTypeCombo.setSelectedItem("Selecciona un tipo");
        editView.categoryTypeCombo.setSelectedItem(0);
    }
    
    public void hidePagination() {
        view.pageCombo.setVisible(false);
        view.itemsPerPageComboBox.setVisible(false);
        view.pageTitle.setVisible(false);
        view.pageItems.setVisible(false);
    } 
    
    public void showPagination() {
        view.pageCombo.setVisible(true);
        view.itemsPerPageComboBox.setVisible(true);
        view.pageTitle.setVisible(true);
        view.pageItems.setVisible(true);
    }
    
}
