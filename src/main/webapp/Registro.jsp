<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro</title>
</head>
<body>

	<div>
		<form action="Registro" method="post" autocomplete="off">
			<ul>
				<li><label for="txtNombreUsuario">Nombre de usuario:</label><input
					type="text" name="nombreUsuario" id="txtNombreUsuario" required /></li>
				<li><label for="txtClave">Clave:</label><input type="password"
					name="clave" id="txtClave" maxlength="25" required></li>
				<li><label for="txtReClave">Repetir clave:</label><input type="password" name="clave" id="txtReClave" maxlength="25" required></li>
				<li>
					<label for="dateFechaNacimiento">Fecha de nacimiento:</label><input type="date" id="dateFechaNacimiento" name="fechaNacimiento"/>
				</li>
				<li><label for="txtEmail">Email:</label><input type="email"
					id="txtEmail" name="email" required /></li>

				<li><input type="submit" value="Registrar nuevo usuario"></li>

			</ul>


		</form>
	</div>
	
	<% String mensajeError = (String)request.getAttribute("error"); %>
	<% if (mensajeError != null) { %>
		<div class="error"><%=mensajeError %></div>
	<%} %>
</body>
</html>