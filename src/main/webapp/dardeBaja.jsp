<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="principal.css"/>
		<title>Eliminar cuenta</title>
		<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Dosis:wght@200..800&family=Kanit:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
</head>
<body>
	<%@include file="Menu.jsp" %>
		<header>
			<h1>Casette</h1>
			<h3>Eliminar cuenta</h3>
		</header>
		
		<form action="DarDeBaja" method="post" id="formBaja">
			<fieldset>
				<label>¿Esta seguro que quiere eliminar su cuenta?</label>
			<ol>
				<li>Confirme introduciendo su clave</li>
				<li>Darle al boton de "Borrar usuario"</li>
			</ol>
			
			<label for="txtClave1">Ingrese su contraseña para darle de baja</label>
				<input type="password" name="claveActual" id="txtClave1" placeholder="Ingresa tu Contraseña"/>
				
			<input id="btnDarDeBja" type="submit" value="Borrar usuario">
		</form>
		
		<div id="ErrorClacve" >
			
		</div>
			</fieldset>
			
		<script src="nav.js"></script>
</body>
</html>