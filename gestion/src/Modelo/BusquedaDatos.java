package Modelo;

import java.sql.SQLException;
import java.util.ArrayList;

import pool.TestPool;

public class BusquedaDatos {

	public BusquedaDatos() {
		tp= new TestPool();
	}
	String usu, pass, correo, newPass;
	TestPool tp;
	public ArrayList<String> tipoDocumentoTodos(ArrayList<String> where,ArrayList<String> data, String fecha1, String fecha2){
		ArrayList<String> lista=new ArrayList<String>();
		ArrayList<String> lista2=new ArrayList<String>(); 
		ArrayList<String> listaAux=new ArrayList<String>();
		ArrayList<String> sentencias=new ArrayList<String>();
		String tabla, total, q, qt=new String();
		
		try {
			if(where.size()!=0){
				lista=tp.ejecutar("select count(*) from solicitud where fecha >= '"+fecha1+"' and fecha <= '"+fecha2+"' and "+data.get(0)+" = '"+where.get(0)+"'");
			}
			else{
				lista=tp.ejecutar("select count(*) from solicitud where fecha >= '"+fecha1+"' and fecha <= '"+fecha2+"'");
			}
			total=lista.get(0);
			lista.clear();
			lista=tp.ejecutar("select distinct tipoDocumento from solicitud");
			for(int i=0;i<lista.size();i++){
				q="select count(*) ";
				qt="from solicitud where tipoDocumento='"+lista.get(i)+"' and fecha >= '"+fecha1+"' and fecha <= '"+fecha2+"'";
				if(where.size()!=0){
					qt+=" and "+data.get(0)+" = '"+where.get(0)+"'";
				}
				sentencias.add(qt);
				q+=qt;
				System.out.println(q);
				listaAux=tp.ejecutar(q);
				lista2.add(listaAux.get(0));
				listaAux.clear();
			}
			tabla="<tr><td>n�mero de solicitudes</td><td>tipo de documento</td> <td>ver todas</td><td>Fecha inicio</td><td>Fecha final</td></tr>";
			for(int i=0;i<lista.size();i++){
				//pues magia!!!
				//Se debe poder editar!?
				tabla+="<tr> <td>"+lista2.get(i)+"</td>"
						+ "<td>"+lista.get(i)+"</td>"
							+ "<td><input type=\"submit\" name=\"sec\" value=\"tdt"+i+"\"></td>"
								+ "<td>"+fecha1+"</td><td>"+fecha2+"</td></tr>";
			}
			tabla+="<tr><td>"+total+"</td><td></td><td></td><td></td><td></td></tr>";
			listaAux.add(tabla);
			for(int i=0;i<sentencias.size();i++){
				listaAux.add(sentencias.get(i));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return listaAux;
	}
	public ArrayList<String> tipoDocumentoNoTodos(ArrayList<String> where,ArrayList<String> data, String fecha1, String fecha2){
		ArrayList<String> lista=new ArrayList<String>();
		ArrayList<String> listaAux=new ArrayList<String>();
		ArrayList<String> sentencias=new ArrayList<String>();
		String tabla, q, qt=new String();
		
		try {
			if(where.size()>1){
				q="select count(*)";
				qt=" from solicitud where fecha >= '"+fecha1+"' and fecha <= '"+fecha2+"' and "+data.get(0)+" = '"+where.get(0)+"' and "+data.get(1)+" = '"+where.get(1)+"'";
			}
			else{
				q="select count(*) ";
				qt="from solicitud where fecha >= '"+fecha1+"' and fecha <= '"+fecha2+"' and "+data.get(0)+" = '"+where.get(0)+"'";
				
			}
			q+=qt;
			sentencias.add(qt);
			lista=tp.ejecutar(q);
			tabla="<tr><td>n�mero de solicitudes</td><td>tipo de documento</td> <td>ver todas</td><td>Fecha inicio</td><td>Fecha final</td></tr>";
			if(where.size()>1){
				//pues magia!!!
				//Se debe poder editar!?
				tabla+="<tr> <td>"+lista.get(0)+"</td>"
						+ "<td>"+where.get(where.size()-1)+"</td>"
							+ "<td><input type=\"submit\" name=\"sec\" value=\"tdnt\"></td>"
								+ "<td>"+fecha1+"</td><td>"+fecha2+"</td></tr>";
			}
			listaAux.add(tabla);
			for(int i=0;i<sentencias.size();i++){
				listaAux.add(sentencias.get(i));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return listaAux;
	}
	public ArrayList<String> motivoTodos(ArrayList<String> where,ArrayList<String> data, String fecha1, String fecha2){
		ArrayList<String> lista=new ArrayList<String>();
		ArrayList<String> lista2=new ArrayList<String>(); 
		ArrayList<String> listaAux=new ArrayList<String>();
		ArrayList<String> sentencias=new ArrayList<String>();
		String tabla, total, q, qt=new String();
		
		try {
			if(where.size()!=0){
				lista=tp.ejecutar("select count(*) from solicitud where fecha >= '"+fecha1+"' and fecha <= '"+fecha2+"' and "+data.get(0)+" = '"+where.get(0)+"'");
			}
			else{
				lista=tp.ejecutar("select count(*) from solicitud where fecha >= '"+fecha1+"' and fecha <= '"+fecha2+"'");
			}
			total=lista.get(0);
			lista.clear();
			lista=tp.ejecutar("select distinct motivo from solicitud");
			for(int i=0;i<lista.size();i++){
				q="select count(*) ";
				qt="from solicitud where motivo='"+lista.get(i)+"' and fecha >= '"+fecha1+"' and fecha <= '"+fecha2+"'";
				if(where.size()!=0){
					qt+=" and "+data.get(0)+" = '"+where.get(0)+"'";
				}
				sentencias.add(qt);
				q+=qt;
				System.out.println(q);
				listaAux=tp.ejecutar(q);
				lista2.add(listaAux.get(0));
				listaAux.clear();
			}
			tabla="<tr><td>n�mero de solicitudes</td><td>motivo del documento</td> <td>ver todas</td><td>Fecha inicio</td><td>Fecha final</td></tr>";
			for(int i=0;i<lista.size();i++){
				//pues magia!!!
				//Se debe poder editar!?
				tabla+="<tr> <td>"+lista2.get(i)+"</td>"
						+ "<td>"+lista.get(i)+"</td>"
							+ "<td><input type=\"submit\" name=\"sec\" value=\"mt"+i+"\"></td>"
								+ "<td>"+fecha1+"</td><td>"+fecha2+"</td></tr>";
			}
			tabla+="<tr><td>"+total+"</td><td></td><td></td><td></td><td></td></tr>";
			listaAux.add(tabla);
			for(int i=0;i<sentencias.size();i++){
				listaAux.add(sentencias.get(i));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return listaAux;
	}
	public ArrayList<String> motivoNoTodos(ArrayList<String> where,ArrayList<String> data, String fecha1, String fecha2){
		ArrayList<String> lista=new ArrayList<String>();
		ArrayList<String> listaAux=new ArrayList<String>();
		ArrayList<String> sentencias=new ArrayList<String>();
		String tabla, q, qt=new String();
		
		try {
			q="select count(*)";
			if(where.size()>1){
				qt=" from solicitud where fecha >= '"+fecha1+"' and fecha <= '"+fecha2+"' and "+data.get(0)+" = '"+where.get(0)+"' and "+data.get(1)+" = '"+where.get(1)+"'";
			}
			else{
				
				qt=" from solicitud where fecha >= '"+fecha1+"' and fecha <= '"+fecha2+"' and "+data.get(0)+" = '"+where.get(0)+"'";
				
			}
			q+=qt;
			sentencias.add(qt);
			lista=tp.ejecutar(q);
			tabla="<tr><td>n�mero de solicitudes</td><td>motivo del documento</td> <td>ver todas</td><td>Fecha inicio</td><td>Fecha final</td></tr>";
			if(where.size()>1){
				//pues magia!!!
				//Se debe poder editar!?
				tabla+="<tr> <td>"+lista.get(0)+"</td>"
						+ "<td>"+where.get(where.size()-1)+"</td>"
							+ "<td><input type=\"submit\" name=\"sec\" value=\"mnt\"></td>"
								+ "<td>"+fecha1+"</td><td>"+fecha2+"</td></tr>";
			}
			listaAux.add(tabla);
			for(int i=0;i<sentencias.size();i++){
				listaAux.add(sentencias.get(i));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return listaAux;
	}
	public ArrayList<String> analistaTodos(ArrayList<String> where,ArrayList<String> data, String fecha1, String fecha2){
		ArrayList<String> lista=new ArrayList<String>();
		ArrayList<String> lista2=new ArrayList<String>(); 
		ArrayList<String> listaNom=new ArrayList<String>(); 
		ArrayList<String> listaAux=new ArrayList<String>();
		ArrayList<String> sentencias=new ArrayList<String>();
		String tabla, total, q, qt=new String();
		
		try {
			q="select count(*) ";
			qt="from solicitud where fecha >= '"+fecha1+"' and fecha <= '"+fecha2+"'";
			for(int i=0;i<where.size()-1;i++){
				qt+=" and "+data.get(0)+" = '"+where.get(0)+"'";	
			
			}
			qt+=" and idAnalista IS NOT NULL";
			q+=qt;
			System.out.println(q);
			lista=tp.ejecutar(q);
			total=lista.get(0);
			lista.clear();
			lista=tp.ejecutar("select distinct idAnalista from solicitud where idAnalista IS NOT NULL");
			for(int i=0;i<lista.size();i++){
				q="select count(*) ";
				qt="from solicitud where idAnalista='"+lista.get(i)+"' and fecha >= '"+fecha1+"' and fecha <= '"+fecha2+"'";
				if(where.size()!=0){
					qt+=" and "+data.get(0)+" = '"+where.get(0)+"'";
				}
				sentencias.add(qt);
				q+=qt;
				System.out.println(q);
				listaAux=tp.ejecutar(q);
				lista2.add(listaAux.get(0));
				listaAux.clear();
			}
			for(int i=0;i<lista.size();i++){
				q="select nombre from usuario where idUsuario = '"+lista.get(i)+"'";
				System.out.println(q);
				listaAux=tp.ejecutar(q);
				listaNom.add(listaAux.get(0));
				listaAux.clear();
			}
			tabla="<tr><td>n�mero de solicitudes</td><td>Analista</td> <td>ver todas</td><td>Fecha inicio</td><td>Fecha final</td></tr>";
			for(int i=0;i<lista.size();i++){
				//pues magia!!!
				//Se debe poder editar!?
				tabla+="<tr> <td>"+lista2.get(i)+"</td>"
						+ "<td>"+listaNom.get(i)+"</td>"
							+ "<td><input type=\"submit\" name=\"sec\" value=\"at"+i+"\"></td>"
								+ "<td>"+fecha1+"</td><td>"+fecha2+"</td></tr>";
			}
			tabla+="<tr><td>"+total+"</td><td></td><td></td><td></td><td></td></tr>";
			listaAux.add(tabla);
			for(int i=0;i<sentencias.size();i++){
				listaAux.add(sentencias.get(i));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return listaAux;
	}
	public ArrayList<String> analistaNoTodos(ArrayList<String> where,ArrayList<String> data, String fecha1, String fecha2){
		ArrayList<String> lista=new ArrayList<String>();
		ArrayList<String> listaAux=new ArrayList<String>();
		ArrayList<String> sentencias=new ArrayList<String>();
		String tabla, q, qt=new String();
		
		try {
			if(where.size()>2){
				q="select count(*)";
				qt=" from solicitud where fecha >= '"+fecha1+"' and fecha <= '"+fecha2+"' and "+data.get(0)+" = '"+where.get(0)+"' and "+data.get(1)+" = '"+where.get(1)+"' and "+data.get(2)+" = "+where.get(2)+" and idAnalista IS NOT NULL";
			}
			else if(where.size()>1){
				q="select count(*) ";
				qt="from solicitud where fecha >= '"+fecha1+"' and fecha <= '"+fecha2+"' and "+data.get(0)+" = '"+where.get(0)+"' and "+data.get(1)+" = "+where.get(1)+" and idAnalista IS NOT NULL";
				
			}
			else{
				q="select count(*) ";
				qt="from solicitud where fecha >= '"+fecha1+"' and fecha <= "+fecha2+" and "+data.get(0)+" = "+where.get(0)+" and idAnalista IS NOT NULL";
			}
			q+=qt;
			sentencias.add(qt);
			lista=tp.ejecutar(q);
			q="select nombre from usuario where idUsuario = '"+where.get(where.size()-1)+"'";
			System.out.println(q);
			listaAux=tp.ejecutar(q);
			tabla="<tr><td>n�mero de solicitudes</td><td>Analista</td> <td>ver todas</td><td>Fecha inicio</td><td>Fecha final</td></tr>";
			if(where.size()>1){
				//pues magia!!!
				//Se debe poder editar!?
				tabla+="<tr> <td>"+lista.get(0)+"</td>"
						+ "<td>"+listaAux.get(0)+"</td>"
							+ "<td><input type=\"submit\" name=\"sec\" value=\"ant\"></td>"
								+ "<td>"+fecha1+"</td><td>"+fecha2+"</td></tr>";
			}
			listaAux.clear();
			listaAux.add(tabla);
			for(int i=0;i<sentencias.size();i++){
				listaAux.add(sentencias.get(i));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return listaAux;
	}
	public ArrayList<String> alumnoTodos(ArrayList<String> where,ArrayList<String> data, String fecha1, String fecha2){
		ArrayList<String> lista=new ArrayList<String>();
		ArrayList<String> lista2=new ArrayList<String>(); 
		ArrayList<String> listaNom=new ArrayList<String>(); 
		ArrayList<String> listaAux=new ArrayList<String>();
		ArrayList<String> sentencias=new ArrayList<String>();
		String tabla, total, q, qt=new String();
		
		try {
			q="select count(*)";
			qt=" from solicitud where fecha >= '"+fecha1+"' and fecha <= '"+fecha2+"'";
			for(int i=0;i<where.size()-1;i++){
				qt+=" and "+data.get(i)+" = '"+where.get(i)+"'";	
			
			}
			q+=qt;
			lista=tp.ejecutar(q);
			total=lista.get(0);
			lista.clear();
			lista=tp.ejecutar("select distinct nivel from alumno where nivel is not null");
			for(int i=0;i<lista.size();i++){
				q="select count(*)";
				qt=" from solicitud, alumno where alumno.boleta=solicitud.idAlumno and alumno.nivel='"+lista.get(i)+"' and fecha >= '"+fecha1+"' and fecha <= '"+fecha2+"'";
				for(int j=0;j<where.size()-1;j++){
					qt=" and "+data.get(j)+" = '"+where.get(j)+"'";	
				
				}
				sentencias.add(qt);
				q+=qt;
				System.out.println(q);
				listaAux=tp.ejecutar(q);
				lista2.add(listaAux.get(0));
				listaAux.clear();
			}
			tabla="<tr><td>n�mero de solicitudes</td><td>nivel</td> <td>ver todas</td><td>Fecha inicio</td><td>Fecha final</td></tr>";
			for(int i=0;i<lista.size();i++){
				//pues magia!!!
				//Se debe poder editar!?
				tabla+="<tr> <td>"+lista2.get(i)+"</td>"
						+ "<td>"+lista.get(i)+"</td>"
							+ "<td><input type=\"submit\" name=\"sec\" value=\"alt"+i+"\"></td>"
								+ "<td>"+fecha1+"</td><td>"+fecha2+"</td></tr>";
			}
			tabla+="<tr><td>"+total+"</td><td></td><td></td><td></td><td></td></tr>";
			listaAux.add(tabla);
			for(int i=0;i<sentencias.size();i++){
				listaAux.add(sentencias.get(i));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return listaAux;
	}
	public ArrayList<String> alumnoNoTodos(ArrayList<String> where,ArrayList<String> data, String fecha1, String fecha2){
		ArrayList<String> lista=new ArrayList<String>();
		ArrayList<String> listaAux=new ArrayList<String>();
		ArrayList<String> sentencias=new ArrayList<String>();
		String tabla, q, qt=new String();
		
		try {
			q="select count(*)";
			if(where.size()>2){
				
				qt=" from alumno, solicitud where alumno.boleta=solicitud.idAlumno and fecha >= '"+fecha1+"' and fecha <= '"+fecha2+"' and "+data.get(0)+" = '"+where.get(0)+"' and "+data.get(1)+" = '"+where.get(1)+"' and "+data.get(2)+" = "+where.get(2)+"";
			}
			else if(where.size()>1){
				qt=" from alumno, solicitud where alumno.boleta=solicitud.idAlumno and fecha >= '"+fecha1+"' and fecha <= '"+fecha2+"' and "+data.get(0)+" = '"+where.get(0)+"' and "+data.get(1)+" = "+where.get(1)+"";
				
			}
			else{
				qt=" from solicitud where alumno.boleta=solicitud.idAlumno and fecha >= '"+fecha1+"' and fecha <= "+fecha2+" and "+data.get(0)+" = "+where.get(0)+"";
			}
			q+=qt;
			sentencias.add(qt);
			System.out.println(q);
			lista=tp.ejecutar(q);
			q="select nombre from usuario where idUsuario = '"+where.get(where.size()-1)+"'";
			System.out.println(q);
			listaAux=tp.ejecutar(q);
			tabla="<tr><td>n�mero de solicitudes</td><td>nivel</td> <td>ver todas</td><td>Fecha inicio</td><td>Fecha final</td></tr>";
			if(where.size()>1){
				//pues magia!!!
				//Se debe poder editar!?
				tabla+="<tr> <td>"+lista.get(0)+"</td>"
						+ "<td>"+where.get(where.size()-1)+"</td>"
							+ "<td><input type=\"submit\" name=\"sec\" value=\"alnt\"></td>"
								+ "<td>"+fecha1+"</td><td>"+fecha2+"</td></tr>";
			}
			listaAux.clear();
			listaAux.add(tabla);
			for(int i=0;i<sentencias.size();i++){
				listaAux.add(sentencias.get(i));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return listaAux;
	}
}