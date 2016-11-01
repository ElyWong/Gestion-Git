<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta property="og:url" content="http://www.isc.escom.ipn.mx" />
<meta property="og:title" content="Escuela Superior de C&oacute;mputo" />
<meta property="og:description" content="Sitio Web oficial de la ESCOM del IPN. 2014 &reg;." />
<meta property="og:image" content="http://www.isc.escom.ipn.mx/images/logoShared.png" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width">
<title>Generar bitácora</title>
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
      <a href="http://www.ipn.mx/Paginas/Servicios-Medicos.aspx" class="ligasInst" title="Servicios Médicos" target="_blank">Servicios M&eacute;dicos</a>&nbsp;<span class="blanco">|</span>
      <a href="http://www.ipn.mx/Paginas/Calendario-Escolar-IPN.aspx" class="ligasInst" title="Calendario" target="_blank">Calendario</a>&nbsp;<span class="blanco">|</span>
      <a href="http://www.ipn.mx/Paginas/Contacto.aspx" class="ligasInst" target="_blank">Contacto</a>&nbsp;
    </div><!--/.nav-collapse -->
		</div><!-- Fin div container -->
	</div><!-- Fin del areaTrabajo -->
</section>
<!-- Fin del código agregado para menú institucional el día =090115= -->



<!-- /header -->
    
<!--Header-->
<!--<header class="navbar navbar-fixed-top">-->
<!-- Colocamos el header aquí para que nuestro menú quede fijo en todo momento -->
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
        <img src="images/logoEscom.png" border="0" usemap="#logoMap" id="logo" title="ESCOM - Escuela Superior de Cómputo" />
        <!--<a id="logo" class="pull-left" href="index.php"></a>-->
     	<div class="nav-collapse collapse pull-right">
      	<ul class="nav">
			<li class="active"><a href="consultarAnalista.jsp">Consultar solicitudes</a></li>
			<li ><a href="solicitar.jsp">Registrar trámite</a></li>
			<li ><a href="reporteAnalista.jsp">Generar reporte de turno</a></li>
			<li ><a href="bitacoraAnalista.jsp">Generar bitácora</a></li>
            <li><a href="logout">Cerrar sesión</a></li>
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
    <!--/Slider Items-->
    
    <!--Slider Next Prev button-->
    <nav id="nav-arrows" class="nav-arrows">
        <span class="nav-arrow-prev"><i class="icon-angle-left"></i></span>
        <span class="nav-arrow-next"><i class="icon-angle-right"></i></span> 
    </nav>
    <!--/Slider Next Prev button-->

<!-- /slider-wrapper -->           
<!--/Slider-->
	<!-- Message -->
  	<!-- Message -->
  <% 
  	String path = request.getContextPath();
  %>
  <section class="main-info">
			<h3 align="center">Generar bitácora</h3>
			<br>
	<div class="container-fluid">
		<form action="bitacora" class="form-inline" align="center">
			<div class="form-group">
				<label for="fechaInicial">Fecha inicial</label>
				<input type="date" class="form-control" name="fechaInicial" id="fechaInicial" required="required">
				<input type="submit" class="form-control" value="Generar bitácora">
			</div>
	</form>
	</div>
    <div class="container-fluid">
    	<div style="margin:auto;width:80%;height:800px;">
    		<%
    			String filename = (String) session.getAttribute("filename");
    			if(filename != null) {
    				path += "/reportes/" + filename;
    				out.print("<embed src=\"" + path + "\" type=\"application/pdf\" height=\"800\" width=\"100%\">");
    			}
    		%>
    	</div>
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


</body>
</html>