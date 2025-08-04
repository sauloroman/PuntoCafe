package views.warehouse;

import entities.User;
import utils.constants.ViewConstants;
import views.components.Button;
import views.components.Input;

public class WarehouseMenuInit {
    
    private final User user;
    private final WarehouseMenus view;
    private final int PANEL_WIDTH = 1290;
    private final int PANEL_HEIGHT = 800;
    private final String INPUT_COLOR = "#DDDDDD";
    private final Button buttonGenerator = new Button(); 
    private final Input inputGenerator = new Input();

    public WarehouseMenuInit(WarehouseMenus view, User user) {
        this.view = view;
        this.user = user;
    }
    
    public void init() {
        view.setVisible(true);
        view.setSize(PANEL_WIDTH, PANEL_HEIGHT);
    
        buttonGenerator.solidButton(view.btnCreateMenu, ViewConstants.skyColor, "#FFFFFF", 12);
        buttonGenerator.addIcon(view.btnCreateMenu, "icon-plus-white", 16);
        buttonGenerator.solidButton(view.btnSearch, ViewConstants.blackColor, "#FFFFFF", 12);
        buttonGenerator.addIcon(view.btnSearch, "icon-search", 16);
        buttonGenerator.outlineButton(view.btnRestore, "#DDDDDD", ViewConstants.textBtn);
        buttonGenerator.addIcon(view.btnRestore, "icon-reload", 16);
        
        inputGenerator.roundedComboBox(view.pageComboBox, "#DDDDDD", 10);
        inputGenerator.roundedField(view.searchTxt, "#DDDDDD", 10, "Busca menús por nombre");
        inputGenerator.roundedComboBox(view.filterStatus, "#DDDDDD", 10);
        
        hideElementsDependingRole();
    }
    
    private void hideElementsDependingRole() {
        if ( user.getRoleId() == 2 || user.getRoleId() == 3 ) {
            view.btnCreateMenu.setVisible(false);
            view.btnCreateMenu.setSize(0, 0);
        }
    }
    
}
