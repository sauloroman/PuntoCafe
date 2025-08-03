package controllers.menu.helpers;

import java.text.SimpleDateFormat;
import java.util.Date;
import utils.helpers.DateFilterPanel;
import views.warehouse.WarehouseMenuCreate;
import views.warehouse.WarehouseMenuInfo;
import views.warehouse.WarehouseMenus;

public class InputReader {
    
    private final WarehouseMenus view;
    private final WarehouseMenuInfo menuInfoView;
    private final WarehouseMenuCreate menuCreateView;
    private final DateFilterPanel dateFilterPanel;
    
    public InputReader(
            WarehouseMenus view,
            WarehouseMenuInfo menuInfoView,
            WarehouseMenuCreate menuCreateView,
            DateFilterPanel dateFilterPanel
    ) {
        this.view = view;
        this.menuInfoView = menuInfoView;
        this.menuCreateView = menuCreateView;
        this.dateFilterPanel = dateFilterPanel;
    }
    
    public String getDishSearched() {
        String dishSearched = menuCreateView.searchDishTxt.getText().trim();
        if ( dishSearched.equals("Busca platillos por nombre") ) return null;
        return dishSearched;
    }
    
    public String getMenuName() {
        String menuName = menuInfoView.menuNameTxt.getText().trim();
        if ( menuName.equals("Ingresa un nombre") ) return null;
        return menuName;
    }
    
    public String getMenuDescription() {
        String menuDesc = menuInfoView.menuDescriptionTxt.getText().trim();
        return menuDesc;
    }
    
    public String getStartDate() {
        Date dateSelected = dateFilterPanel.getStartDate();
        if ( dateSelected == null ) return null;
        return new SimpleDateFormat("yyyy-MM-dd").format(dateSelected);
    }
    
    public String getEndDate() {
        Date dateSelected = dateFilterPanel.getEndDate();
        if ( dateSelected == null ) return null;
        return new SimpleDateFormat("yyyy-MM-dd").format(dateSelected);
    }
    
    public String getMenuSearched() {
        String menuSearched = view.searchTxt.getText().trim();
        if ( menuSearched.equals("Busca menús por nombre") ) return null;
        return menuSearched;
    }
    
    public String getStatusSelected() {
        String status = view.filterStatus.getSelectedItem().toString();
        if ( status.equals("Estado") ) return null;
        return status;
    }
}
