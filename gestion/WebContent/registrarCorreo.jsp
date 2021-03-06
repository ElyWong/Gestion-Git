<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
  
  <script src="js/vendor/jquery-1.9.1.min.js"></script>
  <script src="js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>
  <script src="js/vendor/bootstrap.min.js"></script>
	<script src="js/main.js"></script>

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
        	</section>
</header>
<!-- /slider-wrapper -->  
<% 
	String boleta = (String) request.getSession().getAttribute("boleta");
%>         
</section>
<!--/Slider-->
	<!-- Message -->
  	<!-- Message -->
  <section class="main-info">
	<div class="row-fluid">
	<h1 align="center">Bienvenido</h1>
			<h3 align="center">Hemos notado que no tienes un correo asignado a tu cuenta. Para poder utilizar el sistema 
			requieres registrar un correo electr�nico y actualizar tu contrase�a.</div><br><br>
	<div class="container">
              	<!--<h3>Mensaje del Director</h3>-->
          <form action="RegistroCorreo" onsubmit="return myFunction()" method="post" align="center">
            <input type="email" name="email" id="email" placeholder = "Correo electr�nico" style="text-align:center;" required>
            <br>
            <input type="password" name="pass0" id="pass0" placeholder="Contrase�a anterior" style="text-align:center;" required>
            <br>
            <input type="password" name="pass1" id="pass1" placeholder="Contrase�a nueva" style="text-align:center;" required>
            <br>
            <input type="password" name="pass2" id="pass2" placeholder="Contrase�a nueva" style="text-align:center;" required>
            <br><br>
            <input type="text" name="boleta" style="display:none" value=<%out.println("\"" + boleta + "\"");%>>
            <input type="submit" class="special" value="Entrar">
          </form>     
  	</div>
	
 	</section>
<!-- /Message -> 	<!-- /Message ->
	
 
</body>

	<!-- Required javascript files for Slider -->
	<script>
		function myFunction() {
		    var pass1 = document.getElementById("pass1").value;
		    var pass2 = document.getElementById("pass2").value;
		    var ok = true;
		    if (pass1 != pass2) {
		        alert("Las contrase�as no coinciden.");
		        document.getElementById("pass1").style.borderColor = "#E34234";
		        document.getElementById("pass2").style.borderColor = "#E34234";
		        ok = false;
		    }
		    return ok;
		}
	</script>
	<script src="js/jquery.ba-cond.min.js"></script>
	<script src="js/jquery.slitslider.js"></script>
  <script src="js/slider.js"></script>
	<!-- /Required javascript files for Slider -->
  
  <!-- GOOGLE ANALYTICS -->
		<script src="js/googleAnalytics.js"></script>
	<!-- FIN DE GOOGLE ANALYTICS -->

</html>