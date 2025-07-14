package entities;

import java.util.Date;

public class Role {
    
    private int roleId;
    private String roleName;
    private String roleDescription;
    private boolean roleIsActive;
    private Date roleCreatedAt;
    private Date roleUpdatedAt;

    public Role() {}

    public Role(String roleName, String roleDescription) {
        this.roleName = roleName;
        this.roleDescription = roleDescription;
    }
    
    public Role(
            int roleId, 
            String roleName, 
            String roleDescription, 
            boolean roleIsActive, 
            Date roleCreatedAt, 
            Date roleUpdatedAt
    ) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleDescription = roleDescription;
        this.roleIsActive = roleIsActive;
        this.roleCreatedAt = roleCreatedAt;
        this.roleUpdatedAt = roleUpdatedAt;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public boolean getIsActive() {
        return roleIsActive;
    }

    public void setIsActive(boolean roleIsActive) {
        this.roleIsActive = roleIsActive;
    }

    public Date getRoleCreatedAt() {
        return roleCreatedAt;
    }

    public void setRoleCreatedAt(Date roleCreatedAt) {
        this.roleCreatedAt = roleCreatedAt;
    }

    public Date getRoleUpdatedAt() {
        return roleUpdatedAt;
    }

    public void setRoleUpdatedAt(Date roleUpdatedAt) {
        this.roleUpdatedAt = roleUpdatedAt;
    }

    @Override
    public String toString() {
        return "Role{" + "roleId=" + roleId + ", roleName=" + roleName + ", roleDescription=" + roleDescription + ", roleIsActive=" + roleIsActive + ", roleCreatedAt=" + roleCreatedAt + ", roleUpdatedAt=" + roleUpdatedAt + '}';
    }
}
