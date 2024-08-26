<%@page import="com.afd.casette.modelo.Cancion"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="principal.css"/>
		<title>Buscar canción</title>
		<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Dosis:wght@200..800&family=Kanit:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
</head>
<body>
	<%@include file="Menu.jsp" %>
	<header>
		<h1>Casette</h1>
		<h3>Buscar por título</h3>
	</header>
	<main>
		<div id="cajita_busqueda">
			<form action="BuscarCancionesTitulo" method="post">
				<label for="formulario">Busca: </label> <input id="formulario"
					type="text" placeholder="Una cancion" name="tituCancion" /> <input
					type="submit" value="¡Busca :)!" />
			</form>

		</div>
		<div class="contenedorResultado">
			<div class="mensaje">
				<% String mensajeError = (String)request.getAttribute("error"); %>
					<% if (mensajeError != null) { %>
					<div class="error"><%=mensajeError %></div>
					<%} %>
			</div>

		<%
		List<Cancion> canciones = (List<Cancion>) request.getAttribute("listaCanciones");
		%>
		<%
		if (canciones != null) {
		%>
		<div id="listaCanciones">
			<%
			for (Cancion cancion : canciones) {
			%>
			<div class="cancionInd">
				<span class="canSpanTitulo"><%=cancion.getTitulo()%></span>
				<audio controls>
					<source
						src=":/FICHEROS/<%=cancion.getUsuario().getIdUsuario()%>/MUSICA/<%=cancion.getArchivo()%>">
				</audio>
			</div>
			<%
			}
			%>
		</div>
		<%
		}
		%>
		</div>




	</main>


</body>
</html>