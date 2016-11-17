package controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.BusquedaDatos;

/**
 * Servlet implementation class ObtenerDatos
 */
@WebServlet("/ObtenerDatos")
public class ObtenerDatos extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ObtenerDatos() {
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
		String fecha1=request.getParameter("fecha1");
		System.out.println(fecha1);
		String fecha2=request.getParameter("fecha2");
		System.out.println(fecha2);
		String principal=request.getParameter("principal");
		System.out.println("el principal es: "+principal);
		String tipodoc=request.getParameter("tipodoc");
		String estadodoc=request.getParameter("estadodoc");
		String motivodoc=request.getParameter("motivodoc");
		String tipousu=request.getParameter("tipousu");
		String nomanalista=request.getParameter("nomanalista");
		String nivelalu=request.getParameter("nivelalu");
		ArrayList<String> where=new ArrayList<String>();
		ArrayList<String> data=new ArrayList<String>();
		ArrayList<String> regreso=new ArrayList<String>();
		if(principal.equals("a")){
			if(estadodoc!=null){
				if(!estadodoc.equals("todos")){
					where.add(estadodoc);
					data.add("status");
				}
			}
			System.out.println(tipodoc);
			if(tipodoc!=null){
				if(!tipodoc.equals("todos")){
					where.add(tipodoc);
					data.add("tipoDocumento");
					regreso=busd.tipoDocumentoNoTodos(where, data, fecha1, fecha2);
					request.getSession().setAttribute("tablaBusqueda", regreso.get(0));
					for(int i=0;i<regreso.size()-1;i++){
						request.getSession().setAttribute("tdnt", regreso.get(i+1));
					}
					response.sendRedirect("estadistica.jsp");
				}
				else{
					regreso=busd.tipoDocumentoTodos(where, data, fecha1, fecha2);
					System.out.println(regreso.get(0));
					request.getSession().setAttribute("tablaBusqueda", regreso.get(0));
					for(int i=0;i<regreso.size()-1;i++){
						request.getSession().setAttribute("tdt"+i, regreso.get(i+1));
					}
					response.sendRedirect("estadistica.jsp");
				}
			}
			else{
				regreso=busd.tipoDocumentoTodos(where, data, fecha1, fecha2);
				System.out.println(regreso.get(0));
				request.getSession().setAttribute("tablaBusqueda", regreso.get(0));
				for(int i=0;i<regreso.size()-1;i++){
					request.getSession().setAttribute("tdt"+i, regreso.get(i+1));
				}
				response.sendRedirect("estadistica.jsp");
			}
			System.out.println(estadodoc);
			
			//funcion a la que le mando el where
			
		}
		else if(principal.equals("b")){
			System.out.println(tipodoc);
			if(tipodoc!=null){
				if(!tipodoc.equals("todos")){
					where.add(tipodoc);
					data.add("tipoDocumento");
				}
			}
			System.out.println(motivodoc);
			if(motivodoc!=null){
				if(!motivodoc.equals("todos")){
					where.add(motivodoc);
					data.add("motivo");regreso=busd.motivoNoTodos(where, data, fecha1, fecha2);
					request.getSession().setAttribute("tablaBusqueda", regreso.get(0));
					for(int i=0;i<regreso.size()-1;i++){
						request.getSession().setAttribute("tdnt", regreso.get(i+1));
					}
					response.sendRedirect("estadistica.jsp");
				}
				else{
					regreso=busd.motivoTodos(where, data, fecha1, fecha2);
					System.out.println(regreso.get(0));
					request.getSession().setAttribute("tablaBusqueda", regreso.get(0));
					for(int i=0;i<regreso.size()-1;i++){
						request.getSession().setAttribute("tdt"+i, regreso.get(i+1));
					}
					response.sendRedirect("estadistica.jsp");
				}
			}
			else{
				regreso=busd.motivoTodos(where, data, fecha1, fecha2);
				System.out.println(regreso.get(0));
				request.getSession().setAttribute("tablaBusqueda", regreso.get(0));
				for(int i=0;i<regreso.size()-1;i++){
					request.getSession().setAttribute("tdt"+i, regreso.get(i+1));
				}
				response.sendRedirect("estadistica.jsp");
			}	
			
			
			//funcion a la que le mando el where
			
		}else if(principal.equals("c")){
			if(tipodoc!=null){
				if(!tipodoc.equals("todos")){
					where.add(tipodoc);
					data.add("tipoDocumento");
				}
			}
			System.out.println(motivodoc);
			if(motivodoc!=null){
				if(!motivodoc.equals("todos")){
					where.add(motivodoc);
					data.add("motivo");
				}
			}
			System.out.println(tipousu);
			if(tipousu.equals("1")){//analista
				System.out.println(nomanalista);
				if(nomanalista!=null){
					if(!nomanalista.equals("todos")){
						where.add(nomanalista);
						data.add("idanalista");
						regreso=busd.analistaNoTodos(where, data, fecha1, fecha2);
						request.getSession().setAttribute("tablaBusqueda", regreso.get(0));
						for(int i=0;i<regreso.size()-1;i++){
							request.getSession().setAttribute("ant", regreso.get(i+1));
						}
						response.sendRedirect("estadistica.jsp");
					}
					else{
						regreso=busd.analistaTodos(where, data, fecha1, fecha2);
						System.out.println(regreso.get(0));
						request.getSession().setAttribute("tablaBusqueda", regreso.get(0));
						for(int i=0;i<regreso.size()-1;i++){
							request.getSession().setAttribute("at"+i, regreso.get(i+1));
						}
						response.sendRedirect("estadistica.jsp");
					}
				}
				else{
					regreso=busd.analistaTodos(where, data, fecha1, fecha2);
					System.out.println(regreso.get(0));
					request.getSession().setAttribute("tablaBusqueda", regreso.get(0));
					for(int i=0;i<regreso.size()-1;i++){
						request.getSession().setAttribute("at"+i, regreso.get(i+1));
					}
					response.sendRedirect("estadistica.jsp");
				}
			}
			else{//alumno
				System.out.println(nivelalu);
				if(nivelalu!=null){
					if(!nivelalu.equals("todos")){
						where.add(nivelalu);
						data.add("nivel");
						regreso=busd.alumnoNoTodos(where, data, fecha1, fecha2);
						request.getSession().setAttribute("tablaBusqueda", regreso.get(0));
						for(int i=0;i<regreso.size()-1;i++){
							request.getSession().setAttribute("alnt", regreso.get(i+1));
						}
						response.sendRedirect("estadistica.jsp");
					}
					else{
						regreso=busd.alumnoTodos(where, data, fecha1, fecha2);
						System.out.println(regreso.get(0));
						request.getSession().setAttribute("tablaBusqueda", regreso.get(0));
						for(int i=0;i<regreso.size()-1;i++){
							request.getSession().setAttribute("alt"+i, regreso.get(i+1));
						}
						response.sendRedirect("estadistica.jsp");
					}
				}
				else{
					regreso=busd.alumnoTodos(where, data, fecha1, fecha2);
					System.out.println(regreso.get(0));
					request.getSession().setAttribute("tablaBusqueda", regreso.get(0));
					for(int i=0;i<regreso.size()-1;i++){
						request.getSession().setAttribute("alt"+i, regreso.get(i+1));
					}
					response.sendRedirect("estadistica.jsp");
				}
			}
		}
	}

}
