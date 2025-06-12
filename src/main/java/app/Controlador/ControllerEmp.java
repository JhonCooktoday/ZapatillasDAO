package app.Controlador;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.DAO.EmpleadoDAO;
import app.Modelo.Empleado;

/**
 * Servlet implementation class ControllerEmp
 */
@WebServlet("/ControllerEmp")
public class ControllerEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String accion = request.getParameter("accion");
	    
	    if ("listar".equalsIgnoreCase(accion)) {
	        EmpleadoDAO dao = new EmpleadoDAO(); // o el DAO que estés usando
	        List<Empleado> lista = dao.listar(); // método que devuelve todos los empleados
	        request.setAttribute("empleados", lista);
	        request.getRequestDispatcher("listaEmpleados.jsp").forward(request, response);
	    }else if("insertar".equalsIgnoreCase(accion)) {
	    	request.getRequestDispatcher("formularioEmpleado.jsp").forward(request, response); 
	    }else if ("eliminar".equalsIgnoreCase(accion)) {
	        int id = Integer.parseInt(request.getParameter("id"));
	        EmpleadoDAO dao = new EmpleadoDAO();
	        Empleado empleado = new Empleado();
	        empleado.setId(id);
	        dao.eliminar(empleado); // Llama al método eliminar del DAO
	        response.sendRedirect("ControllerEmp?accion=listar"); 
	    
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recuperamos los datos del formulario
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String correo = request.getParameter("correo");
		String telefono = request.getParameter("telefono");
		String direccion = request.getParameter("direccion");
		double salario = Double.parseDouble(request.getParameter("salario"));
		String fechaContratacionStr = request.getParameter("fechaContratacion");

		// Creamos la instancia del empleado
		Empleado empleado = new Empleado();
		EmpleadoDAO empleadoDAO = new EmpleadoDAO();

		// Asignamos los valores a la instancia del empleado
		empleado.setNombre(nombre);
		empleado.setApellido(apellido);
		empleado.setCorreo(correo);
		empleado.setTelefono(telefono);
		empleado.setDireccion(direccion);
		empleado.setSalario(salario);

		// Convertimos la fecha de contratación a Date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha = null;
		try {
		    fecha = sdf.parse(fechaContratacionStr);
		} catch (ParseException e) {
		    e.printStackTrace();
		}
		empleado.setFechaContratacion(fecha);
		System.out.println("Fecha recibida: " + fechaContratacionStr);


		// Llamamos al método para registrar el empleado en la base de datos
		empleadoDAO.registrar(empleado);

		// Redirigimos al listado de empleados
		response.sendRedirect("ControllerEmp?accion=listar&registrado=true");
	}

}
