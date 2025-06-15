package app.Controlador;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import java.io.File;

import app.DAO.MarcaDAO;
import app.DAO.ZapatillaDAO;
import app.Modelo.Marca;
import app.Modelo.Zapatilla;

/**
 * Servlet implementation class ControlerRegZapatilla
 */
@MultipartConfig
@WebServlet("/RegistrarZapatilla")
public class ControlerRegZapatilla extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  // Obtener lista de marcas para el combo
	    MarcaDAO marcaDAO = new MarcaDAO();
	    List<Marca> listaMarcas = marcaDAO.listarTodo();
	    request.setAttribute("atrListaMarcas", listaMarcas);

	    // Mostrar formulario de registro
	    request.getRequestDispatcher("RegistrarZapatilla.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Obtener parámetros del formulario
				String modelo = request.getParameter("modelo");
				String color = request.getParameter("color");
				double talla = Double.parseDouble(request.getParameter("talla"));
				double precio = Double.parseDouble(request.getParameter("precio"));
				int stock = Integer.parseInt(request.getParameter("stock"));
				String genero = request.getParameter("genero");
				String tipo = request.getParameter("tipo");
				String fechaIngresoStr = request.getParameter("fechaIngreso");
				int marcaId = Integer.parseInt(request.getParameter("marca"));
				
				//Obtener la imagen
				Part filePart = request.getPart("imagen");
				String fileName = new File(filePart.getSubmittedFileName()).getName();
				
			    // Generar un nombre único para el archivo (opcional)
			    String uniqueFileName = System.currentTimeMillis() + "_" + fileName;
			    
			    // Establecer la ruta de guardado de la imagen
			    String savePath = getServletContext().getRealPath("/imagenes/zapatillas");
			    File uploadDir = new File(savePath);
			    if (!uploadDir.exists()) uploadDir.mkdirs();
			    
			    // Guardar el archivo
			    try {
			        filePart.write(savePath + File.separator + uniqueFileName);
			    } catch (IOException e) {
			        e.printStackTrace();
			        request.setAttribute("estado", false);
			        request.setAttribute("errorMessage", e.getMessage());
			        request.getRequestDispatcher("error.jsp").forward(request, response);
			        return; // Detener la ejecución si hay un error con la imagen
			    }
			    
			    // Crear la ruta relativa para la imagen
			    String imagenF = "imagenes/zapatillas/" + uniqueFileName;
				
				try {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					java.util.Date utilDate = sdf.parse(fechaIngresoStr);
					Date fechaIngreso = new Date(utilDate.getTime());

					// Crear zapatilla
					Zapatilla zapatilla = new Zapatilla();
					zapatilla.setModelo(modelo);
					zapatilla.setColor(color);
					zapatilla.setTalla(talla);
					zapatilla.setPrecio(precio);
					zapatilla.setStock(stock);
					zapatilla.setGenero(genero);
					zapatilla.setTipo(tipo);
					zapatilla.setFechaIngreso(fechaIngreso);
					
					Marca marca = new Marca();
					marca.setIdMarca(marcaId);
					zapatilla.setMarca(marca);
					
					zapatilla.setImg_Zapatilla(imagenF);

					// Registrar en BD
					ZapatillaDAO dao = new ZapatillaDAO();
					dao.registrar(zapatilla);

					// Redirigir con parámetro a IndexZapatilla
					response.sendRedirect("IndexZapatilla?marca=" + marcaId);

				} catch (Exception e) {
					e.printStackTrace();
					request.setAttribute("errorMessage", e.getMessage());
				    request.getRequestDispatcher("error.jsp").forward(request, response);
				}
    }
}

