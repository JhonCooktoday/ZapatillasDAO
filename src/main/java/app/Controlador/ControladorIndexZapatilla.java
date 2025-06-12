package app.Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.DAO.MarcaDAO;
import app.DAO.ZapatillaDAO;
import app.Modelo.Marca;
import app.Modelo.Zapatilla;

@WebServlet("/IndexZapatilla")
public class ControladorIndexZapatilla extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MarcaDAO marcaDAO = new MarcaDAO();
        ZapatillaDAO zapatillaDAO = new ZapatillaDAO();

        // Cargar marcas siempre
        List<Marca> listaMarcas = marcaDAO.listarTodo();
        request.setAttribute("atrListaMarcas", listaMarcas);

        String accion = request.getParameter("accion");

        if ("eliminar".equalsIgnoreCase(accion)) {
            try {
                int id = Integer.parseInt(request.getParameter("id"));
                int idMarca = Integer.parseInt(request.getParameter("marca"));

                boolean eliminado = zapatillaDAO.eliminar(id);
                String mensaje = eliminado ? "¡Zapatilla eliminada exitosamente!" : "Error al eliminar la zapatilla.";
                request.setAttribute("mensaje", mensaje);

                List<Zapatilla> listaZapatillas = zapatillaDAO.buscarPorMarca(idMarca);
                request.setAttribute("atrListaZapatillas", listaZapatillas);
                request.setAttribute("marcaSeleccionada", idMarca);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        } else {
            String paramMarca = request.getParameter("marca");
            if (paramMarca != null && !paramMarca.isEmpty()) {
                try {
                    int idMarca = Integer.parseInt(paramMarca);
                    List<Zapatilla> listaZapatillas = zapatillaDAO.buscarPorMarca(idMarca);
                    request.setAttribute("atrListaZapatillas", listaZapatillas);
                    request.setAttribute("marcaSeleccionada", idMarca);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        }

        request.getRequestDispatcher("IndexZapatilla.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MarcaDAO marcaDAO = new MarcaDAO();
        ZapatillaDAO zapatillaDAO = new ZapatillaDAO();

        // Cargar marcas siempre
        List<Marca> listaMarcas = marcaDAO.listarTodo();
        request.setAttribute("atrListaMarcas", listaMarcas);

        String paramMarca = request.getParameter("cmbMarca");
        if (paramMarca != null && !paramMarca.isEmpty()) {
            try {
                int idMarca = Integer.parseInt(paramMarca);
                List<Zapatilla> listaZapatillas = zapatillaDAO.buscarPorMarca(idMarca);
                request.setAttribute("atrListaZapatillas", listaZapatillas);
                request.setAttribute("marcaSeleccionada", idMarca);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        } else {
            request.setAttribute("mensaje", "Por favor, selecciona una marca.");
        }

        request.getRequestDispatcher("IndexZapatilla.jsp").forward(request, response);
    }
}