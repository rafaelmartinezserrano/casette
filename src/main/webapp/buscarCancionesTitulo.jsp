<%@page import="com.afd.casette.modelo.Cancion"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Busca tu canción</title>
</head>
<body>
	<header>
		<h1>Busca tu cancion</h1>
	</header>
	<main>
		<div id="cajita_busqueda">

			<form action="BuscarCancionesTitulo" method="post">
				<label for="formulario">Busca: </label> <input id="formulario"
					type="text" placeholder="Una cancion" name="tituCancion" /> <input
					type="submit" value="¡Busca :)!" />
			</form>

		</div>

<% String mensajeError = (String)request.getAttribute("error"); %>
					<% if (mensajeError != null) { %>
					<div class="error"><%=mensajeError %></div>
					<%} %>

		<%
		List<Cancion> canciones = (List<Cancion>) request.getAttribute("listaCanciones");
		%>
		<%
		if (canciones != null) {
		%>
		<div>
			<%
			for (Cancion cancion : canciones) {
			%>
			<div>
				<span><%=cancion.getTitulo()%></span>
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



	</main>


</body>
</html>