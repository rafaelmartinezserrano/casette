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
		<style type="text/css">
			.listaCanciones {
				list-style-type: none;
				padding: 0;
			}
			.cancion-item {
				padding: 10px;
				margin: 5px;
				background-color: #f2f2f2;
				border: 1px solid #ccc;
				cursor: grab;
			}
			.tituloLista {
				display: flex;
				align-items: center;
				gap: 20px;
			}
			#txtNombreLista {
				font-family: 'Times New Roman';
				font-size: 30px;
			}
			.oculto {
				display: none;
			}
			#mensajeLista{
				margin: 20px;
			}
		</style>
	</head>
	<body>
		<% ListaReproduccion lista = (ListaReproduccion) request.getAttribute("listaReproduccion"); %>
		<% if (lista != null) { %>
			<div>
				<div class="tituloLista">
					<h1 id="nombreLista" data-id="<%=lista.getIdLista() %>"><%=lista.getNombre() %></h1>
					<input id="txtNombreLista" class="oculto" type="text" value="<%=lista.getNombre() %>" maxlength="30">
					<button id="editarNombre" onclick="editarNombreLista()">&#9998;</button>
				</div>
				<ol id="listaCanciones">
				<% for (Cancion cancion : lista.getCanciones()) { %>
					<li data-id="<%=cancion.getIdCancion() %>" class="cancion-item" draggable="true"><%=cancion.getTitulo() %></li>
				<% } %>
				</ol>
			</div>
			<div>
				<input type="button" value="Guardar cambios" onclick="guardarOrden()">
			</div>
			<div id="mensajeLista"></div>
		<% } %>
		<script type="text/javascript" src="scripts/editarLista.js"></script>
	</body>
</html>	