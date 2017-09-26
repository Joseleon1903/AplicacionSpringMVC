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
				showMensajeError(InvalidUserException, descripcionError);
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
	
		<div class="form-registrar-usuario-marco">

		<div class="form-registrar-usuario">
		        <h1>Formulario de registro</h1>
				<form:form modelAttribute="UsuarioBean" name="registrarUsuario" id="form-2" method="post" class="pure-form pure-form-aligned">
					
					<fieldset>
						<div class="pure-control-group">
							<label for="nombre">Nombre</label> 
							<form:input path="nombre" type="text" placeholder="Nombre Usuario" /> 
						</div>
					</fieldset>
					
					<fieldset>
						<div class="pure-control-group">
							<label for="apellido">Apellido</label> 
							<form:input path="apellido" type="text" placeholder="Apellido Usuario" /> 
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
						<form:input path="fechaNacimineto" id="fechaNacimiento" type="date" name="fecha" />
						</div>
					</fieldset>
		
					<fieldset>
					<div class="pure-control-group">
					<label for="email">Email usuario</label>
					<form:input path="email" pattern="^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$" type="email" placeholder="Email" />
					</div>
					</fieldset>
		
					<fieldset>
						<div class="pure-control-group">
							<label for="codigoUsuario">Username</label>
							<form:input path="username" type="text" placeholder="Username" /> 
						</div>
					</fieldset>
		
					<fieldset>
						<div class="pure-control-group">
							<label for="password">Password</label>
							<form:input path="password" type="password" placeholder="Password" /> 
						</div>
					</fieldset>
					
					<fieldset>
						<div class="pure-control-group">
							<label for="password-2">Confirmar Password</label>
							<form:input path="confirmarPassword" type="password" placeholder="Password" /> 
						</div>
					</fieldset>
					
					<fieldset>
						<div class="pure-control-group" >
					      <input class="pure-button" id="boton-detalle" onclick="showFormularioDatosAdicionales('detalle-contacto-field')" type="text" value="Agregar informacion adicional" readonly/>
					    </div>
				    </fieldset>
				    
				    <fieldset class="detalle-contacto-field">
						<div class="pure-control-group">
							<label for="emailAlternativa">Email alternativa</label>
							<form:input path="emailAlternativa" type="email" placeholder="Email Alternativa" /> 
						</div>
					</fieldset>
					
					 <fieldset class="detalle-contacto-field">
						<div class="pure-control-group">
							<label for="direccion">Direccion Usuario</label>
							<form:input path="direccion" type="text" placeholder="Dirección" /> 
						</div>
					</fieldset>
					
					 <fieldset class="detalle-contacto-field">
						<div class="pure-control-group">
							<label for="telefono">Telefono</label>
							<form:input path="telefono" type="text" placeholder="Telefono" /> 
						</div>
					</fieldset>
					
					 <fieldset class="detalle-contacto-field">
						<div class="pure-control-group">
							<label for="celular">Celular</label>
							<form:input path="celular" type="text" placeholder="Celular" /> 
						</div>
					</fieldset>
				    
					<fieldset>
						<div>
							<input type="submit" value="Registrate ahora" class="pure-button pure-button-primary" />
						</div>
					</fieldset>
				</form:form>
			</div>
			
		</div>
	</div>
  <!-- ********* Final DIV contenido principal ***********-->



   <!-- *************contenedor footer de fin de pagina inicio codigo ************ -->
     <%@ include file="../html/footer.html" %>
   <!-- *************contenedor footer de fin de pagina final codigo ************ -->

</body>
</html>