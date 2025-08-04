package controllers.menu.helpers;

import java.text.SimpleDateFormat;
import java.util.Date;
import utils.helpers.DateFilterPanel;
import views.warehouse.WarehouseMenuCreate;
import views.warehouse.WarehouseMenuEditInfo;
import views.warehouse.WarehouseMenuInfo;
import views.warehouse.WarehouseMenus;

public class InputReader {
    
    private final WarehouseMenus view;
    private final WarehouseMenuInfo menuInfoView;
    private final WarehouseMenuEditInfo menuEditInfoView;
    private final WarehouseMenuCreate menuCreateView;
    private final DateFilterPanel dateFilterPanelCreate;
    private final DateFilterPanel dateFilterPanelEdit;
    
    public InputReader(
            WarehouseMenus view,
            WarehouseMenuInfo menuInfoView,
            WarehouseMenuEditInfo menuEditInfoView,
            WarehouseMenuCreate menuCreateView,
            DateFilterPanel dateFilterPanel,
            DateFilterPanel dateFilterPanelEdit
    ) {
        this.view = view;
        this.menuInfoView = menuInfoView;
        this.menuEditInfoView = menuEditInfoView;
        this.menuCreateView = menuCreateView;
        this.dateFilterPanelCreate = dateFilterPanel;
        this.dateFilterPanelEdit = dateFilterPanelEdit;
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
    
    public String getMenuNameEdit() {
        String menuName = menuEditInfoView.menuNameTxt.getText().trim();
        if ( menuName.equals("Ingresa un nombre") ) return null;
        return menuName;
    }
    
    public String getMenuDescription() {
        String menuDesc = menuInfoView.menuDescriptionTxt.getText().trim();
        return menuDesc;
    }
    
    public String getMenuDescriptionEdit() {
        String menuDesc = menuEditInfoView.menuDescriptionTxt.getText().trim();
        return menuDesc;
    }
    
    public String getStartDate() {
        Date dateSelected = dateFilterPanelCreate.getStartDate();
        if ( dateSelected == null ) return null;
        return new SimpleDateFormat("yyyy-MM-dd").format(dateSelected);
    }
    
    public String getStartDateEdit() {
        Date dateSelected = dateFilterPanelEdit.getStartDate();
        if ( dateSelected == null ) return null;
        return new SimpleDateFormat("yyyy-MM-dd").format(dateSelected);
    }
    
    public String getEndDate() {
        Date dateSelected = dateFilterPanelCreate.getEndDate();
        if ( dateSelected == null ) return null;
        return new SimpleDateFormat("yyyy-MM-dd").format(dateSelected);
    }
    
    public String getEndDateEdit() {
        Date dateSelected = dateFilterPanelEdit.getStartDate();
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
