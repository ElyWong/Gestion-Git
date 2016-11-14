<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = "listas.Usuarios"%>
<%@ page import = "pool.TestPool"%>
<%@ page import = "java.util.List"%>   
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
  <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <link rel="stylesheet" href="css/bootstrap-responsive.min.css">
  <link rel="stylesheet" href="css/font-awesome.min.css">
  <link rel="stylesheet" href="css/main.css">
  <link rel="stylesheet" href="css/sl-slide.css">
  <link rel="stylesheet" href="css/lazyYT.css"><!-- Agregado el 190515 para el funcionomiento de youtube -->
  
  <script src="js/vendor/jquery.min.js"></script>
  <script src="js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>
  <script src="js/vendor/bootstrap.min.js"></script>
	<script src="js/main.js"></script>
     <script src="js/gestionJefeArea.js"> </script>
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
			<li ><a href="#">Gestionar Alumnos</a></li>
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

<% TestPool tp = new TestPool();
	String email;
	List<Usuarios> lstJefesArea = tp.listaUsuarios("jefe de area");
	if (lstJefesArea != null){ %>
		
<section class="main-info">
<h2>Gestionar Jefes de área.</h2>
<h3>A continuación se muestra una lista de todos los jefes de área que se encuentran registrados.</h1>

	<table class="pure-table">
				
				<thead>
					<th>Número de usuario</th>
					<th>Nombre</th>
					<th>Correo electónico</th>
					
				</thead>
				<tbody>
					<%
					int i = 0;
						for (Usuarios u : lstJefesArea) {
							email = u.getEmail();
							
							if(email.equals("null") || email.equals("")) {
								email = "EMAIL NO REGISTRADO";
							}
							if(i%2 == 0)
							{
					%>
						<tr>
							<td><%=u.getId() %></td>
							<td><%=u.getNombre() + " " + u.getAp() + " " + u.getAm()%></td>
							<td><%=email%></td>
							<td>
								<a class="btn btn-info btn-lg"
								   onclick="modalEditar(); editarJefeArea(<%=u.getId()%>)">Editar</a>
							
								<button onclick="eliminarJefeArea(<%=u.getId() %>)">Eliminar</button>
							</td> 
						</tr>
						<%
							}
							else
							{
						%>
						<tr class="pure-table-odd">
							<td><%=u.getId() %></td>
							<td><%=u.getNombre() + " " + u.getAp() + " " + u.getAm()%></td>
							<td><%=email%></td>
							<td>
								<a class="btn btn-info btn-lg"
								   onclick="modalEditar(); editarAnalista(<%=u.getId()%>)">Editar</a>
							
								<button onclick="eliminarAnalista(<%=u.getId() %>)">Eliminar</button>
							</td> 
						</tr>
						<%
						}
					%>
					<%
						i++;}
					%>
				</tbody>
			</table>
			
	<% } else { %>
	<h2> No se han registrado jefes de área. </h2>
	<% } %>

<a class="btn btn-info btn-lg" href="#" onClick="modalAgregar();">Agregar</a>

<!--  INICIA CONTAINER AGREGAR  -->
<div class="container">
<!-- Trigger the modal with a button -->
<!--   <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Agregar</button>   -->
  <!-- Modal AGREGAR-->
  <div id="myModal" class="modal fade" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h3 class="modal-title">Agregar Jefe de área.</h3>
        </div>
        <div class="modal-body">
        <table align="center">
        	<tr>
        	<td><h4>Número de usuario:</h4></td> <td> <input type="text" id="idusuario" /> </td>
        	</tr>
        	<tr>
          	<td><h4>Nombre:</h4></td><td> <input type="text" id="nombre" /> </td>
          	</tr>
          	<tr>
          	<td><h4>Apellido paterno:</h4></td> <td> <input type="text" id="ap" /> </td>
          	</tr>
          	<tr>
        	<td><h4>Apellido materno:</h4></td> <td> <input type="text" id="am" /> </td>
        	</tr>
        	<tr>
        	<td><h4>Tipo:</h4></td> <td> <input type="text" id="tipo" value="Jefe de área" disabled /> </td>
        	</tr>
        	<tr>
        	<td><h4>Contraseña:</h4></td> <td> <input type="text" id="pass"> </td>
        	</tr>
        	<tr>
        	<td><h4>Confirmar contraseña:</h4> </td> <td> <input type="text" id="pass"> </td>
        	</tr>
        </table>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
          <button type="button" onclick="agregarJefeArea()">Agregar</button>
        
        </div>
      </div>
      
    </div>
  </div>
<!--  </div>  -->
<!-- TERMINA CONTAINER AGREGAR -->


<!--  INICIA CONTAINER EDITAR  -->
<!-- <div class="container"> -->
  
  <!-- Modal EDITAR-->
  <div id="modalEdit" class="modal fade" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h3 class="modal-title">Editar Jefe de área.</h3>
        </div>
        <div class="modal-body">
	        <table align="center">
	        	<tr>
	        	<td><h4>Número de usuario:</h4></td><td> <input type="text" id="idEditar" disabled /> </td>
	        	</tr>
	        	<tr>
	          	<td><h4>Nombre:</h4></td><td> <input type="text" id="nombreEditar" /> </td>
	          	</tr>
	          	<tr>
	          	<td><h4>Apellido paterno:</h4></td> <td> <input type="text" id="apEditar" /> </td>
	          	</tr>
	          	<tr>
	        	<td><h4>Apellido materno:</h4></td> <td> <input type="text" id="amEditar" /> </td>
	        	</tr>
	        	<tr>
	        	<td><h4>Tipo:</h4></td> <td> <input type="text" id="tipoEditar" disabled /> </td>
	        	</tr>
	        </table>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
          <button type="button" onclick="actualizarJefeArea()">Guardar</button>
        </div>
      </div>
      
    </div>
  </div>
 </div> 
 
 
<!-- TERMINA CONTAINER EDITAR -->
</section>


</body>


</html>