<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
	<head>
		<meta charset="UTF-8">
		<link type="text/css" rel="stylesheet" href="principal.css"/>
		<title>Subir Cancion</title>
		<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Dosis:wght@200..800&family=Kanit:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">

	</head>
	<body>
		
		<%@include file="Menu.jsp" %>
		<header>
			<h1>Casette</h1>
			<h3>Subir canción</h3>
		</header>
		<form action="SubirCancion" method="post" enctype="multipart/form-data" id="menuSubir">
			<fieldset>
				<legend>Datos de la canción:</legend>
				<div>
					<label for="txtTitulo">Titulo:</label>
					<input type="text" name="titulo" id="txtTitulo"/>
				</div>
				<div>
					<label for="txtGenero">Genero:</label>
					<input type="text" name="genero" id="txtGenero"/>
				</div>
				<div>
					<label for="txtAutor">Autor:</label>
					<input type="text" name="autor" id="txtAutor"/>
				</div>
				<div>
					<label for="txtDuracion">Duración:</label>
					<input type="text" name="duracion" id="txtDuracion"/>
				</div>
				<div>
					<label for="txtAnho">Año:</label>
					<input type="number" name="anho" id="txtAnho"/>
				</div>
				<div>
					<input type="checkbox" name="privada" id="txtPrivada"/>
					<label for="txtPrivada">La canción es privada</label>
				</div>
			</fieldset>
			<fieldset>
				<legend>Archivos:</legend>
				<div>
					<label for="slcTipoArchivo">Tipo de archivo:</label>
					<select id="slcTipoArchivo" name="tipoArchivo">
						<option value="AUDIO">Audio</option>
						<option value="VIDEO">Video</option>
					</select>
				</div>
				<div>
					<label for="filePortada">Portada:</label>
					<input type="file" name="portada" id="filePortada"/>
				</div>
				<div>
					<label for="fileArchivo">Archivo:</label>
					<input type="file" name="archivo" id="fileArchivo"/>
				</div>
				<div>
					<input type="submit" value="Subir canción"/>
				</div>
			</fieldset>
			
			
		
		</form>

	</body>
</html>