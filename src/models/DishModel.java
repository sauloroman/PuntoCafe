package models;

import config.Database;
import entities.Dish;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.interfaces.CrudInterface;
import utils.enums.SearchCriteriaEnum;

public class DishModel implements CrudInterface<Dish> {
    
    private final Database DATABASE;
    private PreparedStatement statement;
    private ResultSet result;
    private boolean response;
    
    public DishModel() {
        this.DATABASE = Database.getInstance();
    }

    @Override
    public Dish getItemByName(String name) {
        
        Dish dish = null;
        
        try {
            
            statement = DATABASE.connect().prepareStatement(
                    "SELECT * "
                  + "FROM dish "
                  + "WHERE dish_name LIKE ? "
            );
            statement.setString(1, name);
            result = statement.executeQuery();
            
            if ( result.next() ) {
                dish = new Dish(
                        result.getInt("dish_id"),
                        result.getString("dish_name"),
                        result.getString("dish_description"),
                        result.getString("dish_image"),
                        result.getDouble("dish_selling_price"),
                        result.getBoolean("dish_is_active"),
                        result.getDate("dish_createdAt"),
                        result.getDate("dish_updatedAt"),
                        result.getInt("category_id")
                );
            }
            
            statement.close();
            result.close();
            
        } catch(SQLException e) {
            System.out.println("No se pudo obtener el platillo: " + e.getMessage() );
        } finally {
            DATABASE.disconnect();
            statement = null;
            result = null;
        }
        
        return dish;
    }

    @Override
    public Dish getItemById(int id) {
        Dish dish = null;
        
        try {
            
            statement = DATABASE.connect().prepareStatement("SELECT * FROM dish WHERE dish_id = ?");
            statement.setInt(1, id);
            result = statement.executeQuery();
            
            if( result.next() ) {
                new Dish(
                    result.getInt("dish_id"),
                    result.getString("dish_name"),
                    result.getString("dish_description"),
                    result.getString("dish_image"),
                    result.getDouble("dish_selling_price"),
                    result.getBoolean("dish_is_active"),
                    result.getDate("dish_createdAt"),
                    result.getDate("dish_updatedAt"),
                    result.getInt("category_id")
                );
                
            }
            
            statement.close();
            result.close();
                    
        } catch(SQLException e) {
            System.out.println("No se pudieron obtener el platillo por id: " + e.getMessage());
        } finally {
            DATABASE.disconnect();
            statement = null;
            result = null;
        }
        
        return dish;

    }

    @Override
    public List listItems(String filter) {
       List<Dish> dishes = new ArrayList<>();
        
        try {
            
            statement = DATABASE.connect().prepareStatement("SELECT * FROM dish ORDER BY dish_createdAt DESC");
            result = statement.executeQuery();
            
            while( result.next() ) {
                dishes.add(
                        new Dish(
                                result.getInt("dish_id"),
                                result.getString("dish_name"),
                                result.getString("dish_description"),
                                result.getString("dish_image"),
                                result.getDouble("dish_selling_price"),
                                result.getBoolean("dish_is_active"),
                                result.getDate("dish_createdAt"),
                                result.getDate("dish_updatedAt"),
                                result.getInt("category_id")
                        )
                );
            }
            
            statement.close();
            result.close();
                    
        } catch(SQLException e) {
            System.out.println("No se pudieron obtener todos los platillos: " + e.getMessage());
        } finally {
            DATABASE.disconnect();
            statement = null;
            result = null;
        }
        
        return dishes; 

    }

    @Override
    public List<Dish> listItemsByPage(String filter, SearchCriteriaEnum criteria, int page, int itemsPerPage) {
        List<Dish> dishes = new ArrayList<>();
        
        try {
            
            statement = DATABASE.connect().prepareStatement("SELECT * FROM dish ORDER BY dish_createdAt DESC LIMIT ?, ?");
            statement.setInt(1, (page - 1) * itemsPerPage);
            statement.setInt(2, itemsPerPage);
            result = statement.executeQuery();
            
            while( result.next() ) {
                dishes.add(
                        new Dish(
                                result.getInt("dish_id"),
                                result.getString("dish_name"),
                                result.getString("dish_description"),
                                result.getString("dish_image"),
                                result.getDouble("dish_selling_price"),
                                result.getBoolean("dish_is_active"),
                                result.getDate("dish_createdAt"),
                                result.getDate("dish_updatedAt"),
                                result.getInt("category_id")
                        )
                );
            }
            
            statement.close();
            result.close();
                    
        } catch(SQLException e) {
            System.out.println("No se pudieron obtener los platillos: " + e.getMessage());
        } finally {
            DATABASE.disconnect();
            statement = null;
            result = null;
        }
        
        return dishes;
    }

    @Override
    public boolean saveItem(Dish obj) {
        response = false;
        
        try {
            
            String dishName = obj.getDishName();
            String dishDescription = obj.getDishDescription();
            Double dishSellingPrice = obj.getDishSellingPrice();
            String dishImage = obj.getDishImage();
            int dishCategory = obj.getCategoryId();
            
            boolean hashDescription = dishDescription != null && !dishDescription.isEmpty();
            boolean hashImage = dishImage != null && !dishImage.isEmpty();

            if ( hashDescription && hashImage ) {
                statement = DATABASE.connect().prepareStatement(
                    "INSERT INTO dish(dish_name, dish_description, dish_image, dish_selling_price, category_id ) "
                  + "VALUES (?, ?, ?, ?, ?)"      
                );
                statement.setString(1, dishName);
                statement.setString(2, dishDescription);
                statement.setString(3, dishImage);
                statement.setDouble(4, dishSellingPrice);
                statement.setInt(5, dishCategory);
            } else if ( hashDescription && !hashImage ) {
                statement = DATABASE.connect().prepareStatement(
                    "INSERT INTO dish(dish_name, dish_description, dish_selling_price, category_id ) "
                  + "VALUES (?, ?, ?, ?)"      
                );
                statement.setString(1, dishName);
                statement.setString(2, dishDescription);
                statement.setDouble(3, dishSellingPrice);
                statement.setInt(4, dishCategory);
            } else if ( !hashDescription && hashImage ) {
                statement = DATABASE.connect().prepareStatement(
                    "INSERT INTO dish(dish_name, dish_image, dish_selling_price, category_id ) "
                  + "VALUES (?, ?, ?, ?)"      
                );
                statement.setString(1, dishName);
                statement.setString(2, dishImage);
                statement.setDouble(3, dishSellingPrice);
                statement.setInt(4, dishCategory);
            } else {
                statement = DATABASE.connect().prepareStatement(
                    "INSERT INTO dish(dish_name, dish_selling_price, category_id ) "
                  + "VALUES (?, ?, ?)"      
                );
                statement.setString(1, dishName);
                statement.setDouble(2, dishSellingPrice);
                statement.setInt(3, dishCategory);
            }
            
            if ( statement.executeUpdate() > 0 ) {
                response = true;
            }
            
            statement.close();
            
        } catch(SQLException e) {
            System.out.println("El platillo no pudo ser creado: " + e.getMessage() );
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
                    "UPDATE dish "
                  + "SET dish_is_active = ? "
                  + "WHERE dish_id = ?"  
            );
            statement.setBoolean(1, status);
            statement.setInt(2, id);
            
            if ( statement.executeUpdate() > 0 ) {
                response = true;
            }
            
            statement.close();
            
        } catch(SQLException e) {
           System.out.println("El platillo no pudo cambiar de estado: " + e.getMessage());
        } finally {
           DATABASE.disconnect();
           statement = null;
        }
        
        return response;
    }

    @Override
    public boolean updateItem(Dish obj, int id) {
        response = false;
        
        try {
            
            String newDishName = obj.getDishName();
            String newDishDescription = obj.getDishDescription();
            Double newDishSellingPrice = obj.getDishSellingPrice();
            String newDishImage = obj.getDishImage();
            int newCategoryId = obj.getCategoryId();
            
            statement = DATABASE.connect().prepareStatement(
                    "UPDATE dish "
                  + "SET dish_name = ?, dish_description = ?, dish_image = ?, dish_selling_price = ?, category_id = ? "
                  + "WHERE dish_id = ? "  
            );
            statement.setString(1, newDishName);
            statement.setString(2, newDishDescription);
            statement.setString(3, newDishImage);
            statement.setDouble(4, newDishSellingPrice);
            statement.setInt(5, newCategoryId);
            statement.setInt(6, id);
            
            if ( statement.executeUpdate() > 0 ) {
                response = true;
            }
            
            statement.close();
            
        } catch(SQLException e) {
            System.out.println("No se pudo actualizar el platillo: " + e.getMessage());
        } finally {
            DATABASE.disconnect();
            statement = null;
        }
        
        return response;
    }
    
    public List<Dish> getDishesByCategoryId( int categoryId, int page, int quantity ) {
        List<Dish> dishes = new ArrayList<>();
        
        try {
            
            statement = DATABASE.connect().prepareStatement("SELECT * FROM dish WHERE category_id = ? ORDER BY dish_createdAt DESC LIMIT ?, ?");
            statement.setInt(1, categoryId);
            statement.setInt(2, (page - 1) * quantity);
            statement.setInt(3, quantity);
            result = statement.executeQuery();
            
            while ( result.next() ) {
                dishes.add(
                      new Dish(
                            result.getInt("dish_id"),
                            result.getString("dish_name"),
                            result.getString("dish_description"),
                            result.getString("dish_image"),
                            result.getDouble("dish_selling_price"),
                            result.getBoolean("dish_is_active"),
                            result.getDate("dish_createdAt"),
                            result.getDate("dish_updatedAt"),
                            result.getInt("category_id")
                      )  
                );
            }
            
            statement.close();
            result.close();
            
        } catch (SQLException e) {
            System.out.println("No se pudieron obtener los platillos por categoria: " + e.getMessage() );
        } finally {
            statement = null;
            result = null;
            DATABASE.disconnect();
        }
        
        return dishes;
    }
    
    public List<Dish> getDishesByStatus( int status, int page, int quantity ) {
        List<Dish> dishes = new ArrayList<>();
        
        try {
            
            statement = DATABASE.connect().prepareStatement("SELECT * FROM dish WHERE dish_is_active = ? ORDER BY dish_createdAt DESC LIMIT ?, ?");
            statement.setInt(1, status);
            statement.setInt(2, (page - 1) * quantity);
            statement.setInt(3, quantity);
            result = statement.executeQuery();
            
            while ( result.next() ) {
                dishes.add(
                      new Dish(
                            result.getInt("dish_id"),
                            result.getString("dish_name"),
                            result.getString("dish_description"),
                            result.getString("dish_image"),
                            result.getDouble("dish_selling_price"),
                            result.getBoolean("dish_is_active"),
                            result.getDate("dish_createdAt"),
                            result.getDate("dish_updatedAt"),
                            result.getInt("category_id")
                      )  
                );
            }
            
            statement.close();
            result.close();
            
        } catch (SQLException e) {
            System.out.println("No se pudieron obtener los platillos por estado: " + e.getMessage() );
        } finally {
            statement = null;
            result = null;
            DATABASE.disconnect();
        }
        
        return dishes;
    }
    
    public List<Dish> getDishesByName( String dishName, int page, int quantity ) {
        List<Dish> dishes = new ArrayList<>();
        
        try {
            
            statement = DATABASE.connect().prepareStatement("SELECT * FROM dish WHERE dish_name LIKE ? ORDER BY dish_createdAt DESC LIMIT ?, ?");
            statement.setString(1, "%" + dishName + "%");
            statement.setInt(2, (page - 1) * quantity);
            statement.setInt(3, quantity);
            result = statement.executeQuery();
            
            while ( result.next() ) {
                dishes.add(
                      new Dish(
                            result.getInt("dish_id"),
                            result.getString("dish_name"),
                            result.getString("dish_description"),
                            result.getString("dish_image"),
                            result.getDouble("dish_selling_price"),
                            result.getBoolean("dish_is_active"),
                            result.getDate("dish_createdAt"),
                            result.getDate("dish_updatedAt"),
                            result.getInt("category_id")
                      )  
                );
            }
            
            statement.close();
            result.close();
            
        } catch (SQLException e) {
            System.out.println("No se pudieron obtener los platillos por nombre: " + e.getMessage() );
        } finally {
            statement = null;
            result = null;
            DATABASE.disconnect();
        }
        
        return dishes;
    }

    @Override
    public int getTotalItems() {
        
         int totalItems = 0;
        
        try {
            
            statement = DATABASE.connect().prepareStatement("SELECT COUNT(*) FROM dish");
            result = statement.executeQuery();
            
            while( result.next() ) { 
                totalItems = result.getInt("COUNT(*)");
            }
            
            statement.close();
            result.close();
            
        } catch(SQLException e) {
            System.out.println("No se pudo obtener el total de platillos: " + e.getMessage());
        } finally {
            statement = null;
            result = null;
            DATABASE.disconnect();
        }
        
        return totalItems;
        
    }
    
    public int getTotalDishesByCategoryId(int categoryId) {
        
        int totalItems = 0;
        
        try {
            
            statement = DATABASE.connect().prepareStatement("SELECT COUNT(*) FROM dish WHERE category_id = ?");
            statement.setInt(1, categoryId);
            
            result = statement.executeQuery();
            
            while( result.next() ) {
                totalItems = result.getInt("COUNT(*)");
            }
            
            statement.close();
            result.close();
            
        } catch(SQLException e) {
            System.out.println("No se pudo obtener el total de platillos por categoría");
        } finally {
            statement = null;
            result = null;
            DATABASE.disconnect();
        }
        
        return totalItems;
        
    }
    
    public int getTotalDishesByStatus(String status) {
        int totalItems = 0;
        
        try {
            
            statement = DATABASE.connect().prepareStatement(
                  "SELECT COUNT(*) "
                + "FROM dish "
                + "WHERE dish_is_active = ? "
            );
            statement.setInt(1, status.equals("Activo") ? 1 : 0);
            result = statement.executeQuery();
            
            while( result.next() ) {
                totalItems = result.getInt("COUNT(*)");
            }
            
            statement.close();
            result.close();
            
        } catch(SQLException e) {
            System.out.println("No se pudo obtener el total de platillos por estado " + e.getMessage());
        } finally {
            statement = null;
            result = null;
            DATABASE.disconnect();
        }
        
        return totalItems;
    }
    
    public int getTotalDishesByName(String name) {
        int totalItems = 0;
        
        try {
            
            statement = DATABASE.connect().prepareStatement(
                  "SELECT COUNT(*) "
                + "FROM dish "
                + "WHERE dish_name LIKE ? "
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
    
}
