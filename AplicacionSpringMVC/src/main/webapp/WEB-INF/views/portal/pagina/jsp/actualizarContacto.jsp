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
	
	 <!-- *************contenedor mensaje error codigo ************ -->
		<div id="pop-up-mensaje">
	   <script type="text/javascript">
			var descripcionError = "<c:out value="${SessionUsuario.mensajeError}"/>";
			if (descripcionError != "NONE" && descripcionError != "") {
				erroPagina = true;
				showMensajeError(InternalServerError, descripcionError);
			}else{
				erroPagina = false;
			}
		</script>
			<div class="container-error-pop">
				<img alt="ICON NOT FOUND" src="<c:url value="/static/resources/inmagenes/png/free-icon/Error-Icono.png"/>" />
				<p id="codigoError">[CODIGO ERROR] </p>
				<p id="descripcion"><c:out value="${SessionUsuario.mensajeError}"/></p>
			</div>
		</div>
    <!-- *************contenedor mensaje error Fin codigo ************ -->
	
		<div class="form-actualizar-usuario">
		<h1>Actualizar informacion usuario sistema</h1>
		    <form:form modelAttribute="ActualizarUsuarioBean" name="actualizarUsuario" id="form-3" method="post" class="pure-form pure-form-aligned">
		    
					<fieldset>
						<div class="pure-control-group">
							<label for="nombre">Nombre</label> 
							<form:input path="nombre" id="nombre" type="text" placeholder="Nombre Usuario" /> 
						</div>
					</fieldset>
					
					<fieldset>
						<div class="pure-control-group">
							<label for="apellido">Apellido</label> 
							<form:input path="apellido"  id="apellido" type="text" placeholder="Apellido Usuario" /> 
						</div>
					</fieldset>
		
					<fieldset>
						<div class="pure-control-group">
							<label for="sexo" class="pure-radio">Sexo </label>
							<form:radiobutton path="sexo" name="sexo" value="F" />Female
							<form:radiobutton path="sexo" name="sexo" value="M" />Male
						</div>
					</fieldset>
					
					<fieldset>
						<div class="pure-control-group">
						<label for="fechaNacimiento" class="pure-radio">Fecha nacimiento</label>
						<form:input path="fechaNacimiento" id="fechaNacimiento" type="date" name="fecha" />
						</div>
					</fieldset>
		
					<fieldset>
					<div class="pure-control-group">
					<label for="email">Email usuario</label>
					<form:input path="email" pattern="^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$" id="email" type="email" placeholder="Email" />
					</div>
					</fieldset>
		
					<fieldset>
						<div class="pure-control-group">
							<label for="name">Username</label>
							<form:input path="username" id="username" type="text" placeholder="Username" /> 
						</div>
					</fieldset>
				
		            <fieldset>
						<div class="pure-control-group">
							<label for="emailAlternatriva">Email alternatriva</label>
							<form:input path="emailAlternativa" id="emailAlternatriva" type="text" placeholder="Email alternatriva" /> 
						</div>
					</fieldset>
					<fieldset>
						<div class="pure-control-group">
							<label for="Direccion">Direccion</label>
							<form:input path="direccion" id="Direccion" type="text" placeholder="Direccion" /> 
						</div>
					</fieldset>
					<fieldset>
						<div class="pure-control-group">
							<label for="Telefono">Telefono</label>
							<form:input path="telefono" id="Telefono" type="text" placeholder="Telefono" /> 
						</div>
					</fieldset>
					<fieldset>
						<div class="pure-control-group">
							<label for="Celular">Celular</label>
							<form:input path="celular" id="Celular" type="text" placeholder="Celular" /> 
						</div>
					</fieldset>
					
					<fieldset>
						<div>
							<button type="submit" class="pure-button pure-button-primary">Actualiza</button>
							<button type="submit" class="pure-button pure-button-primary">Salir</button>
						</div>
					</fieldset>
				</form:form>
			</div>
		</div>
		<!-- ********* Final DIV principal *********** -->


   <!-- *************contenedor footer de fin de pagina inicio codigo ************ -->
     <%@ include file="../html/footer.html" %>
   <!-- *************contenedor footer de fin de pagina final codigo ************ -->

</body>
</html>