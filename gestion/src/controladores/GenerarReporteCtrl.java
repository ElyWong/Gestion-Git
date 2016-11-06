package controladores;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.DocumentException;

import Modelo.Consultas;
import Modelo.GenerarBitacoraPDF;

/**
 * Servlet implementation class GenerarReporteCtrl
 */
@WebServlet("/reporte")
public class GenerarReporteCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String path = "";
    
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerarReporteCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }
    

    @Override
    public void init(ServletConfig config) throws ServletException {
    	path = config.getServletContext().getRealPath("/");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idAnalista = request.getParameter("boleta");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String fechaActual = formatter.format(new Date());
		Consultas consulta = new Consultas();
		try {
			ResultSet rs = consulta.generarReporte(idAnalista, fechaActual);
			ArrayList<String> analistas = consulta.obtenerAnalista(idAnalista);
			String filename = GenerarBitacoraPDF.crearReporte(rs, analistas, path, fechaActual, idAnalista);
			request.getSession().setAttribute("filename", filename);
			response.sendRedirect("reporteAnalista.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
