package controllers.user.helpers;

import javax.swing.JPasswordField;
import views.access.AccessCreateUser;
import views.access.AccessEditUser;
import views.access.AccessUsers;
import views.components.ImageCustom;

public class ResetElements {
    
    private final ImageCustom imageCustom = new ImageCustom();
    private final AccessUsers view;
    private final AccessCreateUser createView;
    private final AccessEditUser editView;

    public ResetElements(AccessUsers view, AccessCreateUser createView, AccessEditUser editView) {
        this.view = view;
        this.createView = createView;
        this.editView = editView;
    }
    
    public void hideButtonUploadImage() {
        createView.btnLoad.setVisible(false);
        createView.btnRemove.setVisible(true);
        editView.btnLoad.setVisible(false);
        editView.btnRemove.setVisible(true);
    }
    
    public void showButtonUploadImage() {
        createView.btnLoad.setVisible(true);
        createView.btnRemove.setVisible(false);
        editView.btnLoad.setVisible(true);
        editView.btnRemove.setVisible(false);
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
    
    public void hidePagination() {
        view.pageCombo.setVisible(false);
        view.itemsPerPageComboBox.setVisible(false);
        view.btnRestore.setVisible(true);
    }
    
    public void showPagination() {
        view.pageCombo.setVisible(true);
        view.itemsPerPageComboBox.setVisible(true);
        view.btnRestore.setVisible(false);
    }
    
    public void clearEditUserForm() {
        editView.userNameTxt.setText("");
        editView.userLastnameTxt.setText("");
        editView.userEmailTxt.setText("");
        editView.userRoleCombo.setSelectedItem("Seleccione un rol");
        imageCustom.addImageUser(createView.userImageLabel, "no-image.jpg", 200, 200);
    }
    
    public void showPassword(JPasswordField field) {
        if (field.getEchoChar() == (char) 0) {
            field.setEchoChar('*');
        } else {
            field.setEchoChar((char) 0);
        }
    }
    
}
