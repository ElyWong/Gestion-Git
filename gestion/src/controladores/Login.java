package controladores;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.Usuario;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    String usuario, password;
    int tipo=-1;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		usuario=request.getParameter("user");
		password=request.getParameter("pass");
		
		Usuario vu = new Usuario(usuario,password);
		if(vu.verificarExistencia()){
			if(vu.verificarPassword()){
				System.out.println("contraseña correcta");
				//all is well
				if(vu.verificarCorreo()){
					System.out.println("si tiene correo");
					//checar qué tipo es
					request.getSession().setAttribute("boleta", usuario);
					switch(vu.verificarTipoUsuario()){
						case 0:
							request.getSession().setAttribute("tipo", "0");
							response.sendRedirect("consultarEstudiante.jsp");
							//estudiante
							break;
						case 1:
							request.getSession().setAttribute("tipo", "1");
							response.sendRedirect("consultarJefeArea.jsp");
							//jefeArea
							break;
						case 2:
							request.getSession().setAttribute("tipo", "2");
							response.sendRedirect("consultarAnalista.jsp");
							//analista
							break;
						case 3:
							request.getSession().setAttribute("tipo", "3");
							response.sendRedirect("generarEstadistica.jsp");
							//jefeGestion
							break;
						case 4:
							request.getSession().setAttribute("tipo", "4");
							response.sendRedirect("consultarSubdirector.jsp");
							//subdirector
							break;
					}
				}
				else{
					System.out.println("no tiene correo");
					request.setAttribute("boleta", usuario);
					request.getRequestDispatcher("registrarCorreo.jsp").forward(request, response);
					//hacer pantalla para guardar correo y cambiar contraseña
				}
			}
			else{
				//contraseña incorrecta
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				   out.println("alert('Contraseña incorrecta');");
				   out.println("location='index.jsp';");
				   out.println("</script>");
				
			}
		}
		else{
			//No existe el usuario
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			   out.println("alert('Usuario no registrado');");
			   out.println("location='index.jsp';");
			   out.println("</script>");
		}
		
	}

}
