<%@page import="com.afd.casette.modelo.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
	<head>
		<meta charset="UTF-8">
		<link type="text/css" rel="stylesheet" href="principal.css"/>
		<title>Cambiar contraseña</title>
		<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Dosis:wght@200..800&family=Kanit:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
	</head>
	<body>
		<%@include file="Menu.jsp" %>
		<header>
			<h1>Casette</h1>
			<h3>Cambiar contraseña</h3>
		</header>
		<% String mensajeErrorConexion = (String) request.getAttribute("mensajeErrorConexion"); %>
		<% if(mensajeErrorConexion != null) { %>
			<div class="mensajeErrorClave"><%=mensajeErrorConexion %></div>
		<% } %>
		<% String mensajeClaveCambiada = (String) request.getAttribute("mensajeClaveCambiada"); %>
		<% if(mensajeClaveCambiada != null) { %>
			<div class="mensajeClaveCambiada"><%=mensajeClaveCambiada %></div>
		<% } %>
		<form action="CambiarClave" method="post" id="cambioForm">
			<fieldset>
				<div>
					<label for="txtClaveActual">Contraseña actual</label>
					<input type="password" name="claveActual" id="txtClaveActual" placeholder="Contraseña actual"/>
					<% String mensajeClaveNoValida = (String) request.getAttribute("mensajeClaveNoValida"); %>
					<% if(mensajeClaveNoValida != null) { %>
						<div class="mensajeErrorClave"><%=mensajeClaveNoValida %></div>
					<% } %>
				</div>
				
					<div>
						<label for="txtClaveNueva1">Contraseña nueva</label>
					<input type="password" name="claveNueva1" id="txtClaveNueva1" placeholder="Nueva contraseña"/>
					</div>
					<div> <input type="password" name="claveNueva2" id="txtClaveNueva2" placeholder="Vuelva a escribir la nueva contraseña"/>
						<div id="mensajeErrorClaveNueva">
							<% String mensajeErrorClaveNueva = (String) request.getAttribute("mensajeErrorClaveNueva"); %>
							<% if(mensajeErrorClaveNueva != null) { %>
								<div class="mensajeErrorClave"><%=mensajeErrorClaveNueva %></div>
							<% } %></div>
					
					</div>
				
				<div>
					<input id="btnCambiarClave" type="submit" value="Guardar cambios">
				</div>
			</fieldset>
			
		</form>
		<script type="text/javascript" src="scripts/cambiarClave.js"></script>

	</body>
</html>