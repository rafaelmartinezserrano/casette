<%@page import="com.afd.casette.modelo.Cancion"%>
<%@page import="com.afd.casette.modelo.ListaReproduccion"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Reproducir Lista</title>
	</head>
	<body>
		<% ListaReproduccion lista = (ListaReproduccion) request.getAttribute("listaReproduccion"); %>
		<% if (lista != null) { %>
			<div>
				<div class="tituloLista">
					<h1 id="nombreLista"><%=lista.getNombre() %></h1>
					<h2>
						<input type="button" value="Reproducir lista" onclick="reproducirLista();"/>
						<input type="button" value="Orden aleatorio" onclick="ordenAleatorio();"/>
						<label for="chkBucle">En bucle</label> <input type="checkbox" checked id="chkBucle"/>
					</h2>
				</div>
				<ol id="listaCanciones">
				<% for (int pos = 0; pos < lista.getCanciones().size(); pos++) { %>
					<% Cancion cancion = lista.getCanciones().get(pos); %>
					<li>
						<span><%=cancion.getTitulo() %></span>
						<audio controls="controls" id="cancion-<%=pos%>" onended="siguienteCancion();" onplaying="pararOtras(this)">
							<source src="../FICHEROS/<%=cancion.getUsuario().getIdUsuario()%>/MUSICA/<%=cancion.getArchivo()%>">
						</audio>
					</li>
				<% } %>
				</ol>
			</div>
		<% } %>
		
		<script src="scripts/reproducir.js"></script>
	</body>
</html>