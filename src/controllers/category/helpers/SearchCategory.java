package controllers.category.helpers;

import views.warehouse.WarehouseCategories;

public class SearchCategory {
    
    private final WarehouseCategories view;

    public SearchCategory(
            WarehouseCategories view
    ) {
        this.view = view;
    }

    public String getSearchCriteria() {
        String input = view.searchTxt.getText().trim();
        view.pageComboBox.setSelectedIndex(0);
        view.itemsPerPageComboBox.setSelectedIndex(0);
        return input;
    }
}
