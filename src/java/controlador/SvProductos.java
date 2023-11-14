package controlador;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Productos;
import modelo.ProductosDAO;

@WebServlet(name = "SvProductos", urlPatterns = {"/"})
public class SvProductos extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Se trae la clase con su objeto; al hacer esto se ejecuta el costructor con la conexión a la DB
        ProductosDAO proDao = new ProductosDAO();
        //String o variable que guarda una acción
        String accion;
        //Indica que vista se va a mostrar
        RequestDispatcher dispatcher = null;

        //Tomar la accion que haga el usuario
        accion = request.getParameter("accion");

        //Validar las acciones que está realizando el usuario
        //Validar si no hace ninguna acción
        if (accion == null || accion.isEmpty()) {
            //Vista que va a redirigir si no se hace ninguna acción
            dispatcher = request.getRequestDispatcher("Productos/index.jsp");

            //Obtener valores de la tabla de la DB en el index.jsp del método listarProductos del modeloDAO
            List<Productos> listaProductos = proDao.listarProductos();
            //Settear un atributo de nombre "listaProductos" pasándole el array de listaProductos
            request.setAttribute("listaProductos", listaProductos);
        }
        
        //En caso de que se quiera insetar un registro que muestre la página que es
        else if ("nuevo".equals(accion)){
            dispatcher = request.getRequestDispatcher("Productos/nuevo.jsp");
        }
        
        //En caso de que se quiera insetar un registro
        else if ("insertar".equals(accion)){
            
            //Recibir datos por doPost que envie el usuario por medio del formulario de nuevo.jsp
            String codigo = request.getParameter("txtcodigo");
            String nombre = request.getParameter("txtnombre");
            Double precio = Double.valueOf(request.getParameter("txtprecio"));
            int existencia = Integer.parseInt(request.getParameter("txtexistencia"));
            
            Productos pro = new Productos(0, codigo, nombre, precio, existencia);
            
            //llamado de proDao con el método insertar y le pasamos el objeto pro
            proDao.insertar(pro);
            
            //Al hacer todo reenviar al usuario al index.jsp
            dispatcher = request.getRequestDispatcher("Productos/index.jsp");
            
            //Actualizar la tabla con la lista de productos de la DB
            List<Productos> listaProductos = proDao.listarProductos();
            request.setAttribute("listaProductos", listaProductos);
            
        }
        
        //Envia un registro dependiendo del id a el formulario para actualizarlo
        else if ("vermodificar".equals(accion)){
            dispatcher = request.getRequestDispatcher("Productos/modificar.jsp");
            //
            int id = Integer.parseInt(request.getParameter("urlid"));
            System.out.println("EL ID ES: "+ id);
            //Llamar método para traer los registros dependiendo de un id
            Productos pro = proDao.mostrarProducto(id);
            
            //Setear atributo al producto que encontró en la DB por el id
            request.setAttribute("proModificar", pro);
        }
        
        //En caso de querer actualizar o modificar un registro
        else if ("actualizar".equals(accion)){
            
            //
            int id = Integer.parseInt(request.getParameter("txtid"));
            String codigo = request.getParameter("txtcodigo");
            String nombre = request.getParameter("txtnombre");
            Double precio = Double.valueOf(request.getParameter("txtprecio"));
            int existencia = Integer.parseInt(request.getParameter("txtexistencia"));
            
            Productos pro = new Productos(id, codigo, nombre, precio, existencia);
            
            //llamado de proDao con el método insertar y le pasamos el objeto pro
            proDao.actualizar(pro);
            
            //Al hacer todo reenviar al usuario al index.jsp
            dispatcher = request.getRequestDispatcher("Productos/index.jsp");
            //Actualizar la tabla con la lista de productos de la DB
            List<Productos> listaProductos = proDao.listarProductos();
            request.setAttribute("listaProductos", listaProductos);
            
        }
        
        //En caso de querer eliminar un registro
        else if ("eliminar".equals(accion)){
            
            //Pasar id como parámetro para eliminar el registro
            int id = Integer.parseInt(request.getParameter("urlid"));
            
            //llamado de proDao con el método eliminar y le pasamos el id del producto
            proDao.eliminar(id);
            
            //Al hacer todo reenviar al usuario al index.jsp
            dispatcher = request.getRequestDispatcher("Productos/index.jsp");
            //Actualizar la tabla con la lista de productos de la DB
            List<Productos> listaProductos = proDao.listarProductos();
            request.setAttribute("listaProductos", listaProductos);
        }
        
        //Mostrar vista principal si no coincide con ningúna accion
        else {
            dispatcher = request.getRequestDispatcher("Productos/index.jsp");
            //Actualizar la tabla con la lista de productos de la DB
            List<Productos> listaProductos = proDao.listarProductos();
            request.setAttribute("listaProductos", listaProductos);
        }
        
        //Reenvio de solicitud a otro recurso
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Enviar todas las peticiones que hace el usuario al método doGet
        doGet(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
