package Modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.*;

import pool.TestPool;

public class Solicitud {
	private TestPool pool;
	private modeloXML xml = new modeloXML();

	public Solicitud() {
		// TODO Auto-generated constructor stub
		pool = new TestPool();
	}

	public String getJefeAreaTabla(String id) {
		String res = "";
		String query = "select fecha, idAlumno, tipoDocumento, motivo, status, idSolicitud from solicitud where idJefeArea = "
				+ id + " ORDER BY fecha DESC";
		try {
			ArrayList<String> lista = pool.ejecutar(query);
			res+="<tbody>";
			for (int i = 0; i < lista.size(); i++) {
				// pues magia!!!
				// Se debe poder editar!?
				res += "<tr><td>" + lista.get(i) + "</td><td>" + lista.get(++i) + "</td><td>" + lista.get(++i)
						+ "</td><td>" + lista.get(++i) + "</td><td>" + lista.get(++i) + "</td><td><a href='eliminar?id="
						+ lista.get(++i) + "'>[Eliminar]</a></td></tr>";
			}
			res+="</tbody>";
			System.out.println(res);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println(res);
		return res;
	}

	public String getEstudianteTabla(String boleta) {
		String res = "";
		String query = "select fecha, tipoDocumento, motivo, status, idSolicitud from solicitud where idAlumno = "
				+ boleta + " ORDER BY fecha DESC";
		try {
			System.out.println(query);
			ArrayList<String> lista = pool.ejecutar(query);
			res+="<tbody>";
			for (int i = 0; i < lista.size(); i++) {
				// pues magia!!!
				// Se debe poder editar!?
				res += "<tr><td>" + lista.get(i) + "</td><td>" + lista.get(++i) + "</td><td>" + lista.get(++i);
				lista.get(++i);
				res +="</td><td>" + lista.get(++i) + "</td></tr>";
			}
			res+="</tbody>";
			System.out.println(res);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(res);
		return res;
	}

	public String getAnalistaTabla(String boleta) {
		String res = "<tbody>";
		String query = "select s.idSolicitud, s.fecha, s.idAlumno, u.nombre, s.tipoDocumento, s.motivo from solicitud s, usuario u where status=\"iniciada\" and s.idAlumno=u.idUsuario ORDER BY fecha DESC";
		try {
			ArrayList<String> lista = pool.ejecutar(query);
			for (int i = 0; i < lista.size(); i++) {
				// pues magia!!!
				// Se debe poder editar!?
				res += "<tr><td><input type=\\\"checkbox\\\" name=\\\"nBoleta\\\" value=\\\"" + lista.get(i)
						+ "\\\"></td><td>" + lista.get(++i) + "</td><td>" + lista.get(++i) + "</td><td>"
						+ lista.get(++i) + "</td><td>" + lista.get(++i) + "</td><td>" + lista.get(++i) + "</td></tr>";
			}
			res += "</tbody>";
			System.out.println(res);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println(res);
		return res;
	}

	public String getAnalistaTabla1(String boleta) {
		String res = "<tbody>";
		String query = "select s.idSolicitud, s.fecha, s.idAlumno, u.nombre, s.tipoDocumento, s.motivo from solicitud s, usuario u where status=\"impresa\" and s.idAlumno=u.idUsuario ORDER BY fecha DESC";
		System.out.println(query);
		try {
			ArrayList<String> lista = pool.ejecutar(query);
			for (int i = 0; i < lista.size(); i++) {
				// pues magia!!!
				// Se debe poder editar!?
				res += "<tr><td><input type=\\\"checkbox\\\" name=\\\"nBoleta\\\" value=\\\"" + lista.get(i)
						+ "\\\"></td><td>" + lista.get(++i) + "</td><td>" + lista.get(++i) + "</td><td>"
						+ lista.get(++i) + "</td><td>" + lista.get(++i) + "</td><td>" + lista.get(++i) + "</td></tr>";
			}
			res += "</tbody>";
			System.out.println(res);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println(res);
		return res;
	}

	public String getAnalistaTabla2(String boleta) {
		String res = "<tbody>";
		String query = "select s.idSolicitud, s.fecha, s.idAlumno, u.nombre, s.tipoDocumento, s.motivo from solicitud s, usuario u where status=\"enFirma\" and s.idAlumno=u.idUsuario ORDER BY fecha DESC";
		System.out.println(query);
		try {
			ArrayList<String> lista = pool.ejecutar(query);
			for (int i = 0; i < lista.size(); i++) {
				// pues magia!!!
				// Se debe poder editar!?
				res += "<tr><td><input type=\\\"checkbox\\\" name=\\\"nBoleta\\\" value=\\\"" + lista.get(i)
						+ "\\\"></td><td>" + lista.get(++i) + "</td><td>" + lista.get(++i) + "</td><td>"
						+ lista.get(++i) + "</td><td>" + lista.get(++i) + "</td><td>" + lista.get(++i) + "</td></tr>";
			}res += "</tbody>";
			System.out.println(res);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println(res);
		return res;
	}

	public String getAnalistaTabla3(String boleta) {
		
		String res = "<tbody>";
		String query = "select s.idSolicitud, s.fecha, s.idAlumno, u.nombre, s.tipoDocumento, s.motivo from solicitud s, usuario u where status=\"lista\" and s.idAlumno=u.idUsuario ORDER BY fecha DESC";
		System.out.println(query);
		String noBoleta;
		try {
			ArrayList<String> lista = pool.ejecutar(query);
			for (int i = 0; i < lista.size(); i++) {
				noBoleta = lista.get(i);
				res += "<tr><td><input type=\\\"checkbox\\\" name=\\\"nBoleta\\\" value=\\\"" + lista.get(i)
						+ "\\\"></td><td>" + lista.get(++i) + "</td><td>" + lista.get(++i) + "</td><td>"
						+ lista.get(++i) + "</td><td>" + lista.get(++i) + "</td><td>" + lista.get(++i) + "</td>"
								+ "<td><input type=\\\"number\\\" name=\\\"" + noBoleta +"\\\"></td></tr>";
			}
			res += "</tbody>";
			System.out.println(res);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println(res);
		return res;
	}

	public int actualizarEstado(String solicitud, String usuario, String status) {
		Calendar fecha = new GregorianCalendar();
		// Obtenemos el valor del año, mes, día,
		// hora, minuto y segundo del sistema
		// usando el método get y el parámetro correspondiente
		int hora = fecha.get(Calendar.HOUR_OF_DAY);
		int minuto = fecha.get(Calendar.MINUTE);
		int segundo = fecha.get(Calendar.SECOND);
		String tiempo = hora + ":" + minuto + ":" + segundo;
		int dia = fecha.get(Calendar.DATE);
		int mes = fecha.get(Calendar.MONTH) + 1;
		int annio = fecha.get(Calendar.YEAR);
		if (status.trim().equals("impresa")) {
			String q = "update solicitud set ";
			int r = 0;
			q += "status ='" + status + "', ";
			q += "idAnalista =" + usuario;
			q += ", horaImpresion='" + tiempo + "'";
			q += ", fecha='" + annio + "-" + mes + "-" + dia + "'";
			q += " where idSolicitud=" + solicitud + ";";
			System.out.println(q);
			try {
				r = pool.ejecutarSR(q);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return r;
		} else if (status.trim().equals("entregada")) {
			String q = "update solicitud set ";
			int r = 0;
			q += "status ='" + status + "', ";
			q += "idAnalista2 =" + usuario;
			q += ", horaEntrega='" + tiempo + "'";
			q += ", fechaEntrega='" + annio + "-" + mes + "-" + dia + "'";
			q += " where idSolicitud=" + solicitud + ";";
			System.out.println(q);
			try {
				r = pool.ejecutarSR(q);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return r;
		} else {
			String q = "update solicitud set ";
			int r = 0;
			q += "status ='" + status + "'";
			q += " where idSolicitud=" + solicitud + ";";
			System.out.println(q);
			try {
				r = pool.ejecutarSR(q);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return r;

		}
	}
	
	public void actualizarFolio(String solicitud, String folio) throws SQLException {
		String sql = "update solicitud set folio=" + folio 
				+ " where idSolicitud=" + solicitud + ";";
		pool.ejecutarSR(sql);
	}

	
}
