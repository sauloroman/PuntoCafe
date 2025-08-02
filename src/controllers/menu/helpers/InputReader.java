package controllers.menu.helpers;

import java.text.SimpleDateFormat;
import java.util.Date;
import utils.helpers.DateFilterPanel;
import views.warehouse.WarehouseMenuCreate;
import views.warehouse.WarehouseMenuInfo;

public class InputReader {
    
    private final WarehouseMenuInfo menuInfoView;
    private final WarehouseMenuCreate menuCreateView;
    private final DateFilterPanel dateFilterPanel;
    
    public InputReader(
            WarehouseMenuInfo menuInfoView,
            WarehouseMenuCreate menuCreateView,
            DateFilterPanel dateFilterPanel
    ) {
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
}
