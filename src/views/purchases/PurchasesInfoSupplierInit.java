package views.purchases;

import entities.User;
import javax.swing.WindowConstants;
import utils.constants.ViewConstants;
import views.components.Button;
import views.components.ImageCustom;

public class PurchasesInfoSupplierInit {
    
    private final User user;
    private final PurchasesInfoSupplier view;
    private final Button buttonGenerator = new Button(); 
    private final ImageCustom imageGenerator = new ImageCustom();

    public PurchasesInfoSupplierInit(PurchasesInfoSupplier view, User user) {
        this.user = user;
        this.view = view;
    }
   
    public void init() {
        view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        view.setResizable(false);
        
        buttonGenerator.outlineButton(view.btnActivate, "#DDDDDD", ViewConstants.textBtn);
        buttonGenerator.addIcon(view.btnActivate, "icon-check", 20);
        buttonGenerator.outlineButton(view.btnDeactivate, "#DDDDDD", ViewConstants.textBtn);
        buttonGenerator.addIcon(view.btnDeactivate, "icon-trash", 20);
        buttonGenerator.solidButton(view.btnEdit, ViewConstants.blackColor, ViewConstants.whiteColor, 11);
        buttonGenerator.addIcon(view.btnEdit, "icon-edit", 20);
        imageGenerator.addImageFix(view.iconRH, "logo-rh", 50, 50);
        
        hideElementsDependingRole();
    }
    
    private void hideElementsDependingRole() {
        if ( user.getRoleId() == 2 || user.getRoleId() == 3 ) {
            view.btnEdit.setVisible(false);
            view.btnActivate.setVisible(false);
            view.btnDeactivate.setVisible(false);
        }
    }
   
}
