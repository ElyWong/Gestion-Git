package controladores;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.Consultas;

/**
 * Servlet implementation class SolicitarEstudiante
 */
@WebServlet("/SolicitarEstudiante")
public class SolicitarEstudiante extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SolicitarEstudiante() {
        super();
        // TODO Auto-generated constructor stub
    }

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

		String tipoDoc = request.getParameter("tipodoc");
		String motivo = request.getParameter("motivo");
		String  idUsuario = (String) request.getSession().getAttribute("boleta");
		
		switch(tipoDoc) {
			case "1": 
				tipoDoc = "Boleta global";
				break;
			case "2": 
				tipoDoc = "Boleta Certificada";
				break;
			case "3": 
				tipoDoc = "Boleta Departamental";
				break;
			case "4": 
				tipoDoc = "Constancia de inscripción";
				break;
			case "5": 
				tipoDoc = "Constancia de inscripción y horario";
				break;
			case "6": 
				tipoDoc = "Constancia de estudios";
				break;
			case "7": 
				tipoDoc = "Constancia de periodo vacacional";
				break;
			case "8": 
				tipoDoc = "Constancia para trámite de servicio social";
				break;
		}

		switch(motivo) {
			case "1": 
				motivo = "Beca Externa";
				break;
			case "2": 
				motivo = "Movilidad";
				break;
			case "3": 
				motivo = "Ninguno";
				break;
			case "4": 
				motivo = "Padres";
				break;
			case "5": 
				motivo = "Otro";
				break;
		}
		
		Consultas consultas = new Consultas();
		String mensaje = "Solicitud agregada.";
		
		try {
			if(consultas.solicitarDocumento(Integer.valueOf(idUsuario), motivo, tipoDoc) == false) {
				mensaje = "Solicitud no permitida.";
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			mensaje = "Fallo interno del sistema.";
		}
		System.out.println("Mensaje: " + mensaje);
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher("consultarEstudiante.jsp").forward(request, response);

	}

}
