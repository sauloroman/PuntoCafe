package controllers.category.helpers;

import views.warehouse.WarehouseCategories;
import views.warehouse.WarehouseCreateCategory;
import views.warehouse.WarehouseEditCategory;

public class InputReader {
    
    private WarehouseCategories view;
    private WarehouseCreateCategory createView;
    private WarehouseEditCategory editView;

    public InputReader(WarehouseCategories view, WarehouseCreateCategory createView, WarehouseEditCategory editView) {
        this.view = view;
        this.createView = createView;
        this.editView = editView;
    }
    
    public String getNameSearched() {
        String nameSearched = view.searchTxt.getText().trim();
        if ( nameSearched.isEmpty() || nameSearched.equals("Buscar categoría por nombre")) return null;
        return nameSearched;
    }
    
    public String getNameCreation() {
        return createView.categoryNameTxt.getText();
    }
    
    public String getDescCreation() {
        return createView.categoryDescTxt.getText();
    }
    
    public String getTypeCreation() {
        return createView.categoryTypeCombo.getSelectedItem().toString().trim().toLowerCase();
    }
    
    public String getNameEdition() {
        return editView.categoryNameTxt.getText();
    }
    
    public String getDescEdition() {
        return editView.categoryDescTxt.getText();
    }
    
    public String getTypeEdition() {
        return editView.categoryTypeCombo.getSelectedItem().toString().trim().toLowerCase();
    }

}
