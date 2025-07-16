package controllers.user.helpers;

import views.access.AccessUsers;

public class FilterUsers {
    
    private final AccessUsers view;

    public FilterUsers(AccessUsers view) {
        this.view = view;
    }
    
    public String getRoleSelected() {
        String role = view.userRoleCombo.getSelectedItem().toString();
        if ( role.equals("Filtro por Roles") ) return null;
        return role;
    }
    
    public String getUserSearched() {
        String userSearched = view.searchUserTxt.getText().trim();
        if ( userSearched.isEmpty() ) return null;
        return userSearched;
    }
    
    public void restoreRoleSelected() {
        view.userRoleCombo.setSelectedItem("Filtro por Roles");
        view.userRoleCombo.setSelectedIndex(0);
    }
    
    public void restoreUserSearched() {
        view.searchUserTxt.setText("");
    }
    
}
