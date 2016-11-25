package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.Consultas;

/**
 * Servlet implementation class GestionarAlumnoCtrl
 */
@WebServlet("/gestionAlumno")
public class GestionarAlumnoCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionarAlumnoCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Consultas consulta = new Consultas();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			ResultSet rs = consulta.listarEstudiantes();
			while(rs.next()) {
				out.print("<tr>");
				out.print("<td id=\"" + rs.getString("Boleta") + "\">");
				out.print(rs.getString("Boleta"));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getString("Nombre"));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getString("Correo"));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getString("Estatus"));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getString("Nivel"));
				out.print("</td>");
				out.print("</tr>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operacion = request.getParameter("operacion");
		String mensaje = "";
		response.setContentType("text/html");
		try {
			Integer boleta = Integer.valueOf(request.getParameter("boleta"));
			Integer nivel = Integer.valueOf(request.getParameter("nivel"));
			Consultas consulta = new Consultas();
			String nombre, email, estatus;
			switch(operacion) {
				case "A":
					nombre = request.getParameter("nombre");
					email = request.getParameter("email");
					estatus = request.getParameter("estatus");
					consulta.insertarAlumno(boleta, nombre, email, estatus, nivel);
					mensaje = "El alumno fue agregado correctamente.";
					break; 
				case "M":
					nombre = request.getParameter("nombre");
					email = request.getParameter("email");
					estatus = request.getParameter("estatus");
					consulta.modificarAlumno(boleta, nombre, email, estatus, nivel);
					mensaje = "Los datos del alumno se modificaron correctamente.";
					break;
				case "E":
					consulta.eliminarAlumno(boleta);
					mensaje = "El alumno fue eliminado correctamente.";
					break;
			}
		} catch(Exception e) {
			mensaje = "La operación no pudo ser realizada.";
		} finally {
			response.getWriter().print(mensaje);
		}
	}

}
