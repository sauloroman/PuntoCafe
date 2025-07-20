package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import config.Database;
import entities.Supplier;
import java.util.ArrayList;
import java.util.List;
import interfaces.CrudInterface;
import utils.enums.SearchCriteriaEnum;

public class SupplierModel implements CrudInterface<Supplier> {

    private final Database DATABASE;
    private PreparedStatement statement;
    private ResultSet result;
    private boolean response;
    
    public SupplierModel() {
        this.DATABASE = Database.getInstance();
    }
    
    public List<String> getCompaniesSupplier() {
        List<String> companies = new ArrayList<>();
        try {
            
            statement = DATABASE.connect().prepareStatement(
                    "SELECT DISTINCT(supplier_company) "
                  + "FROM supplier" 
            );
            result = statement.executeQuery();
            
            while( result.next() ) {
                companies.add( result.getString(1) );
            }
            
            statement.close();
            result.close();
            
        } catch(SQLException e ){
            System.out.println("No se pudieron obtener las empresas de los proveedores: " + e.getMessage());
        } finally {
            statement = null;
            result = null;
            DATABASE.disconnect();
        }
        
        return companies;
    }
    
    @Override
    public Supplier getItemByName(String supplierName) {

        Supplier supplier = null;
        
        try {
            
            statement = DATABASE.connect().prepareStatement(
                    "SELECT * "
                  + "FROM supplier "
                  + "WHERE supplier_name = ?"
            );
            statement.setString(1, supplierName);
            result = statement.executeQuery();
            
            if ( result.next() ) {
                supplier = new Supplier(
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getString(6),
                        result.getString(7),
                        result.getBoolean(8),
                        result.getDate(9),
                        result.getDate(10)
                );
            }
            
            statement.close();
            result.close();
            
        } catch(SQLException e) {
            System.out.println("Error al obtener el registro: " + e.getMessage());
            return supplier;
        } finally {
           statement = null;
           result = null;
           DATABASE.disconnect(); 
        }
        
        return supplier;
        
    }

    public Supplier getItemByCompany(String companyName) {

        Supplier supplier = null;
        
        try {
            
            statement = DATABASE.connect().prepareStatement(
                    "SELECT * "
                  + "FROM supplier "
                  + "WHERE supplier_company = ?"
            );
            statement.setString(1, companyName);
            result = statement.executeQuery();
            
            if ( result.next() ) {
                supplier = new Supplier(
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getString(6),
                        result.getString(7),
                        result.getBoolean(8),
                        result.getDate(9),
                        result.getDate(10)
                );
            }
            
            statement.close();
            result.close();
            
        } catch(SQLException e) {
            System.out.println("Error al obtener el registro: " + e.getMessage());
            return supplier;
        } finally {
           statement = null;
           result = null;
           DATABASE.disconnect(); 
        }
        
        return supplier;
        
    }
    
    @Override
    public List<Supplier> listItems(String filter) {
            List<Supplier> suppliers = new ArrayList<>();
        
        try {
            
            statement = DATABASE.connect().prepareStatement(
                    "SELECT * "
                  + "FROM supplier "
                  + "WHERE supplier_name LIKE ? AND supplier_is_active = 1 "
                  + "ORDER BY supplier_name ASC " 
            );
            statement.setString(1, "%" + filter + "%");
            result = statement.executeQuery();
            
            while( result.next() ) {
                suppliers.add(
                       new Supplier(
                            result.getInt("supplier_id"),
                            result.getString("supplier_name"),
                            result.getString("supplier_lastname"),
                            result.getString("supplier_company"),
                            result.getString("supplier_phone"),
                            result.getString("supplier_email"),
                            result.getString("supplier_address"),
                            result.getBoolean("supplier_is_active"),
                            result.getDate("supplier_createdAt"),
                            result.getDate("supplier_updatedAt")
                       )
                );
            }
            
            statement.close();
            result.close();
            
        } catch(SQLException e) {
            System.out.println("Error al obtener las categorias: " + e.getMessage());
        } finally {
            statement = null;
            result = null;
            DATABASE.disconnect();
        }
        
        return suppliers;
    }

    @Override
    public List<Supplier> listItemsByPage(
            String filterName, 
            SearchCriteriaEnum criteria, 
            int page, 
            int itemsPerPage
    ) {
        List<Supplier> suppliers = new ArrayList<>();
        
        try {
            
            if ( criteria == SearchCriteriaEnum.NAME ) {
                statement = DATABASE.connect().prepareStatement(
                    "SELECT * "
                  + "FROM supplier "
                  + "WHERE supplier_name LIKE ? "          
                  + "ORDER BY supplier_createdAt DESC "
                  + "LIMIT ?, ?"
                );
                statement.setString(1, "%" + filterName + "%");
                statement.setInt(2, (page - 1) * itemsPerPage);
                statement.setInt(3, itemsPerPage);
            }
            
            if ( criteria == SearchCriteriaEnum.SUPPLIER_COMPANY_NAME ) {
                statement = DATABASE.connect().prepareStatement(
                    "SELECT * "
                  + "FROM supplier "
                  + "WHERE supplier_company = ? "  
                  + "ORDER BY supplier_createdAt DESC "
                  + "LIMIT ?, ?"
                );
                statement.setString(1, filterName);
                statement.setInt(2, (page - 1) * itemsPerPage);
                statement.setInt(3, itemsPerPage);
            }
            
            if ( criteria == SearchCriteriaEnum.STATUS ) {
                statement = DATABASE.connect().prepareStatement(
                    "SELECT * "
                  + "FROM supplier "
                  + "WHERE supplier_is_active = ? " 
                  + "ORDER BY supplier_createdAt DESC "
                  + "LIMIT ?, ?"
                );
                statement.setInt(1, filterName.equals("Activo") ? 1 : 0);
                statement.setInt(2, (page - 1) * itemsPerPage);
                statement.setInt(3, itemsPerPage);
            }
            
            result = statement.executeQuery();
            
            while ( result.next() ) {
                suppliers.add(
                        new Supplier(
                                result.getInt("supplier_id"),
                                result.getString("supplier_name"),
                                result.getString("supplier_lastname"),
                                result.getString("supplier_company"),
                                result.getString("supplier_phone"),
                                result.getString("supplier_email"),
                                result.getString("supplier_address"),
                                result.getBoolean("supplier_is_active"),
                                result.getDate("supplier_createdAt"),
                                result.getDate("supplier_updatedAt")
                        )
                );
            }
            
        } catch(SQLException e) {
            System.out.println("No se pudieron obtener los proveedores: " + e.getMessage());
        } finally {
            statement = null;
            result = null;
            DATABASE.disconnect();
        }
        
        return suppliers;
        
    }

    @Override
    public boolean saveItem(Supplier obj) {
        
        response = false;
        
        try {
            
            String supplierName = obj.getSupplierName();
            String supplierLastname = obj.getSupplierLastname();
            String supplierCompany = obj.getSupplierCompany();
            String supplierPhone = obj.getSupplierPhone();
            String supplierEmail = obj.getSupplierEmail();
            String supplierAddress = obj.getSupplierAddress();
            
            boolean hasEmail = supplierEmail != null && !supplierEmail.isEmpty();
            boolean hasAddress = supplierAddress != null && !supplierAddress.isEmpty();
            
            if ( hasEmail && hasAddress ) {
                statement = DATABASE.connect().prepareStatement(
                        "INSERT INTO supplier (supplier_name, supplier_lastname, supplier_company, supplier_phone, supplier_email, supplier_address ) "
                      + "VALUES (?, ?, ?, ?, ?, ?)"  
                );
                
                statement.setString(1, supplierName);
                statement.setString(2, supplierLastname);
                statement.setString(3, supplierCompany);
                statement.setString(4, supplierPhone);
                statement.setString(5, supplierEmail);
                statement.setString(6, supplierAddress);
            } else if ( !hasEmail && hasAddress ) {
                statement = DATABASE.connect().prepareStatement(
                        "INSERT INTO supplier (supplier_name, supplier_lastname, supplier_company, supplier_phone, supplier_address) "
                      + "VALUES (?, ?, ?, ?, ?)"  
                );
                
                statement.setString(1, supplierName);
                statement.setString(2, supplierLastname);
                statement.setString(3, supplierCompany);
                statement.setString(4, supplierPhone);
                statement.setString(5, supplierAddress);
            } else if ( hasEmail && !hasAddress ) { 
                statement = DATABASE.connect().prepareStatement(
                        "INSERT INTO supplier (supplier_name, supplier_lastname, supplier_company, supplier_phone, supplier_email) "
                      + "VALUES (?, ?, ?, ?, ?)"  
                );
                
                statement.setString(1, supplierName);
                statement.setString(2, supplierLastname);
                statement.setString(3, supplierCompany);
                statement.setString(4, supplierPhone);
                statement.setString(5, supplierEmail);   
            } else {
                 statement = DATABASE.connect().prepareStatement(
                        "INSERT INTO supplier (supplier_name, supplier_lastname, supplier_company, supplier_phone) "
                      + "VALUES (?, ?, ?, ?)"  
                );
                
                statement.setString(1, supplierName);
                statement.setString(2, supplierLastname);
                statement.setString(3, supplierCompany);
                statement.setString(4, supplierPhone);
            }
            
            if ( statement.executeUpdate() > 0 ) {
                response = true;
            }
            
            return response;
            
        } catch(SQLException e) {
            System.out.println("No se pudo crear el proveedor " + e.getMessage());
        } finally {
            statement = null;
            DATABASE.disconnect();
        }
        
        return response;
    }

    @Override
    public boolean changeStatus(int id, boolean status) {
        
        response = false;
        
        try {
            
            statement = DATABASE.connect().prepareStatement(
                    "UPDATE supplier "
                  + "SET supplier_is_active = ? "
                  + "WHERE supplier_id = ?"
            );
            statement.setBoolean(1, status);
            statement.setInt(2, id);
            
            if ( statement.executeUpdate() > 0 ) {
                response = true;
            }
            
            statement.close();
            
        } catch( SQLException e ) {
            System.out.println("No se pudo actualizar el estado del proveedor: " + e.getMessage());
            response = false;
        } finally {
            statement = null;
            DATABASE.disconnect();
        }
        
        return response;
    }

    @Override
    public boolean updateItem(Supplier obj, int id) {
        response = false;
        
        try {
            
            statement = DATABASE.connect().prepareStatement(
                    "UPDATE supplier "
                  + "SET supplier_name = ?, supplier_lastname = ?, supplier_company = ?, supplier_phone = ?, supplier_email = ?, supplier_address = ? "
                  + "WHERE supplier_id = ?"  
            );
            statement.setString(1, obj.getSupplierName());
            statement.setString(2, obj.getSupplierLastname());
            statement.setString(3, obj.getSupplierCompany());
            statement.setString(4, obj.getSupplierPhone());
            statement.setString(5, obj.getSupplierEmail());
            statement.setString(6, obj.getSupplierAddress());
            statement.setInt(7, id);
            
            if ( statement.executeUpdate() > 0 ) {
                response = true;
            }
            
            statement.close();
            
        } catch(SQLException e) {
            System.out.println("No se pudo actualizar el proveedor: " + e.getMessage() );
            response = false;
        } finally {
            statement = null;
            DATABASE.disconnect();
        }
        
        return response;
    }

    @Override
    public int getTotalItems() {
    
        int totalItems = 0;
        
        try {
            
            statement = DATABASE.connect().prepareStatement("SELECT COUNT(*) FROM supplier");
            result = statement.executeQuery();
            
            while( result.next() ) {
                totalItems = result.getInt("COUNT(*)");
            }
            
            statement.close();
            result.close();
            
        } catch(SQLException e) {
            System.out.println("No se pudo obtener el total de proveedores");
        } finally {
            statement = null;
            result = null;
            DATABASE.disconnect();
        }
        
        return totalItems;
    
    }

    @Override
    public Supplier getItemById(int id) {
        Supplier supplier = null;
        
        try {
            
            statement = DATABASE.connect().prepareStatement(
                    "SELECT * "
                  + "FROM supplier "
                  + "WHERE supplier_id = ?"
            );
            statement.setInt(1, id);
            result = statement.executeQuery();
            
            if ( result.next() ) {
                supplier = new Supplier(
                        result.getInt("supplier_id"),
                        result.getString("supplier_name"),
                        result.getString("supplier_lastname"),
                        result.getString("supplier_company"),
                        result.getString("supplier_phone"),
                        result.getString("supplier_email"),
                        result.getString("supplier_address"),
                        result.getBoolean("supplier_is_active"),
                        result.getDate("supplier_createdAt"),
                        result.getDate("supplier_updatedAt")
                );
            }
            
            statement.close();
            result.close();
        
        } catch(SQLException e) {
            System.out.println("No se pudo obtener la categoria por id: " + e.getMessage() );
        } finally {
            statement = null;
            result = null;
            DATABASE.disconnect();
        }
        
        return supplier;
    }
    
}
