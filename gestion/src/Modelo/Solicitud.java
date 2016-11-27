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
	

}
