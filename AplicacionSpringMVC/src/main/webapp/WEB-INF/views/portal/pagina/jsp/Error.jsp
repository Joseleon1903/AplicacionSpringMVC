<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>SpringMVC Application</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<link rel="stylesheet" type="text/css" href="<c:url value="/static/resources/css/estilo.css"/>"/>
<link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css"
	integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w"
	crossorigin="anonymous">
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
		<!-- ********* inicio DIV contenido principal ***********-->
	<div class="container-contenido">
	<div id="box_error">
	<div class="inmagen_error">
	<img src="<c:url value="/static/resources/inmagenes/jpg/website_error.jpg"/>" >
	</div>
	
	<div class=mensaje_error>
	<h1>Error intentando cargar la pagina </h1>
	<p>The server can only generate a response that is not accepted by the client</p>
	</br>
	<p>El navegador puede continuar realizando su petici�n, intente realizarla de nuevo.</p>
	</br>ErrorPageBean
	<p>Nos discupamos por los incovenientes.</p>
	<p>Codigo que genero el error: <c:out value="${ErrorPageBean.codigo}"/></p>
	<p>Descripcion: <c:out value="${ErrorPageBean.mensajeError}"/></p>
	</div>	
	</div>	
	</div>
	<!-- ********* Final DIV principal *********** -->

    </div>
    <!-- ********* Fin DIV contenido principal ***********-->

   <!-- *************contenedor footer de fin de pagina inicio codigo ************ -->
     <%@ include file="../html/footer.html" %>
   <!-- *************contenedor footer de fin de pagina final codigo ************ -->


</body>
</html>