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
  <link rel="stylesheet" href="css/lazyYT.css"><!-- Agregado el 190515 para el funcionomiento de youtube -->
  <link rel="stylesheet" href="css/jquery.dataTables.min.css">
  <script src="js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>
  <script src="js/vendor/bootstrap.min.js"></script>
  <script src="js/jquery.min.js"></script>
  <script src="js/jquery.dataTables.min.js"></script>
  <script src="js/main.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#tabla').DataTable( {
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
	
<script type="text/javascript">
$(document).ready(function(){
 $("#principal").change(function() {
    if ($(this).val() == 'a') {
      $("#tipodoc").show();
      $("#estadodoc").show();
      $("#motivodoc").hide();
      $("#tipousu").hide();
      $("#nomanalista").hide();
      $("#nivelalu").hide();
      $("#1").show();
      $("#2").show();
      $("#3").hide();
      $("#4").hide();
      $("#5").hide();
      $("#6").hide();
      $("#tipousu").attr('required', false);
    } else if ($(this).val() == 'b'){
   $("#tipodoc").show();
   $("#estadodoc").hide();
   $("#motivodoc").show();
   $("#tipousu").hide();
   $("#nomanalista").hide();
   $("#nivelalu").hide();
   $("#1").show();
   $("#2").hide();
   $("#3").show();
   $("#4").hide();
   $("#5").hide();
   $("#6").hide();
   $("#tipousu").attr('required', false);
    }
    else if ($(this).val() == 'c'){
   $("#tipodoc").show();
   $("#estadodoc").hide();
   $("#motivodoc").show();
   $("#tipousu").show();
   $("#nomanalista").hide();
   $("#nivelalu").hide();
   $("#1").show();
   $("#2").hide();
   $("#3").show();
   $("#4").show();
   $("#5").hide();
   $("#6").hide();
   $("#tipousu").attr('required', true);
    }
  });
});
 </script>
 <script type="text/javascript">
$(document).ready(function(){
 $("#tipousu").change(function() {
  if ($(this).val() == 1) {
      $("#nomanalista").show();
      $("#nivelalu").hide();
      $("#5").show();
      $("#6").hide();
    } 
  else if ($(this).val() == 2){
	   $("#nomanalista").hide();
	   $("#nivelalu").show();
	   $("#5").hide();
	   $("#6").show();
    }
  });
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
			<li ><a href="gestionAlumno.jsp">Gestionar Alumnos</a></li>
			<li ><a href="gestionJefeArea.jsp">Gestionar Jefes de área</a></li>
            <li class="active"><a href="generarEstadistica.jsp">Generar estadistica</a></li>
			<li ><a href="logout"">Cerrar sesión</a></li>
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

</div>
<!-- /slider-wrapper -->           
</section>
<!--/Slider-->
	<!-- Message -->
  	<!-- Message -->
  <section class="main-info">
         	<!--<h3>Mensaje del Director</h3>-->
    <form action="ObtenerDatos" method="post" align="center">
          Fecha de inicio: <input type="date" name="fecha1" required/>
    		Fecha final: <input type="date" name="fecha2" required/>
     		<p>Criterio principal:</p>
             <select name="principal" id="principal" required>
			   <option disabled selected value></option>
               <option value="a">Por tipo de documento</option>
               <option value="b">Por motivo de documento</option>
               <option value="c">Por tipo de usuario</option>
             </select><br>
    &nbsp; &nbsp;
             <p id="1" style="display: none;">Selecciona el tipo de documento:</p>
             <select name="tipodoc" id="tipodoc" style="display: none;">
               <option disabled selected value></option>
               <option value="todos">Todos</option>
               <option value="Boleta global">Boleta global</option>
               <option value="Boleta cetrificada">Boleta cetrificada</option>
               <option value="Constancia de inscripción">Constancia de inscripción</option>
               <option value="Constancia de estudios">Constancia de estudios</option>
               <option value="Constancia de periodo vacacional">Constancia de periodo vacacional</option>
               <option value="Constancia para trámite de servicio social">Constancia para trámite de servicio social</option>
             </select><br>
             <p id ="2" style="display: none;">Selecciona el estado de los documentos a visualizar:</p>
             <select name="estadodoc" id="estadodoc" style="display: none;">
               <option disabled selected value></option>
               <option value="todos">Todos</option>
               <option value="Iniciada">Iniciada</option>
               <option value="Impresa">Impresa</option>
               <option value="En firma">En firma</option>
               <option value="Lista">Lista</option>
               <option value="Entregada">Entregada</option>
             </select><br>
             <p id ="3" style="display: none;">Selecciona el motivo de los documentos:</p>
             <select name="motivodoc" id="motivodoc" style="display: none;">
               <option disabled selected value></option>
               <option value="todos">Todos</option>
               <option value="Beca Externa">Beca Externa</option>
               <option value="Movilidad">Movilidad</option>
               <option value="Padres">Padres</option>
               <option value="Ninguno">Ninguno</option>
               <option value="Otro">Otro</option>
             </select><br>
             <p id ="4" style="display: none;">Selecciona el tipo de usuario:</p><br>
             <select name="tipousu" id="tipousu" style="display: none;">
               <option disabled selected value></option>
               <option value="1">Analista</option>
               <option value="2">Alumno</option>
             </select><br>
             <p id ="5" style="display: none;">Selecciona el nombre del analista:</p>
             <select name="nomanalista" id="nomanalista" style="display: none;">
               <option disabled selected value></option>
               <option value="todos">Todos</option>
               <option value="200">Olivia</option>
               <option value="201">Gina</option>
               <option value="202">Rigoberto</option>
               <option value="203">Eduardo</option>
               <option value="204">Miguel</option>
             </select><br>
             <p id ="6" style="display: none;">Selecciona el nivel de los alumnos:</p>
             <select name="nivelalu" id="nivelalu" style="display: none;">
               <option disabled selected value></option>
               <option value="todos">Todos</option>
               <option value="1">1</option>
               <option value="2">2</option>
               <option value="3">3</option>
               <option value="4">4</option>
               <option value="5">5</option>
             </select><br>
   
            <input type="submit" class="special" value="Obtener datos">
            
          </form>
          
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