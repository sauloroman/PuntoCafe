package views.warehouse;

import entities.User;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.WindowConstants;
import utils.constants.ViewConstants;
import views.components.Button;

public class WarehouseMenuDetailInit {
    
    private final User user;
    private final WarehouseMenuDetail view;
    private final Button buttonGenerator = new Button();

    public WarehouseMenuDetailInit(WarehouseMenuDetail menuDetailView, User user) {
        this.view = menuDetailView;
        this.user = user;
    }
    
    public void init() {
        view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        view.setResizable(false);
        
        view.menuDetailGrid.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        view.menuDetailGrid.setPreferredSize(new Dimension(800, 500));
        view.menuDetailGrid.setMaximumSize(new Dimension(Integer.MAX_VALUE, 500));
        view.menuDetailGrid.setMinimumSize(new Dimension(800, 500));
        
        buttonGenerator.solidButton(view.btnChangeDishes, ViewConstants.blackColor, "#FFFFFF", 12);
        buttonGenerator.addIcon(view.btnChangeDishes, "icon-info", 20);
        buttonGenerator.solidButton(view.btnEditMenu, ViewConstants.blackColor, "#FFFFFF", 12);
        buttonGenerator.addIcon(view.btnEditMenu, "icon-edit", 20);
        buttonGenerator.outlineButton(view.btnActivate, "#DDDDDD", ViewConstants.textBtn);
        buttonGenerator.addIcon(view.btnActivate, "icon-check", 20);
        buttonGenerator.outlineButton(view.btnDeactivate, "#DDDDDD", ViewConstants.textBtn);
        buttonGenerator.addIcon(view.btnDeactivate, "icon-trash", 20);
        
        hideElementsDependingRole();
    }
    
    private void hideElementsDependingRole() {
        if ( user.getRoleId() == 2 || user.getRoleId() == 3 ) {
            view.btnEditMenu.setVisible(false);
            view.btnActivate.setVisible(false);
            view.btnDeactivate.setVisible(false);
            view.btnChangeDishes.setVisible(false);
        }
    }
    
}
