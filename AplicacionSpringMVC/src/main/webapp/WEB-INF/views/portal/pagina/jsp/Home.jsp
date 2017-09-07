<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Pagina de home jsp</h1>
	<h5>Usuario Id: <c:out value="${user.usuarioId}"/></h5>
	<h5>Fecha Creacion: <c:out value="${user.fechaCreacion}"/></h5>
	<h5>Fecha Creacion: <c:out value="${user.fechaCreacion}"/></h5>
	
	<h5>Session Usuario autenticado : <c:out value="${usuarioSession.autenticado}"/></h5>
	<h5>Session Usuario: <c:out value="${usuarioSession.nombre}"/></h5>
	<h5>Session Usuario Id: <c:out value="${usuarioSession.usuarioId}"/></h5>

</body>

</html>