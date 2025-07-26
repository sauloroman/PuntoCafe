package models;

import config.Database;
import entities.SaleProductDetail;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SaleProductDetailModel {
    
    private final Database DATABASE;
    private PreparedStatement statement;
    private ResultSet result;
    private boolean response;
    
    public SaleProductDetailModel(){
        this.DATABASE = Database.getInstance();
    }
    
    public boolean saveSaleProductDetail(SaleProductDetail saleProductDetail) {
        
        response = false;
        
        try {
            
            int productId = saleProductDetail.getProductId();
            int quantity = saleProductDetail.getSaleProductDetailQuantity();
            double unitPrice = saleProductDetail.getSaleProductDetailUnitPrice();
            double discount = saleProductDetail.getSaleProductDetailDiscount();
            int saleId = saleProductDetail.getSaleId();
            
            statement = DATABASE.connect().prepareStatement(
                    "INSERT INTO sale_product_detail ("
                        + "sale_product_detail_quantity, "
                        + "sale_product_detail_unit_price, "
                        + "sale_product_detail_discount, "
                        + "sale_id, "
                        + "product_id ) "
                  + "VALUES (?, ?, ?, ?, ?)"
            );
            statement.setInt(1, quantity);
            statement.setDouble(2, unitPrice);
            statement.setDouble(3, discount);
            statement.setInt(4, saleId);
            statement.setInt(5, productId);
            
            if ( statement.executeUpdate() > 0 ) {
                response = true;
            }
            
        } catch(SQLException e) {
            System.out.println("Error al crear el detalle de venta de producto: " + e.getMessage());
        } finally {
            DATABASE.disconnect();
            statement = null;
        }
        
        return response;
        
    }
    
    public List<SaleProductDetail> getProductDetailsBySaleId( int saleId ) {
        
        List<SaleProductDetail> details = new ArrayList<>();
        
        try {
            
            statement = DATABASE.connect().prepareStatement(
                    "SELECT * FROM sale_product_detail where sale_id = ?"
            );
            statement.setInt(1, saleId);
            result = statement.executeQuery();
            
            while( result.next() ) {
                details.add(
                        new SaleProductDetail(
                                result.getInt("sale_product_detail_id"),
                                result.getInt("sale_product_detail_quantity"),
                                result.getDouble("sale_product_detail_unit_price"),
                                result.getDouble("sale_product_detail_discount"),
                                result.getInt("sale_id"),
                                result.getInt("product_id")
                        )
                );
            }
            
            statement.close();
            result.close();
            
        } catch(SQLException e) {
            System.out.println("No se pudieron obtener los detalles de venta de productos: " + e.getMessage());
        } finally {
            DATABASE.disconnect();
            statement = null;
            result = null;
        }   
        
        return details;
    }
    
}
