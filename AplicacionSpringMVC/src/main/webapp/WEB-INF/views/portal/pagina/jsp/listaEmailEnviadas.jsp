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

    <!-- *************contenedor menu fildtros de busqueda codigo ************ -->
	<div class="form-filtro-mail">
		<form class="pure-form" action="">
		<label>Filtrar email por: </label>
			<input class="pure-input-1-4" type="text" placeholder="Usuario envio">
			<input class="pure-input-1-4" type="text" placeholder="Asunto">
			<input class="pure-input-1-4" type="text" placeholder="Destinatario">
			<label for="state">Estado</label>
	        <select id="state">
	            <option>OK</option>
	            <option>RE</option>
	        </select>
		</form>
	</div>

	<!-- *************contenedor menu fildtros de busqueda Fin codigo ************ -->

    <!-- ********* inicio DIV contenido principal ***********-->
	<div class="container-contenido">
		<div class="table-main-enviadas">
			<table class="pure-table pure-table-bordered">
				<thead>
					<tr>
						<th>ENVIO ID</th>
						<th>FECHA ENVIO EMAIL</th>
						<th>USUARIO ENVIO</th>
						<th>ASUNTO</th>
						<th>DESTINATARIO</th>
						<th>ESTADO</th>
						<th>OPCIONES</th>
					</tr>
				</thead>
	
				<tbody>
					<tr>
						<td>1</td>
						<td>2017-06-16T00:00:00</td>
						<td>ADMIN1</td>
						<td>Personal 1</td>
					    <td>numero1@gmail.com</td>
						<td>OK</td>
						<td>
						<img alt="[NOT FOUND  ERROR] Objeto solicitado no encontrado" id="inmagen-detalle" src="../../inmagenes/png/free-icon/options-icon.png">
						<button class="pure-button" onclick="llamandoRest()" ><i class="fa fa-cog"></i>Detalles</button>
						</td>
					</tr>
	
					<tr>
						<td>2</td>
						<td>2017-06-16T00:00:00</td>
						<td>ADMIN1</td>
						<td>Personal 2</td>
					    <td>numero2@gmail.com</td>
						<td>RE</td>
						<td>
						<img alt="[NOT FOUND  ERROR] Objeto solicitado no encontrado" id="inmagen-detalle" src="../../inmagenes/png/free-icon/options-icon.png">
						<button class="pure-button"><i class="fa fa-cog"></i>Detalles</button>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>	
    <!-- ********* final DIV contenido principal ***********-->

   <!-- *************contenedor footer de fin de pagina inicio codigo ************ -->
     <%@ include file="../html/footer.html" %>
   <!-- *************contenedor footer de fin de pagina final codigo ************ -->

</body>
</html>