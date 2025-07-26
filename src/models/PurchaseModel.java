package models;

import config.Database;
import entities.MontlyMoney;
import entities.Purchase;
import entities.TopProduct;
import entities.TopSupplier;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PurchaseModel {
    
    private final Database DATABASE;
    private PreparedStatement statement;
    private ResultSet result;

    public PurchaseModel() {
        this.DATABASE = Database.getInstance();
    }
    
    public Purchase savePurchase( Purchase purchase ) {
        Purchase newPurchase = null;
        
        try {
            
            String purchaseDate = purchase.getPurchaseDate();
            double purchaseTotal = purchase.getPurchaseTotal();
            String purchaseCode = purchase.getPurchaseCode();
            int supplierId = purchase.getSupplierId();
            int userId = purchase.getUserId();
            
            statement = DATABASE.connect().prepareStatement(
                    "INSERT INTO purchase (purchase_date, purchase_total, purchase_code, supplier_id, user_id) "
                  + "VALUES (?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            statement.setString(1, purchaseDate);
            statement.setDouble(2, purchaseTotal);
            statement.setString(3, purchaseCode);
            statement.setInt(4, supplierId);
            statement.setInt(5, userId);
            
            int affectedRows = statement.executeUpdate();
            
            if (affectedRows > 0) {
                result = statement.getGeneratedKeys();
                if (result.next()) {
                    int generatedId = result.getInt(1);
                    newPurchase = new Purchase(
                            generatedId,
                            result.getString("purchase_date"),
                            result.getDouble("purchase_total"),
                            result.getString("purchase_code"),
                            result.getInt("supplier_id"),
                            result.getInt("user_id")
                    );
                }
            }
            
            statement.close();
            result.close();
            
        } catch(SQLException e) {
            System.out.println("Error al crear la venta: " + e.getMessage());
        } finally {
            DATABASE.disconnect();
            statement = null;
        }
        
        return newPurchase;
    }
    
    public Purchase getPurchaseById( int purchaseId ) {
        Purchase purchase = null;
        
        try {
            
            statement = DATABASE.connect().prepareStatement("SELECT * FROM purchase WHERE purchase_id = ?");
            statement.setInt(1, purchaseId);
            result = statement.executeQuery();
            
            if ( result.next() ) {
                purchase = new Purchase(
                        result.getInt("purchase_id"),
                        result.getString("purchase_date"),
                        result.getDouble("purchase_total"),
                        result.getString("purchase_code"),
                        result.getInt("supplier_id"),
                        result.getInt("user_id")
                );
            }
            
        } catch(SQLException e) {
            System.out.println("No se pudo obtener la compra por id: " + e.getMessage());
        } finally {
            DATABASE.disconnect();
            statement = null;
            result = null;
        }
        
        return purchase;
        
    }
    
    public List<Purchase> getPurchases(int supplierId, String startDate, String endDate) {
        List<Purchase> purchases = new ArrayList<>();
        
        try {
            StringBuilder query = new StringBuilder("SELECT * FROM purchase WHERE 1=1 ");

            if ( supplierId > 0 ) {
                query.append("AND supplier_id = ? ");
            }
            
            if (startDate != null && !startDate.isEmpty()) {
                query.append("AND purchase_date BETWEEN ? AND ? ");
            } else {
                query.append("AND purchase_date <= ? ");
            }
            
            query.append("ORDER BY purchase_date DESC");
            
            statement = DATABASE.connect().prepareStatement(query.toString());

            int paramIndex = 1;
            
            if ( supplierId > 0 ) {
                statement.setInt(paramIndex++, supplierId);
            }

            if (startDate != null && !startDate.isEmpty()) {
                statement.setString(paramIndex++, startDate);
                statement.setString(paramIndex++, endDate);
            } else {
                statement.setString(paramIndex++, endDate);
            }

            result = statement.executeQuery();

            while (result.next()) {
                purchases.add(new Purchase(
                    result.getInt("purchase_id"),
                    result.getString("purchase_date"),
                    result.getDouble("purchase_total"),
                    result.getString("purchase_code"),
                    result.getInt("supplier_id"),
                    result.getInt("user_id")
                ));
            }
            
            statement.close();
            result.close();

        } catch (SQLException e) {
            System.out.println("Error al traer las compras: " + e.getMessage());
        } finally {
            statement = null;
            result = null;
            DATABASE.disconnect();
        }
        
        return purchases;
    }
    
    public double getTotalPurchasesAmount() {
        
        double total = 0.0;
        
        try {
            
            statement = DATABASE.connect().prepareStatement("SELECT SUM(purchase_total) AS total FROM purchase");
            result = statement.executeQuery();
            
            if ( result.next() ) {
                total = result.getDouble("total");
            } 
            
            statement.close();
            result.close();
            
        } catch(SQLException e) {
            System.out.println("Error al traer el total de las compras: " + e.getMessage());
        } finally {
            DATABASE.disconnect();
            statement = null;
            result = null;
        }
        
        return total;
    }
    
    public int getTotalPurchases() {
        int counter = 0;
        
        try {
            
            statement = DATABASE.connect().prepareStatement("SELECT COUNT(*) AS count FROM purchase");
            result = statement.executeQuery();
            
            if ( result.next() ) {
                counter = result.getInt("count");
            }
            
            statement.close();
            result.close();
            
        } catch(SQLException e) {
            System.out.println("No se pudieron obtener la cantidad de compras realizadas: " + e.getMessage());
        } finally {
            DATABASE.disconnect();
            statement = null;
            result = null;
        }
        
        return counter;
    }
    
    public double getAvgPurchaseAmount() {
        double avg = 0;
        
        try {
            
            statement = DATABASE.connect().prepareStatement("SELECT AVG(purchase_total) AS average FROM purchase");
            result = statement.executeQuery();
            
            if ( result.next() ) {
                avg = result.getDouble("average");
            }
            
            statement.close();
            result.close();
            
        } catch(SQLException e) {
            System.out.println("No se pudieron obtener el promedio por compra: " + e.getMessage());
        } finally {
            DATABASE.disconnect();
            statement = null;
            result = null;
        }
        
        return avg;
    }
    
    public TopSupplier getTopSupplierPurchases() {
        TopSupplier supplier = null;
        
        try {
            
            statement = DATABASE.connect().prepareStatement(
                    "SELECT s.supplier_name AS sup_name, s.supplier_lastname AS sup_lastname, SUM(p.purchase_total) AS inversion "
                  + "FROM purchase p "
                  + "JOIN supplier s ON s.supplier_id = p.supplier_id "
                  + "GROUP BY s.supplier_id "
                  + "ORDER BY inversion "
                  + "LIMIT 1"  
            );
            result = statement.executeQuery();
            
            if ( result.next() ){
                supplier = new TopSupplier(
                        result.getString("sup_name"),
                        result.getString("sup_lastname"),
                        result.getDouble("inversion")
                );
            }
            
            statement.close();
            result.close();
            
        } catch(SQLException e) {
            System.out.println("Error al obtener el mejor proveedor: " + e.getMessage());
        } finally {
            DATABASE.disconnect();
            statement = null;
            result = null;
        }
        
        return supplier;
    }
    
    public List<MontlyMoney> getTotalPurchasesPerMonth( int quantityMonths ) {
        
        List<MontlyMoney> monthlyPurchases = new ArrayList<>();
        
        try {
            
            statement = DATABASE.connect().prepareStatement(
                    "SELECT " +
                    "  DATE_FORMAT(purchase_date, '%Y-%m') AS `year_month`, " +
                    "  SUM(pruchase_total) AS total_amount " +
                    "FROM " +
                    "  purchase " +
                    "WHERE " +
                    "  purchase_date >= DATE_SUB(CURDATE(), INTERVAL ? MONTH) " +
                    "GROUP BY " +
                    "  DATE_FORMAT(purchase_date, '%Y-%m') " +
                    "ORDER BY " +
                    "  `year_month` DESC"
            );
            statement.setInt(1, quantityMonths);
            result = statement.executeQuery();
            
            while( result.next() ) {
                String month = result.getString("year_month");
                double total = result.getDouble("total_amount");
                
                monthlyPurchases.add(new MontlyMoney(month, total));
            }
            
            statement.close();
            result.close();
            
        } catch(SQLException e) {
            System.out.println("Error al calcular compras por mes: " + e.getMessage());
        } finally {
            DATABASE.disconnect();
            statement = null;
            result = null;
        }
        
        return monthlyPurchases;
    }
    
    public List<TopProduct> getTopProductsInPurchase( int quantityProducts ) {
        
        List<TopProduct> topProducts = new ArrayList<>();
        
        try {
            
            statement = DATABASE.connect().prepareStatement(
                    "SELECT p.product_name AS p_name, SUM(pd.purchase_detail_quantity) AS total_quantity "
                  + "FROM purchase_detail pd "
                  + "JOIN product p ON p.product_id = pd.product_id "
                  + "GROUP BY p.product_id "
                  + "ORDER BY total_quantity DESC"
                  + "LIMIT ?"
            );
            statement.setInt(1, quantityProducts);
            result = statement.executeQuery();
            
            while ( result.next() ) {
                topProducts.add( 
                    new TopProduct(
                        result.getString("p_name"),
                        result.getInt("total_quantity")
                    )
                );
            }
            
            statement.close();
            result.close();
            
        } catch(SQLException e) {
            System.out.println("No se pudieron obtener los mejores productos en compras: " + e.getMessage());
        } finally {
            DATABASE.disconnect();
            statement = null;
            result = null;
        }
        
        return topProducts;
    } 
    
}
