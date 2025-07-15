package models;

import config.Database;
import entities.Role;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.interfaces.CrudInterface;
import utils.enums.SearchCriteriaEnum;

public class RoleModel implements CrudInterface<Role> {
    
    private final Database DATABASE;
    private PreparedStatement statement;
    private ResultSet result;
    private boolean response;
    
    public RoleModel() {
        this.DATABASE = Database.getInstance();
    }

    @Override
    public Role getItemByName(String name) {
        Role role = null;
        
        try {
            
            statement = DATABASE.connect().prepareStatement(
                    "SELECT * FROM role WHERE role_name = ?"
            );
            statement.setString(1, name);
            result = statement.executeQuery();
            
            if ( result.next() ) {
                role = new Role(
                        result.getInt("role_id"),
                        result.getString("role_name"),
                        result.getString("role_description"),
                        result.getBoolean("role_is_active"),
                        result.getDate("role_createdAt"),
                        result.getDate("role_updatedAt")
                );
            }
            
            statement.close();
            result.close();
            
        } catch(SQLException e) {
            System.out.println("No se pudo obtener el role por id: " + e.getMessage());
        } finally {
            DATABASE.disconnect();
            statement = null;
            result = null;
        }
    
        return role;

    }

    @Override
    public Role getItemById(int id) {
        
        Role role = null;
        
        try {
            
            statement = DATABASE.connect().prepareStatement(
                    "SELECT * FROM role WHERE role_id = ?"
            );
            statement.setInt(1, id);
            result = statement.executeQuery();
            
            if ( result.next() ) {
                role = new Role(
                        result.getInt("role_id"),
                        result.getString("role_name"),
                        result.getString("role_description"),
                        result.getBoolean("role_is_active"),
                        result.getDate("role_createdAt"),
                        result.getDate("role_updatedAt")
                );
            }
            
            statement.close();
            result.close();
            
        } catch(SQLException e) {
            System.out.println("No se pudo obtener el role por id: " + e.getMessage());
        } finally {
            DATABASE.disconnect();
            statement = null;
            result = null;
        }
    
        return role;
    }
    

    @Override
    public List<Role> listItems(String filter) {
        
        List<Role> roles = new ArrayList<>();
        
        try {
            
            statement = DATABASE.connect().prepareStatement("SELECT * FROM role");
            result = statement.executeQuery();
            
            while ( result.next() ) {
                roles.add(
                        new Role(
                            result.getInt("role_id"),
                            result.getString("role_name"),
                            result.getString("role_description"),
                            result.getBoolean("role_is_active"),
                            result.getDate("role_createdAt"),
                            result.getDate("role_updatedAt")    
                        )
                );
            }
            
            statement.close();
            result.close();
            
        } catch(SQLException e) {
            System.out.println("No se pudieron obtener todos los roles: " + e.getMessage());
        } finally {
            statement = null;
            result = null;
            DATABASE.disconnect();
        }
        
        return roles;
    }

    @Override
    public List<Role> listItemsByPage(String filter, SearchCriteriaEnum criteria, int page, int itemsPerPage) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean saveItem(Role obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean changeStatus(int id, boolean status) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean updateItem(Role obj, int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getTotalItems() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
