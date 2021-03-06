<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>SpringMVC Application</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css"
	integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="<c:url value="/static/resources/css/estilo.css"/>"/>
</head>
<script type="text/javascript" src="<c:url value="/static/resources/javascript/portal/logger-script.js"/>"></script>
<script type="text/javascript" src="<c:url value="/static/resources/javascript/portal/script-servicios-contantes.js"/>"></script>
<script type="text/javascript" src="<c:url value="/static/resources/javascript/portal/script-validacion.js"/>"></script>
<script type="text/javascript" src="<c:url value="/static/resources/javascript/portal/Proxy-Menu-Navegacion.js"/>"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<body>

   <!-- *************contenedor menu de navegacion inicio codigo ************ -->
     <%@ include file="../html/header.html" %>
   <!-- *************contenedor menu de navegacion Fin codigo ************ -->

    <!-- ********* inicio DIV contenido principal ***********-->
	<div class="container-contenido">
		<div id="cuadro-menu">
			<div class="box-selector-1">
				<h1>Enviar nueva email</h1>
				<img alt="Imposible cargar inmagen." src="<c:url value="/static/resources/inmagenes/png/free-icon/Email-send-icon.png"/>" >
				<button type="button" id="search" onclick="redirigirLink(PaginaEnviarEmail)" class="button-large pure-button">Enviar</button>
			</div>

			<div class="box-selector-2">
				<h1>Ver lista email</h1>
				<img alt="Imposible cargar inmagen." src="<c:url value="/static/resources/inmagenes/png/free-icon/list-icon.png"/>" >
				<button type="button" id="search" onclick="redirigirLink(PaginaListaEmailEnviadas)" class="button-large pure-button">Visualizar</button>
			</div>

			<div class="box-selector-3">
				<h1>Gestion usuario</h1>
				<img alt="Imposible cargar inmagen." src="<c:url value="/static/resources/inmagenes/png/free-icon/update-edit-icon.png"/>" >
				<button type="button" id="search" onclick="redirigirLink(PaginaActualizarContacto)" class="button-large pure-button">Gestionar</button>
			</div>

		</div>
	
  </div>

   <!-- *************contenedor footer de fin de pagina inicio codigo ************ -->
     <%@ include file="../html/footer.html" %>
   <!-- *************contenedor footer de fin de pagina final codigo ************ -->
   
</body>

</html>