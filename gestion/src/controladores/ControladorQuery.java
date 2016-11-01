package controladores;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pool.TestPool;

/**
 * Servlet implementation class ControladorQuery
 */
@WebServlet("/query")
public class ControladorQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorQuery() {
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
		String consulta=request.getParameter("txtQuery");
		TestPool operador=(TestPool)request.getSession().getAttribute("op");
		int columnas=0;
		int bandera=0;
		
		if(consulta.charAt(0)=='s' || (consulta.charAt(0)=='d' && consulta.charAt(1)=='e' && consulta.charAt(2)=='s') || consulta.charAt(0)=='S' || (consulta.charAt(0)=='D' && consulta.charAt(1)=='E' && consulta.charAt(2)=='S') ) {
			bandera=1;
			String[] arr;
			try {
				ArrayList<String> a= operador.ejecutar(consulta);
				arr = a.toArray(new String[0]);
				columnas=operador.getLastcolums();
				request.getSession().setAttribute("respuesta", arr);
				request.getSession().setAttribute("col", columnas);
			} catch (SQLException e) {
				bandera=0; 
				request.getSession().setAttribute("mensaje", "No se realizo exitosamente el comando");
				e.printStackTrace();
			}
		}
		else {
			bandera=0;
			try{
				operador.ejecutarSR(consulta);
				request.getSession().setAttribute("mensaje", "Se realizo exitosamente el comando");
			}catch(SQLException e){
				request.getSession().setAttribute("mensaje", "No se realizo exitosamente el comando");
				e.printStackTrace();
			}
		}
		request.getSession().setAttribute("bandera", bandera);
		response.sendRedirect("SQLWeb.jsp");
	}

}
