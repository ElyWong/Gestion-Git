package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import listas.Usuarios;
import pool.TestPool;


@WebServlet("/gestionJefeArea")
public class gestionJefeArea extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TestPool tp;
	
    public gestionJefeArea() {
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
		String id = request.getParameter("idJefeArea");
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
			nombre = request.getParameter("nombre");
			ap = request.getParameter("ap");
			am = request.getParameter("am");
			
			boolean respEditar = tp.editarUsuario(id,nombre,ap,am);
			response.getWriter().println(respEditar);
			break;
			
		case "recuperar":
			List <Usuarios> infoJefeArea = tp.recuperaUsuario(id);
			
			if (infoJefeArea != null) {
				try (PrintWriter out = response.getWriter()) { 
					String json = new Gson().toJson(infoJefeArea); /* Se convierte A JSON LA LISTA Y se pasa A UN "STRING"*/
					System.out.println("JSON: " + json);

					out.println(json); /* IMPRIMIMOS ESE STRING */
				}
			} else {
				response.getWriter().print("Jefe de área VACIO");
			}
			
			break;
			
		case "eliminar":
			boolean respEliminar = tp.eliminarUsuario(id);
			
			response.getWriter().println(respEliminar);
			break;
		}
	}

}
