package models;

import config.Database;
import entities.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StatsModel {
    
    private final Database DATABASE;
    private PreparedStatement statement;
    private ResultSet result;
    
    public StatsModel() {
        this.DATABASE = Database.getInstance();
    }
 
    public List<Product> getLowRotationProducts( int quantityDays ) {
        
        List<Product> products = new ArrayList<>();
        
        try {
            
            statement = DATABASE.connect().prepareStatement(
                    "SELECT p.product_id, p.product_name "
                  + "FROM product p "
                  + "LEFT JOIN ("
                  + "   SELECT DISTINCT product_id "
                  + "   FROM sale_product_detail AS spd "
                  + "   JOIN sale s ON s.sale_id = spd.sale_id "
                  + "   WHERE s.sale_date >= DATE_SUB(CURDATE(), INTERVALE ? days) "
                  + ") AS recent_sales ON recent_sales.product_id = p.product_id "
                  + "WHERE recent_sales.product_id IS NULL"
            );
            statement.setInt(1, quantityDays);
            result = statement.executeQuery();
            
            while( result.next() ) {
                products.add(new Product( result.getInt("product_id"), result.getString("product_name") ));
            }
            
        } catch(SQLException e) {
            System.out.println("No fue posible obtener los productos con baja rotación: " + e.getMessage());
        } finally {
            closeResources();
        }
        
        return products;
    }
    
    public List<Product> getCriticalStockProducts() {
        List<Product> critical = new ArrayList<>();
        
        try {
            statement = DATABASE.connect().prepareStatement(
                "SELECT product_id, product_name, product_stock, product_stock_min " +
                "FROM product WHERE product_stock <= product_stock_min"
            );
            
            result = statement.executeQuery();
            
            while (result.next()) {
                Product p = new Product(
                        result.getInt("product_id"), 
                        result.getString("product_name"),
                        result.getInt("product_stock"),
                        result.getInt("product_stock_min")
                );
                critical.add(p);
            }
            
        } catch (SQLException e) {
            System.out.println("Error al obtener productos con stock crítico: " + e.getMessage());
        } finally {
            closeResources();
        }
        return critical;
    }
    
    public Map<String, Double> getMostProfitableProducts() {
        
        Map<String, Double> profits = new LinkedHashMap<>();
        
        try {
            
            statement = DATABASE.connect().prepareStatement(
                    "SELECT " +
                            "p.product_name, " +
                            "SUM((spd.sale_product_detail_unit_price - IFNULL(avg_prices.avg_cost, 0)) * spd.sale_product_detail_quantity) AS total_profit " +
                    "FROM sale_product_detail spd " +
                    "JOIN product p ON p.product_id = spd.product_id " +
                    "JOIN sale s ON s.sale_id = spd.sale_id " +
                    "LEFT JOIN ( " +
                        "SELECT product_id, AVG(purchase_detail_unit_price) AS avg_cost " +
                        "FROM purchase_detail " + 
                        "GROUP BY product_id " +
                    ") AS avg_prices ON avg_prices.product_id = p.product_id " +
                    "GROUP BY p.product_id, p.product_name " +
                    "ORDER BY total_profit DESC"
            );
            result = statement.executeQuery();
            
            while( result.next() ) {
                profits.put(result.getString("product_name"), result.getDouble("total_profit"));
            }
            
        } catch(SQLException e) {
            System.out.println("Error al obtener productos más rentables: " + e.getMessage());
        } finally {
            closeResources();
        }
        
        return profits;
    }   
    
    public Map<String, Integer> getTopSellingProductsOfMonth() {
        Map<String, Integer> products = new LinkedHashMap<>();

        try {
            statement = DATABASE.connect().prepareStatement(
                "SELECT p.product_name, SUM(spd.sale_product_detail_quantity) AS total_quantity " +
                "FROM sale_product_detail spd " +
                "JOIN sale s ON s.sale_id = spd.sale_id " +
                "JOIN product p ON p.product_id = spd.product_id " +
                "WHERE MONTH(s.sale_date) = MONTH(CURDATE()) AND YEAR(s.sale_date) = YEAR(CURDATE()) " +
                "GROUP BY p.product_id, p.product_name " +
                "ORDER BY total_quantity DESC"
            );

            result = statement.executeQuery();

            while (result.next()) {
                products.put(result.getString("product_name"), result.getInt("total_quantity"));
            }

        } catch (SQLException e) {
            System.out.println("No fue posible obtener los productos más vendidos del mes: " + e.getMessage());
        } finally {
            closeResources();
        }

        return products;
    }

    public Map<String, Double> getMonthlyGrowth() {
        Map<String, Double> monthlyTotals = new LinkedHashMap<>();

        try {
            statement = DATABASE.connect().prepareStatement(
                "SELECT DATE_FORMAT(sale_date, '%Y-%m') AS month, " +
                "       SUM(sale_total) AS total_sales " +
                "FROM sale " +
                "GROUP BY month " +
                "ORDER BY month ASC"
            );

            result = statement.executeQuery();

            String previousMonth = null;
            double previousTotal = 0;

            while (result.next()) {
                String month = result.getString("month");
                double total = result.getDouble("total_sales");

                if (previousMonth != null) {
                    double growth = ((total - previousTotal) / previousTotal) * 100;
                    monthlyTotals.put(month, Math.round(growth * 100.0) / 100.0);
                } else {
                    monthlyTotals.put(month, 0.0);
                }

                previousMonth = month;
                previousTotal = total;
            }

        } catch (SQLException e) {
            System.out.println("No fue posible calcular el crecimiento mensual: " + e.getMessage());
        } finally {
            closeResources();
        }

        return monthlyTotals;
    }
    
    
    public List<String> getTopSalesMonths(int limit) {
        List<String> topMonths = new ArrayList<>();

        try {
            statement = DATABASE.connect().prepareStatement(
                "SELECT DATE_FORMAT(sale_date, '%Y-%m') AS month, " +
                "       SUM(sale_total) AS total_sales " +
                "FROM sale " +
                "GROUP BY month " +
                "ORDER BY total_sales DESC " +
                "LIMIT ?"
            );

            statement.setInt(1, limit);
            result = statement.executeQuery();

            while (result.next()) {
                String month = result.getString("month");
                topMonths.add(month);
            }

        } catch (SQLException e) {
            System.out.println("No fue posible obtener los meses con mayores ventas: " + e.getMessage());
        } finally {
            closeResources();
        }

        return topMonths;
    }
    
    public List<String> getTopSalesCountMonths(int limit) {
        List<String> topMonths = new ArrayList<>();

        try {
            statement = DATABASE.connect().prepareStatement(
                "SELECT DATE_FORMAT(sale_date, '%Y-%m') AS month, " +
                "       COUNT(*) AS total_sales_count " +
                "FROM sale " +
                "GROUP BY month " +
                "ORDER BY total_sales_count DESC " +
                "LIMIT ?"
            );

            statement.setInt(1, limit);
            result = statement.executeQuery();

            while (result.next()) {
                String month = result.getString("month");
                topMonths.add(month);
            }

        } catch (SQLException e) {
            System.out.println("No fue posible obtener los meses con mayor número de ventas: " + e.getMessage());
        } finally {
            closeResources();
        }

        return topMonths;
    }

    public List<String> getAverageDailySalesPerMonth(int limit) {
        List<String> results = new ArrayList<>();

        try {
            statement = DATABASE.connect().prepareStatement(
                "SELECT DATE_FORMAT(sale_date, '%Y-%m') AS month, " +
                "       ROUND(SUM(sale_total) / COUNT(DISTINCT DATE(sale_date)), 2) AS avg_daily_sales " +
                "FROM sale " +
                "GROUP BY month " +
                "ORDER BY avg_daily_sales DESC " +
                "LIMIT ?"
            );

            statement.setInt(1, limit);
            result = statement.executeQuery();

            while (result.next()) {
                String month = result.getString("month");
                double average = result.getDouble("avg_daily_sales");
                results.add(month + " - $" + average);
            }

        } catch (SQLException e) {
            System.out.println("No fue posible obtener el promedio diario por mes: " + e.getMessage());
        } finally {
            closeResources();
        }

        return results;
    }
    
    public List<String> getAverageTimeBetweenPurchaseAndSalePerProduct(int limit) {
        List<String> results = new ArrayList<>();

        try {
            statement = DATABASE.connect().prepareStatement(
                "SELECT p.product_name, " +
                "       ROUND(AVG(DATEDIFF(s.sale_date, pu.purchase_date)), 2) AS avg_days " +
                "FROM product p " +
                "JOIN purchase_detail pd ON p.product_id = pd.product_id " +
                "JOIN purchase pu ON pd.purchase_id = pu.purchase_id " +
                "JOIN sale_product_detail spd ON p.product_id = spd.product_id " +
                "JOIN sale s ON spd.sale_id = s.sale_id " +
                "WHERE s.sale_date > pu.purchase_date " +
                "GROUP BY p.product_id " +
                "ORDER BY avg_days DESC " +
                "LIMIT ?"
            );

            statement.setInt(1, limit);
            result = statement.executeQuery();

            while (result.next()) {
                results.add(result.getString("product_name") + " - " + result.getDouble("avg_days") + " días");
            }

        } catch (SQLException e) {
            System.out.println("Error al calcular el tiempo promedio entre compra y venta: " + e.getMessage());
        } finally {
            closeResources();
        }

        return results;
    }
    
    public List<String> getUnsoldPurchasedProducts() {
        List<String> results = new ArrayList<>();

        try {
            statement = DATABASE.connect().prepareStatement(
                "SELECT DISTINCT p.product_name " +
                "FROM purchase_detail pd " +
                "JOIN product p ON pd.product_id = p.product_id " +
                "LEFT JOIN sale_product_detail spd ON p.product_id = spd.product_id " +
                "WHERE spd.product_id IS NULL"
            );

            result = statement.executeQuery();

            while (result.next()) {
                results.add(result.getString("product_name"));
            }

        } catch (SQLException e) {
            System.out.println("No fue posible obtener productos comprados y no vendidos: " + e.getMessage());
        } finally {
            closeResources();
        }

        return results;
    }
    
    public List<String> getTopSuppliersByVolumePurchased(int limit) {
        List<String> results = new ArrayList<>();

        try {
            statement = DATABASE.connect().prepareStatement(
                "SELECT CONCAT(s.supplier_name, ' ', s.supplier_lastname) AS supplier_name, " +
                "       SUM(pd.purchase_detail_quantity) AS total_quantity " +
                "FROM supplier s " +
                "JOIN purchase p ON s.supplier_id = p.supplier_id " +
                "JOIN purchase_detail pd ON p.purchase_id = pd.purchase_id " +
                "GROUP BY s.supplier_id " +
                "ORDER BY total_quantity DESC " +
                "LIMIT ?"
            );

            statement.setInt(1, limit);
            result = statement.executeQuery();

            while (result.next()) {
                results.add(result.getString("supplier_name") + " - " + result.getInt("total_quantity") + " unidades");
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener proveedores con mayor volumen comprado: " + e.getMessage());
        } finally {
            closeResources();
        }

        return results;
    }
    
    public List<String> getTopMonthsByPurchases(int limit) {
        List<String> results = new ArrayList<>();

        try {
            statement = DATABASE.connect().prepareStatement(
                "SELECT DATE_FORMAT(purchase_date, '%Y-%m') AS month, " +
                "       COUNT(*) AS total_purchases " +
                "FROM purchase " +
                "GROUP BY month " +
                "ORDER BY total_purchases DESC " +
                "LIMIT ?"
            );

            statement.setInt(1, limit);
            result = statement.executeQuery();

            while (result.next()) {
                results.add(result.getString("month") + " - " + result.getInt("total_purchases") + " compras");
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener los meses con más compras realizadas: " + e.getMessage());
        } finally {
            closeResources();
        }

        return results;
    }
    
    private void closeResources() {
        try {
            if (result != null) result.close();
            if (statement != null) statement.close();
            DATABASE.disconnect();
        } catch (SQLException e) {
            System.out.println("Error al cerrar recursos: " + e.getMessage());
        }
    }
}
