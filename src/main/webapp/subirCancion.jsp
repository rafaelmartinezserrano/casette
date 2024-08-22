<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
	<head>
		<meta charset="UTF-8">
		<title>Subir Cancion</title>
	</head>
	<body>
		<form action="SubirCancion" method="post" enctype="multipart/form-data">
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
		
		</form>
	</body>
</html>