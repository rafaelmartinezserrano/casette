<%@page import="com.afd.casette.modelo.Cancion"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Casette</title>

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
		</div>
	<%} %>
	</div>
<%} %>
</body>
</html>