package controladores;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pool.TestPool;

/**
 * Servlet implementation class ControladorBase
 */
@WebServlet("/base")
public class ControladorBase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorBase() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TestPool operador=new TestPool();
		try{
			operador.getconexion();
			request.getSession().setAttribute("op", operador);
			request.getSession().setAttribute("bandera", 0);
			request.getSession().setAttribute("mensaje", "Aun no se ha realizado una consulta");
			response.sendRedirect("SQLWeb.jsp");
		} catch(SQLException ex){
			enviarError(response);
		}
		
	}
	public void enviarError(HttpServletResponse response){
		try {
			response.getWriter().println("<html>");
			response.getWriter().println("	<head>");
			response.getWriter().println("		<title>Error</title>");
			response.getWriter().println("		<meta charset='utf-8' />");
			response.getWriter().println("		<meta name='viewport' content='width=device-width, initial-scale=1, user-scalable=no' />");
			response.getWriter().println("		<link rel='stylesheet' href='assets/css/main.css' />");
			response.getWriter().println("	</head>");
			response.getWriter().println("	<body>");
			response.getWriter().println("		<header id=header>");
			response.getWriter().println("			<h1>Error</h1>");
			response.getWriter().println("		</header>");
			response.getWriter().println("		<section id='section'>");
			response.getWriter().println("			<ul class='icons'>");
			response.getWriter().println("				<li><a href='login.html'>Inicio</a></li>");
			response.getWriter().println("			</ul>");
			response.getWriter().println("		</section>");
			response.getWriter().println("		<aside id='aside'>");
			response.getWriter().println("			<h2>Error al intentar la conexion</h2>");
			response.getWriter().println("		</aside>");
			response.getWriter().println("		<footer id='footer'>");
			response.getWriter().println("			<ul class='copyright'>");
			response.getWriter().println("			<li>Copyright 2015</li>");
			response.getWriter().println("			</ul>");
			response.getWriter().println("		</footer>");
			response.getWriter().println("		<script src='assets/js/main.js'></script>");
			response.getWriter().println("	</body>");
				response.getWriter().println("</html> ");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}
}
