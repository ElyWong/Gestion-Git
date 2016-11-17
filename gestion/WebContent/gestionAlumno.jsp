<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="js/vendor/jquery.min.js"></script>
  <script src="js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>
  <script src="js/vendor/bootstrap.min.js"></script>
	<script src="js/main.js"></script>
     <script src="js/gestionAlumno.js"> </script>
        <script type="text/javascript" src="http://static.fusioncharts.com/code/latest/fusioncharts.js"></script>
        <script type="text/javascript" src="http://static.fusioncharts.com/code/latest/fusioncharts.charts.js"></script>
        <script type="text/javascript" src="http://static.fusioncharts.com/code/latest/themes/fusioncharts.theme.ocean.js"></script>
		<script type="text/javascript" src="http://static.fusioncharts.com/code/latest/themes/fusioncharts.theme.zune.js"></script>
		
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
      	
        <img src="images/logoEscom.png" border="0" usemap="#logoMap" id="logo" title="ESCOM - Escuela Superior de Cómputo" />
        <!--<a id="logo" class="pull-left" href="index.php"></a>-->
     	<div class="nav-collapse collapse pull-right">
      	<ul class="nav">
			<li ><a href="gestionAnalista.jsp">Gestionar Analistas</a></li>
			<li ><a href="gestionAlumno.jsp">Gestionar Alumnos</a></li>
			<li ><a href="gestionJefeArea.jsp">Gestionar Jefes de área</a></li>
            <li class="active"><a href="generarEstadistica.jsp">Generar estadistica</a></li>
			<li ><a href="logout">Cerrar sesión</a></li>
	    </ul>     
      </div><!--/.nav-collapse -->
     	</div>
  		</div><!-- Fin del div navbar-inner -->
		</div><!-- Fin areaTrabajo -->
	</section>
</header>
<!-- /slider-wrapper -->          
		
<section class="main-info">
	<div class="container-fluid">
		<h2>Gestionar Alumnos</h2>
		<h3>A continuación se muestra una lista de todos los alumnos que se encuentran registrados.</h3>
		<div class="table-responsive">
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th>Boleta</th>
						<th>Apellido Paterno</th>
						<th>Apellido Materno</th>
						<th>Nombre</th>
						<th>Correo</th>
						<th>Estatus</th>
					</tr>
				</thead>
				<tbody id="tableAlumno" style="cursor:pointer">
				</tbody>
			</table>
		</div>
	</div>
	<div align="center">
			<h3>Ingresa los datos del alumno</h3>
			<div class="form-group">
    			<label for="boleta">Boleta</label>
    			<input type="text" class="form-control" id="boleta" name="boleta" required>
  			</div>
  			<div class="form-group">
    			<label for="nombre">Nombre</label>
    			<input type="text" class="form-control" id="nombre" name="nombre" required>
  			</div>
			<table>
				<tr>
					<td>
						<div class="form-group">
    						<label for="apPaterno">Apellido Paterno</label>
    						<input type="text" class="form-control" id="apPaterno" name="apPaterno" required>
  						</div>
					</td>
					<td>
						<div class="form-group">
    						<label for="apMaterno">Apellido Materno</label>
    						<input type="text" class="form-control" id="apMaterno" name="apMaterno" required>
  						</div>
					</td>
				</tr>
				<tr>
					<td>
						<div class="form-group">
    						<label for="email">Correo</label>
    						<input type="text" class="form-control" id="email" name="email">
  						</div>
					</td>
					<td>
						<div class="form-group">
    						<label for="estatus">Estatus</label>
    						<select class="form-control" id="estatus" name="estatus" required>
    							<option value="inscrito">Inscrito</option>
    							<option value="baja">Baja</option>
    							<option value="egresado">Egresado</option>
    						</select>
  						</div>
					</td>
				</tr>
			</table>
  			<button id="agregarAlumno">Agregar</button> 
  			<button id="modificarAlumno">Modificar</button>
  			<button id="eliminarAlumno">Eliminar</button>
  			<button id="cancelar">Cancelar</button>
	</div>
</section>


</body>

</html>