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
		 
    </div>
    <!-- *************contenedor mensaje error Fin codigo ************ -->
	
		<div class="form-registrar-usuario-marco">

		<div class="form-registrar-usuario">
		        <h1>Formulario de registro</h1>
				<form name="registrarUsuario" id="form-2" method="post"  onsubmit="event.preventDefault()" class="pure-form pure-form-aligned">
					
					<fieldset>
						<div class="pure-control-group">
							<label for="nombre">Nombre</label> 
							<input id="nombre" onblur="validarNotNull('nombre')" type="text" placeholder="Nombre Usuario" required/> 
						</div>
					</fieldset>
					
					<fieldset>
						<div class="pure-control-group">
							<label for="apellido">Apellido</label> 
							<input id="apellido" onblur="validarNotNull('apellido')" type="text" placeholder="Apellido Usuario" required/> 
						</div>
					</fieldset>
		
					<fieldset>
						 <div class="pure-control-group">				
						<label for="sexo" class="pure-radio">Sexo </label>
						<input id="sexo" type="radio" name="sexo" value="F" checked> female
						<input id="sexo" type="radio" name="sexo" value="M"> male
						</div>
					</fieldset>
					
					<fieldset>
						<div class="pure-control-group">
						<label for="fechaNacimiento" class="pure-radio">Fecha nacimiento</label>
						<input id="fechaNacimiento" type="date" name="fecha">
						</div>
					</fieldset>
		
					<fieldset>
					<div class="pure-control-group">
					<label for="email">Email usuario</label>
					<input id="email" onblur="validarNotNull('email')" pattern="^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$" type="email" placeholder="Email" required/>
					</div>
					</fieldset>
		
					<fieldset>
						<div class="pure-control-group">
							<label for="codigoUsuario">Username</label>
							 <input id="codigoUsuario" onblur="validarNotNull('codigoUsuario')" type="text" placeholder="Username" required/> 
						</div>
					</fieldset>
		
					<fieldset>
						<div class="pure-control-group">
							<label for="password">Password</label>
							<input id="password" onblur="validarNotNull('password')" type="password" placeholder="Password" required/> 
						</div>
					</fieldset>
					
					<fieldset>
						<div class="pure-control-group">
							<label for="password-2">Confirmar Password</label>
							<input id="password-2" type="password" placeholder="Password" required/> 
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
							<input id="emailAlternativa" type="email" placeholder="Email Alternativa" /> 
						</div>
					</fieldset>
					
					 <fieldset class="detalle-contacto-field">
						<div class="pure-control-group">
							<label for="direccion">Direccion Usuario</label>
							<input id="direccion" type="text" placeholder="Dirección" required/> 
						</div>
					</fieldset>
					
					 <fieldset class="detalle-contacto-field">
						<div class="pure-control-group">
							<label for="telefono">Telefono</label>
							<input id="telefono" type="text" placeholder="Telefono" required/> 
						</div>
					</fieldset>
					
					 <fieldset class="detalle-contacto-field">
						<div class="pure-control-group">
							<label for="celular">Celular</label>
							<input id="celular" type="text" placeholder="Celular" required/> 
						</div>
					</fieldset>
				    
					<fieldset>
						<div>
							<button type="submit" onclick="optenerValoresFormularioRegistrar()" class="pure-button pure-button-primary"  >Registrate ahora</button>
						</div>
					</fieldset>
				</form>
			</div>
			
		</div>
	</div>
  <!-- ********* Final DIV contenido principal ***********-->



   <!-- *************contenedor footer de fin de pagina inicio codigo ************ -->
     <%@ include file="../html/footer.html" %>
   <!-- *************contenedor footer de fin de pagina final codigo ************ -->

</body>
</html>