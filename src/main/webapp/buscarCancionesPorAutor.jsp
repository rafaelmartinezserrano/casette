<%@page import="com.afd.casette.modelo.Cancion"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Casette</title>
<style>
	.lista {
		list-style-type: none;
	}
	.lista:hover{
		background-color: orange;
	}
</style>
</head>
<body>


<form action="BuscarCancionesPorAutor" method="get" class="contenedorForm"/>
<label for="buscarPorAutor">Nombre del Autor:</label>
<input type="search" id="buscarPorAutor" name="buscarPorAutor"/>
<form/>
 
 <div>
	<input type="submit" value="Buscar"/>
</div>

<%List <Cancion> canciones = (List <Cancion>)request.getAttribute("listaCanciones");  %>
<%if (canciones != null) { %>
	<div>
	<%for (Cancion cancion: canciones ){ %>
		<div>
			<span><%= cancion.getTitulo() %></span>
			<audio controls>
				<source src="../FICHEROS/<%=cancion.getUsuario().getIdUsuario() %>/MUSICA/<%=cancion.getArchivo()%>">
			</audio>
			<input type="button" value="Añadir a lista" onclick="buscarListas(<%=cancion.getIdCancion()%>);"/>
		</div>
	<%} %>
	</div>
<%} %>

<div id="contenedorListas" style="display:none"></div>
<script src="buscarListas.js"></script>
</body>
</html>