package models;

import java.sql.Statement;
import config.Database;
import entities.MontlyMoney;
import entities.Sale;
import entities.SoldCategoryTotal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SaleModel {
    
    private final Database DATABASE;
    private PreparedStatement statement;
    private ResultSet result;
    
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
            
            statement.close();
            result.close();
            
        } catch(SQLException e) {
            System.out.println("Error al crear la venta: " + e.getMessage());
        } finally {
            DATABASE.disconnect();
            statement = null;
        }
        
        return newSale;
    }
    
    public Sale getSaleById(int saleId) {
        Sale sale = null;
        
        try {
            
            statement = DATABASE.connect().prepareStatement("SELECT * FROM sale WHERE sale_id = ?");
            statement.setInt(1, saleId);
            result = statement.executeQuery();
            
            if ( result.next() ) {
                sale = new Sale(
                    result.getInt("sale_id"),
                    result.getString("sale_date"),
                    result.getDouble("sale_total"),
                    result.getString("sale_code"),
                    result.getInt("user_id")  
                );
            }
            
        } catch(SQLException e) {
            System.out.println("No se pudo obtener la venta por id: " + e.getMessage());
        } finally {
            DATABASE.disconnect();
            statement = null;
            result = null;
        }
        
        return sale;
    }
    
    public List<Sale> getSales(int userId, String startDate, String endDate) {        
        List<Sale> sales = new ArrayList<>();

        try {
            StringBuilder query = new StringBuilder("SELECT * FROM sale WHERE 1=1 ");

            if (userId > 0) {
                query.append("AND user_id = ? ");
            }

            if (startDate != null && !startDate.isEmpty()) {
                query.append("AND sale_date BETWEEN ? AND ? ");
            } else {
                query.append("AND sale_date <= ? ");
            }
            
             query.append("ORDER BY sale_date DESC");
            
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

            result.close();
            statement.close();
            
        } catch (SQLException e) {
            System.out.println("Error al traer las ventas: " + e.getMessage());
        } finally {
            result = null;
            statement = null;
            DATABASE.disconnect();
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
    
    public List<MontlyMoney> getTotalSalesPerMonth( int quantityMonths ) {
        
        List<MontlyMoney> monthlySales = new ArrayList<>();
        
        try {
            
            statement = DATABASE.connect().prepareStatement(
                    "SELECT " +
                        "DATE_FORMAT(sale_date, '%Y-%m') AS `year_month`, " + 
                        "SUM(sale_total) AS total_amount " +
                    "FROM sale " +
                    "WHERE DATE_FORMAT(sale_date, '%Y-%m') >= DATE_FORMAT(DATE_SUB(CURDATE(), INTERVAL ? MONTH), '%Y-%m') " +
                    "GROUP BY DATE_FORMAT(sale_date, '%Y-%m') " +
                    "ORDER BY `year_month` DESC "
            );
            statement.setInt(1, quantityMonths - 1);
            result = statement.executeQuery();
            
            while( result.next() ) {
                String month = result.getString("year_month");
                double total = result.getDouble("total_amount");
                
                monthlySales.add(new MontlyMoney(month, total));
            }
            
            statement.close();
            result.close();
            
        } catch(SQLException e) {
            System.out.println("Error al calcular ventas por mes: " + e.getMessage());
        } finally {
            DATABASE.disconnect();
            statement = null;
            result = null;
        }
        
        return monthlySales;
    }
    
    public List<SoldCategoryTotal> getItemsCountPercentageByCategory() {
        List<SoldCategoryTotal> totals = new ArrayList<>();
        
        try {
            
            statement = DATABASE.connect().prepareStatement(
                    "(SELECT 'Producto' AS category, SUM(spd.sale_product_detail_quantity) AS count " +
                    "FROM sale_product_detail AS spd) " +
                    "	UNION ALL" +
                    "(SELECT 'Platillo' AS category, SUM(sdd.sale_dish_detail_quantity) AS count " +
                    "FROM sale_dish_detail AS sdd)"
            );
            result = statement.executeQuery();
            
            int totalItems = 0;
            int productCount = 0;
            int dishCount = 0;
            
            while( result.next() ) {
                String category = result.getString("category");
                int count = result.getInt("count");
                
                if ( category.equals("Producto") ) {
                    productCount = count;
                } else {
                    dishCount = count;
                }
                
                totalItems += count;
            }
            
            result.close();
            statement.close();
            
            if ( totalItems > 0 ) {
                double productPercentage = ((double) productCount / totalItems) * 100;
                double dishPercentage = ((double) dishCount / totalItems ) * 100;
                
                totals.add(new SoldCategoryTotal("Productos", productCount, productPercentage));
                totals.add(new SoldCategoryTotal("Platillos", dishCount, dishPercentage));
            } else {
                totals.add(new SoldCategoryTotal("Productos", 0, 0));
                totals.add(new SoldCategoryTotal("Platillos", 0, 0));
            }
            
        } catch(SQLException e) {
            System.out.println("Error al obtener los ´porcentajes de items por categoría: " + e.getMessage());
        } finally {
            DATABASE.disconnect();
            statement = null;
            result = null;
        }
        
        return totals;
    }
    
}
