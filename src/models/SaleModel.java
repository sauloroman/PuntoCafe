package models;

import java.sql.Statement;
import config.Database;
import entities.Sale;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    
    public List<Sale> getSales(int userId, String startDate, String endDate) {        
        List<Sale> sales = new ArrayList<>();

        try {
            StringBuilder query = new StringBuilder("SELECT * FROM sale WHERE 1=1 ");

            if (userId > 0) {
                query.append("AND user_id = ? ORDER BY sale_date DESC");
            }

            if (startDate != null && !startDate.isEmpty()) {
                query.append("AND sale_date BETWEEN ? AND ? ");
            } else {
                query.append("AND sale_date <= ? ");
            }

            statement = DATABASE.connect().prepareStatement(query.toString());

            int paramIndex = 1;

            if (userId > 0) {
                statement.setInt(paramIndex++, userId);
            }

            if (startDate != null && !startDate.isEmpty()) {
                statement.setString(paramIndex++, startDate);
                statement.setString(paramIndex++, endDate);
            } else {
                statement.setString(paramIndex++, endDate);
            }

            result = statement.executeQuery();

            while (result.next()) {
                sales.add(new Sale(
                    result.getInt("sale_id"),
                    result.getString("sale_date"),
                    result.getDouble("sale_total"),
                    result.getString("sale_code"),
                    result.getInt("user_id")
                ));
            }

        } catch (SQLException e) {
            System.out.println("Error al traer las ventas: " + e.getMessage());
        } finally {
            try {
                if (result != null) result.close();
                if (statement != null) statement.close();
                DATABASE.disconnect();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return sales;
    }

    public double getTotalSalesAmount() {
        
        double total = 0.0;
        
        try {
            
            statement = DATABASE.connect().prepareStatement("SELECT SUM(sale_total) AS total FROM sale");
            result = statement.executeQuery();
            
            if ( result.next() ) {
                total = result.getDouble("total");
            }
            
            statement.close();
            result.close();
            
        } catch(SQLException e) {
            System.out.println("Error al calcular el total dinero acumulado de ventas: " + e.getMessage());
        } finally {
            DATABASE.disconnect();
            statement = null;
            result = null;
        }
        
        return total;
    }
    
    public int getTotalSales() {
        
        int total = 0;
        
        try {
            
            statement = DATABASE.connect().prepareStatement("SELECT COUNT(*) AS total_sales FROM sale");
            result = statement.executeQuery();
            
            if ( result.next() ) {
                total = result.getInt("total_sales");
            }
            
            statement.close();
            result.close();
            
        } catch(SQLException e) {
            System.out.println("Error al calcular el total de ventas: " + e.getMessage());
        } finally {
            DATABASE.disconnect();
            statement = null;
            result = null;
        }
        
        return total;
        
    }
    
    public double getAvgSaleAmount() {
        
        double average = 0.0;
        
         try {
            
            statement = DATABASE.connect().prepareStatement("SELECT AVG(sale_total) AS average FROM sale");
            result = statement.executeQuery();
            
            if ( result.next() ) {
                average = result.getDouble("average");
            }
            
            statement.close();
            result.close();
            
        } catch(SQLException e) {
            System.out.println("Error al calcular el promedio de ventas: " + e.getMessage());
        } finally {
            DATABASE.disconnect();
            statement = null;
            result = null;
        }
        
        return average;
        
    }
   
    public double getTotalDiscountSalesAmount() {
        
        double discount = 0.0;
        
        try {
            
            statement = DATABASE.connect().prepareStatement(
                    "SELECT "
                  + "(SELECT SUM(sale_dish_detail_discount) FROM sale_dish_detail) + "
                  + "(SELECT SUM(sale_product_detail_discount) FROM sale_product_detail) AS total_discount"
            );
            result = statement.executeQuery();
            
            if ( result.next() ) {
                discount = result.getDouble("total_discount");
            }
            
            statement.close();
            result.close();
            
        } catch(SQLException e) {
            System.out.println("Error al calcular el total de dinero de descuentos: " + e.getMessage());
        } finally {
            DATABASE.disconnect();
            statement = null;
            result = null;
        }
        
        return discount;
    }
    
    
}
