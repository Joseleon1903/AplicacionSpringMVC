/**
 * ***************************************************************************
 * ****  Manejadores de eventos semánticos   ****
 * ************************************************************************** 
 *
 */
// Esta técnica es una evolución del método de las funciones externas, ya que se basa en 
//utilizar las propiedades DOM de los elementos XHTML para asignar todas las funciones externas que actúan de manejadores de eventos.

 
//window.onload = function() {
//	  document.getElementById("pinchable").onclick = muestraMensaje;
//}

// Función externa
function muestraMensaje() {
  alert('Gracias por pinchar');
}
 
// Asignar la función externa al elemento
//document.getElementById("pinchable").onclick = muestraMensaje;

/**
 * ***************************************************************************
 * ****  6.3.1. Información sobre el evento   ****
 * ************************************************************************** 
 *
 */
function resalta(elEvento) {
	  var evento = elEvento || window.event;
	  switch(evento.type) {
	    case 'mouseover':
	      this.style.borderColor = 'black';
	      break;
	    case 'mouseout':
	      this.style.borderColor = 'silver';
	      break;
	  }
}

window.onload = function() {
	  document.getElementById("seccion").onmouseover = resalta;
	  document.getElementById("seccion").onmouseout = resalta;
	  
	  //script que muestra toda la información sobre los tres eventos de teclado:
	  document.onkeyup = muestraInformacion;
	  document.onkeypress = muestraInformacion;
	  document.onkeydown = muestraInformacion;
	  document.onclick = muestraInformacion;
}

/*
* Si se quiere programar una aplicación que funcione correctamente en todos los navegadores, es necesario obtener el objeto event de forma correcta según cada navegador.
* El siguiente código muestra la forma correcta de obtener el objeto event en cualquier navegador:
*/
function manejadorEventos(elEvento) {
  var evento = elEvento || window.event;
  return evento;
}


function muestraInformacion(elEvento) {
	  var evento = window.event || elEvento;
	 
	  var mensaje = "Tipo de evento: " + evento.type + "<br>" +
                    "Propiedad keyCode: " + evento.keyCode + "<br>" +
                    "Propiedad charCode: " + evento.charCode + "<br>" +
                    "Carácter pulsado: " + String.fromCharCode(evento.charCode);
 
  info.innerHTML += "<br>--------------------------------------<br>" + mensaje;
}

/**
 * Eventos de ratón
 * 
 *  Las coordenadas más sencillas son las que se refieren a la posición del puntero respecto de la ventana del navegador,
 *  que se obtienen mediante las propiedades clientX y clientY:
 * 
 * */
function muestraInformacion(elEvento) {
	  var evento = elEvento || window.event;
	  var coordenadaX = evento.clientX;
	  var coordenadaY = evento.clientY;
	//  alert("Has pulsado el ratón en la posición: " + coordenadaX + ", " + coordenadaY);
}

/**
 * 
 *  Internet Explorer no proporciona estas coordenadas de forma directa, mientras que el resto de navegadores sí que lo hacen.
 *   De esta forma,es necesario detectar si el navegador es de tipo Internet Explorer y en caso afirmativo realizar un cálculo sencillo:
 * 
 */
function detectarCordenasInternetExplorer(elEvento) {
	// Detectar si el navegador es Internet Explorer
	var ie = navigator.userAgent.toLowerCase().indexOf('msie') != -1;
	if (ie) {
		coordenadaX = evento.clientX + document.body.scrollLeft;
		coordenadaY = evento.clientY + document.body.scrollTop;
	} else {
		coordenadaX = evento.pageX;
		coordenadaY = evento.pageY;
	}
	alert("Has pulsado el ratón en la posición: " + coordenadaX + ", "+ coordenadaY + " respecto de la página web");
}

/**
 * formularios y elementos.
 * 
 */




