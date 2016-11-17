package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.BusquedaDatos;

/**
 * Servlet implementation class ObtenerSecuencia
 */
@WebServlet("/ObtenerSecuencia")
public class ObtenerSecuencia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ObtenerSecuencia() {
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
		// TODO Auto-generated method stub
		BusquedaDatos busd=new BusquedaDatos();
		String sec=request.getParameter("sec");
		String sentencia =(String)request.getSession().getAttribute(sec);
		System.out.println(sec);
		System.out.println(sentencia);
		String tabla=busd.simple(sentencia);
		request.getSession().setAttribute("tablaBusqueda", tabla);
		response.sendRedirect("estadistica.jsp");
		
	}

}
