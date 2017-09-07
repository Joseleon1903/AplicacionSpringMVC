/**
 * variable globales
 */
var erroPagina = false;
var menuAdicional= true;

/** ----------------------------------------------*/ 

/**
 * funcion al cargar la pagina
 */
window.onload = function() {
	entering('entrando en el metodo para inicialisacion al carcar la pagina..');
	exiting('saliendo en el metodo inicialisacion al carcar la pagina..');
}

/**
 * 
 * @param inputId
 * @returns true si el campo esta vacio false si tiene valor
 */
function validarNotNull(inputId){
	entering("validarNotNull");
	parametro('password', inputId);
	var elemento = document.getElementById(inputId);
	parametro('contenido text', elemento.value);
	if (elemento.value =='' || elemento == undefined || elemento.value == null) {
		erroPagina = true;
		showMensajeError(1603, 'INTERNAL SERVER ERROR');
		elemento.style.border = 'solid';
		elemento.style.borderColor= 'red';
		exiting("validarNotNull");
		return true;
	}
	else{
		erroPagina = false;
		showMensajeError();
		elemento.style.border = 'none';
		exiting("validarNotNull");
		return false;
	}
}

function optenerValorCampo(idCampo){
	entering("optenerValorCampo");
	parametro('idCampo', idCampo);
	if (!validarNotNull(idCampo)) {
		var campo= document.getElementById(idCampo);
		return campo.value;
	}
	error("Atencion el campo no tiene valor..");
	exiting("optenerValorCampo");
}

function validarDatosFormulario(){
	entering("validarDatosFormulario");
	nombre = optenerValorCampo("name");
	password = optenerValorCampo("password");
	var usuarioValido = validarUsuarioSistema(nombre,password);
	if (usuarioValido) {
		erroPagina= false;
	}else{
	//validacion usuario sistema inicio final
	erroPagina =  true;
	info('El usuario es invalido');
	showMensajeError(1603, 'INTERNAL SERVER ERROR');
	}
}

function showMensajeError(codigo, mensajeError ){
	entering("showMensajeError");
	parametro("mensajeError", mensajeError);
	if (erroPagina) {
	var elementoError = document.getElementById("pop-up-mensaje");
	parametro('style', elementoError.style.display);
	elementoError.style.display = 'inline';
	var inmageError = '<img alt="ICON NOT FOUND" src="<c:url value="/static/resources/inmagenes/png/free-icon/Error-Icono.png"/>" />';
	var parrafoCodigo = '<p> [CODIGO ERROR] '+codigo+'</p>';
	var parrafoMensaje= '<p>'+mensajeError+'</p>'; 
	elementoError.innerHTML='<div class="container-error-pop">'+inmageError+parrafoCodigo+parrafoMensaje+'</div>';
	exiting("showMensajeError");
	}
}


function showFormularioDatosAdicionales(idcampos){
	entering("showFormularioDatosAdicionales");
	parametro("idcampos", idcampos);
	var elementos = document.getElementsByClassName(idcampos);
	if (menuAdicional) {
		for (var i = 0; i < elementos.length; i++) {
			var array_element = elementos[i];
				array_element.style.display= 'block';
		}
		menuAdicional = false;
	}else{
		for (var i = 0; i < elementos.length; i++) {
			var array_element = elementos[i];
				array_element.style.display= 'none';
		}
		menuAdicional = true;
	}
	exiting('showFormularioDatosAdicionales');
}