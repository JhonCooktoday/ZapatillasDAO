package app.Controlador;

import app.Modelo.Empleado;
import app.DAO.EmpleadoDAO;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/Report")
public class ReporteEmpleadoPDF extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "inline; filename=empleados.pdf");

        try {
            Document doc = new Document();
            PdfWriter.getInstance(doc, response.getOutputStream());
            doc.open();

            Paragraph title = new Paragraph("REPORTE DE EMPLEADOS", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16));
            title.setAlignment(Element.ALIGN_CENTER);
            title.setSpacingAfter(20);
            doc.add(title);

            PdfPTable table = new PdfPTable(6);
            table.setWidthPercentage(100);
            table.setWidths(new float[]{1f, 2f, 2f, 3f, 2f, 2f});

            String[] headers = {"ID", "Nombre", "Apellido", "Correo", "Teléfono", "Salario"};
            for (String h : headers) {
                PdfPCell cell = new PdfPCell(new Phrase(h, FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
                cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
            }

            EmpleadoDAO dao = new EmpleadoDAO();
            List<Empleado> lista = dao.listarpdf();

            for (Empleado emp : lista) {
                table.addCell(String.valueOf(emp.getId()));
                table.addCell(emp.getNombre());
                table.addCell(emp.getApellido());
                table.addCell(emp.getCorreo());
                table.addCell(emp.getTelefono());
                table.addCell("S/ " + emp.getSalario());
            }

            doc.add(table);
            doc.close();

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
