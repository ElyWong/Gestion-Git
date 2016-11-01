<%@page import="java.io.PrintWriter"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>Consultas</title>
	<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assets/css/main.css" />
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
		<style>
			table, th, td {
			    border: 1px solid black;
			    border-collapse: collapse;
			    background-color: #f1f1c1;
			    
			}
			th, td {
			    padding: 5px;
			    text-align: center;
			    color: #000000;
			}
		</style>
</head>
<body>
	<header> </header>
	<main>
	<section id="secConsulta">
		<form action="query" method="post">
			<h1>Consultas</h1>
			<textarea id="txtQuery" name="txtQuery" cols="500"></textarea>
			<button>Enviar</button>
		</form>
	</section>
	<section>
		<div class="table-wrapper">
			<%if((int)session.getAttribute("bandera")==1) {%>
				<h3>Resultados</h3>
				<table style="width:100%" >
				<thead></thead>
				<tbody>
				<%String[] r = (String [])session.getAttribute("respuesta");%>
				<%if(r!=null){ 
				 int columnas= (int)session.getAttribute("col"); 
					 for(int i=0;i<r.length;i++){ %>
							<tr>
							<%for(int j=0;j<columnas && i<r.length;j++,i++){ %>
								<td><%=r[i]%></td> 
								
							<%} i--;%>
							</tr>
						<% }%>
						
				<%}%>
				</tbody>
				<tfoot></tfoot>
				</table>	
			<%}else {%>
				<h3>Resultado</h3>
				<%String m= (String)session.getAttribute("mensaje");%>
				<%= m %>
				
			<%}%>
			</tbody>
			<tfoot></tfoot>
			</table>				
		</div>
	</section>
	</main>
	<footer id="footer">
		</footer>
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="assets/js/main.js"></script>
</body>
</html>