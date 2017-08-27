<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>SpringMVC Application</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<!-- <link rel="stylesheet" href="../../resources/css/estilo.css"> -->
<link rel="stylesheet" type="text/css" href="<c:url value="/static/resources/css/estilo.css"/>"/>

<link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css"
	integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w"
	crossorigin="anonymous">
</head>
<script type="text/javascript" src="<c:url value="/static/resources/javascript/portal/logger-script.js"/>"></script>
<script type="text/javascript" src="<c:url value="/static/resources/javascript/portal/script-servicios-rest.js"/>"></script>
<script type="text/javascript" src="<c:url value="/static/resources/javascript/portal/script-servicios-contantes.js"/>"></script>
<script type="text/javascript" src="<c:url value="/static/resources/javascript/portal/script-validacion.js"/>"></script>
<script type="text/javascript" src="<c:url value="/static/resources/javascript/portal/logger-script.js"/>"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<body>
<body>
    <!-- *************contenedor menu de navegacion inicio codigo ************ -->
	<div class="navegacion-container-menu">
		<div class="menu-navegacion">
			<div class="pure-menu pure-menu-horizontal">
				<ul class="pure-menu-list">
				    <li class="pure-menu-item">
					<a href="index.jsp" class="pure-menu-link">Home</a>
					</li>
					<li class="pure-menu-item">
					<a href="portal/pagina/jsp/registrarUsuario.jsp" class="pure-menu-link">Registrar usuario</a>
					</li>
					<li class="pure-menu-item">
					<a href="portal/pagina/jsp/actualizarContacto.jsp" class="pure-menu-link">Actualizar usuario</a>
					</li>
					<li class="pure-menu-item">
					<a href="portal/pagina/jsp/enviarEmail.jsp" class="pure-menu-link">Enviar email</a>
					</li>
					<li class="pure-menu-item">
					<a href="portal/pagina/jsp/listaMailEnviadas.jsp" class="pure-menu-link">Ver lista email</a>
					</li>
				</ul>
			</div>
		</div>
	</div>
    <!-- *************contenedor menu de navegacion Fin codigo ************ -->

    <!-- ********* inicio DIV contenido principal ***********-->
	<div class="container-contenido">
	
	 <!-- *************contenedor mensaje error codigo ************ -->
	 <div id="pop-up-mensaje">
		 
    </div>
    <!-- *************contenedor mensaje error Fin codigo ************ -->
   
	
	<div class="form-login-marco">
	
		<div class="form-login">
		  <img alt="[NOT FOUND  ERROR] Objeto solicitado no encontrado" src="<c:url value="/static/resources/inmagenes/png/free-icon/login-inmg.png"/>">
			<form name="login" id="form-1" method="post"  onsubmit="event.preventDefault()" class="pure-form pure-form-aligned">
				<fieldset>
					<div class="pure-control-group">
						<label for="name">Username</label> 
						<input id="name" type="text" onblur="validarNotNull('name')" placeholder="Username" required/> 
					</div>
				</fieldset>
	
				<fieldset>
					<div class="pure-control-group">
						<label for="password">Password</label>
						<input id="password" type="password"  onblur="validarNotNull('password')" placeholder="Password" required/> 
					</div>
				</fieldset>
	
				<fieldset>
					<div>
						<button type="submit" onclick="validarDatosFormulario()" class="pure-button pure-button-primary">Login</button>
						<button type="reset" onclick="redireccionarPagina('portal/contenido/registrarUsuario.html')" class="pure-button pure-button-primary">Registrate ahora</button>
					</div>
				</fieldset>
			</form>
			
		  </div>
		</div>
	</div>
<!-- ********* Final DIV contenido principal *********** -->

	<div class="container-footer">
		<div class="footer-inside">
			
			<div id="boxfooter_left">
			<p>2017 Copyright. All Rights Reserved.</p>
				<p>The Sponsored Listings displayed above are served automatically by a third party.</p>
				<p>Neither the service provider nor the domain owner maintain any relationship with the advertisers.</p>
				<p>In case of tradem  ark issues please contact the domain owner directly (contact information can be found in whois).</p>
				<br></br>
			</div>
			
			<div id="boxfooter_right">
			  <table>
			  <tbody>
			  <tr>
			  <td><img alt="[NOT FOUND  ERROR] Objeto solicitado no encontrado" id="inmagen-footer" src="<c:url value="/static/resources/inmagenes/png/free-icon/email-icon.png"/>">   </td>
			  <td>
			      <p id="parrafo-tabla"> Gracias al motor de Aplicacion es posible enviar numerosos mensajes de correo electronico,</p>
			      <p id="parrafo-tabla"> aún sin un servidor SMTP, haciendo que el envío de mensajes sea más fácil y seguro en comparación con otros clientes de e-mail comunes.</p>
			      <p id="parrafo-tabla"> Cada mensaje es enviado por separado. La privacidad de los destinatarios se encuentra protegida.</p>
			  </td>
			  </tr>
			  
			  </tbody>
			  </table>
			  
			</div>

		</div>
	</div>
</body>
</body>
</html>
