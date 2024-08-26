<%@page import="com.afd.casette.modelo.ListaReproduccion"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<% List<ListaReproduccion> listas = (List<ListaReproduccion>)request.getAttribute("listas"); %>
		<% for (ListaReproduccion lista : listas) { %>
			<div><%=lista.getNombre() %> <a href="CargarLista?idLista=<%=lista.getIdLista()%>">Editar lista</a> <a href="">Reproducir</a></div>
		<% } %>
	</body>
</html>