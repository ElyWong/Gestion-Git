package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import pool.TestPool;

public class Consultas {
	
	private TestPool operador=new TestPool();
	public Consultas(){
		
	}
	private String queryAnteriores(String boleta){
		String q="Select fecha, tipo, motivo, status from solicitud s, documento d where s.status=iniciada or status="+boleta+";";
		return q;
	}
	private String queryUbicacion(double latitud, double longitud){
		String q="Select nombre, estado, descripcion from pueblosmagicos where latitud="+latitud+"and longitud="+longitud+";";
		System.out.println(q);
		return q;
	}
	private String queryEliminarNegocio(String id){
		String q="Delete from negocio where idnegocio="+id+";";
		return q;
	}
	private String querySelect(String xml, String id){
		String q="Update t00figuras set xml='"+xml+"' where idt00figuras="+id+";";
		System.out.println(q);
		return q;
	}
	
	public void eliminarTupla(String id) throws SQLException {
		operador.ejecutarSR(queryEliminarNegocio(id));
	}
	public String getDatos(String id) throws SQLException{
		ArrayList<String> lista;
		lista=operador.ejecutar(queryAnteriores(id));
		lista.add(id);
		return lista.get(0);
	}
	public void update(String xml, String id) throws SQLException{
		operador.ejecutarSR(querySelect(xml,id));
	}
	
	public String getTabla(double latitud, double longitud) throws SQLException{
		ArrayList<String> lista;
		lista=operador.ejecutar(queryUbicacion(latitud, longitud));
		String res="";
		if(lista!=null){
			int i;
			res="<tr><th>Nombre</th><th>Fecha</th><th></th><th>Operaciones</th></tr>";
			 for (i = 0; i <lista.size(); i+=3) { 
				 	res+="<tr><td>"+lista.get(i)+"</td><td>"+lista.get(i+1)+"</td><td>        </td><td><a href=\\\"Consultar?id="+lista.get(i+2)+"\\\">[Consultar]</a><a href=\\\"Editar?id="+lista.get(i+2)+"\\\">[Editar]</a><a href=\\\"Eliminar?id="+lista.get(i+2)+"\\\">[Eliminar]</a></td><tr>";
			}
			System.out.println(res);
		}
		System.out.println();
		return res;
	}
	public String getNombre(String id) throws SQLException{
		ArrayList<String> lista;
		lista=operador.ejecutar("Select nombre from t00figuras where idt00figuras="+id+";");
		if(lista!=null){
			return lista.get(0);
		}
		else return null;
	}
	public void queryInsert(String nombreFig,String fecha,String xml) throws SQLException{
		String q="INSERT INTO t00figuras (nombre,fecha,xml) VALUES ('"+nombreFig+"','"+fecha+"','"+xml+"');";
		operador.ejecutarSR(q);
	}
	
	public boolean solicitarDocumento(Integer idUsuario, String motivo, String tipoDocumento) throws SQLException {
		String sql = "select status from solicitud where idAlumno=" + idUsuario + " and "
				+ "tipoDocumento='" + tipoDocumento + "';";
		ArrayList<String> lista = operador.ejecutar(sql);
		int i=0;
		if(lista != null) {
			for(String status : lista) {
				if(!status.equals("Entregada")) {
					i++;
				}
			}
		}
		System.out.println("Solicitudes: " + i);
		if(i < 1) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			sql = "insert into solicitud(motivo, status, fecha, idAlumno, tipoDocumento) "
					+ "values('" + motivo + "','Iniciada','" + 
					formatter.format(new Date()) + "'," + idUsuario + ",'" + tipoDocumento + "')";
			operador.ejecutarSR(sql);
			return true;
		}
		return false;
	}
	
	public ResultSet generarReporte(String idAnalista, String fecha) throws SQLException {
		String sql = "select s.idAlumno as Boleta, "
				+ "concat(u.ap,' ',u.am,' ',u.nombre) as Alumno, s.horaImpresion as Impresion, s.tipoDocumento as Solicitud, "
				+ "s.status as Estatus, s.folio as Folio, s.horaEntrega as Entrega, s.idAnalista2 as AnalistaE, s.idAnalista as AnalistaI from solicitud s, usuario u where "
				+ "u.idUsuario=s.idAlumno and s.status!='Iniciada' and s.fecha='" + fecha + "' and (s.idAnalista=" + idAnalista + " or s.idAnalista2=" + idAnalista + ") order by 1, 4;";
		return operador.ejecutarQuery(sql);
	}
	
	public ArrayList<String> obtenerAnalista(String idAnalista) throws SQLException {
		String sql = "select concat(ap,' ',am,' ',nombre) as Analista "
				+ "from usuario where idUsuario=" + idAnalista + ";";
		return operador.ejecutar(sql);
	}
	
	public ResultSet generarBitacora(String fecha) throws SQLException {
		String sql = "select s.fecha as Fecha, s.idAlumno as Boleta, "
				+ "concat(u.ap,' ',u.am,' ',u.nombre) as Alumno, s.horaImpresion as Impresion, s.tipoDocumento as Solicitud, "
				+ "s.status as Estatus, s.folio as Folio, s.horaEntrega as Entrega, s.idAnalista2 as Analista from solicitud s, usuario u where "
				+ "u.idUsuario=s.idAlumno and s.status!='Iniciada' and s.fecha>='" + fecha + "' order by 1, 4;";
		return operador.ejecutarQuery(sql);
	}
	
	public ArrayList<String> obtenerAnalistas(String fecha) throws SQLException {
		String sql = "select concat(u.ap,' ',u.am,' ',u.nombre) as Analista "
				+ "from solicitud s, usuario u where u.idUsuario=s.idAnalista "
				+ "and s.fecha>='" + fecha + "' order by s.fecha, s.horaImpresion;";
		return operador.ejecutar(sql);
	}
	
	public ResultSet obtenerAnalistaEntrega(String idAnalista) throws SQLException {
		String sql = "select concat(u.ap,' ',u.am,' ',u.nombre) as Analista "
				+ "from solicitud s, usuario u where u.idUsuario=s.idAnalista2 "
				+ "and s.idAnalista2>=" + idAnalista + ";";
		return operador.ejecutarQuery(sql);
	}
}
