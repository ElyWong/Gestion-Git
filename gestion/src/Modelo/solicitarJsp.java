package Modelo;

public class solicitarJsp {
	public solicitarJsp() {

	}

	public String armarMenu(int tipo) {
		String menu = null;
		if (tipo == 0)
			menu = "<li ><a href=\"consultarEstudiante.jsp\">Consultar solicitudes</a></li><li class=\"active\"><a href=\"solicitar.jsp\">Solicitar tr�mite</a></li><li><a href=\"logout\">Cerrar sesi�n</a></li>";
		else {
			if (tipo == 1)
				menu = "<li ><a href=\"consultarJefeArea.jsp\">Consultar solicitudes</a></li><li class=\"active\"><a href=\"solicitarJefeArea\">Solicitar tr�mite</a></li><li><a href=\"logout\">Cerrar sesi�n</a></li>";
			else {
				if (tipo == 2)
					menu = "<li ><a href=\"consultarAnalista.jsp\">Consultar solicitudes</a></li><li class=\"active\"><a href=\"solicitar.jsp\">Registrar tr�mite</a></li><li><a href=\"reporteAnalista.jsp\">Generar reporte de turno</a></li><li><a href=\"bitacoraAnalista.jsp\">Generar bit�cora</a></li><li><a href=\"logout\">Cerrar sesi�n</a></li>";
				else {
					if (tipo == 3)
						menu = "";
				}
			}
		}
		return menu;
	}

	public String armarFormulario(int tipo) {
		String form = null;
		if (tipo == 0)
			form = "<h3 align=\"center\">Todos los campos son obligatorios, verificalos antes de realizar el registro de la solicitud.</h3><br><br><form id=\"solicitar\" action=\"SolicitarEstudiante\" method=\"post\" align=\"center\">"
					+ "Tipo de documento:<select name=\"tipodoc\" id=\"tipodoc\"><option value=\"1\">Boleta global</option><option value=\"2\">Boleta Certificada</option><option value=\"3\">Boleta Departamental</option><option value=\"4\">"
					+ "Constancia de inscripci�n</option><option value=\"5\">Constancia de inscripci�n y horario</option><option value=\"6\">Constancia de estudios</option><option value=\"7\">Constancia de periodo vacacional</option><option value=\"8\">"
					+ "Constancia para tr�mite de serivicio social</option></select>&nbsp; &nbsp; Motivo:<select name=\"motivo\" id=\"motivo\">              <option value=\"1\">Beca Externa</option>              <option value=\"2\">Movilidad</option>    "
					+ "          <option value=\"3\">Ninguno</option>              <option value=\"4\">Padres</option>            <option value=\"5\">Otro</option></select><br><br><input type=\"submit\" value=\"Aceptar\"></form>";
		else {
			if (tipo == 1)
				form = "<h3 align=\"center\">Todos los campos son obligatorios, verificalos antes de realizar el registro de la solicitud.</h3><br><br>"
						+ "<form action=\"solicitarArea\" method=\"post\" align=\"center\">" + "Tipo de documento:"
						+ "<select name=\"tipodoc\" id=\"tipodoc\">" + "<option value=\"1\">Boleta global</option>"
						+ "<option value=\"2\">Boleta Certificada</option>"
						+ "<option value=\"3\">Boleta Departamental</option>"
						+ "<option value=\"4\">Constancia de inscripci�n</option>"
						+ "<option value=\"5\">Constancia de inscripci�n y horario</option>"
						+ "<option value=\"6\">Constancia de estudios</option>"
						+ "<option value=\"7\">Constancia de periodo vacacional</option>"
						+ "<option value=\"8\">Constancia para tr�mite de serivicio social</option>" + "</select>"
						+ "&nbsp; &nbsp;" + "Motivo:" + "<select name=\"motivo\" id=\"motivo\">"
						+ "<option value=\"1\">Beca Externa</option>" + "<option value=\"2\">Movilidad</option>"
						+ "<option value=\"3\">Ninguno</option> " + "<option value=\"4\">Padres</option>"
						+ "<option value=\"5\">Otro</option>" + "</select>" + "<br><br>" + "<p>No. de Boleta:</p>"
						+ "<div class=\"controls\" id=\"profs\">" + "<form class=\"input-append\">"
						+ "<div id=\"field\"><input autocomplete=\"off\" class=\"input\" id=\"field1\" name=\"prof1\" type=\"text\" placeholder=\"Boleta\" data-items=\"10\"/><button id=\"b1\" class=\"btn add-more\" type=\"button\">+</button></div>"
						+ "</form>" + "<br><br>" + "<input type=\"submit\" value=\"Aceptar\">" + "</form>";
			else {
				if (tipo == 2)
					form = "<h3 align=\"center\">Todos los campos son obligatorios, verificalos antes de realizar el registro de la solicitud.</h3><br><br>"
							+ "<form action=\"SolicitarArea\" method=\"post\" align=\"center\">" + "Tipo de documento:"
							+ "<select name=\"tipodoc\" id=\"tipodoc\">" + "<option value=\"1\">Boleta global</option>"
							+ "<option value=\"2\">Boleta Certificada</option>"
							+ "<option value=\"3\">Boleta Departamental</option>"
							+ "<option value=\"4\">Constancia de inscripci�n</option>"
							+ "<option value=\"5\">Constancia de inscripci�n y horario</option>"
							+ "<option value=\"6\">Constancia de estudios</option>"
							+ "<option value=\"7\">Constancia de periodo vacacional</option>"
							+ "<option value=\"8\">Constancia para tr�mite de serivicio social</option>" + "</select>"
							+ "&nbsp; &nbsp;" + "Motivo:" + "<select name=\"motivo\" id=\"motivo\">"
							+ "<option value=\"1\">Beca Externa</option>" + "<option value=\"2\">Movilidad</option>"
							+ "<option value=\"3\">Ninguno</option> " + "<option value=\"4\">Padres</option>"
							+ "<option value=\"5\">Otro</option>" + "</select>" + "<br><br>" + "<p>No. de Boleta:</p>"
							+ "<input name=\"noboleta\" id=\"noboleta\" style=\"text-align:center;\" required>"
							+ "<br><br>" + "<input type=\"submit\" value=\"Aceptar\">" + "</form>";
				else {
					if (tipo == 3)
						form = "";
				}
			}
		}
		return form;
	}

}
