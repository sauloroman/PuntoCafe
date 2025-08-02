package models;

import config.Database;
import entities.Menu;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
            
            statement = DATABASE.connect().prepareStatement(
                    "INSERT INTO menu (menu_name, menu_description, menu_date_start, menu_date_end) "
                  + "VALUES (?, ?, ?, ?)"  
            );
            statement.setString(1, menuName);
            statement.setString(2, menuDesc);
            statement.setString(3, menuStartDate);
            statement.setString(4, menuEndDate);
            
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
