package models;

import config.Database;
import entities.SaleDishDetail;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SaleDishDetailModel {
    
    private final Database DATABASE;
    private PreparedStatement statement;
    private ResultSet result;
    private boolean response;
    
    public SaleDishDetailModel(){
        this.DATABASE = Database.getInstance();
    }
    
    public boolean saveSaleDishDetail(SaleDishDetail saleDishDetail) {
        
        response = false;
        
        try {
            
            int quantity = saleDishDetail.getSaleDishDetailQuantity();
            double unitPrice = saleDishDetail.getSaleDishDetailUnitPrice();
            int saleId = saleDishDetail.getSaleId();
            int dishId = saleDishDetail.getDishId();
            
            statement = DATABASE.connect().prepareStatement(
                    "INSERT INTO sale_dish_detail (sale_dish_detail_quantity, sale_dish_detail_unit_price, sale_id, product_id) "
                  + "VALUES (?, ?, ?, ?)"
            );
            statement.setInt(1, quantity);
            statement.setDouble(2, unitPrice);
            statement.setInt(3, saleId);
            statement.setInt(4, dishId);
            
            if ( statement.executeUpdate() > 0 ) {
                response = true;
            }
            
        } catch(SQLException e) {
            System.out.println("Error al crear el detalle de venta de platillos: " + e.getMessage());
        } finally {
            DATABASE.disconnect();
            statement = null;
        }
        
        return response;
        
    }
    
}
