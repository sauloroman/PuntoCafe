package views.access;

import entities.User;
import javax.swing.SwingUtilities;
import views.components.Button;
import views.components.Input;
import views.components.Table;
import utils.constants.ViewConstants;

public class AccessUsersInit {
    
    private final User user;
    private final AccessUsers view;
    private final int PANEL_WIDTH = 1320;
    private final int PANEL_HEIGHT = 1000;
    private final Button buttonGenerator  = new Button();
    private final Input input = new Input();

    public AccessUsersInit(AccessUsers view, User user) {
        this.view = view;
        this.user = user;
    }
    
    public void init() {
        view.setVisible(true);
        view.setSize(PANEL_WIDTH, PANEL_HEIGHT);
        
        Table.tableStyle3(view.usersTable);
        
        buttonGenerator.solidButton(view.btnNewUser, ViewConstants.skyColor, "#FFFFFF", 12);
        buttonGenerator.addIcon(view.btnNewUser, "icon-plus-white", 20);
        buttonGenerator.solidButton(view.btnSearch, "#000000", "#FFFFFF", 11);
        buttonGenerator.addIcon(view.btnSearch, "icon-search", 20);
        buttonGenerator.outlineButton(view.btnSeeUser, "#DDDDDD", ViewConstants.textBtn);
        buttonGenerator.addIcon(view.btnSeeUser, "icon-eye", 20);
        buttonGenerator.outlineButton(view.btnRestore, "#DDDDDD", ViewConstants.textBtn);
        buttonGenerator.addIcon(view.btnRestore, "icon-reload", 16);
        
        input.roundedComboBox(view.userRoleCombo, "#DDDDDD", 10);
        input.roundedField(view.searchUserTxt, "#DDDDDD", 10, "Busca usuarios por nombre");
        input.roundedComboBox(view.pageCombo, "#DDDDDD", 10);
        input.roundedComboBox(view.itemsPerPageComboBox, "#DDDDDD", 10);
        
        SwingUtilities.updateComponentTreeUI(view);
        
        hideElementsDependingRole();
    }
    
    private void hideElementsDependingRole() {
        if ( user.getRoleId() == 2 ) {
            view.btnNewUser.setVisible(false);
            view.btnNewUser.setSize(0, 0);
        }
    }
}
