package views.access;

import javax.swing.SwingUtilities;
import views.access.AccessUsers;
import views.components.Button;
import views.components.Input;
import views.components.Table;
import utils.constants.ViewConstants;

public class AccessUsersInit {
    
    private final AccessUsers view;
    private final int PANEL_WIDTH = 1200;
    private final int PANEL_HEIGHT = 900;
    private final Button buttonGenerator  = new Button();
    private final Input input = new Input();

    public AccessUsersInit(AccessUsers view) {
        this.view = view;
    }
    
    public void init() {
        view.setVisible(true);
        view.setSize(PANEL_WIDTH, PANEL_HEIGHT);
        
        Table.tableStyle3(view.usersTable);
        
        buttonGenerator.solidButton(view.btnNewUser, "#000000", "#FFFFFF", 11);
        buttonGenerator.addIcon(view.btnNewUser, "icon-plus-white", 20);
        buttonGenerator.solidButton(view.btnSearch, "#000000", "#FFFFFF", 11);
        buttonGenerator.addIcon(view.btnSearch, "icon-search", 20);
        buttonGenerator.outlineButton(view.btnSeeUser, "#DDDDDD", ViewConstants.textBtn);
        buttonGenerator.addIcon(view.btnSeeUser, "icon-eye", 20);
        buttonGenerator.solidButton(view.btnRestore, ViewConstants.skyColor, ViewConstants.whiteColor, 11);
        view.btnRestore.setVisible(false);
        
        input.roundedComboBox(view.userRoleCombo, "#DDDDDD", 10);
        input.roundedField(view.searchUserTxt, "#DDDDDD", 10, "");
        input.roundedComboBox(view.pageCombo, "#DDDDDD", 10);
        input.roundedComboBox(view.itemsPerPageComboBox, "#DDDDDD", 10);
        
        SwingUtilities.updateComponentTreeUI(view);
        
    }
}
