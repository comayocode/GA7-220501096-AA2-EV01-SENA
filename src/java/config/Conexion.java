package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    
    private final String DB = "almacen";
    private final String USUARIO = "root";
    private final String CONTRASENA = "";
    private final String URL = "jdbc:mysql://localhost:3306/"+DB;
    //private Connection conexion;
    
    public Connection getConexion() {
            
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(URL,USUARIO,CONTRASENA);
            
            System.out.println("Conexión exitosa");
            
            return conexion;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        
    }
    
}
