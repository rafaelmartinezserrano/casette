<%@page import="com.afd.casette.modelo.Cancion"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.afd.casette.modelo.ListaReproduccion"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Editar Lista</title>
	</head>
	<body>
		<% ListaReproduccion lista = (ListaReproduccion) request.getAttribute("listaReproduccion"); %>
		<% if (lista != null) { %>
			<div>
				<h1><%=lista.getNombre() %></h1>
				<ol>
				<% for (Cancion cancion : lista.getCanciones()) { %>
					<li><%=cancion.getTitulo() %></li>
				<% } %>
				</ol>
			</div>
		<% } %>
		<script type="text/javascript" src="scripts/editarLista.js"></script>
	</body>
</html>