package controllers.user.helpers;

import entities.User;
import java.awt.Color;
import services.RoleService;
import views.access.AccessEditUser;
import views.access.AccessInfoUser;
import views.components.ImageCustom;

public class LoadInformation {
    
    private final ImageCustom image = new ImageCustom();
    private final AccessInfoUser infoView;
    private final AccessEditUser editView;
    private final RoleService roleService;
    
    public LoadInformation(AccessInfoUser infoView, AccessEditUser editView, RoleService roleService) {
        this.infoView = infoView;
        this.editView = editView;
        this.roleService = roleService;
    }
    
    public void loadInfoUser( User user ) {
        String roleName = roleService.getRoleById(user.getRoleId()).getRoleName();
        infoView.userInfoId.setText(user.getUserId() + "");
        infoView.userInfoName.setText(user.getUserName() + " " + user.getUserLastname());
        infoView.userInfoRol.setText(roleName);
        infoView.userInfoEmail.setText(user.getUserEmail());
        infoView.userInfoStatus.setText(user.getIsActive() ? "Activo" : "Inactivo");
        infoView.userInfoCreatedAt.setText(user.getUserCreatedAt().toString());
        infoView.userInfoUpdatedAt.setText(user.getUserUpdatedAt().toString());
        image.addImageUser(infoView.userInfoImage, user.getUserImage(), 120, 120);
        setColorRolLabel(roleName);
    }
    
    public void loadInfoEdit(User user) {
        String roleName = roleService.getRoleById(user.getRoleId()).getRoleName();
        editView.userNameTxt.setText(user.getUserName());
        editView.userLastnameTxt.setText(user.getUserLastname());
        editView.userEmailTxt.setText(user.getUserEmail());
        editView.userRoleCombo.setSelectedItem(roleName);
        image.addImageUser(editView.userImageLabel, user.getUserImage(), 150, 150);
    }
    
    private void setColorRolLabel(String roleName) {
        switch (roleName) {
            case "Administrador" -> infoView.userInfoRol.setBackground(Color.decode("#9933FF"));
            case "Vendedor" -> infoView.userInfoRol.setBackground(Color.decode("#FFCC00"));
            case "Supervisor" -> infoView.userInfoRol.setBackground(Color.decode("#009933"));
        }
    }
    
}
