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

 <%@ include file="portal/pagina/html/header.html" %>
  
    <!-- ********* inicio DIV contenido principal ***********-->
	<div class="container-contenido">

	 <!-- *************contenedor mensaje error codigo ************ -->

		<div id="pop-up-mensaje">
			<div class="container-error-pop">
				<img alt="ICON NOT FOUND" src="<c:url value="/static/resources/inmagenes/png/free-icon/Error-Icono.png"/>" />
				<p id="codigoError">[CODIGO ERROR] <c:out value="${LoginBean.codigoError}"/></p>
				<p id="descripcion"><c:out value="${LoginBean.mensajeError}"/></p>
			</div>
		</div>
		
	   <script type="text/javascript">
			var codigoError = <c:out value="${LoginBean.codigoError}"/>;
			var descripcionError = "<c:out value="${LoginBean.mensajeError}"/>";
			if (codigoError != undefined || codigoError != "") {
				erroPagina = true;
				showMensajeError(codigoError, descripcionError);
			}
		</script>
     <!-- *************contenedor mensaje error Fin codigo ************ -->

	<div class="form-login-marco">
		<div class="form-login">
		   <img alt="[NOT FOUND  ERROR] Objeto solicitado no encontrado" src="<c:url value="/static/resources/inmagenes/png/free-icon/login-inmg.png"/>">
			<form name="login" action="formularioLogin" id="form-1" method="post" class="pure-form pure-form-aligned">
				<fieldset>
					<div class="pure-control-group">
						<label for="name">Username</label> 
						<input id="name" name="name" type="text" onblur="validarNotNull('name')" placeholder="Username" value="<c:out value="${LoginBean.codigoUsuario}"/>" required/> 
					</div>
				</fieldset>
	
				<fieldset>
					<div class="pure-control-group">
						<label for="password">Password</label>
						<input id="password" name="password" type="password"  onblur="validarNotNull('password')" placeholder="Password" value="<c:out value="${LoginBean.password}"/>" required/> 
					</div>
				</fieldset>
	
				<fieldset>
					<div>
						<input type="submit" class="pure-button pure-button-primary" value="Login" />
						<button type="reset" onclick="redirigirLink(PaginaRegistrarUsuario)" class="pure-button pure-button-primary">Registrate ahora</button>
					</div>
				</fieldset>
			</form>
			
		  </div>
		</div>
	</div>
    <!-- ********* Final DIV contenido principal *********** -->
    
   <%@ include file="portal/pagina/html/footer.html" %>
	
</body>
</html>
