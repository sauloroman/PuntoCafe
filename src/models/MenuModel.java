package models;

import config.Database;
import entities.Menu;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuModel {
 
    private final Database DATABASE;
    private PreparedStatement statement;
    private ResultSet result;
    private boolean response;
    
    public MenuModel() {
        DATABASE = Database.getInstance();
    }
    
    public Menu saveMenu(Menu menu) {
        Menu newMenu = null;
        
        try {
            
            String menuName = menu.getMenuName();
            String menuDesc = menu.getMenuDescription();
            String menuStartDate = menu.getMenuStartDate();
            String menuEndDate = menu.getMenuEndDate();
            
            boolean hashMenuDesc = menuDesc != null && !menuDesc.isEmpty();
            
            if ( hashMenuDesc ) {
                 statement = DATABASE.connect().prepareStatement(
                    "INSERT INTO menu (menu_name, menu_description, menu_date_start, menu_date_end) "
                  + "VALUES (?, ?, ?, ?)",
                    PreparedStatement.RETURN_GENERATED_KEYS
                );
                statement.setString(1, menuName);
                statement.setString(2, menuDesc);
                statement.setString(3, menuStartDate);
                statement.setString(4, menuEndDate);
            } else {
                 statement = DATABASE.connect().prepareStatement(
                    "INSERT INTO menu (menu_name, menu_date_start, menu_date_end) "
                  + "VALUES (?, ?, ?)",
                    PreparedStatement.RETURN_GENERATED_KEYS
                );
                statement.setString(1, menuName);
                statement.setString(2, menuStartDate);
                statement.setString(3, menuEndDate);
            }
            
            int affectedRows = statement.executeUpdate();
            
            if ( affectedRows > 0 ) {
                result = statement.getGeneratedKeys();
                
                if ( result.next() ) {
                    int generatedId = result.getInt(1);
                    
                    newMenu = new Menu(
                            generatedId,
                            menuName,
                            menuDesc,
                            menuStartDate,
                            menuEndDate
                    );
                }
            }
            
            statement.close();
            result.close();
            
        } catch(SQLException e) {
            System.out.println("No se pudo guardar el menú: " + e.getMessage());
        } finally {
           closeResources(); 
        }
        
        return newMenu;
    }
    
    public List<Menu> getMenus( int page, int quantity ) {
        
        List<Menu> menus = new ArrayList<>();
        
        try {
            
            statement = DATABASE.connect().prepareStatement("SELECT * FROM menu ORDER BY menu_createdAt DESC LIMIT ?, ?");
            statement.setInt(1, (page - 1) * quantity);
            statement.setInt(2, quantity);
            result = statement.executeQuery();
            
            while( result.next() ) {
                menus.add(new Menu(
                            result.getInt("menu_id"),
                            result.getString("menu_name"),
                            result.getString("menu_description"),
                            result.getString("menu_date_start"),
                            result.getString("menu_date_end"),
                            result.getString("menu_createdAt"),
                            result.getString("menu_updatedAt"),
                            result.getBoolean("menu_is_active")
                ));
            }
            
            statement.close();
            result.close();
            
        } catch(SQLException e) {
            System.out.println("Error al obtener los menus: " + e.getMessage());
        } finally {
            closeResources();
        }
        
        return menus;
    }
    
    public Menu getByName(String menuName) {
        
        Menu menu = null;
        
        try {
            
            statement = DATABASE.connect().prepareStatement(
                    "SELECT * FROM menu WHERE menu_name = ?"
            );
            statement.setString(1, menuName);
            result = statement.executeQuery();
            
            if ( result.next() ) {
                menu = new Menu(
                        result.getInt("menu_id"),
                        result.getString("menu_name"),
                        result.getString("menu_description"),
                        result.getString("menu_date_start"),
                        result.getString("menu_date_end"),
                        result.getString("menu_createdAt"),
                        result.getString("menu_updatedAt"),
                        result.getBoolean("menu_is_active")
                );
            }
            
            statement.close();
            result.close();
            
        } catch(SQLException e) {
            System.out.println("No se pudo obtener el menu por nombre: " + e.getMessage());
        } finally {
            closeResources();
        }
        
        return menu;
    }
    
    public int getQuantityMenus() {
        int counter = 0;
        
        try {
            
            statement = DATABASE.connect().prepareStatement(
                    "SELECT COUNT(*) AS total FROM menu"
            );
            result = statement.executeQuery();
            
            while ( result.next() ) {
                counter = result.getInt("total");
            }
            
            statement.close();
            result.close();
            
        } catch(SQLException e) {
            System.out.println("No se pudo obtener la cantidad de menus: " + e.getMessage());
        } finally {
            closeResources();
        }
        
        return counter;
    }
    
    public List<Menu> getMenusByName(String menuName) {
        
        List<Menu> menus = new ArrayList<>();
        
        try {
             
            statement = DATABASE.connect().prepareStatement(
                    "SELECT * FROM menu WHERE menu_name LIKE ? ORDER BY menu_createdAt"
            );
            statement.setString(1, "%" + menuName + "%");
            result = statement.executeQuery();
            
            while( result.next() ) {
                menus.add(
                        new Menu(
                            result.getInt("menu_id"),
                            result.getString("menu_name"),
                            result.getString("menu_description"),
                            result.getString("menu_date_start"),
                            result.getString("menu_date_end"),
                            result.getString("menu_createdAt"),
                            result.getString("menu_updatedAt"),
                            result.getBoolean("menu_is_active")
                        )
                );
            }
            
            statement.close();
            result.close();
            
        } catch(SQLException e){
            System.out.println("No se pudieron obtener los menús por nombre: " + e.getMessage());
        } finally {
            closeResources();
        }
        
        return menus;
    }
    
    public List<Menu> getMenusByStatus(boolean status) {
        
        List<Menu> menus = new ArrayList<>();
        
        try {
             
            statement = DATABASE.connect().prepareStatement(
                    "SELECT * FROM menu WHERE menu_is_active = ? ORDER BY menu_createdAt"
            );
            statement.setBoolean(1, status);
            result = statement.executeQuery();
            
            while( result.next() ) {
                menus.add(
                        new Menu(
                            result.getInt("menu_id"),
                            result.getString("menu_name"),
                            result.getString("menu_description"),
                            result.getString("menu_date_start"),
                            result.getString("menu_date_end"),
                            result.getString("menu_createdAt"),
                            result.getString("menu_updatedAt"),
                            result.getBoolean("menu_is_active")
                        )
                );
            }
            
            statement.close();
            result.close();
            
        } catch(SQLException e){
            System.out.println("No se pudieron obtener los menús por estado: " + e.getMessage());
        } finally {
            closeResources();
        }
        
        return menus;
    }
    
    public boolean updateMenu( int menuId, Menu menu ) {
        response = false;
        
        try {
            
            String menuName = menu.getMenuName();
            String menuDesc = menu.getMenuDescription();
            String menuStartDate = menu.getMenuStartDate();
            String menuEndDate = menu.getMenuEndDate();
            
            statement = DATABASE.connect().prepareStatement(
                    "UPDATE menu " +
                    "SET menu_name = ?, menu_description = ?, menu_date_start = ?, menu_date_end = ? " +
                    "WHERE menu_id = ?"
            );
            statement.setString(1, menuName);
            statement.setString(2, menuDesc);
            statement.setString(3, menuStartDate);
            statement.setString(4, menuEndDate);
            statement.setInt(5, menuId);
            
            if ( statement.executeUpdate() > 0 ) {
                response = true;
            }
            
            statement.close();
            
        } catch(SQLException e) {
            System.out.println("No fue posible actualizar el menu: " + e.getMessage());
        } finally {
            closeResources();
        }
        
        return response;
    }
    
    public boolean changeStatus( int menuId, boolean status ) {
        response = false;
        
        try {
            
            statement = DATABASE.connect().prepareStatement(
                    "UPDATE menu " +
                    "SET menu_is_active = ? WHERE menu_id = ?"
            );
            statement.setBoolean(1, status);
            statement.setInt(2, menuId);
            
            if ( statement.executeUpdate() >  0 ) {
                response = true;
            }
            
            statement.close();
            
        } catch(SQLException e) {
            System.out.println("No se pudo cambiar de estado: " + e.getMessage());
        } finally {
            closeResources();
        }
        
        return response;
    }
    
    private void closeResources() {
        try {
            if (result != null) result.close();
            if (statement != null) statement.close();
            DATABASE.disconnect();
        } catch(SQLException e) {
            System.out.println("Error al cerrar recursos: " + e.getMessage());
        }
    }
    
}
