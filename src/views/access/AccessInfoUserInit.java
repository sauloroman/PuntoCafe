package views.access;

import entities.User;
import javax.swing.WindowConstants;
import utils.constants.ViewConstants;
import views.components.Button;
import views.components.ImageCustom;
import views.components.Input;

public class AccessInfoUserInit {
    
    private final User user;
    private final AccessInfoUser view;
    private final Button buttonGenerator = new Button(); 
    private final ImageCustom imageGenerator = new ImageCustom();
    private final Input inputGenerator = new Input();

    public AccessInfoUserInit(AccessInfoUser view, User user) {
        this.view = view;
        this.user = user;
    }
    
    public void init() {
        view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        view.setResizable(false);
        
        buttonGenerator.solidButton(view.btnEdit, "#000000", "#FFFFFF", 11);
        buttonGenerator.addIcon(view.btnEdit, "icon-edit", 14);
        buttonGenerator.outlineButton(view.btnActivate, "#DDDDDD", ViewConstants.textBtn);
        buttonGenerator.addIcon(view.btnActivate, "icon-check", 14);
        buttonGenerator.outlineButton(view.btnDeactivate, "#DDDDDD", ViewConstants.textBtn);
        buttonGenerator.addIcon(view.btnDeactivate, "icon-trash", 14);
        
        hideElementsDependingRole();
    }
    
    private void hideElementsDependingRole() {
        if ( user.getRoleId() == 2 || user.getRoleId() == 3 ) {
            view.btnEdit.setVisible(false);
            view.btnEdit.setSize(0, 0);
            view.btnActivate.setVisible(false);
            view.btnActivate.setSize(0, 0);
            view.btnDeactivate.setVisible(false);
            view.btnDeactivate.setSize(0, 0);
        }
    }
}
