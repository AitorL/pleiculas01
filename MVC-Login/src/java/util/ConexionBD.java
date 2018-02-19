package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionBD {
    
    private static Connection con = null;
    
    // Crea y retorna una conexión
    public static Connection createConnection()  
    {
        if ( con != null ) {   // Si existe conexión no crear una nueva
            return con;
        }
         
        // Datos de conexión
            // String url = "jdbc:mysql://localhost:3306/gesventa"; 
            // String user = "dwes"; 
            // String password = "dwes"; 
 
        try 
        {
            // Leer datos de conexión desde un archivo de tipo properties 
            Properties prop = new Properties();
            InputStream inputStream = ConexionBD.class.getClassLoader().getResourceAsStream("/bd.properties");
            prop.load(inputStream);
            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");
            String user = prop.getProperty("user");
            String password = prop.getProperty("password");
        
            Class.forName("com.mysql.jdbc.Driver"); // Cargar el driver de MySQL            
            con = DriverManager.getConnection(url, user, password); 
            
        } catch (ClassNotFoundException e) {
              e.printStackTrace();
        } catch (IOException e) {
              e.printStackTrace();
        } catch (SQLException ex) {
              Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return con; 
    }
}