package app.Controlador;

import java.io.IOException;
import java.io.InputStream;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import app.DAO.LoginDao;
import app.Modelo.Usuario;




/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
@MultipartConfig
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginDao dao = new LoginDao();
	Usuario u = new Usuario();

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
		String accion = request.getParameter("accion");
		if (accion == null || accion.trim().isEmpty()) {
		    accion = "Guardar"; // valor por defecto si llega vacío
		}
		switch (accion) {
		case "Guardar":
			String nombre = request.getParameter("nombre");
			String contrasenia = request.getParameter("contrasena");
			Part part = request.getPart("fileFoto");
			InputStream inputstream = part.getInputStream();
			u.setNombreUsuario(nombre);
			u.setContrasena(contrasenia);
			u.setFoto(inputstream);
			dao.insertar(u);
			request.getRequestDispatcher("bienvenido.jsp").forward(request, response);
			inputstream.close();
	

			
			break;
		default:
			break;
		}
	}

}
