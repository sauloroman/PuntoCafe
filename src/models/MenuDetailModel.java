package models;

import config.Database;
import entities.MenuDetail;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MenuDetailModel {
    
    private final Database DATABASE;
    private PreparedStatement statement;
    private ResultSet result;
    private boolean response;
    
    public MenuDetailModel() {
        DATABASE = Database.getInstance();
    }
    
    public boolean saveMenuDetail(MenuDetail menuDetail) {
        response = false;
        
        try {
            
            String menuDetailDate = menuDetail.getMenuDetailDate();
            int dishId = menuDetail.getDishId();
            int menuId = menuDetail.getMenuId();
            
            statement = DATABASE.connect().prepareStatement(
                    "INSERT INTO menu_detail (menu_detail_date, dish_id, menu_id) "
                  + "VALUES (?, ?, ?)"  
            );
            statement.setString(1, menuDetailDate);
            statement.setInt(2, dishId);
            statement.setInt(3, menuId);
            
            if ( statement.executeUpdate() > 0 ) {
                response = true;
            }
            
            statement.close();
            
        } catch(SQLException e) {
            System.out.println("No se pudo guardar el detalle de menú: " + e.getMessage());
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
