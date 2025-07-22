package models;

import config.Database;
import entities.Sale;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SaleModel {
    
    private final Database DATABASE;
    private PreparedStatement statement;
    private ResultSet result;
    private boolean response;
    
    public SaleModel() {
        this.DATABASE = Database.getInstance();
    }
    
    public boolean saveSale( Sale sale ) {
        
        response = false;
        
        try {
            
            String saleDate = sale.getSaleDate().toString();
            Double saleTotal = sale.getTotal();
            String saleCode = sale.getSaleCode();
            int userId = sale.getUserId();
            
            statement = DATABASE.connect().prepareStatement(
                    "INSERT INTO sale (sale_date, sale_total, sale_code, user_id) "
                  + "VALUES (?, ?, ?, ?)"
            );
            statement.setString(1, saleDate);
            statement.setDouble(2, saleTotal);
            statement.setString(3, saleCode);
            statement.setInt(4, userId);
            
            if ( statement.executeUpdate() > 0 ) {
                response = true;
            }
            
        } catch(SQLException e) {
            System.out.println("Error al crear la venta: " + e.getMessage());
        } finally {
            DATABASE.disconnect();
            statement = null;
        }
        
        return response;
    }
    
}
