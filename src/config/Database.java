package config;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.Properties;

public class Database {
    
    private String url;
    private String user;
    private String password;
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    
    public Connection connectionStr;
    private static Database instance;
    
    private Database() {
        connectionStr = null;
        loadCredentials();
    }
    
    public synchronized static Database getInstance() {
        if ( instance == null ) {
            instance = new Database();
        }
        return instance;
    }
    
    private void loadCredentials() {
        
        Properties props = new Properties();
        
        try( InputStream input = getClass().getClassLoader().getResourceAsStream("config/config.properties") ) {
            
            if ( input == null ) {
                System.out.println("No se encontró el archivo de configuración para la base de datos.");
                System.exit(0);
            }
            
            props.load(input);
            url = props.getProperty("db.url");
            user = props.getProperty("db.user");
            password = props.getProperty("db.password");
            
        } catch( IOException e ){
            System.out.println("No se pudo leer el archivo");
            System.exit(0);
        }  
    }
    
    public Connection connect() {
        try {
            Class.forName(DRIVER);
            this.connectionStr = DriverManager.getConnection(url, user, password);
        } catch(ClassNotFoundException | SQLException e ) {
            System.out.println("No se pudo conect a la base de datos: " + e.getMessage());
            System.exit(0);
        }
        
        return connectionStr;
    }
    
    public void disconnect() {
        try {
            connectionStr.close();
        } catch( SQLException e ) {
            System.out.println("Error en la desconexión: " + e.getMessage());
        }
    }
    
}
