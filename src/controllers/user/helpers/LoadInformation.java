package controllers.user.helpers;

import entities.User;
import java.awt.Color;
import services.RoleService;
import views.access.AccessInfoUser;
import views.components.ImageCustom;

public class LoadInformation {
    
    private final ImageCustom image = new ImageCustom();
    private final AccessInfoUser infoView;
    private final RoleService roleService;
    
    public LoadInformation(AccessInfoUser infoView, RoleService roleService) {
        this.infoView = infoView;
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
    
    private void setColorRolLabel(String roleName) {
        switch (roleName) {
            case "Administrador" -> infoView.userInfoRol.setBackground(Color.decode("#9933FF"));
            case "Vendedor" -> infoView.userInfoRol.setBackground(Color.decode("#FFCC00"));
            case "Supervisor" -> infoView.userInfoRol.setBackground(Color.decode("#009933"));
        }
    }
    
}
