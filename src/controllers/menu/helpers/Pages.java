package controllers.menu.helpers;

import views.warehouse.WarehouseMenus;

public class Pages {
    
    private final WarehouseMenus view;

    public Pages(WarehouseMenus view) {
        this.view = view;
    }
    
    public void create(int quantityMenus) {
        int pages = calculatePages(quantityMenus);
        fillPageComboBox(pages);
    }
    
    private void fillPageComboBox( int pages ) {
        view.pageComboBox.removeAllItems();
        for ( int i = 1; i <= pages; i++ ) {
            view.pageComboBox.addItem(String.valueOf(i));
        }
        if ( pages == 0 ) {
            view.pageComboBox.addItem("1");
        }
        view.pageComboBox.setSelectedIndex(0);
    }
    
    private int calculatePages( int quantityProducts ) {
        return Math.max((int) Math.ceil((double) quantityProducts / 12), 1);
    }
    
    public int getPageSelected() {
        int page = Integer.parseInt(view.pageComboBox.getSelectedItem().toString());
        return page;
    }
    
}
