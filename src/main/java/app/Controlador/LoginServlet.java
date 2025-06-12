package app.Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import app.DAO.LoginDao;
import app.Modelo.Usuario;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginDao ld = new LoginDao();
		String nombreUsuario = request.getParameter("username");
		String contrasena = request.getParameter("password");

		Usuario usuario = null;
		try {
			usuario = ld.validar(nombreUsuario, contrasena);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (usuario != null) {
			HttpSession sesion = request.getSession();
			sesion.setAttribute("usuario", usuario);
			// Redirige a index.jsp con parámetro de éxito
			response.sendRedirect("bienvenido.jsp?login=success");
		} else {
			// Redirige a index.jsp con parámetro de error
			response.sendRedirect("index.jsp?login=error");
		}
	}
}
