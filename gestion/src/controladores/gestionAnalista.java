package controladores;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import pool.TestPool;

/**
 * Servlet implementation class gestionAnalista
 */
@WebServlet("/gestionAnalista")
public class gestionAnalista extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TestPool tp;
	
    public gestionAnalista() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		 tp = new TestPool();
	}

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipoOperacion = request.getParameter("tipo");
		String id = request.getParameter("idAnalista");
		String nombre,ap,am,pass,tipoUsuario;
		
		switch(tipoOperacion) {
		case "agregar":
			nombre = request.getParameter("nombre");
			ap = request.getParameter("ap");
			am = request.getParameter("am");
			pass = request.getParameter("pass");
			tipoUsuario = request.getParameter("tipoUsuario");
			
			boolean respAgregar = tp.agregarUsuario(id,nombre,ap,am,tipoUsuario,pass);
			response.getWriter().println(respAgregar);
			break;
		
		case "editar":
			break;
			
		case "eliminar":
			boolean respEliminar = tp.eliminarUsuario(id);
			
			response.getWriter().println(respEliminar);
			break;
		}
	}

}
