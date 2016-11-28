package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class Login
 */
@WebFilter(urlPatterns = { "/*" })
public class Login implements Filter {

    /**
     * Default constructor. 
     */
    public Login() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest rqst = (HttpServletRequest) request;
		HttpServletResponse rspns = (HttpServletResponse) response;
		String uri = rqst.getRequestURI();
		HttpSession session = rqst.getSession(false);
		String idUsuario = null;
		try{
			idUsuario = (String) session.getAttribute("boleta");
		}catch(NullPointerException ex){
			idUsuario = null;
		} finally{
			if(idUsuario == null) {
				if(uri.endsWith("index.jsp")||uri.endsWith("gestion/")
						||uri.endsWith("login")||uri.endsWith("gestion")
						||uri.endsWith("RegistroCorreo")||uri.endsWith("registrarCorreo.jsp")
						||uri.endsWith("RecuperarContra")||uri.endsWith("recuperarContra.jsp")) {
					chain.doFilter(request, response);
				} else {
					rspns.sendRedirect("/gestion/");
				}
			} else if(idUsuario != null) {
				if(uri.endsWith("index.jsp")||uri.endsWith("gestion/")
						||uri.endsWith("login")||uri.endsWith("gestion")) {
					String tipo = (String) session.getAttribute("tipo");
					switch(tipo) {
						case "0": 
							rspns.sendRedirect("./solicitar.jsp");
							break;
						case "1": 
							rspns.sendRedirect("./consultarJefeArea.jsp");
							break;
						case "2": 
							rspns.sendRedirect("./consultarAnalista.jsp");
							break;
						case "3": 
							rspns.sendRedirect("./consultarJefeGestion.jsp");
							break;
						case "4": 
							rspns.sendRedirect("./consultarSubdirector.jsp");
							break;
					}
				} else {
					chain.doFilter(request, response);
				}
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
