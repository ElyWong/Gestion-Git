<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
  <link rel="stylesheet" href="css/jquery.dataTables.min.css">
  <link rel="stylesheet" href="css/lazyYT.css"><!-- Agregado el 190515 para el funcionomiento de youtube -->
  <script src="js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>
  <script src="js/vendor/bootstrap.min.js"></script>
  <script src="js/jquery.min.js"></script>
  <script src="js/jquery.dataTables.min.js"></script>
  <script src="js/main.js"></script>
  <script type="text/javascript" src="fc/fusioncharts.js"></script>
        <script type="text/javascript" src="fc/fusioncharts.charts.js"></script>
        <script type="text/javascript" src="fc/fusioncharts.theme.ocean.js"></script>

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
			<li ><a href="gestionAnalista.jsp">Gestionar Analistas</a></li>
			<li ><a href="#">Gestionar Alumnos</a></li>
			<li ><a href="gestionJefeArea.jsp">Gestionar Jefes de área</a></li>
            <li class="active"><a href="generarEstadistica.jsp">Generar estadistica</a></li>
			<li ><a href="index.jsp">Cerrar sesión</a></li>
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

<!--/Slider-->
	<!-- Message -->
  	<!-- Message -->
  <section class="main-info">
         	<!--<h3>Mensaje del Director</h3>-->
         <table align= "center">
         	<tr>
         		<td>
         		<div id="grafica"></div>
         		</td>
         		<td>
         		<div id="grafica2"></div>	
         		</td>
         	</tr>
         </table>
          	
          
           <%@page import="FusionCharts.FusionCharts" %>
        
<!--    Step 3:Include the package in the file where you want to show 
        FusionCharts as follows.
        
        Step 4: Create a chart object using the FusionCharts JAVA class 
        constructor. Syntax for the constructor: 
        `FusionCharts("type of chart", "unique chart id", "width of chart",
                        "height of chart", "div id to render the chart", 
                        "data format", "data source")`   
-->        
        <% 

            FusionCharts pastel = new FusionCharts(
                        "pie3d",// chartType
                        "ex1",// chartId
                        "600", "400",// chartWidth, chartHeight
                        "grafica",// chartContainer
                        "xmlurl",// dataFormat
                        "file1.xml"
                    );
	        FusionCharts lineas = new FusionCharts(
	                "column2d",// chartType
	                "ex2",// chartId
	                "600", "400",// chartWidth, chartHeight
	                "grafica2",// chartContainer
	                "xmlurl",// dataFormat
	                "file2.xml"
	            );
        %>
<!--    Step 5: Render the chart    -->  
        <%=pastel.render()%>
        <%=lineas.render()%>
 	</section>
 	
     
<!-- /Message -> 	<!-- /Message -->
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