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

    <!-- *************contenedor contenido codigo inicio ************ -->
	<div class="form-envio-email">
	    <h1>Formulario para enviar email</h1>
		<form name="envioEmail" action="EnviarEmail/enviarEmail" id="form-4" method="post" class="pure-form">
			  <fieldset>
			  	<div class="pure-group">
				<input type="email" id="destinatario" name="destinatario" pattern="^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$" placeholder="Destinatario" 
				value="<c:out value="${EnviarMailBean.destinatario}"/>" required>
			</div>
			</fieldset>
			 <fieldset>
			  	<div class="pure-group">
				<input type="text" id="asunto" name="asunto" placeholder="Asunto" value="<c:out value="${EnviarMailBean.asunto}"/>" required>
			</div>
			</fieldset>

			<fieldset>
			<div class="pure-group">
				<textarea id="contenido" name="contenido" placeholder="Textareas work too" value="<c:out value="${EnviarMailBean.contenido}"/>" required> </textarea>
			</div>
			</fieldset>
			
			<fieldset>
			<div class="pure-group">
			<input type="submit" class="pure-button pure-input-1-2 pure-button-primary" value="Envio" />
			</div>
			</fieldset>
			
		</form>
	</div>
    <!-- *************contenedor contenido codigo final ************ -->

   <!-- *************contenedor footer de fin de pagina inicio codigo ************ -->
     <%@ include file="../html/footer.html" %>
   <!-- *************contenedor footer de fin de pagina final codigo ************ -->

</body>
</html>