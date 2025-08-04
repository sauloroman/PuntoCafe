package views.warehouse;

import entities.User;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.SwingUtilities;
import utils.constants.ViewConstants;
import views.components.Button;
import views.components.Input;
import views.components.Table;

public class WarehouseCategoriesInit {
    
    private final User user;
    private final WarehouseCategories view;
    private final String INPUT_COLOR = "#DDDDDD";
    private final int PANEL_WIDTH = 1320;
    private final int PANEL_HEIGHT = 900;
    private final Button buttonGenerator = new Button(); 
    private final Input inputGenerator = new Input();

    public WarehouseCategoriesInit(WarehouseCategories view, User user) {
        this.view = view;
        this.user = user;
    }
    
    public void init() {
        view.setVisible(true);
        view.setSize(PANEL_WIDTH, PANEL_HEIGHT);
        
        Table.tableStyle3(view.categoriesTable);
        view.scrollTable.setBorder(BorderFactory.createLineBorder(Color.decode("#DDDDDD")));   
        
        inputGenerator.roundedField(view.searchTxt, INPUT_COLOR, 8, "Buscar categoría por nombre");
        inputGenerator.roundedComboBox(view.categoryTypeCombo, "#DDDDDD", 10);
        inputGenerator.roundedComboBox(view.pageCombo, "#DDDDDD", 10);
        inputGenerator.roundedComboBox(view.itemsPerPageComboBox, "#DDDDDD", 10);
        
        buttonGenerator.outlineButton(view.btnSeeCategory, INPUT_COLOR, ViewConstants.textBtn);
        buttonGenerator.addIcon(view.btnSeeCategory, "icon-eye", 20);
        buttonGenerator.solidButton(view.btnNew, ViewConstants.skyColor, "#FFFFFF", 12);
        buttonGenerator.addIcon(view.btnNew, "icon-plus-white", 20);
        buttonGenerator.solidButton(view.btnSearch, ViewConstants.blackColor, ViewConstants.whiteColor, 12);
        buttonGenerator.addIcon(view.btnSearch, "icon-search", 20);
        buttonGenerator.outlineButton(view.btnRestore, "#DDDDDD", ViewConstants.textBtn);
        buttonGenerator.addIcon(view.btnRestore, "icon-reload", 16);
        
        SwingUtilities.updateComponentTreeUI(view); 
        
        hideElementsDependingRole();
    }
    
    private void hideElementsDependingRole() {
        if ( user.getRoleId() == 2 || user.getRoleId() == 3 ) {
            view.btnNew.setVisible(false);
            view.btnNew.setSize(0, 0);
        }
    }
}
