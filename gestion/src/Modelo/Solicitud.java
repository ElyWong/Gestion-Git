package Modelo;

import java.sql.SQLException;
import java.util.ArrayList;

import pool.TestPool;

public class Solicitud {
	private TestPool pool;
	private modeloXML xml= new modeloXML();
	public Solicitud() {
		// TODO Auto-generated constructor stub
		pool= new TestPool();
	}
	public String getJefeAreaTabla(String id){
		String res="";
		String query="select fecha, idAlumno, tipoDocumento, motivo, status, idSolicitud from solicitud where idJefeArea = "+id+" ORDER BY fecha DESC";
		try {
			ArrayList<String> lista=pool.ejecutar(query);
			for(int i=0;i<lista.size();i++){
				//pues magia!!!
				//Se debe poder editar!?
				res+="<tr><td>"+lista.get(i)+"</td><td>"+lista.get(++i)+"</td><td>"+lista.get(++i)+"</td><td>"+lista.get(++i)+"</td><td>"+lista.get(++i)+"</td><td><a href='eliminar?id="+lista.get(++i)+"'>[Eliminar]</a></td></tr>";
			}
			System.out.println(res);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(res);
		return res;
	}

	public String getEstudianteTabla(String boleta){
		String res="";
		String query="select fecha, tipoDocumento, motivo, status, idSolicitud from solicitud where idAlumno = "+boleta+" ORDER BY fecha DESC";
		try {
			System.out.println(query);
			ArrayList<String> lista=pool.ejecutar(query);
			for(int i=0;i<lista.size();i++){
				//pues magia!!!
				//Se debe poder editar!?
				res+="<tr><td>"+lista.get(i)+"</td><td>"+lista.get(++i)+"</td><td>"+lista.get(++i)+"</td><td>"+lista.get(++i)+"</td><td><a href='eliminar?id="+lista.get(++i)+"'>[Eliminar]</a></td></tr>";
			}
			System.out.println(res);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(res);
		return res;
	}
	
	public String getAnalistaTabla(String boleta){
		String res="";
		String query="select idSolicitud, fecha, idAlumno, tipoDocumento, motivo, status from solicitud ORDER BY fecha DESC";
		try {
			ArrayList<String> lista=pool.ejecutar(query);
			for(int i=0;i<lista.size();i++){
				//pues magia!!!
				//Se debe poder editar!?
				res+="<tr><td><input type=\\\"checkbox\\\" name=\\\"nBoleta\\\" value=\\\""+lista.get(i)+"\\\"></td><td>"+lista.get(++i)+"</td><td>"+lista.get(++i)+"</td><td>"+lista.get(++i)+"</td><td>"+lista.get(++i)+"</td><td>"+lista.get(++i)+"</td></tr>";
			}
			System.out.println(res);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(res);
		return res;
	}
	
	public int actualizarEstado(String solicitud, String usuario, String status){
		String q="update solicitud set ";
		int r=0;
		q+="status ='"+status+"', ";
		q+="idAnalista ="+usuario;
		q+=" where idSolicitud="+solicitud+";";
		System.out.println(q);
		try {
			r= pool.ejecutarSR(q);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}
	public int actualizarGrafica(String path){
		String q;
		int r=0;
		try {
			q="select distinct motivo from solicitud";
			ArrayList<String> lista=pool.ejecutar(q);
			ArrayList<String> lista2=new ArrayList<String>(); 
			ArrayList<String> listaAux=new ArrayList<String>(); 
			for(int i=0;i<lista.size();i++){
				q="select count(*) from solicitud where motivo='"+lista.get(i)+"'";
				listaAux=pool.ejecutar(q);
				lista2.add(listaAux.get(0));
				listaAux.clear();
			}
			xml.crearMotivo(path, lista, lista2);
			//agregar lista 1 y 2 al generador xml de motivo
			q="select distinct tipoDocumento from solicitud";
			lista.clear();
			lista2.clear();
			listaAux.clear();
			lista=pool.ejecutar(q);
			for(int i=0;i<lista.size();i++){
				q="select count(*) from solicitud where tipoDocumento='"+lista.get(i)+"'";
				listaAux=pool.ejecutar(q);
				lista2.add(listaAux.get(0));
				listaAux.clear();
			}
			xml.crearDocumento(path, lista, lista2);
			//agregar lista 1 y 2 al generador xml de tipoDocumento
			q="select * from analista";
			lista.clear();
			lista2.clear();
			listaAux.clear();
			lista=pool.ejecutar(q);
			for(int i=0;i<lista.size();i++){
				q="select nombre from usuario where idUsuario='"+lista.get(i)+"'";
				listaAux=pool.ejecutar(q);
				lista2.add(listaAux.get(0));
				listaAux.clear();
				q="select count(*) from solicitud where idAnalista='"+lista.get(i)+"'";
				listaAux=pool.ejecutar(q);
				lista2.add(listaAux.get(0));
				listaAux.clear();
			}
			xml.crearTrabajo(path, lista2);
			//agregar lista 2 al generador xml de trabajoAnalista
			
			r=1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(res);
		return r;
	}

}
