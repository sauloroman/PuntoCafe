package models;

import config.Database;
import entities.Product;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.interfaces.CrudInterface;
import utils.enums.SearchCriteriaEnum;

public class ProductModel implements CrudInterface<Product> {

    private final Database DATABASE;
    private PreparedStatement statement;
    private ResultSet result;
    private boolean response;
    
    public ProductModel() {
        this.DATABASE = Database.getInstance();
    }
    
    @Override
    public Product getItemByName(String name) {
        
        Product product = null;
        
        try {
            
            statement = DATABASE.connect().prepareStatement("SELECT * FROM product WHERE product_name LIKE ?");
            statement.setString(1, "%" + name + "%");
            result = statement.executeQuery();
            
            if ( result.next() ) {
                product = new Product(
                    result.getInt("product_id"),
                    result.getString("product_name"),
                    result.getString("product_description"),
                    result.getString("product_image"),
                    result.getDouble("product_selling_price"),
                    result.getInt("product_stock"),
                    result.getInt("product_stock_min"),
                    result.getBoolean("product_is_active"),
                    result.getDate("product_createdAt"),
                    result.getDate("product_updatedAt"),
                    result.getInt("category_id"),
                    result.getInt("supplier_id")
                );
            }
  
            statement.close();
            
        } catch(SQLException e) {
            System.out.println("No se pudo obtener el producto: " + e.getMessage() );
        } finally {
            statement = null;
            DATABASE.disconnect();
        }
        
        return product;
    }

    @Override
    public List<Product> listItems(String filter) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Product> listItemsByPage(String filter, SearchCriteriaEnum criteria, int page, int itemsPerPage) {
        List<Product> products = new ArrayList<>();
        
        try {
            
            statement = DATABASE.connect().prepareStatement("SELECT * FROM product ORDER BY product_createdAt DESC LIMIT ?, ?");
            statement.setInt(1, (page - 1) * itemsPerPage);
            statement.setInt(2, itemsPerPage);
            result = statement.executeQuery();
            
            while( result.next() ) {
                products.add(
                        new Product(
                                result.getInt("product_id"),
                                result.getString("product_name"),
                                result.getString("product_description"),
                                result.getString("product_image"),
                                result.getDouble("product_selling_price"),
                                result.getInt("product_stock"),
                                result.getInt("product_stock_min"),
                                result.getBoolean("product_is_active"),
                                result.getDate("product_createdAt"),
                                result.getDate("product_updatedAt"),
                                result.getInt("category_id"),
                                result.getInt("supplier_id")
                        )
                );
            }
            
            statement.close();
            result.close();
            
        } catch(SQLException e) {
            System.out.println("No se pudieron obtener los productos: " + e.getMessage() );
        } finally {
            statement = null;
            result = null;
            DATABASE.disconnect();
        }

        return products;
    }

    @Override
    public boolean saveItem(Product obj) {
        
        response = false;
        
        try {
            
            String productName = obj.getProductName();
            String productDescription = obj.getProductDescription();
            String productImage = obj.getProductImage();
            Double productSellingPrice = obj.getProductSellingPrice();
            int productStock = obj.getProductStock();
            int productStockMin = obj.getProductStockMin();
            int categoryId = obj.getCategoryId();
            int supplierId = obj.getSupplierId();
            
            boolean hashDescription = productDescription != null && !productDescription.isEmpty();
            boolean hashImage = productImage != null && !productImage.isEmpty();
            
            if ( hashDescription && hashImage ) {
                statement = DATABASE.connect().prepareStatement(
                        "INSERT INTO product (product_name, product_description, product_image, product_selling_price, product_stock, product_stock_min, category_id, supplier_id ) "
                      + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
                );
                statement.setString(1, productName);
                statement.setString(2, productDescription);
                statement.setString(3, productImage);
                statement.setDouble(4, productSellingPrice);
                statement.setInt(5, productStock);
                statement.setInt(6, productStockMin);
                statement.setInt(7, categoryId);
                statement.setInt(8, supplierId);
                
            } else if ( hashDescription && !hashImage ) {
                statement = DATABASE.connect().prepareStatement(
                        "INSERT INTO product (product_name, product_description, product_selling_price, product_stock, product_stock_min, category_id, supplier_id ) "
                      + "VALUES (?, ?, ?, ?, ?, ?, ?)"
                );
                statement.setString(1, productName);
                statement.setString(2, productDescription);
                statement.setDouble(3, productSellingPrice);
                statement.setInt(4, productStock);
                statement.setInt(5, productStockMin);
                statement.setInt(6, categoryId);
                statement.setInt(7, supplierId);
            } else if ( !hashDescription && hashImage ) {
                statement = DATABASE.connect().prepareStatement(
                        "INSERT INTO product (product_name, product_image, product_selling_price, product_stock, product_stock_min, category_id, supplier_id ) "
                      + "VALUES (?, ?, ?, ?, ?, ?, ?)"
                );
                statement.setString(1, productName);
                statement.setString(2, productImage);
                statement.setDouble(3, productSellingPrice);
                statement.setInt(4, productStock);
                statement.setInt(5, productStockMin);
                statement.setInt(6, categoryId);
                statement.setInt(7, supplierId);
            } else {
                statement = DATABASE.connect().prepareStatement(
                        "INSERT INTO product (product_name, product_selling_price, product_stock, product_stock_min, category_id, supplier_id ) "
                      + "VALUES (?, ?, ?, ?, ?, ?)"
                );
                statement.setString(1, productName);
                statement.setDouble(2, productSellingPrice);
                statement.setInt(3, productStock);
                statement.setInt(4, productStockMin);
                statement.setInt(5, categoryId);
                statement.setInt(6, supplierId);
            }
            
            if ( statement.executeUpdate() > 0 ) {
                response = true;
            }
            
            statement.close();
            
        } catch(SQLException e) {
            System.out.println("No se pudo crear el producto: " + e.getMessage() );
        } finally {
            DATABASE.disconnect();
            statement = null;
        }

        return response;
    }

    @Override
    public boolean changeStatus(int id, boolean status) {
        response = false;
        
        try {
            
            statement = DATABASE.connect().prepareStatement(
                    "UPDATE product "
                  + "SET product_is_active = ? "
                  + "WHERE product_id = ?"
            );
            statement.setBoolean(1, status);
            statement.setInt(2, id);
            
            if ( statement.executeUpdate() >  0 ) {
                response = true;
            }
            
            statement.close();
            
        } catch(SQLException e) {
            System.out.println("El producto no puedo cambiar de estado: " + e.getMessage() );
        } finally {
            DATABASE.disconnect();
            statement = null;
        }
        
        return response;
    }

    @Override
    public boolean updateItem(Product obj, int id) {
        
        response = false;
        
        try {
            
            statement = DATABASE.connect().prepareStatement(
                    "UPDATE product "
                  + "SET product_name = ?, product_description = ?, product_image = ?, product_selling_price = ?, product_stock = ?, product_stock_min = ?, category_id = ?, supplier_id = ? "
                  + "WHERE product_id = ?"
            );
            statement.setString(1, obj.getProductName());
            statement.setString(2, obj.getProductDescription());
            statement.setString(3, obj.getProductImage());
            statement.setDouble(4, obj.getProductSellingPrice());
            statement.setInt(5, obj.getProductStock());
            statement.setInt(6, obj.getProductStockMin());
            statement.setInt(7, obj.getCategoryId());
            statement.setInt(8, obj.getSupplierId());
            statement.setInt(9, id);
            
            if ( statement.executeUpdate() > 0 ) {
                response = true;
            }
            
            statement.close();
            
        } catch(SQLException e) {
            System.out.println("No se pudo actualizar el producto: " + e.getMessage());
        } finally {
            DATABASE.disconnect();
            statement = null;
        }
        
        return response;
    }

    @Override
    public int getTotalItems() {
        int totalItems = 0;
        
        try {
            
            statement = DATABASE.connect().prepareStatement("SELECT COUNT(*) FROM product");
            result = statement.executeQuery();
            
            while( result.next() ) {
                totalItems = result.getInt("COUNT(*)");
            }
            
            statement.close();
            result.close();
            
        } catch(SQLException e) {
            System.out.println("No se pudo obtener el total de productos");
        } finally {
            statement = null;
            result = null;
            DATABASE.disconnect();
        }
        
        return totalItems;
    }  
    
    public int getTotalProductsByCategoryId(int id) {
        int totalItems = 0;
        
        try {
            
            statement = DATABASE.connect().prepareStatement("SELECT COUNT(*) FROM product WHERE category_id = ?");
            statement.setInt(1, id);
            
            result = statement.executeQuery();
            
            while( result.next() ) {
                totalItems = result.getInt("COUNT(*)");
            }
            
            statement.close();
            result.close();
            
        } catch(SQLException e) {
            System.out.println("No se pudo obtener el total de productos");
        } finally {
            statement = null;
            result = null;
            DATABASE.disconnect();
        }
        
        return totalItems;
    }
    
    public int getTotalProductsBySupplierCompany(String supplierCompany) {
        int totalItems = 0;
        
        try {
            
            statement = DATABASE.connect().prepareStatement(
                    "SELECT COUNT(*) "
                  + "FROM product "
                  + "INNER JOIN supplier ON supplier.supplier_id = product.supplier_id "
                  + "WHERE supplier.supplier_company = ?"
            );
            statement.setString(1, supplierCompany);
            result = statement.executeQuery();
            
            while( result.next() ) {
                totalItems = result.getInt("COUNT(*)");
            }
            
            statement.close();
            result.close();
            
        } catch(SQLException e) {
            System.out.println("No se pudo obtener el total de productos " + e.getMessage());
        } finally {
            statement = null;
            result = null;
            DATABASE.disconnect();
        }
        
        return totalItems;
    }
    
    public int getTotalProductsByStatus(String status) {
        int totalItems = 0;
        
        try {
            
            statement = DATABASE.connect().prepareStatement(
                  "SELECT COUNT(*) "
                + "FROM product "
                + "WHERE product_is_active = ? "
            );
            statement.setInt(1, status.equals("Activo") ? 1 : 0);
            result = statement.executeQuery();
            
            while( result.next() ) {
                totalItems = result.getInt("COUNT(*)");
            }
            
            statement.close();
            result.close();
            
        } catch(SQLException e) {
            System.out.println("No se pudo obtener el total de productos " + e.getMessage());
        } finally {
            statement = null;
            result = null;
            DATABASE.disconnect();
        }
        
        return totalItems;
    }
    
    public int getTotalProductsByName(String name) {
        int totalItems = 0;
        
        try {
            
            statement = DATABASE.connect().prepareStatement(
                  "SELECT COUNT(*) "
                + "FROM product "
                + "WHERE product_is_active LIKE ? "
            );
            statement.setString(1, "%" + name + "%");
            result = statement.executeQuery();
            
            while( result.next() ) {
                totalItems = result.getInt("COUNT(*)");
            }
            
            statement.close();
            result.close();
            
        } catch(SQLException e) {
            System.out.println("No se pudo obtener el total de productos " + e.getMessage());
        } finally {
            statement = null;
            result = null;
            DATABASE.disconnect();
        }
        
        return totalItems;
    }

    @Override
    public Product getItemById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public List<Product> getProductsByCategoryId( int categoryId, int page, int quantity ) {
        
        List<Product> products = new ArrayList<>();
        
        try {
            
            statement = DATABASE.connect().prepareStatement("SELECT * FROM product WHERE category_id = ? ORDER BY product_createdAt DESC LIMIT ?, ?");
            statement.setInt(1, categoryId);
            statement.setInt(2, (page - 1) * quantity);
            statement.setInt(3, quantity);
            result = statement.executeQuery();
            
            while ( result.next() ) {
                products.add(
                        new Product(
                                result.getInt("product_id"),
                                result.getString("product_name"),
                                result.getString("product_description"),
                                result.getString("product_image"),
                                result.getDouble("product_selling_price"),
                                result.getInt("product_stock"),
                                result.getInt("product_stock_min"),
                                result.getBoolean("product_is_active"),
                                result.getDate("product_createdAt"),
                                result.getDate("product_updatedAt"),
                                result.getInt("category_id"),
                                result.getInt("supplier_id")
                        )
                );
            }
            
            statement.close();
            result.close();
            
        } catch (SQLException e) {
            System.out.println("No se pudieron obtener los productos por categoria: " + e.getMessage() );
        } finally {
            statement = null;
            result = null;
            DATABASE.disconnect();
        }
        
        return products;
    }
    
     public List<Product> getProductsBySupplierCompany( String supplierCompany, int page, int quantity ) {
        
        List<Product> products = new ArrayList<>();
        
        try {
            
            statement = DATABASE.connect().prepareStatement(
                    "SELECT P.product_id, P.product_name, P.product_description, P.product_image, P.product_selling_price, P.product_stock, P.product_stock_min, P.product_createdAt, P.product_updatedAt, P.product_is_active, P.category_id, P.supplier_id "
                  + "FROM product AS P "
                  + "INNER JOIN supplier ON supplier.supplier_id = P.supplier_id "
                  + "WHERE supplier_company = ? "
                  + "ORDER BY P.product_createdAt "
                  + "LIMIT ?, ?"
            );
            
            statement.setString(1, supplierCompany);
            statement.setInt(2, (page - 1) * quantity);
            statement.setInt(3, quantity);
            result = statement.executeQuery();
            
            while ( result.next() ) {
                products.add(
                        new Product(
                                result.getInt("product_id"),
                                result.getString("product_name"),
                                result.getString("product_description"),
                                result.getString("product_image"),
                                result.getDouble("product_selling_price"),
                                result.getInt("product_stock"),
                                result.getInt("product_stock_min"),
                                result.getBoolean("product_is_active"),
                                result.getDate("product_createdAt"),
                                result.getDate("product_updatedAt"),
                                result.getInt("category_id"),
                                result.getInt("supplier_id")
                        )
                );
            }
            
            statement.close();
            result.close();
            
        } catch (SQLException e) {
            System.out.println("No se pudieron obtener los productos por categoria: " + e.getMessage() );
        } finally {
            statement = null;
            result = null;
            DATABASE.disconnect();
        }
        
        return products;
    }
     
    public List<Product> getProductsByStatus( String status, int page, int quantity ) {
        
        List<Product> products = new ArrayList<>();
        
        try {
            
            statement = DATABASE.connect().prepareStatement("SELECT * FROM product WHERE product_is_active = ? ORDER BY product_createdAt DESC LIMIT ?, ?");
            statement.setInt(1, status.equals("Activo") ? 1 : 0 );
            statement.setInt(2, (page - 1) * quantity);
            statement.setInt(3, quantity);
            result = statement.executeQuery();
            
            while ( result.next() ) {
                products.add(
                        new Product(
                                result.getInt("product_id"),
                                result.getString("product_name"),
                                result.getString("product_description"),
                                result.getString("product_image"),
                                result.getDouble("product_selling_price"),
                                result.getInt("product_stock"),
                                result.getInt("product_stock_min"),
                                result.getBoolean("product_is_active"),
                                result.getDate("product_createdAt"),
                                result.getDate("product_updatedAt"),
                                result.getInt("category_id"),
                                result.getInt("supplier_id")
                        )
                );
            }
            
            statement.close();
            result.close();
            
        } catch (SQLException e) {
            System.out.println("No se pudieron obtener los productos por categoria: " + e.getMessage() );
        } finally {
            statement = null;
            result = null;
            DATABASE.disconnect();
        }
        
        return products;
        
    }
    
    public List<Product> getProductsByName( String name, int page, int quantity ) {
        
        List<Product> products = new ArrayList<>();
        
        try {
            
            statement = DATABASE.connect().prepareStatement("SELECT * FROM product WHERE product_name LIKE ? ORDER BY product_createdAt DESC LIMIT ?, ?");
            statement.setString(1, "%" + name + "%" );
            statement.setInt(2, (page - 1) * quantity);
            statement.setInt(3, quantity);
            result = statement.executeQuery();
            
            while ( result.next() ) {
                products.add(
                        new Product(
                                result.getInt("product_id"),
                                result.getString("product_name"),
                                result.getString("product_description"),
                                result.getString("product_image"),
                                result.getDouble("product_selling_price"),
                                result.getInt("product_stock"),
                                result.getInt("product_stock_min"),
                                result.getBoolean("product_is_active"),
                                result.getDate("product_createdAt"),
                                result.getDate("product_updatedAt"),
                                result.getInt("category_id"),
                                result.getInt("supplier_id")
                        )
                );
            }
            
            statement.close();
            result.close();
            
        } catch (SQLException e) {
            System.out.println("No se pudieron obtener los productos por categoria: " + e.getMessage() );
        } finally {
            statement = null;
            result = null;
            DATABASE.disconnect();
        }
        
        return products;
        
    }
}
