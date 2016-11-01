package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.Solicitud;

/**
 * Servlet implementation class consultaAnalista
 */
@WebServlet("/consultaAnalista")
public class consultaAnalista extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public consultaAnalista() {
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
		String[] boletas= request.getParameterValues("nBoleta");
		String usuario=(String)request.getSession().getAttribute("boleta");
		String status=request.getParameter("status");
		System.out.println("El status es: "+status);
		System.out.println("las boletas son:");
		Solicitud unaS=new Solicitud();
		
		if(!boletas.toString().equals("")){
			for(String s : boletas){
				System.out.println(s);
				unaS.actualizarEstado(s, usuario, status);
			}
		}
		request.getSession().setAttribute("boleta", usuario);
		response.sendRedirect("consultarAnalista.jsp");
	}

}
