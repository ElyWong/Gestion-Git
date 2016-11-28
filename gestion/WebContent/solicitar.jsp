<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String mensaje = (String) request.getAttribute("mensaje");
%>
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
<link rel="stylesheet" type="text/css" href="css/estilo.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript"></script>
<script>
	$(function() {
		var mensaje = <%out.println("\""+mensaje+"\"");%>
		if (mensaje.indexOf("null") != 0) {
			alert(mensaje);
		}
	});
</script>
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
	<!-- Fin de areaTrabajo --> </section>


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
	<!-- Fin del areaTrabajo --> </section>
	<script>
		$(document)
				.ready(
						function() {
							var next = 1;
							$(".add-more")
									.click(
											function(e) {
												e.preventDefault();
												var addto = "#field" + next;
												var addRemove = "#field"
														+ (next);
												next = next + 1;
												var newIn = '<input autocomplete="off" class="input form-control" id="field' + next + '" name="field' + next + '" type="text">';
												var newInput = $(newIn);
												var removeBtn = '<button id="remove'
														+ (next - 1)
														+ '" class="btn btn-danger remove-me" >-</button></div><div id="field">';
												var removeButton = $(removeBtn);
												$(addto).after(newInput);
												$(addRemove)
														.after(removeButton);
												$("#field" + next).attr(
														'data-source',
														$(addto).attr(
																'data-source'));
												$("#count").val(next);

												$('.remove-me')
														.click(
																function(e) {
																	e
																			.preventDefault();
																	var fieldNum = this.id
																			.charAt(this.id.length - 1);
																	var fieldID = "#field"
																			+ fieldNum;
																	$(this)
																			.remove();
																	$(fieldID)
																			.remove();
																});
											});
						});
	</script>
	<%
		String tipo1 = (String) request.getSession().getAttribute("tipo");
		Integer tipo = Integer.parseInt(tipo1);
		Modelo.solicitarJsp sol = new Modelo.solicitarJsp();
		String menu = sol.armarMenu(tipo);
		String formulario = sol.armarFormulario(tipo);
	%>
	<header class="navbar" data-spy="affix" data-offset-top="100"
		id="miMenu"> <section class="fondoBlanco">
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
						<%=menu%>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
		<!-- Fin del div navbar-inner -->
	</div>
	<!-- Fin areaTrabajo --> </section> </header>



	<!--/Slider-->
	<section class="main-info"><%=formulario%></section>
	<!-- /Message -> 	<!-- /Message ->
<body>

	<!-- Required javascript files for Slider -->
	<script src="js/jquery.ba-cond.min.js"></script>
	<script src="js/jquery.slitslider.js"></script>
	<script src="js/slider.js"></script>
	<!-- /Required javascript files for Slider -->


	<!-- GOOGLE ANALYTICS -->
	<script src="js/googleAnalytics.js"></script>
	<!-- FIN DE GOOGLE ANALYTICS -->
</html>