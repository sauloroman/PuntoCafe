package models;

import config.Database;
import entities.Product;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
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
                    "SELECT p.product_id, p.product_name, p.product_stock, p.product_stock_min "
                  + "FROM product p "
                  + "LEFT JOIN ("
                  + "   SELECT DISTINCT product_id "
                  + "   FROM sale_product_detail AS spd "
                  + "   JOIN sale s ON s.sale_id = spd.sale_id "
                  + "   WHERE s.sale_date >= DATE_SUB(CURDATE(), INTERVAL ? DAY) "
                  + ") AS recent_sales ON recent_sales.product_id = p.product_id "
                  + "WHERE recent_sales.product_id IS NULL"
            );
            statement.setInt(1, quantityDays);
            result = statement.executeQuery();
            
            while( result.next() ) {
                products.add(new Product( 
                        result.getInt("product_id"), 
                        result.getString("product_name") ,
                        result.getInt("product_stock"),
                        result.getInt("product_stock_min")
                ));
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
                    "ORDER BY total_profit DESC LIMIT 10"
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
    
    public Map<String, Integer> getTopSellingProductsOfMonth( int quantity ) {
        Map<String, Integer> products = new LinkedHashMap<>();

        try {
            statement = DATABASE.connect().prepareStatement(
                "SELECT p.product_name, SUM(spd.sale_product_detail_quantity) AS total_quantity " +
                "FROM sale_product_detail spd " +
                "JOIN sale s ON s.sale_id = spd.sale_id " +
                "JOIN product p ON p.product_id = spd.product_id " +
                "WHERE MONTH(s.sale_date) = MONTH(CURDATE()) AND YEAR(s.sale_date) = YEAR(CURDATE()) " +
                "GROUP BY p.product_id, p.product_name " +
                "ORDER BY total_quantity DESC LIMIT ?"
            );
            statement.setInt(1, quantity);

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

    public Map<String, Double> getMonthlyGrowth( int quantityMonths ) {
        Map<String, Double> monthlyTotals = new LinkedHashMap<>();

        try {
            statement = DATABASE.connect().prepareStatement(
                "SELECT DATE_FORMAT(sale_date, '%Y-%m') AS month, " +
                "       SUM(sale_total) AS total_sales " +
                "FROM sale " +
                "GROUP BY month " +
                "ORDER BY month ASC LIMIT ?"
            );
            statement.setInt(1, quantityMonths);
            
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
    
    
    public Map<String, Double> getTopSalesMonths(int limit) {
        Map<String, Double> topMonths = new LinkedHashMap<>();

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
                double total = result.getDouble("total_sales");
                topMonths.put(month, total);
            }

        } catch (SQLException e) {
            System.out.println("No fue posible obtener los meses con mayores ventas: " + e.getMessage());
        } finally {
            closeResources();
        }

        return topMonths;
    }
    
    public Map<String, Integer> getTopSalesCountMonths(int limit) {
        Map<String, Integer> topMonths = new LinkedHashMap<>();

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
                int count = result.getInt("total_sales_count");
                topMonths.put(month, count);
            }

        } catch (SQLException e) {
            System.out.println("No fue posible obtener los meses con mayor número de ventas: " + e.getMessage());
        } finally {
            closeResources();
        }

        return topMonths;
    }

    public Map<String, Double> getAverageDailySalesPerMonth(int limit) {
        Map<String, Double> results = new LinkedHashMap<>();

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
                results.put(month, average);
            }

        } catch (SQLException e) {
            System.out.println("No fue posible obtener el promedio diario por mes: " + e.getMessage());
        } finally {
            closeResources();
        }

        return results;
    }
    
    public Map<String, Double> getAverageTimeBetweenPurchaseAndSalePerProduct(int limit) {
        Map<String, Double> results = new LinkedHashMap<>();

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
                String productName = result.getString("product_name");
                double avgDays = result.getDouble("avg_days");
                results.put(productName, avgDays);
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
    
    public Map<String, Double> getTopSuppliersByInvestment(int limit) {
        Map<String, Double> supplierInvestmentMap = new LinkedHashMap<>();

        try {
            statement = DATABASE.connect().prepareStatement(
                "SELECT CONCAT(s.supplier_name, ' ', s.supplier_lastname) AS supplier_name, " +
                "       ROUND(SUM(pd.purchase_detail_quantity * pd.purchase_detail_unit_price), 2) AS total_investment " +
                "FROM supplier s " +
                "JOIN purchase p ON s.supplier_id = p.supplier_id " +
                "JOIN purchase_detail pd ON p.purchase_id = pd.purchase_id " +
                "GROUP BY s.supplier_id " +
                "ORDER BY total_investment DESC " +
                "LIMIT ?"
            );

            statement.setInt(1, limit);
            result = statement.executeQuery();

            while (result.next()) {
                String name = result.getString("supplier_name");
                double investment = result.getDouble("total_investment");
                supplierInvestmentMap.put(name, investment);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener proveedores con mayor inversión: " + e.getMessage());
        } finally {
            closeResources();
        }

        return supplierInvestmentMap;
    }
    
    public Map<String, Integer> getTopMonthsByPurchases() {
        Map<String, Integer> purchasesPerMonth = new LinkedHashMap<>();

        try {
            statement = DATABASE.connect().prepareStatement(
                "SELECT DATE_FORMAT(purchase_date, '%Y-%m') AS month, " +
                "       COUNT(*) AS total_purchases " +
                "FROM purchase " +
                "GROUP BY month " +
                "ORDER BY total_purchases DESC " +
                "LIMIT 3"
            );

            result = statement.executeQuery();

            while (result.next()) {
                String month = result.getString("month");
                int total = result.getInt("total_purchases");
                purchasesPerMonth.put(month, total);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener los meses con más compras realizadas: " + e.getMessage());
        } finally {
            closeResources();
        }

        return purchasesPerMonth;
    }
    
    public Map<String, Map<String, BigDecimal>> getMonthlyPurchaseAndSaleTotals(int monthsBack) {
        Map<String, Map<String, BigDecimal>> monthlyTotals = new LinkedHashMap<>();

        try {
            statement = DATABASE.connect().prepareStatement(
                "SELECT DATE_FORMAT(fecha, '%Y-%m') AS mes, tipo, SUM(total) AS total " +
                "FROM ( " +
                "   SELECT purchase_date AS fecha, 'compra' AS tipo, purchase_total AS total " +
                "   FROM purchase " +
                "   WHERE purchase_date >= DATE_SUB(CURDATE(), INTERVAL ? MONTH) " +
                "   UNION ALL " +
                "   SELECT sale_date AS fecha, 'venta' AS tipo, sale_total AS total " +
                "   FROM sale " +
                "   WHERE sale_date >= DATE_SUB(CURDATE(), INTERVAL ? MONTH) " +
                ") AS combined " +
                "GROUP BY mes, tipo " +
                "ORDER BY mes ASC"
            );

            statement.setInt(1, monthsBack);
            statement.setInt(2, monthsBack);
            result = statement.executeQuery();

            while (result.next()) {
                String month = result.getString("mes");
                String type = result.getString("tipo"); 
                BigDecimal total = result.getBigDecimal("total");

                monthlyTotals.putIfAbsent(month, new HashMap<>());
                monthlyTotals.get(month).put(type, total);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener comparativa mensual de compras y ventas: " + e.getMessage());
        } finally {
            closeResources();
        }

        return monthlyTotals;
    }
    
    public BigDecimal getEstimatedNetProfit() {
        BigDecimal totalSales = BigDecimal.ZERO;
        BigDecimal totalPurchases = BigDecimal.ZERO;

        try {
            statement = DATABASE.connect().prepareStatement("SELECT SUM(sale_total) FROM sale");
            result = statement.executeQuery();
            if (result.next()) {
                totalSales = result.getBigDecimal(1);
            }

            statement = DATABASE.connect().prepareStatement("SELECT SUM(purchase_total) FROM purchase");
            result = statement.executeQuery();
            if (result.next()) {
                totalPurchases = result.getBigDecimal(1);
            }

        } catch (SQLException e) {
            System.out.println("Error al calcular ganancia neta: " + e.getMessage());
        } finally {
            closeResources();
        }

        return totalSales.subtract(totalPurchases);
    }
    
    public Map<String, Double> getMonthlyGrowthPercentage() {
        Map<String, Double> growth = new LinkedHashMap<>();

        try {
            statement = DATABASE.connect().prepareStatement(
                "SELECT DATE_FORMAT(sale_date, '%Y-%m') AS mes, SUM(sale_total) AS total " +
                "FROM sale " +
                "GROUP BY mes " +
                "ORDER BY mes"
            );
            result = statement.executeQuery();

            BigDecimal previous = null;
            while (result.next()) {
                String month = result.getString("mes");
                BigDecimal current = result.getBigDecimal("total");

                if (previous != null && previous.compareTo(BigDecimal.ZERO) > 0) {
                    double percent = current.subtract(previous)
                                            .divide(previous, 4, RoundingMode.HALF_UP)
                                            .multiply(BigDecimal.valueOf(100))
                                            .doubleValue();
                    growth.put(month, percent);
                } else {
                    growth.put(month, 0.0);
                }

                previous = current;
            }

        } catch (SQLException e) {
            System.out.println("Error al calcular crecimiento mensual: " + e.getMessage());
        } finally {
            closeResources();
        }

        return growth;
    }

    public Map<String, Integer> getTopSellingProduct() {
        Map<String, Integer> topProduct = new LinkedHashMap<>();

        try {
            statement = DATABASE.connect().prepareStatement(
                "SELECT p.product_name, SUM(spd.sale_product_detail_quantity) AS total_quantity " +
                "FROM sale_product_detail spd " +
                "JOIN product p ON p.product_id = spd.product_id " +
                "GROUP BY p.product_name " +
                "ORDER BY total_quantity DESC " +
                "LIMIT 1"
            );
            result = statement.executeQuery();

            if (result.next()) {
                topProduct.put(result.getString("product_name"), result.getInt("total_quantity"));
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener el producto más vendido: " + e.getMessage());
        } finally {
            closeResources();
        }

        return topProduct;
    }
    
    public Map<String, Integer> getTopSellerUser() {
        Map<String, Integer> topUser = new LinkedHashMap<>();

        try {
            statement = DATABASE.connect().prepareStatement(
                "SELECT CONCAT(u.user_name, ' ', u.user_lastname) AS username, COUNT(*) AS ventas " +
                "FROM sale s " +
                "JOIN user u ON u.user_id = s.user_id " +
                "GROUP BY u.user_id " +
                "ORDER BY ventas DESC " +
                "LIMIT 1"
            );
            result = statement.executeQuery();

            if (result.next()) {
                topUser.put(result.getString("username"), result.getInt("ventas"));
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener el usuario con más ventas: " + e.getMessage());
        } finally {
            closeResources();
        }

        return topUser;
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
