package views.warehouse;

import entities.User;
import javax.swing.WindowConstants;
import utils.constants.ViewConstants;
import views.components.Button;
import views.components.ImageCustom;
import views.components.Input;

public class WarehouseInfoProductInit {
    
    private final User user;
    private final WarehouseInfoProduct view;
    private final Button buttonGenerator = new Button(); 
    private final ImageCustom imageGenerator = new ImageCustom();
    private final Input inputGenerator = new Input();

    public WarehouseInfoProductInit(WarehouseInfoProduct view, User user) {
        this.view = view;
        this.user = user;
    }
    
    public void init() {
        view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        view.setResizable(false);
        
        imageGenerator.addImage(view.iconStock, "icon-stock", 20);
        imageGenerator.addImage(view.iconStock1, "icon-stock", 20);
        inputGenerator.areaInfo(view.productDescription);
        
        buttonGenerator.solidButton(view.btnEditProduct, "#000000", "#ffffff", 11);
        buttonGenerator.addIcon(view.btnEditProduct, "icon-edit", 20);
        buttonGenerator.outlineButton(view.btnActivate, "#DDDDDD", ViewConstants.textBtn);
        buttonGenerator.addIcon(view.btnActivate, "icon-check", 20);
        buttonGenerator.outlineButton(view.btnDeactivate, "#DDDDDD", ViewConstants.textBtn);
        buttonGenerator.addIcon(view.btnDeactivate, "icon-trash", 20);
        
        hideElementsDependingRole();
    }
    
    private void hideElementsDependingRole() {
        if ( user.getRoleId() == 2 || user.getRoleId() == 3 ) {
            view.btnEditProduct.setVisible(false);
            view.btnActivate.setVisible(false);
            view.btnDeactivate.setVisible(false);
        }
    }
}
