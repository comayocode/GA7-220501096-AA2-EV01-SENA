package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductosDAO {
 
    //Crear conexión con la DB
    Connection conexion;
    
    public ProductosDAO() {
        Conexion con = new Conexion();
        conexion = con.getConexion();
    }
    
    //Método listarProductos() público de tipo List<Productos>
    public List<Productos> listarProductos(){
        
        PreparedStatement ps;
        ResultSet rs;
        
        //Lista para retornar
        List<Productos> listaProductos = new ArrayList<>();
        
        try {
            //Crear consulta
            String consulta = "SELECT id, codigo, nombre, precio, existencia FROM productos";
            ps = conexion.prepareStatement(consulta);
            
            //Ejecutar consulta y se guarda en la tabla ResulSet
            rs = ps.executeQuery();
            
            //Recorre el ResultSet y extrae los datos
            while (rs.next()){
                
                //Variable para cada elemento de la consulta (columna de tabla de DB)
                int id = rs.getInt("id");
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                Double precio = rs.getDouble("precio");
                int existencia = rs.getInt("existencia");
                
                //Instanciar clase Productos.java
                Productos producto = new Productos(id, codigo, nombre, precio, existencia);
                
                //Llenar la lista con los productos recorridos
                listaProductos.add(producto);
                
            }
            //Retorna la lista
            return listaProductos;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
        
    }
    
    //Método mostrarProducto(int _id) para mostrar un único registro por un id como parámetro
    public Productos mostrarProducto(int _id){
        
        PreparedStatement ps;
        ResultSet rs;
        
        //Inicializar producto a retornar
        Productos producto = null;
        
        try {
            //Crear consulta
            String consulta = "SELECT id, codigo, nombre, precio, existencia FROM productos WHERE id=?";
            ps = conexion.prepareStatement(consulta);
            
            /*
            * Se pasa el indice del parámetro de la consulta en la posición 1 después de WHERE 
            * y como segundo parametro se le pasa el parámetro que recibe el método
            */
            ps.setInt(1, _id);
            //Ejecutar consulta y se guarda en la tabla ResulSet
            rs = ps.executeQuery();
            
            //Recorre el ResultSet y extrae los datos
            while (rs.next()){
                
                //Variable para cada elemento de la consulta (columna de tabla de DB)
                int id = rs.getInt("id");
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                Double precio = rs.getDouble("precio");
                int existencia = rs.getInt("existencia");
                
                //Pasar datos extraidos a la variable producto
                producto = new Productos(id, codigo, nombre, precio, existencia);
                
            }
            //Retorna el producto
            return producto;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
        
    }

    //Insertar registros recibiendo la clase Productos.java
    public boolean insertar(Productos producto){
        
        PreparedStatement ps;
        
        try {
            //Crear consulta
            String consulta = "INSERT INTO productos (codigo, nombre, precio, existencia) VALUES (?,?,?,?)";
            //Guardamos un objeto PreparedStatement para enviar la consulta
            ps = conexion.prepareStatement(consulta);
            
            //Pasar datos cargados del modeloVO a la sentencia preparada (PreparedStatement ps;)
            ps.setString(1, producto.getCodigo());
            ps.setString(2, producto.getNombre());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getExistencia());
            
            //Realizar inserción a la DB
            ps.execute();
            
            //Retorna el producto
            return true;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
        
    }
    
    //Actualizar registro recibiendo la clase Productos.java
    public boolean actualizar(Productos producto){
        
        PreparedStatement ps;
        
        try {
            //Crear consulta
            String consulta = "UPDATE productos SET codigo=?, nombre=?, precio=?, existencia=? WHERE id=?";
            //Guardamos un objeto PreparedStatement para enviar la consulta
            ps = conexion.prepareStatement(consulta);
            
            //Pasar datos cargados del modeloVO a la sentencia preparada (PreparedStatement ps;)
            ps.setString(1, producto.getCodigo());
            ps.setString(2, producto.getNombre());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getExistencia());
            ps.setInt(5, producto.getId());
            
            //Realizar insercióAn a la DB
            ps.execute();
            
            //Retorna el producto
            return true;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
        
    }
    
    //Elminar registro recibiendo como parámetro el id del registro
    public boolean eliminar(int _id){
        
        PreparedStatement ps;
        
        try {
            //Crear consulta
            String consulta = "DELETE FROM productos WHERE id=?";
            //Guardamos un objeto PreparedStatement para enviar la consulta
            ps = conexion.prepareStatement(consulta);
            
            //Pasar datos cargados del modeloVO a la sentencia preparada (PreparedStatement ps;)
            ps.setInt(1, _id);
            
            //Realizar insercióAn a la DB
            ps.execute();
            
            //Retorna el producto
            return true;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
        
    }
    
}
