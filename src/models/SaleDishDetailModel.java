package models;

import config.Database;
import entities.SaleDishDetail;
import entities.SaleProductDetail;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
            double discount = saleDishDetail.getSaleDishDetailDiscount();
            int saleId = saleDishDetail.getSaleId();
            int dishId = saleDishDetail.getDishId();
            
            statement = DATABASE.connect().prepareStatement(
                    "INSERT INTO sale_dish_detail ("
                            + "sale_dish_detail_quantity, "
                            + "sale_dish_detail_unit_price, " 
                            + "sale_dish_detail_discount, "
                            + "sale_id, "
                            + "dish_id) "
                  + "VALUES (?, ?, ?, ?, ?)"
            );
            statement.setInt(1, quantity);
            statement.setDouble(2, unitPrice);
            statement.setDouble(3, discount);
            statement.setInt(4, saleId);
            statement.setInt(5, dishId);
            
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
    
    public List<SaleDishDetail> getDishDetailsBySaleId( int saleId ) {
        
        List<SaleDishDetail> details = new ArrayList<>();
        
        try {
            
            statement = DATABASE.connect().prepareStatement(
                    "SELECT * FROM sale_dish_detail where sale_id = ?"
            );
            statement.setInt(1, saleId);
            result = statement.executeQuery();
            
            while( result.next() ) {
                details.add(
                        new SaleDishDetail(
                                result.getInt("sale_dish_detail_id"),
                                result.getInt("sale_dish_detail_quantity"),
                                result.getDouble("sale_dish_detail_unit_price"),
                                result.getDouble("sale_dish_detail_discount"),
                                result.getInt("sale_id"),
                                result.getInt("dish_id")
                        )
                );
            }
            
            statement.close();
            result.close();
            
        } catch(SQLException e) {
            System.out.println("No se pudieron obtener los detalles de venta de platillos: " + e.getMessage());
        } finally {
            DATABASE.disconnect();
            statement = null;
            result = null;
        }   
        
        return details;
        
    }
    
}
