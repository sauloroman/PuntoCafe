package models;

import config.Database;
import entities.MenuDetail;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
            
            int dishId = menuDetail.getDishId();
            int menuId = menuDetail.getMenuId();
            
            statement = DATABASE.connect().prepareStatement(
                    "INSERT INTO menu_detail (dish_id, menu_id) "
                  + "VALUES (?, ?)"  
            );
            statement.setInt(1, dishId);
            statement.setInt(2, menuId);
            
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
    
    public List<MenuDetail> getMenuDetail( int menuId ) {
        
        List<MenuDetail> detail = new ArrayList<>();
        
        try {
            
            statement = DATABASE.connect().prepareStatement("SELECT * FROM menu_detail WHERE menu_id = ?");
            statement.setInt(1, menuId);
            result = statement.executeQuery();
            
            while( result.next() ) {
                detail.add(
                        new MenuDetail(
                                result.getInt("menu_detail_id"),
                                result.getInt("dish_id"),
                                result.getInt("menu_id")
                        )
                );
            }
            
            statement.close();
            result.close();
            
        } catch(SQLException e) {
            System.out.println("No se pudo obtener el detalle de menu: " + e.getMessage());
        } finally {
            closeResources();
        }
        
        return detail;
    }
    
    public boolean deleteDishesFromMenu( int menuId ) {
        
        response = false;
        
        try {
            
            statement = DATABASE.connect().prepareStatement("DELETE FROM menu_detail WHERE menu_id = ?");
            statement.setInt(1, menuId);
            
            if ( statement.executeUpdate() > 0 ) {
                response = true;
            }
            
        } catch(SQLException e) {
            System.out.println("No se pudieron eliminar los platillos del menu: " + e.getMessage());
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
