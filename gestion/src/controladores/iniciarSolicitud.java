package controladores;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class iniciarSolicitud
 */
@WebServlet("/iniciarSolicitud")
public class iniciarSolicitud extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public iniciarSolicitud() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tipo1=(String) request.getSession().getAttribute("tipo");
		System.out.println(tipo1);
		int tipo=Integer.parseInt(tipo1);
		Modelo.solicitarJsp sol=new Modelo.solicitarJsp();
		String menu=sol.armarMenu(tipo);
		String formulario=sol.armarFormulario(tipo);
		System.out.println(tipo);
		request.getSession().setAttribute("menu", menu);
		request.getSession().setAttribute("formulario", formulario);
	}

}
