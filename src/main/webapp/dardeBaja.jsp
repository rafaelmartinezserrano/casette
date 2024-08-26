<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>Eliminara tu cuenta</h1>
		
		<form action="DarDeBaja" method="post">
			
			<label>Estas seguro de darte de baja ?</label>
			<ol>
				<li> Confirme introduciendo su clave</li>
				<li> Darle al boton de "Borrar usuario"</li>
			</ol>
			
			<label for="txtClave1">Ingresa su contraseña para darte de baja</label>
				<input type="password" name="claveActual" id="txtClave1" placeholder="Ingresa tu Contraseña"/>
				
			<input id="btnDarDeBja" type="submit" value="Borrar usuario">
		</form>
		
		<div id="ErrorClacve" >
			
		</div>
</body>
</html>