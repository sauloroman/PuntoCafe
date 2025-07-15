package views.inits;

import javax.swing.WindowConstants;
import utils.constants.ViewConstants;
import views.access.AccessCreateUser;
import views.components.Button;
import views.components.ImageCustom;
import views.components.Input;

public class AccessCreateUserInit {
    
    private final AccessCreateUser view;
    private final Button buttonGenerator = new Button(); 
    private final ImageCustom imageGenerator = new ImageCustom();
    private final Input inputGenerator = new Input();

    public AccessCreateUserInit(AccessCreateUser view) {
        this.view = view;
    }
    
    public void init() {
        view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        view.setResizable(false);
        
        view.btnRemove.setVisible(false);
        
        buttonGenerator.solidButton(view.btnSaveUser, "#000000", "#FFFFFF");
        buttonGenerator.addIcon(view.btnSaveUser, "icon-save", 20);
        buttonGenerator.outlineButton(view.btnCancelSaveUser, ViewConstants.errorColor, ViewConstants.errorColor);
        buttonGenerator.addIcon(view.btnCancelSaveUser, "icon-left-red", 20);
        buttonGenerator.outlineButton(view.btnLoad, "#dddddd", ViewConstants.textBtn);
        buttonGenerator.addIcon(view.btnLoad, "icon-up", 20);
        buttonGenerator.outlineButton(view.btnRemove, "#dddddd", ViewConstants.textBtn);
        buttonGenerator.addIcon(view.btnRemove, "icon-down", 20);
        
        inputGenerator.roundedField(view.userEmailTxt, "#DDDDDD", 10);
        inputGenerator.roundedField(view.userNameTxt, "#DDDDDD", 10);
        inputGenerator.roundedField(view.userLastnameTxt, "#DDDDDD", 10);
        inputGenerator.roundedField(view.userPassTxt, "#DDDDDD", 10);
        inputGenerator.roundedField(view.userConfirmPassTxt, "#DDDDDD", 10);
        inputGenerator.roundedComboBox(view.userRoleCombo, "#DDDDDD", 10);
        
        imageGenerator.addImageFix(view.iconRH, "logo-rh", 50, 50);
        imageGenerator.addImageUser(view.userImageLabel, "no-image.jpg", 200, 200);
        imageGenerator.addImage(view.iconInputMandatory, "icon-lock", 14);
        imageGenerator.addImage(view.iconInputMandatory1, "icon-lock", 14);
        imageGenerator.addImage(view.iconInputMandatory2, "icon-lock", 14);
        imageGenerator.addImage(view.iconInputMandatory3, "icon-lock", 14);
        imageGenerator.addImage(view.iconInputMandatory4, "icon-lock", 14);
        imageGenerator.addImage(view.iconInputMandatory5, "icon-lock", 14);
        
    }
    
}
