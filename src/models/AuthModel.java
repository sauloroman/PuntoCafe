package models;

import config.Database;
import entities.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthModel {
    
    private final Database DATABASE;
    private PreparedStatement statement;
    private ResultSet result;
    private boolean response;
    
    public AuthModel() {
        this.DATABASE = Database.getInstance();
    }
    
    public User login(String email, String pass) {
        
        User user = null;
        
        try {
            
            statement = DATABASE.connect().prepareStatement("SELECT * FROM user WHERE user_email = ? AND user_password = ?");
            statement.setString(1, email);
            statement.setString(2, pass);
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
            
        } catch(SQLException e) {
            System.out.println("Authenticacion: No se pudo iniciar al usuario: " + e.getMessage());
        } finally {
            DATABASE.disconnect();
            statement = null;
            result = null;
        }
        
        
        return user;
    }
    
    public User getUserByEmail(String email) {
        
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
            
        } catch(SQLException e) {
            System.out.println("Authenticacion: No se pudo obtener el usuario por email: " + e.getMessage());
        } finally {
            DATABASE.disconnect();
            statement = null;
            result = null;
        }
        
        return user;
    }
    
}
