package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import config.Database;
import entities.Category;
import java.util.ArrayList;
import java.util.List;
import interfaces.CrudInterface;
import utils.enums.SearchCriteriaEnum;

public class CategoryModel implements CrudInterface<Category> {

    private final Database DATABASE;
    private PreparedStatement statement;
    private ResultSet result;
    private boolean response;
    
    public CategoryModel() {
        this.DATABASE = Database.getInstance();
    }
    
    @Override
    public List<Category> listItems(String filter ) {
        
        List<Category> categories = new ArrayList<>();
        
        try {
            
            statement = DATABASE.connect().prepareStatement(
                    "SELECT * "
                  + "FROM category "
                  + "WHERE category_is_active = 1 AND category_type = ? "
                  + "ORDER BY category_name ASC "
            );
            statement.setString(1, filter);
            result = statement.executeQuery();
            
            while( result.next() ) {
                categories.add(
                       new Category(
                            result.getInt(1),
                            result.getString(2),
                            result.getString(3),
                            result.getString(4),
                            result.getBoolean(5),
                            result.getDate(6),
                            result.getDate(7)
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
        
        return categories;
    }
    
    @Override
    public List<Category> listItemsByPage(String filter, SearchCriteriaEnum criteria, int page, int itemsPerPage) {
        List<Category> categories = new ArrayList<>();
        
        try {
            
            if ( criteria.equals( SearchCriteriaEnum.NAME ) ) {
                statement = DATABASE.connect().prepareStatement(
                    "SELECT * "
                  + "FROM category "
                  + "WHERE category_name LIKE ?"
                  + "ORDER BY category_createdAt DESC "
                  + "LIMIT ?, ?"
                );
                statement.setString(1, "%" + filter + "%");
                statement.setInt(2, (page - 1) * itemsPerPage);
                statement.setInt(3, itemsPerPage);
            }
            
            result = statement.executeQuery();
            
            while( result.next() ) {
                categories.add(
                       new Category(
                            result.getInt(1),
                            result.getString(2),
                            result.getString(3),
                            result.getString(4),
                            result.getBoolean(5),
                            result.getDate(6),
                            result.getDate(7)
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
        
        return categories;
    }

    @Override
    public boolean saveItem(Category obj) {
        response = false;
        
        try {
            
            String categoryName = obj.getCategoryName();
            String categoryDescription = obj.getCategoryDescription();
            String categoryType = obj.getCategoryType();
            
            boolean hashDescription  = categoryDescription != null && !categoryDescription.isEmpty();
            
            if ( hashDescription ) {
                statement = DATABASE.connect().prepareStatement(
                    "INSERT INTO category (category_name, category_type) "
                  + "VALUES (?, ?)"     
                );

                statement.setString(1, categoryName);
                statement.setString(2, categoryType);
            }  else {
                statement = DATABASE.connect().prepareStatement(
                    "INSERT INTO category (category_name, category_description, category_type) "
                  + "VALUES (?, ?, ?)"     
                );

                statement.setString(1, categoryName);
                statement.setString(2, categoryDescription);
                statement.setString(3, categoryType);
            }
            
            if ( statement.executeUpdate() > 0 ) {
                response = true;
            }
            
            statement.close();
            
        } catch(SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
            response = false;
        } finally {
            statement = null;
            DATABASE.disconnect();
        }
        
        return response;
    }

    @Override
    public Category getItemByName(String name) {
        Category category = null;
        
        try {
            
            statement = DATABASE.connect().prepareStatement(
                "SELECT * "
              + "FROM category "
              + "WHERE category_name = ?"
            );
            statement.setString(1, name);
            result = statement.executeQuery();
            
            if ( result.next() ) {
                category = new Category(
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getBoolean(5),
                        result.getDate(6),
                        result.getDate(7)
                );
            }
            
            statement.close();
            result.close();
            
        } catch(SQLException e) {
            System.out.println("Error al obtener el registro: " + e.getMessage());
            return category;
        } finally {
            statement = null;
            result = null;
            DATABASE.disconnect();
        }
        
        return category;
    }

    @Override
    public boolean changeStatus(int id, boolean status ) {
        
        response = false;
        
        try {
            
            statement = DATABASE.connect().prepareStatement(
                "UPDATE category "
              + "SET category_is_active = ? "
              + "WHERE category_id = ? "      
            );

            statement.setBoolean(1, status);
            statement.setInt(2, id);
            
            if ( statement.executeUpdate() > 0 ) {
                response = true;
            }
            
            statement.close();
            
        } catch(SQLException e) {
            System.out.println("No se pudo desactivar la categoría: " + e.getMessage());
        } finally {
            statement = null;
            DATABASE.disconnect();
        }
        
        return response;
    }

    @Override
    public boolean updateItem(Category obj, int id) {
        
        response = false;
        
        try {
            
            String categoryName = obj.getCategoryName();
            String categoryDescription = obj.getCategoryDescription();
            String categoryType = obj.getCategoryType();
            
            statement = DATABASE.connect().prepareStatement(
                    "UPDATE category "
                  + "SET category_name = ?, category_description = ?, category_type = ? "
                  + "WHERE category_id = ?"  
            );
            
            statement.setString(1, categoryName);
            statement.setString(2, categoryDescription.isEmpty() ? "Categoría sin descripción" : categoryDescription);
            statement.setString(3, categoryType);
            statement.setInt(4, id);
            
            if ( statement.executeUpdate() > 0 ) {
                response = true;
            }
            
            statement.close();
            
        } catch(SQLException e) {
            System.out.println("No se pudo actualizar la categoría: " + e.getMessage());
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
            
            statement = DATABASE.connect().prepareStatement("SELECT COUNT(*) FROM category");
            result = statement.executeQuery();
            
            while( result.next() ) {
                totalItems = result.getInt("COUNT(*)");
            }
            
            statement.close();
            result.close();
            
        } catch(SQLException e) {
            System.out.println("No se pudo obtener el total de categorias");
        } finally {
            statement = null;
            result = null;
            DATABASE.disconnect();
        }
        
        return totalItems;
    }
    
    public int getTotalItemsByFilter( String filter, SearchCriteriaEnum criteria ) {
        
        int totalItems = 0;
        
        try {
            
            if ( criteria.equals(SearchCriteriaEnum.STATUS )) {
                statement = DATABASE.connect().prepareStatement("SELECT COUNT(*) FROM category WHERE category_is_active = ?");
                statement.setInt(1, filter.equals("Activo") ? 1 : 0);
            }
            
            result = statement.executeQuery();
            
            while( result.next() ) { 
                totalItems = result.getInt("COUNT(*)");
            }
            
            statement.close();
            result.close();
            
        } catch(SQLException e) {
            System.out.println("No se pudo obtener el total de categorias por filtro: " + e.getMessage());
        } finally {
            statement = null;
            result = null;
            DATABASE.disconnect();
        }
        
        return totalItems;
        
    }

    @Override
    public Category getItemById(int id) {
        
        Category category = null;
        
        try {
            
            statement = DATABASE.connect().prepareStatement(
                    "SELECT * "
                  + "FROM category "
                  + "WHERE category_id = ?"
            );
            statement.setInt(1, id);
            result = statement.executeQuery();
            
            if ( result.next() ) {
                category = new Category(
                        result.getInt("category_id"),
                        result.getString("category_name"),
                        result.getString("category_description"),
                        result.getString("category_type"),
                        result.getBoolean("category_is_active"),
                        result.getDate("category_createdAt"),
                        result.getDate("category_updatedAt")
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
        
        return category;
    }
    
}
