<%@page import="com.afd.casette.modelo.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			#mensajeErrorClaveNueva,.mensajeErrorClave {
				color: red;
			}
			.mensajeClaveCambiada {
				color: green;
			}
		</style>
	</head>
	<body>
		<h1>Cambiar contraseña</h1>
		<% String mensajeErrorConexion = (String) request.getAttribute("mensajeErrorConexion"); %>
		<% if(mensajeErrorConexion != null) { %>
			<div class="mensajeErrorClave"><%=mensajeErrorConexion %></div>
		<% } %>
		<% String mensajeClaveCambiada = (String) request.getAttribute("mensajeClaveCambiada"); %>
		<% if(mensajeClaveCambiada != null) { %>
			<div class="mensajeClaveCambiada"><%=mensajeClaveCambiada %></div>
		<% } %>
		<form action="CambiarClave" method="post">
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
				<input type="password" name="claveNueva2" id="txtClaveNueva2" placeholder="Vuelva a escribir la nueva contraseña"/>
				<div id="mensajeErrorClaveNueva">
					<% String mensajeErrorClaveNueva = (String) request.getAttribute("mensajeErrorClaveNueva"); %>
					<% if(mensajeErrorClaveNueva != null) { %>
						<div class="mensajeErrorClave"><%=mensajeErrorClaveNueva %></div>
					<% } %>
				</div>
			</div>
			<div>
				<input id="btnCambiarClave" type="submit" value="Guardar cambios">
			</div>
		</form>
		<script type="text/javascript" src="scripts/cambiarClave.js"></script>
	</body>
</html>