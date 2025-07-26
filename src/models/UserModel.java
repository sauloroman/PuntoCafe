package models;

import config.Database;
import entities.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import interfaces.CrudInterface;
import utils.enums.SearchCriteriaEnum;

public class UserModel implements CrudInterface<User> {
    
    private final Database DATABASE;
    private PreparedStatement statement;
    private ResultSet result;
    private boolean response;
    
    public UserModel() {
        this.DATABASE = Database.getInstance();
    }
    
    public User getUserByEmail( String email ) {
        User user = null;
        
        try {
            
            statement = DATABASE.connect().prepareStatement("SELECT * FROM user WHERE user_email = ?");
            statement.setString(1, email);
            result = statement.executeQuery();
            
            if ( result.next() ) {
                user = new User(
                        result.getInt("user_id"),
                        result.getString("user_name"),
                        result.getString("user_lastname"),
                        result.getString("user_image"),
                        result.getString("user_email"),
                        result.getString("user_password"),
                        result.getBoolean("user_is_active"),
                        result.getDate("user_createdAt"),
                        result.getDate("user_updatedAt"),
                        result.getInt("role_id")
                );
            }
            
            statement.close();
            result.close();
            
        } catch(SQLException e) {
            System.out.println("No se pudo obtener el usuario por email: " + e.getMessage());
        } finally {
            statement = null;
            result = null;
            DATABASE.disconnect();
        }
     
        return user;
        
    }

    @Override
    public User getItemByName(String name) {
        
        User user = null;
        
        try {
            
            statement = DATABASE.connect().prepareStatement(
                    "SELECT * "
                  + "FROM user "
                  + "WHERE user_name LIKE ?"
            );
            statement.setString(1, "%" + name + "%");
            result = statement.executeQuery();
            
            if ( result.next() ) {
                user = new User(
                        result.getInt("user_id"),
                        result.getString("user_name"),
                        result.getString("user_lastname"),
                        result.getString("user_image"),
                        result.getString("user_email"),
                        result.getString("user_password"),
                        result.getBoolean("user_is_active"),
                        result.getDate("user_createdAt"),
                        result.getDate("user_updatedAt"),
                        result.getInt("role_id")
                );
            }
            
            statement.close();
            result.close();
        
        } catch(SQLException e) {
            System.out.println("No se pudo obtener el usuario por nombre: " + e.getMessage() );
        } finally {
            statement = null;
            result = null;
            DATABASE.disconnect();
        }
        
        return user;
        
    }
    
    public User getUserByNameAndLastname(String fullName) {
        
        User user = null;
        
        try {
            
            statement = DATABASE.connect().prepareStatement(
                    "SELECT * "
                  + "FROM user "
                  + "WHERE CONCAT(user_name, ' ', user_lastname) LIKE ?"
            );
            statement.setString(1, "%" + fullName + "%");
            result = statement.executeQuery();
            
            if ( result.next() ) {
                user = new User(
                        result.getInt("user_id"),
                        result.getString("user_name"),
                        result.getString("user_lastname"),
                        result.getString("user_image"),
                        result.getString("user_email"),
                        result.getString("user_password"),
                        result.getBoolean("user_is_active"),
                        result.getDate("user_createdAt"),
                        result.getDate("user_updatedAt"),
                        result.getInt("role_id")
                );
            }
            
            statement.close();
            result.close();
        
        } catch(SQLException e) {
            System.out.println("No se pudo obtener el usuario por nombre y apellido: " + e.getMessage() );
        } finally {
            statement = null;
            result = null;
            DATABASE.disconnect();
        }
        
        return user;
        
    }

    @Override
    public User getItemById(int id) {
        User user = null;
        
        try {
            
            statement = DATABASE.connect().prepareStatement(
                    "SELECT * "
                  + "FROM user "
                  + "WHERE user_id = ?"
            );
            statement.setInt(1, id);
            result = statement.executeQuery();
            
            if ( result.next() ) {
                user = new User(
                        result.getInt("user_id"),
                        result.getString("user_name"),
                        result.getString("user_lastname"),
                        result.getString("user_image"),
                        result.getString("user_email"),
                        result.getString("user_password"),
                        result.getBoolean("user_is_active"),
                        result.getDate("user_createdAt"),
                        result.getDate("user_updatedAt"),
                        result.getInt("role_id")
                );
            }
            
            statement.close();
            result.close();
        
        } catch(SQLException e) {
            System.out.println("No se pudo obtener el usuario por id: " + e.getMessage() );
        } finally {
            statement = null;
            result = null;
            DATABASE.disconnect();
        }
        
        return user;
    }

    @Override
    public List<User> listItems(String filter) {
        List<User> users = new ArrayList<>();
        
        try {
            
            statement = DATABASE.connect().prepareStatement("SELECT * FROM user");
            result = statement.executeQuery();
            
            while ( result.next() ) {
                users.add(
                     new User(
                            result.getInt("user_id"),
                            result.getString("user_name"),
                            result.getString("user_lastname"),
                            result.getString("user_image"),
                            result.getString("user_email"),
                            result.getString("user_password"),
                            result.getBoolean("user_is_active"),
                            result.getDate("user_createdAt"),
                            result.getDate("user_updatedAt"),
                            result.getInt("role_id")
                     )   
                );
            }
            
            statement.close();
            result.close();
            
        } catch(SQLException e) {
            System.out.println("No se pudo obtener los usuarios: " + e.getMessage());
        } finally {
            statement = null;
            result = null;
            DATABASE.disconnect();
        }
        
        return users;
    }

    @Override
    public List<User> listItemsByPage(String filter, SearchCriteriaEnum criteria, int page, int itemsPerPage) {
        List<User> users = new ArrayList<>();
        
        try {            
            if ( criteria.equals(SearchCriteriaEnum.NAME) ) {
                statement = DATABASE.connect().prepareStatement(
                    "SELECT * "
                  + "FROM user "
                  + "WHERE user_name LIKE ? "
                  + "ORDER BY user_createdAt DESC "
                  + "LIMIT ?, ?"
                );
                statement.setString(1, "%" + filter + "%");
                statement.setInt(2, (page - 1) * itemsPerPage);
                statement.setInt(3, itemsPerPage);
                result = statement.executeQuery();
            }
            
            if ( criteria.equals(SearchCriteriaEnum.USER_ROLE) ) {
                statement = DATABASE.connect().prepareStatement(
                    "SELECT * "
                  + "FROM user "
                  + "WHERE role_id = ? "
                  + "ORDER BY user_createdAt DESC "
                  + "LIMIT ?, ?"
                );
                statement.setInt(1, Integer.parseInt(filter) );
                statement.setInt(2, (page - 1) * itemsPerPage);
                statement.setInt(3, itemsPerPage);
                result = statement.executeQuery();
            }
                  
            while( result.next() ) {
                users.add(
                    new User(
                            result.getInt("user_id"),
                            result.getString("user_name"),
                            result.getString("user_lastname"),
                            result.getString("user_image"),
                            result.getString("user_email"),
                            result.getString("user_password"),
                            result.getBoolean("user_is_active"),
                            result.getDate("user_createdAt"),
                            result.getDate("user_updatedAt"),
                            result.getInt("role_id") 
                    )
                );
            }
            
            statement.close();
            result.close();
            
        } catch(SQLException e) {
            System.out.println("Error al obtener los usuarios por filtro: " + e.getMessage());
        } finally {
            statement = null;
            result = null;
            DATABASE.disconnect();
        }
        
        return users;
    }

    @Override
    public boolean saveItem(User obj) {
        response = false;

        try {
            
            String userName = obj.getUserName();
            String userLastname = obj.getUserLastname();
            String userImage = obj.getUserImage();
            String userEmail = obj.getUserEmail();
            String userPass = obj.getUserPassword();
            int userRole = obj.getRoleId();
            
            boolean hashImage = userImage != null && !userImage.isEmpty();
            
            if ( hashImage ) {
                statement = DATABASE.connect().prepareStatement(
                    "INSERT INTO user( user_name, user_lastname, user_image, user_email, user_password, role_id ) "
                  + "VALUES ( ?, ?, ?, ?, ?, ? )"
                );
                statement.setString(1, userName);
                statement.setString(2, userLastname);
                statement.setString(3, userImage);
                statement.setString(4, userEmail);
                statement.setString(5, userPass);
                statement.setInt(6, userRole); 
            } else {
                statement = DATABASE.connect().prepareStatement(
                    "INSERT INTO user( user_name, user_lastname, user_email, user_password, role_id ) "
                  + "VALUES ( ?, ?, ?, ?, ? )"
                );
                statement.setString(1, userName);
                statement.setString(2, userLastname);
                statement.setString(3, userEmail);
                statement.setString(4, userPass);
                statement.setInt(5, userRole); 
            }
            
            if ( statement.executeUpdate() > 0 ) {
                response = true;
            }
            
            statement.close();
            
        } catch(SQLException e) {
            System.out.println("No se pudo guardar el usuario: " + e.getMessage());
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
                "UPDATE user "
              + "SET user_is_active = ? "
              + "WHERE user_id = ? "      
            );

            statement.setBoolean(1, status);
            statement.setInt(2, id);
            
            if ( statement.executeUpdate() > 0 ) {
                response = true;
            }
            
            statement.close();
            
        } catch(SQLException e) {
            System.out.println("No se pudo desactivar el usuario: " + e.getMessage());
        } finally {
            statement = null;
            DATABASE.disconnect();
        }
        
        return response;    
    }

    @Override
    public boolean updateItem(User obj, int id) {
        
        response = false;
        
        try {
            
            String userName = obj.getUserName();
            String userLastname = obj.getUserLastname();
            String userEmail = obj.getUserEmail();
            String userImage = obj.getUserImage();
            int roleId = obj.getRoleId();
            
            statement = DATABASE.connect().prepareStatement(
                    "UPDATE user "
                  + "SET user_name = ?, user_lastname = ?, user_image = ?, user_email = ?, role_id = ? "
                  + "WHERE user_id = ?"
            );
            
            statement.setString(1, userName);
            statement.setString(2, userLastname);
            statement.setString(3, userImage);
            statement.setString(4, userEmail);
            statement.setInt(5, roleId);
            statement.setInt(6, id);
            
            if ( statement.executeUpdate() > 0 ) {
                response = true;
            }
            
            statement.close();
            
        } catch(SQLException e) {
            System.out.println("No se pudo actualizar el usuario: " + e.getMessage());
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
            
            statement = DATABASE.connect().prepareStatement("SELECT COUNT(*) FROM user");
            result = statement.executeQuery();
            
            while( result.next() ) { 
                totalItems = result.getInt("COUNT(*)");
            }
            
            statement.close();
            result.close();
            
        } catch(SQLException e) {
            System.out.println("No se pudo obtener el total de usuarios: " + e.getMessage());
        } finally {
            statement = null;
            result = null;
            DATABASE.disconnect();
        }
        
        return totalItems;

    }
    
    public int getTotalUsersByRole( int role ) {
        
        int totalItems = 0;
        
        try {
            
            statement = DATABASE.connect().prepareStatement("SELECT COUNT(*) FROM user WHERE role_id = ?");
            statement.setInt(1, role);
            result = statement.executeQuery();
            
            while( result.next() ) { 
                totalItems = result.getInt("COUNT(*)");
            }
            
            statement.close();
            result.close();
            
        } catch(SQLException e) {
            System.out.println("No se pudo obtener el total de usuarios por rol: " + e.getMessage());
        } finally {
            statement = null;
            result = null;
            DATABASE.disconnect();
        }
        
        return totalItems;

    }
    
}
