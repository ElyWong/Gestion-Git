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
 * Servlet implementation class RegistroAlumno
 */
@WebServlet("/RegistroCorreo")
public class RegistroCorreo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String email,pass0,pass1, usuario;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroCorreo() {
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
		
		usuario= request.getParameter("boleta");
		
		if(usuario.length()<1){
			usuario = request.getParameter("bol");
		}
		System.err.println(usuario);
		email=request.getParameter("email");
		pass0=request.getParameter("pass0");
		pass1=request.getParameter("pass1");
		
		Usuario vu = new Usuario(usuario,email,pass0,pass1);
		
		if(vu.verificarPassword()) {
			System.out.println("contraseña correcta");
			//all is well
			if(vu.registrarCorreo()==1)
				if(vu.registrarContra()==1) {
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
							response.sendRedirect("consultarJefeGestion.jsp");
							//jefeGestion
							break;
						case 4:
							request.getSession().setAttribute("tipo", "4");
							response.sendRedirect("consultarSubdirector.jsp");
							//subdirector
							break;
					} 
				} else
					System.out.println("problemas al registrar la contraseña");
			else
				System.out.println("problemas al registrar el correo");
			
		}
		else{
			   request.getSession().setAttribute("boleta", usuario);
			   request.getSession().setAttribute("bol", usuario);
			   PrintWriter out = response.getWriter();
			   out.println("<script type=\"text/javascript\">");
			   out.println("alert('Contraseña incorrecta');");
			   out.println("location='registrarCorreo.jsp';");
			   out.println("</script>");
			//wey no registrado
		}
	}

}
