package controllers.category.helpers;

import utils.helpers.Modal;
import views.warehouse.WarehouseCategories;

public class LoadEditCategory {

    private final WarehouseCategories view;
    private final Modal modal;

    public LoadEditCategory(WarehouseCategories view, Modal modal) {
        this.view = view;
        this.modal = modal;
    }

    public void load() {
        int row = view.categoriesTable.getSelectedRow();
        
        view.categoryIdSelected.setText(view.categoriesTable.getValueAt(row, 0).toString());
        view.categoryNameSelected.setText(view.categoriesTable.getValueAt(row, 1).toString());
        view.categoryDescriptionSelected.setText(view.categoriesTable.getValueAt(row, 2).toString());
        view.categoryTypeSelected.setText(view.categoriesTable.getValueAt(row, 3).toString());
        view.categoryCreatedSelected.setText(view.categoriesTable.getValueAt(row, 4).toString());
        view.categoryUpdatedSelected.setText(view.categoriesTable.getValueAt(row, 5).toString());
        view.categoryStatusSelected.setText(view.categoriesTable.getValueAt(row, 6).toString());
        
        view.editCategoryNameTxt.setText(view.categoryNameSelected.getText());
        view.editCategoryDescriptionTxt.setText(view.categoryDescriptionSelected.getText());
        view.editCategoryTypeCombo.setSelectedItem(view.categoryTypeSelected.getText());
    }
    
}
