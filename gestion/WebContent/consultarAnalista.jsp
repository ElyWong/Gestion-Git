<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "Modelo.Solicitud"%> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta property="og:url" content="http://www.isc.escom.ipn.mx" />
  <meta property="og:title" content="Escuela Superior de C&oacute;mputo" />
	<meta property="og:description" content="Sitio Web oficial de la ESCOM del IPN. 2014 &reg;." />
	<meta property="og:image" content="http://www.isc.escom.ipn.mx/images/logoShared.png" />
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
  <link rel="stylesheet" href="css/lazyYT.css"><!-- Agregado el 190515 para el funcionomiento de youtube -->
  <link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
  
  <script src="js/vendor/jquery-1.9.1.min.js"></script>
  <script src="js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>
  <script type="text/javascript" src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
  <script src="js/vendor/bootstrap.min.js"></script>
	<script src="js/main.js"></script>
  <script src="js/consultarAnalista.js"></script>
<script>
	$(function(){
		<%Solicitud unaS=new Solicitud();
		String cad=unaS.getAnalistaTabla((String) session.getAttribute("boleta")); 
		%>
		var data = <%out.println("\""+cad+"\"");%>
		$("#tabla").append("<tr><th></th><th>Fecha</th><th>Boleta</th><th>Tr�mite</th><th>Motivo</th><th>Estado</th><th></th></tr>");
  		$("#tabla").append(data); 
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
         	<a href="http://www.ipn.mx" target="_blank">
          	<img src="images/logoIPNGris.png" border="0" />
          </a>
        </div>
      </div> <!-- Fin de logos -->
    </div>	<!-- Fin de container -->
	</div>	<!-- Fin de areaTrabajo -->
</section> 

   
<section class="gris">
	<div id="areaTrabajo">
		<div class="container">

    <div class="nav-collapse collapse pull-right">
    	<a href="http://www.ipn.mx" class="ligasInst" target="_blank">Inicio IPN</a>&nbsp;<span class="blanco">|</span>
      <a href="http://www.ipn.mx/Paginas/Correo-Electronico.aspx" class="ligasInst" target="_blank" title="Correo Institucional">Correo Electr&oacute;nico</a>&nbsp;<span class="blanco">|</span>
      <a href="http://www.ipn.mx/Paginas/Instalaciones.aspx" class="ligasInst" title="Instalaciones IPN" target="_blank">Instalaciones</a>&nbsp;<span class="blanco">|</span>
      <a href="http://www.ipn.mx/Paginas/Servicios-Medicos.aspx" class="ligasInst" title="Servicios M�dicos" target="_blank">Servicios M&eacute;dicos</a>&nbsp;<span class="blanco">|</span>
      <a href="http://www.ipn.mx/Paginas/Calendario-Escolar-IPN.aspx" class="ligasInst" title="Calendario" target="_blank">Calendario</a>&nbsp;<span class="blanco">|</span>
      <a href="http://www.ipn.mx/Paginas/Contacto.aspx" class="ligasInst" target="_blank">Contacto</a>&nbsp;
    </div><!--/.nav-collapse -->
		</div><!-- Fin div container -->
	</div><!-- Fin del areaTrabajo -->
</section>
<!-- Fin del c�digo agregado para men� institucional el d�a =090115= -->



<!-- /header -->
    
<!--Header-->
<!--<header class="navbar navbar-fixed-top">-->
<!-- Colocamos el header aqu� para que nuestro men� quede fijo en todo momento -->
<header class="navbar" data-spy="affix" data-offset-top="100" id="miMenu">
	<section class="fondoBlanco">
		<div id="areaTrabajo">
			<div class="navbar-inner">
    	<div class="container">
      	<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
       	<span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        </a>
        <img src="images/logoEscom.png" border="0" usemap="#logoMap" id="logo" title="ESCOM - Escuela Superior de C�mputo" />
        <!--<a id="logo" class="pull-left" href="index.php"></a>-->
     	<div class="nav-collapse collapse pull-right">
      	<ul class="nav">
			<li class="active"><a href="consultarAnalista.jsp">Consultar solicitudes</a></li>
			<li ><a href="solicitar.jsp">Registrar tr�mite</a></li>
			<li ><a href="reporteAnalista.jsp">Generar reporte de turno</a></li>
			<li ><a href="bitacoraAnalista.jsp">Generar bit�cora</a></li>
            <li><a href="logout">Cerrar sesi�n</a></li>
			<!--<li class="login">
           	 <a data-toggle="modal" href="#loginForm"><i class="icon-lock"></i></a>
          </li>-->
        </ul>        
      </div><!--/.nav-collapse -->
     	</div>
  		</div><!-- Fin del div navbar-inner -->
		</div><!-- Fin areaTrabajo -->
	</section>
</header>
<!-- /header -->
    
	<!-- /header -->
    

	<!--Slider-->
  	<!--Slider-->
      
    </div>
    <!--/Slider Items-->
    
    <!--Slider Next Prev button-->
    <nav id="nav-arrows" class="nav-arrows">
        <span class="nav-arrow-prev"><i class="icon-angle-left"></i></span>
        <span class="nav-arrow-next"><i class="icon-angle-right"></i></span> 
    </nav>
    <!--/Slider Next Prev button-->

</div>
<!-- /slider-wrapper -->           
</section>
<!--/Slider-->
	<!-- Message -->
  	<!-- Message -->
  <section class="main-info">
         	<!--<h3>Mensaje del Director</h3>-->
			<h3 align="center">A continuaci�n se muestran las solicitudes que se han hecho atraves del sistema, en el estado podr�s modificarlo 
			seg�n sea el caso.</h3>
			<br><br>
    <div class="container-fluid">
     <form action="consultaAnalista" method="post" align="center">
     	<table align="center">
     		<th style="font-size: 150%; width:70%">
     			<table id="tabla" style="border-collapse: separate; border-spacing: 25px;">
			      </table>
     		</th>
     		<th align="center" style=" width:20%">
     			<select id="status" name="status">
     				<option value="impresa" selected>Impresa</option>
     				<option value="enFirma">En firma</option>
     				<option value="lista">Lista</option>
     				<option value="entregada">Entregada</option>
     			</select>
     			<br>
     			<input type="submit" class="special" value="Realizar cambios">
     		</th>
     	</table>
     </form>
    </div>
 	</section>
	
<!-- /Message -> 	<!-- /Message ->
 
</body>

	<!-- Required javascript files for Slider -->
	<script src="js/jquery.ba-cond.min.js"></script>
	<script src="js/jquery.slitslider.js"></script>
  <script src="js/slider.js"></script>
	<!-- /Required javascript files for Slider -->
  
  <!-- GOOGLE ANALYTICS -->
		<script src="js/googleAnalytics.js"></script>
	<!-- FIN DE GOOGLE ANALYTICS -->

</html>