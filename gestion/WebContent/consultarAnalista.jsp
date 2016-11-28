<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="Modelo.Solicitud"%>
<!DOCTYPE html>

<%
	String mensaje = (String) request.getAttribute("mensaje");
%>
<html>
<style>/* Style the list */
ul.tab {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	border: 1px solid #ccc;
	background-color: white;
}

/* Float the list items side by side */
ul.tab li {
	float: left;
}

/* Style the links inside the list items */
ul.tab li a {
	display: inline-block;
	color: black;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	transition: 0.3s;
	font-size: 17px;
}

/* Change background color of links on hover */
ul.tab li a:hover {
	background-color: #ddd;
}

/* Create an active/current tablink class */
ul.tab li a:focus, .active {
	background-color: white;
}

/* Style the tab content */
.tabcontent {
	display: none;
	padding: 6px 12px;
	border: 1px solid #ccc;
	border-top: none;
}
</style>
<head>
<meta charset="utf-8">
<meta property="og:url" content="http://www.isc.escom.ipn.mx" />
<meta property="og:title" content="Escuela Superior de C&oacute;mputo" />
<meta property="og:description"
	content="Sitio Web oficial de la ESCOM del IPN. 2014 &reg;." />
<meta property="og:image"
	content="http://www.isc.escom.ipn.mx/images/logoShared.png" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>.:: ESCOM - IPN ::.</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width">
<link rel="icon" href="images/icon.png" />
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-responsive.min.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/sl-slide.css">
<link rel="stylesheet" href="css/lazyYT.css">
<!-- Agregado el 190515 para el funcionomiento de youtube -->
<link rel="stylesheet" href="css/jquery.dataTables.min.css">
<script src="js/vendor/jquery-1.9.1.min.js"></script>
<script src="js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>
<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
<script src="js/vendor/bootstrap.min.js"></script>
<script src="js/main.js"></script>
<script src="js/consultarAnalista.js"></script>
<script>
	$(function() {
<%Solicitud unaS = new Solicitud();
			String cad = unaS.getAnalistaTabla((String) session.getAttribute("boleta"));%>
	var data =
<%out.println("\"" + cad + "\"");%>
	var mensaje =
<%out.println("\"" + mensaje + "\"");%>
	$("#iniciadas")
				.append(
						"<thead><tr><th>Selección</th><th>Fecha</th><th>Boleta</th><th>Nombre</th><th>Trámite</th><th>Motivo</th></tr></thead>");
		$("#iniciadas").append(data);
	});
	$(function() {
<%Solicitud unaS1 = new Solicitud();
			String cad1 = unaS1.getAnalistaTabla1((String) session.getAttribute("boleta"));%>
	var data =
<%out.println("\"" + cad1 + "\"");%>
	$("#impresas")
				.append(
						"<thead><tr><th>Selección</th><th>Fecha</th><th>Boleta</th><th>Nombre</th><th>Trámite</th><th>Motivo</th></tr></thead>");
		$("#impresas").append(data);
	});
	$(function() {
<%Solicitud unaS2 = new Solicitud();
			String cad2 = unaS2.getAnalistaTabla2((String) session.getAttribute("boleta"));%>
	var data =
<%out.println("\"" + cad2 + "\"");%>
	$("#enFirma")
				.append(
						"<thead><tr><th>Selección</th><th>Fecha</th><th>Boleta</th><th>Nombre</th><th>Trámite</th><th>Motivo</th></tr></thead>");
		$("#enFirma").append(data);
	});
	$(function() {
<%Solicitud unaS3 = new Solicitud();
			String cad3 = unaS3.getAnalistaTabla3((String) session.getAttribute("boleta"));%>
	var data =
<%out.println("\"" + cad3 + "\"");%>
	$("#listas")
				.append(
						"<thead><tr><th>Selección</th><th>Fecha</th><th>Boleta</th><th>Nombre</th><th>Trámite</th><th>Motivo</th><th>Folio</th></tr></thead>");
		$("#listas").append(data);
	});
</script>
<script type="text/javascript">
$(document).ready(function(){
	$('#iniciadas').DataTable( {
	    language: {
	    	"sProcessing":     "Procesando...",
	        "sLengthMenu":     "Mostrar _MENU_ registros",
	        "sZeroRecords":    "No se encontraron resultados",
	        "sEmptyTable":     "Ningún dato disponible en esta tabla",
	        "sInfo":           "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
	        "sInfoEmpty":      "Mostrando registros del 0 al 0 de un total de 0 registros",
	        "sInfoFiltered":   "(filtrado de un total de _MAX_ registros)",
	        "sInfoPostFix":    "",
	        "sSearch":         "Buscar:",
	        "sUrl":            "",
	        "sInfoThousands":  ",",
	        "sLoadingRecords": "Cargando...",
	        "oPaginate": {
	            "sFirst":    "Primero",
	            "sLast":     "Último",
	            "sNext":     "Siguiente",
	            "sPrevious": "Anterior"
	        },
	        "oAria": {
	            "sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
	            "sSortDescending": ": Activar para ordenar la columna de manera descendente"
	        }
	    }
	} );
});
$(document).ready(function(){
	$('#impresas').DataTable( {
	    language: {
	    	"sProcessing":     "Procesando...",
	        "sLengthMenu":     "Mostrar _MENU_ registros",
	        "sZeroRecords":    "No se encontraron resultados",
	        "sEmptyTable":     "Ningún dato disponible en esta tabla",
	        "sInfo":           "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
	        "sInfoEmpty":      "Mostrando registros del 0 al 0 de un total de 0 registros",
	        "sInfoFiltered":   "(filtrado de un total de _MAX_ registros)",
	        "sInfoPostFix":    "",
	        "sSearch":         "Buscar:",
	        "sUrl":            "",
	        "sInfoThousands":  ",",
	        "sLoadingRecords": "Cargando...",
	        "oPaginate": {
	            "sFirst":    "Primero",
	            "sLast":     "Último",
	            "sNext":     "Siguiente",
	            "sPrevious": "Anterior"
	        },
	        "oAria": {
	            "sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
	            "sSortDescending": ": Activar para ordenar la columna de manera descendente"
	        }
	    }
	} );
});
$(document).ready(function(){
	$('#enFirma').DataTable( {
	    language: {
	    	"sProcessing":     "Procesando...",
	        "sLengthMenu":     "Mostrar _MENU_ registros",
	        "sZeroRecords":    "No se encontraron resultados",
	        "sEmptyTable":     "Ningún dato disponible en esta tabla",
	        "sInfo":           "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
	        "sInfoEmpty":      "Mostrando registros del 0 al 0 de un total de 0 registros",
	        "sInfoFiltered":   "(filtrado de un total de _MAX_ registros)",
	        "sInfoPostFix":    "",
	        "sSearch":         "Buscar:",
	        "sUrl":            "",
	        "sInfoThousands":  ",",
	        "sLoadingRecords": "Cargando...",
	        "oPaginate": {
	            "sFirst":    "Primero",
	            "sLast":     "Último",
	            "sNext":     "Siguiente",
	            "sPrevious": "Anterior"
	        },
	        "oAria": {
	            "sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
	            "sSortDescending": ": Activar para ordenar la columna de manera descendente"
	        }
	    }
	} );
});
$(document).ready(function(){
	$('#listas').DataTable( {
	    language: {
	    	"sProcessing":     "Procesando...",
	        "sLengthMenu":     "Mostrar _MENU_ registros",
	        "sZeroRecords":    "No se encontraron resultados",
	        "sEmptyTable":     "Ningún dato disponible en esta tabla",
	        "sInfo":           "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
	        "sInfoEmpty":      "Mostrando registros del 0 al 0 de un total de 0 registros",
	        "sInfoFiltered":   "(filtrado de un total de _MAX_ registros)",
	        "sInfoPostFix":    "",
	        "sSearch":         "Buscar:",
	        "sUrl":            "",
	        "sInfoThousands":  ",",
	        "sLoadingRecords": "Cargando...",
	        "oPaginate": {
	            "sFirst":    "Primero",
	            "sLast":     "Último",
	            "sNext":     "Siguiente",
	            "sPrevious": "Anterior"
	        },
	        "oAria": {
	            "sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
	            "sSortDescending": ": Activar para ordenar la columna de manera descendente"
	        }
	    }
	} );
});
</script>
<!-- /Scripts for facebook, twitter & youtube -->
</head>
<body>
	<section class="fondoBlanco">
		<div id="areaTrabajo">
			<div class="container">
				<div class="row-fluid logos">
					<div class="span6">
						<img src="images/logoSEP.png" border="0" id="logo1" />
					</div>
					<div class="span6" align="right">
						<a href="http://www.ipn.mx" target="_blank"> <img
							src="images/logoIPNGris.png" border="0" />
						</a>
					</div>
				</div>
				<!-- Fin de logos -->
			</div>
			<!-- Fin de container -->
		</div>
		<!-- Fin de areaTrabajo -->
	</section>


	<section class="gris">
		<div id="areaTrabajo">
			<div class="container">

				<div class="nav-collapse collapse pull-right">
					<a href="http://www.ipn.mx" class="ligasInst" target="_blank">Inicio
						IPN</a>&nbsp;<span class="blanco">|</span> <a
						href="http://www.ipn.mx/Paginas/Correo-Electronico.aspx"
						class="ligasInst" target="_blank" title="Correo Institucional">Correo
						Electr&oacute;nico</a>&nbsp;<span class="blanco">|</span> <a
						href="http://www.ipn.mx/Paginas/Instalaciones.aspx"
						class="ligasInst" title="Instalaciones IPN" target="_blank">Instalaciones</a>&nbsp;<span
						class="blanco">|</span> <a
						href="http://www.ipn.mx/Paginas/Servicios-Medicos.aspx"
						class="ligasInst" title="Servicios Médicos" target="_blank">Servicios
						M&eacute;dicos</a>&nbsp;<span class="blanco">|</span> <a
						href="http://www.ipn.mx/Paginas/Calendario-Escolar-IPN.aspx"
						class="ligasInst" title="Calendario" target="_blank">Calendario</a>&nbsp;<span
						class="blanco">|</span> <a
						href="http://www.ipn.mx/Paginas/Contacto.aspx" class="ligasInst"
						target="_blank">Contacto</a>&nbsp;
				</div>
				<!--/.nav-collapse -->
			</div>
			<!-- Fin div container -->
		</div>
		<!-- Fin del areaTrabajo -->
	</section>
	<!-- Fin del código agregado para menú institucional el día =090115= -->



	<!-- /header -->

	<!--Header-->
	<!--<header class="navbar navbar-fixed-top">-->
	<!-- Colocamos el header aquí para que nuestro menú quede fijo en todo momento -->
	<header class="navbar" data-spy="affix" data-offset-top="100"
		id="miMenu">
		<section class="fondoBlanco">
			<div id="areaTrabajo">
				<div class="navbar-inner">
					<div class="container">
						<a class="btn btn-navbar" data-toggle="collapse"
							data-target=".nav-collapse"> <span class="icon-bar"></span> <span
							class="icon-bar"></span> <span class="icon-bar"></span>
						</a> <img src="images/logoEscom.png" border="0" usemap="#logoMap"
							id="logo" title="ESCOM - Escuela Superior de Cómputo" />
						<!--<a id="logo" class="pull-left" href="index.php"></a>-->
						<div class="nav-collapse collapse pull-right">
							<ul class="nav">
								<li class="active"><a href="consultarAnalista.jsp">Consultar
										solicitudes</a></li>
								<li><a href="solicitar.jsp">Registrar trámite</a></li>
								<li><a href="reporteAnalista.jsp">Generar reporte de
										turno</a></li>
								<li><a href="bitacoraAnalista.jsp">Generar bitácora</a></li>
								<li><a href="logout">Cerrar sesión</a></li>
								<!--<li class="login">
           	 <a data-toggle="modal" href="#loginForm"><i class="icon-lock"></i></a>
          </li>-->
							</ul>
						</div>
						<!--/.nav-collapse -->
					</div>
				</div>
				<!-- Fin del div navbar-inner -->
			</div>
			<!-- Fin areaTrabajo -->
		</section>
	</header>
	<!-- /header -->

	<!-- /header -->
	<!--/Slider-->
	<!-- Message -->
	<!-- Message -->
	<section class="main-info">
		<!--<h3>Mensaje del Director</h3>-->
		<h3 align="center">A continuación se muestran las solicitudes que
			se han hecho atraves del sistema, en el estado podrás modificarlo
			según sea el caso.</h3>
		<br>
		<ul class="tab">
			<li><a href="javascript:void(0)" class="tablinks"
				onclick="openCity(event, 'London')">Iniciadas</a></li>
			<li><a href="javascript:void(0)" class="tablinks"
				onclick="openCity(event, 'Paris')">Impresas</a></li>
			<li><a href="javascript:void(0)" class="tablinks"
				onclick="openCity(event, 'Tokyo')">En firma</a></li>
			<li><a href="javascript:void(0)" class="tablinks"
				onclick="openCity(event, 'NewYork')">Listas</a></li>
		</ul>
		<div id="London" class="tabcontent">
			<form action="consultaAnalista" method="post" align="center">
				<button name="boton" value="impresa">Cambiar estado</button>
				<table id="iniciadas" class="table table-bordered table-hover">
				</table>
			</form>
		</div>
		<div id="Paris" class="tabcontent">
			<form action="consultaAnalista" method="post" align="center">

				<button name="boton" value="enFirma">Cambiar estado</button>
				<table id="impresas" class="table table-bordered table-hover">
				</table>
			</form>
		</div>
		<div id="Tokyo" class="tabcontent">
			<form action="consultaAnalista" method="post" align="center">
				<button name="boton" value="lista">Cambiar estado</button>
				<table id="enFirma" class="table table-bordered table-hover">
				</table>
			</form>
		</div>
		<div id="NewYork" class="tabcontent">
			<form action="consultaAnalista" method="post" align="center">
				<button name="boton" value="entregada">Cambiar estado</button>
				<table id="listas" class="table table-bordered table-hover">
				</table>
			</form>
		</div>
		<script>
			function openCity(evt, cityName) {
				// Declare all variables
				var i, tabcontent, tablinks;

				// Get all elements with class="tabcontent" and hide them
				tabcontent = document.getElementsByClassName("tabcontent");
				for (i = 0; i < tabcontent.length; i++) {
					tabcontent[i].style.display = "none";
				}

				// Get all elements with class="tablinks" and remove the class "active"
				tablinks = document.getElementsByClassName("tablinks");
				for (i = 0; i < tablinks.length; i++) {
					tablinks[i].className = tablinks[i].className.replace(
							" active", "");
				}

				// Show the current tab, and add an "active" class to the link that opened the tab
				document.getElementById(cityName).style.display = "block";
				evt.currentTarget.className += " active";
			}
		</script>
	</section>

</body>

<script src="js/jquery.ba-cond.min.js"></script>
<script src="js/jquery.slitslider.js"></script>
<script src="js/slider.js"></script>
<script src="js/googleAnalytics.js"></script>
</html>