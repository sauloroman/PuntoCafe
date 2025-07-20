package controllers.dish.helpers;

import views.warehouse.WarehouseCreateDish;
import views.warehouse.WarehouseDishes;
import views.warehouse.WarehouseEditDish;

public class InputReader {
    
    private final WarehouseDishes view;
    private final WarehouseCreateDish createView;
    private final WarehouseEditDish editView;
    
    public InputReader(WarehouseDishes view, WarehouseCreateDish createView, WarehouseEditDish editView) {
        this.view = view;
        this.createView = createView;
        this.editView = editView;
    }
    
    public String getDishNameSearched() {
        String dishNameSearched = view.dishSearchByNameTxt.getText().trim();
        if ( dishNameSearched.isEmpty() ) return null;
        return dishNameSearched;
    }
    
    public String getCategorySelected() {
        String categorySelected = view.dishCategoryCombo.getSelectedItem().toString();
        if ( categorySelected.equals("Categorías") ) return null;
        return categorySelected;
    }
    
    public String getStatusSelected() {
        String statusSelected = view.dishStatusCombo.getSelectedItem().toString();
        if( statusSelected.equals("Estado") ) return null;
        return statusSelected;
    }
    
    public String getNameCreate() {
        String dishName = createView.dishNameTxt.getText().trim();
        if ( dishName == null || dishName.equals("Ingresa el nombre del platillo")) return "";
        return dishName;
    }
    
    public String getCategoryCreate() {
        String categorySelected = createView.dishCategoryCombo.getSelectedItem().toString().trim();
        if ( categorySelected == null || categorySelected.equals("Seleccione una categoría")) return "";
        return categorySelected;
    }
    
    public String getPriceCreate() {
        String price = createView.dishPriceTxt.getText().trim();
        if ( price == null ) return "";
        return price;
    }
    
    public String getDescriptionCreate() {
        String description = createView.dishDescriptionTxt.getText().trim();
        if ( description == null ) return "";
        return description;
    }
    
    public String getNameEdition() {
        String dishName = editView.dishEditNameTxt.getText().trim();
        if ( dishName == null || dishName.equals("Ingresa el nombre del platillo")) return "";
        return dishName;
    }
    
    public String getCategoryEdition() {
        String categorySelected = editView.dishEditCategoryCombo.getSelectedItem().toString().trim();
        if ( categorySelected == null || categorySelected.equals("Seleccione una categoría")) return "";
        return categorySelected;
    }
    
    public String getPriceEdition() {
        String price = editView.dishEditPriceTxt.getText().trim();
        if ( price == null ) return "";
        return price;
    }
    
    public String getDescriptionEdition() {
        String description = editView.dishEditDescriptionTxt.getText().trim();
        if ( description == null ) return "";
        return description;
    }
    
}
