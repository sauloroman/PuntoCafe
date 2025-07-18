package controllers.user.helpers;

import views.access.AccessCreateUser;
import views.access.AccessEditUser;

public class InputReader {
    
    private final AccessCreateUser createView;
    private final AccessEditUser editView;

    public InputReader(AccessCreateUser createView, AccessEditUser editView) {
        this.createView = createView;
        this.editView = editView;
    }
    
    public String getNameCreate() {
        return createView.userNameTxt.getText().trim();
    }
    
    public String getLastnameCreate() {
        return createView.userLastnameTxt.getText().trim();
    }
    
    public String getEmailCreate() {
        return createView.userEmailTxt.getText().trim();
    }
    
    public String getRoleCreate() {
        return createView.userRoleCombo.getSelectedItem().toString();
    }
    
    public String getPasswordCreate() {
        return createView.userPassTxt.getText().trim();
    }
    
    public String getConfirmPasswordCreate() {
        return createView.userConfirmPassTxt.getText().trim();
    }
    
    public String getNameEdition() {
        return createView.userNameTxt.getText().trim();
    }
    
    public String getLastnameEdition() {
        return createView.userLastnameTxt.getText().trim();
    }
    
    public String getEmailEdition() {
        return createView.userEmailTxt.getText().trim();
    }
    
    public String getRoleEdition() {
        return createView.userRoleCombo.getSelectedItem().toString();
    }
    
}
