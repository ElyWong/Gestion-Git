package controladores;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
 * Servlet implementation class GenerarBitacoraCtrl
 */
@WebServlet("/bitacora")
public class GenerarBitacoraCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String path = "";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerarBitacoraCtrl() {
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
		String fecha = request.getParameter("fechaInicial");
		//String idAnalista = request.getParameter("boleta");
		Consultas consulta = new Consultas();
		try {
			ResultSet rs = consulta.generarBitacora(fecha);
			ArrayList<String> analistas = consulta.obtenerAnalistas(fecha);
			String filename = GenerarBitacoraPDF.crearDocumento(rs, analistas, path, fecha);
			request.getSession().setAttribute("filename", filename);
			response.sendRedirect("bitacoraAnalista.jsp");
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
