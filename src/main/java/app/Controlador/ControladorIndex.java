package app.Controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.DAO.ZapatillaDAO;
import app.Modelo.Zapatilla;

/**
 * Servlet implementation class ControladorIndex
 */
@WebServlet("/Index")
public class ControladorIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ZapatillaDAO zapatillaDAO = new ZapatillaDAO();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Obtener la lista de todas las zapatillas
		List<Zapatilla> todasZapatillas = new ArrayList<>();


		todasZapatillas.addAll(zapatillaDAO.buscarPorMarca(1));
		todasZapatillas.addAll(zapatillaDAO.buscarPorMarca(2));
		todasZapatillas.addAll(zapatillaDAO.buscarPorMarca(3));
		todasZapatillas.addAll(zapatillaDAO.buscarPorMarca(4));
		todasZapatillas.addAll(zapatillaDAO.buscarPorMarca(5));
		todasZapatillas.addAll(zapatillaDAO.buscarPorMarca(6));
		todasZapatillas.addAll(zapatillaDAO.buscarPorMarca(7));
		todasZapatillas.addAll(zapatillaDAO.buscarPorMarca(8));
		todasZapatillas.addAll(zapatillaDAO.buscarPorMarca(9));
		todasZapatillas.addAll(zapatillaDAO.buscarPorMarca(10));
		request.setAttribute("zapatillas", todasZapatillas);
		request.getRequestDispatcher("index2.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
