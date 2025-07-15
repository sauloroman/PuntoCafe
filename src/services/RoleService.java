package services;

import entities.Role;
import java.util.List;
import models.RoleModel;

public class RoleService {
    
    private final RoleModel model;

    public RoleService(RoleModel model) {
        this.model = model;
    }
    
    public Role getRoleById(int roleId) {
        if ( roleId < 0 ) return null;
        return model.getItemById(roleId);
    }
    
    public Role getRoleByName(String name) {
        if ( name.isEmpty() ) return null;
        return model.getItemByName(name);
    }
    
    public List<Role> getRoles() {
        return model.listItems("");
    }
    
}
