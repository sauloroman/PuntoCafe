package models;

import config.Database;
import entities.PurchaseDetail;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PurchaseDetailModel {
    
    private final Database DATABASE;
    private PreparedStatement statement;
    private ResultSet result;
    private boolean response;

    public PurchaseDetailModel() {
        this.DATABASE = Database.getInstance();
    }
    
    public boolean savePurchaseDetail( PurchaseDetail purchaseDetail ) {
        
        response = false;
        
        try {
            
            int purchaseDetailQuantity = purchaseDetail.getPurchaseDetailQuantity();
            double purchaseDetailUnitPrice = purchaseDetail.getPurchaseDetailUnitPrice();
            int productId = purchaseDetail.getProductId();
            int purchaseId = purchaseDetail.getPuchaseId();
            
            statement = DATABASE.connect().prepareStatement(
                    "INSERT INTO purchase_detail ("
                            + "purchase_detail_quantity, "
                            + "purchase_detail_unit_price, " 
                            + "product_id, "
                            + "purchase_id) "
                  + "VALUES (?, ?, ?, ?)"
            );
            statement.setInt(1, purchaseDetailQuantity);
            statement.setDouble(2, purchaseDetailUnitPrice);
            statement.setInt(3, productId);
            statement.setInt(4, purchaseId);
            
            if ( statement.executeUpdate() > 0 ) {
                response = true;
            }
            
            statement.close();
            
        } catch(SQLException e) {
            System.out.println("Error al crear el detalle de compra: " + e.getMessage());
        } finally {
            DATABASE.disconnect();
            statement = null;
        }
        
        return response;
        
    }
    
    public List<PurchaseDetail> getPurchaseDetailByPurchaseId( int purchaseId ) {
        
        List<PurchaseDetail> details = new ArrayList<>();
        
        try {
            
            statement = DATABASE.connect().prepareStatement(
                    "SELECT * FROM purchase_detail where purchase_id = ?"
            );
            statement.setInt(1, purchaseId);
            result = statement.executeQuery();
            
            while( result.next() ) {
                details.add(
                        new PurchaseDetail(
                                result.getInt("purchase_detail_id"),
                                result.getInt("purchase_detail_quantity"),
                                result.getDouble("purchase_detail_unit_price"),
                                result.getInt("product_id"),
                                result.getInt("purchase_id")
                        )
                );
            }
            
            statement.close();
            result.close();
            
        } catch(SQLException e) {
            System.out.println("No se pudieron obtener los detalles de compra: " + e.getMessage());
        } finally {
            DATABASE.disconnect();
            statement = null;
            result = null;
        }   
        
        return details;
        
    }
    
}
