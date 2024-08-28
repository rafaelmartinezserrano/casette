<%@ page language="java"  contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="principal.css"/>
    <title>Listas de reproduccion</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Dosis:wght@200..800&family=Kanit:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
</head>
<body>
    	<%@include file="Menu.jsp" %>
	<header>
		<h1>Casette</h1>
		<h3>Crear lista</h3>
	</header>
<div id="cajita_busqueda">
    <form action="CrearLista">
        <label for="txtNombreLista">Nombre de la lista:</label><input id="txtNombrelista" type="text" name="nombreLista"/>
        <input type="submit" value="Crear"/>
</div>

</form>
</body>
</html>