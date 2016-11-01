<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Consultas</title>
		<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<link rel="stylesheet" href="html5up-eventually/assets/css/main.css" />
</head>
<body>
	<header>Consultas</header>
	<main>
	<section id="secConsulta">
		<form action="query">
		<div class="field">
			<label for="message">Consulta</label>
			<textarea id="txtQuery" name="txtQuery" cols="15" rows="8"></textarea>
			<button>Enviar</button>
		</div>
		</form>
	</section>
	<section id="secResultado">
		<div>
			<%
				//Scriplet
				String r = (String)session.getAttribute("resultadoSesion");
				response.getWriter().print("Esta es la linea chida: "+"<br>"+r);
			%>
			<table>

			</table>
		</div>
	</section>
	</main>
	<footer> </footer>
	<script src="html5up-eventually/assets/js/main.js"></script>
</body>
</html>