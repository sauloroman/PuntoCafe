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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List listItems(String filter) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean updateItem(Dish obj, int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
    
    
    
}
