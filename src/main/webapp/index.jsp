<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang = "es">

<head>
		<meta charset="UTF-8">
		<link type="text/css" rel="stylesheet" href="iniciarSesion.css"/>
		<title>Casette</title>
		<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Dosis:wght@200..800&family=Kanit:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
</head>
<body>
	<div id="botonAbrir" onclick="abrirNav()">&#9776;</div>
		<header class="cabecera">
			<h1>Casette</h1>
			<h3>Lorem ipsum dolor</h3>
			<%-- <img src="imagenes/casette.svg" alt="casette vectorizado" id="casette" />--%>
			<svg id="casette" alt ="casette"  height="300px" width="300px" version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" 
			viewBox="0 0 512 512" xml:space="preserve">
				<g>
				<g>
		<path d="M461.913,55.652H50.087C22.468,55.652,0,78.12,0,105.739v300.522c0,27.619,22.468,50.087,50.087,50.087
			c148.444,0,264.815,0,411.826,0c27.619,0,50.087-22.468,50.087-50.087V105.739C512,78.12,489.532,55.652,461.913,55.652z
			 M143.885,422.957l16.696-33.391h190.837l16.696,33.391H143.885z M378.435,322.783h-244.87c-36.826,0-66.783-29.956-66.783-66.783
			s29.956-66.783,66.783-66.783h244.87c36.826,0,66.783,29.956,66.783,66.783S415.261,322.783,378.435,322.783z M428.522,155.826
			H83.478c-9.223,0-16.696-7.473-16.696-16.696s7.473-16.696,16.696-16.696h345.043c9.223,0,16.696,7.473,16.696,16.696
			C445.217,148.353,437.744,155.826,428.522,155.826z"/>
	</g>
</g>
<g>
	<g>
		<path d="M378.435,222.609c-18.413,0-33.391,14.978-33.391,33.391s14.978,33.391,33.391,33.391
			c18.413,0,33.391-14.978,33.391-33.391S396.848,222.609,378.435,222.609z"/>
	</g>
</g>
<g>
	<g>
		<path d="M133.565,222.609c-18.413,0-33.391,14.978-33.391,33.391s14.978,33.391,33.391,33.391s33.391-14.978,33.391-33.391
			S151.978,222.609,133.565,222.609z"/>
	</g>
</g>
<g>
	<g>
		<path d="M320.687,222.609H191.312c5.71,9.836,9.036,21.221,9.036,33.391s-3.326,23.555-9.036,33.391h129.375
			c-5.71-9.836-9.036-21.221-9.036-33.391S314.977,232.445,320.687,222.609z"/>
	</g>
</g></svg>
		</header>

	
	<section id="seccionFlotante" class="navFull">
		<div class="contenedorLogin">
			<a href="javascript:void(0)" class="botonCerrar" onclick="cerrarNav()">X</a>
			<form action="IniciarSesion" method="post" id="inicioSesion">
			
				<div>
					<label for ="txtUserName">Nombre de usuario:</label>
				</div>
				<div>
					<input type ="text" name="userName" id="userName"/>
				</div>
				<div>
					<label for ="txtPassword">Clave:</label>
				</div>
				<div>
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
		<div id="tocaContenedor"><svg id="tocadiscos" height="530px" width="530px" version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" >
			<g>
				<g>
					<path d="M422.957,105.739c-9.206,0-16.696,7.49-16.696,16.696c0,9.206,7.49,16.696,16.696,16.696
						c9.206,0,16.696-7.49,16.696-16.696C439.652,113.229,432.162,105.739,422.957,105.739z"/>
				</g>
			</g>
			<g>
				<g>
					<path d="M289.391,306.087h48.754c0.788-5.468,1.333-11.013,1.333-16.696c0-64.441-52.429-116.87-116.87-116.87
						s-116.87,52.429-116.87,116.87s52.429,116.87,116.87,116.87c46.5,0,86.627-27.369,105.432-66.783h-38.649
						c-9.223,0-16.696-7.473-16.696-16.696C272.696,313.56,280.169,306.087,289.391,306.087z M222.609,339.478
						c-27.619,0-50.087-22.468-50.087-50.087c0-27.619,22.468-50.087,50.087-50.087s50.087,22.468,50.087,50.087
						C272.696,317.01,250.228,339.478,222.609,339.478z"/>
				</g>
			</g>
			<g>
				<g>
					<path d="M222.609,272.696c-9.206,0-16.696,7.49-16.696,16.696s7.49,16.696,16.696,16.696s16.696-7.49,16.696-16.696
						S231.815,272.696,222.609,272.696z"/>
				</g>
			</g>
			<g>
				<g>
					<path d="M456.348,0H55.652C24.968,0,0,24.968,0,55.652v400.696C0,487.032,24.968,512,55.652,512h400.696
						C487.032,512,512,487.032,512,456.348V55.652C512,24.968,487.032,0,456.348,0z M89.044,72.348h233.739
						c9.223,0,16.696,7.473,16.696,16.696c0,9.223-7.473,16.696-16.696,16.696H89.044c-9.223,0-16.696-7.473-16.696-16.696
						C72.348,79.821,79.821,72.348,89.044,72.348z M89.044,439.652c-9.22,0-16.696-7.475-16.696-16.696
						c0-9.22,7.475-16.696,16.696-16.696c9.22,0,16.696,7.475,16.696,16.696C105.739,432.177,98.264,439.652,89.044,439.652z
						 M422.957,439.652c-9.22,0-16.696-7.475-16.696-16.696c0-9.22,7.475-16.696,16.696-16.696c9.22,0,16.696,7.475,16.696,16.696
						C439.652,432.177,432.177,439.652,422.957,439.652z M439.652,169.445v119.946c0,27.619-22.468,50.087-50.087,50.087h-25.463
						c-20.695,58.263-76.222,100.174-141.493,100.174c-82.853,0-150.261-67.408-150.261-150.261S139.756,139.13,222.609,139.13
						S372.87,206.539,372.87,289.391c0,5.649-0.374,11.206-0.984,16.696h17.68c9.206,0,16.696-7.49,16.696-16.696V169.445
						c-19.391-6.914-33.391-25.273-33.391-47.011c0-27.619,22.468-50.087,50.087-50.087c27.619,0,50.087,22.468,50.087,50.087
						C473.043,144.171,459.044,162.531,439.652,169.445z"/>
				</g>
			</g>
			</svg></div>
			
		</div>
		<div id="eresNuevo">  ¿Eres nuevo? <a href = "Registro.jsp"> Regístrate aquí </a> </div>
	</section>
	
	<script src="nav.js"></script>
</body>
</html>