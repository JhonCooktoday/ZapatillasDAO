package app.Controlador;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import app.DAO.MarcaDAO;
import app.DAO.ZapatillaDAO;
import app.Modelo.Marca;
import app.Modelo.Zapatilla;

/**
 * Servlet implementation class ControladorActualizarZapatilla
 */
@MultipartConfig
@WebServlet("/ActualizarZapatilla")
public class ControladorActualizarZapatilla extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  int id = Integer.parseInt(request.getParameter("id"));
	        ZapatillaDAO dao = new ZapatillaDAO();
	        MarcaDAO marcaDAO = new MarcaDAO();

	        request.setAttribute("zapatilla", dao.buscarPorID(id));
	        request.setAttribute("marcas", marcaDAO.listarTodo());
	        request.getRequestDispatcher("ActualizarZapatilla.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Zapatilla z = new Zapatilla();
	        z.setIdZapatilla(Integer.parseInt(request.getParameter("id")));
	        z.setModelo(request.getParameter("modelo"));
	        z.setColor(request.getParameter("color"));
	        z.setTalla(Double.parseDouble(request.getParameter("talla")));
	        z.setPrecio(Double.parseDouble(request.getParameter("precio")));
	        z.setStock(Integer.parseInt(request.getParameter("stock")));
	        z.setGenero(request.getParameter("genero"));
	        z.setTipo(request.getParameter("tipo"));
	        z.setFechaIngreso(java.sql.Date.valueOf(request.getParameter("fechaIngreso")));
	        z.setMarca(new Marca(Integer.parseInt(request.getParameter("marca")), ""));
	        
	        String imagenAnterior = request.getParameter("imagen_anterior");
	        
	        //
	        String imagenF;
	        Part filePart = request.getPart("imagen");
	        
	        if(filePart != null && filePart.getSize() > 0) {
	            // Guardar nueva imagen
	        	String fileName = System.currentTimeMillis() + "_" + Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
	            String uploadPath = getServletContext().getRealPath("/imagenes/zapatillas");
	            File dir = new File(uploadPath);
	            if (!dir.exists()) dir.mkdirs();

	            String fullPath = uploadPath + File.separator + fileName;
	            filePart.write(fullPath);
	            imagenF = "imagenes/zapatillas/" + fileName;

	            // Eliminar imagen anterior si existe
	            if (imagenAnterior != null && !imagenAnterior.isEmpty()) {
	                File oldFile = new File(getServletContext().getRealPath("/") + imagenAnterior);
	                if (oldFile.exists()) oldFile.delete();
	            }
	        }
	        else {
	        	imagenF = imagenAnterior;
	        }
	        
	        z.setImg_Zapatilla(imagenF);

	        boolean actualizado = new ZapatillaDAO().actualizar(z);

	        if (actualizado) {
	            response.sendRedirect("IndexZapatilla?marca=" + z.getMarca().getIdMarca());
	        } else {
	            request.setAttribute("mensaje", "Error al actualizar");
	            request.getRequestDispatcher("ActualizarZapatilla.jsp").forward(request, response);
	        }
    }

}
