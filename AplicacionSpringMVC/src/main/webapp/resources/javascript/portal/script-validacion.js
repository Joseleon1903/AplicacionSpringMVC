/**
 * variable globales
 */
var erroPagina =  false;
var menuAdicional= true;

/** ----------------------------------------------*/ 

alert('inicio');
/**
 * funcion al cargar la pagina
 */
window.onload = function() {
	alert('Al cargar la pagina');
	entering('entrando en el metodo para inicialisacion al carcar la pagina..');
	validarSessionUsuario();
	buscarMotivoEstadoSistema();
	//motivosSistema.unshift(new MotivoEstadoSistema(404, mensajeCampoRequerido));
	//alert('motivoId: '+buscarMotivoPorId(404).motivoId+ 'descripcion: '+buscarMotivoPorId(404).descripcion);
	
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
		showMensajeError(buscarMotivoPorId(DatoRequeridoNoProporcionado).motivoId, buscarMotivoPorId(DatoRequeridoNoProporcionado).descripcion);
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

function redireccionarPagina(url){
	entering("redireccionarPagina");
	parametro('password', url);
	window.location.replace(url);
	exiting("redireccionarPagina");
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
	showMensajeError(buscarMotivoPorId(InvalidUserException).motivoId, buscarMotivoPorId(InvalidUserException).descripcion);
	}
}

function showMensajeError(codigo, mensajeError ){
	entering("showMensajeError");
	parametro("mensajeError", mensajeError);
	if (erroPagina) {
	var elementoError = document.getElementById("pop-up-mensaje");
	parametro('style', elementoError.style.display);
	elementoError.style.display = 'inline';
	var inmageError = '<img alt="ICON NOT FOUND" src="inmagenes/png/free-icon/Error-Icono.png" />';
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

/**
 * Funcion  para validar si el usuario no esta ya loguedo o se ha loguedo corectamente..
 * @returns
 */
function validarSessionUsuario(){
	entering("validarSessionUsuario");
	
	
	exiting('validarSessionUsuario');

}