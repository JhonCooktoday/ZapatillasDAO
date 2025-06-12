package app.Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.DAO.EmpleadoDAO;
import app.Modelo.Empleado;

/**
 * Servlet implementation class ActualizarEmpleado
 */
@WebServlet("/Update")
public class ActualizarEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int id = Integer.parseInt(request.getParameter("id"));
	        
	        // Recuperar el empleado de la base de datos
	        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
	        Empleado empleado = empleadoDAO.buscarPorID(id);
	        
	        // Establecer el empleado en el request para mostrarlo en el JSP
	        request.setAttribute("empleado", empleado);
	        
	        // Redirigir al JSP que contiene el formulario de edición
	        request.getRequestDispatcher("FormularioEditar.jsp").forward(request, response);
	    }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    }
	

}
