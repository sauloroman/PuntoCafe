package views.warehouse;

import entities.User;
import javax.swing.WindowConstants;
import utils.constants.ViewConstants;
import views.components.Button;
import views.components.ImageCustom;
import views.components.Input;

public class WarehouseInfoDishInit {
    
    private final User user;
    private final WarehouseInfoDish view;
    private final Button buttonGenerator = new Button(); 
    private final ImageCustom imageGenerator = new ImageCustom();
    private final Input inputGenerator = new Input();
    
    public WarehouseInfoDishInit(WarehouseInfoDish view, User user) {
        this.view = view;
        this.user = user;
    }
    
    public void init() {
        view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        view.setResizable(false);
        
        inputGenerator.areaInfo(view.dishDescription);
        
        buttonGenerator.solidButton(view.btnEditDish, "#000000", "#ffffff", 11);
        buttonGenerator.addIcon(view.btnEditDish, "icon-edit", 20);
        buttonGenerator.outlineButton(view.btnActivate, "#DDDDDD", ViewConstants.textBtn);
        buttonGenerator.addIcon(view.btnActivate, "icon-check", 20);
        buttonGenerator.outlineButton(view.btnDeactivate, "#DDDDDD", ViewConstants.textBtn);
        buttonGenerator.addIcon(view.btnDeactivate, "icon-trash", 20);
        
        hideElementsDependingRole();
    }
    
    private void hideElementsDependingRole() {
        if ( user.getRoleId() == 2 || user.getRoleId() == 3 ) {
            view.btnEditDish.setVisible(false);
            view.btnActivate.setVisible(false);
            view.btnDeactivate.setVisible(false);
        }
    }
    
}
