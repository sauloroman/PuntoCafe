package controllers.user.helpers;

import views.access.AccessCreateUser;
import views.components.ImageCustom;

public class ResetElements {
    
    private final ImageCustom imageCustom = new ImageCustom();
    private final AccessCreateUser createView;

    public ResetElements(AccessCreateUser createView) {
        this.createView = createView;
    }
    
    public void hideButtonUploadImage() {
        createView.btnLoad.setVisible(false);
        createView.btnRemove.setVisible(true);
        //editView.btnLoadImage.setVisible(false);
        //editView.btnRemoveImage.setVisible(true);
    }
    
    public void showButtonUploadImage() {
        createView.btnLoad.setVisible(true);
        createView.btnRemove.setVisible(false);
        //editView.btnLoadImage.setVisible(true);
        //editView.btnRemoveImage.setVisible(false);
    }
    
    public void clearCreateUserForm() {
        createView.userNameTxt.setText("");
        createView.userLastnameTxt.setText("");
        createView.userEmailTxt.setText("");
        createView.userRoleCombo.setSelectedItem("Seleccione un rol");
        createView.userPassTxt.setText("");
        createView.userConfirmPassTxt.setText("");
        imageCustom.addImageUser(createView.userImageLabel, "no-image.jpg", 200, 200);
    }
    
}
