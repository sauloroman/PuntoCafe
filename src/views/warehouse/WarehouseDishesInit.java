package views.warehouse;

import entities.User;
import java.awt.Color;
import utils.constants.ViewConstants;
import views.components.Button;
import views.components.Input;

public class WarehouseDishesInit {
    
    private final User user;
    private final WarehouseDishes view;
    private final int PANEL_WIDTH = 1320;
    private final int PANEL_HEIGHT = 900;
    private final String INPUT_COLOR = "#DDDDDD";
    private final Button buttonGenerator = new Button(); 
    private final Input inputGenerator = new Input();

    public WarehouseDishesInit(WarehouseDishes view, User user) {
        this.view = view;
        this.user = user;
    }
    
    public void init() {
        view.setVisible(true);
        view.setSize(PANEL_WIDTH, PANEL_HEIGHT);
        view.dishesGrid.setBackground(Color.decode("#F4F6F6"));
        
        buttonGenerator.solidButton(view.btnNewDish, ViewConstants.skyColor, "#FFFFFF", 12);
        buttonGenerator.addIcon(view.btnNewDish, "icon-plus-white", 20);
        buttonGenerator.outlineButton(view.btnExportDishes, INPUT_COLOR, ViewConstants.textBtn);
        buttonGenerator.addIcon(view.btnExportDishes, "icon-print", 20);
        buttonGenerator.solidButton(view.btnSearch, ViewConstants.blackColor, "#FFFFFF", 11);
        buttonGenerator.addIcon(view.btnSearch, "icon-search", 20);
        buttonGenerator.outlineButton(view.btnReload, "#DDDDDD", ViewConstants.textBtn);
        buttonGenerator.addIcon(view.btnReload, "icon-reload", 20);
        
        inputGenerator.roundedComboBox(view.dishStatusCombo, INPUT_COLOR, 10);
        inputGenerator.roundedComboBox(view.dishCategoryCombo, INPUT_COLOR, 10);
        inputGenerator.roundedField(view.dishSearchByNameTxt, INPUT_COLOR, 10, "Busca platillos por nombre");
        inputGenerator.roundedComboBox(view.pageComboBox, INPUT_COLOR, 10);
     
        hideElementsByRole();
    }
    
    private void hideElementsByRole() {
        if ( user.getRoleId() == 2 || user.getRoleId() == 3 ) {
            view.btnNewDish.setVisible(false);
            view.btnNewDish.setSize(0, 0);
        }
    }
    
}
