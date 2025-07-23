package models;

import java.sql.Statement;
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
    
    public Sale saveSale( Sale sale ) {
        
        Sale newSale = null;
        
        try {
            
            String saleDate = sale.getSaleDate();
            Double saleTotal = sale.getTotal();
            String saleCode = sale.getSaleCode();
            int userId = sale.getUserId();
            
            statement = DATABASE.connect().prepareStatement(
                    "INSERT INTO sale (sale_date, sale_total, sale_code, user_id) "
                  + "VALUES (?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            statement.setString(1, saleDate);
            statement.setDouble(2, saleTotal);
            statement.setString(3, saleCode);
            statement.setInt(4, userId);
            
            int affectedRows = statement.executeUpdate();
            
            if (affectedRows > 0) {
                result = statement.getGeneratedKeys();
                if (result.next()) {
                    int generatedId = result.getInt(1);
                    newSale = new Sale(
                            generatedId,
                            saleDate,
                            saleTotal,
                            saleCode,
                            userId
                    );
                }
            }
            
        } catch(SQLException e) {
            System.out.println("Error al crear la venta: " + e.getMessage());
        } finally {
            DATABASE.disconnect();
            statement = null;
        }
        
        return newSale;
    }
    
}
