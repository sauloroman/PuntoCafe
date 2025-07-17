package views.access;

import javax.swing.WindowConstants;
import utils.constants.ViewConstants;
import views.access.AccessInfoUser;
import views.components.Button;
import views.components.ImageCustom;
import views.components.Input;

public class AccessInfoUserInit {
    
    private final AccessInfoUser view;
    private final Button buttonGenerator = new Button(); 
    private final ImageCustom imageGenerator = new ImageCustom();
    private final Input inputGenerator = new Input();

    public AccessInfoUserInit(AccessInfoUser view) {
        this.view = view;
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
        
    }
}
