package views.inits;

import views.access.AccessUsers;
import utils.builders.BadgeCellRenderer;
import views.components.Button;
import views.components.Input;
import views.components.Table;
import utils.builders.UserCellRenderer;

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
        
        view.usersTable.getColumnModel().getColumn(0).setCellRenderer(new UserCellRenderer());
        view.usersTable.getColumnModel().getColumn(1).setCellRenderer(new BadgeCellRenderer());
        
        buttonGenerator.solidButton(view.btnNewUser, "#000000", "#FFFFFF");
        buttonGenerator.addIcon(view.btnNewUser, "icon-plus-white", 20);
        buttonGenerator.solidButton(view.btnSearch, "#000000", "#FFFFFF");
        buttonGenerator.addIcon(view.btnSearch, "icon-search", 20);
        
        input.roundedComboBox(view.userRoleCombo, "#DDDDDD", 10);
        input.roundedField(view.searchUserTxt, "#DDDDDD", 10);
    }
}
