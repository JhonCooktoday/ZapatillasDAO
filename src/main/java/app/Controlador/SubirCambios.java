package app.Controlador;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.DAO.EmpleadoDAO;
import app.Modelo.Empleado;

/**
 * Servlet implementation class SubirCambios
 */
@WebServlet("/SubirCambios")
public class SubirCambios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubirCambios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recibir los datos del formulario
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String correo = request.getParameter("correo");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        double salario = Double.parseDouble(request.getParameter("salario"));
        String fechaContratacionStr = request.getParameter("fechaContratacion");
        int id = Integer.parseInt(request.getParameter("id"));

        // Crear la instancia del empleado
        Empleado empleado = new Empleado();
        empleado.setId(id);
        empleado.setNombre(nombre);
        empleado.setApellido(apellido);
        empleado.setCorreo(correo);
        empleado.setTelefono(telefono);
        empleado.setDireccion(direccion);
        empleado.setSalario(salario);

        // Convertir la fecha
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date fechaContratacion = sdf.parse(fechaContratacionStr);
            empleado.setFechaContratacion(fechaContratacion);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        

        // Actualizar los datos en la base de datos
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        empleadoDAO.actualizar(empleado);

        // Redirigir al listado de empleados después de la actualización
        response.sendRedirect("ControllerEmp?accion=listar&actualizado=true");
        
	}

}
