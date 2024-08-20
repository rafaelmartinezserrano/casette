<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang = "es">

<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="iniciarSesion.css"/>
<title>Cassette</title>
</head>
<body>

<header class="cabecera">
	<h1> Cassette</h1>
</header>
	
	
	<section id="seccionLogin">
	<form action="IniciarSesion" method="post">
	
	<div>
	<label for ="txtUserName">Nombre de usuario:</label>
	<input type ="text" name="userName" id="userName"/>
	</div>
	<div>
	<label for ="txtPassword">Clave:</label>
	<input type ="password" name="password" id="txtPassword"/>
	</div>
	<div>
	<input type="checkbox" name="recordarUsuario" id="chkRecordarUsuario" value=""/><label for="chkRecordarUsuario"> Recordar usuario</label>
	
	</div>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
	<div>
	<input type="submit" value="Enviar" />
	</div>
	<% String mensajeError = (String)request.getAttribute("errorLogin"); %>
	<% if (mensajeError != null) { %>
		<div class="error"><%=mensajeError %></div>
	<%} %>
	
	</form>
	<div id="eresNuevo">  Eres nuevo ?<a href = "Registro.jsp"> Regístrate aquí </a> </div>
	</section>

</body>
</html>

</body>
</html>